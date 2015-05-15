package UI.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import UI.common.CreateTable;
import UI.common.CreateTable_pic;
import VO.PlayerInfoVO;





public class Player_Info extends JPanel {

	public static CreateTable_pic playerinfolist;
	
	Font f=new Font("华康雅宋体W9", Font.PLAIN, 12);
	public static String[] playerinfotitle = { "序号","肖像", "姓名", "球号 ", "位置", "身高",
			"体重", "出生日期", "年龄", "球龄", "毕业院校" };
	public static Object[][] playerinfodata;
	public static ArrayList<PlayerInfoVO> pivo;
	
	
	public Player_Info(){

		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		
		/*
		JButton A = new JButton("A");
		A.setFont(new Font("Bauhaus 93", Font.PLAIN, 12));
		A.setBackground(init.sysdarkblue);
		A.setBorderPainted(false);
		A.setBounds(24, 10, 40, 40);
		add(A);*/
		
		
		
		pivo = init.pbl.getAllPlayerInfo();
		playerinfodata=getinfodata(pivo);
		playerinfolist = new CreateTable_pic(playerinfotitle, playerinfodata, 10, 60,1040, 515, 25,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(playerinfolist);
		playerinfolist.FitTableColumns(playerinfolist.getTable());
		
		String []butname={"A","B","C","D","E","F","G","H","I","G","K","L","M","N","O","P","Q","R",
				"S","T","U","V","W","X","Y","Z"};
		
		for(int i=0;i<butname.length;i++){
			//ImageIcon image = new ImageIcon("pic/TEAMPNG/"+butname[i]+".png");
			//image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT)); 		
			final String tempa = butname[i];
			final JButton charbut = new JButton(tempa);
			//btnNewButton.setContentAreaFilled(false);
			charbut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Player.textField.setText("");
					playerinfolist.updateTable(playerinfotitle, getinfodata(init.pbl.getPlayerInfoByFirstChar(charbut.getToolTipText())));
				}
			});
			add(charbut);
			charbut.setFont(f);
			charbut.setBackground(init.sysdarkblue);
			charbut.setBorderPainted(false);
			charbut.setBounds(34+38*i, 13, 35, 35);
		}
		
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 10, 1040, 42);
		add(menubg);
		menubg.setOpaque(true);
	}
	
	
	public static Object[][] getinfodata(ArrayList<PlayerInfoVO> da) {
		if (da == null) {
			Object[][] re = new Object[1][11];
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
			return re;
		} else {
			Object[][] re = new Object[da.size()][11];
			/* "序号","姓名","球号","位置","身高","体重","出生日期","年龄","球龄","毕业院校" */
			
			for (int i = 0; i < da.size(); i++) {
				re[i][0] =changenumber( i + 1);
				ImageIcon image = new ImageIcon("newpic/portrait/"+da.get(i).getName()+".png");
				image.setImage(image.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT));
				re[i][1] = image;
				re[i][2] = da.get(i).getName();
				re[i][3] = da.get(i).getNumber();
				re[i][4] = da.get(i).getPosition();
				re[i][5] = da.get(i).getHeight();
				re[i][6] = da.get(i).getWeight();
				re[i][7] = da.get(i).getBirth();
				re[i][8] = da.get(i).getAge();
				re[i][9] = da.get(i).getExp();
				re[i][10] = da.get(i).getSchool();

			}
			return re;

		}
	}
	public static String changenumber(int number){
		//System.out.println(rate);
				
		DecimalFormat df = new DecimalFormat("000");    
		String temp=String.valueOf(df.format(number));
		return temp;
		
	}
}
