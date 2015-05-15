package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.common.ComboBoxRenderer;
import VO.MatchVO;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;

public class init extends JFrame {

	private JPanel contentPane;
	
	
	JButton min;
	JButton exit;
	
	JButton playerbutton;
	JButton matchbutton;
	JButton teambutton;
	JButton hotbutton;
	
	static JPanel rightpanel;
	
	static Player p;
	static Team t;
	static Match m;
	
	
	//当前panel的信息
	public static String currentpanel="";
	public static String currentdio="";
	public static String[] currenttext=null;
	public static boolean[] currentunordown=null; 
	public static boolean currentisaverage;
	
	//颜色
	public static Color syswhite=new Color(249,250,243);
	public static Color syslightblue=new Color(183,221,222);
	public static Color sysdarkblue=new Color(80,179,175);
	public static Color syspurple=new Color(155,106,141);
	public static Color syspurpleblue=new Color(102,90,197);
	
	int x,y;
	
	//程序现在的位置
	public static int SysStart_X;
	public static int SysStart_Y;

	public static RMIObject rmi=new RMIObject();
	public static PlayerBLService pbl=rmi.getPlayerObject();
	public static TeamBLService tbl=rmi.getTeamObject();
	public static MatchBLService mbl=rmi.getMatchObject();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            UIManager
	                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
		EventQueue.invokeLater(new Runnable() {
			@Override
			
			public void run() {
				try {
					init frame = new init();
					frame.setVisible(true);
					listen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	static PanelUpdateThread f ;	
	
	protected static void listen(){
		f=new PanelUpdateThread();
		Thread thread = new Thread(f);
		thread.start();
	}
	static class PanelUpdateThread implements Runnable{
		@Override
		public void run() {	  

			while(true){
			//System.out.println("bbb");
            try {
              	 /**updatepanel(currentpanel);
              	  * 
              	  */
              	 //System.out.println("刷新"+currentpanel+"  "+currentdio);
                  Thread.sleep(1000000);// 线程休眠3秒
              } catch (InterruptedException e1) {
                  e1.printStackTrace();
              } catch (TransformerFactoryConfigurationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
          }
		}
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public init() {
		setTitle("NBA\u6570\u636E\u67E5\u8BE2\u5206\u6790\u7CFB\u7EDF");
		setUndecorated(true);// 取消窗体修饰效果************
		setDragable();//移动功能
		
		setSize(1060, 690);
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		x=(screen.width-getWidth())/2;
		y=(screen.height-getHeight())/2-16;	
		setLocation(x,y);
		this.SysStart_X=x;
		this.SysStart_Y=y;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(5,5,1060, 690);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		/**
		 * TODO 
		 * 
		 * 可以对初始界面做出欢迎字样的改进
		 */
		rightpanel=new JPanel();
		rightpanel.setBounds(0,51,1060,639);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		add(rightpanel);
		

		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowOpened(WindowEvent e) {
	             do_this_windowOpened(e);
	            
	        }
	    });
		
		
		playerbutton = new JButton(new ImageIcon("newpic/球员信息-平常.png"));
    	playerbutton.setToolTipText("球员信息");
		playerbutton.setBounds(220, 18, 112, 32);
		playerbutton.setContentAreaFilled(false);
		contentPane.add(playerbutton);
		playerbutton.addMouseListener(new MouseListener() {
            
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
            	if(!playerbutton.getToolTipText().equals("球员信息 "))
            	playerbutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	else
            		playerbutton.setIcon(new ImageIcon("newpic/球员信息-选中.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	playerbutton.setIcon(new ImageIcon("newpic/球员信息-上浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	playerbutton.setToolTipText("球员信息 ");
            	playerbutton.setIcon(new ImageIcon("newpic/球员信息-选中.png"));
            	teambutton.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	hotbutton.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	matchbutton.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));

            	hotbutton.setToolTipText("热门信息");
            	teambutton.setToolTipText("队伍信息");
            	matchbutton.setToolTipText("比赛信息");	
            	
            	currentpanel="player";
				p = new Player();
				change(p);
            }
        });
		
		teambutton = new JButton(new ImageIcon("newpic/队伍信息-平常.png"));
    	teambutton.setToolTipText("队伍信息");
		teambutton.setBounds(340, 18, 112, 32);
		contentPane.add(teambutton);
		teambutton.addMouseListener(new MouseListener() {
            
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
            	if(!teambutton.getToolTipText().equals("队伍信息 "))
            		teambutton.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	else
            		teambutton.setIcon(new ImageIcon("newpic/队伍信息-选中.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	teambutton.setIcon(new ImageIcon("newpic/队伍信息-上浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	teambutton.setIcon(new ImageIcon("newpic/队伍信息-选中.png"));
            	hotbutton.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	playerbutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	matchbutton.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	
            	playerbutton.setToolTipText("球员信息");
            	hotbutton.setToolTipText("热门信息");
            	teambutton.setToolTipText("队伍信息 ");
            	matchbutton.setToolTipText("比赛信息");
            	currentpanel="team";
				t = new Team();
				change(t);
            }
        });

		matchbutton = new JButton(new ImageIcon("newpic/比赛信息-平常.png"));
    	matchbutton.setToolTipText("比赛信息");
		matchbutton.setBounds(610, 18, 112, 32);
		contentPane.add(matchbutton);
		matchbutton.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
               
            }          
            @Override
            public void mouseExited(MouseEvent e) {
            	if(!matchbutton.getToolTipText().equals("比赛信息 "))
            		matchbutton.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	else
            		matchbutton.setIcon(new ImageIcon("newpic/比赛信息-选中.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("newpic/比赛信息-上浮.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("newpic/比赛信息-选中.png"));
            	teambutton.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	hotbutton.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	playerbutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	
            	playerbutton.setToolTipText("球员信息");
            	hotbutton.setToolTipText("热门信息");
            	teambutton.setToolTipText("队伍信息");
            	matchbutton.setToolTipText("比赛信息 ");
            	Match p;		
            	currentpanel="match";
            	//System.out.println(currentpanel);
				p = new Match();
				change(p);
            }
        });

		hotbutton = new JButton(new ImageIcon("newpic/热门信息-平常.png"));
    	hotbutton.setToolTipText("热门信息");
		hotbutton.setBounds(730, 18, 112, 32);
		contentPane.add(hotbutton);
		hotbutton.addMouseListener(new MouseListener() {
            
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
            	if(!hotbutton.getToolTipText().equals("热门信息 "))
            		hotbutton.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	else
            		hotbutton.setIcon(new ImageIcon("newpic/热门信息-选中.png"));
            	//hotbutton.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	hotbutton.setIcon(new ImageIcon("newpic/热门信息-上浮.png"));
                // TODO Auto-generated method stub
            	//hotbutton.setIcon(new ImageIcon("newpic/热门信息-ao.png"));
            	//teambutton.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	//playerbutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	//matchbutton.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	hotbutton.setIcon(new ImageIcon("newpic/热门信息-选中.png"));
            	teambutton.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	playerbutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	matchbutton.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	
            	playerbutton.setToolTipText("球员信息");
            	hotbutton.setToolTipText("热门信息 ");
            	teambutton.setToolTipText("队伍信息");
            	matchbutton.setToolTipText("比赛信息");
            	Hot p;			
            	currentpanel="hot";
            	//System.out.println(currentpanel);
				p = new Hot();
				change(p);
            }
        });
	
		teambutton.setFocusPainted(false);
		hotbutton.setFocusPainted(false);
		playerbutton.setFocusPainted(false);
		matchbutton.setFocusPainted(false);
		//btnNewButton.setContentAreaFilled(false);
		teambutton.setContentAreaFilled(false);
		hotbutton.setContentAreaFilled(false);
		playerbutton.setContentAreaFilled(false);
		matchbutton.setContentAreaFilled(false);
		//最小化but
		min = new JButton(new ImageIcon("newpic/缩小.png"));
		min.setBounds(1025, 1, 16, 17);
		contentPane.add(min);
		min.setBorderPainted(false);
		min.setFocusPainted(false);
		min.setContentAreaFilled(false);
		min.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
            	//min.setIcon(new ImageIcon("newpic/rnormal.png"));
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub    
            	//min.setIcon(new ImageIcon("newpic/ractive.png"));
            }          
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            	//min.setIcon(new ImageIcon("newpic/rover.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	
            	//min.setIcon(new ImageIcon("newpic/ractive.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	 setExtendedState(JFrame.ICONIFIED);
            }
        });
	
					
		
				//tuichubut
				exit = new JButton(new ImageIcon("newpic/关闭.png"));
				exit.setBounds(1044, 1, 16, 17);
			    exit.setBorderPainted(false);
				exit.setFocusPainted(false);
				exit.setContentAreaFilled(false);
				contentPane.add(exit);
				exit.addMouseListener(new MouseListener() {
		            
		            @Override
		            public void mouseReleased(MouseEvent e) {
		            	exit.setIcon(new ImageIcon("newpic/cnormal.png"));
		                // TODO Auto-generated method stub                
		            }           
		            @Override
		            public void mousePressed(MouseEvent e) {
		                // TODO Auto-generated method stub    
		            	exit.setIcon(new ImageIcon("newpic/cactive.png"));
		            }          
		            @Override
		            public void mouseExited(MouseEvent e) {
		                // TODO Auto-generated method stub
		            	exit.setIcon(new ImageIcon("newpic/cover.png"));
		            }           
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	
		                // TODO Auto-generated method stub
		            	
		            	exit.setIcon(new ImageIcon("newpic/cactive.png"));
		            	
		            }            
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	dispose();// 销毁窗体
		            }
		        });
		
				/**
				 * 背景图片
				 */
        ImageIcon image = new ImageIcon("newpic/背景图.jpg");
		image.setImage(image.getImage().getScaledInstance(1060, 690,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 1060, 690);		
		photo.setOpaque(false);
		getContentPane().add(photo);
		
		setLocationRelativeTo(null);
		
	}
	
	 protected void do_this_windowOpened(WindowEvent e) {
	        final int height = this.getHeight();// 记录窗体高度
	        new Thread() {// 创建新线程
	            public void run() {
	            	Rectangle rec = getBounds();
	                for (int i = 0; i <= 1060; i += 5) {// 循环拉伸窗体
	                	 setBounds(rec.x+530-i/2 , rec.y, i, height);// 不断设置窗体大小与位置
	                     try {
	                        Thread.sleep(1);// 线程休眠1毫秒
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }.start();// 启动线程
	        
	    }
	
	
	 private boolean isDragged = false;
	 private Point loc = null;
	 private Point tmp = null;
	 /**
		 * 设置可以拖动窗体
		 */
		protected void setDragable () {
			this.addMouseListener(new MouseAdapter() {

				public void mouseReleased (MouseEvent e) {
					isDragged = false;
				}

				public void mousePressed (MouseEvent e) {
					tmp = new Point(e.getX(), e.getY());
					isDragged = true;
				}

			});

			this.addMouseMotionListener(new MouseMotionAdapter() {

				public void mouseDragged (MouseEvent e) {
					if (isDragged) {
						loc = new Point(getLocation().x + e.getX() - tmp.x, getLocation().y + e.getY() - tmp.y);
						setLocation(loc);
						SysStart_X=getLocation().x;
						SysStart_Y=getLocation().y;
					}
				}
			});
		}
       
		
		static void change(Player ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 1060,639);
			rightpanel.validate();
			rightpanel.repaint();
		}
		static void change(Team ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0,1060,639);
			rightpanel.validate();
			rightpanel.repaint();
		}
		static void change(Hot ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 1060, 639);
			rightpanel.validate();
			rightpanel.repaint();
		}
		static void change(Match ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 1060,639);
			rightpanel.validate();
			rightpanel.repaint();
		}
/*
		static void updatepanel(String command) throws TransformerFactoryConfigurationError, TransformerException, IOException, SVGConverterException{
			String[] playerAvgtitle = { " 序号  ", " 球员名称  ", " 所属球队  ", 			 "参赛场数",
					"先发场数", "场均篮板", "场均助攻", "场均上场时间", "投篮命中率", "三分命中率",
					"罚球命中s率", "场均进攻", "场均防守", "场均抢断", "场均盖帽", "场均失误",
					"场均犯规", "场均得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
					"篮板率", "进攻篮板率", "防守篮板率", "助攻率", "抢断率", "盖帽率",
					"失误率", "使用率","近五场得分提升率","近五场助攻提升率","近五场篮板提升率"};
			String[] teamtitle={" 序号  "," 球队名称  "," 比赛场数  "," 投篮命中数  "," 投篮出手次数  "," 三分命中数  ",
					" 三分出手数  "," 罚球命中数  "," 罚球出手数  "," 进攻篮板数  "," 防守篮板数  "," 篮板数  "," 助攻数  ",
					" 抢断数  "," 盖帽数  "," 失误数  "," 犯规数  "," 比赛得分  "," 投篮命中率  "," 三分命中率  "," 罚球命中率  ",
					" 胜率  "," 进攻回合  ","防守回合"," 防守效率  "," 进攻效率  "," 进攻篮板率  "," 防守篮板率  "," 抢断效率  "," 助攻率  "};
			String[] matchtitle={"序号"," 日期  "," 赛季  "," 主队  "," 比分  "," 客队  ",
					" 第一节  "," 第二节  "," 第三节  "," 第四节  "," 加时赛  "};
			String[] playerinfo = { " 序号  ", " 姓名  ", " 球号  ", " 位置  ", " 身高  ",
					" 体重  ", " 出生日期  ", " 年龄  ", " 球龄  ", " 毕业院校  " };
			
			String com_panel[]=currentpanel.split("&");
			String com_dio[]=currentdio.split("&");
			
									
			if(currentdio!=""){
				String com2[]=com_dio[1].split(";");
				if(com_dio[0]=="4(1)"){
					BasicP p=new BasicP(com2[0],com2[1]);
					SinglePlayer.change(p);
				}
				if(com_dio[0]=="4(3)"){
					MatP p=new MatP(com2[0],com2[1]);
					SinglePlayer.change(p);
				}
				if(com_dio[0]=="7(1)"){
					BasicT p=new BasicT(com2[0],com2[1]);
					SingleTeam.change(p);
				}
				if(com_dio[0]=="7(3)"){
					MatT p=new MatT(com2[0],com2[1]);
					SingleTeam.change(p);
				}

				if(com_dio[0]=="7(4)"){
					//OtherT p=new OtherT();
					//	SingleTeam.change(p);
				}
				if(com_dio[0]=="10(1)"){
					BasicM p=new BasicM(com2[0],com2[1]);
					SingleMatch.change(p);
				}
				
			}
			//if(currentdio==""){//如果dio为“”，那么当前panel是初始的
				//以下判断panel的刷新
			//System.out.println("???///");
				if(com_panel[0].equals("hot")){//hot针对每个panel刷新
					String[] com2=com_panel[1].split(";");
					String[] panel1=com2[0].split(",");
					String[] panel2=com2[1].split(",");
					HotTeams ht = new HotTeams(panel2[0],panel2[1]);
					Hot.changep2(ht);		
					HotPlayers hp = new HotPlayers(panel1[0],panel1[1]);
					Hot.changep1(hp);
				}
				if(com_panel[0].equals("player")){//球员信息表格刷新
					Object[][] d=init.p.getinfodata(pbl.getAllPlayerInfo());
					init.p.changetabledata(playerinfo, d);
				}
				if(com_panel[0].equals("3")){//球员筛选表格刷新
					System.out.println("3");
					String[]com2=com_panel[1].split(";");
					if(com2.length==1){					
						ArrayList<PlayerSeasonDataVO>psvo = pbl.keyfind(com2[0]);					
						Object[][] data = init.p.getAveragedata(psvo);					
						init.p.changetabledata(playerAvgtitle, data);					
					}else if(com2.length==4){	
						System.out.println("fangfa");
						String Position = com2[1];					
						String Partition = com2[2];					
						String According = com2[3];
						String Season = com2[0];				
						ArrayList<PlayerSeasonDataVO>psvo = pbl.sort(Season, Position, Partition, According);					
						Object[][] data = init.p.getAveragedata(psvo);					
						init.p.changetabledata(playerAvgtitle, data);					
					}else{
						System.out.println("Player里不应出现这种情况");
					}			
				}
				if(com_panel[0].equals("team")){
					System.out.println("TEAM不需要变");
				}
				if(com_panel[0].equals("6")){
					String[] com2=com_panel[1].split(";");
					if(com2.length==1){
						ArrayList<TeamSeasonDataVO>tdvo =tbl.find(com2[0]);
		            	Object[][] data=init.t.getTotaldata(tdvo);
		            	init.t.changetabledata(teamtitle, data);
					}
					else if(com2.length==2){						
							ArrayList<TeamSeasonDataVO>tdvo=tbl.sort(com2[0], com2[1]);
			            	Object[][]data=init.t.getAveragedata(tdvo);
			            	init.t.changetabledata(teamtitle, data);
			            	//Team.teamlist.setVisible(true);						
					}else{
						System.out.println("team6里不应出现这种情况");
					}
				}
				if(com_panel[0].equals("9")){
					
						String[] com2=com_panel[1].split(";");
						if(com2.length==1){
							ArrayList<MatchVO>mvo=mbl.getMatchByTeamTime(com2[0]);             
				              Object[][] data=init.m.getdata(mvo);
				               init.m.changetabledata(matchtitle, data);
				              // Match.matchlist.hideColumn(2);	          
						}else if(com2.length==2){			
							ArrayList<MatchVO> mvo=mbl.getMatchBySeason(com2[0], com2[1]);		         
							Object[][] data=init.m.getdata(mvo);				          
							init.m.changetabledata(matchtitle, data);			         
							//Match. matchlist.hideColumn(2);										
						}else{
							System.out.println("match9里不应出现这种情况");
					 
						}
				}				
				if(currenttext!=null){
					init.p.supersort(currenttext, currentunordown, currentisaverage);					
				}
			
		}
	*/
}
