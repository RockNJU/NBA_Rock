package UI.Player;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.data.category.DefaultCategoryDataset;

import bl_db.common.Team_map;
import UI.Player.temp_linechart.LineChart;
import UI.common.ChartUtils;
import UI.common.Serie;
import UI.common.SortItem_Map;
import UI.main.init;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;

public class PlayerC extends JPanel {

	/**
	 * Create the panel.
	 */
	PlayerSeasonDataVO playera;
	PlayerSeasonDataVO playerb;
	//RMIObject rmi = new RMIObject();
	//PlayerBLService pbs = rmi.getPlayerObject();

	private JPanel contentPane;
	private JTextField textField;
	private JButton 赛季;
	JButton 三十场 = new JButton("");
	JButton 二十场 = new JButton("");
	JButton 十场 = new JButton("");
	JComboBox 队员选择3 = new JComboBox();
	JComboBox 队伍选择3 = new JComboBox();
	Team_map tm = new Team_map();
	SortItem_Map sm = new SortItem_Map();
	String season = "13-14";
	JComboBox 对比项目选择 = new JComboBox();
	
	String chossenShowData = "总分";
	String[] categories =  { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", };
	String basicName = "NULL";
	String firstName = "NULL";
	String secondName = "NULL";
	String thirdName = "NULL";
	String fourthName = "NULL";
	String sectionupName = "估计上限";
	String sectiondownName = "估计下限";
	Double[] basicData = { 49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1 };
	Double[] firstData =  { 83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5};
	Double[] secondData = { 48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2};
	Double[] thirdData =  { 12.2, 14.2, 18.5, 50.2,26.2, 37.4, 39.5,23.1, 47.6, 39.1 };
	Double[] fourthData =  { 42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 28.5, 58.1};
	Double[] sectionupData =  {50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0};
	Double[] sectiondownData =  { 40.0,40.0,40.0,40.0,40.0,40.0,40.0,40.0,40.0,40.0};

	Serie basicline = new Serie(basicName, basicData);
	Serie firsts = new Serie(firstName, firstData);
	Serie seconds = new Serie(secondName, secondData);
	Serie thirds = new Serie(thirdName, thirdData);
	Serie fourths = 	new Serie(fourthName, fourthData);
	Serie sectionup = new Serie(sectionupName, sectionupData);
	Serie sectiondown = new Serie(sectiondownName, sectiondownData);
	boolean[] lineisshowed = {false,false,false,false,false,false};
	Serie[] tempsave = {firsts,seconds,thirds,fourths,sectionup,sectiondown};
	
	double sectionupnum = 40;
	double sectiondownnum = 30;	
	
	boolean showsectionline = false;
	int lineChartState = 10;//选择的可以是10，20,30，赛季
	
	LineChart lc = new LineChart();
	ChartPanel chartPanel = lc.createChart();//下方图表
	String na;
	
	public PlayerC(String name) {
		//用于测试
		basicName=name;
		
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1042, 580);
		contentPane.setBackground(new Color(183,221,222));
		add(contentPane);
		contentPane.setLayout(null);
		
		double[] temp = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(chossenShowData));
		basicData = Changedouble(temp);
		basicline = new Serie(basicName, basicData);
		System.out.println(basicData[0]+";"+basicData[1]);
		chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
		chartPanel.getChart().fireChartChanged();
		
		//初始化区间,需要得到预计的上限和下限
		for(int i = 0;i<10;i++){
			sectionupData[i] = sectionupnum;
			sectiondownData[i] = sectiondownnum;	
		}
		
		//下方线表
		contentPane.add(chartPanel);

		
		//对比项目选择
		对比项目选择.setModel(new DefaultComboBoxModel(new String[] {"总分","篮板数","助攻数","盖帽数","抢断数","犯规数"
				,"失误数"}));
		对比项目选择.setBounds(10, 40, 109, 23);
		对比项目选择.setSelectedIndex(0);
		contentPane.add(对比项目选择);
		对比项目选择.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chossenShowData = 对比项目选择.getSelectedItem().toString();

				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 0; i<lineChartState;i++){
					sectionupData[i] = sectionupnum;
					sectiondownData[i] = sectiondownnum;	
				}
				//修改数据			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(chossenShowData));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(对比项目选择.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}


				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("最近"+lineChartState+"场比赛的"+chossenShowData+"趋势");
			}
		});

		
		//上方操控
		JButton 加入对比3 = new JButton(new ImageIcon("newpic\\加入对比.png"));
		加入对比3.setForeground(new Color(0, 0, 255));
		加入对比3.setOpaque(true);
		加入对比3.setContentAreaFilled(false);
		加入对比3.setBounds(852, 10, 88, 23);
		contentPane.add(加入对比3);
		加入对比3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[2] = true;
				thirdName = 队员选择3.getSelectedItem().toString();
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);			

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		
		JButton 取消对比3 = new JButton(new ImageIcon("newpic\\取消对比.png"));
		取消对比3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[2] = false;
				thirdName = "NULL";
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		取消对比3.setOpaque(true);
		取消对比3.setForeground(Color.BLUE);
		取消对比3.setContentAreaFilled(false);
		取消对比3.setBounds(946, 10, 88, 23);
		contentPane.add(取消对比3);
		

		队员选择3.setBounds(723, 10, 125, 23);
		contentPane.add(队员选择3);
		队员选择3.setModel(new DefaultComboBoxModel(new String[] {"NULL"}));
		

		队伍选择3.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				//可以改变队员选择中可选择的内容
				ArrayList<PlayerInfoVO> playerdata = init.pbl.getTeamAllPlayer(season,tm.getFullName(队伍选择3.getSelectedItem().toString()));
				int length = playerdata.size();
				String[] playerlist = new String[length];
				int i  = 0;
				for(PlayerInfoVO pinfo:playerdata){
					playerlist[i] = pinfo.getName();
				}
				队员选择3.setModel(new DefaultComboBoxModel(playerlist));
			}
		});
		/*队伍选择3.setModel(new DefaultComboBoxModel(new String[] {"亚特兰大老鹰","布鲁克林篮网","波士顿凯尔特人","夏洛特黄蜂"
				,"芝加哥公牛","克里夫兰骑士","达拉斯小牛","丹佛掘金","底特律活塞","金州勇士","休斯顿火箭","印第安纳步行者","洛杉矶快船"
				,"洛杉矶湖人","孟菲斯灰熊","迈阿密热火","密尔沃基雄鹿","明尼苏达森林狼","新奥尔良鹈鹕","纽约尼克斯","俄克拉荷马雷霆",
				"奥兰多魔术","费城76人", "菲尼克斯太阳","波特兰开拓者","萨克拉门托国王","圣安东尼奥马刺","多伦多猛龙","犹他爵士", "华盛顿奇才"}));
		*/
		队伍选择3.setModel(new DefaultComboBoxModel(new String[] {"老鹰","篮网","凯尔特人","黄蜂"
				,"公牛","骑士","小牛","掘金","活塞","勇士","火箭","步行者","快船"
				,"湖人","灰熊","热火","雄鹿","森林狼","鹈鹕","尼克斯","雷霆",
				"魔术","76人", "太阳","开拓者","国王","马刺","猛龙","爵士", "奇才"}));
	
		队伍选择3.setBounds(644, 10, 75, 23);
		contentPane.add(队伍选择3);


		十场.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartState = 10;	
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				if(basicData.length<10){
					lineChartState = basicData.length;
				}
				
				//获取当前选中球员的所有信息对应
				categories = new String[lineChartState];
				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 1; i<=lineChartState;i++){
					categories[i-1] = String.valueOf(i);
					sectionupData[i-1] = sectionupnum;
					sectiondownData[i-1] = sectiondownnum;	
				}
				//修改数据			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(对比项目选择.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("最近"+lineChartState+"场比赛的"+chossenShowData+"趋势");
				
				十场.setIcon(new ImageIcon("newpic//10场后.png"));
				二十场.setIcon(new ImageIcon("newpic//20场.png"));
				三十场.setIcon(new ImageIcon("newpic//30场.png"));
				赛季.setIcon(new ImageIcon("newpic//赛季.png"));
			}
		});
		十场.setIcon(new ImageIcon("newpic//10场.png"));
		十场.setBounds(10, 10, 51, 23);
		contentPane.add(十场);
		

		二十场.setIcon(new ImageIcon("newpic//20场.png"));
		二十场.setBounds(68, 10, 51, 23);
		contentPane.add(二十场);
		二十场.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartState = 20;
					double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				if(basicData.length<20){
					lineChartState = basicData.length;
				}
				
				//获取当前选中球员的所有信息对应
				categories = new String[lineChartState];
				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 1; i<=lineChartState;i++){
					categories[i-1] = String.valueOf(i);
					sectionupData[i-1] = sectionupnum;
					sectiondownData[i-1] = sectiondownnum;	
				}
				//修改数据			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(对比项目选择.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}


				//修改数据
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("最近"+lineChartState+"场比赛的"+chossenShowData+"趋势");
				十场.setIcon(new ImageIcon("newpic//10场.png"));
				二十场.setIcon(new ImageIcon("newpic//20场后.png"));
				三十场.setIcon(new ImageIcon("newpic//30场.png"));
				赛季.setIcon(new ImageIcon("newpic//赛季.png"));
			}
		});
		

		三十场.setIcon(new ImageIcon("newpic//30场.png"));
		三十场.setBounds(124, 10, 51, 23);
		contentPane.add(三十场);
		三十场.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartState = 30;
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				if(basicData.length<30){
					lineChartState = basicData.length;
				}
				
				categories = new String[lineChartState];
				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 1; i<=lineChartState;i++){
					categories[i-1] = String.valueOf(i);
					sectionupData[i-1] = sectionupnum;
					sectiondownData[i-1] = sectiondownnum;	
				}
				//修改数据			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(对比项目选择.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}


				//修改数据
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("最近"+lineChartState+"场比赛的"+chossenShowData+"趋势");
				
				十场.setIcon(new ImageIcon("newpic//10场.png"));
				二十场.setIcon(new ImageIcon("newpic//20场.png"));
				三十场.setIcon(new ImageIcon("newpic//30场后.png"));
				赛季.setIcon(new ImageIcon("newpic//赛季.png"));

			}
		});
		
		赛季 = new JButton("");
		赛季.setIcon(new ImageIcon("newpic//赛季.png"));
		赛季.setBounds(183, 10, 51, 23);
		contentPane.add(赛季);
		赛季.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//线得到数据，然后修改
				lineChartState = 0;
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				
				lineChartState = basicData.length;
				
				categories = new String[lineChartState];
				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 1; i<=lineChartState;i++){
					categories[i-1] = String.valueOf(i);
					sectionupData[i-1] = sectionupnum;
					sectiondownData[i-1] = sectiondownnum;	
				}
				//修改数据			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(对比项目选择.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(对比项目选择.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("最近"+lineChartState+"场比赛的"+chossenShowData+"趋势");
				十场.setIcon(new ImageIcon("newpic//10场.png"));
				二十场.setIcon(new ImageIcon("newpic//20场.png"));
				三十场.setIcon(new ImageIcon("newpic//30场.png"));
				赛季.setIcon(new ImageIcon("newpic//赛季后.png"));
			}
		});
		
		

		JButton button = new JButton((Icon) null);
		button.setOpaque(true);
		button.setForeground(Color.BLUE);
		button.setContentAreaFilled(false);
		button.setBounds(452, 10, 88, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton((Icon) null);
		button_1.setOpaque(true);
		button_1.setForeground(Color.BLUE);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(546, 10, 88, 23);
		contentPane.add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(323, 10, 125, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(244, 10, 75, 23);
		contentPane.add(comboBox_1);
		
		JButton 球员区间 = new JButton("\u7403\u5458\u9884\u8BA1\u533A\u95F4");
		球员区间.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showsectionline = !showsectionline;
				if(showsectionline==true){
					lineisshowed[4] = true;
					lineisshowed[5] = true;
				}
				else{
					lineisshowed[4] = false;
					lineisshowed[5] = false;
				}
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		球员区间.setBounds(124, 40, 110, 23);
		contentPane.add(球员区间);
		
	
		
		}
	

	public class LineChart {
		public LineChart() {
		}

		public DefaultCategoryDataset createDataset() {
				Vector<Serie> series = new Vector<Serie>();
			// 柱子名称：柱子所有的值集合
			series.add(basicline);
			for(int i = 0; i<6;i++){
				if(lineisshowed[i]!=false){
					series.add(tempsave[i]);
				}
			}
			DefaultCategoryDataset dataset = ChartUtils.createDefaultCategoryDataset(series, categories);
			return dataset;
		}

		
		public ChartPanel createChart() {
			// 2：创建Chart[创建不同图形]
			JFreeChart chart = ChartFactory.createLineChart("最近"+lineChartState+"场比赛的"+chossenShowData+"趋势", "场数", "", createDataset());
			// 3:设置抗锯齿，防止字体显示不清楚
			ChartUtils.setAntiAlias(chart);// 抗锯齿
			// 4:对柱子进行渲染[[采用不同渲染]]
			ChartUtils.setLineRender(chart.getCategoryPlot(), false,true);//
			// 5:对其他部分进行渲染
			ChartUtils.setXAixs(chart.getCategoryPlot());// X坐标轴渲染
			ChartUtils.setYAixs(chart.getCategoryPlot());// Y坐标轴渲染
			// 设置标注无边框
			chart.getLegend().setFrame(new BlockBorder(Color.WHITE));

			// 6:使用chartPanel接收
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setBounds(10, 70, 1022, 500);
			return chartPanel;
		}



	}
	
	public Double[] Changedouble(double[] temp){
		int num = temp.length;
		Double[] Data = new Double[num];
		int i  = 0;
		for(double tempnum:temp){
			Data[i] = new Double(tempnum);
			i++;
		}
		return Data;
	}
}
