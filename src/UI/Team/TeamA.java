package UI.Team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableCellRenderer;

import bl_db.common.Team_map;
import UI.Match.SingleMatch;
import UI.Player.SinglePlayer;
import UI.common.CreateTable;
import UI.common.CreateTable_M;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.main.init;
import VO.SingleMatchPersonalDataVO;
import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class TeamA extends JPanel {
	
	ImageIcon bg=new ImageIcon("newpic/labelcolor.png");
	Color newc=new Color(219,241,241);
	CreateTable_M analysis;
	CreateTable TeamA_list;
	ImageIcon tpic;
	JLabel jb1,pname,label,lblabalabala,pnumwin,pnumlose,time,label_1,label_2,ground,coach;
	Team_map tm=new Team_map();
	String[]anatitle={"","场均得分","场均助攻","场均篮板"};
	Object[][]anadata;
	String[] TeamA_matchtitle={"日期","对手","得分","篮板","助攻","投篮","投篮%","三分","三分%","罚球","罚球%","抢断","失误","盖帽","犯规","攻/防"};
	String []TeamA_yeartitle={"赛季","场数","得分","篮板","助攻","投篮%","三分%","罚球%","抢断","失误","盖帽","犯规","攻/守"};
	Object[][]TeamA_data;
	String[] newti;
	ArrayList<TeamMatchVO> smdvo=null;
	ArrayList<TeamSeasonDataVO> tsdvo=null;
	JButton lastmatches,lastyears,process,normal,after;
	JRadioButton isAvg;
	String seasontype="常规赛";
	String tabletype="近五场";
	//String isAvgorTotal="";
	String na;
	TeamInfoVO tivo;
	TeamSeasonDataVO tsd;
	
	public TeamA(String name) {
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		this.na=name;
		
		tpic=new ImageIcon("newpic/TEAMPNG/"+name+".png");
		tpic.setImage(tpic.getImage().getScaledInstance( 200, 200,Image.SCALE_DEFAULT));
		jb1=new JLabel(tpic);
		jb1.setBounds(10, 10, 200, 200);
		jb1.setOpaque(false);
		add(jb1);
		
		bg.setImage(bg.getImage().getScaledInstance( 200, 200,Image.SCALE_DEFAULT));
		JLabel jb2=new JLabel(bg);
		jb2.setBounds(10, 10,  200, 200);
		jb2.setOpaque(false);
		add(jb2);
		
		
		pname = new JLabel("nameBLABLAB");
		pname.setFont(new Font("华文细黑", Font.BOLD, 25));
		pname.setBounds(232, 22, 206, 47);
		pname.setForeground(UI.main.init.syspurple);
		add(pname);
		
		label = new JLabel("\u8054\u76DF\uFF1A\u4E1C\u90E8\u5206\u533A\uFF1B\u6392\u540D#14");
		label.setForeground(UI.main.init.syspurpleblue);
		label.setFont(new Font("华文细黑", Font.BOLD, 12));
		label.setBounds(232, 67, 185, 20);
		add(label);
		
		time = new JLabel("\u5EFA\u961F\u65F6\u95F4\uFF1A1920-02-20");
		time.setForeground(new Color(102, 90, 197));
		time.setFont(new Font("华文细黑", Font.BOLD, 12));
		time.setBounds(232, 92, 185, 20);
		add(time);
		
		ground = new JLabel("zhuguan");
		ground.setForeground(new Color(102, 90, 197));
		ground.setFont(new Font("华文细黑", Font.BOLD, 12));
		ground.setBounds(408, 67, 185, 20);
		add(ground);
		
		coach = new JLabel("coach");
		coach.setForeground(new Color(102, 90, 197));
		coach.setFont(new Font("华文细黑", Font.BOLD, 12));
		coach.setBounds(408, 92, 185, 20);
		add(coach);
		
		lblabalabala = new JLabel("\u4F4D\u7F6E\uFF1AAbalabala");
		lblabalabala.setForeground(new Color(102, 90, 197));
		lblabalabala.setFont(new Font("华文细黑", Font.BOLD, 12));
		lblabalabala.setBounds(232, 115, 185, 20);
		add(lblabalabala);
		
		pnumwin = new JLabel("00");
		pnumwin.setFont(new Font("微软雅黑", Font.BOLD, 40));
		pnumwin.setBounds(390, 112, 84, 80);
		pnumwin.setForeground(UI.main.init.syspurpleblue);
		add(pnumwin);
		
		pnumlose = new JLabel("-00");
		pnumlose.setFont(new Font("微软雅黑", Font.BOLD, 40));
		pnumlose.setBounds(478, 112, 84, 80);
		pnumlose.setForeground(UI.main.init.syspurpleblue);
		add(pnumlose);
		
		label_1 = new JLabel("\u80DC");
		label_1.setForeground(new Color(102, 90, 197));
		label_1.setFont(new Font("华文细黑", Font.BOLD, 16));
		label_1.setBounds(448, 151, 22, 20);
		add(label_1);
		label_2 = new JLabel("\u8D1F");
		label_2.setForeground(new Color(102, 90, 197));
		label_2.setFont(new Font("华文细黑", Font.BOLD, 16));
		label_2.setBounds(551, 151, 22, 20);
		add(label_2);
		
		anadata=getanadata(name);
	//	analysis=new CreateTable_M(anatitle, anadata, 640, 20, 380, 160,25,
	//			new Font("黑体", 0, 15), new Font("微软雅黑", 0, 13));
	//	analysis.getTable().setRowHeight(2, 10);
	//	analysis.setNthWidth(0, 110);
	//	analysis.setNthWidth(1, 90);
	//	analysis.setNthWidth(2, 90);
	//	analysis.setNthWidth(3, 90);
	//	analysis.setAllWhite();
	//	add(analysis);
      
		TeamA_data=getLastFiveMatch(smdvo);
		TeamA_list = new CreateTable(TeamA_matchtitle, TeamA_data, 10, 250,1025, 330, 25,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(TeamA_list);
		TeamA_list.setOpaque(false);
		//PlayerA_list.setOpa();
		TeamA_list.FitTableColumns(TeamA_list.getTable());
		TeamA_list.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && TeamA_list.getSelectedRow() != -1) {
					if(tabletype.equals("近五场")){
						String date = TeamA_list.getValueAt(TeamA_list.getSelectedRow(), 0);	
						String name=TeamA_list.getValueAt(TeamA_list.getSelectedRow(), 1);
						SingleMatch spi = new SingleMatch((name),date);
						spi.setVisible(true);
						spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);
					}else if(tabletype.equals("赛程")){
						String date = TeamA_list.getValueAt(TeamA_list.getSelectedRow(), 0);
						String name=TeamA_list.getValueAt(TeamA_list.getSelectedRow(), 1);
						SingleMatch spi = new SingleMatch((name),date);
						spi.setVisible(true);
						spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);
					}else{
						
					}
				}
				
			}
		});
		TeamA_list.getRoll().getViewport().setOpaque(false);
		
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
				process.setIcon(new ImageIcon("newpic/按钮赛程.png"));
				normal.setEnabled(false);
				after.setEnabled(false);
				normal.setIcon(new ImageIcon("newpic/常规赛.png"));
				after.setIcon(new ImageIcon("newpic/季后赛.png"));
				tabletype="近五场";
				isAvg.setSelected(true);
				isAvg.setEnabled(false);
				/*
				smdvo=UI.main.init.tbl.getLastFiveMatchData(na);
				TeamA_data=getLastFiveMatch(smdvo);
				TeamA_list.setOpaque(false);
				//PlayerA_list.setOpa();
				TeamA_list.FitTableColumns(TeamA_list.getTable());
				TeamA_list.getRoll().getViewport().setOpaque(false);*/
				updateTeamA(na);
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
				process.setIcon(new ImageIcon("newpic/按钮赛程.png"));
				tabletype="近几年";
				normal.setEnabled(true);
				after.setEnabled(true);
				normal.setIcon(new ImageIcon("newpic/常规赛浮.png"));
				after.setIcon(new ImageIcon("newpic/季后赛.png"));
				isAvg.setSelected(true);
				isAvg.setEnabled(true);
				/*
				tsdvo=UI.main.init.tbl.getATeamSeasonData(na, seasontype);				
				TeamA_data=getyearavg(tsdvo);
				TeamA_list = new CreateTable(TeamA_matchtitle, TeamA_data, 10, 260,1025, 320, 25,
						new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
				add(TeamA_list);
				TeamA_list.setOpaque(false);
				//PlayerA_list.setOpa();
				TeamA_list.FitTableColumns(TeamA_list.getTable());
				TeamA_list.getRoll().getViewport().setOpaque(false);*/
				updateTeamA(na);
			}			
		});
		process=new JButton(new ImageIcon("newpic/按钮赛程.png"));
		process.setBounds(240, 219, 48, 30);
		add(process);
		process.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-gsenerated method stub
				lastmatches.setIcon(new ImageIcon("newpic/近五场.png"));
				lastyears.setIcon(new ImageIcon("newpic/近几年.png"));
				process.setIcon(new ImageIcon("newpic/按钮赛程浮.png"));
				tabletype="赛程";
				after.setEnabled(false);
				normal.setEnabled(false);
				normal.setIcon(new ImageIcon("newpic/常规赛.png"));
				after.setIcon(new ImageIcon("newpic/季后赛.png"));
				isAvg.setSelected(true);
				isAvg.setEnabled(false);
				/*
				
				smdvo=UI.main.init.tbl. getASeasonMatchData(na, init.defaultseason);
				TeamA_data=getLastFiveMatch(smdvo);
				TeamA_list.setOpaque(false);
				//PlayerA_list.setOpa();
				TeamA_list.FitTableColumns(TeamA_list.getTable());
				TeamA_list.getRoll().getViewport().setOpaque(false);*/
				updateTeamA(na);
			}			
		});
		
		normal=new JButton(new ImageIcon("newpic/常规赛浮.png"));
		normal.setLocation(340, 219);
		normal.setSize(55, 30);
		add(normal);
		normal.setEnabled(false);
		normal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/常规赛浮.png"));
				after.setIcon(new ImageIcon("newpic/季后赛.png"));
				seasontype="常规赛";
				updateTeamA(na);
			}			
		});
		after=new JButton(new ImageIcon("newpic/季后赛.png"));
		after.setLocation(395, 219);
		after.setSize(55, 30);
		add(after);
		after.setEnabled(false);
		after.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/常规赛.png"));
				after.setIcon(new ImageIcon("newpic/季后赛浮.png"));
				seasontype="季后赛";
				updateTeamA(na);
			}			
		});
		
		isAvg = new JRadioButton("\u573A\u5747\u6570\u636E");
		isAvg.setSelected(true);
		isAvg.setFont(new Font("华文细黑", Font.PLAIN, 15));
		isAvg.setBounds(513, 221, 100, 23);
		isAvg.setEnabled(false);
		add(isAvg);
		isAvg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				updateTeamA(na);
				// TODO Auto-generated method stub
				/*
				if(isAvg.isSelected()){
					isAvgorTotal="avg";	
					//tsdvo=UI.main.init.pbl.getAPlayerSaeasonData(na, seasontype);				
					TeamA_data=getyearavg(tsdvo);
					TeamA_list = new CreateTable(TeamA_matchtitle, TeamA_data, 10, 260,1025, 320, 25,
							new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
					add(TeamA_list);
					TeamA_list.setOpaque(false);
					//PlayerA_list.setOpa();
					TeamA_list.FitTableColumns(TeamA_list.getTable());
					TeamA_list.getRoll().getViewport().setOpaque(false);
				}else{
					isAvgorTotal="total";	
					//tsdvo=UI.main.init.pbl.getAPlayerSaeasonData(na, seasontype);				
					TeamA_data=getyeartol(tsdvo);
					TeamA_list = new CreateTable(TeamA_matchtitle, TeamA_data, 10, 260,1025, 320, 25,
							new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
					add(TeamA_list);
					TeamA_list.setOpaque(false);
					//PlayerA_list.setOpa();
					TeamA_list.FitTableColumns(TeamA_list.getTable());
					TeamA_list.getRoll().getViewport().setOpaque(false);
				}*/
			}
			
		});
		
		JLabel menubg = new JLabel();
		menubg.setBackground(newc);
		menubg.setBounds(220, 10, 393, 200);
		add(menubg);
		menubg.setOpaque(true);
		
		
		ImageIcon bg1=bg;
		bg1.setImage(bg1.getImage().getScaledInstance(  409, 200,Image.SCALE_DEFAULT));
		JLabel menubg_1 = new JLabel(bg1);
		menubg_1.setBounds(623, 10, 409, 200);
		add(menubg_1);
		menubg.setOpaque(true);
		
		updateTeamA(na);
	
	}
	
	
	public Object[][] getanadata(String teanname){
		Object[][] da=new Object[5][4];		
		da[0][0]="  本队排名";
		da[0][1]="  3th";
		da[0][2]="  3th";
		da[0][3]="  3th";
		da[1][0]="  对手排名";
		da[1][1]="  10th";
		da[1][2]="  10th";
		da[1][3]="  10th";
		da[2][0]="";
		da[2][1]="";
		da[2][2]="";
		da[2][3]="";
		da[3][0]="  本队数据";
		da[3][1]="  12";
		da[3][2]="  12";
		da[3][3]="  12";
		da[4][0]="  对手数据";
		da[4][1]="  30";
		da[4][2]="  30";
		da[4][3]="  30";
		return da;
	}
	
	
	public Object[][] getLastFiveMatch(ArrayList<TeamMatchVO> da){
		if(da==null){
			Object[][] re=new Object[1][16];
			re[0][0]="";
			re[0][1]="";
			re[0][2]="";
			re[0][3]="";			
			re[0][4]="";
			re[0][5]="";
			re[0][6]="";
			re[0][7]="";
			re[0][8]="";
			re[0][9]="";
			re[0][10]="";
			re[0][11]="";			
			re[0][12]="";
			re[0][13]="";
			re[0][14]="";
			re[0][15]="";
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][16];
			for(int i=0;i<da.size();i++){						
				re[i][0]=da.get(i).getDate();
				re[i][1]=da.get(i).getOpp_team();
				re[i][2]=da.get(i).getPointNum();
				re[i][3]=da.get(i).getReboundNum();
				re[i][4]=da.get(i).getAssistNum();	
				re[i][5]=String.valueOf(da.get(i).getFieldGoal())+"/"+String.valueOf(da.get(i).getShootNum());				
				re[i][6]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][7]=String.valueOf(da.get(i).getT_fieldGoal())+"/"+String.valueOf(da.get(i).getT_shootNum());
				re[i][8]=OftenUseMethod.changedouble(da.get(i).getThreePointPercentage());			
				re[i][9]=String.valueOf(da.get(i).getFreeThrowGoalNum())+"/"+String.valueOf(da.get(i).getFreeThrowNum());			
				re[i][10]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());
				re[i][11]=da.get(i).getStealNum();
				re[i][12]=da.get(i).getFoulNum();
				re[i][13]=da.get(i).getBlockNum();
				re[i][14]=da.get(i).getTurnoverNum();																
				re[i][15]=String.valueOf(da.get(i).getO_ReboundNum())+"/"+String.valueOf(da.get(i).getD_ReboundNum());											
			}		
			return re;		
		}
	}
	public Object[][] getyearavg(ArrayList<TeamSeasonDataVO> da) {
		//System.out.println(da==null);
		if (da == null) {
			Object[][] re = new Object[1][13];
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
			return re;
		} else {			
			Object[][] re = new Object[da.size()][13];	

			for (int i = 0; i < da.size(); i++) {
				
				re[i][0]= da.get(i).getSeason()+"赛季";
				re[i][1] = da.get(i).getMatchNum();
				re[i][2] = OftenUseMethod.changedouble(da.get(i).getPointNum_avg());				
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][5] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));				
				re[i][6] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][7] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][8] = OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][9] = OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][10] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());
				re[i][12] =  OftenUseMethod.changedouble(da.get(i).getO_ReboundNum_avg())+"/"+ OftenUseMethod.changedouble( da.get(i).getD_ReboundNum_avg());									
			}
			return re;
		}

	}
	public Object[][] getyeartol(ArrayList<TeamSeasonDataVO> da) {
		//System.out.println(da==null);
		if (da == null) {
			Object[][] re = new Object[1][13];
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
			return re;
		} else {			
			Object[][] re = new Object[da.size()][13];	

			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getSeason()+"赛季";
				re[i][1] = da.get(i).getMatchNum();
				re[i][2] = OftenUseMethod.changedouble(da.get(i).getPointNum());				
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getReboundNum());
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getAssistNum());
				re[i][5] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));				
				re[i][6] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][7] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][8] = OftenUseMethod.changedouble(da.get(i).getStealNum());
				re[i][9] = OftenUseMethod.changedouble(da.get(i).getBlockNum());
				re[i][10] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum());
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getFoulNum());
				re[i][12] = String.valueOf(da.get(i).getO_ReboundNum())+"/"+String.valueOf( da.get(i).getD_ReboundNum());							
			}
			return re;
		}

	}
	public void updateTeamA(String name){
		System.out.println(name);
		tivo=init.tbl.getATeamInfo(init.defaultseason, name);
		tsd=init.tbl.getATeamData(init.defaultseason, name);
		tpic=new ImageIcon("newpic/TEAMPNG/"+name+".png");
		tpic.setImage(tpic.getImage().getScaledInstance( 200, 200,Image.SCALE_DEFAULT));
		jb1.setIcon(tpic);
		pname.setText(tivo.getTeam());
		label.setText("联盟:"+(tivo.getPartition())+";  #排名:"+String.valueOf(init.tbl.getRank(name)));
		lblabalabala.setText("位置："+tivo.getLocation());
		pnumwin.setText(String.valueOf(tsd.getWinNum()));
		//System.out.println(tsd.getMatchNum()+" "+tsd.getWinNum()+"  "+init.tbl.getRank(name));
		coach.setText("教练："+tivo.getCaoch_name());
		ground.setText("主馆:"+tivo.getHomeGround());
		pnumlose.setText(String.valueOf(tsd.getMatchNum()-tsd.getWinNum()));
		time.setText("建队时间："+tivo.getFormedTime());
		
		if(tabletype.equals("近五场")){
			smdvo=UI.main.init.tbl.getLastFiveMatchData(na);
			TeamA_data=getLastFiveMatch(smdvo);
			newti=TeamA_matchtitle;
		}else if(tabletype.equals("近几年")){
			newti=TeamA_yeartitle;
			Team_map tm=new Team_map();
			System.out.println("判断传入值"+na);
			System.out.println("球队近几年"+tm.getFullName(na)+seasontype);
			tsdvo=UI.main.init.tbl.getATeamSeasonData((na), seasontype);
			System.out.println(tsdvo.size());
			if(isAvg.isSelected()){
				TeamA_data=getyearavg(tsdvo);
			}else{
				TeamA_data=getyeartol(tsdvo);
			}		
		}else{
			newti=TeamA_matchtitle;
			smdvo=init.tbl. getASeasonMatchData(na, init.defaultseason);
			TeamA_data=getLastFiveMatch(smdvo);
		}
		TeamA_list.setOpaque(false);
		TeamA_list.updateTable(newti, TeamA_data);
		if(tabletype.equals("近几年")){
			TeamA_list.new2FitTableColumns(TeamA_list.getTable());
		}else{
			TeamA_list.new1FitTableColumns(TeamA_list.getTable());
		}
		TeamA_list.getRoll().getViewport().setOpaque(false);
	}
}
