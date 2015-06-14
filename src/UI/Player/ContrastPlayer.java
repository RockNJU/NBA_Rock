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
		setUndecorated(true);// ȡ����������Ч��************
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(183,222,222));
		
		JLabel label = new JLabel(
				"\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("����������W9", Font.PLAIN, 18));
		label.setBounds(10, 0, 188, 36);
		contentPane.add(label);
		
		final JRadioButton �������� = new JRadioButton("��������");
		��������.setBounds(20, 31, 106, 36);
		��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��������.setOpaque(false);
		contentPane.add(��������);
		data[0][0] = OftenUseMethod.changedouble(playera.getMatchNum());
		data[1][0] = OftenUseMethod.changedouble(playerb.getMatchNum());
		jbs.add(��������);
		
		final JRadioButton �ȷ����� = new JRadioButton("\u5148\u53D1\u573A\u6570");
		�ȷ�����.setFont(new Font("����������W9", Font.PLAIN, 14));
		�ȷ�����.setBounds(133, 31, 95, 36);
		�ȷ�����.setOpaque(false);
		contentPane.add(�ȷ�����);
		data[0][1] = OftenUseMethod.changedouble(playera.getStartingNum());
		data[1][1] = OftenUseMethod.changedouble(playerb.getStartingNum());
		jbs.add(�ȷ�����);
		
		final JRadioButton ���� = new JRadioButton("\u7BEE\u677F");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(242, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][2] = OftenUseMethod.changedouble(playera.getReboundNum_avg());
		data[1][2] = OftenUseMethod.changedouble(playerb.getReboundNum_avg());
		jbs.add(����);
		
		final JRadioButton ���� = new JRadioButton("\u52A9\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(318, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][3] = OftenUseMethod.changedouble(playera.getAssistNum_avg());
		data[1][3] = OftenUseMethod.changedouble(playerb.getAssistNum_avg());
		jbs.add(����);
		
		final JRadioButton �ϳ�ʱ�� = new JRadioButton("\u4E0A\u573A\u65F6\u95F4");
		�ϳ�ʱ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		�ϳ�ʱ��.setBounds(399, 31, 95, 36);
		�ϳ�ʱ��.setOpaque(false);
		data[0][4] = OftenUseMethod.changedouble(playera.getTime_avg());
		data[1][4] = OftenUseMethod.changedouble(playerb.getTime_avg());
		contentPane.add(�ϳ�ʱ��);
		jbs.add(�ϳ�ʱ��);
		
		final JRadioButton Ͷ�������� = new JRadioButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��������.setBounds(20, 69, 106, 36);
		Ͷ��������.setOpaque(false);
		contentPane.add(Ͷ��������);
		data[0][5] = OftenUseMethod.changedouble(playera.getShootPercentage());
		data[1][5] = OftenUseMethod.changedouble(playerb.getShootPercentage());
		jbs.add(Ͷ��������);
		
		final JRadioButton ���������� = new JRadioButton("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(130, 69, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		data[0][6] = OftenUseMethod.changedouble(playera.getT_shootPercentage());
		data[1][6] = OftenUseMethod.changedouble(playerb.getT_shootPercentage());
		jbs.add(����������);
		
		final JRadioButton ���������� = new JRadioButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(242, 69, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		data[0][7] = OftenUseMethod.changedouble(playera.getFreeThrowPercentage());
		data[1][7] = OftenUseMethod.changedouble(playerb.getFreeThrowPercentage());
		jbs.add(����������);
		
		final JRadioButton ���� = new JRadioButton("\u8FDB\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(353, 69, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][8] = OftenUseMethod.changedouble(playera.getO_ReboundNum_avg());
		data[1][8] = OftenUseMethod.changedouble(playerb.getO_ReboundNum_avg());
		jbs.add(����);
		
		final JRadioButton ���� = new JRadioButton("\u9632\u5B88");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(427, 69, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][9] = OftenUseMethod.changedouble(playera.getD_ReboundNum_avg());
		data[1][9] = OftenUseMethod.changedouble(playerb.getD_ReboundNum_avg());
		jbs.add(����);
		
		final JRadioButton ���� = new JRadioButton("\u62A2\u65AD");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(20, 107, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][10] = OftenUseMethod.changedouble(playera.getStealNum_avg());
		data[1][10] = OftenUseMethod.changedouble(playerb.getStealNum_avg());
		jbs.add(����);
		
		final JRadioButton ��ñ = new JRadioButton("\u76D6\u5E3D");
		��ñ.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ñ.setBounds(104, 107, 67, 36);
		��ñ.setOpaque(false);
		contentPane.add(��ñ);
		data[0][11] = OftenUseMethod.changedouble(playera.getBlockNum_avg());
		data[1][11] = OftenUseMethod.changedouble(playerb.getBlockNum_avg());
		jbs.add(��ñ);
		
		final JRadioButton ʧ�� = new JRadioButton("\u5931\u8BEF");
		ʧ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʧ��.setBounds(180, 107, 67, 36);
		ʧ��.setOpaque(false);
		contentPane.add(ʧ��);
		data[0][12] = OftenUseMethod.changedouble(playera.getTurnoverNum_avg());
		data[1][12] = OftenUseMethod.changedouble(playerb.getTurnoverNum_avg());
		jbs.add(ʧ��);
		
		final JRadioButton ���� = new JRadioButton("\u72AF\u89C4");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(263, 107, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][13] = OftenUseMethod.changedouble(playera.getFoulNum_avg());
		data[1][13] = OftenUseMethod.changedouble(playerb.getFoulNum_avg());
		jbs.add(����);
		
		final JRadioButton �÷� = new JRadioButton("\u5F97\u5206");
		�÷�.setFont(new Font("����������W9", Font.PLAIN, 14));
		�÷�.setBounds(344, 107, 67, 36);
		�÷�.setOpaque(false);
		contentPane.add(�÷�);
		data[0][14] = OftenUseMethod.changedouble(playera.getPointNum_avg());
		data[1][14] = OftenUseMethod.changedouble(playerb.getPointNum_avg());
		jbs.add(�÷�);
		
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 149, 188, 36);
		contentPane.add(label_1);

		final JRadioButton Ч�� = new JRadioButton("\u6548\u7387");
		Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ч��.setBounds(20, 180, 61, 36);
		Ч��.setOpaque(false);
		contentPane.add(Ч��);
		data[0][15] = OftenUseMethod.changedouble(playera.getEfficiency());
		data[1][15] = OftenUseMethod.changedouble(playerb.getEfficiency());
		jbs.add(Ч��);
		
		final JRadioButton Gmsc = new JRadioButton("GmSC\u6548\u7387\u503C");
		Gmsc.setFont(new Font("����������W9", Font.PLAIN, 14));
		Gmsc.setBounds(87, 180, 105, 36);
		Gmsc.setOpaque(false);
		contentPane.add(Gmsc);
		data[0][16] = OftenUseMethod.changedouble(playera.getGmSc());
		data[1][16] = OftenUseMethod.changedouble(playerb.getGmSc());
		jbs.add(Gmsc);

		final JRadioButton ��ʵ������ = new JRadioButton("\u771F\u5B9E\u547D\u4E2D\u7387");
		��ʵ������.setOpaque(false);
		��ʵ������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ʵ������.setBounds(200, 180, 103, 36);
		contentPane.add(��ʵ������);
		data[0][17] = OftenUseMethod.changedouble(playera.getRealShootPercentage());
		data[1][17] = OftenUseMethod.changedouble(playerb.getRealShootPercentage());
		jbs.add(��ʵ������);
		
		final JRadioButton Ͷ��Ч�� = new JRadioButton("\u6295\u7BEE\u6548\u7387");
		Ͷ��Ч��.setOpaque(false);
		Ͷ��Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��Ч��.setBounds(310, 180, 95, 36);
		contentPane.add(Ͷ��Ч��);
		data[0][18] = OftenUseMethod.changedouble(playera.getShootEfficiency());
		data[1][18] = OftenUseMethod.changedouble(playerb.getShootEfficiency());
		jbs.add(Ͷ��Ч��);
		
		final JRadioButton ������ = new JRadioButton("\u7BEE\u677F\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(415, 180, 79, 36);
		contentPane.add(������);
		data[0][19] = OftenUseMethod.changedouble(playera.getReboundEfficiency());
		data[1][19] = OftenUseMethod.changedouble(playerb.getReboundEfficiency());
		jbs.add(������);
		
		final JRadioButton ���������� = new JRadioButton("\u8FDB\u653B\u7BEE\u677F\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(20, 218, 105, 36);
		contentPane.add(����������);
		data[0][20] = OftenUseMethod.changedouble(playera.getOffensiveReboundEff_avg());
		data[1][20] = OftenUseMethod.changedouble(playerb.getOffensiveReboundEff_avg());
		jbs.add(����������);
		
		final JRadioButton ���������� = new JRadioButton("\u9632\u5B88\u7BEE\u677F\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(133, 218, 106, 36);
		contentPane.add(����������);
		data[0][21] = OftenUseMethod.changedouble(playera.getDefenseReboundEff_avg());
		data[1][21] = OftenUseMethod.changedouble(playerb.getDefenseReboundEff_avg());
		jbs.add(����������);
		
		final JRadioButton ������ = new JRadioButton("\u52A9\u653B\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(248, 218, 75, 36);
		contentPane.add(������);
		data[0][22] = OftenUseMethod.changedouble(playera.getAssistEfficiency_avg());
		data[1][22] = OftenUseMethod.changedouble(playerb.getAssistEfficiency_avg());
		jbs.add(������);
		
		final JRadioButton ������ = new JRadioButton("\u62A2\u65AD\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(333, 218, 78, 36);
		contentPane.add(������);
		data[0][23] = OftenUseMethod.changedouble(playera.getStealEfficiency_avg());
		data[1][23] = OftenUseMethod.changedouble(playerb.getStealEfficiency_avg());
		jbs.add(������);
		
		final JRadioButton ��ñ�� = new JRadioButton("\u76D6\u5E3D\u7387");
		��ñ��.setOpaque(false);
		��ñ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ñ��.setBounds(415, 218, 79, 36);
		contentPane.add(��ñ��);
		data[0][24] = OftenUseMethod.changedouble(playera.getBlockEfficiency());
		data[1][24] = OftenUseMethod.changedouble(playerb.getBlockEfficiency());
		jbs.add(��ñ��);
		
		final JRadioButton ʧ���� = new JRadioButton("\u5931\u8BEF\u7387");
		ʧ����.setOpaque(false);
		ʧ����.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʧ����.setBounds(20, 256, 79, 36);
		contentPane.add(ʧ����);
		data[0][25] = OftenUseMethod.changedouble(playera.getTurnoverPercentage());
		data[1][25] = OftenUseMethod.changedouble(playerb.getTurnoverPercentage());
		jbs.add(ʧ����);
		
		final JRadioButton ʹ���� = new JRadioButton("\u4F7F\u7528\u7387");
		ʹ����.setOpaque(false);
		ʹ����.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʹ����.setBounds(107, 256, 78, 36);
		getContentPane().add(ʹ����);
		data[0][26] = OftenUseMethod.changedouble(playera.getUsingPercentage_avg());
		data[1][26] = OftenUseMethod.changedouble(playerb.getUsingPercentage_avg());
		jbs.add(ʹ����);
		
		final JRadioButton ���峡�÷������� = new JRadioButton(
				"\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387");
		���峡�÷�������.setOpaque(false);
		���峡�÷�������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���峡�÷�������.setBounds(193, 256, 145, 36);
		contentPane.add(���峡�÷�������);
		data[0][27] = OftenUseMethod.changedouble(playera.getL_f_point_rate());
		data[1][27] = OftenUseMethod.changedouble(playerb.getL_f_point_rate());
		jbs.add(���峡�÷�������);
		
		final JRadioButton ���峡���������� = new JRadioButton(
				"\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387");
		���峡����������.setOpaque(false);
		���峡����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���峡����������.setBounds(349, 256, 145, 36);
		contentPane.add(���峡����������);
		data[0][28] = OftenUseMethod.changedouble(playera.getL_f_assist_rate());
		data[1][28] = OftenUseMethod.changedouble(playerb.getL_f_assist_rate());
		jbs.add(���峡����������);
		
		final JRadioButton ���峡���������� = new JRadioButton(
				"\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387");
		���峡����������.setOpaque(false);
		���峡����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		���峡����������.setBounds(20, 294, 159, 36);
		contentPane.add(���峡����������);
		data[0][29] = OftenUseMethod.changedouble(playera.getL_f_rebound_rate());
		data[1][29] = OftenUseMethod.changedouble(playerb.getL_f_rebound_rate());
		jbs.add(���峡����������);
		
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(init.sysdarkblue);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 change = false;
			    dispose();
			}
		});
		btnNewButton.setFont(new Font("����������W9", Font.PLAIN, 14));
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
				//ִ�к���+�ر�
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
		
		button.setFont(new Font("����������W9", Font.PLAIN, 14));
		button.setBounds(292, 310, 93, 30);
		contentPane.add(button);

		contentPane.setBackground(new Color(183,222,222));

	}
}
