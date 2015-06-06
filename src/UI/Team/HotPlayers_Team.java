package UI.Team;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import businessService.blservice.TeamBLService;
import UI.common.CreateTable_pic;
import UI.common.CreateTableforhot;
import UI.common.OftenUseMethod;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_Map;
import UI.common.TeamName_Map;
import UI.main.init;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class HotPlayers_Team extends JPanel {

	/**
	 * Create the panel.
	 */
	String saiji = init.defaultseason;

	ArrayList<PlayerSeasonDataVO> psdv;
	String teamna;
	String type;
	//RMIObject rmi = new RMIObject();
	MatchBLService mbs = init.rmi.getMatchObject();
	TeamBLService tbs = init.rmi.getTeamObject();
	Object[] no1=new Object[4];
	Object [][] data;
	CreateTable_pic ctfh;
	SortItem_Map map1 = new SortItem_Map();
	TeamName_Map map3 = new TeamName_Map();	
	PlayerPosition_Map map4 = new PlayerPosition_Map();	

	/**
	 * Create the panel.
	 */
	public HotPlayers_Team(String teamname,String tmptype) {
		
		this.teamna=teamname;
		this.type=tmptype;
		String[] title = {"序号","肖像","姓名","位置","球队",this.type};

	
			psdv = tbs.getKingPlayerForATeam(init.defaultseason,map1.getItem(tmptype));
			data=getdata1(psdv);
			no1[0]=psdv.get(0).getName();
			no1[1]=map3.getFullName(psdv.get(0).getTeamName());
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
		
		
		setLayout(null);
		setOpaque(false);
		setSize(1040,220);
		
		ImageIcon No1_Player = new ImageIcon("newpic/portrait/"+no1[0]+".png");
		No1_Player.setImage(No1_Player.getImage().getScaledInstance(160, 130,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Player);		
		No1_p.setBounds(35, 39, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		No1_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					
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
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 28));
		No1_info.setBounds(248, 124, 85, 50);
		add(No1_info);
		

		ctfh = new CreateTable_pic(title,data,
				381, 0,655, 205,43,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 14));
		add(ctfh);
		
		ctfh.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && ctfh.getSelectedRow() != -1) {
					

				}
			}
		});
	}
	

	public Object[][] getdata(ArrayList<SingleMatchPersonalDataVO> da){
		Object[][] re=new Object[4][6];
		for(int i=1;i<5;i++){
			re[i-1][0]=i+1;
			ImageIcon ddd = new ImageIcon("newpic/portrait/"+da.get(i).getPlayerName()+".png");
			ddd.setImage(ddd.getImage().getScaledInstance(53, 42,Image.SCALE_DEFAULT)); 					
		    re[i-1][1]=ddd;
		    re[i-1][2]=da.get(i).getPlayerName();
		    re[i-1][3]=da.get(i).getPlayerPosition();
		    re[i-1][4]=map3.getFullName(da.get(i).getTeamName());
		    if(type.equals("得分总")){
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
		if(da==null){
			Object re[][]=new Object[4][6];
			return re;
		}else{
		Object[][] re=new Object[4][6];
		for(int i=1;i<5;i++){		
			re[i-1][0]=i+1;
			ImageIcon ddd = new ImageIcon("newpic/portrait/"+da.get(i).getName()+".png");
			ddd.setImage(ddd.getImage().getScaledInstance(53, 42,Image.SCALE_DEFAULT)); 					
		    re[i-1][1]=ddd;
		    re[i-1][2]=da.get(i).getName();
		    re[i-1][3]=da.get(i).getPosition();
		    re[i-1][4]=map3.getFullName(da.get(i).getTeamName());
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
	}
}

