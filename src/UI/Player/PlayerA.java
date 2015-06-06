package UI.Player;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import UI.common.TeamName_Map;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;

public class PlayerA extends JPanel {
	JButton lastmatches,lastyears,normal,after;
	JRadioButton isAvg;
	String seasontype;
	String tabletype;
	String isAvgorTotal;
	ImageIcon bg=new ImageIcon("newpic/labelcolor.png");
	Color newc=new Color(219,241,241);
	ArrayList<PlayerSeasonDataVO> psvo;
	ArrayList<SingleMatchPersonalDataVO> smdvo;
	CreateTable PlayerA_list;
	Object[][] PlayerA_data={{""}};
	String []PlayerA_matchtitle={"日期","对手","分钟","得分","篮板","助攻","投篮","投篮%","三分","三分%","罚球","罚球%","抢断","失误","盖帽","犯规","攻/防"};
	String []PlayerA_yeartitle={"赛季","球队","场数","先发","分钟","得分","篮板","助攻","投篮%","三分%","罚球%","抢断","失误","盖帽","犯规","攻/守"};
	String na;
	/**
	 * Create the panel.
	 */
	public PlayerA(String name) {
		this.na=name;
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		//psvo=UI.main.init.pbl.getAPlayerSeasonMatch(UI.main.init.defaultseason,UI.main.init.defaulttype,name);
		
		
		JLabel jb1=new JLabel(new ImageIcon("newpic/portrait/"+name+".png"));
		jb1.setBounds(10, 10, 230, 185);
		jb1.setOpaque(false);
		add(jb1);
		bg.setImage(bg.getImage().getScaledInstance(230, 185,Image.SCALE_DEFAULT));
		JLabel jb2=new JLabel(bg);
		jb2.setBounds(10, 10, 230, 185);
		jb2.setOpaque(false);
		add(jb2);
		
		
		JLabel pname = new JLabel("nameBLABLAB");
		pname.setFont(new Font("华文细黑", Font.BOLD, 25));
		pname.setBounds(272, 10, 206, 47);
		pname.setForeground(UI.main.init.syspurple);
		add(pname);
		
		JLabel lblLocation = new JLabel("pposition/pratiton");
		lblLocation.setFont(new Font("华文细黑", Font.BOLD, 14));
		lblLocation.setBounds(272, 50, 176, 31);
		lblLocation.setForeground(UI.main.init.syspurple);
		add(lblLocation);
		
		JLabel pnum = new JLabel("00");
		pnum.setFont(new Font("微软雅黑", Font.BOLD, 60));
		pnum.setBounds(266, 91, 84, 80);
		pnum.setForeground(UI.main.init.syspurpleblue);
		add(pnum);
		
		JLabel label = new JLabel("\u8EAB\u9AD8\uFF1A2.10");
		label.setForeground(UI.main.init.syspurpleblue);
		label.setFont(new Font("华文细黑", Font.BOLD, 12));
		label.setBounds(360, 90, 117, 20);
		add(label);
		
		JLabel label_1 = new JLabel("\u4F53\u91CD\uFF1A108");
		label_1.setForeground(new Color(102, 90, 197));
		label_1.setFont(new Font("华文细黑", Font.BOLD, 12));
		label_1.setBounds(360, 110, 117, 20);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u751F\u65E5\uFF1A1995.12.12");
		label_2.setForeground(new Color(102, 90, 197));
		label_2.setFont(new Font("华文细黑", Font.BOLD, 12));
		label_2.setBounds(360, 130, 117, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A23");
		label_3.setForeground(new Color(102, 90, 197));
		label_3.setFont(new Font("华文细黑", Font.BOLD, 12));
		label_3.setBounds(360, 150, 117, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u7403\u9F84\uFF1A2");
		label_4.setForeground(new Color(102, 90, 197));
		label_4.setFont(new Font("华文细黑", Font.BOLD, 12));
		label_4.setBounds(515, 90, 117, 20);
		add(label_4);
		
		JLabel lblxxxx = new JLabel("\u6BD5\u4E1A\u9662\u6821\uFF1AXXXX");
		lblxxxx.setForeground(new Color(102, 90, 197));
		lblxxxx.setFont(new Font("华文细黑", Font.BOLD, 12));
		lblxxxx.setBounds(515, 110, 145, 20);
		add(lblxxxx);
		
		//ImageIcon pteam = new ImageIcon("newpic/TEAMPNG"+psvo.getTeamName()+".png");
		ImageIcon pteam = new ImageIcon("newpic/TEAMPNG/"+"ATL"+".png");
		pteam.setImage(pteam.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		JLabel lblNewLabel = new JLabel(pteam);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBounds(623, 10, 120,120);
		add(lblNewLabel);
		
		bg.setImage(bg.getImage().getScaledInstance(510, 185,Image.SCALE_DEFAULT));
		JLabel jb3=new JLabel(bg);
		jb3.setBounds(251, 10, 510, 185);		
		add(jb3);
		jb3.setOpaque(false);
	
		
		lastmatches=new JButton(new ImageIcon("newpic/近五场浮.png"));
		lastmatches.setLocation(40, 219);
		lastmatches.setSize(100, 30);
		add(lastmatches);
		lastmatches.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lastmatches.setIcon(new ImageIcon("newpic/近五场浮.png"));
				lastyears.setIcon(new ImageIcon("newpic/近几年.png"));
				tabletype="近五场";
				isAvg.setSelected(true);
				isAvg.setEnabled(false);
				smdvo=UI.main.init.pbl.getLastFiveMatchData(na, seasontype);
				PlayerA_data=getmatch(smdvo);
				PlayerA_list.setOpaque(false);
				//PlayerA_list.setOpa();
				PlayerA_list.FitTableColumns(PlayerA_list.getTable());
				PlayerA_list.getRoll().getViewport().setOpaque(false);
			}			
		});
		
		lastyears = new JButton(new ImageIcon("newpic/近几年.png"));
		lastyears.setBounds(140, 219, 100, 30);
		add(lastyears);
		lastyears.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lastmatches.setIcon(new ImageIcon("newpic/近五场.png"));
				lastyears.setIcon(new ImageIcon("newpic/近几年浮.png"));
				tabletype="近几年";
				isAvg.setSelected(true);
				isAvg.setEnabled(true);
				
				psvo=UI.main.init.pbl.getAPlayerSaeasonData(na, seasontype);				
				PlayerA_data=getyearavg(psvo);
				PlayerA_list = new CreateTable(PlayerA_matchtitle, PlayerA_data, 10, 260,1025, 320, 25,
						new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
				add(PlayerA_list);
				PlayerA_list.setOpaque(false);
				//PlayerA_list.setOpa();
				PlayerA_list.FitTableColumns(PlayerA_list.getTable());
				PlayerA_list.getRoll().getViewport().setOpaque(false);
			}			
		});
		
		normal=new JButton(new ImageIcon("newpic/常规赛浮.png"));
		normal.setLocation(288, 219);
		normal.setSize(55, 30);
		add(normal);
		normal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/常规赛浮.png"));
				after.setIcon(new ImageIcon("newpic/季后赛.png"));
				seasontype="常规赛";
			}			
		});
		after=new JButton(new ImageIcon("newpic/季后赛.png"));
		after.setLocation(343, 219);
		after.setSize(55, 30);
		add(after);
		after.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/常规赛.png"));
				after.setIcon(new ImageIcon("newpic/季后赛浮.png"));
				seasontype="季后赛";
			}			
		});
		
		isAvg = new JRadioButton("\u573A\u5747\u6570\u636E");
		isAvg.setSelected(true);
		isAvg.setFont(new Font("华文细黑", Font.PLAIN, 15));
		isAvg.setBounds(461, 221, 100, 23);
		isAvg.setEnabled(false);
		add(isAvg);
		isAvg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isAvg.isSelected()){
					isAvgorTotal="avg";	
					psvo=UI.main.init.pbl.getAPlayerSaeasonData(na, seasontype);				
					PlayerA_data=getyearavg(psvo);
					PlayerA_list = new CreateTable(PlayerA_matchtitle, PlayerA_data, 10, 260,1025, 320, 25,
							new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
					add(PlayerA_list);
					PlayerA_list.setOpaque(false);
					//PlayerA_list.setOpa();
					PlayerA_list.FitTableColumns(PlayerA_list.getTable());
					PlayerA_list.getRoll().getViewport().setOpaque(false);
				}else{
					isAvgorTotal="total";	
					psvo=UI.main.init.pbl.getAPlayerSaeasonData(na, seasontype);				
					PlayerA_data=getyeartol(psvo);
					PlayerA_list = new CreateTable(PlayerA_matchtitle, PlayerA_data, 10, 260,1025, 320, 25,
							new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
					add(PlayerA_list);
					PlayerA_list.setOpaque(false);
					//PlayerA_list.setOpa();
					PlayerA_list.FitTableColumns(PlayerA_list.getTable());
					PlayerA_list.getRoll().getViewport().setOpaque(false);
				}
			}
			
		});
		
		smdvo=UI.main.init.pbl.getLastFiveMatchData(name, seasontype);
		PlayerA_data=getmatch(smdvo);
		PlayerA_list = new CreateTable(PlayerA_matchtitle, PlayerA_data, 10, 260,1025, 320, 25,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(PlayerA_list);
		PlayerA_list.setOpaque(false);
		//PlayerA_list.setOpa();
		PlayerA_list.FitTableColumns(PlayerA_list.getTable());
		PlayerA_list.getRoll().getViewport().setOpaque(false);
		
		JLabel menubg = new JLabel();
		menubg.setBackground(newc);
		menubg.setBounds(10, 207, 751, 61);
		add(menubg);
		menubg.setOpaque(true);
	
		
		ImageIcon image1 = new ImageIcon("newpic/action/C_"+name+".png");
		image1.setImage(image1.getImage().getScaledInstance(484, 770,Image.SCALE_DEFAULT));
		bg.setImage(bg.getImage().getScaledInstance( 510, 185,Image.SCALE_DEFAULT));
		JLabel jb=new JLabel(image1);
		jb.setBounds(690,-150,440, 700);
		jb.setOpaque(false);
		add(jb);
		
 
	}
	
	public Object[][] getmatch(ArrayList<SingleMatchPersonalDataVO> da) {
		//System.out.println(da==null);
		if (da == null) {
			Object[][] re = new Object[1][17];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			re[0][11] = "";
			re[0][12] = "";
			re[0][13] = "";
			re[0][14] = "";
			re[0][15] = "";
			re[0][16] = "";
			return re;
		} else {
			Object[][] re = new Object[da.size()][17];	
			TeamName_Map mm=new TeamName_Map();
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getDate();
				re[i][1] = mm.getFullName(da.get(i).getTeamName());
				re[i][2] = OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][3] = da.get(i).getPointNum();
				re[i][4]=da.get(i).getReboundNum();
				re[i][5] = da.get(i).getAssistNum();
				re[i][6] = String.valueOf(da.get(i).getFieldGoal())+"/"+String.valueOf(da.get(i).getShootNum());		
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][8] = String.valueOf(da.get(i).getT_fieldGoal())+"/"+String.valueOf(da.get(i).getT_shootNum());
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getThreePointPercentage());
				re[i][10] = String.valueOf(da.get(i).getFreeThrowGoalNum())+"/"+String.valueOf(da.get(i).getFreeThrowNum());	
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());				
				re[i][12] = da.get(i).getStealNum();
				re[i][13] = da.get(i).getTurnoverNum();
				re[i][14] = da.get(i).getBlockNum();
				re[i][15] = da.get(i).getFoulNum();				
				re[i][16] = String.valueOf(da.get(i).getO_ReboundNum())+"/"+String.valueOf( da.get(i).getD_ReboundNum());				
			}
			return re;
		}

	}
	public Object[][] getyearavg(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da==null);
		if (da == null) {
			Object[][] re = new Object[1][16];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			re[0][11] = "";
			re[0][12] = "";
			re[0][13] = "";
			re[0][14] = "";
			re[0][15] = "";
			return re;
		} else {			
			Object[][] re = new Object[da.size()][16];	
			TeamName_Map mm=new TeamName_Map();
			for (int i = 0; i < da.size(); i++) {
				re[i][0]= da.get(i).getSeason();
				re[i][1] = mm.getFullName(da.get(i).getTeamName());
				re[i][2] = da.get(i).getMatchNum();
				re[i][3] = da.get(i).getStartingNum();
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getTime_avg());
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getPointNum_avg());				
				re[i][6] = OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][8] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));				
				re[i][9] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][10] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][12] = OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][13] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][14] = OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());
				re[i][15] = String.valueOf(da.get(i).getO_ReboundNum_avg())+"/"+String.valueOf( da.get(i).getD_ReboundNum_avg());									
			}
			return re;
		}

	}
	public Object[][] getyeartol(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da==null);
		if (da == null) {
			Object[][] re = new Object[1][16];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			re[0][11] = "";
			re[0][12] = "";
			re[0][13] = "";
			re[0][14] = "";
			re[0][15] = "";
			return re;
		} else {			
			Object[][] re = new Object[da.size()][16];	
			TeamName_Map mm=new TeamName_Map();
			for (int i = 0; i < da.size(); i++) {
				re[i][0] =da.get(i).getSeason();
				re[i][1] = mm.getFullName(da.get(i).getTeamName());
				re[i][2] = da.get(i).getMatchNum();
				re[i][3] = da.get(i).getStartingNum();
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getPointNum());				
				re[i][6] = OftenUseMethod.changedouble(da.get(i).getReboundNum());
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getAssistNum());
				re[i][8] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));				
				re[i][9] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][10] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getStealNum());
				re[i][12] = OftenUseMethod.changedouble(da.get(i).getBlockNum());
				re[i][13] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum());
				re[i][14] = OftenUseMethod.changedouble(da.get(i).getFoulNum());
				re[i][15] = String.valueOf(da.get(i).getO_ReboundNum())+"/"+String.valueOf( da.get(i).getD_ReboundNum());							
			}
			return re;
		}

	}
	
}
