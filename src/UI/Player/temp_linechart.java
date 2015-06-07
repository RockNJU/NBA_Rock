package UI.Player;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Icon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.data.category.DefaultCategoryDataset;

import businessService.blservice.PlayerBLService;
import UI.blObject.RMIObject;
import UI.common.ChartUtils;
import UI.common.Serie;
import VO.PlayerSeasonDataVO;
import VO.PlayerVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class temp_linechart extends JFrame {
	
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
	
	String chossenShowData = "�÷�";
	String[] categories =  { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	String basicName = "Tokyo";
	String firstName = "New York";
	String secondName = "London";
	String thirdName = "bitch";
	String fourthName = "Berlin";
	Double[] basicData = { 49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 };
	Double[] firstData =  { 83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3 };
	Double[] secondData = { 48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2 };
	Double[] thirdData =  { 12.2, 14.2, 18.5, 50.2,26.2, 37.4, 39.5,23.1, 47.6, 39.1, 46.8, 51.1 };
	Double[] fourtaData =  { 42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 28.5, 58.1, 30.6,68.2 };
	Serie basicline = new Serie(basicName, basicData);
	Serie firsts = new Serie(firstName, firstData);
	Serie seconds = new Serie(secondName, secondData);
	Serie thirds = new Serie(thirdName, thirdData);
	Serie fourths = 	new Serie(fourthName, fourtaData);
	boolean[] lineisshowed = {false,false,false,false};
	Serie[] tempsave = {firsts,seconds,thirds,fourths};
	
	String lineChartState = "10���Ա�";//ѡ��Ŀ�����10��20,30������
	
	LineChart lc = new LineChart();
	ChartPanel chartPanel = lc.createChart();//�·�ͼ��
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp_linechart frame = new temp_linechart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public temp_linechart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060,620 );
		
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1042, 580);
		contentPane.setBackground(new Color(183,221,222));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//�·��߱�
		contentPane.add(chartPanel);
		
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
				//�������޸ĳɶ�Ӧ��
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
			public void actionPerformed(ActionEvent e) {
				//���Ըı��Աѡ���п�ѡ�������
				��Աѡ��3.setModel(new DefaultComboBoxModel(new String[] {����ѡ��3.getSelectedItem().toString()}));
			}
		});
		����ѡ��3.setModel(new DefaultComboBoxModel(new String[] {"temp","test"}));
		����ѡ��3.setBounds(644, 10, 75, 23);
		contentPane.add(����ѡ��3);


		ʮ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡ��ǰѡ����Ա��������Ϣ��Ӧ
				categories = new String[10];
				for(int i = 1; i<=10;i++){
					categories[i-1] = String.valueOf(i);
				}
				lineChartState = "10�������Ա�";			//�޸�����
				
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
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
				//��ȡ��ǰѡ����Ա��������Ϣ��Ӧ
				categories = new String[20];
				for(int i = 1; i<=20;i++){
					categories[i-1] = String.valueOf(i);
				}
				lineChartState = "20�������Ա�";
				//�޸�����
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
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
				categories = new String[30];
				for(int i = 1; i<=30;i++){
					categories[i-1] = String.valueOf(i);
				}
				lineChartState = "30�������Ա�";
				//�޸�����
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
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
		
		JComboBox �Ա���Ŀѡ�� = new JComboBox();
		�Ա���Ŀѡ��.setBounds(10, 40, 224, 23);
		contentPane.add(�Ա���Ŀѡ��);
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ߵõ����ݣ�Ȼ���޸�
				lineChartState = "�����Ա�";
				chartPanel.getChart().getCategoryPlot().setDataset(lc.createDataset());
				chartPanel.getChart().fireChartChanged();
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
		
	
		
		}
	

	public class LineChart {
		public LineChart() {
		}

		public DefaultCategoryDataset createDataset() {
				Vector<Serie> series = new Vector<Serie>();
			// �������ƣ��������е�ֵ����
			series.add(basicline);
			for(int i = 0; i<4;i++){
				if(lineisshowed[i]!=false){
					series.add(tempsave[i]);
				}
			}
			DefaultCategoryDataset dataset = ChartUtils.createDefaultCategoryDataset(series, categories);
			return dataset;
		}

		public ChartPanel createChart() {
			// 2������Chart[������ͬͼ��]
			JFreeChart chart = ChartFactory.createLineChart(chossenShowData+"��"+lineChartState, "����", "", createDataset());
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
	}