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
			SinglePlayer dialog = new SinglePlayer("��¡-��³��˹");
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
		setUndecorated(true);// ȡ����������Ч��************		
		setLocation(UI.main.init.SysStart_X,UI.main.init.SysStart_Y+70);

		this.na=name;
		/**
		 * TODO 
		 * 
		 * ���ԶԳ�ʼ����������ӭ�����ĸĽ�
		 */
		rightpanel=new PlayerA(name);
		rightpanel.setBounds(9,30,1042,580);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		getContentPane().add(rightpanel);
			
		A = new JButton(new ImageIcon("newpic/add/������Ϣ��.png"));
    	A.setToolTipText("������Ϣ");
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
            	if(!A.getToolTipText().equals("������Ϣ"))
            	A.setIcon(new ImageIcon("newpic/add/������Ϣ.png"));
            	else
            		A.setIcon(new ImageIcon("newpic/add/������Ϣ��.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	A.setIcon(new ImageIcon("newpic/add/������Ϣ��.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	A.setIcon(new ImageIcon("newpic/add/������Ϣ��.png"));
            	B.setIcon(new ImageIcon("newpic/add/���ƶԱ�.png"));
            	C.setIcon(new ImageIcon("newpic/add/��Ա�Ա�.png"));
            	A.setToolTipText("������Ϣ");
            	B.setToolTipText("���ƶԱ�");
            	C.setToolTipText("��Ա�Ա�");	
            	PlayerA a=new PlayerA(na);
            	change(a);
            	
            }
        });
		
		B = new JButton(new ImageIcon("newpic/add/���ƶԱ�.png"));
    	B.setToolTipText("���ƶԱ�");
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
            	if(!B.getToolTipText().equals("���ƶԱ�"))
            		B.setIcon(new ImageIcon("newpic/add/���ƶԱ�.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/add/���ƶԱȸ�.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/���ƶԱȸ�.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/add/���ƶԱȸ�.png"));
            	A.setIcon(new ImageIcon("newpic/add/������Ϣ.png"));
            	C.setIcon(new ImageIcon("newpic/add/��Ա�Ա�.png"));
            	
            	A.setToolTipText("������Ϣ");
            	B.setToolTipText("���ƶԱ�");
            	C.setToolTipText("��Ա�Ա�");
            	
            	c=new PlayerC(na);
            	change(c);
            	
            }
        });

		C = new JButton(new ImageIcon("newpic/add/��Ա�Ա�.png"));
    	C.setToolTipText("��Ա�Ա�");
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
            	if(!C.getToolTipText().equals("��Ա�Ա�"))
            		C.setIcon(new ImageIcon("newpic/add/��Ա�Ա�.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/add/��Ա�Աȸ�.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/��Ա�Աȸ�.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/add/��Ա�Աȸ�.png"));
            	B.setIcon(new ImageIcon("newpic/add/���ƶԱ�.png"));
            	A.setIcon(new ImageIcon("newpic/add/������Ϣ.png"));
            	
            	A.setToolTipText("������Ϣ");
            	B.setToolTipText("���ƶԱ�");
            	C.setToolTipText("��Ա�Ա�");
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
		ImageIcon image = new ImageIcon("newpic/������Ϣʹ��.jpg");
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
