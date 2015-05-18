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
		setUndecorated(true);// 取消窗体修饰效果************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(
				"\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label.setBounds(10, 0, 188, 36);
		contentPane.add(label);
		JButton 投篮命中数 = new JButton("\u6295\u7BEE\u547D\u4E2D\u6570");
		投篮命中数.setOpaque(false);
		投篮命中数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮命中数.setBounds(251, 31, 106, 36);
		contentPane.add(投篮命中数);
		jbs.add(投篮命中数);
		JButton 投篮出手数 = new JButton("\u6295\u7BEE\u51FA\u624B\u6570");
		投篮出手数.setOpaque(false);
		投篮出手数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮出手数.setBounds(369, 31, 106, 36);
		contentPane.add(投篮出手数);
		jbs.add(投篮出手数);
		JButton 三分命中数 = new JButton("\u4E09\u5206\u547D\u4E2D\u6570");
		三分命中数.setOpaque(false);
		三分命中数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		三分命中数.setBounds(20, 69, 106, 36);
		contentPane.add(三分命中数);
		jbs.add(三分命中数);
		JButton 三分出手数 = new JButton("\u4E09\u5206\u51FA\u624B\u6570");
		三分出手数.setOpaque(false);
		三分出手数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		三分出手数.setBounds(133, 69, 106, 36);
		contentPane.add(三分出手数);
		jbs.add(三分出手数);
		JButton 罚球命中数 = new JButton("\u7F5A\u7403\u547D\u4E2D\u6570");
		罚球命中数.setOpaque(false);
		罚球命中数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		罚球命中数.setBounds(250, 69, 106, 36);
		contentPane.add(罚球命中数);
		jbs.add(罚球命中数);
		JButton 罚球出手数 = new JButton("\u7F5A\u7403\u51FA\u624B\u6570");
		罚球出手数.setOpaque(false);
		罚球出手数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		罚球出手数.setBounds(369, 69, 106, 36);
		contentPane.add(罚球出手数);
		jbs.add(罚球出手数);
		JButton 进攻效率 = new JButton("\u8FDB\u653B\u6548\u7387");
		进攻效率.setOpaque(false);
		进攻效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻效率.setBounds(132, 257, 95, 36);
		contentPane.add(进攻效率);
		jbs.add(进攻效率);
		JButton 防守篮板率 = new JButton("\u9632\u5B88\u6548\u7387");
		防守篮板率.setOpaque(false);
		防守篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守篮板率.setBounds(251, 257, 95, 36);
		contentPane.add(防守篮板率);
		jbs.add(防守篮板率);
		JButton button_8 = new JButton("\u9632\u5B88\u7BEE\u677F\u7387");
		button_8.setOpaque(false);
		button_8.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		button_8.setBounds(20, 298, 103, 36);
		contentPane.add(button_8);
		jbs.add(button_8);
		final JButton 进攻回合 = new JButton("\u8FDB\u653B\u56DE\u5408");
		进攻回合.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻回合.setBounds(20, 257, 95, 36);
		进攻回合.setOpaque(false);
		contentPane.add(进攻回合);
		jbs.add(进攻回合);
		final JButton 篮板 = new JButton("\u7BEE\u677F");
		篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		篮板.setBounds(97, 31, 67, 36);
		篮板.setOpaque(false);
		contentPane.add(篮板);
		jbs.add(篮板);
		final JButton 助攻 = new JButton("\u52A9\u653B");
		助攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻.setBounds(174, 31, 67, 36);
		助攻.setOpaque(false);
		contentPane.add(助攻);
		jbs.add(助攻);
		final JButton 投篮命中率 = new JButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		投篮命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮命中率.setBounds(20, 218, 106, 36);
		投篮命中率.setOpaque(false);
		contentPane.add(投篮命中率);
		jbs.add(投篮命中率);
		final JButton 三分命中率 = new JButton("\u4E09\u5206\u547D\u4E2D\u7387");
		三分命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		三分命中率.setBounds(148, 218, 106, 36);
		三分命中率.setOpaque(false);
		contentPane.add(三分命中率);
		jbs.add(三分命中率);
		final JButton 罚球命中率 = new JButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		罚球命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		罚球命中率.setBounds(278, 218, 106, 36);
		罚球命中率.setOpaque(false);
		contentPane.add(罚球命中率);
		jbs.add(罚球命中率);
		final JButton 抢断 = new JButton("\u62A2\u65AD");
		抢断.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断.setBounds(20, 110, 67, 36);
		抢断.setOpaque(false);
		contentPane.add(抢断);
		jbs.add(抢断);
		final JButton 盖帽 = new JButton("\u76D6\u5E3D");
		盖帽.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		盖帽.setBounds(104, 110, 67, 36);
		盖帽.setOpaque(false);
		contentPane.add(盖帽);
		jbs.add(盖帽);
		final JButton 失误 = new JButton("\u5931\u8BEF");
		失误.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		失误.setBounds(180, 110, 67, 36);
		失误.setOpaque(false);
		contentPane.add(失误);
		jbs.add(失误);
		final JButton 犯规 = new JButton("\u72AF\u89C4");
		犯规.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		犯规.setBounds(263, 110, 67, 36);
		犯规.setOpaque(false);
		contentPane.add(犯规);
		jbs.add(犯规);
		final JButton 得分 = new JButton("\u5F97\u5206");
		得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		得分.setBounds(20, 31, 67, 36);
		得分.setOpaque(false);
		contentPane.add(得分);
		jbs.add(得分);
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label_1.setBounds(10, 189, 188, 36);
		contentPane.add(label_1);

		final JButton 效率 = new JButton("\u80DC\u7387");
		效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		效率.setBounds(414, 218, 61, 36);
		效率.setOpaque(false);
		contentPane.add(效率);
		jbs.add(效率);

		final JButton 进攻篮板率 = new JButton("\u8FDB\u653B\u7BEE\u677F\u7387");
		进攻篮板率.setOpaque(false);
		进攻篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻篮板率.setBounds(372, 257, 103, 36);
		contentPane.add(进攻篮板率);
		jbs.add(进攻篮板率);
		final JButton 进攻篮板 = new JButton("\u8FDB\u653B\u7BEE\u677F");
		进攻篮板.setOpaque(false);
		进攻篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻篮板.setBounds(20, 151, 105, 36);
		contentPane.add(进攻篮板);
		jbs.add(进攻篮板);
		final JButton 防守篮板 = new JButton("\u9632\u5B88\u7BEE\u677F");
		防守篮板.setOpaque(false);
		防守篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守篮板.setBounds(135, 151, 106, 36);
		contentPane.add(防守篮板);
		jbs.add(防守篮板);
		final JButton 助攻率 = new JButton("\u52A9\u653B\u7387");
		助攻率.setOpaque(false);
		助攻率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻率.setBounds(148, 298, 75, 36);
		contentPane.add(助攻率);
		jbs.add(助攻率);
		final JButton 抢断率 = new JButton("\u62A2\u65AD\u7387");
		抢断率.setOpaque(false);
		抢断率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断率.setBounds(252, 298, 78, 36);
		contentPane.add(抢断率);
		jbs.add(抢断率);
		
		
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
