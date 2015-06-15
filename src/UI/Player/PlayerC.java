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
	private JButton ����;
	JButton ��ʮ�� = new JButton("");
	JButton ��ʮ�� = new JButton("");
	JButton ʮ�� = new JButton("");
	JComboBox ��Աѡ��3 = new JComboBox();
	JComboBox ����ѡ��3 = new JComboBox();
	JComboBox ��Աѡ��1 = new JComboBox();
	JComboBox ��Աѡ��4 = new JComboBox();
	Team_map tm = new Team_map();
	SortItem_Map sm = new SortItem_Map();
	String season = "13-14";
	JComboBox �Ա���Ŀѡ�� = new JComboBox();
	
	String chossenShowData = "�ܷ�";
	String[] categories =  { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", };
	String basicName = "NULL";
	String firstName = "NULL";
	String secondName = "NULL";
	String thirdName = "NULL";
	String fourthName = "NULL";
	String sectionupName = "��������";
	String sectiondownName = "��������";
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
	
	double sectionupnum = 30;
	double sectiondownnum = 40;	
	Py_SectionEstimate pys;
	Py_forecast pf;
	
	boolean showsectionline = false;
	int lineChartState = 10;//ѡ��Ŀ�����10��20,30������
	
	LineChart lc = new LineChart();
	ChartPanel chartPanel = lc.createChart();//�·�ͼ��
	String na;
	private JTextField Ԥ��;
	
	public PlayerC(String name) {
		//���ڲ���
		basicName=name;
		pys = new Py_SectionEstimate(name);
		
		sectionupnum = pys.getEstimatePoint()[1];
		sectiondownnum = pys.getEstimatePoint()[0];
		for(int i = 0;i<10;i++){
			sectionupData[i] = sectionupnum;
			sectiondownData[i] = sectiondownnum;
		}
		sectionup = new Serie(sectionupName, sectionupData);
		sectiondown = new Serie(sectiondownName, sectiondownData);
		tempsave[4] = sectionup;
		tempsave[5]	= sectiondown;

		
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
		chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
		chartPanel.getChart().fireChartChanged();
		
		//��ʼ������,��Ҫ�õ�Ԥ�Ƶ����޺�����
		for(int i = 0;i<10;i++){
			sectionupData[i] = sectionupnum;
			sectiondownData[i] = sectiondownnum;	
		}
		
		//�·��߱�
		contentPane.add(chartPanel);

		
		//�Ա���Ŀѡ��
		�Ա���Ŀѡ��.setModel(new DefaultComboBoxModel(new String[] {"�ܷ�","������","������","��ñ��","������","������"
				,"ʧ����"}));
		�Ա���Ŀѡ��.setBounds(10, 40, 109, 23);
		�Ա���Ŀѡ��.setSelectedIndex(0);
		contentPane.add(�Ա���Ŀѡ��);
		�Ա���Ŀѡ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chossenShowData = �Ա���Ŀѡ��.getSelectedItem().toString();
				//String forecast = String.valueOf(pf.getForecastProperty(chossenShowData,basicName));
			//	Ԥ��.setText("\u4E0B\u573A\u6BD4\u8D5B\u7684\u9884\u8BA1\u503C\uFF1A"+forecast);
				getsectionnum(chossenShowData);

				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 0; i<lineChartState;i++){
					sectionupData[i] = sectionupnum;
					sectiondownData[i] = sectiondownnum;	
				}
				//�޸�����			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(chossenShowData));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(�Ա���Ŀѡ��.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}


				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("���"+lineChartState+"��������"+chossenShowData+"����");
			}
		});

		
		//�Ϸ��ٿ�
		JButton ����Ա�3 = new JButton(new ImageIcon("newpic\\����Ա�.png"));
		����Ա�3.setForeground(new Color(0, 0, 255));
		����Ա�3.setOpaque(true);
		����Ա�3.setContentAreaFilled(false);
		����Ա�3.setBounds(852, 10, 88, 23);
		contentPane.add(����Ա�3);
		����Ա�3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[2] = true;
				thirdName = ��Աѡ��3.getSelectedItem().toString();
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		
		JButton ȡ���Ա�3 = new JButton(new ImageIcon("newpic\\ȡ���Ա�.png"));
		ȡ���Ա�3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[2] = false;
				thirdName = "NULL";
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		ȡ���Ա�3.setOpaque(true);
		ȡ���Ա�3.setForeground(Color.BLUE);
		ȡ���Ա�3.setContentAreaFilled(false);
		ȡ���Ա�3.setBounds(946, 10, 88, 23);
		contentPane.add(ȡ���Ա�3);
		

		��Աѡ��3.setBounds(723, 10, 125, 23);
		contentPane.add(��Աѡ��3);
		��Աѡ��3.setModel(new DefaultComboBoxModel(new String[] {"NULL"}));
		
		����ѡ��3.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				//���Ըı��Աѡ���п�ѡ�������
				ArrayList<PlayerInfoVO> playerdata = init.pbl.getTeamAllPlayer(season,tm.getFullName(����ѡ��3.getSelectedItem().toString()));
				int length = playerdata.size();
				String[] playerlist = new String[length];
				int i  = 0;
				for(PlayerInfoVO pinfo:playerdata){
					playerlist[i] = pinfo.getName();
					i++;
				}
				��Աѡ��3.setModel(new DefaultComboBoxModel(playerlist));
			}
		});
		/*����ѡ��3.setModel(new DefaultComboBoxModel(new String[] {"����������ӥ","��³��������","��ʿ�ٿ�������","�����ػƷ�"
				,"֥�Ӹ繫ţ","���������ʿ","����˹Сţ","������","�����ɻ���","������ʿ","��˹�ٻ��","ӡ�ڰ��ɲ�����","��ɼ�촬"
				,"��ɼ����","�Ϸ�˹����","�������Ȼ�","�ܶ��ֻ���¹","�����մ�ɭ����","�°¶�������","ŦԼ���˹","�������������",
				"������ħ��","�ѳ�76��", "�����˹̫��","������������","���������й���","ʥ����������","���׶�����","������ʿ", "��ʢ�����"}));
		*/
		����ѡ��3.setModel(new DefaultComboBoxModel(new String[] {"��ӥ","����","��������","�Ʒ�"
				,"��ţ","��ʿ","Сţ","���","����","��ʿ","���","������","�촬"
				,"����","����","�Ȼ�","��¹","ɭ����","����","���˹","����",
				"ħ��","76��", "̫��","������","����","���","����","��ʿ", "���"}));
	
		����ѡ��3.setBounds(644, 10, 75, 23);
		contentPane.add(����ѡ��3);


		ʮ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartState = 10;	
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				if(basicData.length<10){
					lineChartState = basicData.length;
				}
				
				//��ȡ��ǰѡ����Ա��������Ϣ��Ӧ
				categories = new String[lineChartState];
				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 1; i<=lineChartState;i++){
					categories[i-1] = String.valueOf(i);
					sectionupData[i-1] = sectionupnum;
					sectiondownData[i-1] = sectiondownnum;	
				}
				//�޸�����			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(�Ա���Ŀѡ��.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("���"+lineChartState+"��������"+chossenShowData+"����");
				
				ʮ��.setIcon(new ImageIcon("newpic//10����.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//20��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//30��.png"));
				����.setIcon(new ImageIcon("newpic//����.png"));
			}
		});
		ʮ��.setIcon(new ImageIcon("newpic//10��.png"));
		ʮ��.setBounds(10, 10, 51, 23);
		contentPane.add(ʮ��);
		

		��ʮ��.setIcon(new ImageIcon("newpic//20��.png"));
		��ʮ��.setBounds(68, 10, 51, 23);
		contentPane.add(��ʮ��);
		��ʮ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartState = 20;
					double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);
				if(basicData.length<20){
					lineChartState = basicData.length;
				}
				
				//��ȡ��ǰѡ����Ա��������Ϣ��Ӧ
				categories = new String[lineChartState];
				sectionupData = new Double[lineChartState];
				sectiondownData = new Double[lineChartState];
				for(int i = 1; i<=lineChartState;i++){
					categories[i-1] = String.valueOf(i);
					sectionupData[i-1] = sectionupnum;
					sectiondownData[i-1] = sectiondownnum;	
				}
				//�޸�����			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(�Ա���Ŀѡ��.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}


				//�޸�����
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("���"+lineChartState+"��������"+chossenShowData+"����");
				ʮ��.setIcon(new ImageIcon("newpic//10��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//20����.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//30��.png"));
				����.setIcon(new ImageIcon("newpic//����.png"));
			}
		});
		

		��ʮ��.setIcon(new ImageIcon("newpic//30��.png"));
		��ʮ��.setBounds(124, 10, 51, 23);
		contentPane.add(��ʮ��);
		��ʮ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartState = 30;
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
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
				//�޸�����			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(�Ա���Ŀѡ��.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}


				//�޸�����
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("���"+lineChartState+"��������"+chossenShowData+"����");
				
				ʮ��.setIcon(new ImageIcon("newpic//10��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//20��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//30����.png"));
				����.setIcon(new ImageIcon("newpic//����.png"));

			}
		});
		
		���� = new JButton("");
		����.setIcon(new ImageIcon("newpic//����.png"));
		����.setBounds(183, 10, 51, 23);
		contentPane.add(����);
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ߵõ����ݣ�Ȼ���޸�
				lineChartState = 0;
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
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
				//�޸�����			
				sectionup = new Serie(sectionupName, sectionupData);
				sectiondown = new Serie(sectiondownName, sectiondownData);
				tempsave[4] = sectionup;
				tempsave[5] = sectiondown;
				//System.out.print(�Ա���Ŀѡ��.getSelectedItem().toString()+"\n");
				if(!firstName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				firstData = Changedouble(temp);
				 firsts = new Serie(firstName, firstData);
					tempsave[0] = firsts;
				}
				if(!secondName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(secondName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				secondData = Changedouble(temp);
				seconds = new Serie(secondName, secondData);
				tempsave[1] = seconds;
				}
				if(!thirdName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(thirdName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				}
				if(!fourthName.equals("NULL")){
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				fourthData = Changedouble(temp);
				fourths = 	new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				}

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
				chartPanel.getChart().setTitle("���"+lineChartState+"��������"+chossenShowData+"����");
				
				ʮ��.setIcon(new ImageIcon("newpic//10��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//20��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//30��.png"));
				����.setIcon(new ImageIcon("newpic//������.png"));
			}
		});
		
		JButton ��Ա���� = new JButton("\u9884\u8BA1\u533A\u95F4");
		��Ա����.addActionListener(new ActionListener() {
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
		��Ա����.setBounds(124, 40, 110, 23);
		contentPane.add(��Ա����);
		

		JButton ����Ա�1 = new JButton(new ImageIcon("newpic\\����Ա�.png"));
		����Ա�1.setOpaque(true);
		����Ա�1.setForeground(Color.BLUE);
		����Ա�1.setContentAreaFilled(false);
		����Ա�1.setBounds(452, 10, 88, 23);
		contentPane.add(����Ա�1);
		����Ա�1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[0] = true;
				firstName = ��Աѡ��1.getSelectedItem().toString();
				double[] temp = init.pbl.getPlayerOneData(firstName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				firstData = Changedouble(temp);
				firsts = new Serie(firstName, firstData);
				tempsave[0] = firsts;

				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		
		JButton ȡ���Ա�1 = new JButton(new ImageIcon("newpic\\ȡ���Ա�.png"));
		ȡ���Ա�1.setOpaque(true);
		ȡ���Ա�1.setForeground(Color.BLUE);
		ȡ���Ա�1.setContentAreaFilled(false);
		ȡ���Ա�1.setBounds(546, 10, 88, 23);
		contentPane.add(ȡ���Ա�1);
		ȡ���Ա�1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[0] = false;
				firstName = "NULL";
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		

		��Աѡ��1.setBounds(323, 10, 125, 23);
		contentPane.add(��Աѡ��1);
		��Աѡ��1.setModel(new DefaultComboBoxModel(new String[] {"NULL"}));
		final JComboBox ����ѡ��1 = new JComboBox();
		����ѡ��1.setBounds(244, 10, 75, 23);
		contentPane.add(����ѡ��1);
		����ѡ��1.setModel(new DefaultComboBoxModel(new String[] {"��ӥ","����","��������","�Ʒ�"
				,"��ţ","��ʿ","Сţ","���","����","��ʿ","���","������","�촬"
				,"����","����","�Ȼ�","��¹","ɭ����","����","���˹","����",
				"ħ��","76��", "̫��","������","����","���","����","��ʿ", "���"}));
		����ѡ��1.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				//���Ըı��Աѡ���п�ѡ�������
				ArrayList<PlayerInfoVO> playerdata = init.pbl.getTeamAllPlayer(season,tm.getFullName(����ѡ��1.getSelectedItem().toString()));
				int length = playerdata.size();
				String[] playerlist = new String[length];
				int i  = 0;
				for(PlayerInfoVO pinfo:playerdata){
					playerlist[i] = pinfo.getName();
					i++;
				}
				��Աѡ��1.setModel(new DefaultComboBoxModel(playerlist));
			}
		});
		

		
		Ԥ�� = new JTextField();
		Ԥ��.setEditable(false);
		Ԥ��.setText("\u4E0B\u573A\u6BD4\u8D5B\u7684\u9884\u8BA1\u503C\uFF1A");
		Ԥ��.setBounds(244, 38, 204, 28);
		contentPane.add(Ԥ��);
		Ԥ��.setColumns(10);
		
		JButton ȡ���Ա�4 = new JButton(new ImageIcon("newpic\\ȡ���Ա�.png"));
		ȡ���Ա�4.setOpaque(true);
		ȡ���Ա�4.setForeground(Color.BLUE);
		ȡ���Ա�4.setContentAreaFilled(false);
		ȡ���Ա�4.setBounds(946, 40, 88, 23);
		contentPane.add(ȡ���Ա�4);
		ȡ���Ա�4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[3] = false;
				fourthName = "NULL";
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		
		JButton ����Ա�4 = new JButton(new ImageIcon("newpic\\����Ա�.png"));
		����Ա�4.setOpaque(true);
		����Ա�4.setForeground(Color.BLUE);
		����Ա�4.setContentAreaFilled(false);
		����Ա�4.setBounds(852, 40, 88, 23);
		contentPane.add(����Ա�4);
		����Ա�4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineisshowed[3] = true;
				fourthName = ��Աѡ��4.getSelectedItem().toString();
				double[] temp = init.pbl.getPlayerOneData(fourthName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				temp = Addzero(temp,lineChartState,temp.length);
				fourthData = Changedouble(temp);
				fourths = new Serie(fourthName, fourthData);
				tempsave[3] = fourths;
				
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
			}
		});
		

		��Աѡ��4.setBounds(723, 40, 125, 23);
		contentPane.add(��Աѡ��4);
		��Աѡ��4.setModel(new DefaultComboBoxModel(new String[] {"NULL"}));
		final JComboBox ����ѡ��4 = new JComboBox();
		����ѡ��4.setBounds(644, 40, 75, 23);
		����ѡ��4.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				//���Ըı��Աѡ���п�ѡ�������
				ArrayList<PlayerInfoVO> playerdata = init.pbl.getTeamAllPlayer(season,tm.getFullName(����ѡ��4.getSelectedItem().toString()));
				int length = playerdata.size();
				String[] playerlist = new String[length];
				int i  = 0;
				for(PlayerInfoVO pinfo:playerdata){
					playerlist[i] = pinfo.getName();
					i++;
				}
				��Աѡ��4.setModel(new DefaultComboBoxModel(playerlist));
			}
		});

		contentPane.add(����ѡ��4);
		����ѡ��4.setModel(new DefaultComboBoxModel(new String[] {"��ӥ","����","��������","�Ʒ�"
				,"��ţ","��ʿ","Сţ","���","����","��ʿ","���","������","�촬"
				,"����","����","�Ȼ�","��¹","ɭ����","����","���˹","����",
				"ħ��","76��", "̫��","������","����","���","����","��ʿ", "���"}));
		
		
		
		}
	

	protected void getsectionnum(String chossenShowData2) {
		//"�ܷ�","������","������","��ñ��","������","������","ʧ����"


		if(chossenShowData2.equals("�ܷ�")){
			sectionupnum = pys.getEstimatePoint()[1];
			sectiondownnum = pys.getEstimatePoint()[0];
		}
		else if(chossenShowData2.equals("������")){
			sectionupnum = pys.getEstimateRebound()[1];
			sectiondownnum = pys.getEstimateRebound()[0];
		}
		else if(chossenShowData2.equals("������")){
			sectionupnum = pys.getEstimateAssist()[1];
			sectiondownnum = pys.getEstimateAssist()[0];
		}
		else if(chossenShowData2.equals("��ñ��")){
			sectionupnum = pys.getEstimateBlock()[1];
			sectiondownnum = pys.getEstimateBlock()[0];
		}
		else if(chossenShowData2.equals("������")){
			sectionupnum = pys.getEstimateSteal()[1];
			sectiondownnum = pys.getEstimateSteal()[0];
		}
		else if(chossenShowData2.equals("������")){
			sectionupnum = 0;
			sectiondownnum = 0;
		}
		else if(chossenShowData2.equals("ʧ����")){
			sectionupnum = 0;
			sectiondownnum = 0;
		}
		for(int i = 0;i<10;i++){
			sectionupData[i] = sectionupnum;
			sectiondownData[i] = sectiondownnum;
		}
		sectionup = new Serie(sectionupName, sectionupData);
		sectiondown = new Serie(sectiondownName, sectiondownData);
		tempsave[4] = sectionup;
		tempsave[5]	= sectiondown;
	}


	public class LineChart {
		public LineChart() {
		}

		public DefaultCategoryDataset createDataset() {
				Vector<Serie> series = new Vector<Serie>();
			// �������ƣ��������е�ֵ����
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
			// 2������Chart[������ͬͼ��]
			JFreeChart chart = ChartFactory.createLineChart("���"+lineChartState+"��������"+chossenShowData+"����", "����", "", createDataset());
			// 3:���ÿ���ݣ���ֹ������ʾ�����
			ChartUtils.setAntiAlias(chart);// �����
			// 4:�����ӽ�����Ⱦ[[���ò�ͬ��Ⱦ]]
			ChartUtils.setLineRender(chart.getCategoryPlot(), false,true);//
			// 5:���������ֽ�����Ⱦ
			ChartUtils.setXAixs(chart.getCategoryPlot());// X��������Ⱦ
			ChartUtils.setYAixs(chart.getCategoryPlot());// Y��������Ⱦ
			// ���ñ�ע�ޱ߿�
			chart.getLegend().setFrame(new BlockBorder(Color.WHITE));

			// 6:ʹ��chartPanel����
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
	
	public double[] Addzero(double[] temp,int shouldput,int realput){
		double[] output = new double[shouldput];
		if(realput==shouldput)
			return temp;
		else if(realput<shouldput){
			for(int i = 0;i<shouldput-realput;i++){
				output[i] = 0;
			}
			for(int j = 0;j<realput;j++){
				output[shouldput-realput+j] = temp[j];
			}
			return output;
		}
		return temp;
	}
}
