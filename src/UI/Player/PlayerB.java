package UI.Player;

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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businessService.blservice.PlayerBLService;
import UI.common.OftenUseMethod;
import UI.main.init;
import VO.PlayerSeasonDataVO;
import VO.PlayerVO;

public class PlayerB extends JPanel {

	String na;
	JPanel contentPane;
	PlayerSeasonDataVO playera;
	PlayerSeasonDataVO playerb;	
	String[] paintcontent = {"首发场数","得分","助攻","篮板","三分","罚球","投篮"};
	int paintcontentnum = 7;
	double[] paintdataA = {24,0,24,52,26,57.56,100};
	double[] paintdataB = {74,12,86,1,59.3,23.1,99.6};
	 final CardLayout cardLayout = new CardLayout();
	 JPanel jp = new JPanel();
	private JTextField textField;
	String season = "14-15";
	/**
	 * Create the panel.
	 */
	public PlayerB(String name) {
		System.out.println(name);
		playera = init.pbl.keyfind(name).get(0);
		paintdataA[0] = OftenUseMethod.changedouble(playera.getStartingNum());
		paintdataA[1] = OftenUseMethod.changedouble(playera.getPointNum_avg());
		paintdataA[2] = OftenUseMethod.changedouble(playera.getAssistNum_avg());
		paintdataA[3] = OftenUseMethod.changedouble(playera.getReboundNum_avg());
		paintdataA[4] = OftenUseMethod.changedouble(playera.getT_shootNum_avg());
		paintdataA[5] = OftenUseMethod.changedouble(playera.getFreeThrowNum_avg());
		paintdataA[6] = OftenUseMethod.changedouble(playera.getShootNum_avg());
		
		playerb = init.pbl.get_Avg_PlayerSeasonData(season,"常规赛");
		paintdataB[0] = OftenUseMethod.changedouble(playerb.getStartingNum());
		paintdataB[1] = OftenUseMethod.changedouble(playerb.getPointNum_avg());
		paintdataB[2] = OftenUseMethod.changedouble(playerb.getAssistNum_avg());
		paintdataB[3] = OftenUseMethod.changedouble(playerb.getReboundNum_avg());
		paintdataB[4] = OftenUseMethod.changedouble(playerb.getT_shootNum_avg());
		paintdataB[5] = OftenUseMethod.changedouble(playerb.getFreeThrowNum_avg());
		paintdataB[6] = OftenUseMethod.changedouble(playerb.getShootNum_avg());
		
		 jp.setBounds(0, 0, 1042, 580);
		 jp.setOpaque(false);
		 jp.setLayout(cardLayout);
		 this.add(jp);

		this.na=name;
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1042, 580);
		add(contentPane);
		
		//test暂用
		//playera = pbs.keyfind("Brooks").get(0);
		//playera = 联盟水平
		
		//获取信息
		String nameA = name;
		String portraitA = "newpic/portrait/"+init.pbl.getAPlayerInfo(name).getEname()+".png";
		String teamA = playera.getTeamName();
		String infoA = playera.getInfo().getNumber()+"|"+playera.getInfo().getPosition();
		
		 String nameB = "联盟平均水平";
		 String portraitB = "newpic/NBA.png";
		 String teamB = "";
		 String infoB = "";

		//头像
		 ImageIcon playerfirst = new ImageIcon(portraitA);
		 playerfirst.setImage(playerfirst.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
			contentPane.setLayout(null);
			JLabel photoplayer1 = new JLabel(playerfirst);
			photoplayer1.setBounds(255, 10, 230, 185);
			photoplayer1.setOpaque(false);
			contentPane.add(photoplayer1);
			
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
			namefirst.setFont(new Font("黑体", Font.PLAIN, 30));
			namefirst.setBounds(25, 9, 211, 36);
			contentPane.add(namefirst);
			
			 ImageIcon playersecond = new ImageIcon(portraitB);
			 playersecond.setImage(playersecond.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
			final JLabel photoplayer2 = new JLabel((Icon) playersecond);
			photoplayer2.setOpaque(false);
			photoplayer2.setBounds(552, 10, 230, 185);
			contentPane.add(photoplayer2);
			
			final JLabel teamsecond = new JLabel(teamB);
			teamsecond.setHorizontalAlignment(SwingConstants.LEFT);
			teamsecond.setForeground(new Color(155, 106, 141));
			teamsecond.setFont(new Font("黑体", Font.BOLD, 18));
			teamsecond.setBounds(804, 65, 106, 24);
			contentPane.add(teamsecond);
			
			final JLabel infosecond = new JLabel(infoB);
			infosecond.setHorizontalAlignment(SwingConstants.LEFT);
			infosecond.setForeground(new Color(155, 106, 141));
			infosecond.setFont(new Font("黑体", Font.BOLD, 18));
			infosecond.setBounds(804, 44, 106, 24);
			contentPane.add(infosecond);
			
			final JLabel namesecond = new JLabel(nameB);
			namesecond.setHorizontalAlignment(SwingConstants.LEFT);
			namesecond.setForeground(new Color(155, 106, 141));
			namesecond.setFont(new Font("黑体", Font.PLAIN, 30));
			namesecond.setBounds(804, 9, 211, 36);
			contentPane.add(namesecond);
			
			textField = new JTextField();
			textField.setBackground(new Color(219, 241, 241));
			textField.setBounds(797, 162, 184, 24);
			contentPane.add(textField);
			
		
			JButton findsecond = new JButton("");
			findsecond.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String secondname = textField.getText();
					ArrayList<PlayerSeasonDataVO> tempplayer =  init.pbl.keyfind(secondname);
					if(tempplayer.isEmpty()){
						textField.setText("未查到对应球员");
					}
					else{
						if(tempplayer.size()>1){
							textField.setText("未能精确查到到对应球员");
						}
						playerb = tempplayer.get(0);
						String nameB = playerb.getName();
						String portraitB = "newpic/portrait/"+init.pbl.getAPlayerInfo(nameB).getEname()+".png";
						 String  teamB = playerb.getTeamName();
						 String	infoB = playerb.getInfo().getNumber()+"|"+playerb.getInfo().getPosition();
					
						 ImageIcon playersecond = new ImageIcon(portraitB);
						 playersecond.setImage(playersecond.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
						 photoplayer2.setIcon(playersecond);
						 teamsecond.setText(teamB);
						 infosecond.setText(infoB);
						 namesecond.setText(nameB);
					}
				}
			});
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
					ContrastPlayer cp = new ContrastPlayer(playera,playerb);//默认是联盟平均水平
					cp.setModal(true);
					cp.setLocation(init.SysStart_X+280, init.SysStart_Y+302);
					cp.setVisible(true);
					if(cp.change == true){
						System.out.println("sadf");
						System.out.println(cp.outputcontent[0]);
						paintunder(cp.now,cp.outputcontent,cp.dataoutput[0],cp.dataoutput[1]);
						cardLayout.next(jp);
					}

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

	
	//重绘下方对比区域
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
