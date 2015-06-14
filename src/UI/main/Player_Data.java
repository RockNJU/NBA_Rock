package UI.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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


import javax.swing.JToolBar;

import UI.Player.SinglePlayer;
import UI.common.CreateTable;
import UI.common.History;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.common.SearchHistory;
import UI.common.SortItem_Map;
import VO.PlayerSeasonDataVO;

import javax.swing.JTextField;

import bl_db.common.Team_map;

public class Player_Data extends JPanel{
	JButton zongbiao=new JButton(new ImageIcon("newpic/hotbut/�÷�.jpg"));
	JButton defen=new JButton(new ImageIcon("newpic/hotbut/����.jpg"));
	JButton xiaolv=new JButton(new ImageIcon("newpic/hotbut/����.jpg"));
	JButton gaojie=new JButton(new ImageIcon("newpic/hotbut/��ñ.jpg"));
	JToolBar toolBar=new JToolBar();
	public static String[] types={"������","������"};
	public static JComboBox position;
	public static JComboBox partition;
	public static JComboBox playerseason;
	public static String seasontype="������";
	public static CreateTable playerdatalist;
	public static JComboBox according;
	public static JComboBox according_super;
	public static JComboBox signs;
	public static  JTextField num;
	public static  JTextField term1;
	public static  JTextField term2;
	public static  JTextField term3;
	public static JButton up1;
	public static JButton up2;
	public static JButton up3;
	public static  JButton choose;
	public static  JButton sort_super;
	public static JPanel choosep;
	public static JButton sort_terms;
	public static int choosetimes=0;
	static Team_map tm=new Team_map();
	SortPlayer spp;
	JButton sort;
	JButton sort_point;
	JButton sort_rebound;
	JButton sort_assist;
	static JButton normal;
	static JButton after;
	public static JRadioButton avg_tol;
	public static String a_t="avg";
	public static String butisclick="according"; 
	public static String[] playerAvgdatatitle = { "���", "����", "���", "����",
		"�ȷ�", "����", "����", "�÷�", "Ͷ��(%)", "����(%)",
		"����(%)", "����", "����", "����", "��ñ", "ʧ��",
		"����", "����", "Ч��", "GmScЧ��ֵ", "��ʵ������(%)", "Ͷ��Ч��",
		"������(%)", "����������(%)", "����������(%)", "������(%)", "������(%)", "��ñ��(%)",
		"ʧ����(%)", "ʹ����(%)","���峡�÷�����(%)","���峡��������(%)","���峡��������(%)","��˫��","��˫��"};
	public static String[] playerTotaldatatitle={ "���", "����", "���", "����",
		"�ȷ�", "����", "����", "�÷�", "Ͷ��(%)", "����(%)",
		"����(%)", "����", "����", "����", "��ñ", "ʧ��",
		"����", "����", "Ч��", "GmScЧ��ֵ", "��ʵ������(%)", "Ͷ��Ч��",
		"������(%)", "����������(%)", "����������(%)", "������(%)", "������(%)", "��ñ��(%)",
		"ʧ����(%)", "ʹ����(%)","���峡�÷�����(%)","���峡��������(%)","���峡��������(%)","��˫��","��˫��"};
	public static String[] avgtitle_point={"���", "����", "���", "����", "����", "�÷�",
	 "����", "��ñ", "ʧ��","����" ,"��˫��","��˫��","����","�ȷ�","����"};
	public static String[] avgtitle_rate={"���", "����", "���" ,"Ͷ��(%)", "����(%)","����(%)","��ʵ������(%)", 
		"Ͷ��Ч��" ,"������(%)","������(%)","������(%)", "��ñ��(%)","ʧ����(%)", "ʹ����(%)"};
	public static String[] avgtitle_higher={"���","����", "���", "Ч��", "GmScЧ��ֵ","������(%)", "����������(%)", "����������(%)",
		 "���峡�÷�����(%)","���峡��������(%)","���峡��������(%)"};
	public static Object[][] playerdata;
	public static ArrayList<PlayerSeasonDataVO> pdvo;
	
	SinglePlayer spi;
	
	public Player_Data(){

		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		
		/**
		 * ��Ա��λ��
		 */
		position = new JComboBox();
		position.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		position.setBounds(25, 15, 70, 30);
		position.setMaximumRowCount(100);
		position.setModel(new DefaultComboBoxModel(new String[] {
				"\u524D\u950B", "\u4E2D\u950B", "\u540E\u536B" }));
		position.setToolTipText("\u4F4D\u7F6E");
		position.setEditable(true);
		add(position);
		position.setVisible(true);
		
		/**
		 * ��Ա������ӵķ���
		 * 
		 */
		
		partition = new JComboBox();
		partition.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		partition.setToolTipText("\u6240\u5C5E\u7403\u961F\u5206\u533A");
		partition.setModel(new DefaultComboBoxModel(new String[] {"\u6240\u6709\u5206\u533A", "\u4E1C\u90E8", "\u897F\u90E8", "\u5927\u897F\u6D0B", "\u4E2D\u592E", "\u4E1C\u5357", "\u897F\u5357", "\u897F\u5317", "\u592A\u5E73\u6D0B"}));
		partition.setEditable(true);
		partition.setBounds(126, 15, 89, 30);
		add(partition);
		partition.setVisible(true);
		
		/**
		 * TODO ����
		 */
		playerseason = new JComboBox();
		playerseason.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		playerseason.setToolTipText("����");

		ArrayList<String> seasons = init.mbl.getAllSeason();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14����");
		}
		for (int o = 0; o < seasons.size(); o++) {
			playerseason.addItem(seasons.get(o));
		}
		playerseason.setEditable(true);
		playerseason.setBounds(243, 15, 89, 30);
		add(playerseason);
		playerseason.setVisible(true);
		
		/**
		 * TODO ������ʽ
		 */
		normal=new JButton(new ImageIcon("newpic/��������.png"));
		normal.setLocation(358, 15);
		normal.setSize(55, 30);
		add(normal);
		normal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/��������.png"));
				after.setIcon(new ImageIcon("newpic/������.png"));
				seasontype="������";
			}			
		});
		after=new JButton(new ImageIcon("newpic/������.png"));
		after.setLocation(413, 15);
		after.setSize(55, 30);
		add(after);
		after.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/������.png"));
				after.setIcon(new ImageIcon("newpic/��������.png"));
				seasontype="������";
			}			
		});
		/**
		 * ��Ա����ɸѡ���е�����
		 * 
		 */
		according = new JComboBox();
		according.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		according.setToolTipText("\u6392\u5E8F\u4F9D\u636E");
		according.setModel(new DefaultComboBoxModel(new String[] {"\u53C2\u8D5B\u573A\u6570", "\u5148\u53D1\u573A\u6570", "\u4E0A\u573A\u65F6\u95F4", "\u6295\u7BEE\u547D\u4E2D\u7387", "\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", "\u8FDB\u653B", "\u9632\u5B88", "\u62A2\u65AD", "\u76D6\u5E3D", "\u5931\u8BEF", "\u72AF\u89C4", "\u6548\u7387", "GmSc\u6548\u7387\u503C", "\u771F\u5B9E\u547D\u4E2D\u7387", "\u6295\u7BEE\u6548\u7387", "\u7BEE\u677F\u7387", "\u8FDB\u653B\u7BEE\u677F\u6570", "\u9632\u5B88\u7BEE\u677F\u6570", "\u52A9\u653B\u7387", "\u62A2\u65AD\u7387", "\u76D6\u5E3D\u7387", "\u5931\u8BEF\u7387", "\u4F7F\u7528\u7387", "\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387", "\u4E24\u53CC\u6570", "\u4E09\u53CC\u6570"}));
		according.setEditable(true);
		according.setBounds(25, 55, 86, 30);
		add(according);
		according.setVisible(true);
		
		/**
		 * ���ڵ��ڵ�ɸѡ
		 * 
		 */
		according_super = new JComboBox();
		according_super.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		according_super.setToolTipText("\u7B5B\u9009\u6761\u4EF6");
		according_super.setModel(new DefaultComboBoxModel(new String[] {"\u53C2\u8D5B\u573A\u6570", "\u5148\u53D1\u573A\u6570", "\u4E0A\u573A\u65F6\u95F4", "\u6295\u7BEE\u547D\u4E2D\u7387", "\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", "\u8FDB\u653B", "\u9632\u5B88", "\u62A2\u65AD", "\u76D6\u5E3D", "\u5931\u8BEF", "\u72AF\u89C4", "\u6548\u7387", "\u4E24\u53CC\u6570", "\u4E09\u53CC\u6570", "GmSc\u6548\u7387\u503C", "\u771F\u5B9E\u547D\u4E2D\u7387", "\u6295\u7BEE\u6548\u7387", "\u7BEE\u677F\u7387", "\u8FDB\u653B\u7BEE\u677F\u6570", "\u9632\u5B88\u7BEE\u677F\u6570", "\u52A9\u653B\u7387", "\u62A2\u65AD\u7387", "\u76D6\u5E3D\u7387", "\u5931\u8BEF\u7387", "\u4F7F\u7528\u7387", "\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387", "\u4E24\u53CC\u6570", "\u4E09\u53CC\u6570"}));
		according_super.setEditable(true);
		according_super.setBounds(522, 15, 105, 30);
		add(according_super);
		according_super.setVisible(true);
		
		/**
		 * ����
		 * 
		 */
		signs = new JComboBox();
		signs.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		signs.setToolTipText("\u7B5B\u9009\u6761\u4EF6");
		signs.setModel(new DefaultComboBoxModel(new String[] {">", "<", "��", "��", "="}));
		signs.setEditable(true);
		signs.setBounds(653, 15, 45, 30);
		add(signs);
		signs.setVisible(true);
		
		num = new JTextField();
		num.setBounds(723, 15, 104, 30);
		add(num);
		num.setColumns(10);
		
		
		final ImageIcon imageup = new ImageIcon("newpic/up.png");
		imageup.setImage(imageup.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));
		final ImageIcon imagedown = new ImageIcon("newpic/down.png");
		imagedown.setImage(imagedown.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));
		
		term1 = new JTextField();
		term1.setBounds(522, 55, 105, 30);
		add(term1);
		term1.setColumns(10);
		
		
		
		
		up1 =new JButton(imageup);
		up1.setFont(new Font("����", Font.PLAIN, 10));
		up1.setBounds(627, 62, 20,20);
		up1.setToolTipText("����");
		add(up1);
		up1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(up1.getToolTipText().equals("����")){
					up1.setIcon(imagedown);
					up1.setToolTipText("����");
				}else{
					up1.setIcon(imageup);
					up1.setToolTipText("����");
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
		
		
		term2 = new JTextField();
		term2.setBounds(660, 55, 105, 30);
		add(term2);
		term2.setColumns(10);
		
		up2 =new JButton(imageup);
		up2.setFont(new Font("����", Font.PLAIN, 10));
		up2.setBounds(765, 62, 20,20);
		up2.setToolTipText("����");
		add(up2);
		up2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(up2.getToolTipText().equals("����")){
					up2.setIcon(imagedown);
					up2.setToolTipText("����");
				}else{
					up2.setIcon(imageup);
					up2.setToolTipText("����");
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
		
		term3 = new JTextField();
		term3.setBounds(802, 55, 105, 30);
		add(term3);
		term1.setColumns(10);
		
		up3 =new JButton(imageup);
		up3.setFont(new Font("����", Font.PLAIN, 10));
		up3.setBounds(906, 62, 20,20);
		up3.setToolTipText("����");
		add(up3);
		up3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(up3.getToolTipText().equals("����")){
					up3.setIcon(imagedown);
					up3.setToolTipText("����");
				}else{
					up3.setIcon(imageup);
					up3.setToolTipText("����");
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
		final ImageIcon image9 = new ImageIcon("newpic/ɸѡ-ɸѡ.png");
		image9.setImage(image9.getImage().getScaledInstance(75, 25,Image.SCALE_DEFAULT));
		final ImageIcon image10 = new ImageIcon("newpic/ɸѡ-ɸѡ��.png");
		image10.setImage(image10.getImage().getScaledInstance(75, 25,Image.SCALE_DEFAULT));
		
		sort_terms=new JButton();
		sort_terms = new JButton(image9);
		sort_terms.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort_terms.setBounds(940, 57, 75, 25);
		add(sort_terms);
		sort_terms.setContentAreaFilled(false);
		sort_terms.setVisible(true);
		sort_terms.addMouseListener(new MouseListener() {
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
				sort_terms.setIcon(image9);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort_terms.setIcon(image10);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				termsort();
			
			}

		});
		
		//1037 164
		//choosep.setLocation(537, 84);
		//add(choosep);
		//choosep.setVisible(false);
		
		choose =new JButton(new ImageIcon("newpic/set.png"));
		choose.setFont(new Font("����", Font.PLAIN, 10));
		choose.setBounds(1018, 63, 20,20);
		add(choose);
		choose.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				choosetimes++;
				if(choosetimes%2==1){
					spp=new SortPlayer();
					spp.setLocation(init.SysStart_X+537, init.SysStart_Y+164);
					spp.setVisible(true);
					term1.setText("");
					term2.setText("");
					term3.setText("");
				}else{
					spp.dispose();
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
		
		avg_tol = new JRadioButton("\u573A\u5747\u6570\u636E");
		avg_tol.setFont(new Font("����ϸ��", Font.PLAIN, 14));
		avg_tol.setSelected(true);
		avg_tol.setBounds(949, 15, 90, 30);
		add(avg_tol);
		avg_tol.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(avg_tol.isSelected()){
					a_t="avg";
					if(butisclick.equals("according")){
						playerdata=getAveragedata(pdvo);
						playerdatalist.updateTable(playerAvgdatatitle, playerdata);
						playerdatalist.FitTableColumns(playerdatalist.getTable());
						playerdatalist.setcolor(getcl(according.getSelectedItem().toString()));
					}else{
						playerdata=getAveragedata(pdvo);
						playerdatalist.updateTable(playerAvgdatatitle, playerdata);
						playerdatalist.FitTableColumns(playerdatalist.getTable());
						playerdatalist.setcolor(getcl(butisclick));
					}			
				}else{
					a_t="total";
					if(butisclick.equals("according")){
						playerdata=getTotaldata(pdvo);
						playerdatalist.updateTable(playerTotaldatatitle, playerdata);
						playerdatalist.FitTableColumns(playerdatalist.getTable());
						playerdatalist.setcolor(getcl(according.getSelectedItem().toString()));
					}else{
						playerdata=getTotaldata(pdvo);
						playerdatalist.updateTable(playerTotaldatatitle, playerdata);
						playerdatalist.FitTableColumns(playerdatalist.getTable());
						playerdatalist.setcolor(getcl(butisclick));
					}
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
		
		final ImageIcon image1 = new ImageIcon("newpic/ɸѡ-�÷�.png");
		image1.setImage(image1.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		final ImageIcon image2 = new ImageIcon("newpic/ɸѡ-�÷ָ�.png");
		image2.setImage(image2.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image3 = new ImageIcon("newpic/ɸѡ-����.png");
		image3.setImage(image3.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image4 = new ImageIcon("newpic/ɸѡ-������.png");
		image4.setImage(image4.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image5 = new ImageIcon("newpic/ɸѡ-����.png");
		image5.setImage(image5.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image6 = new ImageIcon("newpic/ɸѡ-���帡.png");
		image6.setImage(image6.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image7 = new ImageIcon("newpic/ɸѡ-ɸѡ.png");
		image7.setImage(image7.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		final ImageIcon image8 = new ImageIcon("newpic/ɸѡ-ɸѡ��.png");
		image8.setImage(image8.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		
		
		
		sort_point = new JButton(image1);
		sort_point.setToolTipText("ɸѡ�÷ֿ�ݰ�ť");
		sort_point.setBounds(136, 55, 60, 24);
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
				butisclick= "�÷�";      
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = "�÷�";
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				avg_tol.setSelected(true);
				pdvo = init.pbl.sort(Season,seasontype,Position, Partition, According);
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
		sort_rebound.setToolTipText("ɸѡ�����ݰ�ť");
		sort_rebound.setBounds(218, 55, 60, 24);
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
				butisclick= "����";
            	
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = "����";
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, seasontype,Position, Partition, According);
			    playerdata = getAveragedata(pdvo);
			
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);
				playerdatalist.setcolor(5);
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}

		});
		sort_assist = new JButton(image3);
		sort_assist.setToolTipText("ɸѡ������ݰ�ť");
		sort_assist.setBounds(301, 55, 60, 24);
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
				butisclick= "����";
				avg_tol.setSelected(true);
            	//������ʷ��¼			
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = "����";
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, seasontype,Position, Partition, According);
				playerdata = getAveragedata(pdvo);
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);
				
				playerdatalist.FitTableColumns(playerdatalist.getTable());
				playerdatalist.setcolor(6);
			}

		});
		sort = new JButton(image7);
		sort.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort.setBounds(384, 54, 75, 27);
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
				butisclick= "according";
            	String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = according.getSelectedItem().toString();
				String Season = playerseason.getSelectedItem().toString()
						.substring(0, 5);
				SortItem_Map map3 = new SortItem_Map();
				According = map3.getItem(According);
				pdvo = init.pbl.sort(Season, seasontype,Position, Partition, According);
				playerdata = getAveragedata(pdvo);			
				avg_tol.setSelected(true);
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);		
				int x=getcl(according.getSelectedItem().toString());
				playerdatalist.setcolor(x);
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}

		});
		
		sort_super = new JButton(image7);
		sort_super.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort_super.setBounds(850, 16, 75, 27);
		add(sort_super);
		sort_super.setContentAreaFilled(false);
		sort_super.setVisible(true);
		sort_super.addMouseListener(new MouseListener() {
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
				sort_super.setIcon(image7);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort_super.setIcon(image8);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				butisclick= "according";
					String Position = position.getSelectedItem().toString();
					String Partition = partition.getSelectedItem().toString();				
					PlayerPosition_Map map1 = new PlayerPosition_Map();
					PartitionMap map2 = new PartitionMap();
					SortItem_Map map3 = new SortItem_Map();
					Position = map1.getItem(Position);
					Partition = map2.getItem(Partition);			
				String According = according_super.getSelectedItem().toString();
				String Season = playerseason.getSelectedItem().toString().substring(0, 5);
				
				According = map3.getItem(According);
				
				pdvo = init.pbl.sort_super(Season, seasontype,Position,Partition, According, signs.getSelectedItem().toString(),Integer.parseInt(num.getText()));
				playerdata = getAveragedata(pdvo);
				avg_tol.setSelected(true);
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);		
				int x=getcl(according.getSelectedItem().toString());
				playerdatalist.setcolor(x);
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}

		});
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 104, 1040, 25);
		toolBar.setOpaque(false);
		
		toolBar.add(zongbiao);
		toolBar.add(defen);
		toolBar.add(xiaolv);
		toolBar.add(gaojie);
		add(toolBar);
		//һ����� 
		zongbiao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerdata = getAveragedata(pdvo);
				avg_tol.setSelected(true);
				playerdatalist.updateTable(playerAvgdatatitle, playerdata);		
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}
		});
		defen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerdata = getAveragedata_ForPoints(pdvo);
				avg_tol.setSelected(true);
				playerdatalist.updateTable(avgtitle_point, playerdata);		
				playerdatalist.newFitTableColumns(playerdatalist.getTable());
				
				//changl();
			}
		});
		xiaolv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerdata = getAveragedata_ForRate(pdvo);
				avg_tol.setSelected(true);
				playerdatalist.updateTable(avgtitle_rate, playerdata);		
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}
		});
		gaojie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerdata = getAveragedata_ForHigher(pdvo);
				avg_tol.setSelected(true);
				playerdatalist.updateTable(avgtitle_higher, playerdata);		
				playerdatalist.FitTableColumns(playerdatalist.getTable());
			}
		});
		pdvo=init.pbl.getPlayerSeasonData(init.defaultseason);
		playerdata=getAveragedata(pdvo);
		playerdatalist = new CreateTable(playerAvgdatatitle, playerdata, 10, 135,1040, 445, 25,
				new Font("����", 0, 15), new Font("Dialog", 0, 12));
		add(playerdatalist);
		playerdatalist.FitTableColumns(playerdatalist.getTable());
		// ˫��������Ա����
				playerdatalist.getTable().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// System.out.println(playerlist.getSelectedRow()!=-1);
						// System.out.println(e.getClickCount() == 2);
						// TODO Auto-generated method stub
						if (e.getClickCount() == 2 && playerdatalist.getSelectedRow() != -1) {
							
							String name = playerdatalist.getValueAt(playerdatalist.getSelectedRow(), 1);
							// System.out.println(name);
							
							spi = new SinglePlayer(name);
							spi.setVisible(true);
							spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);
						}
						
					}
				});
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 10, 1040, 82);
		add(menubg);
		menubg.setOpaque(true);
		
		
	}
	
	public static Object[][] getAveragedata(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null||da.size()==0) {
			Object[][] re = new Object[1][35];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "û����Ϣ";
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
			re[0][33]="";
			re[0][34]="";
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][35];
			/*
			 * {"���","��Ա����","�������","��������","�ȷ�����",
			 * "������","������","�ڳ�ʱ��","Ͷ��������","����������","����������",
			 * "������","������","������","��ñ��","ʧ����","������","�÷�","Ч��",
			 * "GmScЧ��ֵ","��ʵ������","Ͷ��Ч��","������","����������","����������",
			 * "������","������","��ñ��","ʧ����","ʹ����"};
			 */
			// TeamMap temp=new TeamMap();
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] = tm.getFullName(da.get(i).getTeamName());
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
				
				re[i][33]=   da.get(i).getDoubleNum();
				re[i][34]=   da.get(i).getThreeNum();
			}
			return re;

		}

		
		
	}
	public static Object[][] getTotaldata(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][35];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "û����Ϣ";
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
			re[0][33]="";
			re[0][34]="";
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][35];
			/*
			 * {"���","��Ա����","�������","��������","�ȷ�����",
			 * "������","������","�ڳ�ʱ��","Ͷ��������","����������","����������",
			 * "������","������","������","��ñ��","ʧ����","������","�÷�","Ч��",
			 * "GmScЧ��ֵ","��ʵ������","Ͷ��Ч��","������","����������","����������",
			 * "������","������","��ñ��","ʧ����","ʹ����"};
			 */
			// TeamMap temp=new TeamMap();
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] = tm.getFullName(da.get(i).getTeamName());
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
				re[i][33]=   da.get(i).getSeasonDoubleNum();
				re[i][34]=   da.get(i).getSeasonThreeNum();
			}
			return re;
		}
	}

	public static Object[][] getAveragedata_ForPoints(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null||da.size()==0) {
			Object[][] re = new Object[1][15];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "û����Ϣ";
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
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][15];		
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] =tm.getFullName( da.get(i).getTeamName());
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getPointNum_avg());			
				re[i][6] = OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][8] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][9] = OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());
				re[i][10]=   da.get(i).getDoubleNum();
				re[i][11]=   da.get(i).getThreeNum();
				re[i][12] = da.get(i).getMatchNum();
				re[i][13] = da.get(i).getStartingNum();
				re[i][14] = OftenUseMethod.changedouble(da.get(i).getTime_avg());
			}
			return re;

		}

		
		
	}
	public static Object[][] getAveragedata_ForRate(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null||da.size()==0) {
			Object[][] re = new Object[1][14];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "û����Ϣ";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			re[0][11] = "";
			re[0][12] = "";
			re[0][13] = "";
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][14];
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] = tm.getFullName(da.get(i).getTeamName());
				re[i][3] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));				
				re[i][4] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][5] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][6] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getRealShootPercentage()));
				re[i][7] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootEfficiency()));
				re[i][8] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getReboundEfficiency()));
				re[i][9] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getAssistEfficiency()));
				re[i][10] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getStealEfficiency()));
				re[i][11] = (OftenUseMethod.changedouble(da.get(i).getBlockEfficiency()));
				re[i][12] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getTurnoverPercentage()));
				re[i][13] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getUsingPercentage()));			
			}
			return re;

		}

		
		
	}
	
	
	public static Object[][] getAveragedata_ForHigher(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null||da.size()==0) {

			Object[][] re = new Object[1][11];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "û����Ϣ";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			return re;
		} else {
			int length=50;
			if(da.size()<50){
				length=da.size();
			}
			Object[][] re = new Object[length][11];
			for (int i = 0; i <length; i++) {
				re[i][0] = Player_Info.changenumber(i + 1);
				re[i][1] = da.get(i).getName();
				re[i][2] = tm.getFullName(da.get(i).getTeamName());		
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getEfficiency());
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getGmSc());
				re[i][5] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getReboundEfficiency()));
				re[i][6] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getOffensiveReboundEff()));
				re[i][7] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getDefenseReboundEff()));			
				re[i][8] = (OftenUseMethod.changedouble(da.get(i).getL_f_point_rate()));
				re[i][9] = (OftenUseMethod.changedouble(da.get(i).getL_f_assist_rate()));
				re[i][10] = (OftenUseMethod.changedouble(da.get(i).getL_f_rebound_rate()));
				
			}
			return re;
		}

		
		
	}
	static int getcl(String name){
		if(name.equals("��������")){
			return 3;
		}else if(name.equals("�ȷ�����")){
			return 4;
		}else if(name.equals("�÷�")){
			return 7;
		}else if(name.equals("����")){
			return 5;
		}else if(name.equals("����")){
			return 6;
		}else if(name.equals("�ϳ�ʱ��")){
			return 17;
		}else if(name.equals("Ͷ��������")){
			return 8;
		}else if(name.equals("����������")){
			return 9;
		}else if(name.equals("����������")){
			return 10;
		}else if(name.equals("����")){
			return 11;
		}else if(name.equals("����")){
			return 12;
		}else if(name.equals("����")){
			return 13;
		}else if(name.equals("��ñ")){
			return 14;
		}else if(name.equals("ʧ��")){
			return 15;
		}else if(name.equals("����")){
			return 16;
		}else if(name.equals("Ч��")){
			return 18;
		}else if(name.equals("��˫��")){
			return 33;
		}else if(name.equals("��˫��")){
			return 34;
		}else if(name.equals("GmScЧ��ֵ")){
			return 19;
		}else if(name.equals("��ʵ������")){
			return 20;
		}else if(name.equals("Ͷ��Ч��")){
			return 21;
		}else if(name.equals("������")){
			return 22;
		}else if(name.equals("����������")){
			return 23;
		}else if(name.equals("����������")){
			return 24;
		}else if(name.equals("������")){
			return 25;
		}else if(name.equals("������")){
			return 26;
		}else if(name.equals("��ñ��")){
			return 27;
		}else if(name.equals("ʧ����")){
			return 28;
		}else if(name.equals("ʹ����")){
			return 29;
		}else if(name.equals("���峡�÷�������")){
			return 30;
		}else if(name.equals("���峡����������")){
			return 31;
		}else if(name.equals("���峡����������")){
			return 32;
		}else {
			return -1;
		}		
	}
	
	public static void do_this_whenclick(String text) {
		if (term1.getText().equals("")) {
			term1.setText(text);
			
		} else if (term2.getText().equals("")&&(!term1.getText().equals(text))) {
			term2.setText(text);
			
		} else if (term3.getText().equals("")&&(!term2.getText().equals(text))&&(!term1.getText().equals(text))) {
			term3.setText(text);
			
		} else{}
			
	}

	public static void termsort() {
		// TODO Auto-generated method stub	
		String[] textforsort = {null,null,null};
		boolean[] upordown = {true,true,true};
		boolean isaverage = avg_tol.isSelected();
		SortItem_Map map = new SortItem_Map();
		
		
		if(!term1.getText().equals("")){
			textforsort[0] = map.getItem(term1.getText());
			if(up1.getToolTipText().equals("����")){
				upordown[0] = false;
			}
		}
		else{
			textforsort[0] = map.getItem("��������");
		}
		if(!term2.getText().equals("")){
			textforsort[1] = map.getItem(term2.getText());
			if(up2.getToolTipText().equals("����")){
				upordown[1] = false;
			}
		}else{
			textforsort[0] = map.getItem("�÷�");
		}
		if(!term3.getText().equals("")){
			textforsort[2] = map.getItem(term3.getText());
			if(up3.getToolTipText().equals("����")){
				upordown[2] = false;
			}
		}else{
			textforsort[0] = map.getItem("����");
		}
		String Position = position.getSelectedItem().toString();
		String Partition = partition.getSelectedItem().toString();
		String Season = playerseason.getSelectedItem().toString().substring(0, 5);
		String Type=seasontype;
		PlayerPosition_Map map1 = new PlayerPosition_Map();
		PartitionMap map2 = new PartitionMap();
		Position = map1.getItem(Position);
		Partition = map2.getItem(Partition);
		if(isaverage == true){		
			pdvo = init.pbl.sort(Season,Type, Position, Partition,textforsort,upordown);
			playerdata = getAveragedata(pdvo);
			playerdatalist.updateTable(playerAvgdatatitle, playerdata);
			playerdatalist.FitTableColumns(playerdatalist.getTable());
		}
		else{
			
			pdvo = init.pbl.sort(Season,Type, Position, Partition, textforsort,upordown);
			playerdata = getTotaldata(pdvo);
			playerdatalist.updateTable(playerTotaldatatitle, playerdata);
			playerdatalist.FitTableColumns(playerdatalist.getTable());
		}
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(getcl(term1.getText()));
		c.add(getcl(term2.getText()));
		c.add(getcl(term3.getText()));
		playerdatalist.setcolors(c);
	}
	static void changl(){
		playerdatalist.setNthWidth(0, 50);
		playerdatalist.setNthWidth(3, 70);
		playerdatalist.setNthWidth(4, 70);
		playerdatalist.setNthWidth(5, 70);			
		playerdatalist.setNthWidth(6, 70);

		playerdatalist.setNthWidth(7, 70);
		playerdatalist.setNthWidth(8, 70);
		playerdatalist.setNthWidth(9, 70);
		
		playerdatalist.setNthWidth(10, 70);
		playerdatalist.setNthWidth(11, 70);
		playerdatalist.setNthWidth(12, 70);
		playerdatalist.setNthWidth(13, 70);
		playerdatalist.setNthWidth(14, 100);
	}
}
