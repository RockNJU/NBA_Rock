package UI.Team;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import UI.common.LimpidButton;
import UI.main.Player;
import UI.main.Team;

public class SingleTeam extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static JPanel rightpanel;
	public JButton A;
	public JButton B;
	public JButton C;
	public JButton D;
	String na;
	JButton back;
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
		try {
			SingleTeam dialog = new SingleTeam("ATL");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SingleTeam(String name) {
		this.na=name;
		getContentPane().setLayout(null);
		setSize(1060,620);
		setUndecorated(true);// 取消窗体修饰效果************		
		setLocation(UI.main.init.SysStart_X,UI.main.init.SysStart_Y+70);

		/**
		 * TODO 
		 * 
		 * 可以对初始界面做出欢迎字样的改进
		 */
		rightpanel=new TeamA(name);
		rightpanel.setBounds(9,30,1042,580);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		add(rightpanel);
			
		A = new JButton(new ImageIcon("newpic/add/基本信息.png"));
    	A.setToolTipText("基本信息");
		A.setBounds(228, 0, 112, 30);
		A.setContentAreaFilled(false);
		getContentPane().add(A);
		A.addMouseListener(new MouseListener() {
            
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
            	if(!A.getToolTipText().equals("基本信息"))
            	A.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	else
            		A.setIcon(new ImageIcon("newpic/add/基本信息浮.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	A.setIcon(new ImageIcon("newpic/add/基本信息浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	A.setToolTipText("基本信息");
            	A.setIcon(new ImageIcon("newpic/add/基本信息浮.png"));
            	B.setIcon(new ImageIcon("newpic/add/球员数据.png"));
            	D.setIcon(new ImageIcon("newpic/add/数据对比.png"));
            	C.setIcon(new ImageIcon("newpic/add/趋势对比.png"));

            	D.setToolTipText("数据对比");
            	B.setToolTipText("球员数据");
            	C.setToolTipText("趋势对比");	
            	
            	TeamA a=new TeamA(na);
            	change(a);
            }
        });
		
		B = new JButton(new ImageIcon("newpic/add/球员数据.png"));
    	B.setToolTipText("球员数据");
		B.setBounds(379, 0, 112, 30);
		getContentPane().add(B);
		B.addMouseListener(new MouseListener() {
            
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
            	if(!B.getToolTipText().equals("球员数据"))
            		B.setIcon(new ImageIcon("newpic/add/球员数据.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/add/球员数据浮.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/球员数据浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/球员数据浮.png"));
            	D.setIcon(new ImageIcon("newpic/add/数据对比.png"));
            	A.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	C.setIcon(new ImageIcon("newpic/add/趋势对比.png"));
            	
            	A.setToolTipText("基本信息");
            	D.setToolTipText("数据对比");
            	B.setToolTipText("球员数据");
            	C.setToolTipText("趋势对比");
            	TeamB a=new TeamB(na);
            	change(a);
            }
        });

		C = new JButton(new ImageIcon("newpic/add/趋势对比.png"));
    	C.setToolTipText("趋势对比");
		C.setBounds(514, 0, 112, 30);
		getContentPane().add(C);
		C.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
               
            }          
            @Override
            public void mouseExited(MouseEvent e) {
            	if(!C.getToolTipText().equals("趋势对比"))
            		C.setIcon(new ImageIcon("newpic/add/趋势对比.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/add/趋势对比浮.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/趋势对比浮.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/趋势对比浮.png"));
            	B.setIcon(new ImageIcon("newpic/add/球员数据.png"));
            	D.setIcon(new ImageIcon("newpic/add/数据对比.png"));
            	A.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	
            	A.setToolTipText("基本信息");
            	D.setToolTipText("数据对比");
            	B.setToolTipText("球员数据");
            	C.setToolTipText("趋势对比");
            
            	TeamC a=new TeamC(na);
            	change(a);
            }
        });

		D = new JButton(new ImageIcon("newpic/add/数据对比.png"));
    	D.setToolTipText("数据对比");
		D.setBounds(669, 0, 112, 30);
		getContentPane().add(D);
		D.addMouseListener(new MouseListener() {
            
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
            	if(!D.getToolTipText().equals("数据对比 "))
            		D.setIcon(new ImageIcon("newpic/add/数据对比.png"));
            	else
            		D.setIcon(new ImageIcon("newpic/add/数据对比浮.png"));
            	
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	D.setIcon(new ImageIcon("newpic/add/数据对比浮.png"));
                // TODO Auto-generated method stub
            	//hotbutton.setIcon(new ImageIcon("newpic/数据对比-ao.png"));
            	//teambutton.setIcon(new ImageIcon("newpic/球员数据.png"));
            	//Teambutton.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	//matchbutton.setIcon(new ImageIcon("newpic/趋势对比.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	D.setIcon(new ImageIcon("newpic/add/数据对比浮.png"));
            	B.setIcon(new ImageIcon("newpic/add/球员数据.png"));
            	A.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	C.setIcon(new ImageIcon("newpic/add/趋势对比.png"));
            	
            	A.setToolTipText("基本信息");
            	D.setToolTipText("数据对比");
            	B.setToolTipText("球员数据");
            	C.setToolTipText("趋势对比");
            	TeamD a=new TeamD(na);
            	change(a);
            }
        });
	
		B.setFocusPainted(false);
		D.setFocusPainted(false);
		A.setFocusPainted(false);
		C.setFocusPainted(false);
		//btnNewButton.setContentAreaFilled(false);
		B.setContentAreaFilled(false);
		D.setContentAreaFilled(false);
		A.setContentAreaFilled(false);
		C.setContentAreaFilled(false);
		
		
		back = new LimpidButton("","newpic/关闭.png");
		back.setBounds(1030, 6,16, 17);
		getContentPane().add(back);
		back.setVisible(false);
		back.addMouseListener(new MouseListener() {
         
		
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
            	
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	UI.main.init.currentdio="";
            	dispose();// 销毁窗体
            }
        });
		addMouseMotionListener(new MouseMotionListener() {

			/**
			* 处理鼠标拖动事件
			* */
			public void mouseDragged(MouseEvent arg0) {
			
			}

			/**
			* 处理鼠标移动事件
			* */
			public void mouseMoved(MouseEvent arg0) {
				
				if(arg0.getX()>back.getX() && arg0.getX() <back.getX()+back.getWidth()
						&&
						arg0.getY()>back.getY() && arg0.getY()<back.getY()+back.getHeight()){
					back.setVisible(true);
				}
				else{	
					back.setVisible(false);
					
				}
			
			}

			});
		
		/**
		 * 背景图片
		 */
		ImageIcon image = new ImageIcon("newpic/基础信息使用.jpg");
		image.setImage(image.getImage().getScaledInstance(1060, 620,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 1060, 620);		
		photo.setOpaque(false);
		add(photo);

		
		
		setLocationRelativeTo(null);
		
		
	}
	static void change(TeamA ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
	static void change(TeamB ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
	static void change(TeamC ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
	static void change(TeamD ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
}
