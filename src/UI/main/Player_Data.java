package UI.main;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Player_Data extends JPanel{
	
	
	public Player_Data(){

		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		//setBackground(init.sysdarkblue);
		//setBackground(Color.BLUE);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Newsddton");
		rdbtnNewRadioButton.setBounds(34, 333, 248, 93);
		add(rdbtnNewRadioButton);
	}
}
