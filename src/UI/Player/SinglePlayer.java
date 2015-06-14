package UI.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import UI.common.LimpidButton;
import UI.main.Hot;
import UI.main.Match;
import UI.main.Player;
import UI.main.Team;

public class SinglePlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	LimpidButton  back;
	public static JPanel rightpanel;
	public JButton A;
	public JButton B;
	public JButton C;
	PlayerB b;
	PlayerC c;
	String na;
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
			SinglePlayer dialog = new SinglePlayer("阿隆-布鲁克斯");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SinglePlayer(String name) {
		System.out.print(name);
		getContentPane().setLayout(null);
		setSize(1060,620);
		setUndecorated(true);// 取消窗体修饰效果************		
		setLocation(UI.main.init.SysStart_X,UI.main.init.SysStart_Y+70);

		this.na=name;
		/**
		 * TODO 
		 * 
		 * 可以对初始界面做出欢迎字样的改进
		 */
		rightpanel=new PlayerA(name);
		rightpanel.setBounds(9,30,1042,580);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		getContentPane().add(rightpanel);
			
		A = new JButton(new ImageIcon("newpic/add/基本信息浮.png"));
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
            	
            	A.setIcon(new ImageIcon("newpic/add/基本信息浮.png"));
            	B.setIcon(new ImageIcon("newpic/add/趋势对比.png"));
            	C.setIcon(new ImageIcon("newpic/add/球员对比.png"));
            	A.setToolTipText("基本信息");
            	B.setToolTipText("趋势对比");
            	C.setToolTipText("球员对比");	
            	PlayerA a=new PlayerA(na);
            	change(a);
            	
            }
        });
		
		B = new JButton(new ImageIcon("newpic/add/趋势对比.png"));
    	B.setToolTipText("趋势对比");
		B.setBounds(450, 0, 112, 30);
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
            	if(!B.getToolTipText().equals("趋势对比"))
            		B.setIcon(new ImageIcon("newpic/add/趋势对比.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/add/趋势对比浮.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/趋势对比浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/趋势对比浮.png"));
            	A.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	C.setIcon(new ImageIcon("newpic/add/球员对比.png"));
            	
            	A.setToolTipText("基本信息");
            	B.setToolTipText("趋势对比");
            	C.setToolTipText("球员对比");
            	
            	c=new PlayerC(na);
            	change(c);
            	
            }
        });

		C = new JButton(new ImageIcon("newpic/add/球员对比.png"));
    	C.setToolTipText("球员对比");
		C.setBounds(665, 0, 112, 30);
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
            	if(!C.getToolTipText().equals("球员对比"))
            		C.setIcon(new ImageIcon("newpic/add/球员对比.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/add/球员对比浮.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/球员对比浮.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/球员对比浮.png"));
            	B.setIcon(new ImageIcon("newpic/add/趋势对比.png"));
            	A.setIcon(new ImageIcon("newpic/add/基本信息.png"));
            	
            	A.setToolTipText("基本信息");
            	B.setToolTipText("趋势对比");
            	C.setToolTipText("球员对比");
            	b=new PlayerB(na);
				change(b);
            }
        });

	
	
		B.setFocusPainted(false);
		A.setFocusPainted(false);
		C.setFocusPainted(false);
		//btnNewButton.setContentAreaFilled(false);
		B.setContentAreaFilled(false);
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
		getContentPane().add(photo);

		setLocationRelativeTo(null);
		
	}
	static void change(PlayerA ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
	static void change(PlayerB ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
	static void change(PlayerC ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
}
