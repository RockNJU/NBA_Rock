package UI.Player;

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

import UI.common.OftenUseMethod;
import UI.common.SortItem_Map;
import UI.main.init;
import VO.PlayerSeasonDataVO;
import VO.PlayerVO;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ContrastPlayer extends JDialog {
	String[] outputcontent = new String[8];
	int now = 0;
	int chossentime = 0;
	SortItem_Map map = new SortItem_Map();
	ArrayList<JRadioButton> jbs = new ArrayList<JRadioButton>();
	private JPanel contentPane;
	PlayerSeasonDataVO playera;
	PlayerSeasonDataVO playerb;
	boolean change = false;
	
	double[][] data = new double[2][30];
	double[][] dataoutput = new double[2][10];
	/**
	 * Create the panel.
	 */
	public ContrastPlayer(PlayerSeasonDataVO pe1,PlayerSeasonDataVO pe2) {
		playera = pe1;
		playerb = pe2;
		
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
		
		final JRadioButton 参赛场数 = new JRadioButton("参赛场数");
		参赛场数.setBounds(20, 31, 106, 36);
		参赛场数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		参赛场数.setOpaque(false);
		contentPane.add(参赛场数);
		data[0][0] = OftenUseMethod.changedouble(playera.getMatchNum());
		data[1][0] = OftenUseMethod.changedouble(playerb.getMatchNum());
		jbs.add(参赛场数);
		
		final JRadioButton 先发场数 = new JRadioButton("\u5148\u53D1\u573A\u6570");
		先发场数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		先发场数.setBounds(133, 31, 95, 36);
		先发场数.setOpaque(false);
		contentPane.add(先发场数);
		data[0][1] = OftenUseMethod.changedouble(playera.getStartingNum());
		data[1][1] = OftenUseMethod.changedouble(playerb.getStartingNum());
		jbs.add(先发场数);
		
		final JRadioButton 篮板 = new JRadioButton("\u7BEE\u677F");
		篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		篮板.setBounds(242, 31, 67, 36);
		篮板.setOpaque(false);
		contentPane.add(篮板);
		data[0][2] = OftenUseMethod.changedouble(playera.getReboundNum_avg());
		data[1][2] = OftenUseMethod.changedouble(playerb.getReboundNum_avg());
		jbs.add(篮板);
		
		final JRadioButton 助攻 = new JRadioButton("\u52A9\u653B");
		助攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻.setBounds(318, 31, 67, 36);
		助攻.setOpaque(false);
		contentPane.add(助攻);
		data[0][3] = OftenUseMethod.changedouble(playera.getAssistNum_avg());
		data[1][3] = OftenUseMethod.changedouble(playerb.getAssistNum_avg());
		jbs.add(助攻);
		
		final JRadioButton 上场时间 = new JRadioButton("\u4E0A\u573A\u65F6\u95F4");
		上场时间.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		上场时间.setBounds(399, 31, 95, 36);
		上场时间.setOpaque(false);
		data[0][4] = OftenUseMethod.changedouble(playera.getTime_avg());
		data[1][4] = OftenUseMethod.changedouble(playerb.getTime_avg());
		contentPane.add(上场时间);
		jbs.add(上场时间);
		
		final JRadioButton 投篮命中率 = new JRadioButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		投篮命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮命中率.setBounds(20, 69, 106, 36);
		投篮命中率.setOpaque(false);
		contentPane.add(投篮命中率);
		data[0][5] = OftenUseMethod.changedouble(playera.getShootPercentage());
		data[1][5] = OftenUseMethod.changedouble(playerb.getShootPercentage());
		jbs.add(投篮命中率);
		
		final JRadioButton 三分命中率 = new JRadioButton("\u4E09\u5206\u547D\u4E2D\u7387");
		三分命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		三分命中率.setBounds(130, 69, 106, 36);
		三分命中率.setOpaque(false);
		contentPane.add(三分命中率);
		data[0][6] = OftenUseMethod.changedouble(playera.getT_shootPercentage());
		data[1][6] = OftenUseMethod.changedouble(playerb.getT_shootPercentage());
		jbs.add(三分命中率);
		
		final JRadioButton 罚球命中率 = new JRadioButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		罚球命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		罚球命中率.setBounds(242, 69, 106, 36);
		罚球命中率.setOpaque(false);
		contentPane.add(罚球命中率);
		data[0][7] = OftenUseMethod.changedouble(playera.getFreeThrowPercentage());
		data[1][7] = OftenUseMethod.changedouble(playerb.getFreeThrowPercentage());
		jbs.add(罚球命中率);
		
		final JRadioButton 进攻 = new JRadioButton("\u8FDB\u653B");
		进攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻.setBounds(353, 69, 67, 36);
		进攻.setOpaque(false);
		contentPane.add(进攻);
		data[0][8] = OftenUseMethod.changedouble(playera.getO_ReboundNum_avg());
		data[1][8] = OftenUseMethod.changedouble(playerb.getO_ReboundNum_avg());
		jbs.add(进攻);
		
		final JRadioButton 防守 = new JRadioButton("\u9632\u5B88");
		防守.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守.setBounds(427, 69, 67, 36);
		防守.setOpaque(false);
		contentPane.add(防守);
		data[0][9] = OftenUseMethod.changedouble(playera.getD_ReboundNum_avg());
		data[1][9] = OftenUseMethod.changedouble(playerb.getD_ReboundNum_avg());
		jbs.add(防守);
		
		final JRadioButton 抢断 = new JRadioButton("\u62A2\u65AD");
		抢断.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断.setBounds(20, 107, 67, 36);
		抢断.setOpaque(false);
		contentPane.add(抢断);
		data[0][10] = OftenUseMethod.changedouble(playera.getStealNum_avg());
		data[1][10] = OftenUseMethod.changedouble(playerb.getStealNum_avg());
		jbs.add(抢断);
		
		final JRadioButton 盖帽 = new JRadioButton("\u76D6\u5E3D");
		盖帽.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		盖帽.setBounds(104, 107, 67, 36);
		盖帽.setOpaque(false);
		contentPane.add(盖帽);
		data[0][11] = OftenUseMethod.changedouble(playera.getBlockNum_avg());
		data[1][11] = OftenUseMethod.changedouble(playerb.getBlockNum_avg());
		jbs.add(盖帽);
		
		final JRadioButton 失误 = new JRadioButton("\u5931\u8BEF");
		失误.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		失误.setBounds(180, 107, 67, 36);
		失误.setOpaque(false);
		contentPane.add(失误);
		data[0][12] = OftenUseMethod.changedouble(playera.getTurnoverNum_avg());
		data[1][12] = OftenUseMethod.changedouble(playerb.getTurnoverNum_avg());
		jbs.add(失误);
		
		final JRadioButton 犯规 = new JRadioButton("\u72AF\u89C4");
		犯规.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		犯规.setBounds(263, 107, 67, 36);
		犯规.setOpaque(false);
		contentPane.add(犯规);
		data[0][13] = OftenUseMethod.changedouble(playera.getFoulNum_avg());
		data[1][13] = OftenUseMethod.changedouble(playerb.getFoulNum_avg());
		jbs.add(犯规);
		
		final JRadioButton 得分 = new JRadioButton("\u5F97\u5206");
		得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		得分.setBounds(344, 107, 67, 36);
		得分.setOpaque(false);
		contentPane.add(得分);
		data[0][14] = OftenUseMethod.changedouble(playera.getPointNum_avg());
		data[1][14] = OftenUseMethod.changedouble(playerb.getPointNum_avg());
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
		data[0][15] = OftenUseMethod.changedouble(playera.getEfficiency());
		data[1][15] = OftenUseMethod.changedouble(playerb.getEfficiency());
		jbs.add(效率);
		
		final JRadioButton Gmsc = new JRadioButton("GmSC\u6548\u7387\u503C");
		Gmsc.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		Gmsc.setBounds(87, 180, 105, 36);
		Gmsc.setOpaque(false);
		contentPane.add(Gmsc);
		data[0][16] = OftenUseMethod.changedouble(playera.getGmSc());
		data[1][16] = OftenUseMethod.changedouble(playerb.getGmSc());
		jbs.add(Gmsc);

		final JRadioButton 真实命中率 = new JRadioButton("\u771F\u5B9E\u547D\u4E2D\u7387");
		真实命中率.setOpaque(false);
		真实命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		真实命中率.setBounds(200, 180, 103, 36);
		contentPane.add(真实命中率);
		data[0][17] = OftenUseMethod.changedouble(playera.getRealShootPercentage());
		data[1][17] = OftenUseMethod.changedouble(playerb.getRealShootPercentage());
		jbs.add(真实命中率);
		
		final JRadioButton 投篮效率 = new JRadioButton("\u6295\u7BEE\u6548\u7387");
		投篮效率.setOpaque(false);
		投篮效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮效率.setBounds(310, 180, 95, 36);
		contentPane.add(投篮效率);
		data[0][18] = OftenUseMethod.changedouble(playera.getShootEfficiency());
		data[1][18] = OftenUseMethod.changedouble(playerb.getShootEfficiency());
		jbs.add(投篮效率);
		
		final JRadioButton 篮板率 = new JRadioButton("\u7BEE\u677F\u7387");
		篮板率.setOpaque(false);
		篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		篮板率.setBounds(415, 180, 79, 36);
		contentPane.add(篮板率);
		data[0][19] = OftenUseMethod.changedouble(playera.getReboundEfficiency());
		data[1][19] = OftenUseMethod.changedouble(playerb.getReboundEfficiency());
		jbs.add(篮板率);
		
		final JRadioButton 进攻篮板数 = new JRadioButton("\u8FDB\u653B\u7BEE\u677F\u6570");
		进攻篮板数.setOpaque(false);
		进攻篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻篮板数.setBounds(20, 218, 105, 36);
		contentPane.add(进攻篮板数);
		data[0][20] = OftenUseMethod.changedouble(playera.getOffensiveReboundEff_avg());
		data[1][20] = OftenUseMethod.changedouble(playerb.getOffensiveReboundEff_avg());
		jbs.add(进攻篮板数);
		
		final JRadioButton 防守篮板数 = new JRadioButton("\u9632\u5B88\u7BEE\u677F\u6570");
		防守篮板数.setOpaque(false);
		防守篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守篮板数.setBounds(133, 218, 106, 36);
		contentPane.add(防守篮板数);
		data[0][21] = OftenUseMethod.changedouble(playera.getDefenseReboundEff_avg());
		data[1][21] = OftenUseMethod.changedouble(playerb.getDefenseReboundEff_avg());
		jbs.add(防守篮板数);
		
		final JRadioButton 助攻率 = new JRadioButton("\u52A9\u653B\u7387");
		助攻率.setOpaque(false);
		助攻率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻率.setBounds(248, 218, 75, 36);
		contentPane.add(助攻率);
		data[0][22] = OftenUseMethod.changedouble(playera.getAssistEfficiency_avg());
		data[1][22] = OftenUseMethod.changedouble(playerb.getAssistEfficiency_avg());
		jbs.add(助攻率);
		
		final JRadioButton 抢断率 = new JRadioButton("\u62A2\u65AD\u7387");
		抢断率.setOpaque(false);
		抢断率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断率.setBounds(333, 218, 78, 36);
		contentPane.add(抢断率);
		data[0][23] = OftenUseMethod.changedouble(playera.getStealEfficiency_avg());
		data[1][23] = OftenUseMethod.changedouble(playerb.getStealEfficiency_avg());
		jbs.add(抢断率);
		
		final JRadioButton 盖帽率 = new JRadioButton("\u76D6\u5E3D\u7387");
		盖帽率.setOpaque(false);
		盖帽率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		盖帽率.setBounds(415, 218, 79, 36);
		contentPane.add(盖帽率);
		data[0][24] = OftenUseMethod.changedouble(playera.getBlockEfficiency());
		data[1][24] = OftenUseMethod.changedouble(playerb.getBlockEfficiency());
		jbs.add(盖帽率);
		
		final JRadioButton 失误率 = new JRadioButton("\u5931\u8BEF\u7387");
		失误率.setOpaque(false);
		失误率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		失误率.setBounds(20, 256, 79, 36);
		contentPane.add(失误率);
		data[0][25] = OftenUseMethod.changedouble(playera.getTurnoverPercentage());
		data[1][25] = OftenUseMethod.changedouble(playerb.getTurnoverPercentage());
		jbs.add(失误率);
		
		final JRadioButton 使用率 = new JRadioButton("\u4F7F\u7528\u7387");
		使用率.setOpaque(false);
		使用率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		使用率.setBounds(107, 256, 78, 36);
		getContentPane().add(使用率);
		data[0][26] = OftenUseMethod.changedouble(playera.getUsingPercentage_avg());
		data[1][26] = OftenUseMethod.changedouble(playerb.getUsingPercentage_avg());
		jbs.add(使用率);
		
		final JRadioButton 近五场得分提升率 = new JRadioButton(
				"\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387");
		近五场得分提升率.setOpaque(false);
		近五场得分提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		近五场得分提升率.setBounds(193, 256, 145, 36);
		contentPane.add(近五场得分提升率);
		data[0][27] = OftenUseMethod.changedouble(playera.getL_f_point_rate());
		data[1][27] = OftenUseMethod.changedouble(playerb.getL_f_point_rate());
		jbs.add(近五场得分提升率);
		
		final JRadioButton 近五场助攻提升率 = new JRadioButton(
				"\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387");
		近五场助攻提升率.setOpaque(false);
		近五场助攻提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		近五场助攻提升率.setBounds(349, 256, 145, 36);
		contentPane.add(近五场助攻提升率);
		data[0][28] = OftenUseMethod.changedouble(playera.getL_f_assist_rate());
		data[1][28] = OftenUseMethod.changedouble(playerb.getL_f_assist_rate());
		jbs.add(近五场助攻提升率);
		
		final JRadioButton 近五场篮板提升率 = new JRadioButton(
				"\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387");
		近五场篮板提升率.setOpaque(false);
		近五场篮板提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		近五场篮板提升率.setBounds(20, 294, 159, 36);
		contentPane.add(近五场篮板提升率);
		data[0][29] = OftenUseMethod.changedouble(playera.getL_f_rebound_rate());
		data[1][29] = OftenUseMethod.changedouble(playerb.getL_f_rebound_rate());
		jbs.add(近五场篮板提升率);
		
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(init.sysdarkblue);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 change = false;
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
				 change = true;
				for(int i=0;i<jbs.size();i++){
					final JRadioButton tempjb = jbs.get(i);
					if(tempjb.isSelected()){
						outputcontent[now] = tempjb.getText();
						dataoutput[0][now] = data[0][i];
						dataoutput[1][now] = data[1][i];
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
					if(chossentime<=7&&(jrtemp.isSelected()==true)){
						chossentime++;
					}
					else if(chossentime>7&&(jrtemp.isSelected()==true)){
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
