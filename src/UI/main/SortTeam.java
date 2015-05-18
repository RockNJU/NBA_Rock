package UI.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UI.common.SortItem_Map;

public class SortTeam extends JDialog {
	SortItem_Map map = new SortItem_Map();
	ArrayList<JButton> jbs = new ArrayList<JButton>();
	private JPanel contentPane;
	


	/**
	 * Create the dialog.
	 */
	public SortTeam() {
		getContentPane().setLayout(null);
		setSize(500,350);
		setUndecorated(true);// ȡ����������Ч��************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(
				"\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("����������W9", Font.PLAIN, 18));
		label.setBounds(10, 0, 188, 36);
		contentPane.add(label);
		JButton Ͷ�������� = new JButton("\u6295\u7BEE\u547D\u4E2D\u6570");
		Ͷ��������.setOpaque(false);
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��������.setBounds(251, 31, 106, 36);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		JButton Ͷ�������� = new JButton("\u6295\u7BEE\u51FA\u624B\u6570");
		Ͷ��������.setOpaque(false);
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��������.setBounds(369, 31, 106, 36);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		JButton ���������� = new JButton("\u4E09\u5206\u547D\u4E2D\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(20, 69, 106, 36);
		contentPane.add(����������);
		jbs.add(����������);
		JButton ���ֳ����� = new JButton("\u4E09\u5206\u51FA\u624B\u6570");
		���ֳ�����.setOpaque(false);
		���ֳ�����.setFont(new Font("����������W9", Font.PLAIN, 14));
		���ֳ�����.setBounds(133, 69, 106, 36);
		contentPane.add(���ֳ�����);
		jbs.add(���ֳ�����);
		JButton ���������� = new JButton("\u7F5A\u7403\u547D\u4E2D\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(250, 69, 106, 36);
		contentPane.add(����������);
		jbs.add(����������);
		JButton ��������� = new JButton("\u7F5A\u7403\u51FA\u624B\u6570");
		���������.setOpaque(false);
		���������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���������.setBounds(369, 69, 106, 36);
		contentPane.add(���������);
		jbs.add(���������);
		JButton ����Ч�� = new JButton("\u8FDB\u653B\u6548\u7387");
		����Ч��.setOpaque(false);
		����Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		����Ч��.setBounds(132, 257, 95, 36);
		contentPane.add(����Ч��);
		jbs.add(����Ч��);
		JButton ���������� = new JButton("\u9632\u5B88\u6548\u7387");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(251, 257, 95, 36);
		contentPane.add(����������);
		jbs.add(����������);
		JButton button_8 = new JButton("\u9632\u5B88\u7BEE\u677F\u7387");
		button_8.setOpaque(false);
		button_8.setFont(new Font("����������W9", Font.PLAIN, 14));
		button_8.setBounds(20, 298, 103, 36);
		contentPane.add(button_8);
		jbs.add(button_8);
		final JButton �����غ� = new JButton("\u8FDB\u653B\u56DE\u5408");
		�����غ�.setFont(new Font("����������W9", Font.PLAIN, 14));
		�����غ�.setBounds(20, 257, 95, 36);
		�����غ�.setOpaque(false);
		contentPane.add(�����غ�);
		jbs.add(�����غ�);
		final JButton ���� = new JButton("\u7BEE\u677F");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(97, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton ���� = new JButton("\u52A9\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(174, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton Ͷ�������� = new JButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��������.setBounds(20, 218, 106, 36);
		Ͷ��������.setOpaque(false);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		final JButton ���������� = new JButton("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(148, 218, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton ���������� = new JButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(278, 218, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton ���� = new JButton("\u62A2\u65AD");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(20, 110, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton ��ñ = new JButton("\u76D6\u5E3D");
		��ñ.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ñ.setBounds(104, 110, 67, 36);
		��ñ.setOpaque(false);
		contentPane.add(��ñ);
		jbs.add(��ñ);
		final JButton ʧ�� = new JButton("\u5931\u8BEF");
		ʧ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʧ��.setBounds(180, 110, 67, 36);
		ʧ��.setOpaque(false);
		contentPane.add(ʧ��);
		jbs.add(ʧ��);
		final JButton ���� = new JButton("\u72AF\u89C4");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(263, 110, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton �÷� = new JButton("\u5F97\u5206");
		�÷�.setFont(new Font("����������W9", Font.PLAIN, 14));
		�÷�.setBounds(20, 31, 67, 36);
		�÷�.setOpaque(false);
		contentPane.add(�÷�);
		jbs.add(�÷�);
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 189, 188, 36);
		contentPane.add(label_1);

		final JButton Ч�� = new JButton("\u80DC\u7387");
		Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ч��.setBounds(414, 218, 61, 36);
		Ч��.setOpaque(false);
		contentPane.add(Ч��);
		jbs.add(Ч��);

		final JButton ���������� = new JButton("\u8FDB\u653B\u7BEE\u677F\u7387");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(372, 257, 103, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton �������� = new JButton("\u8FDB\u653B\u7BEE\u677F");
		��������.setOpaque(false);
		��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��������.setBounds(20, 151, 105, 36);
		contentPane.add(��������);
		jbs.add(��������);
		final JButton �������� = new JButton("\u9632\u5B88\u7BEE\u677F");
		��������.setOpaque(false);
		��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��������.setBounds(135, 151, 106, 36);
		contentPane.add(��������);
		jbs.add(��������);
		final JButton ������ = new JButton("\u52A9\u653B\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(148, 298, 75, 36);
		contentPane.add(������);
		jbs.add(������);
		final JButton ������ = new JButton("\u62A2\u65AD\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(252, 298, 78, 36);
		contentPane.add(������);
		jbs.add(������);
		
		
		for(int i=0;i<jbs.size();i++){
			final JButton tempjb = jbs.get(i);
			final String name = tempjb.getText();
			tempjb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Team.do_this_whenclick(name);					
				}
			});
		}
		
		
		contentPane.setBackground(init.sysdarkblue);
		
		
	}
}
