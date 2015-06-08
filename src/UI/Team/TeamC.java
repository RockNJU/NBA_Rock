package UI.Team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import UI.main.ContrastTeam;
import UI.main.init;
import VO.TeamSeasonDataVO;

public class TeamC extends JPanel {

	/**
	 * Create the panel.
	 */
	String na;
	JPanel contentPane;
	TeamSeasonDataVO Teama;
	TeamSeasonDataVO Teamb;	
	String[] paintcontent = {"球队胜率","得分","助攻","篮板","三分","罚球","投篮"};
	int paintcontentnum = 7;
	double[] paintdataA = {24,0,24,52,26,57.56,100};
	double[] paintdataB = {74,12,86,1,59.3,23.1,99.6};
	double[] paintdataC = {0,0,0,0,0.0,0.0,0.0};
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public TeamC(String name) {
		this.na=name;
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1042, 580);
		add(contentPane);
		
		//test暂用
		//Teama = pbs.keyfind("Brooks").get(0);
		
		//获取信息
		String portraitA = "newpic/fortest/Aaron Brooks.png";
		String teamA = "Avaliers";
		String infoA = "11\u53F7/\u4E2D\u536B";
		String nameA = "Aaron Brooks";
		String portraitB = "newpic/fortest/Aaron Brooks.png";
		String teamB = "Avaliers";
		String infoB = "11\u53F7/\u4E2D\u536B";
		String nameB = "Aaron Brooks";
		//头像
		 ImageIcon Teamfirst = new ImageIcon(portraitA);
		 Teamfirst.setImage(Teamfirst.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
			contentPane.setLayout(null);
			JLabel photoTeam1 = new JLabel(Teamfirst);
			photoTeam1.setBounds(255, 10, 230, 185);
			photoTeam1.setOpaque(false);
			contentPane.add(photoTeam1);
			
			JLabel teamfirst = new JLabel(teamA);
			teamfirst.setHorizontalAlignment(SwingConstants.RIGHT);
			teamfirst.setForeground(new Color(155, 106, 141));
			teamfirst.setFont(new Font("黑体", Font.BOLD, 18));
			teamfirst.setBounds(130, 65, 106, 24);
			contentPane.add(teamfirst);
			
			JLabel infofirst = new JLabel(infoA);
			infofirst.setHorizontalAlignment(SwingConstants.RIGHT);
			infofirst.setForeground(new Color(155, 106, 141));
			infofirst.setFont(new Font("黑体", Font.BOLD, 18));
			infofirst.setBounds(130, 44, 106, 24);
			contentPane.add(infofirst);
			
			JLabel namefirst = new JLabel(nameA);
			namefirst.setHorizontalAlignment(SwingConstants.RIGHT);
			namefirst.setForeground(new Color(155, 106, 141));
			namefirst.setFont(new Font("Verdana", Font.PLAIN, 30));
			namefirst.setBounds(25, 9, 211, 36);
			contentPane.add(namefirst);
			
			JTextField findTeamfist = new JTextField();
			findTeamfist.setBackground(new Color(219, 241, 241));
			findTeamfist.setBounds(42, 162, 184, 24);
			contentPane.add(findTeamfist);
			
			JButton firstfind = new JButton("");
			firstfind.setToolTipText("\u67E5\u627E\u5BF9\u5E94\u7684\u7403\u5458");
			firstfind.setBounds(228, 162, 25, 25);
			firstfind.setContentAreaFilled(false); 
			contentPane.add(firstfind);
			
			 ImageIcon Teamsecond = new ImageIcon(portraitB);
			 Teamsecond.setImage(Teamsecond.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
			JLabel photoTeam2 = new JLabel( Teamsecond);
			photoTeam2.setOpaque(false);
			photoTeam2.setBounds(552, 10, 230, 185);
			contentPane.add(photoTeam2);
			
			JLabel teamsecond = new JLabel(teamB);
			teamsecond.setHorizontalAlignment(SwingConstants.LEFT);
			teamsecond.setForeground(new Color(155, 106, 141));
			teamsecond.setFont(new Font("黑体", Font.BOLD, 18));
			teamsecond.setBounds(804, 65, 106, 24);
			contentPane.add(teamsecond);
			
			JLabel infosecond = new JLabel(infoB);
			infosecond.setHorizontalAlignment(SwingConstants.LEFT);
			infosecond.setForeground(new Color(155, 106, 141));
			infosecond.setFont(new Font("黑体", Font.BOLD, 18));
			infosecond.setBounds(804, 44, 106, 24);
			contentPane.add(infosecond);
			
			JLabel namesecond = new JLabel(nameB);
			namesecond.setHorizontalAlignment(SwingConstants.LEFT);
			namesecond.setForeground(new Color(155, 106, 141));
			namesecond.setFont(new Font("Verdana", Font.PLAIN, 30));
			namesecond.setBounds(804, 9, 211, 36);
			contentPane.add(namesecond);
			
			textField = new JTextField();
			textField.setBackground(new Color(219, 241, 241));
			textField.setBounds(797, 162, 184, 24);
			contentPane.add(textField);
			
		
			JButton findsecond = new JButton("");
			findsecond.setToolTipText("\u67E5\u627E\u5BF9\u5E94\u7684\u7403\u5458");
			findsecond.setContentAreaFilled(false);
			findsecond.setBounds(985, 162, 25, 25);
			contentPane.add(findsecond);
			
			//绘制下方
			paintunder(paintcontentnum,paintcontent,paintdataB,paintdataA);
			
			//绘制下方选择按钮
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContrastTeam cp = new ContrastTeam();
					cp.setLocation(init.SysStart_X+380, init.SysStart_Y+342);
					cp.setVisible(true);
				}
			});
			btnNewButton.setIcon(new ImageIcon("newpic\\\u5BF9\u6BD4\u66F4\u66FF.png"));
			btnNewButton.setBounds(491, 189, 60, 23);
			contentPane.add(btnNewButton);		
			
		//背景
		ImageIcon image = new ImageIcon("newpic/对比界面实用.jpg");
			image.setImage(image.getImage().getScaledInstance(1042, 580,Image.SCALE_DEFAULT));
			contentPane.setLayout(null);
			JLabel photo = new JLabel(image);
			photo.setBounds(0, 0, 1042, 580);
			photo.setOpaque(false);
			contentPane.add(photo);
			

	}
	//选择对比数据后，得到对比数据
	public double[] getdata(String[] list){
		double[] result = new double[9];
			for(String temp:list){
				//获得数据
			}
		return result;
	}
	
	//重绘下方对比区域
	public void paintunder(int num,String[] contrat,double[] dataforB,double[] dataforA){
		//数据保留两位有效小数，无对应数据则为0，数据尽量不要超过100
		
		int heightadjust = 0;
		//paintunder(paintcontentnum,paintcontent,paintdataA,paintdataC);
		
		

		for(int i = 0;i<num;i++){
		
		JLabel label = new JLabel(contrat[i]);
		label.setForeground(new Color(155, 106, 141));
		label.setFont(new Font("黑体", Font.BOLD, 20));
		label.setBounds(476, 212+i*45+heightadjust, 91, 30);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		int locationforR =  (int) Math.rint(dataforB[i]);
		String rstring = "newpic/对比/低000.png";
		char fora = '低';
		int locationforL = (int) Math.rint(dataforA[i]);
		String lstring = "newpic/对比/低000.png";
		char forb = '低';
		

		
		if(dataforB[i]>dataforA[i]){
			fora = '高';
			forb = '低';
		}
		else if(dataforB[i]<dataforA[i]){
			fora = '低';
			forb = '高';
		}
		
		if(locationforR>=100){
			rstring = "newpic/对比/"+fora+"099.png";
		}
		else if(locationforR>=10){
		 rstring = "newpic/对比/"+fora+"0"+locationforR+".png";
		}
		else if(locationforR<=0){
		rstring = "newpic/对比/"+fora+"000.png";
		}
		else if(locationforR<10){
		 rstring = "newpic/对比/"+fora+"00"+locationforR+".png";
		}
		
		if(locationforL>=100){
			lstring = "newpic/对比/"+forb+"099.png";
		}
		else if(locationforL>=10){
			lstring = "newpic/对比/"+forb+"0"+locationforL+".png";
		}
		else if(locationforL<=0){
			lstring = "newpic/对比/"+forb+"000.png";
		}
		else if(locationforL<10){
			lstring = "newpic/对比/"+forb+"00"+locationforL+".png";
		
		}
		//System.out.print(rfstring1+"\n");

		
		JLabel righttext1 = new JLabel(String.valueOf(dataforB[i]));
		righttext1.setFont(new Font("宋体", Font.BOLD, 20));
		righttext1.setForeground(new Color(155, 106, 141));
		righttext1.setBounds(580+7+3*locationforR, 214+i*45+heightadjust, 68, 24);
		contentPane.add(righttext1);
		
		ImageIcon rightfirstim = new ImageIcon(rstring);
		//leftfirstim.setImage(leftfirstim.getImage().getScaledInstance(1042, 610,Image.SCALE_DEFAULT));
		JLabel rightlable1 = new JLabel(rightfirstim);
		rightlable1.setBounds(580, 210+i*45+heightadjust,rightfirstim.getIconWidth() , rightfirstim.getIconHeight());
		rightlable1.setOpaque(false);
		contentPane.add(rightlable1);
		

	
		
		JLabel lefttext1 = new JLabel(String.valueOf(dataforA[i]));
		lefttext1.setFont(new Font("宋体", Font.BOLD, 20));
		lefttext1.setForeground(new Color(155, 106, 141));
		lefttext1.setBounds(400-3*locationforL, 214+i*45+heightadjust, 68, 24);
		contentPane.add(lefttext1);
		
		//翻转图像
		BufferedImage sourceImage = null;
		BufferedImage dstImage = null;  
	     try {
	    	 File file = new File(lstring);
			 sourceImage = ImageIO.read(file);
			  AffineTransform transform = new AffineTransform(-1, 0, 0, 1, sourceImage.getWidth(), 0);// 水平翻转  
			  AffineTransformOp op = new AffineTransformOp(transform,  
			          AffineTransformOp.TYPE_BILINEAR);  
			      dstImage = op.filter(sourceImage, null);  
	     } catch (IOException e) {
			e.printStackTrace();
		}  
		JLabel leftlable1 = new JLabel( new ImageIcon(dstImage));
		leftlable1.setOpaque(false);
		leftlable1.setBounds(162, 210+i*45+heightadjust, sourceImage.getWidth(),  sourceImage.getHeight());
		contentPane.add(leftlable1);
	}
	}
}
