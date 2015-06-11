package UI.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import bl_db.common.Team_map;

import java.awt.Font;
import java.awt.Color;



public class AllTeams extends JDialog {

	Team_map tm=new Team_map();
	private JPanel contentPane;
	JPanel A;
	JPanel B;
	JPanel C;
	JPanel D;
	JPanel E;
	JPanel F;
	JLabel p1;
	JLabel p2;
	JLabel a;
	JLabel b;
	JLabel c;
	JLabel d;
	JLabel e;
	JLabel f;
	//东部
	/**
	 * 大西洋
	 */
	ArrayList<JButton>  atlantic=new ArrayList<JButton>();
	ArrayList<JLabel>  atl=new ArrayList<JLabel>();
	ArrayList<String> at=new ArrayList<String>();
	/**
	 * 中央
	 */
	ArrayList<JButton> central=new ArrayList<JButton>();
	ArrayList<JLabel>  cen=new ArrayList<JLabel>();
	ArrayList<String> ce=new ArrayList<String>();
	/**
	 * 东南
	 */
	ArrayList<JButton> east_south=new ArrayList<JButton>();
	ArrayList<JLabel>  e_s=new ArrayList<JLabel>();
	ArrayList<String> es=new ArrayList<String>();
	//西部
	/**
	 * 西北
	 */
	ArrayList<JButton> west_north =new ArrayList<JButton>();
	ArrayList<JLabel>  w_n=new ArrayList<JLabel>();
	ArrayList<String> wn=new ArrayList<String>();
	/**
	 *太平洋
	 */
	ArrayList<JButton> pacific=new ArrayList<JButton>();
	ArrayList<JLabel>  pac=new ArrayList<JLabel>();
	ArrayList<String> pa=new ArrayList<String>();
	/**
	 * 西南
	 */
	ArrayList<JButton> west_south=new ArrayList<JButton>();	
	ArrayList<JLabel>  w_s=new ArrayList<JLabel>();
	ArrayList<String> ws=new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AllTeams dialog = new AllTeams();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AllTeams() {
		getContentPane().setLayout(null);
		setSize(580,330);
		setUndecorated(true);// 取消窗体修饰效果************
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		at=init.tbl.getTeamByPartition("大西洋");
		ce=init.tbl.getTeamByPartition("中部");
		es=init.tbl.getTeamByPartition("东南");
		wn=init.tbl.getTeamByPartition("西北");
		pa=init.tbl.getTeamByPartition("太平洋");
		ws=init.tbl.getTeamByPartition("西南");
		
		p1=new JLabel("东部分区：");
		p1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 15));
		p1.setBounds(10,0,80,30);
		contentPane.add(p1);
		p2=new JLabel("西部分区：");
		p2.setFont(new Font("华康雅宋体W9", Font.PLAIN, 15));
		p2.setBounds(300,0,80,30);
		contentPane.add(p2);
		
		a=new JLabel("大西洋分区：");
		a.setForeground(Color.DARK_GRAY);
		a.setFont(new Font("华康雅宋体W9", Font.PLAIN, 13));
		a.setBounds(10,20,80,30);
		contentPane.add(a);
		b=new JLabel("中央分区：");
		b.setForeground(Color.DARK_GRAY);
		b.setFont(new Font("华康雅宋体W9", Font.PLAIN, 13));
		b.setBounds(10,117,65,30);
		contentPane.add(b);
		c=new JLabel("东南分区：");
		c.setForeground(Color.DARK_GRAY);
		c.setFont(new Font("华康雅宋体W9", Font.PLAIN, 13));
		c.setBounds(10,215,65,30);
		contentPane.add(c);
		d=new JLabel("西北分区：");
		d.setForeground(Color.DARK_GRAY);
		d.setFont(new Font("华康雅宋体W9", Font.PLAIN, 13));
		d.setBounds(300,20,65,30);
		contentPane.add(d);
		e=new JLabel("太平洋分区：");
		e.setForeground(Color.DARK_GRAY);
		e.setFont(new Font("华康雅宋体W9", Font.PLAIN, 13));
		e.setBounds(300,117,80,30);
		contentPane.add(e);
		f=new JLabel("西南分区：");
		f.setFont(new Font("华康雅宋体W9", Font.PLAIN, 13));
		f.setForeground(Color.DARK_GRAY);
		f.setBounds(300,215,65,30);
		contentPane.add(f);
		
		
		A=new JPanel();
		A.setBounds(10, 46, 270, 75);
		contentPane.add(A);
		A.setBackground(init.syslightblue);
		A.setLayout(null);
		
		B=new JPanel();
		B.setBounds(10, 143, 270, 75);
		B.setBackground(init.syslightblue);
		contentPane.add(B);
		B.setLayout(null);
		
		C=new JPanel();
		C.setBounds(10, 242, 270, 75);
		C.setBackground(init.syslightblue);
		contentPane.add(C);
		C.setLayout(null);
		
		D=new JPanel();
		D.setBounds(300, 46, 270, 75);
		D.setBackground(init.syslightblue);
		contentPane.add(D);
		D.setLayout(null);
		
		E=new JPanel();
		E.setBounds(300, 143, 270, 75);
		E.setBackground(init.syslightblue);
		contentPane.add(E);
		E.setLayout(null);
		
		F=new JPanel();
		F.setBounds(300, 242, 270, 75);
		F.setBackground(init.syslightblue);
		contentPane.add(F);
		F.setLayout(null);
		
		for(int i=0;i<at.size();i++){
			System.out.println(at.get(i));
			final ImageIcon pic = new ImageIcon("newpic/TEAMPNG/"+at.get(i)+".png");
			pic.setImage(pic.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
			JButton jbt=new JButton(pic);
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			jbt.setSize(50,50);
			jbt.setLocation(50*i+5*i, 5);
			atlantic.add(jbt);
			A.add(jbt);
		}
		for(int i=0;i<at.size();i++){			
			JLabel jbl=new JLabel(tm.getFullName(at.get(i)),JLabel.CENTER);
			jbl.setSize(50, 25);
			jbl.setFont(new Font("Dialog", 0, 10));
			jbl.setLocation(50*i+5*i, 50);
			A.add(jbl);
		}
		
		for(int i=0;i<ce.size();i++){
			final ImageIcon pic = new ImageIcon("newpic/TEAMPNG/"+ce.get(i)+".png");
			pic.setImage(pic.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
			JButton jbt=new JButton(pic);
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			jbt.setSize(50,50);
			jbt.setLocation(50*i+5*i, 5);
			central.add(jbt);
			B.add(jbt);
		}
		for(int i=0;i<ce.size();i++){			
			JLabel jbl=new JLabel(tm.getFullName(ce.get(i)),JLabel.CENTER);
			jbl.setSize(50, 25);
			jbl.setLocation(50*i+5*i, 50);
			jbl.setFont(new Font("Dialog", 0, 10));
			B.add(jbl);
		}
		
		for(int i=0;i<es.size();i++){
			final ImageIcon pic = new ImageIcon("newpic/TEAMPNG/"+es.get(i)+".png");
			pic.setImage(pic.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
			JButton jbt=new JButton(pic);
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			jbt.setSize(50,50);
			jbt.setLocation(50*i+5*i, 5);
			east_south.add(jbt);
			C.add(jbt);
		}
		for(int i=0;i<es.size();i++){			
			JLabel jbl=new JLabel(tm.getFullName(es.get(i)),JLabel.CENTER);
			jbl.setSize(50, 25);
			jbl.setLocation(50*i+5*i, 50);
			jbl.setFont(new Font("Dialog", 0, 10));
			C.add(jbl);
		}
		
		
		for(int i=0;i<wn.size();i++){
			final ImageIcon pic = new ImageIcon("newpic/TEAMPNG/"+wn.get(i)+".png");
			pic.setImage(pic.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
			JButton jbt=new JButton(pic);
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			jbt.setSize(50,50);
			jbt.setLocation(50*i+5*i, 5);
			west_north.add(jbt);
			D.add(jbt);
		}
		for(int i=0;i<wn.size();i++){			
			JLabel jbl=new JLabel(tm.getFullName(wn.get(i)),JLabel.CENTER);
			jbl.setSize(50, 25);
			jbl.setLocation(50*i+5*i, 50);
			jbl.setFont(new Font("Dialog", 0, 10));
			D.add(jbl);
		}
		
		
		for(int i=0;i<pa.size();i++){
			final ImageIcon pic = new ImageIcon("newpic/TEAMPNG/"+pa.get(i)+".png");
			pic.setImage(pic.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
			JButton jbt=new JButton(pic);
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			jbt.setSize(50,50);
			jbt.setLocation(50*i+5*i, 5);
			pacific.add(jbt);
			E.add(jbt);
		}
		for(int i=0;i<pa.size();i++){			
			JLabel jbl=new JLabel(tm.getFullName(pa.get(i)),JLabel.CENTER);
			jbl.setSize(50, 25);
			jbl.setLocation(50*i+5*i, 50);
			jbl.setFont(new Font("Dialog", 0, 10));
			E.add(jbl);
		}
		
		
		for(int i=0;i<ws.size();i++){
			final ImageIcon pic = new ImageIcon("newpic/TEAMPNG/"+ws.get(i)+".png");
			pic.setImage(pic.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
			JButton jbt=new JButton(pic);
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			jbt.setSize(50,50);
			
			jbt.setLocation(50*i+5*i, 5);
			west_south.add(jbt);
			F.add(jbt);
		}
		for(int i=0;i<ws.size();i++){			
			JLabel jbl=new JLabel(tm.getFullName(ws.get(i)),JLabel.CENTER);
			jbl.setSize(50, 25);
			jbl.setLocation(50*i+5*i, 50);
			jbl.setFont(new Font("Dialog", 0, 10));
			F.add(jbl);
		}
		
		for(int i=0;i<atlantic.size();i++){
			atlantic.get(i).addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 打开单独窗口
					Team.cleartime();
					dispose();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		for(int i=0;i<west_south.size();i++){
			west_south.get(i).addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 打开单独窗口
					dispose();
					Team.cleartime();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		for(int i=0;i<pacific.size();i++){
			pacific.get(i).addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 打开单独窗口
					dispose();
					Team.cleartime();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		for(int i=0;i<east_south.size();i++){
			east_south.get(i).addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 打开单独窗口
					dispose();
					Team.cleartime();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		for(int i=0;i<central.size();i++){
			central.get(i).addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 打开单独窗口
					dispose();
					Team.cleartime();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		for(int i=0;i<west_north.size();i++){
			west_north.get(i).addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 打开单独窗口
					Team.cleartime();
					dispose();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
	
		contentPane.setBackground(init.sysdarkblue);
	}

}
