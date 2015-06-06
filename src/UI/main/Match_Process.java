package UI.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import UI.common.ComboBoxRenderer;
import UI.common.CreateTable_M;
import UI.common.TeamName_Map;
import VO.MatchInfoVO;

import javax.swing.DefaultComboBoxModel;


public class Match_Process extends JPanel {

	JButton ChooseByMonth;
	JButton ChooseByWeek;
	JComboBox teams;
	JComboBox pro_season;
	JComboBox pro_month;
	JComboBox pro_date;
	JComboBox pro_day;
	String[] pro_title={"日期","类型","主队","比分","客队","链接"};//这个日期是（XX日XX点）
	Object[][] pro_data;//"日期","类型","主队","比分","客队","视频/直播","文字直播","技术统计"
	CreateTable_M ctm;	
	ArrayList<MatchInfoVO> mivo;
	/**
	 * Create the panel.
	 */
	public Match_Process() {
		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		/**
		 * TODO 赛季
		 */
		pro_season = new JComboBox();
		pro_season.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		pro_season.setToolTipText("赛季");

		ArrayList<String> seasons = init.mbl.getAllSeason();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			pro_season.addItem(seasons.get(o));
		}
		pro_season.setEditable(true);
		pro_season.setBounds(45, 22, 89, 30);
		add(pro_season);
		pro_season.setVisible(true);
		pro_season.setSelectedItem(init.defaultseason+"赛季");
		
		pro_month=new JComboBox();
		pro_month.setModel(new DefaultComboBoxModel(new String[] {"所有月份","1月","2月",
				"3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"}));
		pro_month.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		pro_month.setToolTipText("月份");
		add(pro_month);
		pro_month.setEditable(true);
		pro_month.setBounds(170, 22, 89, 30);
		add(pro_month);
		pro_month.setSelectedItem("6月");
		pro_month.setVisible(true);
		pro_month.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar c = Calendar.getInstance();
				String[] a=pro_season.getSelectedItem().toString().substring(0, 5).split("-");
				String month=pro_month.getSelectedItem().toString().substring(0, pro_month.getSelectedItem().toString().length()-1);
				String year;
				if(Integer.valueOf(month)>=8){
					year="20"+a[1];
				}else{
					year="20"+a[0];
				}		
				c.set(Integer.valueOf(year),Integer.valueOf( month),1);
				c.add(Calendar.DAY_OF_YEAR, -1);
				int day=c.get(Calendar.DAY_OF_MONTH);
				pro_day.removeAllItems();
				pro_day.addItem("所有日期");
				for(int i=0;i<day;i++){
					
					pro_day.addItem(String.valueOf(i+1));
				}			
			}
			
		});
		pro_day=new JComboBox();
		pro_day.setModel(new DefaultComboBoxModel(new String[] {"所有日期"}));
		pro_day.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		pro_day.setToolTipText("日期");
		add(pro_day);
		pro_day.setEditable(true);
		pro_day.setBounds(296, 22, 89, 30);
		add(pro_day);
		pro_day.setVisible(true);
		
		
		/**
		 * 球队筛选的依据
		 */
		String teamsarray[]={"ATL","BKN","BOS","CHA","CHI",
				"CLE","DAL","DEN","DET","GSW",
				"HOU","IND","LAC","LAL","MEM",
				"MIA","MIL","MIN","NOP","NYK",
				"OKC","ORL","PHI","PHX","POR",
				"SAC","SAS","TOR","UTA","WAS"};
		
		Map<String, ImageIcon> content = new LinkedHashMap<String, ImageIcon>(); 
		TeamName_Map ma=new TeamName_Map();
		content.put("所有球队", null);
	    for(int i=0;i<teamsarray.length;i++){
	    	ImageIcon image=new ImageIcon("newpic/TEAMPNG/"+teamsarray[i]+".png");
	    	image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
	    	content.put(ma.getFullName(teamsarray[i]), image);
	    }
		teams= new JComboBox(content.keySet().toArray());	    
		ComboBoxRenderer renderer = new ComboBoxRenderer(content);	    
		teams.setRenderer(renderer);
	     
		teams.setBounds(450, 18, 164, 42);		
		add(teams);
		teams.setVisible(true);
		
		
		ChooseByMonth=new JButton();
		ChooseByMonth.setLocation(880, 21);
		ChooseByMonth.setText("按月查看");
		ChooseByMonth.setSize(80, 30);
		add(ChooseByMonth);
		
		ChooseByWeek=new JButton();
		ChooseByWeek.setLocation(959, 21);
		ChooseByWeek.setText("按周查看");
		ChooseByWeek.setSize(80, 30);
		add(ChooseByWeek);
		
		
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 10, 1040, 94);
		add(menubg);
		menubg.setOpaque(true);
	}
	
	
	public Object[][] getProdata(ArrayList<MatchInfoVO> da){
		if(da==null){
			Object[][] re=new Object[1][8];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5]="视频/直播";
			re[0][6]="文字直播";
			re[0][7]="技术统计";	
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][8];
			TeamName_Map mm=new TeamName_Map();
			//"日期","类型","主队","比分","客队","视频/直播","文字直播","技术统计"
			for(int i=0;i<da.size();i++){		
				re[i][0]=da.get(i).getDate().substring(da.get(i).getDate().length()-2,da.get(i).getDate().length())+"日 "+da.get(i).getTime()+da.get(i).getIsOver();
				re[i][1]=da.get(i).getMatchType();
				re[i][2]=mm.getFullName(da.get(i).getTeam_H());
				re[i][3]=da.get(i).getScore();
				re[i][4]=mm.getFullName(da.get(i).getTeam_G());
				re[i][5]="视频/直播";
				re[i][6]="文字直播";
				re[i][7]="技术统计";				
			}		
			return re;
		
		}
		
	}
}
