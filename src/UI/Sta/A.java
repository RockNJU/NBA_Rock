package UI.Sta;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class A extends JPanel {

	int[] age_apart={20,30,40};
	int[] point_apart={};
	/**
	 * Create the panel.
	 */
	public A() {
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		
		JComboBox X = new JComboBox();
		X.setModel(new DefaultComboBoxModel(new String[] {"\u5E74\u9F84", "\u8EAB\u9AD8", "\u4F4D\u7F6E"}));
		X.setBounds(45, 57, 119, 32);
		add(X);
		
		JComboBox Y = new JComboBox();
		Y.setModel(new DefaultComboBoxModel(new String[] {"\u5F97\u5206", "\u7BEE\u677F", "\u52A9\u653B", "\u76D6\u5E3D", "\u62A2\u65AD"}));
		Y.setBounds(207, 57, 119, 32);
		add(Y);
		
		
	}
}
