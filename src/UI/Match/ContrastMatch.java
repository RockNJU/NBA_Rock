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

import UI.common.OftenUseMethod;
import UI.common.SortItem_Map;
import UI.main.init;
import VO.PlayerSeasonDataVO;
import VO.PlayerVO;
import VO.TeamMatchVO;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ContrastMatch extends JDialog {
	String[] outputcontent = new String[8];
	int now = 0;
	int chossentime = 0;
	SortItem_Map map = new SortItem_Map();
	ArrayList<JRadioButton> jbs = new ArrayList<JRadioButton>();
	private JPanel contentPane;
	TeamMatchVO teama;
	TeamMatchVO teamb;
	
	double[][] data = new double[2][30];
	double[][] dataoutput = new double[2][10];
	/**
	 * Create the panel.
	 */
	public ContrastMatch(TeamMatchVO pe1,TeamMatchVO pe2) {
		teama = pe1;
		teamb = pe2;
		
		getContentPane().setLayout(null);
		setSize(500,301);
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
		
		final JRadioButton 进攻篮板 = new JRadioButton("进攻篮板");
		进攻篮板.setBounds(20, 31, 106, 36);
		进攻篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻篮板.setOpaque(false);
		contentPane.add(进攻篮板);
		data[0][0] = OftenUseMethod.changedouble(teama.getO_ReboundNum());
		data[1][0] = OftenUseMethod.changedouble(teamb.getO_ReboundNum());
		jbs.add(进攻篮板);
		
		final JRadioButton 防御篮板 = new JRadioButton("防御篮板");
		防御篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防御篮板.setBounds(133, 31, 95, 36);
		防御篮板.setOpaque(false);
		contentPane.add(防御篮板);
		data[0][1] = OftenUseMethod.changedouble(teama.getD_ReboundNum());
		data[1][1] = OftenUseMethod.changedouble(teamb.getD_ReboundNum());
		jbs.add(防御篮板);
		
		final JRadioButton 篮板 = new JRadioButton("\u7BEE\u677F");
		篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		篮板.setBounds(242, 31, 67, 36);
		篮板.setOpaque(false);
		contentPane.add(篮板);
		data[0][2] = OftenUseMethod.changedouble(teama.getReboundNum());
		data[1][2] = OftenUseMethod.changedouble(teamb.getReboundNum());
		jbs.add(篮板);
		
		final JRadioButton 助攻 = new JRadioButton("\u52A9\u653B");
		助攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻.setBounds(318, 31, 67, 36);
		助攻.setOpaque(false);
		contentPane.add(助攻);
		data[0][3] = OftenUseMethod.changedouble(teama.getAssistNum());
		data[1][3] = OftenUseMethod.changedouble(teamb.getAssistNum());
		jbs.add(助攻);
		
		final JRadioButton 投篮数 = new JRadioButton("投篮数");
		投篮数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮数.setBounds(399, 31, 95, 36);
		投篮数.setOpaque(false);
		data[0][4] = OftenUseMethod.changedouble(teama.getShootNum());
		data[1][4] = OftenUseMethod.changedouble(teamb.getShootNum());
		contentPane.add(投篮数);
		jbs.add(投篮数);
		
		final JRadioButton 投篮命中率 = new JRadioButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		投篮命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮命中率.setBounds(20, 69, 106, 36);
		投篮命中率.setOpaque(false);
		contentPane.add(投篮命中率);
		data[0][5] = OftenUseMethod.changedouble(teama.getShootPercentage());
		data[1][5] = OftenUseMethod.changedouble(teamb.getShootPercentage());
		jbs.add(投篮命中率);
		
		final JRadioButton 三分命中率 = new JRadioButton("\u4E09\u5206\u547D\u4E2D\u7387");
		三分命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		三分命中率.setBounds(130, 69, 106, 36);
		三分命中率.setOpaque(false);
		contentPane.add(三分命中率);
		data[0][6] = OftenUseMethod.changedouble(teama.getThreePointPercentage());
		data[1][6] = OftenUseMethod.changedouble(teamb.getThreePointPercentage());
		jbs.add(三分命中率);
		
		final JRadioButton 罚球命中率 = new JRadioButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		罚球命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		罚球命中率.setBounds(242, 69, 106, 36);
		罚球命中率.setOpaque(false);
		contentPane.add(罚球命中率);
		data[0][7] = OftenUseMethod.changedouble(teama.getFreeThrowPercentage());
		data[1][7] = OftenUseMethod.changedouble(teamb.getFreeThrowPercentage());
		jbs.add(罚球命中率);
		
		final JRadioButton 进攻 = new JRadioButton("\u8FDB\u653B");
		进攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻.setBounds(353, 69, 67, 36);
		进攻.setOpaque(false);
		contentPane.add(进攻);
		data[0][8] = OftenUseMethod.changedouble(teama.getO_ReboundNum());
		data[1][8] = OftenUseMethod.changedouble(teamb.getO_ReboundNum());
		jbs.add(进攻);
		
		final JRadioButton 防守 = new JRadioButton("\u9632\u5B88");
		防守.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守.setBounds(427, 69, 67, 36);
		防守.setOpaque(false);
		contentPane.add(防守);
		data[0][9] = OftenUseMethod.changedouble(teama.getD_ReboundNum());
		data[1][9] = OftenUseMethod.changedouble(teamb.getD_ReboundNum());
		jbs.add(防守);
		
		final JRadioButton 抢断 = new JRadioButton("\u62A2\u65AD");
		抢断.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断.setBounds(20, 107, 67, 36);
		抢断.setOpaque(false);
		contentPane.add(抢断);
		data[0][10] = OftenUseMethod.changedouble(teama.getStealNum());
		data[1][10] = OftenUseMethod.changedouble(teamb.getStealNum());
		jbs.add(抢断);
		
		final JRadioButton 盖帽 = new JRadioButton("\u76D6\u5E3D");
		盖帽.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		盖帽.setBounds(104, 107, 67, 36);
		盖帽.setOpaque(false);
		contentPane.add(盖帽);
		data[0][11] = OftenUseMethod.changedouble(teama.getBlockNum());
		data[1][11] = OftenUseMethod.changedouble(teamb.getBlockNum());
		jbs.add(盖帽);
		
		final JRadioButton 失误 = new JRadioButton("\u5931\u8BEF");
		失误.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		失误.setBounds(180, 107, 67, 36);
		失误.setOpaque(false);
		contentPane.add(失误);
		data[0][12] = OftenUseMethod.changedouble(teama.getTurnoverNum());
		data[1][12] = OftenUseMethod.changedouble(teamb.getTurnoverNum());
		jbs.add(失误);
		
		final JRadioButton 犯规 = new JRadioButton("\u72AF\u89C4");
		犯规.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		犯规.setBounds(263, 107, 67, 36);
		犯规.setOpaque(false);
		contentPane.add(犯规);
		data[0][13] = OftenUseMethod.changedouble(teama.getFoulNum());
		data[1][13] = OftenUseMethod.changedouble(teamb.getFoulNum());
		jbs.add(犯规);
		
		final JRadioButton 得分 = new JRadioButton("\u5F97\u5206");
		得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		得分.setBounds(344, 107, 67, 36);
		得分.setOpaque(false);
		contentPane.add(得分);
		data[0][14] = OftenUseMethod.changedouble(teama.getPointNum());
		data[1][14] = OftenUseMethod.changedouble(teamb.getPointNum());
		jbs.add(得分);
		
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label_1.setBounds(10, 149, 188, 36);
		contentPane.add(label_1);

		
		final JRadioButton 投篮效率 = new JRadioButton("\u6295\u7BEE\u6548\u7387");
		投篮效率.setOpaque(false);
		投篮效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		投篮效率.setBounds(20, 180, 95, 36);
		contentPane.add(投篮效率);
		data[0][15] = OftenUseMethod.changedouble(teama.getShootPercentage());
		data[1][15] = OftenUseMethod.changedouble(teamb.getShootPercentage());
		jbs.add(投篮效率);
		
		final JRadioButton 进攻篮板率 = new JRadioButton("进攻篮板率");
		进攻篮板率.setOpaque(false);
		进攻篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻篮板率.setBounds(20, 218, 105, 36);
		contentPane.add(进攻篮板率);
		data[0][16] = OftenUseMethod.changedouble(teama.getO_ReboundEfficiency());
		data[1][16] = OftenUseMethod.changedouble(teamb.getO_ReboundEfficiency());
		jbs.add(进攻篮板率);
		
		final JRadioButton 防守篮板率 = new JRadioButton("防守篮板率");
		防守篮板率.setOpaque(false);
		防守篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守篮板率.setBounds(133, 218, 106, 36);
		contentPane.add(防守篮板率);
		data[0][17] = OftenUseMethod.changedouble(teama.getD_ReboundEfficiency());
		data[1][17] = OftenUseMethod.changedouble(teamb.getD_ReboundEfficiency());
		jbs.add(防守篮板率);
		
		final JRadioButton 助攻率 = new JRadioButton("\u52A9\u653B\u7387");
		助攻率.setOpaque(false);
		助攻率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		助攻率.setBounds(133, 180, 75, 36);
		contentPane.add(助攻率);
		data[0][18] = OftenUseMethod.changedouble(teama.getAssistEfficiency());
		data[1][18] = OftenUseMethod.changedouble(teamb.getAssistEfficiency());
		jbs.add(助攻率);
		
		final JRadioButton 抢断率 = new JRadioButton("\u62A2\u65AD\u7387");
		抢断率.setOpaque(false);
		抢断率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		抢断率.setBounds(248, 180, 78, 36);
		contentPane.add(抢断率);
		data[0][19] = OftenUseMethod.changedouble(teama.getStealEfficiency());
		data[1][19] = OftenUseMethod.changedouble(teamb.getStealEfficiency());
		jbs.add(抢断率);
		
		final JRadioButton 进攻效率 = new JRadioButton("进攻效率");
		进攻效率.setOpaque(false);
		进攻效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		进攻效率.setBounds(341, 180, 95, 36);
		contentPane.add(进攻效率);
		data[0][20] = OftenUseMethod.changedouble(teama.getOffenseEfficiency());
		data[1][20] = OftenUseMethod.changedouble(teamb.getOffenseEfficiency());
		jbs.add(进攻效率);
		
		final JRadioButton 防守效率 = new JRadioButton("防守效率");
		防守效率.setOpaque(false);
		防守效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		防守效率.setBounds(251, 218, 111, 36);
		contentPane.add(防守效率);
		data[0][21] = OftenUseMethod.changedouble(teama.getDefenseEfficiency());
		data[1][21] = OftenUseMethod.changedouble(teamb.getDefenseEfficiency());
		jbs.add(防守效率);

		
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(init.sysdarkblue);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose();
			}
		});
		btnNewButton.setFont(new Font("华康雅宋体W9", Font.PLAIN, 14));
		btnNewButton.setBounds(399, 260, 93, 30);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(init.sysdarkblue);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<jbs.size();i++){
					final JRadioButton tempjb = jbs.get(i);
					if(tempjb.isSelected()){
						outputcontent[now] = tempjb.getText();
						dataoutput[0][now] = data[0][i];
						dataoutput[1][now] = data[1][i];
						now++;
						if(now == 8){break;}
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
		button.setBounds(292, 260, 93, 30);
		contentPane.add(button);

		contentPane.setBackground(new Color(183,222,222));

	}
}
