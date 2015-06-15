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
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public B() {
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		setBackground(init.syslightblue);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\"\u52D2\u5E03\u6717-\u8A79\u59C6\u65AF\""}));
		

		comboBox.setBounds(28, 30, 125, 29);
		add(comboBox);
		
		JButton 提交 = new JButton("\u63D0\u4EA4");
		提交.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tt.useischangealot(comboBox.getSelectedItem().toString());
				textField.setText(tt.maxString+"数据在换队后波动最大");
				double data[] = tt.useisbetterafterturn(comboBox.getSelectedItem().toString());
				StringBuffer sb = new StringBuffer();
				for(int i = 0;i<6;i++){
					sb.append(tt.input[i]+"的p值为"+Double.toString(data[i])+",所以"+"显著提升");
				}
			}
		});
		提交.setBounds(180, 33, 93, 23);
		add(提交);
		

		textPane.setText("\u5404\u6570\u636E\u6CE2\u52A8\u60C5\u51B5\r\n\u6492\u65E6\u6CD5");
		textPane.setEditable(false);
		textPane.setBounds(38, 106, 220, 209);
		add(textPane);
		
		textField = new JTextField();
		textField.setText("\u6CE2\u52A8\u6700\u5927\u7684\u6570\u636E");
		textField.setEditable(false);
		textField.setBounds(38, 69, 220, 27);
		add(textField);
		textField.setColumns(10);
	}
}
