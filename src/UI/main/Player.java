package UI.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class Player extends JPanel{
	static Player_Info p1;
	static Player_Data p2;
	static JPanel mainp;
	JButton statistics;
	JButton change;
	String nowp="info";
	final JButton find;
	public static JTextField textField;
	public Player(){
		setLayout(null);
		setSize(1060, 639);
		setOpaque(false);
		
		mainp=new Player_Info();
		mainp.setBounds(0, 30, 1060, 600);
		//mainp.setBackground(Color.BLACK);
		mainp.setOpaque(false);
		add(mainp);
		
		textField = new JTextField();
		textField.setBounds(950, 12, 66, 25);
		add(textField);
		textField.setColumns(10);
		
		statistics=new JButton("统计分析");
		statistics.setBounds(140,15, 94, 20);
		add(statistics);
		statistics.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {				
				
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
	
		
		find = new JButton(new ImageIcon("newpic/查找.png"));
		find.setBackground(init.syslightblue);
		find.setFocusPainted(false);
		find.setOpaque(false);
		find.setBounds(1020,12, 25, 25);
		//
		find.setToolTipText("查询");		
		this.add(find);
		
		find.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(nowp.equals("info")){
					Player_Info.pivo=init.pbl.getPlayerInfo(textField.getText());
					System.out.println((Player_Info.pivo.size()));
					Object info[][]=Player_Info.getinfodata(Player_Info.pivo);
				Player_Info.playerinfolist.updateTable(Player_Info.playerinfotitle, info);
				Player_Info.playerinfolist.FitTableColumns(Player_Info.playerinfolist.getTable());
				
				}
				else{
				if(Player_Data.a_t.equals("avg")){
					Object info2[][]=Player_Data.getAveragedata(init.pbl.keyfind(textField.getText()));
					Player_Data.playerdatalist.updateTable(Player_Data.playerAvgdatatitle, info2);
					Player_Data.playerdatalist.FitTableColumns(Player_Data.playerdatalist.getTable());
				}else{
					Object info2[][]=Player_Data.getTotaldata(init.pbl.keyfind(textField.getText()));
					Player_Data.playerdatalist.updateTable(Player_Data.playerTotaldatatitle, info2);
					Player_Data.playerdatalist.FitTableColumns(Player_Data.playerdatalist.getTable());
				}
				
				}
				
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
	
		
		change = new JButton(new ImageIcon("newpic/比赛信息前.png"));
		change.setToolTipText("切换到比赛信息");
		change.setBounds(36,15, 94, 20);
		add(change);
		
		
		change.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(change.getToolTipText().equals("切换到比赛信息")){
					nowp="data";
					change.setToolTipText("切换到基础信息");
					change.setIcon(new ImageIcon("newpic/基础信息前.png"));
					Player_Data p=new Player_Data();
					change(p);
				}else{
					nowp="info";
					change.setToolTipText("切换到比赛信息");
					change.setIcon(new ImageIcon("newpic/比赛信息前.png"));
					Player_Info p=new Player_Info();
					change(p);
				}
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
				if(change.getToolTipText().equals("切换到比赛信息")){
					change.setIcon(new ImageIcon("newpic/比赛信息浮.png"));
				}else{
					change.setIcon(new ImageIcon("newpic/基础信息浮.png"));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(change.getToolTipText().equals("切换到比赛信息")){
					change.setIcon(new ImageIcon("newpic/比赛信息前.png"));
				}else{
					change.setIcon(new ImageIcon("newpic/基础信息前.png"));
				}
			}
			
		});
	}
	
	
	void change(Player_Info ppanel){
		mainp.removeAll();
		mainp.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1060, 600);
		mainp.validate();
		mainp.repaint();
	}
	void change(Player_Data ppanel){
		mainp.removeAll();
		mainp.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1060, 600);
		mainp.validate();
		mainp.repaint();
	}
}
