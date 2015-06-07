package UI.Match;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.main.init;

import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class datastatistics extends JPanel {

	String teamnameA = "奥尔良烤鸭";
	String teamnameB = "嘟嘟鸡排";
	
	public datastatistics() {
		
		JButton teamAButton = new JButton(teamnameA);
		teamAButton.setBackground(init.sysdarkblue);
		teamAButton.setForeground(init.syspurple);
		teamAButton.setFont(new Font("黑体", Font.BOLD, 18));
		teamAButton.setBounds(25, 8, 150, 50);
		this.add(teamAButton);
		
		JButton teamBButton = new JButton(teamnameB);
		teamBButton.setBackground(init.sysdarkblue);
		teamBButton.setForeground(init.syspurple);
		teamBButton.setFont(new Font("黑体", Font.BOLD, 18));
		teamBButton.setBounds(175, 8, 150, 50);
		this.add(teamBButton);
		
		ImageIcon image = new ImageIcon("newpic/比赛技术统计.jpg");
		image.setImage(image.getImage().getScaledInstance(1042, 580,Image.SCALE_DEFAULT));
		this.setLayout(null);
		JLabel photo = new JLabel(image);
		photo.setBounds(0, 0, 1042, 580);
		photo.setOpaque(false);
		this.add(photo);
	}

}
