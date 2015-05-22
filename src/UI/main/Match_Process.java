package UI.main;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Match_Process extends JPanel {

	/**
	 * Create the panel.
	 */
	public Match_Process() {
		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(175, 65, 121, 23);
		add(rdbtnNewRadioButton);
	}
}
