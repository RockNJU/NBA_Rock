package UI.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import UI.common.SortItem_Map;

public class SortPlayer extends JDialog {
	SortItem_Map map = new SortItem_Map();
	ArrayList<JButton> jbs = new ArrayList<JButton>();
	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public SortPlayer() {
		setLayout(null);
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

		final JButton �������� = new JButton("\u53C2\u8D5B\u573A\u6570");

		��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��������.setBounds(20, 31, 95, 36);
		��������.setOpaque(false);
		contentPane.add(��������);
		jbs.add(��������);
		final JButton �ȷ����� = new JButton("\u5148\u53D1\u573A\u6570");
		�ȷ�����.setFont(new Font("����������W9", Font.PLAIN, 14));
		�ȷ�����.setBounds(133, 31, 95, 36);
		�ȷ�����.setOpaque(false);
		contentPane.add(�ȷ�����);
		jbs.add(�ȷ�����);
		final JButton ���� = new JButton("\u7BEE\u677F");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(242, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton ���� = new JButton("\u52A9\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(318, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton �ϳ�ʱ�� = new JButton("\u4E0A\u573A\u65F6\u95F4");
		�ϳ�ʱ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		�ϳ�ʱ��.setBounds(399, 31, 95, 36);
		�ϳ�ʱ��.setOpaque(false);
		contentPane.add(�ϳ�ʱ��);
		jbs.add(�ϳ�ʱ��);
		final JButton Ͷ�������� = new JButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��������.setBounds(20, 69, 106, 36);
		Ͷ��������.setOpaque(false);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		final JButton ���������� = new JButton("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(130, 69, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton ���������� = new JButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(242, 69, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton ���� = new JButton("\u8FDB\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(353, 69, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton ���� = new JButton("\u9632\u5B88");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(427, 69, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton ���� = new JButton("\u62A2\u65AD");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(20, 107, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton ��ñ = new JButton("\u76D6\u5E3D");
		��ñ.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ñ.setBounds(104, 107, 67, 36);
		��ñ.setOpaque(false);
		contentPane.add(��ñ);
		jbs.add(��ñ);
		final JButton ʧ�� = new JButton("\u5931\u8BEF");
		ʧ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʧ��.setBounds(180, 107, 67, 36);
		ʧ��.setOpaque(false);
		contentPane.add(ʧ��);
		jbs.add(ʧ��);
		final JButton ���� = new JButton("\u72AF\u89C4");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(263, 107, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JButton �÷� = new JButton("\u5F97\u5206");
		�÷�.setFont(new Font("����������W9", Font.PLAIN, 14));
		�÷�.setBounds(344, 107, 67, 36);
		�÷�.setOpaque(false);
		contentPane.add(�÷�);
		jbs.add(�÷�);
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 149, 188, 36);
		contentPane.add(label_1);

		final JButton Ч�� = new JButton("\u6548\u7387");
		Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ч��.setBounds(20, 180, 61, 36);
		Ч��.setOpaque(false);
		contentPane.add(Ч��);
		jbs.add(Ч��);
		final JButton Gmsc = new JButton("GmSC\u6548\u7387\u503C");
		Gmsc.setFont(new Font("����������W9", Font.PLAIN, 14));
		Gmsc.setBounds(87, 180, 105, 36);
		Gmsc.setOpaque(false);
		contentPane.add(Gmsc);
		jbs.add(Gmsc);

		final JButton ��ʵ������ = new JButton("\u771F\u5B9E\u547D\u4E2D\u7387");
		��ʵ������.setOpaque(false);
		��ʵ������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ʵ������.setBounds(200, 180, 103, 36);
		contentPane.add(��ʵ������);
		jbs.add(��ʵ������);
		final JButton Ͷ��Ч�� = new JButton("\u6295\u7BEE\u6548\u7387");
		Ͷ��Ч��.setOpaque(false);
		Ͷ��Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��Ч��.setBounds(310, 180, 95, 36);
		contentPane.add(Ͷ��Ч��);
		jbs.add(Ͷ��Ч��);
		final JButton ������ = new JButton("\u7BEE\u677F\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(415, 180, 79, 36);
		contentPane.add(������);
		jbs.add(������);
		final JButton ���������� = new JButton("\u8FDB\u653B\u7BEE\u677F\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(20, 218, 105, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton ���������� = new JButton("\u9632\u5B88\u7BEE\u677F\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(133, 218, 106, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JButton ������ = new JButton("\u52A9\u653B\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(248, 218, 75, 36);
		contentPane.add(������);
		jbs.add(������);
		final JButton ������ = new JButton("\u62A2\u65AD\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(333, 218, 78, 36);
		contentPane.add(������);
		jbs.add(������);
		final JButton ��ñ�� = new JButton("\u76D6\u5E3D\u7387");
		��ñ��.setOpaque(false);
		��ñ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ñ��.setBounds(415, 218, 79, 36);
		contentPane.add(��ñ��);
		jbs.add(��ñ��);
		final JButton ʧ���� = new JButton("\u5931\u8BEF\u7387");
		ʧ����.setOpaque(false);
		ʧ����.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʧ����.setBounds(20, 256, 79, 36);
		contentPane.add(ʧ����);
		jbs.add(ʧ����);
		final JButton ʹ���� = new JButton("\u4F7F\u7528\u7387");
		ʹ����.setOpaque(false);
		ʹ����.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʹ����.setBounds(107, 256, 78, 36);
		add(ʹ����);
		jbs.add(ʹ����);
		final JButton ���峡�÷������� = new JButton(
				"\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387");
		���峡�÷�������.setOpaque(false);
		���峡�÷�������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���峡�÷�������.setBounds(193, 256, 145, 36);
		contentPane.add(���峡�÷�������);
		jbs.add(���峡�÷�������);
		final JButton ���峡���������� = new JButton(
				"\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387");
		���峡����������.setOpaque(false);
		���峡����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���峡����������.setBounds(349, 256, 145, 36);
		contentPane.add(���峡����������);
		jbs.add(���峡����������);
		final JButton ���峡���������� = new JButton(
				"\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387");
		���峡����������.setOpaque(false);
		���峡����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���峡����������.setBounds(20, 294, 159, 36);
		contentPane.add(���峡����������);
		jbs.add(���峡����������);
		
		
		for(int i=0;i<jbs.size();i++){
			final JButton tempjb = jbs.get(i);
			final String name = tempjb.getText();
			tempjb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Player_Data.do_this_whenclick(name);					
				}
			});
		}
		
		
		contentPane.setBackground(init.sysdarkblue);
		
	}
	
}
