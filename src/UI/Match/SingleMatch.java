package UI.Match;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import UI.Player.PlayerA;
import UI.common.LimpidButton;
import UI.main.Hot;
import UI.main.Match;
import UI.main.Player;
import UI.main.Team;
import UI.main.init;
import VO.MatchVO;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bl_db.common.Team_map;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SingleMatch extends JDialog {
	private final JPanel contentPanel = new JPanel();
	
	public JPanel basicmatch;
	public JPanel datastastic;
	public JButton B;
	public JButton C;
	LimpidButton back;
	 final CardLayout cardLayout = new CardLayout();
	JPanel jp = new JPanel();
	MatchVO mvo;
	Team_map tm = new Team_map();
	

	public static void main(String[] args) {
		try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		try {
			SingleMatch dialog = new SingleMatch("洛杉矶湖人","2012-05-01");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	
	public SingleMatch(String name,String date) {
		System.out.println(date+";"+tm.getFullName(name));
		mvo = init.mbl.getMatchByTeam(date,tm.getFullName(name));
		
		getContentPane().setLayout(null);
		setSize(1060,620);
		setUndecorated(true);// 取消窗体修饰效果************		
		setLocation(UI.main.init.SysStart_X,UI.main.init.SysStart_Y+70);

		jp.setBounds(9,30,1042,582);
		jp.setLayout(cardLayout);
		getContentPane().add(jp);

		basicmatch=new MatchA(mvo);
		basicmatch.setBounds(9,30,1042,582);
		basicmatch.setOpaque(false);
		basicmatch.setLayout(null);
		jp.add(basicmatch,"基础");

		datastastic = new datastatistics(mvo);
		datastastic.setBounds(9,30,1042,582);
		datastastic.setOpaque(false);
		datastastic.setLayout(null);
		jp.add(datastastic,"统计");
		
		B = new JButton(new ImageIcon("newpic/add/数据对比.png"));
    	B.setToolTipText("数据对比");
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
            	if(!B.getToolTipText().equals("数据对比 "))
            		B.setIcon(new ImageIcon("newpic/add/数据对比.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/add/数据对比浮.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/数据对比浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/数据对比浮.png"));
            	C.setIcon(new ImageIcon("newpic/add/技术统计.png"));
            	cardLayout.show(jp, "基础");
            	B.setToolTipText("数据对比 ");
            	C.setToolTipText("技术统计");
            	
            }
        });

		C = new JButton(new ImageIcon("newpic/add/技术统计.png"));
    	C.setToolTipText("技术统计");
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
            	if(!C.getToolTipText().equals("技术统计 "))
            		C.setIcon(new ImageIcon("newpic/add/技术统计.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/add/技术统计浮.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/技术统计浮.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/技术统计浮.png"));
            	B.setIcon(new ImageIcon("newpic/add/数据对比.png"));
            	cardLayout.show(jp, "统计");
            	B.setToolTipText("数据对比");
            	C.setToolTipText("技术统计 ");
            	Match p;		
            	//currentpanel="match";
            	//System.out.println(currentpanel);
				
            }
        });
	
		B.setFocusPainted(false);
		C.setFocusPainted(false);
		//btnNewButton.setContentAreaFilled(false);
		B.setContentAreaFilled(false);
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
		ImageIcon image = new ImageIcon("newpic/比赛基础信息.jpg");
		image.setImage(image.getImage().getScaledInstance(1060, 620,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 1060, 620);		
		photo.setOpaque(false);
		getContentPane().add(photo);

		setLocationRelativeTo(null);
		
	}


	
}
