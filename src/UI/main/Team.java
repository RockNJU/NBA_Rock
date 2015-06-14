package UI.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import bl_db.common.Team_map;
import UI.Team.SingleTeam;
import UI.common.CreateTable;
import UI.common.History;
import UI.common.OftenUseMethod;
import UI.common.SearchHistory;
import UI.common.SortItem_Map;
import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;

public class Team extends JPanel{
	JButton allteams;
	final JButton find;
	JButton zongbiao=new JButton(new ImageIcon("newpic/hotbut/得分.jpg"));
	JButton defen=new JButton(new ImageIcon("newpic/hotbut/篮板.jpg"));
	JButton xiaolv=new JButton(new ImageIcon("newpic/hotbut/助攻.jpg"));
	JButton gaojie=new JButton(new ImageIcon("newpic/hotbut/盖帽.jpg"));
	JToolBar toolBar=new JToolBar();
	public static JComboBox Teamseason;
	public static String seasontype;
	JButton normal,after;
	public JComboBox according;
	public JComboBox according_super;
	public JComboBox signs;
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
	SortTeam spp;
	JButton sort;
	JButton sort_point;
	JButton sort_rebound;
	JButton sort_assist;
	public static String butisclick="according"; 	
	public static JTextField textField;
	public static ArrayList<TeamSeasonDataVO> tdvo;
	public static Object[][] teamdata;
	public static JRadioButton avg_tol;
	
	public static int times;
	public static AllTeams atd;

	Team_map my=new Team_map();
	public SingleTeam spi;
	public static CreateTable teamdatalist;
	public static String[] teamtitle={"序号","球队","得分","篮板","助攻","三分命中数",
		"三分出手数","罚球命中数","罚球出手数","投篮命中数","投篮出手数","进攻篮板数","防守篮板数",
		"抢断","盖帽","失误","犯规","比赛场数","投篮(%)","三分(%)","罚球(%)",
		"胜率","进攻回合","防守回合","进攻效率","防守效率","进攻篮板率","防守篮板率","抢断率","助攻率"};

	public static String[] teamtitle_point={"序号","球队","得分","篮板","助攻","抢断","盖帽","失误","犯规","比赛场数"};
	public static String[] teamtitle_shoot={"序号","球队","三分命中数","三分出手数","罚球命中数","罚球出手数","投篮命中数","投篮出手数","投篮(%)","三分(%)","罚球(%)"};
	public static String[] teamtitle_rate={"序号","球队","胜率","进攻回合","防守回合","进攻效率","防守效率","进攻篮板率","防守篮板率","抢断率","助攻率"};
	
	public Team(){
		setLayout(null);
		setSize(1060, 639);
		setOpaque(false);
		
		
		
		/**
		 * TODO 赛季
		 */
		Teamseason = new JComboBox();
		Teamseason.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Teamseason.setToolTipText("赛季");

		ArrayList<String> seasons = init.mbl.getAllSeason();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			Teamseason.addItem(seasons.get(o));
		}
		Teamseason.setEditable(true);
		Teamseason.setBounds(25, 46, 117, 30);
		add(Teamseason);
		Teamseason.setVisible(true);
		
		/**
		 * TODO 赛季形式
		 */
		normal=new JButton(new ImageIcon("newpic/常规赛浮.png"));
		normal.setLocation(256, 46);
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
		after.setLocation(311, 46);
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
		
		/**
		 * 进行筛选排列的依据
		 * 
		 */
		according = new JComboBox();
		according.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		according.setToolTipText("\u6392\u5E8F\u4F9D\u636E");
		according.setModel(new DefaultComboBoxModel(new String[] {"\u6295\u7BEE\u51FA\u624B\u6570", "\u6295\u7BEE\u547D\u4E2D\u6570", "\u4E09\u5206\u547D\u4E2D\u6570", "\u4E09\u5206\u51FA\u624B\u6570", "\u7F5A\u7403\u547D\u4E2D\u6570", "\u7F5A\u7403\u51FA\u624B\u6570", "\u8FDB\u653B\u7BEE\u677F", "\u9632\u5B88\u7BEE\u677F", "\u62A2\u65AD", "\u76D6\u5E3D", "\u5931\u8BEF", "\u72AF\u89C4", "\u6295\u7BEE\u547D\u4E2D\u7387", "\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", "\u80DC\u7387", "\u8FDB\u653B\u56DE\u5408", "\u8FDB\u653B\u6548\u7387", "\u9632\u5B88\u6548\u7387", "\u8FDB\u653B\u7BEE\u677F\u7387", "\u9632\u5B88\u7BEE\u677F\u7387", "\u62A2\u65AD\u7387", "\u52A9\u653B\u7387"}));
		according.setEditable(true);
		according.setBounds(152, 46, 94, 30);
		add(according);
		according.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(950, 12, 66, 25);
		add(textField);
		textField.setColumns(10);
				
		find = new JButton(new ImageIcon("newpic/查找.png"));
		find.setBackground(init.syslightblue);
		find.setFocusPainted(false);
		find.setOpaque(false);
		find.setBounds(1020,12, 25, 25);
		
		find.setToolTipText("查询");		
		this.add(find);
		
		find.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tdvo=init.tbl.find(textField.getText());
				teamdata=getAveragedata(tdvo);
				teamdatalist.updateTable(teamtitle, teamdata);
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
		
		allteams = new JButton(new ImageIcon("newpic/所有球队前.png"));
		allteams.setToolTipText("");
		allteams.setBounds(36,15, 94, 20);
		add(allteams);
		
		
		allteams.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				times++;
				if(times%2==1){
					atd=new AllTeams();
					atd.setLocation(init.SysStart_X+42, init.SysStart_Y+87);
					atd.setVisible(true);
				}else{
					atd.dispose();
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
				
				allteams.setIcon(new ImageIcon("newpic/所有球队浮.png"));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
				allteams.setIcon(new ImageIcon("newpic/所有球队前.png"));
				
			}
			
		});
		
		avg_tol = new JRadioButton("\u573A\u5747\u6570\u636E");
		avg_tol.setFont(new Font("华文细黑", Font.PLAIN, 14));
		avg_tol.setSelected(true);
		avg_tol.setBounds(949, 46, 90, 30);
		add(avg_tol);
		avg_tol.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(avg_tol.isSelected()){					
					teamdata=getAveragedata(tdvo);
					teamdatalist.updateTable(teamtitle, teamdata);
					teamdatalist.FitTableColumns(teamdatalist.getTable());
					teamdatalist.setcolor(getcl(butisclick));
				}else{
					teamdata=getTotaldata(tdvo);
					teamdatalist.updateTable(teamtitle, teamdata);
					teamdatalist.FitTableColumns(teamdatalist.getTable());
					teamdatalist.setcolor(getcl(butisclick));
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
		
		/**
		 * 大于等于的筛选
		 * 
		 */
		according_super = new JComboBox();
		according_super.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		according_super.setToolTipText("\u7B5B\u9009\u6761\u4EF6");
		according_super.setModel(new DefaultComboBoxModel(new String[] {"\u53C2\u8D5B\u573A\u6570", "\u5148\u53D1\u573A\u6570", "\u4E0A\u573A\u65F6\u95F4", "\u6295\u7BEE\u547D\u4E2D\u7387", "\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", "\u8FDB\u653B", "\u9632\u5B88", "\u62A2\u65AD", "\u76D6\u5E3D", "\u5931\u8BEF", "\u72AF\u89C4", "\u6548\u7387", "\u4E24\u53CC\u6570", "\u4E09\u53CC\u6570", "GmSc\u6548\u7387\u503C", "\u771F\u5B9E\u547D\u4E2D\u7387", "\u6295\u7BEE\u6548\u7387", "\u7BEE\u677F\u7387", "\u8FDB\u653B\u7BEE\u677F\u6570", "\u9632\u5B88\u7BEE\u677F\u6570", "\u52A9\u653B\u7387", "\u62A2\u65AD\u7387", "\u76D6\u5E3D\u7387", "\u5931\u8BEF\u7387", "\u4F7F\u7528\u7387", "\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387", "\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387", "\u4E24\u53CC\u6570", "\u4E09\u53CC\u6570"}));
		according_super.setEditable(true);
		according_super.setBounds(470, 46, 105, 30);
		add(according_super);
		according_super.setVisible(true);
		
		/**
		 * 符号
		 * 
		 */
		signs = new JComboBox();
		signs.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		signs.setToolTipText("\u7B5B\u9009\u6761\u4EF6");
		signs.setModel(new DefaultComboBoxModel(new String[] {">", "<", "≥", "≤", "="}));
		signs.setEditable(true);
		signs.setBounds(601, 46, 45, 30);
		add(signs);
		signs.setVisible(true);
		
		num = new JTextField();
		num.setBounds(671, 46, 104, 30);
		add(num);
		num.setColumns(10);
		
		
		
		final ImageIcon imageup = new ImageIcon("newpic/up.png");
		imageup.setImage(imageup.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));
		final ImageIcon imagedown = new ImageIcon("newpic/down.png");
		imagedown.setImage(imagedown.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));
		
		term1 = new JTextField();
		term1.setBounds(470, 86, 105, 30);
		add(term1);
		term1.setColumns(10);
		
		
		
		
		up1 =new JButton(imageup);
		up1.setFont(new Font("宋体", Font.PLAIN, 10));
		up1.setBounds(575, 93, 20,20);
		up1.setToolTipText("升序");
		add(up1);
		up1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(up1.getToolTipText().equals("升序")){
					up1.setIcon(imagedown);
					up1.setToolTipText("降序");
				}else{
					up1.setIcon(imageup);
					up1.setToolTipText("升序");
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
		term2.setBounds(608, 86, 105, 30);
		add(term2);
		term2.setColumns(10);
		
		up2 =new JButton(imageup);
		up2.setFont(new Font("宋体", Font.PLAIN, 10));
		up2.setBounds(713, 93, 20,20);
		up2.setToolTipText("升序");
		add(up2);
		up2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(up2.getToolTipText().equals("升序")){
					up2.setIcon(imagedown);
					up2.setToolTipText("降序");
				}else{
					up2.setIcon(imageup);
					up2.setToolTipText("升序");
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
		term3.setBounds(750, 86, 105, 30);
		add(term3);
		term1.setColumns(10);
		
		up3 =new JButton(imageup);
		up3.setFont(new Font("宋体", Font.PLAIN, 10));
		up3.setBounds(854, 93, 20,20);
		up3.setToolTipText("升序");
		add(up3);
		up3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(up3.getToolTipText().equals("升序")){
					up3.setIcon(imagedown);
					up3.setToolTipText("降序");
				}else{
					up3.setIcon(imageup);
					up3.setToolTipText("升序");
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
		final ImageIcon image9 = new ImageIcon("newpic/筛选-筛选.png");
		image9.setImage(image9.getImage().getScaledInstance(75, 25,Image.SCALE_DEFAULT));
		final ImageIcon image10 = new ImageIcon("newpic/筛选-筛选浮.png");
		image10.setImage(image10.getImage().getScaledInstance(75, 25,Image.SCALE_DEFAULT));
		
		sort_terms=new JButton();
		sort_terms = new JButton(image9);
		sort_terms.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort_terms.setBounds(888, 88, 75, 25);
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
            	//保存历史记录
				termsort();
			}

		});
		
		//1037 164
		//choosep.setLocation(537, 84);
		//add(choosep);
		//choosep.setVisible(false);
		
		choose =new JButton(new ImageIcon("newpic/set.png"));
		choose.setFont(new Font("宋体", Font.PLAIN, 10));
		choose.setBounds(970, 91, 20,20);
		add(choose);
		choose.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				choosetimes++;
				if(choosetimes%2==1){
					spp=new SortTeam();
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
		
		final ImageIcon image1 = new ImageIcon("newpic/筛选-得分.png");
		image1.setImage(image1.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		final ImageIcon image2 = new ImageIcon("newpic/筛选-得分浮.png");
		image2.setImage(image2.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image3 = new ImageIcon("newpic/筛选-助攻.png");
		image3.setImage(image3.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image4 = new ImageIcon("newpic/筛选-助攻浮.png");
		image4.setImage(image4.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image5 = new ImageIcon("newpic/筛选-篮板.png");
		image5.setImage(image5.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image6 = new ImageIcon("newpic/筛选-篮板浮.png");
		image6.setImage(image6.getImage().getScaledInstance(60, 24,Image.SCALE_DEFAULT));
		
		final ImageIcon image7 = new ImageIcon("newpic/筛选-筛选.png");
		image7.setImage(image7.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		final ImageIcon image8 = new ImageIcon("newpic/筛选-筛选浮.png");
		image8.setImage(image8.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		
		sort_point = new JButton(image1);
		sort_point.setToolTipText("筛选得分快捷按钮");
		sort_point.setBounds(25, 89, 60, 24);
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
				avg_tol.setSelected(true);
				butisclick= "得分";
            	
				
				// TODO
				
					String According = "得分";
					String Season =Teamseason.getSelectedItem().toString().substring(0, 5);			
					SortItem_Map map3 = new SortItem_Map();
					According = map3.getItem(According);			
					tdvo = init.tbl.sort(Season, seasontype,According);
					teamdata = getAveragedata(tdvo);
					/*init.currenttext=null;
					init.currentunordown=null; 
					init.currentisaverage=false;
					init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
					System.out.println(init.currentpanel);*/
					teamdatalist.updateTable(teamtitle, teamdata);
					teamdatalist.setcolor(getcl("得分"));
					teamdatalist.FitTableColumns(teamdatalist.getTable());
			}

		});
		sort_rebound = new JButton(image5);
		sort_rebound.setToolTipText("筛选篮板快捷按钮");
		sort_rebound.setBounds(107, 89, 60, 24);
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
				butisclick= "篮板";
				avg_tol.setSelected(true);
            
				
				// TODO
					String According = "篮板";
					String Season =Teamseason.getSelectedItem().toString().substring(0, 5);
				
					SortItem_Map map3 = new SortItem_Map();
					According = map3.getItem(According);
					
					//tdvo = init.tbl.sort(Season,seasontype, According);
					tdvo = init.tbl.sort(Season,seasontype, According);
					//System.out.println(Season + Position + Partition + According);
					teamdata = getAveragedata(tdvo);
					/*init.currenttext=null;
					init.currentunordown=null; 
					init.currentisaverage=false;
					init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
					System.out.println(init.currentpanel);*/
					teamdatalist.updateTable(teamtitle, teamdata);
					teamdatalist.setcolor(getcl("篮板"));
					teamdatalist.FitTableColumns(teamdatalist.getTable());
			}

		});
		sort_assist = new JButton(image3);
		sort_assist.setToolTipText("筛选助攻快捷按钮");
		sort_assist.setBounds(190, 89, 60, 24);
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
				butisclick= "助攻";
				avg_tol.setSelected(true);
            	
				
				// TODO
					String According = "助攻";
					String Season =Teamseason.getSelectedItem().toString().substring(0, 5);
				
					SortItem_Map map3 = new SortItem_Map();
					According = map3.getItem(According);
					
					//tdvo = init.tbl.sort(Season,seasontype, According);
					tdvo = init.tbl.sort(Season, seasontype,According);
					//System.out.println(Season + Position + Partition + According);
					teamdata = getAveragedata(tdvo);
					/*init.currenttext=null;
					init.currentunordown=null; 
					init.currentisaverage=false;
					init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
					System.out.println(init.currentpanel);*/
					teamdatalist.updateTable(teamtitle, teamdata);
					teamdatalist.setcolor(getcl("助攻"));
					teamdatalist.FitTableColumns(teamdatalist.getTable());
			}

		});
		sort = new JButton(image7);
		sort.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort.setBounds(273, 86, 75, 27);
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
				avg_tol.setSelected(true);
				butisclick= "according";
            
				
				// TODO
					String According = according.getSelectedItem().toString();
					String Season =Teamseason.getSelectedItem().toString().substring(0, 5);
				
					SortItem_Map map3 = new SortItem_Map();
					According = map3.getItem(According);
					
					//tdvo = init.tbl.sort(Season,seasontype, According);
					tdvo = init.tbl.sort(Season,seasontype, According);
					//System.out.println(Season + Position + Partition + According);
					teamdata = getAveragedata(tdvo);
					/*init.currenttext=null;
					init.currentunordown=null; 
					init.currentisaverage=false;
					init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
					System.out.println(init.currentpanel);*/
					teamdatalist.updateTable(teamtitle, teamdata);
					teamdatalist.setcolor(getcl(according.getSelectedItem().toString()));
					teamdatalist.FitTableColumns(teamdatalist.getTable());
			}

		});
		
		sort_super = new JButton(image7);
		sort_super.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort_super.setBounds(803, 46, 75, 27);
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
				avg_tol.setSelected(true);
            
				
				// TODO
				SortItem_Map map3 = new SortItem_Map();	
				String According = according_super.getSelectedItem().toString();
				String Season = Teamseason.getSelectedItem().toString().substring(0, 5);
				
				According = map3.getItem(According);
				
				tdvo = init.tbl.sort_super(Season, seasontype, According, signs.getSelectedItem().toString(),Integer.parseInt(num.getText()));
				//System.out.println(Season + Position + Partition + According);
				teamdata = getAveragedata(tdvo);
				/*init.currenttext=null;
				init.currentunordown=null; 
				init.currentisaverage=false;
				init.currentpanel="3&"+Season+";" + Position+";" + Partition+";" + According;
				System.out.println(init.currentpanel);*/
				avg_tol.setSelected(true);
				teamdatalist.updateTable(teamtitle, teamdata);		
				int x=getcl(according.getSelectedItem().toString());
				teamdatalist.setcolor(x);
				teamdatalist.FitTableColumns(teamdatalist.getTable());
			}

		});
		

		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 140, 1040, 25);
		toolBar.setOpaque(false);
		
		toolBar.add(zongbiao);
		toolBar.add(defen);
		toolBar.add(xiaolv);
		toolBar.add(gaojie);
		add(toolBar);
		//一坨监听 
		zongbiao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				teamdata = getAveragedata(tdvo);
				avg_tol.setSelected(true);
				teamdatalist.updateTable(teamtitle, teamdata);		
				teamdatalist.FitTableColumns(teamdatalist.getTable());
			}
		});
		defen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				teamdata = getAveragedata_piont(tdvo);
				avg_tol.setSelected(true);
				teamdatalist.updateTable(teamtitle_point, teamdata);		
				teamdatalist.new3FitTableColumns(teamdatalist.getTable());
				
				//changl();
			}
		});
		xiaolv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				teamdata = getAveragedata_shoot(tdvo);
				avg_tol.setSelected(true);
				teamdatalist.updateTable(teamtitle_shoot, teamdata);		
				teamdatalist.new1FitTableColumns(teamdatalist.getTable());
			}
		});
		gaojie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				teamdata = getAveragedata_rate(tdvo);
				avg_tol.setSelected(true);
				teamdatalist.updateTable(teamtitle_rate, teamdata);		
				teamdatalist.new4FitTableColumns(teamdatalist.getTable());
			}
		});
		tdvo=init.tbl.getAllTeamSeasonData(init.defaultseason,init.defaulttype);
		teamdata=getAveragedata(tdvo);
		teamdatalist = new CreateTable(teamtitle, teamdata, 10, 170,1040, 445, 25,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(teamdatalist);
		teamdatalist.FitTableColumns(teamdatalist.getTable());
		// 双击进入球员界面
				teamdatalist.getTable().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// System.out.println(playerlist.getSelectedRow()!=-1);
						// System.out.println(e.getClickCount() == 2);
						// TODO Auto-generated method stub
						if (e.getClickCount() == 2 && teamdatalist.getSelectedRow() != -1) {
							
							String name = teamdatalist.getValueAt(teamdatalist.getSelectedRow(), 1);
							System.out.println(name);
							name=my.getFullName(name);System.out.println(name);
							spi = new SingleTeam(name);
							spi.setVisible(true);
							spi.setLocation(init.SysStart_X+0,init.SysStart_Y+60);
						}
						
					}
				});
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 41, 1040, 82);
		add(menubg);
		menubg.setOpaque(true);
	}
	public static Object[][] getTotaldata(ArrayList<TeamSeasonDataVO> da){
		if(da==null){
			Object[][] re=new Object[1][30];
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
			re[0][16]="";
			re[0][17]="";
			re[0][18]="";
			re[0][19]="";			
			re[0][20]="";
			re[0][21]="";
			re[0][22]="";
			re[0][23]="";
			re[0][24]="";
			re[0][25]="";
			re[0][26]="";
			re[0][27]="";
			re[0][28]="";
			re[0][29]="";
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][30];
			for(int i=0;i<da.size();i++){	
				re[i][0]=Player_Info.changenumber(i+1);
				re[i][1]=da.get(i).getTeamName();				
				re[i][2]=da.get(i).getPointNum();		
				re[i][3]=da.get(i).getReboundNum();	
				re[i][4]=da.get(i).getAssistNum();
				re[i][5]=da.get(i).getT_fieldGoal();
				re[i][6]=da.get(i).getT_shootNum();		
				re[i][7]=da.get(i).getFreeThrowGoalNum();
				re[i][8]=da.get(i).getFreeThrowNum();
				re[i][9]=da.get(i).getFieldGoal();
				re[i][10]=da.get(i).getShootNum();
				re[i][11]=da.get(i).getO_ReboundNum();
				re[i][12]=da.get(i).getD_ReboundNum();								
				re[i][13]=da.get(i).getStealNum();
				re[i][14]=da.get(i).getBlockNum();
				re[i][15]=da.get(i).getTurnoverNum();
				re[i][16]=da.get(i).getFoulNum();								
				re[i][17]=da.get(i).getMatchNum();
				re[i][18]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][19]=OftenUseMethod.changedouble(da.get(i).getT_shootPercentage());
				re[i][20]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());				
				re[i][21]=OftenUseMethod.changedouble(da.get(i).getWinRate());				
				re[i][22]=OftenUseMethod.changedouble(da.get(i).getOffenseRound());
				re[i][23]=OftenUseMethod.changedouble(da.get(i).getDefenseRound());									
				re[i][24]=OftenUseMethod.changedouble(da.get(i).getOffenseEfficiency());
				re[i][25]=OftenUseMethod.changedouble(da.get(i).getDefenseEfficiency());
				re[i][26]=OftenUseMethod.changedouble(da.get(i).getO_ReboundEfficiency());
				re[i][27]=OftenUseMethod.changedouble(da.get(i).getD_ReboundEfficiency());
				re[i][28]=OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][29]=OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
			}		
			return re;	
		}	
	}
	static Object[][] getAveragedata(ArrayList<TeamSeasonDataVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][30];
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
			re[0][16]="";
			re[0][17]="";
			re[0][18]="";
			re[0][19]="";			
			re[0][20]="";
			re[0][21]="";
			re[0][22]="";
			re[0][23]="";
			re[0][24]="";
			re[0][25]="";
			re[0][26]="";
			re[0][27]="";
			re[0][28]="";
			re[0][29]="";
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][30];
			for(int i=0;i<da.size();i++){						
				re[i][0]=Player_Info.changenumber(i+1);				
				re[i][1]=da.get(i).getTeamName();				
				re[i][2]=OftenUseMethod.changedouble(da.get(i).getPointNum_avg());		
				re[i][3]=OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());	
				re[i][4]=OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][5]=OftenUseMethod.changedouble(da.get(i).getT_fieldGoal_avg());
				re[i][6]=OftenUseMethod.changedouble(da.get(i).getT_shootNum_avg());				
				re[i][7]=OftenUseMethod.changedouble(da.get(i).getFreeThrowGoalNum_avg());
				re[i][8]=OftenUseMethod.changedouble(da.get(i).getFreeThrowNum_avg());
				re[i][9]=OftenUseMethod.changedouble(da.get(i).getFieldGoal_avg());
				re[i][10]=OftenUseMethod.changedouble(da.get(i).getShootNum_avg());
				re[i][11]=OftenUseMethod.changedouble(da.get(i).getO_ReboundNum_avg());
				re[i][12]=OftenUseMethod.changedouble(da.get(i).getD_ReboundNum_avg());
				re[i][13]=OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][14]=OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][15]=OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][16]=OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());							
				re[i][17]=da.get(i).getMatchNum();
				re[i][18]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][19]=OftenUseMethod.changedouble(da.get(i).getT_shootPercentage());
				re[i][20]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());				
				re[i][21]=OftenUseMethod.changedouble(da.get(i).getWinRate());				
				re[i][22]=OftenUseMethod.changedouble(da.get(i).getOffenseRound_avg());
				re[i][23]=OftenUseMethod.changedouble(da.get(i).getDefenseRound());						
				re[i][24]=OftenUseMethod.changedouble(da.get(i).getOffenseEfficiency());
				re[i][25]=OftenUseMethod.changedouble(da.get(i).getDefenseEfficiency());
				re[i][26]=OftenUseMethod.changedouble(da.get(i).getO_ReboundEfficiency());
				re[i][27]=OftenUseMethod.changedouble(da.get(i).getD_ReboundEfficiency());
				re[i][28]=OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][29]=OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
			}		
			return re;		
		}			
	}
	static Object[][] getAveragedata_rate(ArrayList<TeamSeasonDataVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][11];
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
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][11];
			for(int i=0;i<da.size();i++){			
				re[i][0]=Player_Info.changenumber(i+1);				
				re[i][1]=da.get(i).getTeamName();												
				re[i][2]=OftenUseMethod.changedouble(da.get(i).getWinRate());				
				re[i][3]=OftenUseMethod.changedouble(da.get(i).getOffenseRound_avg());
				re[i][4]=OftenUseMethod.changedouble(da.get(i).getDefenseRound());						
				re[i][5]=OftenUseMethod.changedouble(da.get(i).getOffenseEfficiency());
				re[i][6]=OftenUseMethod.changedouble(da.get(i).getDefenseEfficiency());
				re[i][7]=OftenUseMethod.changedouble(da.get(i).getO_ReboundEfficiency());
				re[i][8]=OftenUseMethod.changedouble(da.get(i).getD_ReboundEfficiency());
				re[i][9]=OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][10]=OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
			}		
			return re;	
		}			
	}
	
	static Object[][] getAveragedata_shoot(ArrayList<TeamSeasonDataVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][11];
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
		
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][11];
			for(int i=0;i<da.size();i++){									
				re[i][0]=Player_Info.changenumber(i+1);				
				re[i][1]=da.get(i).getTeamName();								
				re[i][2]=OftenUseMethod.changedouble(da.get(i).getT_fieldGoal_avg());
				re[i][3]=OftenUseMethod.changedouble(da.get(i).getT_shootNum_avg());				
				re[i][4]=OftenUseMethod.changedouble(da.get(i).getFreeThrowGoalNum_avg());
				re[i][5]=OftenUseMethod.changedouble(da.get(i).getFreeThrowNum_avg());
				re[i][6]=OftenUseMethod.changedouble(da.get(i).getFieldGoal_avg());
				re[i][7]=OftenUseMethod.changedouble(da.get(i).getShootNum_avg());			
				re[i][8]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][9]=OftenUseMethod.changedouble(da.get(i).getT_shootPercentage());
				re[i][10]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());							
			}		
			return re;
		
		}
			
	}
	static Object[][] getAveragedata_piont(ArrayList<TeamSeasonDataVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][10];
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

			return re;
		}
		else{
			Object[][] re=new Object[da.size()][30];
			for(int i=0;i<da.size();i++){			
				re[i][0]=Player_Info.changenumber(i+1);			
				re[i][1]=da.get(i).getTeamName();				
				re[i][2]=OftenUseMethod.changedouble(da.get(i).getPointNum_avg());		
				re[i][3]=OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());	
				re[i][4]=OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());			
				re[i][5]=OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][6]=OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][7]=OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][8]=OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());							
				re[i][9]=da.get(i).getMatchNum();			
			}		
			return re;
		
		}
			
	}
	public static void cleartime(){
		times=0;
	}
	static int getcl(String name){

		
		
		if(name.equals("得分")){
			return 2;
		}else if(name.equals("篮板")){
			return 3;
		}else if(name.equals("助攻")){
			return 4;
		}else if(name.equals("投篮出手数")){
			return 10;
		}else if(name.equals("投篮命中数")){
			return 9;
		}else if(name.equals("三分命中数")){
			return 5;
		}else if(name.equals("三分出手数")){
			return 6;
		}else if(name.equals("罚球命中数")){
			return 7;
		}else if(name.equals("罚球出手数")){
			return 8;
		}else if(name.equals("进攻篮板")){
			return 11;
		}else if(name.equals("防守篮板")){
			return 12;
		}else if(name.equals("抢断")){
			return 13;
		}else if(name.equals("盖帽")){
			return 14;
		}else if(name.equals("失误")){
			return 15;
		}else if(name.equals("犯规")){
			return 16;		
		}else if(name.equals("投篮命中率")){
			return 18;
		}else if(name.equals("三分命中率")){
			return 19;
		}else if(name.equals("罚球命中率")){
			return 20;
		}else if(name.equals("胜率")){
			return 21;
		}else if(name.equals("进攻回合")){
			return 22;
		}else if(name.equals("进攻效率")){
			return 24;
		}else if(name.equals("防守效率")){
			return 25;
		}else if(name.equals("进攻篮板率")){
			return 26;
		}else if(name.equals("防守篮板率")){
			return 27;
		}else if(name.equals("助攻率")){
			return 29;
		}else if(name.equals("抢断率")){
			return 28;
		}else {
			return -1;
		}		
	}
	public static void do_this_whenclick(String text) {
		// TODO Auto-generated method stub
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
			if(up1.getToolTipText().equals("降序")){
				upordown[0] = false;
			}
		}
		else{
			textforsort[0] = map.getItem("得分");
		}
		if(!term2.getText().equals("")){
			textforsort[1] = map.getItem(term2.getText());
			if(up2.getToolTipText().equals("降序")){
				upordown[1] = false;
			}
		}else{
			textforsort[0] = map.getItem("篮板");
		}
		if(!term3.getText().equals("")){
			textforsort[2] = map.getItem(term3.getText());
			if(up3.getToolTipText().equals("降序")){
				upordown[2] = false;
			}
		}else{
			textforsort[0] = map.getItem("助攻");
		}
		
		String Season = Teamseason.getSelectedItem().toString().substring(0, 5);
		String Type=seasontype;	
		if(isaverage == true){		
			//tdvo = init.tbl.sort(Season,Type,textforsort,upordown);
			tdvo = init.tbl.sort(Season,seasontype,textforsort,upordown);
			teamdata = getAveragedata(tdvo);
			teamdatalist.updateTable(teamtitle, teamdata);
			teamdatalist.FitTableColumns(teamdatalist.getTable());
		}
		else{
			
			//tdvo = init.tbl.sort(Season,Type,textforsort,upordown);
			tdvo = init.tbl.sort(Season,seasontype,textforsort,upordown);
			teamdata = getTotaldata(tdvo);
			teamdatalist.updateTable(teamtitle, teamdata);
			teamdatalist.FitTableColumns(teamdatalist.getTable());
		}
		ArrayList<Integer> c=new ArrayList<Integer>();
		c.add(getcl(term1.getText()));
		c.add(getcl(term2.getText()));
		c.add(getcl(term3.getText()));
		teamdatalist.setcolors(c);
	}
}
