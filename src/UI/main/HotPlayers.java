package UI.main;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import bl_db.common.Team_map;
import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import UI.Player.SinglePlayer;
import UI.common.CreateTable_pic;
import UI.common.CreateTableforhot;
import UI.common.OftenUseMethod;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_Map;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;




public class HotPlayers extends JPanel {
	String saiji = init.defaultseason;

	String according;
	String type;
	MatchBLService mbs = init.rmi.getMatchObject();
	PlayerBLService pbs = init.rmi.getPlayerObject();
	
	Object [][] data;
	static CreateTable_pic ctfh;
	SortItem_Map map1 = new SortItem_Map();
	Team_map tm=new Team_map();
	/**
	 * Create the panel.
	 */
	public HotPlayers(String tmpsaccording,String tmptype) {
		ArrayList<SingleMatchPersonalDataVO> smpd = new ArrayList<SingleMatchPersonalDataVO>();
		ArrayList<PlayerSeasonDataVO> psdv=new ArrayList<PlayerSeasonDataVO>();
		setSize(1040, 256);
		setLayout(null);
		setOpaque(false);
		final Object[] no1=new Object[5];
		this.according=tmpsaccording;
		this.type=tmptype;
		String[] title = {"序号","肖像","姓名","位置","球队",this.type};
		if(tmpsaccording.equals("每日")){
			smpd = pbs.getTodayHotPlayer(map1.getItem(tmptype));
			System.out.println("五个人是"+smpd.get(0).getPlayerName()+smpd.get(1).getPlayerName()
					+smpd.get(2).getPlayerName()+smpd.get(3).getPlayerName()+smpd.get(4).getPlayerName());
			System.out.println(map1.getItem(tmptype));
			no1[0]=smpd.get(0).getPlayerName();
			no1[1]=tm.getFullName(smpd.get(0).getTeamName());
			no1[2]=smpd.get(0).getPlayerPosition();
			if(type.equals("总分")){
				no1[3]=smpd.get(0).getPointNum();
			}
			else if(type.equals("篮板数")){
				no1[3]=smpd.get(0).getReboundNum();
			}
			else if(type.equals("助攻数")){
				no1[3]=smpd.get(0).getAssistNum();
			}
			else if(type.equals("抢断数")){
				no1[3]=smpd.get(0).getStealNum();
			}
			else if(type.equals("盖帽数")){
				no1[3]=smpd.get(0).getBlockNum();
			}
			//System.out.println("中文名"+smpd.get(0).getPlayerName());
			no1[4]=init.pbl.getEnglishName(smpd.get(0).getPlayerName());
			//System.out.println("英文名"+no1[4]);
			data=getdata(smpd);
		}
		else if(tmpsaccording.equals("赛季")){
			psdv = pbs.getSeasonHotPlayer(init.defaultseason,map1.getItem(tmptype));
			System.out.println("五个人是"+psdv.get(0).getName()+psdv.get(1).getName()
					+psdv.get(2).getName()+psdv.get(3).getName()+psdv.get(4).getName());
			System.out.println("中文名"+psdv.get(0).getName());					
			data=getdata1(psdv);
			no1[0]=psdv.get(0).getName();			
			no1[4]=init.pbl.getEnglishName(psdv.get(0).getName());
			System.out.println("英文名"+no1[4]);
			no1[1]=tm.getFullName(psdv.get(0).getTeamName());
			no1[2]=psdv.get(0).getPosition();
			if(type.equals("得分")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getPointNum_avg()));
			}
			else if(type.equals("篮板")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getReboundNum_avg()));
			}
			else if(type.equals("助攻")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getAssistNum_avg()));
			}
			else if(type.equals("抢断")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getStealNum_avg()));
			}
			else if(type.equals("盖帽")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getBlockNum_avg()));
			}
			else if(type.equals("三分命中率")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getT_shootPercentage()));
			}
			else if(type.equals("投篮命中率")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getShootPercentage()));
			}
			else if(type.equals("罚球命中率")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getFreeThrowPercentage()));
			}
			else{
				no1[3] = -1;
			}				
			
		}
		else{
			System.out.println("进步最快"+(tmptype));
			psdv = pbs.getMost_Progress_Player((tmptype));
			System.out.println(psdv.size());		
			data=getdata1(psdv);		
			no1[0]=psdv.get(0).getName();
			no1[1]=tm.getFullName(psdv.get(0).getTeamName());
			no1[2]=psdv.get(0).getPosition();
			if(type.equals("得分")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getPointNum_avg()));
			}
			else if(type.equals("篮板")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getReboundNum_avg()));
			}
			else if(type.equals("助攻")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getAssistNum_avg()));
			}
			else if(type.equals("抢断")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getStealNum_avg()));
			}
			else if(type.equals("盖帽")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getBlockNum_avg()));
			}
			else if(type.equals("三分命中率")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getT_shootPercentage()));
			}
			else if(type.equals("投篮命中率")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getShootPercentage()));
			}
			else if(type.equals("罚球命中率")){
				no1[3]= Double.toString(OftenUseMethod.changedouble(psdv.get(0).getFreeThrowPercentage()));
			}
			else{
				no1[3] = -1;
			}		
			//System.out.println("中文名"+psdv.get(0).getName());
			no1[4]=init.pbl.getEnglishName(psdv.get(0).getName());
			//System.out.println("英文名"+no1[4]);
		}					

	
		ImageIcon No1_Player = new ImageIcon("newpic/portrait/"+no1[4]+".png");
		No1_Player.setImage(No1_Player.getImage().getScaledInstance(160, 130,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Player);		
		No1_p.setBounds(35, 39, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		No1_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					SinglePlayer spi = new SinglePlayer(no1[0].toString());
					spi.setVisible(true);
					spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);
				}
			}
		});
		
		JLabel No1_name = new JLabel((String)no1[0]);
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(220, 34, 151, 36);
		add(No1_name);
		
		JLabel No1_team = new JLabel((String)no1[1]);
		No1_team.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_team.setBounds(220, 75, 85, 15);
		add(No1_team);
		
		JLabel No1_num_positon = new JLabel((String)no1[2]);
		No1_num_positon.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_num_positon.setBounds(220, 99, 85, 15);
		add(No1_num_positon);
		
		JLabel No1_info = new JLabel(String.valueOf(no1[3]));
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 18));
		No1_info.setBounds(248, 124, 85, 50);
		add(No1_info);
		

		ctfh = new CreateTable_pic(title,data,
				381, 45,655, 205,43,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		setclwidth();
		add(ctfh);
		
		ctfh.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && ctfh.getSelectedRow() != -1) {
					String name = ctfh.getValueAt(ctfh.getSelectedRow(), 2);
					// System.out.println(name);
					
					SinglePlayer spi = new SinglePlayer(name);
					spi.setVisible(true);
					spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);

				}
			}
		});
		
		
	
		
	
	}
	

	public Object[][] getdata(ArrayList<SingleMatchPersonalDataVO> da){
		Object[][] re=new Object[4][6];
		for(int i=1;i<5;i++){
			re[i-1][0]=i+1;
			ImageIcon ddd = new ImageIcon("newpic/portrait/"+init.pbl.getEnglishName(da.get(i).getPlayerName())+".png");
			//ImageIcon ddd = new ImageIcon("newpic/portrait/"+"Aaron Brooks"+".png");
			ddd.setImage(ddd.getImage().getScaledInstance(53, 42,Image.SCALE_DEFAULT)); 					
		    re[i-1][1]=ddd;
		    re[i-1][2]=da.get(i).getPlayerName();
		    re[i-1][3]=da.get(i).getPlayerPosition();
		    re[i-1][4]=tm.getFullName(da.get(i).getTeamName());
		    if(type.equals("总分")){
				re[i-1][5]= Integer.toString(da.get(i).getPointNum());
			}
			else if(type.equals("篮板数")){
				re[i-1][5]= Integer.toString(da.get(i).getReboundNum());
			}
			else if(type.equals("助攻数")){
				re[i-1][5]= Integer.toString(da.get(i).getAssistNum());
			}
			else if(type.equals("抢断数")){
				re[i-1][5]= Integer.toString(da.get(i).getStealNum());
			}
			else if(type.equals("盖帽数")){
				re[i-1][5]= Integer.toString(da.get(i).getBlockNum());
			}
			else{
				re[i-1][5] = -1;
			}			
		
		}
		return re;
	}
	
	public Object[][] getdata1(ArrayList<PlayerSeasonDataVO> da){
		Object[][] re=new Object[4][6];
		for(int i=1;i<5;i++){		
			re[i-1][0]=i+1;
			ImageIcon ddd = new ImageIcon("newpic/portrait/"+init.pbl.getEnglishName(da.get(i).getName())+".png");
			ddd.setImage(ddd.getImage().getScaledInstance(53, 42,Image.SCALE_DEFAULT)); 					
		    re[i-1][1]=ddd;
		    re[i-1][2]=da.get(i).getName();
		    re[i-1][3]=da.get(i).getPosition();
		    re[i-1][4]=tm.getFullName(da.get(i).getTeamName());
			//对应项得分
			if(type.equals("得分")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getPointNum_avg()));
			}
			else if(type.equals("篮板")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getReboundNum_avg()));
			}
			else if(type.equals("助攻")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getAssistNum_avg()));
			}
			else if(type.equals("抢断")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getStealNum_avg()));
			}
			else if(type.equals("盖帽")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getBlockNum_avg()));
			}
			else if(type.equals("三分命中率")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
			}
			else if(type.equals("投篮命中率")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));
			}
			else if(type.equals("罚球命中率")){
				re[i-1][5]= Double.toString(OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
			}
			else{
				re[i-1][5] = -1;
			}				
		
		}
		return re;
	}
	public static void setclwidth(){
		ctfh.setNthWidth(0, 45);
		ctfh.setNthWidth(1, 50);
		ctfh.setNthWidth(2, 160);		
		ctfh.setNthWidth(3, 100);
		ctfh.setNthWidth(4, 100);
		ctfh.setNthWidth(5, 100);
	
	}
}
