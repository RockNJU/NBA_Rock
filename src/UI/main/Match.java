package UI.main;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UI.common.ComboBoxRenderer;
import UI.common.DateChooser;
import UI.common.TeamName_Map;

public class Match extends JPanel{
	static Match_Data p1;
	static Match_Process p2;
	static JPanel mainp;
	//static int changetime;
	JButton change;
	
	public Match(){
		setLayout(null);
		setSize(1060, 639);
		setOpaque(false);
		
	
		
		
		mainp=new Match_Data();
		mainp.setBounds(0, 30, 1060, 600);
		//mainp.setBackground(Color.BLACK);
		mainp.setOpaque(false);
		add(mainp);
		
		
		
		
		
		change = new JButton(new ImageIcon("newpic/赛程前.png"));
		change.setToolTipText("切换到赛程");
		change.setBounds(36,15, 94, 20);
		add(change);
		
		
		change.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO Auto-generated method stub
				if(change.getToolTipText().equals("切换到赛程")){
					change.setToolTipText("切换到数据");
					change.setIcon(new ImageIcon("newpic/数据前.png"));
					Match_Process p;
					try {
						p = new Match_Process();
					
						change(p);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					change.setToolTipText("切换到赛程");
					change.setIcon(new ImageIcon("newpic/赛程前.png"));
					Match_Data p=new Match_Data();
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
				if(change.getToolTipText().equals("切换到赛程")){
					change.setIcon(new ImageIcon("newpic/赛程浮.png"));
				}else{
					change.setIcon(new ImageIcon("newpic/数据浮.png"));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(change.getToolTipText().equals("切换到赛程")){
					change.setIcon(new ImageIcon("newpic/赛程前.png"));
				}else{
					change.setIcon(new ImageIcon("newpic/数据前.png"));
				}
			}
			
		});
	}
	
	
	void change(Match_Data ppanel){
		mainp.removeAll();
		mainp.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1060, 600);
		mainp.validate();
		mainp.repaint();
	}
	void change(Match_Process ppanel){
		mainp.removeAll();
		mainp.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,1060, 600);
		mainp.validate();
		mainp.repaint();
	}
}
