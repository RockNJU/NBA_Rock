package UI.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import businesslogic.bl.playerbl.PlayerSeasonData;
import UI.common.CreateTable;
import UI.common.History;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.common.SearchHistory;
import UI.common.SortItem_Map;
import VO.PlayerSeasonDataVO;

public class Player_Data extends JPanel{
	
	public static String[] types={"常规赛","季后赛"};
	public static SearchHistory sh = new SearchHistory();
	public static JComboBox position;
	public static JComboBox partition;
	public static JComboBox playerseason;
	public static JComboBox seasontype;
	public static CreateTable playerdatalist;
	public static JComboBox according;
	JButton sort;
	JButton sort_point;
	JButton sort_rebound;
	JButton sort_assist;
	JRadioButton avg_tol;
	public static String[] playerAvgdatatitle = { "序号", "球员名称", "所属球队", "参赛场数",
		"先发场数", "场均篮板", "场均助攻", "场均得分", "投篮命中率(%)", "三分命中率(%)",
		"罚球命中率(%)", "场均进攻", "场均防守", "场均抢断", "场均盖帽", "场均失误",
		"场均犯规", "场均上场时间", "效率", "GmSc效率值", "真实命中率(%)", "投篮效率(%)",
		"篮板率(%)", "进攻篮板率(%)", "防守篮板率(%)", "助攻率(%)", "抢断率(%)", "盖帽率",
		"失误率(%)", "使用率(%)","近五场得分提升率(%)","近五场助攻提升率(%)","近五场篮板提升率(%)"};
	public static String[] playerTotaldatatitle={ "序号", "球员名称", "所属球队", "参赛场数",
		"先发场数", "篮板", "助攻", "得分", "投篮命中率", "三分命中率",
		"罚球命中率", "进攻", "场均防守", "场均抢断", "盖帽", "失误",
		"犯规", "上场时间", "效率", "GmSc效率值", "真实命中率", "投篮效率",
		"篮板率", "进攻篮板率", "防守篮板率", "助攻率", "抢断率", "盖帽率",
		"失误率", "使用率","近五场得分提升率","近五场助攻提升率","近五场篮板提升率"};
	public static Object[][] playerdata;
	public static ArrayList<PlayerSeasonDataVO> pdvo;

	
	public Player_Data(){

		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		
		/**
		 * 球员的位置
		 */
		position = new JComboBox();
		position.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		position.setBounds(25, 15, 70, 30);
		position.setMaximumRowCount(100);
		position.setModel(new DefaultComboBoxModel(new String[] {
				"\u524D\u950B", "\u4E2D\u950B", "\u540E\u536B" }));
		position.setToolTipText("\u4F4D\u7F6E");
		position.setEditable(true);
		add(position);
		position.setVisible(true);
		
		/**
		 * 球员所属球队的分区
		 * 
		 */
		
		partition = new JComboBox();
		partition.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		partition.setToolTipText("\u6240\u5C5E\u7403\u961F\u5206\u533A");
		partition.setModel(new DefaultComboBoxModel(new String[] {"\u6240\u6709\u5206\u533A", "\u4E1C\u533A", "\u897F\u533A", "\u5927\u897F\u6D0B", "\u4E2D\u90E8", "\u4E1C\u5357", "\u897F\u5357", "\u897F\u5317\u90E8", "\u592A\u5E73\u6D0B"}));
		partition.setEditable(true);
		partition.setBounds(126, 15, 89, 30);
		add(partition);
		partition.setVisible(true);
		
		/**
		 * TODO 赛季
		 */
		playerseason = new JComboBox();
		playerseason.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		playerseason.setToolTipText("赛季");

		ArrayList<String> seasons = init.mbl.getAllSeason();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			playerseason.addItem(seasons.get(o));
		}
		playerseason.setEditable(true);
		playerseason.setBounds(243, 15, 117, 30);
		add(playerseason);
		playerseason.setVisible(true);
		
		/**
		 * TODO 赛季形式
		 */
		seasontype = new JComboBox();
		seasontype.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		seasontype.setToolTipText("赛季");
/*
		ArrayList<String> types = init.mbl.getAllSeasonType();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			playerseason.addItem(seasons.get(o));
		}*/
		seasontype.setModel(new DefaultComboBoxModel(types));
		seasontype.setEditable(true);
		seasontype.setBounds(389, 15, 70, 30);
		add(seasontype);
		seasontype.setVisible(true);
		
		/**
		 * 球员进行筛选排列的依据
		 * 
		 */
		according = new JComboBox();
		according.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		according.setToolTipText("\u6392\u5E8F\u4F9D\u636E");
		according.setModel(new DefaultComboBoxModel(new String[] {"\u53C2\u8D5B\u573A\u6570", "\u5148\u53D1\u573A\u6570", "\u4E0A\u573A\u65F6\u95F4", "\u6295\u7BEE\u547D\u4E2D\u7387", "\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", "\u8FDB\u653B", "\u9632\u5B88", "\u62A2\u65AD", "\u76D6\u5E3D", "\u5931\u8BEF", "\u72AF\u89C4", "\u6548\u7387", "\u4E24\u53CC\u6570", "\u4E09\u53CC\u6570", "GmSc\u6548\u7387\u503C", "\u771F\u5B9E\u547D\u4E2D\u7387", "\u6295\u7BEE\u6548\u7387", "\u7BEE\u677F\u7387", "\u8FDB\u653B\u7BEE\u677F\u6570", "\u9632\u5B88\u7BEE\u677F\u6570", "\u52A9\u653B\u7387", "\u62A2\u65AD\u7387", "\u76D6\u5E3D\u7387", "\u5931\u8BEF\u7387", "\u4F7F\u7528\u7387", "\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387"}));
		according.setEditable(true);
		according.setBounds(25, 55, 86, 30);
		add(according);
		according.setVisible(true);
		
		avg_tol = new JRadioButton("\u573A\u5747\u6570\u636E");
		avg_tol.setFont(new Font("华文细黑", Font.PLAIN, 14));
		avg_tol.setSelected(true);
		avg_tol.setBounds(949, 15, 90, 30);
		add(avg_tol);
		avg_tol.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(avg_tol.isSelected()){
					playerdata=getAveragedata(pdvo);
					playerdatalist.updateTable(playerAvgdatatitle, playerdata);
					playerdatalist.FitTableColumns(playerdatalist.getTable());
				}else{
					playerdata=getTotaldata(pdvo);
					playerdatalist.updateTable(playerTotaldatatitle, playerdata);
					playerdatalist.FitTableColumns(playerdatalist.getTable());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		final ImageIcon image1 = new ImageIcon("newpic/筛选-得分.png");
		image1.setImage(image1.getImage().getScaledInstance(60, 27,Image.SCALE_DEFAULT));
		final ImageIcon image2 = new ImageIcon("newpic/筛选-得分浮.png");
		image2.setImage(image2.getImage().getScaledInstance(60, 27,Image.SCALE_DEFAULT));
		
		final ImageIcon image3 = new ImageIcon("newpic/筛选-助攻.png");
		image3.setImage(image3.getImage().getScaledInstance(60, 27,Image.SCALE_DEFAULT));
		
		final ImageIcon image4 = new ImageIcon("newpic/筛选-助攻浮.png");
		image4.setImage(image4.getImage().getScaledInstance(60, 27,Image.SCALE_DEFAULT));
		
		final ImageIcon image5 = new ImageIcon("newpic/筛选-篮板.png");
		image5.setImage(image5.getImage().getScaledInstance(60, 27,Image.SCALE_DEFAULT));
		
		final ImageIcon image6 = new ImageIcon("newpic/筛选-篮板浮.png");
		image6.setImage(image6.getImage().getScaledInstance(60, 27,Image.SCALE_DEFAULT));
		
		final ImageIcon image7 = new ImageIcon("newpic/筛选-筛选.png");
		image7.setImage(image7.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		final ImageIcon image8 = new ImageIcon("newpic/筛选-筛选浮.png");
		image8.setImage(image8.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		
		
		
		sort_point = new JButton(image1);
		sort_point.setToolTipText("筛选得分快捷按钮");
		sort_point.setBounds(136, 55, 60, 30);
		sort_point.setContentAreaFilled(false);
		add(sort_point);
		sort_point.setVisible(true);
		sort_point.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				sort_point.setIcon(image1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort_point.setIcon(image2);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
            	//保存历史记录
			      Calendar ca = Calendar.getInstance();
				 String time = ca.getTime().toString();
				History his = new History(time,"playerHistory","排列："+position.getSelectedItem().toString()
						+","+partition.getSelectedItem().toString()+","+according.getSelectedItem().toString()
						+","+playerseason.getSelectedItem().toString()
						.substring(0, 5));
					sh.add_player_History(his);
				
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = "得分";
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, Position, Partition, According);
				//System.out.println(Season + Position + Partition + According);
				playerdata = getAveragedata(pdvo);
				/*init.currenttext=null;
				init.currentunordown=null; 
				init.currentisaverage=false;
				init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
				System.out.println(init.currentpanel);*/
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);
				playerdatalist.setcolor(7);
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}

		});
		sort_rebound = new JButton(image5);
		sort_rebound.setToolTipText("筛选篮板快捷按钮");
		sort_rebound.setBounds(218, 55, 60, 30);
		add(sort_rebound);
		sort_rebound.setContentAreaFilled(false);
		sort_rebound.setVisible(true);
		sort_rebound.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				sort_rebound.setIcon(image5);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort_rebound.setIcon(image6);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
            	//保存历史记录
			      Calendar ca = Calendar.getInstance();
				 String time = ca.getTime().toString();
				History his = new History(time,"playerHistory","排列："+position.getSelectedItem().toString()
						+","+partition.getSelectedItem().toString()+","+according.getSelectedItem().toString()
						+","+playerseason.getSelectedItem().toString()
						.substring(0, 5));
					sh.add_player_History(his);
				
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = "篮板";
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, Position, Partition, According);
				//System.out.println(Season + Position + Partition + According);
				playerdata = getAveragedata(pdvo);
				/*init.currenttext=null;
				init.currentunordown=null; 
				init.currentisaverage=false;
				init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
				System.out.println(init.currentpanel);*/
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);
				playerdatalist.setcolor(5);
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}

		});
		sort_assist = new JButton(image3);
		sort_assist.setToolTipText("筛选助攻快捷按钮");
		sort_assist.setBounds(301, 55, 60, 30);
		add(sort_assist);
		sort_assist.setContentAreaFilled(false);
		sort_assist.setVisible(true);
		sort_assist.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				sort_assist.setIcon(image3);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort_assist.setIcon(image4);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
            	//保存历史记录
			      Calendar ca = Calendar.getInstance();
				 String time = ca.getTime().toString();
				History his = new History(time,"playerHistory","排列："+position.getSelectedItem().toString()
						+","+partition.getSelectedItem().toString()+","+according.getSelectedItem().toString()
						+","+playerseason.getSelectedItem().toString()
						.substring(0, 5));
					sh.add_player_History(his);
				
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = "助攻";
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, Position, Partition, According);
				//System.out.println(Season + Position + Partition + According);
				playerdata = getAveragedata(pdvo);
				/*init.currenttext=null;
				init.currentunordown=null; 
				init.currentisaverage=false;
				init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
				System.out.println(init.currentpanel);*/
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);
				
				playerdatalist.FitTableColumns(playerdatalist.getTable());
				playerdatalist.setcolor(6);
			}

		});
		sort = new JButton(image7);
		sort.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort.setBounds(384, 55, 75, 30);
		add(sort);
		sort.setContentAreaFilled(false);
		sort.setVisible(true);
		sort.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				sort.setIcon(image7);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort.setIcon(image8);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
            	//保存历史记录
			      Calendar ca = Calendar.getInstance();
				 String time = ca.getTime().toString();
				History his = new History(time,"playerHistory","排列："+position.getSelectedItem().toString()
						+","+partition.getSelectedItem().toString()+","+according.getSelectedItem().toString()
						+","+playerseason.getSelectedItem().toString()
						.substring(0, 5));
					sh.add_player_History(his);
				
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = according.getSelectedItem().toString();
				String Season = playerseason.getSelectedItem().toString()
						.substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, Position, Partition, According);
				//System.out.println(Season + Position + Partition + According);
				playerdata = getAveragedata(pdvo);
				/*init.currenttext=null;
				init.currentunordown=null; 
				init.currentisaverage=false;
				init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
				System.out.println(init.currentpanel);*/
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);		
				int x=getcl(according.getSelectedItem().toString());
				playerdatalist.setcolor(x);
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}

		});
		
		
		
		pdvo=init.pbl.getPlayerSeasonData("13-14");
		playerdata=getAveragedata(pdvo);
		playerdatalist = new CreateTable(playerAvgdatatitle, playerdata, 10, 100,1040, 480, 25,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(playerdatalist);
		playerdatalist.FitTableColumns(playerdatalist.getTable());
		
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 10, 1040, 82);
		add(menubg);
		menubg.setOpaque(true);
		
		
	}
	
	public static Object[][] getAveragedata(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][33];
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
			re[0][17] = "";
			re[0][18] = "";
			re[0][19] = "";
			re[0][20] = "";
			re[0][21] = "";
			re[0][22] = "";
			re[0][23] = "";
			re[0][24] = "";
			re[0][25] = "";
			re[0][26] = "";
			re[0][27] = "";
			re[0][28] = "";
			re[0][29] = "";
			re[0][30] = "";
			re[0][31] = "";
			re[0][32] = "";
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][33];
			/*
			 * {"序号","球员名称","所属球队","参赛场数","先发场数",
			 * "篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
			 * "进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率",
			 * "GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率",
			 * "助攻率","抢断率","盖帽率","失误率","使用率"};
			 */
			// TeamMap temp=new TeamMap();
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] = da.get(i).getTeamName();
				re[i][3] = da.get(i).getMatchNum();
				re[i][4] = da.get(i).getStartingNum();
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());
				re[i][6] = OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getPointNum_avg());
				re[i][8] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));
				
				re[i][9] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][10] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getO_ReboundNum_avg());
				re[i][12] = OftenUseMethod.changedouble(da.get(i).getD_ReboundNum_avg());
				re[i][13] = OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][14] = OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][15] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][16] = OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());
				re[i][17] = OftenUseMethod.changedouble(da.get(i).getTime_avg());
				re[i][18] = OftenUseMethod.changedouble(da.get(i).getEfficiency());
				re[i][19] = OftenUseMethod.changedouble(da.get(i).getGmSc());
				re[i][20] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getRealShootPercentage()));
				re[i][21] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootEfficiency()));
				re[i][22] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getReboundEfficiency()));
				re[i][23] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getOffensiveReboundEff()));
				re[i][24] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getDefenseReboundEff()));
				re[i][25] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getAssistEfficiency()));
				re[i][26] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getStealEfficiency()));
				re[i][27] = (OftenUseMethod.changedouble(da.get(i).getBlockEfficiency()));
				re[i][28] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getTurnoverPercentage()));
				re[i][29] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getUsingPercentage()));
				re[i][30] = (OftenUseMethod.changedouble(da.get(i).getL_f_point_rate()));
				re[i][31] = (OftenUseMethod.changedouble(da.get(i).getL_f_assist_rate()));
				re[i][32] = (OftenUseMethod.changedouble(da.get(i).getL_f_rebound_rate()));
			}
			return re;

		}

		
		
	}
	public static Object[][] getTotaldata(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][33];
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
			re[0][17] = "";
			re[0][18] = "";
			re[0][19] = "";
			re[0][20] = "";
			re[0][21] = "";
			re[0][22] = "";
			re[0][23] = "";
			re[0][24] = "";
			re[0][25] = "";
			re[0][26] = "";
			re[0][27] = "";
			re[0][28] = "";
			re[0][29] = "";
			re[0][30] = "";
			re[0][31] = "";
			re[0][32] = "";
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][33];
			/*
			 * {"序号","球员名称","所属球队","参赛场数","先发场数",
			 * "篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
			 * "进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率",
			 * "GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率",
			 * "助攻率","抢断率","盖帽率","失误率","使用率"};
			 */
			// TeamMap temp=new TeamMap();
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] = da.get(i).getTeamName();
				re[i][3] = da.get(i).getMatchNum();
				re[i][4] = da.get(i).getStartingNum();
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getReboundNum());
				re[i][6] = OftenUseMethod.changedouble(da.get(i).getAssistNum());
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getPointNum());
				re[i][8] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));
				
				re[i][9] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][10] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getO_ReboundNum());
				re[i][12] = OftenUseMethod.changedouble(da.get(i).getD_ReboundNum());
				re[i][13] = OftenUseMethod.changedouble(da.get(i).getStealNum());
				re[i][14] = OftenUseMethod.changedouble(da.get(i).getBlockNum());
				re[i][15] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum());
				re[i][16] = OftenUseMethod.changedouble(da.get(i).getFoulNum());
				re[i][17] = OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][18] = OftenUseMethod.changedouble(da.get(i).getEfficiency());
				re[i][19] = OftenUseMethod.changedouble(da.get(i).getGmSc());
				re[i][20] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getRealShootPercentage()));
				re[i][21] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootEfficiency()));
				re[i][22] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getReboundEfficiency()));
				re[i][23] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getOffensiveReboundEff()));
				re[i][24] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getDefenseReboundEff()));
				re[i][25] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getAssistEfficiency()));
				re[i][26] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getStealEfficiency()));
				re[i][27] = (OftenUseMethod.changedouble(da.get(i).getBlockEfficiency()));
				re[i][28] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getTurnoverPercentage()));
				re[i][29] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getUsingPercentage()));
				re[i][30] = (OftenUseMethod.changedouble(da.get(i).getL_f_point_rate()));
				re[i][31] = (OftenUseMethod.changedouble(da.get(i).getL_f_assist_rate()));
				re[i][32] = (OftenUseMethod.changedouble(da.get(i).getL_f_rebound_rate()));
			}
			return re;

		}

		
		
	}
	int getcl(String name){
		if(name.equals("参赛场数")){
			return 3;
		}else if(name.equals("先发场数")){
			return 4;
		}else if(name.equals("上场时间")){
			return 17;
		}else if(name.equals("投篮命中率")){
			return 8;
		}else if(name.equals("三分命中率")){
			return 9;
		}else if(name.equals("罚球命中率")){
			return 10;
		}else if(name.equals("进攻")){
			return 11;
		}else if(name.equals("防守")){
			return 12;
		}else if(name.equals("抢断")){
			return 13;
		}else if(name.equals("盖帽")){
			return 14;
		}else if(name.equals("失误")){
			return 15;
		}else if(name.equals("犯规")){
			return 16;
		}else if(name.equals("效率")){
			return 18;
		}else if(name.equals("两双数")){
			return 2;
		}else if(name.equals("三双数")){
			return 2;
		}else if(name.equals("GmSc效率值")){
			return 19;
		}else if(name.equals("真实命中率")){
			return 20;
		}else if(name.equals("投篮效率")){
			return 21;
		}else if(name.equals("篮板率")){
			return 22;
		}else if(name.equals("进攻篮板数")){
			return 23;
		}else if(name.equals("防守篮板数")){
			return 24;
		}else if(name.equals("助攻率")){
			return 25;
		}else if(name.equals("抢断率")){
			return 26;
		}else if(name.equals("盖帽率")){
			return 27;
		}else if(name.equals("失误率")){
			return 28;
		}else if(name.equals("使用率")){
			return 29;
		}else if(name.equals("近五场得分提升率")){
			return 30;
		}else if(name.equals("近五场助攻提升率")){
			return 31;
		}else if(name.equals("近五场篮板提升率")){
			return 32;
		}else {
			return -1;
		}		
	}
}
