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
		data[0][0] = OftenUseMethod.changedouble(teama.getO_ReboundNum());
		data[1][0] = OftenUseMethod.changedouble(teamb.getO_ReboundNum());
		jbs.add(��������);
		
		final JRadioButton �������� = new JRadioButton("��������");
		��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		��������.setBounds(133, 31, 95, 36);
		��������.setOpaque(false);
		contentPane.add(��������);
		data[0][1] = OftenUseMethod.changedouble(teama.getD_ReboundNum());
		data[1][1] = OftenUseMethod.changedouble(teamb.getD_ReboundNum());
		jbs.add(��������);
		
		final JRadioButton ���� = new JRadioButton("\u7BEE\u677F");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(242, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][2] = OftenUseMethod.changedouble(teama.getReboundNum());
		data[1][2] = OftenUseMethod.changedouble(teamb.getReboundNum());
		jbs.add(����);
		
		final JRadioButton ���� = new JRadioButton("\u52A9\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(318, 31, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][3] = OftenUseMethod.changedouble(teama.getAssistNum());
		data[1][3] = OftenUseMethod.changedouble(teamb.getAssistNum());
		jbs.add(����);
		
		final JRadioButton Ͷ���� = new JRadioButton("Ͷ����");
		Ͷ����.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ����.setBounds(399, 31, 95, 36);
		Ͷ����.setOpaque(false);
		data[0][4] = OftenUseMethod.changedouble(teama.getShootNum());
		data[1][4] = OftenUseMethod.changedouble(teamb.getShootNum());
		contentPane.add(Ͷ����);
		jbs.add(Ͷ����);
		
		final JRadioButton Ͷ�������� = new JRadioButton("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��������.setBounds(20, 69, 106, 36);
		Ͷ��������.setOpaque(false);
		contentPane.add(Ͷ��������);
		data[0][5] = OftenUseMethod.changedouble(teama.getShootPercentage());
		data[1][5] = OftenUseMethod.changedouble(teamb.getShootPercentage());
		jbs.add(Ͷ��������);
		
		final JRadioButton ���������� = new JRadioButton("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(130, 69, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		data[0][6] = OftenUseMethod.changedouble(teama.getThreePointPercentage());
		data[1][6] = OftenUseMethod.changedouble(teamb.getThreePointPercentage());
		jbs.add(����������);
		
		final JRadioButton ���������� = new JRadioButton("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(242, 69, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		data[0][7] = OftenUseMethod.changedouble(teama.getFreeThrowPercentage());
		data[1][7] = OftenUseMethod.changedouble(teamb.getFreeThrowPercentage());
		jbs.add(����������);
		
		final JRadioButton ���� = new JRadioButton("\u8FDB\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(353, 69, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][8] = OftenUseMethod.changedouble(teama.getO_ReboundNum());
		data[1][8] = OftenUseMethod.changedouble(teamb.getO_ReboundNum());
		jbs.add(����);
		
		final JRadioButton ���� = new JRadioButton("\u9632\u5B88");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(427, 69, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][9] = OftenUseMethod.changedouble(teama.getD_ReboundNum());
		data[1][9] = OftenUseMethod.changedouble(teamb.getD_ReboundNum());
		jbs.add(����);
		
		final JRadioButton ���� = new JRadioButton("\u62A2\u65AD");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(20, 107, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][10] = OftenUseMethod.changedouble(teama.getStealNum());
		data[1][10] = OftenUseMethod.changedouble(teamb.getStealNum());
		jbs.add(����);
		
		final JRadioButton ��ñ = new JRadioButton("\u76D6\u5E3D");
		��ñ.setFont(new Font("����������W9", Font.PLAIN, 14));
		��ñ.setBounds(104, 107, 67, 36);
		��ñ.setOpaque(false);
		contentPane.add(��ñ);
		data[0][11] = OftenUseMethod.changedouble(teama.getBlockNum());
		data[1][11] = OftenUseMethod.changedouble(teamb.getBlockNum());
		jbs.add(��ñ);
		
		final JRadioButton ʧ�� = new JRadioButton("\u5931\u8BEF");
		ʧ��.setFont(new Font("����������W9", Font.PLAIN, 14));
		ʧ��.setBounds(180, 107, 67, 36);
		ʧ��.setOpaque(false);
		contentPane.add(ʧ��);
		data[0][12] = OftenUseMethod.changedouble(teama.getTurnoverNum());
		data[1][12] = OftenUseMethod.changedouble(teamb.getTurnoverNum());
		jbs.add(ʧ��);
		
		final JRadioButton ���� = new JRadioButton("\u72AF\u89C4");
		����.setFont(new Font("����������W9", Font.PLAIN, 14));
		����.setBounds(263, 107, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		data[0][13] = OftenUseMethod.changedouble(teama.getFoulNum());
		data[1][13] = OftenUseMethod.changedouble(teamb.getFoulNum());
		jbs.add(����);
		
		final JRadioButton �÷� = new JRadioButton("\u5F97\u5206");
		�÷�.setFont(new Font("����������W9", Font.PLAIN, 14));
		�÷�.setBounds(344, 107, 67, 36);
		�÷�.setOpaque(false);
		contentPane.add(�÷�);
		data[0][14] = OftenUseMethod.changedouble(teama.getPointNum());
		data[1][14] = OftenUseMethod.changedouble(teamb.getPointNum());
		jbs.add(�÷�);
		
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 149, 188, 36);
		contentPane.add(label_1);

		
		final JRadioButton Ͷ��Ч�� = new JRadioButton("\u6295\u7BEE\u6548\u7387");
		Ͷ��Ч��.setOpaque(false);
		Ͷ��Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		Ͷ��Ч��.setBounds(20, 180, 95, 36);
		contentPane.add(Ͷ��Ч��);
		data[0][15] = OftenUseMethod.changedouble(teama.getShootPercentage());
		data[1][15] = OftenUseMethod.changedouble(teamb.getShootPercentage());
		jbs.add(Ͷ��Ч��);
		
		final JRadioButton ���������� = new JRadioButton("����������");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(20, 218, 105, 36);
		contentPane.add(����������);
		data[0][16] = OftenUseMethod.changedouble(teama.getO_ReboundEfficiency());
		data[1][16] = OftenUseMethod.changedouble(teamb.getO_ReboundEfficiency());
		jbs.add(����������);
		
		final JRadioButton ���������� = new JRadioButton("����������");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 14));
		����������.setBounds(133, 218, 106, 36);
		contentPane.add(����������);
		data[0][17] = OftenUseMethod.changedouble(teama.getD_ReboundEfficiency());
		data[1][17] = OftenUseMethod.changedouble(teamb.getD_ReboundEfficiency());
		jbs.add(����������);
		
		final JRadioButton ������ = new JRadioButton("\u52A9\u653B\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(133, 180, 75, 36);
		contentPane.add(������);
		data[0][18] = OftenUseMethod.changedouble(teama.getAssistEfficiency());
		data[1][18] = OftenUseMethod.changedouble(teamb.getAssistEfficiency());
		jbs.add(������);
		
		final JRadioButton ������ = new JRadioButton("\u62A2\u65AD\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 14));
		������.setBounds(248, 180, 78, 36);
		contentPane.add(������);
		data[0][19] = OftenUseMethod.changedouble(teama.getStealEfficiency());
		data[1][19] = OftenUseMethod.changedouble(teamb.getStealEfficiency());
		jbs.add(������);
		
		final JRadioButton ����Ч�� = new JRadioButton("����Ч��");
		����Ч��.setOpaque(false);
		����Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		����Ч��.setBounds(341, 180, 95, 36);
		contentPane.add(����Ч��);
		data[0][20] = OftenUseMethod.changedouble(teama.getOffenseEfficiency());
		data[1][20] = OftenUseMethod.changedouble(teamb.getOffenseEfficiency());
		jbs.add(����Ч��);
		
		final JRadioButton ����Ч�� = new JRadioButton("����Ч��");
		����Ч��.setOpaque(false);
		����Ч��.setFont(new Font("����������W9", Font.PLAIN, 14));
		����Ч��.setBounds(251, 218, 111, 36);
		contentPane.add(����Ч��);
		data[0][21] = OftenUseMethod.changedouble(teama.getDefenseEfficiency());
		data[1][21] = OftenUseMethod.changedouble(teamb.getDefenseEfficiency());
		jbs.add(����Ч��);

		
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(init.sysdarkblue);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose();
			}
		});
		btnNewButton.setFont(new Font("����������W9", Font.PLAIN, 14));
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
				//ִ�к���+�ر�
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
		
		button.setFont(new Font("����������W9", Font.PLAIN, 14));
		button.setBounds(292, 260, 93, 30);
		contentPane.add(button);

		contentPane.setBackground(new Color(183,222,222));

	}
}
