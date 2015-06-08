package UI.Team;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
			
		A = new JButton(new ImageIcon("newpic/球员信息-平常.png"));
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
            	
            	TeamA a=new TeamA(na);
            	change(a);
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
            	TeamB a=new TeamB(na);
            	change(a);
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
            
            	TeamC a=new TeamC(na);
            	change(a);
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
            	//Teambutton.setIcon(new ImageIcon("newpic/球员信息-平常.png"));
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
