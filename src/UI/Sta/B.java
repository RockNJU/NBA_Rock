package UI.Sta;

import javax.swing.JPanel;

import UI.main.init;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class B extends JPanel {
	JComboBox comboBox = new JComboBox();
	JTextPane textPane = new JTextPane();
	TrunTeam tt = new TrunTeam();
	String before;
	String after;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public B() {
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		setBackground(init.syslightblue);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"勒布朗-詹姆斯","雷-阿伦"}));
		

		comboBox.setBounds(28, 30, 125, 29);
		add(comboBox);
		
		JButton 提交 = new JButton("\u63D0\u4EA4");
		提交.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("勒布朗-詹姆斯")){
					before = "13-14";
					after = "14-15";
				}
				else if(comboBox.getSelectedItem().toString().equals("雷-阿伦")){
					before = "11-12";
					after = "12-13";
				}
				tt.useischangealot(comboBox.getSelectedItem().toString(),before,after);
				textField.setText(tt.maxString+"数据在换队后波动最大");
				double data[] = tt.useisbetterafterturn(comboBox.getSelectedItem().toString(),before,after);
				StringBuffer sb = new StringBuffer();
				for(int i = 0;i<6;i++){
					sb.append(tt.input[i]+"的p值为"+Double.toString(data[i])+",所以"+tt.outputisornot[i]+"显著提升\n");
				}
				textPane.setText(sb.toString());
			}
		});
		提交.setBounds(180, 33, 93, 23);
		add(提交);
		

		textPane.setText("\u5404\u6570\u636E\u6CE2\u52A8\u60C5\u51B5\r");
		textPane.setEditable(false);
		textPane.setBounds(38, 106, 220, 250);
		add(textPane);
		
		textField = new JTextField();
		textField.setText("\u6CE2\u52A8\u6700\u5927\u7684\u6570\u636E");
		textField.setEditable(false);
		textField.setBounds(38, 69, 220, 27);
		add(textField);
		textField.setColumns(10);
	}
}
