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
	
	double sectionupnum = 40;
	double sectiondownnum = 30;	
	
	boolean showsectionline = false;
	int lineChartState = 10;//ѡ��Ŀ�����10��20,30������
	
	LineChart lc = new LineChart();
	ChartPanel chartPanel = lc.createChart();//�·�ͼ��
	String na;
	
	public PlayerC(String name) {
		//���ڲ���
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
				thirdData = Changedouble(temp);
				thirds = new Serie(thirdName, thirdData);
				tempsave[2] = thirds;
				
				double[] tempb = init.pbl.getPlayerOneData(basicName,lineChartState,sm.getItem(�Ա���Ŀѡ��.getSelectedItem().toString()));
				basicData = Changedouble(tempb);
				basicline = new Serie(basicName, basicData);			

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
				ʮ��.setIcon(new ImageIcon("newpic//10��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//20��.png"));
				��ʮ��.setIcon(new ImageIcon("newpic//30��.png"));
				����.setIcon(new ImageIcon("newpic//������.png"));
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
		
		JButton ��Ա���� = new JButton("\u7403\u5458\u9884\u8BA1\u533A\u95F4");
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
}
