package UI.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Icon;

public class temp_contrast extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp_contrast frame = new temp_contrast();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public temp_contrast() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060,650 );
		
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1042, 610);
		setContentPane(contentPane);
		
		//头像
		 ImageIcon playerfirst = new ImageIcon("newpic/fortest/Aaron Brooks.png");
		 playerfirst.setImage(playerfirst.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
			contentPane.setLayout(null);
			JLabel photoplayer1 = new JLabel(playerfirst);
			photoplayer1.setBounds(255, 83, 230, 185);
			photoplayer1.setOpaque(false);
			contentPane.add(photoplayer1);
			
			JLabel teamfirst = new JLabel("Avaliers");
			teamfirst.setHorizontalAlignment(SwingConstants.RIGHT);
			teamfirst.setForeground(new Color(155, 106, 141));
			teamfirst.setFont(new Font("黑体", Font.BOLD, 18));
			teamfirst.setBounds(130, 111, 106, 24);
			contentPane.add(teamfirst);
			
			JLabel infofirst = new JLabel("11\u53F7/\u4E2D\u536B");
			infofirst.setHorizontalAlignment(SwingConstants.RIGHT);
			infofirst.setForeground(new Color(155, 106, 141));
			infofirst.setFont(new Font("黑体", Font.BOLD, 18));
			infofirst.setBounds(130, 90, 106, 24);
			contentPane.add(infofirst);
			
			JLabel namefirst = new JLabel("Aaron Brooks");
			namefirst.setHorizontalAlignment(SwingConstants.RIGHT);
			namefirst.setForeground(new Color(155, 106, 141));
			namefirst.setFont(new Font("Verdana", Font.PLAIN, 30));
			namefirst.setBounds(25, 55, 211, 36);
			contentPane.add(namefirst);
			
			JTextField findplayerfist = new JTextField();
			findplayerfist.setBackground(new Color(219, 241, 241));
			findplayerfist.setBounds(42, 237, 184, 24);
			contentPane.add(findplayerfist);
			
			JButton firstfind = new JButton("");
			firstfind.setToolTipText("\u67E5\u627E\u5BF9\u5E94\u7684\u7403\u5458");
			firstfind.setBounds(228, 237, 25, 25);
			firstfind.setContentAreaFilled(false); 
			contentPane.add(firstfind);
			
			 ImageIcon playersecond = new ImageIcon("newpic/fortest/Aaron Brooks.png");
			 playersecond.setImage(playersecond.getImage().getScaledInstance(215, 180,Image.SCALE_DEFAULT));
			JLabel photoplayer2 = new JLabel((Icon) playersecond);
			photoplayer2.setOpaque(false);
			photoplayer2.setBounds(552, 83, 230, 185);
			contentPane.add(photoplayer2);
			
			JLabel teamsecond = new JLabel("Avaliers");
			teamsecond.setHorizontalAlignment(SwingConstants.LEFT);
			teamsecond.setForeground(new Color(155, 106, 141));
			teamsecond.setFont(new Font("黑体", Font.BOLD, 18));
			teamsecond.setBounds(804, 111, 106, 24);
			contentPane.add(teamsecond);
			
			JLabel infosecond = new JLabel("11\u53F7/\u4E2D\u536B");
			infosecond.setHorizontalAlignment(SwingConstants.LEFT);
			infosecond.setForeground(new Color(155, 106, 141));
			infosecond.setFont(new Font("黑体", Font.BOLD, 18));
			infosecond.setBounds(804, 90, 106, 24);
			contentPane.add(infosecond);
			
			JLabel namesecond = new JLabel("Aaron Brooks");
			namesecond.setHorizontalAlignment(SwingConstants.LEFT);
			namesecond.setForeground(new Color(155, 106, 141));
			namesecond.setFont(new Font("Verdana", Font.PLAIN, 30));
			namesecond.setBounds(804, 55, 211, 36);
			contentPane.add(namesecond);
			
			textField = new JTextField();
			textField.setBackground(new Color(219, 241, 241));
			textField.setBounds(797, 237, 184, 24);
			contentPane.add(textField);
			
		
			JButton findsecond = new JButton("");
			findsecond.setToolTipText("\u67E5\u627E\u5BF9\u5E94\u7684\u7403\u5458");
			findsecond.setContentAreaFilled(false);
			findsecond.setBounds(985, 237, 25, 25);
			contentPane.add(findsecond);
			
			JLabel changjundefen = new JLabel("\u573A\u5747\u5F97\u5206");
			changjundefen.setForeground(new Color(155, 106, 141));
			changjundefen.setFont(new Font("黑体", Font.BOLD, 20));
			changjundefen.setBounds(479, 288, 91, 30);
			contentPane.add(changjundefen);
			
			String rfstring1 = "newpic/对比/低039.png";
			int locationfortextr1 = 39;
			
			JLabel righttext1 = new JLabel("39.5");
			righttext1.setFont(new Font("宋体", Font.BOLD, 20));
			righttext1.setForeground(new Color(155, 106, 141));
			righttext1.setBounds(580+locationfortextr1*3+10, 290, 68, 24);
			contentPane.add(righttext1);
			
			ImageIcon rightfirstim = new ImageIcon(rfstring1);
			//leftfirstim.setImage(leftfirstim.getImage().getScaledInstance(1042, 610,Image.SCALE_DEFAULT));
			JLabel rightlable1 = new JLabel(rightfirstim);
			rightlable1.setBounds(580, 285,rightfirstim.getIconWidth() , rightfirstim.getIconHeight());
			rightlable1.setOpaque(false);
			contentPane.add(rightlable1);
			
			
			String lfstring1 = "newpic/对比/高072.png";
			int locationfortextl1 = 72;
			
			JLabel lefttext1 = new JLabel("72.3");
			lefttext1.setFont(new Font("宋体", Font.BOLD, 20));
			lefttext1.setForeground(new Color(155, 106, 141));
			lefttext1.setBounds(412-locationfortextl1*3-10, 290, 68, 24);
			contentPane.add(lefttext1);
			
			//翻转图像
			BufferedImage sourceImage = null;
			BufferedImage dstImage = null;  
		     try {
		    	 File file = new File(lfstring1);
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
			leftlable1.setBounds(162, 285, sourceImage.getWidth(),  sourceImage.getHeight());
			contentPane.add(leftlable1);

			
		//背景
		ImageIcon image = new ImageIcon("newpic/对比界面实用.jpg");
			image.setImage(image.getImage().getScaledInstance(1042, 610,Image.SCALE_DEFAULT));
			contentPane.setLayout(null);
			JLabel photo = new JLabel(image);
			photo.setBounds(0, 0, 1042, 610);
			photo.setOpaque(false);
			contentPane.add(photo);
			

		
			
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
