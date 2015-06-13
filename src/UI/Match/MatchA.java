package UI.Match;

import java.awt.CardLayout;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bl_db.common.Team_map;
import UI.Player.ContrastPlayer;
import UI.main.init;
import VO.MatchVO;
import VO.TeamMatchVO;

public class MatchA extends JPanel {
	
	TeamMatchVO teama;
	TeamMatchVO teamb;
	MatchVO match;
	
	String[] paintcontent = {"得分","助攻","篮板","三分","罚球","犯规","投篮"};
	int paintcontentnum = 7;
	double[] paintdataA = {24,0,24,52,26,57.56,100};
	double[] paintdataB = {74,12,86,1,59.3,23.1,99.6};
	 final CardLayout cardLayout = new CardLayout();
	 JPanel jp = new JPanel();
	int dataA[];
	int dataB[];
	Team_map tm = new Team_map();
	
	public MatchA(MatchVO mvo) {
		match = mvo;
		JLabel photoleft;
		teama = mvo.getHostTeam();
		teamb = mvo.getGuestTeam();
		
		//初始数据
		paintdataA[0] = teama.getPointNum();
		paintdataA[1] = teama.getAssistNum();
		paintdataA[2] = teama.getReboundNum();
		paintdataA[3] = teama.getT_shootNum();
		paintdataA[4] = teama.getFreeThrowNum();
		paintdataA[5] = teama.getFoulNum();
		paintdataA[6] = teama.getShootNum();
		paintdataB[0] = teamb.getPointNum();
		paintdataB[1] = teamb.getAssistNum();
		paintdataB[2] = teamb.getReboundNum();
		paintdataB[3] = teamb.getT_shootNum();
		paintdataB[4] = teamb.getFreeThrowNum();
		paintdataB[5] = teamb.getFoulNum();
		paintdataB[6] = teamb.getShootNum();
		
		 jp.setBounds(0, 0, 1042, 580);
		 jp.setOpaque(false);
		 jp.setLayout(cardLayout);
		 this.add(jp);
		
		String nameA = teama.getTeamName();
		String portraitA = "newpic/TEAMPNG/"+tm.getFullName(nameA)+".png";
		String nameB = teamb.getTeamName();
		String portraitB = "newpic/TEAMPNG/"+tm.getFullName(nameB)+".png";
		int color[] = new int[dataA.length];
		//获取比赛数据
		int size = match.getScores().size();
		dataA = new int[size];
		dataB = new int[size];
		int tempnum = 0;
		for(String text:match.getScores()){
			dataA[tempnum] = Integer.valueOf(text.split("-")[0]);
			dataB[tempnum] = Integer.valueOf(text.split("-")[1]);
			tempnum++;
		}
		
		//处理输出的文字颜色
		for(int i = 0;i<dataA.length;i++){
				if(dataA[i]<dataB[i])
				color[i] = -1;
				else if(dataA[i]>dataB[i])
				color[i] = 1;
				else
				color[i] = 0;
		}
		int totalu = 0;
		for(int i = 0;i<dataA.length;i++){
			totalu +=dataA[i];
		}
		int totald = 0;
		for(int i = 0;i<dataB.length;i++){
			totald +=dataB[i];
		}
		int colort = 0;
		if(totalu>totald){
			colort = 1;
		}
		else{
			colort = -1;
		}
		
		JLabel Nameleft = new JLabel(nameA);
		Nameleft.setForeground(new Color(102, 51, 153));
		Nameleft.setHorizontalAlignment(SwingConstants.CENTER);
		Nameleft.setFont(new Font("黑体", Font.BOLD, 20));
		Nameleft.setBounds(35, 207, 180, 30);
		this.add(Nameleft);
		
		 ImageIcon teamleft = new ImageIcon(portraitA);
		 teamleft.setImage(teamleft.getImage().getScaledInstance(190, 190,Image.SCALE_DEFAULT));
		photoleft = new JLabel((Icon) teamleft);
		photoleft.setOpaque(false);
		photoleft.setBounds(32, 15, 190, 190);
		this.add(photoleft);
	
		JLabel Nameright = new JLabel(nameB);
		Nameright.setForeground(new Color(102, 51, 153));
		Nameright.setHorizontalAlignment(SwingConstants.CENTER);
		Nameright.setFont(new Font("黑体", Font.BOLD, 20));
		Nameright.setBounds(827, 207, 180, 30);
		this.add(Nameright);
		
		 ImageIcon teamright = new ImageIcon(portraitB);
		 teamright.setImage(teamright.getImage().getScaledInstance(190, 190,Image.SCALE_DEFAULT));
		photoleft = new JLabel((Icon) teamright);
		photoleft.setOpaque(false);
		photoleft.setBounds(825, 15, 190, 190);
		this.add(photoleft);
		
		 ImageIcon teamup = new ImageIcon(portraitA);
		 teamup.setImage(teamup.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
		JLabel photoup = new JLabel((Icon) teamup);
		photoup.setOpaque(false);
		photoup.setBounds(244, 65, 50, 50);
		this.add(photoup);
		
		 ImageIcon teamdown = new ImageIcon(portraitB);
		 teamdown.setImage(teamdown.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
		JLabel photodown = new JLabel((Icon) teamdown);
		photodown.setOpaque(false);
		photodown.setBounds(244, 125, 50, 50);
		this.add(photodown);
		
		JLabel firstup = new JLabel();
		if(color[0]==1){
			firstup.setForeground(UI.main.init.syspurple);
		}
		else{
			firstup.setForeground(UI.main.init.sysdarkblue);
		}
		firstup.setHorizontalAlignment(SwingConstants.CENTER);
		firstup.setFont(new Font("宋体", Font.BOLD, 35));
		firstup.setText(String.valueOf(dataA[0]));
		firstup.setBounds(314, 64, 50, 50);
		this.add(firstup);

		JLabel firstdown = new JLabel();
		if(color[0]==-1){
			firstdown.setForeground(UI.main.init.syspurple);
		}
		else{
			firstdown.setForeground(UI.main.init.sysdarkblue);
		}
		firstdown.setHorizontalAlignment(SwingConstants.CENTER);
		firstdown.setFont(new Font("宋体", Font.BOLD, 35));
		firstdown.setText(String.valueOf(dataB[0]));
		firstdown.setBounds(314, 124, 50, 50);
		this.add(firstdown);
		
		JLabel secondup = new JLabel();
		if(color[1]==1){
			secondup.setForeground(UI.main.init.syspurple);
		}
		else{
			secondup.setForeground(UI.main.init.sysdarkblue);
		}
		secondup.setHorizontalAlignment(SwingConstants.CENTER);
		secondup.setFont(new Font("宋体", Font.BOLD, 35));
		secondup.setText(String.valueOf(dataA[1]));
		secondup.setBounds(389, 64, 50, 50);
		this.add(secondup);

		JLabel seconddown = new JLabel();
		if(color[1]==-1){
			seconddown.setForeground(UI.main.init.syspurple);
		}
		else{
			seconddown.setForeground(UI.main.init.sysdarkblue);
		}
		seconddown.setHorizontalAlignment(SwingConstants.CENTER);
		seconddown.setFont(new Font("宋体", Font.BOLD, 35));
		seconddown.setText(String.valueOf(dataB[1]));
		seconddown.setBounds(389, 124, 50, 50);
		this.add(seconddown);
		
		JLabel thirdup = new JLabel();
		if(color[2]==1){
			thirdup.setForeground(UI.main.init.syspurple);
		}
		else{
			thirdup.setForeground(UI.main.init.sysdarkblue);
		}
		thirdup.setHorizontalAlignment(SwingConstants.CENTER);
		thirdup.setFont(new Font("宋体", Font.BOLD, 35));
		thirdup.setText(String.valueOf(dataA[2]));
		thirdup.setBounds(464, 64, 50, 50);
		this.add(thirdup);

		JLabel thirddown = new JLabel();
		if(color[2]==-1){
			thirddown.setForeground(UI.main.init.syspurple);
		}
		else{
			thirddown.setForeground(UI.main.init.sysdarkblue);
		}
		thirddown.setHorizontalAlignment(SwingConstants.CENTER);
		thirddown.setFont(new Font("宋体", Font.BOLD, 35));
		thirddown.setText(String.valueOf(dataB[2]));
		thirddown.setBounds(464, 124, 50, 50);
		this.add(thirddown);
		
		JLabel fourthup = new JLabel();
		if(color[3]==1){
			fourthup.setForeground(UI.main.init.syspurple);
		}
		else{
			fourthup.setForeground(UI.main.init.sysdarkblue);
		}
		fourthup.setHorizontalAlignment(SwingConstants.CENTER);
		fourthup.setFont(new Font("宋体", Font.BOLD, 35));
		fourthup.setText(String.valueOf(dataA[3]));
		fourthup.setBounds(539, 64, 50, 50);
		this.add(fourthup);

		JLabel fourthdown = new JLabel();
		if(color[3]==-1){
			fourthdown.setForeground(UI.main.init.syspurple);
		}
		else{
			fourthdown.setForeground(UI.main.init.sysdarkblue);
		}
		fourthdown.setHorizontalAlignment(SwingConstants.CENTER);
		fourthdown.setFont(new Font("宋体", Font.BOLD, 35));
		fourthdown.setText(String.valueOf(dataB[3]));
		fourthdown.setBounds(539, 124, 50, 50);
		this.add(fourthdown);
		
		JLabel addtimeup = new JLabel();
		StringBuffer textupaddtime = new StringBuffer() ;
		for(int i = 4;i<dataA.length;i++){
			if(i!=4){
				textupaddtime.append('-');
				}
			textupaddtime.append(dataA[i]);
		}
		addtimeup.setHorizontalAlignment(SwingConstants.LEFT);
		addtimeup.setText(textupaddtime.toString());
		addtimeup.setFont(new Font("宋体", Font.BOLD, 25));
		addtimeup.setBounds(605, 64, 92, 50);
		addtimeup.setForeground(UI.main.init.syspurple);
		this.add(addtimeup);
		
		JLabel addtimedown = new JLabel();
		StringBuffer textdownaddtime = new StringBuffer() ;
		for(int i = 4;i<dataB.length;i++){
			if(i!=4){
				textdownaddtime.append('-');
				}
			textdownaddtime.append(dataB[i]);
		}
		addtimedown.setHorizontalAlignment(SwingConstants.LEFT);
		addtimedown.setText(textdownaddtime.toString());
		addtimedown.setFont(new Font("宋体", Font.BOLD, 25));
		addtimedown.setBounds(605, 124, 92, 50);
		addtimedown.setForeground(UI.main.init.syspurple);
		this.add(addtimedown);
		
		JLabel totalup = new JLabel();
		totalup.setHorizontalAlignment(SwingConstants.CENTER);
		totalup.setText(String.valueOf(totalu));
		totalup.setFont(new Font("宋体", Font.BOLD, 35));
		totalup.setBounds(720, 64, 92, 50);
		if(colort==1){
		totalup.setForeground(UI.main.init.syspurple);
		}
		else{
			totalup.setForeground(UI.main.init.sysdarkblue);
		}
		this.add(totalup);
		
		JLabel totaldown = new JLabel();
		totaldown.setHorizontalAlignment(SwingConstants.CENTER);
		totaldown.setText(String.valueOf(totald));
		totaldown.setFont(new Font("宋体", Font.BOLD, 35));
		totaldown.setBounds(720, 124, 92, 50);
		if(colort==-1){
		totaldown.setForeground(UI.main.init.syspurple);
		}
		else{
			totaldown.setForeground(UI.main.init.sysdarkblue);
		}
		this.add(totaldown);
		
		//对比
		paintunder(paintcontentnum,paintcontent,paintdataB,paintdataA);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContrastMatch cp = new ContrastMatch(teama,teamb);
				cp.setModal(true);
				cp.setLocation(init.SysStart_X+380, init.SysStart_Y+342);
				cp.setVisible(true);
				paintunder(cp.now,cp.outputcontent,cp.dataoutput[0],cp.dataoutput[1]);
				cardLayout.next(jp);
			}
		});
		btnNewButton.setIcon(new ImageIcon("newpic\\\u5BF9\u6BD4\u66F4\u66FF.png"));
		btnNewButton.setBounds(491, 210, 60, 23);
		this.add(btnNewButton);		
		
		ImageIcon image = new ImageIcon("newpic/比赛基础.jpg");
		image.setImage(image.getImage().getScaledInstance(1042, 580,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0,0, 1042, 580);		
		photo.setOpaque(false);
		this.add(photo);
		
	}
	
	public void paintunder(int num,String[] contrat,double[] dataforB,double[] dataforA){
		//数据保留两位有效小数，无对应数据则为0，数据尽量不要超过100
		
		int heightadjust = 0;
		//paintunder(paintcontentnum,paintcontent,paintdataA,paintdataC);
		 JPanel contentPane = new JPanel();
		 contentPane.setOpaque(false);
		 contentPane.setLayout(null);	 
		 jp.add(contentPane,Double.toString( Math.random()));

		

		for(int i = 0;i<num;i++){
		
		JLabel label = new JLabel(contrat[i]);
		label.setForeground(new Color(155, 106, 141));
		label.setFont(new Font("黑体", Font.BOLD, 20));
		label.setBounds(460, 212+i*45+heightadjust, 120, 30);
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
			locationforR = 100;
			rstring = "newpic/对比/"+fora+"099.png";
		}
		else if(locationforR>=10){
		 rstring = "newpic/对比/"+fora+"0"+locationforR+".png";
		}
		else if(locationforR<=0){
			locationforR = 0;
		rstring = "newpic/对比/"+fora+"000.png";
		}
		else if(locationforR<10){
		 rstring = "newpic/对比/"+fora+"00"+locationforR+".png";
		}
		
		if(locationforL>=100){
			locationforL = 100;
			lstring = "newpic/对比/"+forb+"099.png";
		}
		else if(locationforL>=10){
			lstring = "newpic/对比/"+forb+"0"+locationforL+".png";
		}
		else if(locationforL<=0){
			locationforL = 0;
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
