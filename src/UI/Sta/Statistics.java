package UI.Sta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import UI.common.LimpidButton;
import UI.main.init;

public class Statistics extends JDialog {
	private final JPanel contentPanel = new JPanel();
	LimpidButton  back;
	public static JPanel rightpanel;
	public JButton A;
	public JButton B;

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
			Statistics dialog = new Statistics();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Statistics() {
		
		getContentPane().setLayout(null);
		setSize(1060,620);
		setUndecorated(true);// 取消窗体修饰效果************		
		setLocation(UI.main.init.SysStart_X,UI.main.init.SysStart_Y+70);

		rightpanel=new A();
		rightpanel.setBounds(9,30,1042,580);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		getContentPane().add(rightpanel);
		

	A=new JButton("球员属性分析");
	A.setLocation(85, 0);
	A.setSize(156, 29);
	getContentPane().add(A);
	A.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			A a=new A();
			change(a);
		}
		
	});

	B = new JButton("\u8F6C\u4F1A\u7403\u5458\u5206\u6790");
	B.setBounds(280, 0, 156, 29);
	getContentPane().add(B);
	B.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			B a=new B();
			change(a);
		}
		
	});
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
	static void change(A ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
	static void change(B ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1042,580);
		rightpanel.validate();
		rightpanel.repaint();
	}
}
