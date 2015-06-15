package UI.Team;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import UI.common.CreateTable_pic;
import UI.common.OftenUseMethod;
import UI.main.init;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;

import javax.swing.JLabel;
import java.awt.Color;

public class TeamB extends JPanel {

	JButton info,data;
	CreateTable_pic tp_list;
	String tp_title[]={"姓名","肖像","球号", "位置", "身高","体重", "出生日期", "年龄", "球龄", "毕业院校"};
	String[] tp_datatitle = {"姓名", "场数","先发", "分钟","得分","篮板", "助攻",  "投篮%", "三分%",
		"罚球%", "进攻", "防守", "抢断", "盖帽", "失误","犯规"};
	
	Object[][] tp_data;
	ArrayList<PlayerInfoVO> pivo=null;
	String na;
	
	static JPanel p1;
	JToolBar toolBar;
	JButton changjundefen=new JButton(new ImageIcon("newpic/hotbut/场均得分.jpg"));
	JButton changjunlanban=new JButton(new ImageIcon("newpic/hotbut/场均篮板.jpg"));
	JButton changjunzhugong=new JButton(new ImageIcon("newpic/hotbut/场均助攻.jpg"));
	JButton changjungaimao=new JButton(new ImageIcon("newpic/hotbut/场均盖帽.jpg"));
	JButton changjunqiangduan=new JButton(new ImageIcon("newpic/hotbut/场均抢断.jpg"));
	JButton sanfenmingzhonglv=new JButton(new ImageIcon("newpic/hotbut/三分命中率.jpg"));
	JButton toulanmingzhonglv=new JButton(new ImageIcon("newpic/hotbut/投篮命中率.jpg"));
	JButton faqiumingzhonglv=new JButton(new ImageIcon("newpic/hotbut/罚球命中率.jpg"));
	
	/**
	 * Create the panel.
	 */
	public TeamB(String name) {
		this.na=name;
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 29, 1040, 25);
		toolBar.setOpaque(false);
		toolBar.add(changjundefen);
		toolBar.add(changjunlanban);
		toolBar.add(changjunzhugong);
		toolBar.add(changjungaimao);
		toolBar.add(changjunqiangduan);			
		toolBar.add(sanfenmingzhonglv);
		toolBar.add(toulanmingzhonglv);
		toolBar.add(faqiumingzhonglv);
		add(toolBar);
		HotPlayers_Team hp = new HotPlayers_Team(na,"得分");
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 55, 1040,227);
		p1.setOpaque(false);
		p1.add(hp);
		add(p1);
		
		
		//赛季
		changjundefen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"得分");
				changep1(hp);
			}
		});
		changjunlanban.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"篮板");
				changep1(hp);
			}
		});
		changjunzhugong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"助攻");
				changep1(hp);
			}
		});
		changjungaimao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"盖帽");
				changep1(hp);
			}
		});
		changjunqiangduan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"抢断");
				changep1(hp);
			}
		});
		sanfenmingzhonglv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"三分命中率");
				changep1(hp);
			}
		});
		toulanmingzhonglv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"投篮命中率");
				changep1(hp);
			}
		});
		faqiumingzhonglv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers_Team hp = new HotPlayers_Team(na,"罚球命中率");
				changep1(hp);
			}
		});
		
		
		/*
		info=new JButton(new ImageIcon("newpic/信息浮.png"));
		info.setLocation(915, 283);
		info.setSize(55, 30);
		add(info);
		info.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				info.setIcon(new ImageIcon("newpic/信息浮.png"));
				data.setIcon(new ImageIcon("newpic/新数据.png"));
				pivo = init.pbl.getTeamAllPlayer(init.defaultseason, na);
				tp_data=getinfodata(pivo);
				tp_list.updateTable(tp_title, tp_data);
				setinfolist();
			}			
		});
		data=new JButton(new ImageIcon("newpic/新数据.png"));
		data.setLocation(970, 283);
		data.setSize(55, 30);
		add(data);
		data.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				info.setIcon(new ImageIcon("newpic/信息.png"));
				data.setIcon(new ImageIcon("newpic/新数据浮.png"));
				pivo = init.pbl.getTeamAllPlayer(init.defaultseason, na);
				tp_data=getinfodata(pivo);
				tp_list.updateTable(tp_title, tp_data);
				setinfolist();
			}			
		});
		*/
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u8D5B\u5B63\u9635\u5BB9\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 288, 139, 32);
		add(lblNewLabel);
		lblNewLabel.setForeground(init.syspurple);
		
		System.out.println(name);
		pivo = init.pbl.getTeamAllPlayer(init.defaultseason, name);
		tp_data=getinfodata(pivo);
		tp_list = new CreateTable_pic(tp_title, tp_data, 10, 315,1015, 250, 35,
				new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(tp_list);
		setinfolist();
		JLabel label = new JLabel("\u8D5B\u5B63\u6570\u636E\u738B\uFF1A");
		label.setForeground(new Color(155, 106, 141));
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label.setBounds(10, 0, 139, 32);
		add(label);
		

		
		//tp_list.FitTableColumns(tp_list.getTable());
	}
	
	
	public void setinfolist(){
		tp_list.setNthWidth(0, 145);
		tp_list.setNthWidth(2, 90);		
		tp_list.setNthWidth(3, 90);
		tp_list.setNthWidth(4, 90);
		tp_list.setNthWidth(5, 90);
		tp_list.setNthWidth(6, 150);
		tp_list.setNthWidth(7, 90);		
		tp_list.setNthWidth(8, 90);
		tp_list.setNthWidth(9, 150);
	}
	public static Object[][] getinfodata(ArrayList<PlayerInfoVO> da) {
		if (da == null) {
			Object[][] re = new Object[1][10];
			re[0][0] = "Aaron Brooks";
			ImageIcon image = new ImageIcon("newpic/portrait/"+"Aaron Brooks"+".png");
			image.setImage(image.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT));
			re[0][1] = image;
			re[0][2] = "10";
			re[0][3] = "前锋";
			re[0][4] = "2米1";
			re[0][5] = "2XX";
			re[0][6] = "1986-01-23";
			re[0][7] = "32";
			re[0][8] = "5";
			re[0][9] = "AINAKDDA";
			return re;
		} else {
			Object[][] re = new Object[da.size()][10];
			
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getName();
				ImageIcon image = new ImageIcon("newpic/portrait/"+da.get(i).getEname()+".png");
				image.setImage(image.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT));
				re[i][1] = image;			
				re[i][2] = da.get(i).getNumber();
				re[i][3] = da.get(i).getPosition();
				re[i][4] = da.get(i).getHeight();
				re[i][5] = da.get(i).getWeight();
				re[i][6] = da.get(i).getBirth();
				re[i][7] = da.get(i).getAge();
				re[i][8] = da.get(i).getExp();
				re[i][9] = da.get(i).getSchool();
			}
			return re;

		}
	}
	
	
	public static Object[][] getAveragedata(ArrayList<PlayerSeasonDataVO> da) {
		//System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][16];
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
			re[0][15] = "";
			return re;
		} else {
			Object[][] re = new Object[da.size()][16];
			for (int i = 0; i <da.size(); i++) {
				re[i][0] = da.get(i).getName();
				re[i][1] = da.get(i).getMatchNum();
				re[i][2] = da.get(i).getStartingNum();
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getTime_avg());
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getPointNum_avg());
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());
				re[i][6] = OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][7] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getShootPercentage()));				
				re[i][8] = OftenUseMethod.changeper(OftenUseMethod.changedouble(da.get(i).getT_shootPercentage()));
				re[i][9] =OftenUseMethod.changeper( OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage()));
				re[i][10] = OftenUseMethod.changedouble(da.get(i).getO_ReboundNum_avg());
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getD_ReboundNum_avg());
				re[i][12] = OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][13] = OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][14] = OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][15] = OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());			
			}
			return re;

		}

		
		
	}
	
	static void changep1(HotPlayers_Team newhp){
		p1.removeAll();
		p1.add(newhp);
		newhp.setLocation(0, 0);
		p1.validate();
		p1.repaint();
	}
}
