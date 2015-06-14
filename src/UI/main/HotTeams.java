package UI.main;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import businessService.blservice.TeamBLService;
import UI.Team.SingleTeam;
import UI.blObject.RMIObject;
import UI.common.CreateTable_pic;
import UI.common.CreateTableforhot;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_ForHotTeam;
import UI.common.SortItem_Map;
import VO.SingleMatchPersonalDataVO;
import VO.TeamSeasonDataVO;


public class HotTeams extends JPanel {
	//SortItem_Map map1 = new SortItem_Map();
	SortItem_ForHotTeam map1 = new SortItem_ForHotTeam();
	PlayerPosition_Map map4 = new PlayerPosition_Map();	
	Object [][] data;
	String type;
	String according;
	ArrayList<TeamSeasonDataVO> tsdv;
	CreateTable_pic ctfh;
	String saiji = init.defaultseason;
	TeamBLService tbs = init.rmi.getTeamObject();
	/**
	 * Create the panel.
	 */
	public HotTeams(String tmpsaccording,String tmptype) {{
		this.according=tmpsaccording;
		this.type=tmptype;
		setLayout(null);
		setOpaque(false);
		setSize(1040, 257);
		
		System.out.println("type"+map1.getItem(tmptype));
		tsdv = tbs.getHotTeam(saiji,map1.getItem(tmptype));
		System.out.println(tsdv.size());
		data=getdata(tsdv);
		
		String[] title = {"序号","LOGO","球队","分区","建立时间","缩写",tmptype};
		ctfh = new CreateTable_pic(title,data,
				381,35,655, 205,43,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(ctfh);
		
		ctfh.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && ctfh.getSelectedRow() != -1) {
					String name = ctfh.getValueAt(ctfh.getSelectedRow(), 2);
					//System.out.println(name);
					
					SingleTeam spi = new SingleTeam(name);
					spi.setVisible(true);
					spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);

				}
			}
		});
		//System.out.println("newpic/TEAMPNG/"+tsdv.get(0).getFullName()+".png");
		ImageIcon No1_Team = new ImageIcon("newpic/TEAMPNG/"+tsdv.get(0).getFullName()+".png");
		No1_Team.setImage(No1_Team.getImage().getScaledInstance(158, 158,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Team);		
		No1_p.setBounds(35,45, 180, 158);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		No1_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					

				}
			}
		});
		JLabel No1_name = new JLabel((String)tsdv.get(0).getTeamName());
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(220, 32, 153, 36);
		add(No1_name);
		
		JLabel No1_part = new JLabel((String)tsdv.get(0).getPartition());
		No1_part.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_part.setBounds(220, 73, 85, 15);
		add(No1_part);
		
		JLabel No1_time = new JLabel((String)tsdv.get(0).getInfo().getFormedTime());
		No1_time.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_time.setBounds(220, 97, 85, 15);
		add(No1_time);
		
		String a="";
		if(type.equals("得分")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getPointNum_avg()));
		}
		else if(type.equals("篮板")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getReboundNum_avg()));
		}
		else if(type.equals("助攻")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getAssistNum_avg()));
		}
		else if(type.equals("抢断")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getStealNum_avg()));
		}
		else if(type.equals("盖帽")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getBlockNum_avg()));
		}
		else if(type.equals("三分命中率")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getT_shootPercentage()));
		}
		else if(type.equals("投篮命中率")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getShootPercentage()));
		}
		else if(type.equals("罚球命中率")){
			a= Double.toString(OftenUseMethod.changedouble(tsdv.get(0).getFreeThrowPercentage()));
		}
		JLabel No1_info = new JLabel(a);
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 18));
		No1_info.setBounds(248, 122, 85, 50);
		add(No1_info);
		
		
		
	}

	}
	
	
	public Object[][] getdata(ArrayList<TeamSeasonDataVO> da){
		Object[][] re=new Object[4][7];
		for(int i=1;i<5;i++){		
			re[i-1][0]=i+1;
			ImageIcon ddd = new ImageIcon("newpic/TEAMPNG/"+da.get(i).getFullName()+".png");
			ddd.setImage(ddd.getImage().getScaledInstance(53, 42,Image.SCALE_DEFAULT)); 					
		    re[i-1][1]=ddd;
		    re[i-1][2]=(da.get(i).getTeamName());
		    re[i-1][3]=da.get(i).getPartition();
		    re[i-1][4]=da.get(i).getInfo().getFormedTime();
		    re[i-1][5]=da.get(i).getFullName();
			//对应项得分
		    
			if(type.equals("得分")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getPointNum_avg()));
			}
			else if(type.equals("篮板")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getReboundNum_avg()));
			}
			else if(type.equals("助攻")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getAssistNum_avg()));
			}
			else if(type.equals("抢断")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getStealNum_avg()));
			}
			else if(type.equals("盖帽")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getBlockNum_avg()));
			}
			else if(type.equals("三分命中率")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
			}
			else if(type.equals("投篮命中率")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));
			}
			else if(type.equals("罚球命中率")){
				re[i-1][6]= Double.toString(OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
			}
			else{
				re[i-1][6] = -1;
			}				
		
		}
		return re;
	}
}
	

