package UI.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NoMatches extends JDialog {

	private final JPanel contentPanel = new JPanel();

	

	/**
	 * Create the dialog.
	 */
	public NoMatches() {
		setSize(260,180);
		setUndecorated(true);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JLabel lblNewLabel = new JLabel(Match_Data.dc.showDate.getText()+"  没有比赛 !",JLabel.CENTER);
		lblNewLabel.setBounds(0, 20, 260, 40);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel);
		
		System.out.println(Match_Data.dc.showDate.getText());
		JLabel lblNewLabel_1 = new JLabel("下一场比赛在  "+init.mbl.getNextHavingMatchDate(Match_Data.dc.showDate.getText())+" !",JLabel.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 80, 260, 40);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Match_Data.mdvo=init.mbl.getMatchByTeamTime(init.mbl.getNextHavingMatchDate(Match_Data.dc.showDate.getText()));
				dispose();
				Match_Data.dc.showDate.setText(init.mbl.getNextHavingMatchDate(Match_Data.dc.showDate.getText()));
				Match_Data.matchdata=Match_Data.getdata(Match_Data.mdvo);
				Match_Data.matchdatalist.updateTable(Match_Data.matchtitle, Match_Data.matchdata);
				Match_Data.matchdatalist.FitTableColumns(Match_Data.matchdatalist.getTable());
				Match_Data.setclwidth();
				//Match_Data.matchdatalist.setNthWidth(10, 230);
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
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(101, 147, 69, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		
		getContentPane().setBackground(init.sysdarkblue);
	}
}
