package UI.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UI.common.ComboBoxRenderer;
import UI.common.CreateTable;
import UI.common.CreateTable_M;
import UI.common.DateChooser;
import UI.common.TeamName_Map;
import VO.MatchVO;

public class Match_Data extends JPanel {
	static JComboBox teams;
	static JButton find;
	static JButton datefind;
	static DateChooser dc;
	static CreateTable_M matchdatalist;
	static Object[][] matchdata;
	static ArrayList<MatchVO> mdvo;
	static  String matchtype;
	JButton normal,after;
	static JComboBox matchseason;
	static String[] matchtitle={"序号","日期","赛季","主队","比分",
		"客队","第一节比分","第二节比分","第三节比分","第四节比分","加时赛比分"};
	static NoMatches nm;
	
	
	/**
	 * Create the panel.
	 */
	public Match_Data() {
		setLayout(null);
		setSize(1060, 600);
		setOpaque(false);
		
		Date da=new Date();		
		dc=new DateChooser(180,35,da);
		dc.setSize(120, 34);
		dc.setLocation(26, 18);
		add(dc);
		
		
		/**
		 * TODO 赛季
		 */
		matchseason = new JComboBox();
		matchseason.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		matchseason.setToolTipText("赛季");

		ArrayList<String> seasons = init.mbl.getAllSeason();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			matchseason.addItem(seasons.get(o));
		}
		matchseason.setEditable(true);
		matchseason.setBounds(540, 22, 117, 30);
		add(matchseason);
		matchseason.setVisible(true);
		
		/**
		 * TODO 赛季形式
		 */


		normal=new JButton(new ImageIcon("newpic/常规赛浮.png"));
		normal.setLocation(671, 22);
		normal.setSize(55, 30);
		add(normal);
		normal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				normal.setIcon(new ImageIcon("newpic/常规赛浮.png"));
				after.setIcon(new ImageIcon("newpic/季后赛.png"));

				matchtype="常规赛";
			}			
		});
		after=new JButton(new ImageIcon("newpic/季后赛.png"));
		after.setLocation(726, 22);
		after.setSize(55, 30);
		add(after);
		after.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				normal.setIcon(new ImageIcon("newpic/常规赛.png"));
				after.setIcon(new ImageIcon("newpic/季后赛浮.png"));
				matchtype="季后赛";
			}			
		});
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
	     
		teams.setBounds(351, 18, 164, 42);		
		add(teams);
		teams.setVisible(true);
		
		
		final ImageIcon image9 = new ImageIcon("newpic/筛选-筛选.png");
		image9.setImage(image9.getImage().getScaledInstance(75, 25,Image.SCALE_DEFAULT));
		final ImageIcon image10 = new ImageIcon("newpic/筛选-筛选浮.png");
		image10.setImage(image10.getImage().getScaledInstance(75, 25,Image.SCALE_DEFAULT));
		
		
		datefind = new JButton(image9);
		datefind.setBackground(init.syslightblue);
		datefind.setFocusPainted(false);
		datefind.setOpaque(false);
		datefind.setBounds(163,22, 75, 25);
		datefind.setToolTipText("查询");		
		this.add(datefind);	
		datefind.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Match_Data.mdvo=init.mbl.getMatchByTeamTime(dc.showDate.getText());
				if(Match_Data.mdvo==null||Match_Data.mdvo.size()==0){
					Match_Data.nm=new NoMatches();
					Match_Data.nm.setLocation(init.SysStart_X+360, init.SysStart_Y+200);
					Match_Data.nm.setVisible(true);
				}
				Match_Data.matchdata=Match_Data.getdata(Match_Data.mdvo);
				Match_Data.matchdatalist.updateTable(Match_Data.matchtitle, Match_Data.matchdata);
				Match_Data.matchdatalist.FitTableColumns(Match_Data.matchdatalist.getTable());
				Match_Data.setclwidth();
				//Match_Data.matchdatalist.setNthWidth(10, 230);
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
				datefind.setIcon(image10);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				datefind.setIcon(image9);
			}
			
		});
	
		
		find = new JButton(image9);
		find.setBackground(init.syslightblue);
		find.setFocusPainted(false);
		find.setOpaque(false);
		find.setBounds(791,25,75, 25);
		//
		find.setToolTipText("查询");		
		this.add(find);
		
		find.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				String Season = matchseason.getSelectedItem().toString().substring(0, 5);
            	String Team=teams.getSelectedItem().toString();
            	//System.out.println(Team);
            	matchdatalist.setVisible(true);
            	mdvo=init.mbl.getMatchBySeason(Season, Team);
            	if(mdvo==null||mdvo.size()==0){
            		Match_Data.nm=new NoMatches();
					Match_Data.nm.setLocation(init.SysStart_X+360, init.SysStart_Y+200);
					Match_Data.nm.setVisible(true);
	             }
            	Match_Data.matchdata=Match_Data.getdata(Match_Data.mdvo);
				Match_Data.matchdatalist.updateTable(Match_Data.matchtitle, Match_Data.matchdata);
				Match_Data.matchdatalist.FitTableColumns(Match_Data.matchdatalist.getTable());
				Match_Data.setclwidth();
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
				find.setIcon(image10);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				find.setIcon(image9);
			}
			
		});
	
		
		mdvo=init.mbl.getMatchByTeamTime(dc.showDate.getText());
		if(mdvo==null||mdvo.size()==0){
			nm=new NoMatches();
			nm.setLocation(init.SysStart_X+360, init.SysStart_Y+200);
			nm.setVisible(true);
		}
		matchdata=getdata(mdvo);
		matchdatalist = new CreateTable_M(matchtitle, matchdata, 10, 60,1040, 560, 25,
					new Font("黑体", 0, 15), new Font("Dialog", 0, 12));			
		matchdatalist.setSize(1040, 520);
		matchdatalist.setLocation(10, 70);
		//matchdatalist.FitTableColumns(matchdatalist.getTable());
		setclwidth();
		add(matchdatalist);
		
		JLabel menubg = new JLabel();
		menubg.setBackground(init.syslightblue);;
		menubg.setBounds(10, 10, 1040, 53);
		add(menubg);
		menubg.setOpaque(true);
		
		
	}
	public static  Object[][] getdata(ArrayList<MatchVO> mdata){
		//System.out.println(mdata.size());
		if(mdata==null){
			Object[][] re=new Object[1][11];
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
		}
		else{
			Object[][] re=new Object[mdata.size()][11];
			TeamName_Map mm=new TeamName_Map();
			//String[] matchtitle={"日期","赛季","主队","比分","客队",
			//	"第一节比分","第二节比分","第三节比分","第四节比分","加时赛比分"};
			for(int i=0;i<mdata.size();i++){		
				int k=mdata.get(i).getScores().size();
				re[i][0]=i+1;
				re[i][1]=mdata.get(i).getDate();
				re[i][2]=mdata.get(i).getSeason()+"赛季";
				re[i][3]=mm.getFullName(mdata.get(i).getHostTeam().getTeamName());
				re[i][4]=mdata.get(i).getMatchScore();
				re[i][5]=mm.getFullName(mdata.get(i).getGuestTeam().getTeamName());
				re[i][6]=mdata.get(i).getScores().get(0);
				re[i][7]=mdata.get(i).getScores().get(1);
				re[i][8]=mdata.get(i).getScores().get(2);
				re[i][9]=mdata.get(i).getScores().get(3);				
				re[i][10]="";
				if(k==4){
					re[i][10]="无加时赛";
				}else{
					for(int m=4;m<k;m++){
						re[i][10]=((re[i][10]+"/"+mdata.get(i).getScores().get(m)));
						
						
					}
					String str=re[i][10].toString();
						
					str=str.substring(str.indexOf('/')+1);
					re[i][10]=str;
				}
			}		
			return re;
		
		}
	}
	
	public static void setclwidth(){
		matchdatalist.setNthWidth(0, 50);
		matchdatalist.setNthWidth(1, 90);
		matchdatalist.setNthWidth(2, 80);		
		matchdatalist.setNthWidth(3, 100);
		matchdatalist.setNthWidth(4, 70);
		matchdatalist.setNthWidth(5, 100);
		matchdatalist.setNthWidth(6, 100);
		matchdatalist.setNthWidth(7, 100);
		matchdatalist.setNthWidth(8, 100);
		matchdatalist.setNthWidth(9, 100);
		matchdatalist.setNthWidth(10, 160);
	}
}
