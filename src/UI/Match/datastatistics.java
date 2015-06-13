package UI.Match;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.common.CreateTable_pic;
import UI.main.init;
import VO.MatchVO;
import VO.PlayerInfoVO;
import VO.SingleMatchPersonalDataVO;

import java.awt.Font;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class datastatistics extends JPanel {

	public static CreateTable_pic playerinfolist;
	String teamnameA = "°Â¶ûÁ¼¿¾Ñ¼";
	String teamnameB = "à½à½¼¦ÅÅ";
	public static String[] playerinfotitle = { "ÐòºÅ","Ð¤Ïñ", "ÐÕÃû", "Î»ÖÃ", "·ÖÖÓ", "ÃüÖÐ",
		"Èý·Ö", "·£Çò", "Àº°å", "Öú¹¥", "·¸¹æ","ÇÀ¶Ï","Ê§Îó","¸ÇÃ±","·ÖÊý" };
	public static Object[][] playerinfodata;
	public static ArrayList<SingleMatchPersonalDataVO> pivo;
	MatchVO mvo;
	
	public datastatistics( MatchVO mo) {
		mvo = mo;
		teamnameA = mvo.getHostTeam().getTeamName();
		teamnameB = mvo.getGuestTeam().getTeamName();
		
		playerinfolist = new CreateTable_pic(playerinfotitle, playerinfodata, 10, 60,1040, 515, 35,
				new Font("ºÚÌå", 0, 15), new Font("Dialog", 0, 12));
		
		JButton teamAButton = new JButton(teamnameA);
		teamAButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pivo=mvo.getHostTeam().getIndividualData();
				playerinfodata=getinfodata(pivo);
				playerinfolist.updateTable(playerinfotitle, playerinfodata);
			}
		});
		teamAButton.setBackground(init.sysdarkblue);
		teamAButton.setForeground(init.syspurple);
		teamAButton.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		teamAButton.setBounds(25, 8, 150, 50);
		this.add(teamAButton);
		
		JButton teamBButton = new JButton(teamnameB);
		teamBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pivo=mvo.getGuestTeam().getIndividualData();
				playerinfodata=getinfodata(pivo);
				playerinfolist.updateTable(playerinfotitle, playerinfodata);
			}
		});
		teamBButton.setBackground(init.sysdarkblue);
		teamBButton.setForeground(init.syspurple);
		teamBButton.setFont(new Font("ºÚÌå", Font.BOLD, 18));
		teamBButton.setBounds(175, 8, 150, 50);
		this.add(teamBButton);
		
		ImageIcon image = new ImageIcon("newpic/±ÈÈü¼¼ÊõÍ³¼Æ.jpg");
		image.setImage(image.getImage().getScaledInstance(1042, 580,Image.SCALE_DEFAULT));
		this.setLayout(null);
		JLabel photo = new JLabel(image);
		photo.setBounds(0, 0, 1042, 580);
		photo.setOpaque(false);
		this.add(photo);
		
		
		
	}
	public static String changenumber(int number){
		//System.out.println(rate);
				
		DecimalFormat df = new DecimalFormat("000");    
		String temp=String.valueOf(df.format(number));
		return temp;
		
	}
	public static Object[][] getinfodata(ArrayList<SingleMatchPersonalDataVO> da) {
		if (da == null) {
			Object[][] re = new Object[1][15];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			re[0][11] = "";
			re[0][12] = "";
			re[0][13] = "";
			re[0][14] = "";
			return re;
		} else {
			Object[][] re = new Object[da.size()][11];
			 /*{ "ÐòºÅ","Ð¤Ïñ", "ÐÕÃû", "Î»ÖÃ", "·ÖÖÓ", "½øÇò",
					"Èý·Ö", "·£Çò", "Àº°å", "Öú¹¥", "·¸¹æ","ÇÀ¶Ï","Ê§Îó","¸ÇÃ±","·ÖÊý" };*/
			for (int i = 0; i < da.size(); i++) {
				re[i][0] =changenumber( i + 1);
				ImageIcon image = new ImageIcon("newpic/portrait/"+da.get(i).getPlayerName()+".png");
				image.setImage(image.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT));
				re[i][1] = image;
				re[i][2] = da.get(i).getPlayerName();
				re[i][3] = da.get(i).getPlayerPosition();
				re[i][4] = da.get(i).getTime();
				re[i][5] = da.get(i).getFieldGoal();
				re[i][6] = da.get(i).getT_fieldGoal();
				re[i][7] = da.get(i).getFreeThrowNum();
				re[i][8] = da.get(i).getReboundNum();
				re[i][9] = da.get(i).getAssistNum();
				re[0][10] = da.get(i).getFoulNum();
				re[i][11] = da.get(i).getStealNum();
				re[0][12] = da.get(i).getTurnoverNum();
				re[0][13] = da.get(i).getBlockNum();
				re[0][14] = da.get(i).getPointNum();
			}
			return re;

		}
	}
}
