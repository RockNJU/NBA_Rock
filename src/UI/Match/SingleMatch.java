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
import VO.MatchVO;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SingleMatch extends JDialog {
	private final JPanel contentPanel = new JPanel();
	
	public JPanel basicmatch;
	public JPanel datastastic;
	public JButton A;
	public JButton B;
	public JButton C;
	public JButton D;
	LimpidButton back;
	 final CardLayout cardLayout = new CardLayout();
	JPanel jp = new JPanel();
	MatchVO mvo;

	public static void main(String[] args) {
		try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		try {
			SingleMatch dialog = new SingleMatch("Aaron Brooks","11-11");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings("null")
	
	public SingleMatch(String name,String date) {
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

		datastastic = new datastatistics();
		datastastic.setBounds(9,30,1042,582);
		datastastic.setOpaque(false);
		datastastic.setLayout(null);
		jp.add(datastastic,"统计");
		
		A = new JButton(new ImageIcon("newpic/球员信息-平常.png"));
		A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cardLayout.previous(jp);
			}
		});
    	A.setToolTipText("\u57FA\u672C\u4FE1\u606F");
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
            	if(!A.getToolTipText().equals("球员信息 "))
            	A.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	else
            		A.setIcon(new ImageIcon("newpic/球员信息-选中.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	A.setIcon(new ImageIcon("newpic/球员信息-上浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	

        		
            	
            	A.setToolTipText("球员信息 ");
            	A.setIcon(new ImageIcon("newpic/球员信息-选中.png"));
            	B.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	D.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	C.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));

            	D.setToolTipText("热门信息");
            	B.setToolTipText("队伍信息");
            	C.setToolTipText("比赛信息");	
            	
            	
            }
        });
		
		B = new JButton(new ImageIcon("newpic/队伍信息-平常.png"));
    	B.setToolTipText("\u6BD4\u8D5B\u4FE1\u606F");
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
            	if(!B.getToolTipText().equals("队伍信息 "))
            		B.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/队伍信息-选中.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/队伍信息-上浮.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/队伍信息-选中.png"));
            	D.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	A.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	C.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	
            	A.setToolTipText("球员信息");
            	D.setToolTipText("热门信息");
            	B.setToolTipText("队伍信息 ");
            	C.setToolTipText("比赛信息");
            	
            }
        });

		C = new JButton(new ImageIcon("newpic/比赛信息-平常.png"));
    	C.setToolTipText("比赛信息");
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
            	if(!C.getToolTipText().equals("比赛信息 "))
            		C.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/比赛信息-选中.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/比赛信息-上浮.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/比赛信息-选中.png"));
            	B.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	D.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	A.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	
            	A.setToolTipText("球员信息");
            	D.setToolTipText("热门信息");
            	B.setToolTipText("队伍信息");
            	C.setToolTipText("比赛信息 ");
            	Match p;		
            	//currentpanel="match";
            	//System.out.println(currentpanel);
				
            }
        });

		D = new JButton(new ImageIcon("newpic/热门信息-平常.png"));
    	D.setToolTipText("热门信息");
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
            	if(!D.getToolTipText().equals("热门信息 "))
            		D.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            	else
            		D.setIcon(new ImageIcon("newpic/热门信息-选中.png"));
            	//hotbutton.setIcon(new ImageIcon("newpic/热门信息-平常.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	D.setIcon(new ImageIcon("newpic/热门信息-上浮.png"));
                // TODO Auto-generated method stub
            	//hotbutton.setIcon(new ImageIcon("newpic/热门信息-ao.png"));
            	//teambutton.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	//playerbutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	//matchbutton.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {

            	
            	D.setIcon(new ImageIcon("newpic/热门信息-选中.png"));
            	B.setIcon(new ImageIcon("newpic/队伍信息-平常.png"));
            	A.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
            	C.setIcon(new ImageIcon("newpic/比赛信息-平常.png"));
            	
            	A.setToolTipText("球员信息");
            	D.setToolTipText("热门信息 ");
            	B.setToolTipText("队伍信息");
            	C.setToolTipText("比赛信息");
            	Hot p;			
            	
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
