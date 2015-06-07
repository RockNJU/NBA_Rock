package UI.Match;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import UI.common.SortItem_Map;
import UI.main.init;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ContrastMatch extends JDialog {
	String[] outputcontent = new String[8];
	int now = 0;
	int chossentime = 0;
	SortItem_Map map = new SortItem_Map();
	ArrayList<JRadioButton> jbs = new ArrayList<JRadioButton>();
	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public ContrastMatch() {
		getContentPane().setLayout(null);
		setSize(500,350);
		setUndecorated(true);// 取消窗体修饰效果************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(183,222,222));
		
		JLabel label = new JLabel(
				"\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label.setBounds(10, 0, 188, 36);
		contentPane.add(label);
		
		final JRadioButton 比赛得分 = new JRadioButton("\u6BD4\u8D5B\u5F97\u5206");
		比赛得分.setBounds(20, 31, 106, 36);
		比赛得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		比赛得分.setOpaque(false);
		contentPane.add(比赛得分);
		jbs.add(比赛得分);
		final JRadioButton 比赛失分 = new JRadioButton("\u6BD4\u8D5B\u5931\u5206");
		比赛失分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		比赛失分.setBounds(133, 31, 95, 36);
		比赛失分.setOpaque(false);
		contentPane.add(比赛失分);
		jbs.add(比赛失分);
		final JRadioButton 篮板 = new JRadioButton("\u7BEE\u677F");
		篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		篮板.setBounds(242, 31, 67, 36);
		篮板.setOpaque(false);
		contentPane.add(篮板);
		jbs.add(篮板);
		final JRadioButton 助攻 = new JRadioButton("\u52A9\u653B");
		助攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻.setBounds(318, 31, 67, 36);
		助攻.setOpaque(false);
		contentPane.add(助攻);
		jbs.add(助攻);
		final JRadioButton 上场时间 = new JRadioButton("\u4E0A\u573A\u65F6\u95F4");
		上场时间.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		上场时间.setBounds(399, 31, 95, 36);
		上场时间.setOpaque(false);
		contentPane.add(上场时间);
		jbs.add(上场时间);
		final JRadioButton 投篮命中率 = new JRadioButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		投篮命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮命中率.setBounds(20, 69, 106, 36);
		投篮命中率.setOpaque(false);
		contentPane.add(投篮命中率);
		jbs.add(投篮命中率);
		final JRadioButton 三分命中率 = new JRadioButton("\u4E09\u5206\u547D\u4E2D\u7387");
		三分命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		三分命中率.setBounds(130, 69, 106, 36);
		三分命中率.setOpaque(false);
		contentPane.add(三分命中率);
		jbs.add(三分命中率);
		final JRadioButton 罚球命中率 = new JRadioButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		罚球命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		罚球命中率.setBounds(242, 69, 106, 36);
		罚球命中率.setOpaque(false);
		contentPane.add(罚球命中率);
		jbs.add(罚球命中率);
		final JRadioButton 进攻 = new JRadioButton("\u8FDB\u653B");
		进攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻.setBounds(353, 69, 67, 36);
		进攻.setOpaque(false);
		contentPane.add(进攻);
		jbs.add(进攻);
		final JRadioButton 防守 = new JRadioButton("\u9632\u5B88");
		防守.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守.setBounds(427, 69, 67, 36);
		防守.setOpaque(false);
		contentPane.add(防守);
		jbs.add(防守);
		final JRadioButton 抢断 = new JRadioButton("\u62A2\u65AD");
		抢断.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断.setBounds(20, 107, 67, 36);
		抢断.setOpaque(false);
		contentPane.add(抢断);
		jbs.add(抢断);
		final JRadioButton 盖帽 = new JRadioButton("\u76D6\u5E3D");
		盖帽.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		盖帽.setBounds(104, 107, 67, 36);
		盖帽.setOpaque(false);
		contentPane.add(盖帽);
		jbs.add(盖帽);
		final JRadioButton 失误 = new JRadioButton("\u5931\u8BEF");
		失误.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		失误.setBounds(180, 107, 67, 36);
		失误.setOpaque(false);
		contentPane.add(失误);
		jbs.add(失误);
		final JRadioButton 犯规 = new JRadioButton("\u72AF\u89C4");
		犯规.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		犯规.setBounds(263, 107, 67, 36);
		犯规.setOpaque(false);
		contentPane.add(犯规);
		jbs.add(犯规);
		final JRadioButton 得分 = new JRadioButton("\u5F97\u5206");
		得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		得分.setBounds(344, 107, 67, 36);
		得分.setOpaque(false);
		contentPane.add(得分);
		jbs.add(得分);
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label_1.setBounds(10, 149, 188, 36);
		contentPane.add(label_1);

		final JRadioButton 效率 = new JRadioButton("\u6548\u7387");
		效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		效率.setBounds(20, 180, 61, 36);
		效率.setOpaque(false);
		contentPane.add(效率);
		jbs.add(效率);
		final JRadioButton Gmsc = new JRadioButton("GmSC\u6548\u7387\u503C");
		Gmsc.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		Gmsc.setBounds(87, 180, 105, 36);
		Gmsc.setOpaque(false);
		contentPane.add(Gmsc);
		jbs.add(Gmsc);

		final JRadioButton 真实命中率 = new JRadioButton("\u771F\u5B9E\u547D\u4E2D\u7387");
		真实命中率.setOpaque(false);
		真实命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		真实命中率.setBounds(200, 180, 103, 36);
		contentPane.add(真实命中率);
		jbs.add(真实命中率);
		final JRadioButton 投篮效率 = new JRadioButton("\u6295\u7BEE\u6548\u7387");
		投篮效率.setOpaque(false);
		投篮效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮效率.setBounds(310, 180, 95, 36);
		contentPane.add(投篮效率);
		jbs.add(投篮效率);
		final JRadioButton 篮板率 = new JRadioButton("\u7BEE\u677F\u7387");
		篮板率.setOpaque(false);
		篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		篮板率.setBounds(415, 180, 79, 36);
		contentPane.add(篮板率);
		jbs.add(篮板率);
		final JRadioButton 进攻篮板数 = new JRadioButton("\u8FDB\u653B\u7BEE\u677F\u6570");
		进攻篮板数.setOpaque(false);
		进攻篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻篮板数.setBounds(20, 218, 105, 36);
		contentPane.add(进攻篮板数);
		jbs.add(进攻篮板数);
		final JRadioButton 防守篮板数 = new JRadioButton("\u9632\u5B88\u7BEE\u677F\u6570");
		防守篮板数.setOpaque(false);
		防守篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守篮板数.setBounds(133, 218, 106, 36);
		contentPane.add(防守篮板数);
		jbs.add(防守篮板数);
		final JRadioButton 助攻率 = new JRadioButton("\u52A9\u653B\u7387");
		助攻率.setOpaque(false);
		助攻率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻率.setBounds(248, 218, 75, 36);
		contentPane.add(助攻率);
		jbs.add(助攻率);
		final JRadioButton 抢断率 = new JRadioButton("\u62A2\u65AD\u7387");
		抢断率.setOpaque(false);
		抢断率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断率.setBounds(333, 218, 78, 36);
		contentPane.add(抢断率);
		jbs.add(抢断率);
		final JRadioButton 盖帽率 = new JRadioButton("\u76D6\u5E3D\u7387");
		盖帽率.setOpaque(false);
		盖帽率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		盖帽率.setBounds(415, 218, 79, 36);
		contentPane.add(盖帽率);
		jbs.add(盖帽率);
		final JRadioButton 失误率 = new JRadioButton("\u5931\u8BEF\u7387");
		失误率.setOpaque(false);
		失误率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		失误率.setBounds(20, 256, 79, 36);
		contentPane.add(失误率);
		jbs.add(失误率);
		final JRadioButton 使用率 = new JRadioButton("\u4F7F\u7528\u7387");
		使用率.setOpaque(false);
		使用率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		使用率.setBounds(107, 256, 78, 36);
		getContentPane().add(使用率);
		jbs.add(使用率);
		final JRadioButton 近五场得分提升率 = new JRadioButton(
				"\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387");
		近五场得分提升率.setOpaque(false);
		近五场得分提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		近五场得分提升率.setBounds(193, 256, 145, 36);
		contentPane.add(近五场得分提升率);
		jbs.add(近五场得分提升率);
		final JRadioButton 近五场助攻提升率 = new JRadioButton(
				"\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387");
		近五场助攻提升率.setOpaque(false);
		近五场助攻提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		近五场助攻提升率.setBounds(349, 256, 145, 36);
		contentPane.add(近五场助攻提升率);
		jbs.add(近五场助攻提升率);
		final JRadioButton 近五场篮板提升率 = new JRadioButton(
				"\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387");
		近五场篮板提升率.setOpaque(false);
		近五场篮板提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		近五场篮板提升率.setBounds(20, 294, 159, 36);
		contentPane.add(近五场篮板提升率);
		jbs.add(近五场篮板提升率);
		
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(init.sysdarkblue);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose();
			}
		});
		btnNewButton.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		btnNewButton.setBounds(401, 310, 93, 30);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(init.sysdarkblue);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<jbs.size();i++){
					final JRadioButton tempjb = jbs.get(i);
					if(tempjb.isSelected()){
						//每个选择自动取值赋值给提示文字，然后在这里保存到数据中
						outputcontent[now] = tempjb.getName();
						now++;
						if(now == 9){break;}
					}
				}
				
				//执行函数+关闭
			    dispose();
			}
		});
		
		for(final JRadioButton jrtemp:jbs){
			jrtemp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chossentime<7&&(jrtemp.isSelected()==true)){
						chossentime++;
					}
					else if(chossentime>=7&&(jrtemp.isSelected()==true)){
						jrtemp.setSelected(false);
					}
					else if((jrtemp.isSelected()==false)){
						chossentime--;
					}
				}
			});
		
		}
		
		button.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		button.setBounds(292, 310, 93, 30);
		contentPane.add(button);

		contentPane.setBackground(new Color(183,222,222));

	}
}
