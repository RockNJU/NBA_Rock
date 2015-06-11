package UI.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import UI.main.Hot;
import UI.main.Match;
import UI.main.Player;
import UI.main.Team;

public class SinglePlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static JPanel rightpanel;
	public JButton A;
	public JButton B;
	public JButton C;
	public JButton D;
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
			SinglePlayer dialog = new SinglePlayer("Aaron Brooks");
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
		add(rightpanel);
			
		A = new JButton(new ImageIcon("newpic/��Ա��Ϣ-ƽ��.png"));
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
            	if(!A.getToolTipText().equals("��Ա��Ϣ "))
            	A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ƽ��.png"));
            	else
            		A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ѡ��.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-�ϸ�.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ѡ��.png"));
            	B.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	D.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	C.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	A.setToolTipText("��Ա��Ϣ ");
            	D.setToolTipText("������Ϣ");
            	B.setToolTipText("������Ϣ");
            	C.setToolTipText("������Ϣ");	
            	PlayerA a=new PlayerA(na);
            	change(a);
            	
            }
        });
		
		B = new JButton(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
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
            	if(!B.getToolTipText().equals("������Ϣ "))
            		B.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	else
            		B.setIcon(new ImageIcon("newpic/������Ϣ-ѡ��.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/������Ϣ-�ϸ�.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	B.setIcon(new ImageIcon("newpic/������Ϣ-ѡ��.png"));
            	D.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ƽ��.png"));
            	C.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	
            	A.setToolTipText("��Ա��Ϣ");
            	D.setToolTipText("������Ϣ");
            	B.setToolTipText("������Ϣ ");
            	C.setToolTipText("������Ϣ");
            	
            	b=new PlayerB(na);
            	change(b);
            	
            }
        });

		C = new JButton(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
    	C.setToolTipText("������Ϣ");
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
            	if(!C.getToolTipText().equals("������Ϣ "))
            		C.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	else
            		C.setIcon(new ImageIcon("newpic/������Ϣ-ѡ��.png"));
              
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/������Ϣ-�ϸ�.png"));               
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	C.setIcon(new ImageIcon("newpic/������Ϣ-ѡ��.png"));
            	B.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	D.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ƽ��.png"));
            	
            	A.setToolTipText("��Ա��Ϣ");
            	D.setToolTipText("������Ϣ");
            	B.setToolTipText("������Ϣ");
            	C.setToolTipText("������Ϣ ");
            	c=new PlayerC(na);
				change(c);
            }
        });

		D = new JButton(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
    	D.setToolTipText("������Ϣ");
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
            	if(!D.getToolTipText().equals("������Ϣ "))
            		D.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	else
            		D.setIcon(new ImageIcon("newpic/������Ϣ-ѡ��.png"));
            	//hotbutton.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	D.setIcon(new ImageIcon("newpic/������Ϣ-�ϸ�.png"));
                // TODO Auto-generated method stub
            	//hotbutton.setIcon(new ImageIcon("newpic/������Ϣ-ao.png"));
            	//teambutton.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	//playerbutton.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ƽ��.png"));
            	//matchbutton.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	D.setIcon(new ImageIcon("newpic/������Ϣ-ѡ��.png"));
            	B.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	A.setIcon(new ImageIcon("newpic/��Ա��Ϣ-ƽ��.png"));
            	C.setIcon(new ImageIcon("newpic/������Ϣ-ƽ��.png"));
            	
            	A.setToolTipText("��Ա��Ϣ");
            	D.setToolTipText("������Ϣ ");
            	B.setToolTipText("������Ϣ");
            	C.setToolTipText("������Ϣ");		
            	
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
		
		
		
		
		/**
		 * ����ͼƬ
		 */
		ImageIcon image = new ImageIcon("newpic/������Ϣʹ��.jpg");
		image.setImage(image.getImage().getScaledInstance(1060, 620,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 1060, 620);		
		photo.setOpaque(false);
		add(photo);

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
