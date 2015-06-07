package UI.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.common.ComboBoxRenderer;
import UI.common.CreateTable_M;
import UI.common.DateChooser;
import UI.common.TeamName_Map;
import VO.MatchInfoVO;

import javax.swing.DefaultComboBoxModel;


public class Match_Process extends JPanel {

	String Mon_Week="Month";
	JButton ChooseByMonth;
	JButton ChooseByWeek;
	
	DateChooser dc;
	JLabel dateshow;
	JButton lastsevendays;
	JButton nextsevendays;
	JComboBox teams;
	JComboBox pro_season, pro_season1;
	JComboBox pro_month;
	JComboBox pro_day;
	JButton sort1,sort2;
	String[] pro_title={"日期","类型","主队","比分","客队","链接","",""};//这个日期是（XX日XX点）
	Object[][] pro_data=null;//"日期","类型","主队","比分","客队","视频/直播","文字直播","技术统计"
	CreateTable_M ctm;	
	ArrayList<MatchInfoVO> mivo;
	int[] havingMatchMonths={10,11,12,1,2,3,4,5,6};
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public Match_Process() throws ParseException {
		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		Date da=new Date();		
		dc=new DateChooser(180,35,da);
		dc.setSize(120, 34);
		dc.setLocation(71, 61);
		add(dc);
		dc.setVisible(false);
		dc.showDate.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					dateshow.setText(dc.showDate.getText()+"至"+getSevenDaysLater(dc.showDate.getText(),6));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub			
			}		
		});
		
		dateshow=new JLabel();
		dateshow.setText(dc.showDate.getText()+"至"+getSevenDaysLater(dc.showDate.getText(),6));
		dateshow.setLocation(366, 61);
		dateshow.setFont(new Font("华文细黑", Font.BOLD, 17));
		dateshow.setForeground(init.syspurpleblue);
		dateshow.setSize(227, 30);
		add(dateshow);
		dateshow.setVisible(false);
		lastsevendays=new JButton();
		lastsevendays.setText("\u524D\u4E03\u5929");
		lastsevendays.setLocation(232, 61);
		lastsevendays.setSize(100, 30);
		add(lastsevendays);
		lastsevendays.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String temp[]=dateshow.getText().split("至");
				try {
					dateshow.setText(getSevenDaysBefore(temp[0],7)+"至"+getSevenDaysBefore(temp[1],7));
				    changetable_Week(getSevenDaysBefore(temp[0],7));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		lastsevendays.setVisible(false);
		nextsevendays=new JButton();
		nextsevendays.setLocation(628, 61);
		nextsevendays.setText("\u540E\u4E03\u5929");
		nextsevendays.setSize(100, 30);
		add(nextsevendays);
		nextsevendays.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String temp[]=dateshow.getText().split("至");
				try {
					dateshow.setText(getSevenDaysLater(temp[0],7)+"至"+getSevenDaysLater(temp[1],7));
					changetable_Week(getSevenDaysLater(temp[0],7));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		nextsevendays.setVisible(false);
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
		pro_season.setBounds(38, 65, 89, 30);
		add(pro_season);
		pro_season.setVisible(true);
		pro_season.setSelectedItem(init.defaultseason+"赛季");
		
		pro_month=new JComboBox();
		pro_month.setModel(new DefaultComboBoxModel(new String[] {"1月","2月",
				"3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"}));
		pro_month.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		pro_month.setToolTipText("月份");
		add(pro_month);
		pro_month.setEditable(true);
		pro_month.setBounds(175, 65, 89, 30);
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
				if(Integer.parseInt(month)>=8){
					year="20"+a[1];
				}else{
					year="20"+a[0];
				}		
				c.set(Integer.parseInt(year),Integer.parseInt( month),1);
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
		pro_day.setBounds(319, 65, 89, 30);
		add(pro_day);
		pro_day.setVisible(true);
		
		
		
		/**
		 * TODO 赛季
		 */
		pro_season1 = new JComboBox();
		pro_season1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		pro_season1.setToolTipText("赛季");

		
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			pro_season1.addItem(seasons.get(o));
		}
		pro_season1.setEditable(true);
		pro_season1.setBounds(613, 65, 89, 30);
		add(pro_season1);
		pro_season1.setVisible(true);
		pro_season1.setSelectedItem(init.defaultseason+"赛季");
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
	    for(int i=0;i<teamsarray.length;i++){
	    	ImageIcon image=new ImageIcon("newpic/TEAMPNG/"+teamsarray[i]+".png");
	    	image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
	    	content.put(ma.getFullName(teamsarray[i]), image);
	    }
		teams= new JComboBox(content.keySet().toArray());	    
		ComboBoxRenderer renderer = new ComboBoxRenderer(content);	    
		teams.setRenderer(renderer);
	     
		teams.setBounds(738, 61, 164, 42);		
		add(teams);
		teams.setVisible(true);
		
		
		final ImageIcon image7 = new ImageIcon("newpic/筛选-筛选.png");
		image7.setImage(image7.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		final ImageIcon image8 = new ImageIcon("newpic/筛选-筛选浮.png");
		image8.setImage(image8.getImage().getScaledInstance(75, 27,Image.SCALE_DEFAULT));
		

		
		sort1 = new JButton(image7);
		sort1.setToolTipText("");
		sort1.setBounds(474, 68, 75, 27);
		add(sort1);
		sort1.setContentAreaFilled(false);
		sort1.setVisible(true);
		sort1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				sort1.setIcon(image7);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort1.setIcon(image8);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String se=pro_season.getSelectedItem().toString();
                int m=Integer.parseInt(pro_month.getSelectedItem().toString().substring(0, pro_month.getSelectedItem().toString().length()-1));			
				String temp[];
				if(pro_day.getSelectedItem().toString().equals("所有日期")){
					temp=init.mbl.getDatesOfPro_ByMonth(se,m);
				}else{
					temp=new String[1];
					temp[0]=getYear(se, m)+"-"+change(m)+"-"+change(Integer.parseInt(pro_day.getSelectedItem().toString()));
				}	
				try {
			    mivo=init.mbl.getPro_ByMonth(se, m);
			    
					mivo=changeProdata_ChooseAllTeam_ByDate(mivo,temp);
				
			    pro_data=getProdata_HavingDays(mivo);
			    ctm.updateTable(pro_title, pro_data);
			    } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		sort2 = new JButton(image7);
		sort2.setToolTipText("");
		sort2.setBounds(958, 71, 75, 27);
		add(sort2);
		sort2.setContentAreaFilled(false);
		sort2.setVisible(true);
		sort2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				sort2.setIcon(image7);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort2.setIcon(image8);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
                String tabb=teams.getSelectedItem().toString();	
					
			    mivo=changeProdata_ForATeam(havingMatchMonths, tabb);
			    pro_data=getProdata_HavingMonths(mivo);
			    ctm.updateTable(pro_title, pro_data);
			}

		});
		ChooseByMonth=new JButton();
		ChooseByMonth.setLocation(880, 21);
		ChooseByMonth.setText("按月查看");
		ChooseByMonth.setSize(80, 30);
		add(ChooseByMonth);
		ChooseByMonth.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Mon_Week="Month";
				pro_season.setVisible(true);
				pro_season1.setVisible(true);
				pro_month.setVisible(true);				
				pro_day.setVisible(true);
				teams.setVisible(true);
				sort1.setVisible(true);
				sort2.setVisible(true);
				dc.setVisible(false);
				dateshow.setVisible(false);
				lastsevendays.setVisible(false);
				nextsevendays.setVisible(false);
				
			}
			
		});
		
		ChooseByWeek=new JButton();
		ChooseByWeek.setLocation(959, 21);
		ChooseByWeek.setText("按周查看");
		ChooseByWeek.setSize(80, 30);
		add(ChooseByWeek);
		ChooseByWeek.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Mon_Week="Week";
				pro_season.setVisible(false);
				pro_season1.setVisible(false);
				pro_month.setVisible(false);				
				pro_day.setVisible(false);
				teams.setVisible(false);
				sort1.setVisible(false);
				sort2.setVisible(false);
				dc.setVisible(true);
				dateshow.setVisible(true);
				lastsevendays.setVisible(true);
				nextsevendays.setVisible(true);
				
			}
			
		});
		
		//mivo=init.mbl.getPro_NotOver(init.defaultseason, 6);
		//String[] tempdates=init.mbl.getDatesOfPro_ByMonth(init.defaultseason, 6);
		//pro_data=getProdata_HavingDays(changeProdata_ChooseAllTeam_ByDate(mivo,tempdates));
		ctm=new CreateTable_M(pro_title, pro_data,10, 123,1040, 480, 25,new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		add(ctm);
		
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 10, 1040, 105);
		add(menubg);
		menubg.setOpaque(true);
	}
	
	//对加入了日期的da进行修改
	public Object[][] getProdata_HavingDays(ArrayList<MatchInfoVO> da){
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
				if(da.get(i).getIsOver().equals("")){
					re[i][0] =da.get(i).getDate();
					re[i][1] = "";
					re[i][2] = "";
					re[i][3] = "";
					re[i][4] = "";
					re[i][5]="";
					re[i][6]="";
					re[i][7]="";	
				}else{
					re[i][0]=da.get(i).getTime()+da.get(i).getIsOver();
					re[i][1]=da.get(i).getMatchType();
					re[i][2]=mm.getFullName(da.get(i).getTeam_H());
					re[i][3]=da.get(i).getScore();
					re[i][4]=mm.getFullName(da.get(i).getTeam_G());
					re[i][5]="视频/直播";
					re[i][6]="文字直播";
					re[i][7]="技术统计";		
				}
			}		
			return re;
		
		}
		
	}
	
	//将每个日期作为一个matchInfoVO加入
	public ArrayList<MatchInfoVO> changeProdata_ChooseAllTeam_ByDate(ArrayList<MatchInfoVO> da,String[] dates) throws ParseException{
		ArrayList<MatchInfoVO> re = new ArrayList<MatchInfoVO>();
		MatchInfoVO daymivo=new MatchInfoVO("", "", "", "", "", "", "", null);
		ArrayList<MatchInfoVO> temp = new ArrayList<MatchInfoVO>();
		for(int i=0;i<dates.length;i++){
			daymivo.setDate(dates[i]+" "+getWeekOfDate(dates[i]));
			String[] ddd=dates[i].split("-");
			re.add(daymivo);
			temp=init.mbl.getPro_ByDay(pro_season.getSelectedItem().toString(), Integer.parseInt(ddd[1]), Integer.parseInt(ddd[2]));
		    for(int m=0;m<temp.size();m++){
		    	re.add(temp.get(m));
		    }		
		}
		return re;		
	}
	
	//对加入月份的da进行修改
		public Object[][] getProdata_HavingMonths(ArrayList<MatchInfoVO> da){
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
					if(da.get(i).getIsOver().equals("")){
						re[i][0] =da.get(i).getDate();
						re[i][1] = "";
						re[i][2] = "";
						re[i][3] = "";
						re[i][4] = "";
						re[i][5]="";
						re[i][6]="";
						re[i][7]="";	
					}else{
						re[i][0]=da.get(i).getDate().substring(da.get(i).getDate().length()-2, da.get(i).getDate().length())+"日"+da.get(i).getTime()+da.get(i).getIsOver();
						re[i][1]=da.get(i).getMatchType();
						re[i][2]=mm.getFullName(da.get(i).getTeam_H());
						re[i][3]=da.get(i).getScore();
						re[i][4]=mm.getFullName(da.get(i).getTeam_G());
						re[i][5]="视频/直播";
						re[i][6]="文字直播";
						re[i][7]="技术统计";		
					}
				}		
				return re;			
			}			
		}
		
		
		//将每个月作为一个matchInfoVO加入
		public ArrayList<MatchInfoVO> changeProdata_ForATeam(int[] havingMatchMonths,String teamabb){
			ArrayList<MatchInfoVO> re = new ArrayList<MatchInfoVO>();
			MatchInfoVO daymivo=new MatchInfoVO("", "", "", "", "", "", "", null);
			ArrayList<MatchInfoVO> temp = new ArrayList<MatchInfoVO>();
			for(int i=0;i<havingMatchMonths.length;i++){
				daymivo.setDate(String.valueOf(havingMatchMonths[i])+"月的比赛");
				re.add(daymivo);
				temp=init.mbl.getPro_ForTeam(pro_season1.getSelectedItem().toString(), havingMatchMonths[i], teamabb);
			    for(int m=0;m<temp.size();m++){
			    	re.add(temp.get(m));
			    }		
			}
			return re;		
		}
		
		public String getYear(String season,int month){
			String[] y=season.split("-");
			if(month==1||month==2||month==3||month==4||month==5||month==6||month==7||month==8){
				return "20"+y[1];
			}else{
				return "20"+y[0];
			}
		}
		public String getSeason(int year,int month){
			
			if(month==1||month==2||month==3||month==4||month==5||month==6||month==7||month==8){
				return String.valueOf(year-1).substring(2, 4)+"-"+String.valueOf(year).substring(2, 4);
			}else{
				return String.valueOf(year).substring(2, 4)+"-"+String.valueOf(year+1).substring(2, 4);
			}
		}
		public String change(int a){
			DecimalFormat df = new DecimalFormat("00");    
			String temp=String.valueOf(df.format(a));
			return temp;
		}
		public void changetable_Week(String date1) throws ParseException{
			ArrayList<MatchInfoVO> re=new ArrayList<MatchInfoVO>();
			ArrayList<MatchInfoVO> temp=new ArrayList<MatchInfoVO>();	
			MatchInfoVO daymivo=new MatchInfoVO("", "", "", "", "", "", "", null);
			for(int i=0;i<7;i++){	
				
				String date=getSevenDaysLater(date1, i);
				daymivo.setDate(date+" "+getWeekOfDate(date));
				String s_s_s[]=date.split("-");
				int year=Integer.parseInt(s_s_s[0]);
				int mon=Integer.parseInt(s_s_s[1]);
				int day=Integer.parseInt(s_s_s[2]);
				temp=init.mbl.getPro_ByDay(getSeason(year,mon), mon, day);
				for(int m=0;m<temp.size();m++){
					re.add(temp.get(m));
				}
			}
			mivo=re;
			pro_data=getProdata_HavingDays(re);
			ctm.updateTable(pro_title, pro_data);
		}
		
		String getSevenDaysLater(String da,int ds) throws ParseException{
			String pattern = "yyyy-MM-dd";
			  SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			 Date date = sdf.parse(da);
			  Calendar c = Calendar.getInstance();
			  c.setTime(date);
			  Date today = c.getTime();
			  for(int i=0;i<ds;i++){	
				  c.add(Calendar.DAY_OF_YEAR, +1);			 
			  }
			  String today_plus =sdf.format( c.getTime());
			  
			  return  today_plus;
		}
		String getSevenDaysBefore(String da,int ds) throws ParseException{
			 String pattern = "yyyy-MM-dd";
			  SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			 Date date = sdf.parse(da);
			  Calendar c = Calendar.getInstance();
			  c.setTime(date);
			  Date today = c.getTime();
			  for(int i=0;i<ds;i++){	
				  c.add(Calendar.DAY_OF_YEAR, -1);			 
			  }
			  String today_plus =sdf.format( c.getTime());
			  
			  return  today_plus;
		}
		/** * 获取指定日期是星期几
		  * 参数为null时表示获取当前日期是星期几
		  * @param date
		  * @return
		 * @throws ParseException 
		*/
		public static String getWeekOfDate(String da) throws ParseException {      
		    String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        
		    Calendar calendar = Calendar.getInstance();
		    String pattern = "yyyy-MM-dd";
			 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			 Date date = sdf.parse(da);
		    if(date != null){        
		         calendar.setTime(date);      
		    }        
		    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
		    if (w < 0){        
		        w = 0;      
		    }      
		    return weekOfDays[w];    
		}
}
