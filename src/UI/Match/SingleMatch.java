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
			SingleMatch dialog = new SingleMatch("��ɼ����","2012-05-01");
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
		setUndecorated(true);// ȡ����������Ч��************		
		setLocation(UI.main.init.SysStart_X,UI.main.init.SysStart_Y+70);

		jp.setBounds(9,30,1042,582);
		jp.setLayout(cardLayout);
		getContentPane().add(jp);

		basicmatch=new MatchA(mvo);
		basicmatch.setBounds(9,30,1042,582);
		basicmatch.setOpaque(false);
		basicmatch.setLayout(null);
		jp.add(basicmatch,"����");

		datastastic = new datastatistics(mvo);
		datastastic.setBounds(9,30,1042,582);
		datastastic.setOpaque(false);
		datastastic.setLayout(null);
		jp.add(datastastic,"ͳ��");
		
		B = new JButton(new ImageIcon("newpic/add/���ݶԱ�.png"));
    	B.setToolTipText("���ݶԱ�");
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
            	if(!B.getToolTipText().equals("���ݶԱ� "))
            		B.setIcon(new ImageIcon("newpic/add/���ݶԱ�.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/add/���ݶԱȸ�.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/���ݶԱȸ�.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/���ݶԱȸ�.png"));
            	C.setIcon(new ImageIcon("newpic/add/����ͳ��.png"));
            	cardLayout.show(jp, "����");
            	B.setToolTipText("���ݶԱ� ");
            	C.setToolTipText("����ͳ��");
            	
            }
        });

		C = new JButton(new ImageIcon("newpic/add/����ͳ��.png"));
    	C.setToolTipText("����ͳ��");
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
            	if(!C.getToolTipText().equals("����ͳ�� "))
            		C.setIcon(new ImageIcon("newpic/add/����ͳ��.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/add/����ͳ�Ƹ�.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/����ͳ�Ƹ�.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/����ͳ�Ƹ�.png"));
            	B.setIcon(new ImageIcon("newpic/add/���ݶԱ�.png"));
            	cardLayout.show(jp, "ͳ��");
            	B.setToolTipText("���ݶԱ�");
            	C.setToolTipText("����ͳ�� ");
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
		
		
		

		back = new LimpidButton("","newpic/�ر�.png");
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
            	dispose();// ���ٴ���
            }
        });
		addMouseMotionListener(new MouseMotionListener() {

			/**
			* ��������϶��¼�
			* */
			public void mouseDragged(MouseEvent arg0) {
			
			}

			/**
			* ��������ƶ��¼�
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
		 * ����ͼƬ
		 */
		ImageIcon image = new ImageIcon("newpic/����������Ϣ.jpg");
		image.setImage(image.getImage().getScaledInstance(1060, 620,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 1060, 620);		
		photo.setOpaque(false);
		getContentPane().add(photo);

		setLocationRelativeTo(null);
		
	}


	
}
