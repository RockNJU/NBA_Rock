package bl_db.matchbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.MatchInfoVO;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamInfoVO;
import businessService.blservice.MatchBLService;

public class MatchController implements MatchBLService{

	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";		
    
    String currentSeason;
	
	private ArrayList<MatchInfoVO> getMatchInfo(String season){
		ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		try
	    {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection conn = DriverManager.getConnection(url,user, pwd);
		     Statement stmt = conn.createStatement();
	       ResultSet  rs=stmt.executeQuery("SELEFT * FROM matchinfo WHERE season='"+season+"'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
	       ArrayList<String> list=new ArrayList<>();
	      while (rs.next())
	      {    
	    	  
	    	  score=rs.getString("sc");
	    	  String str[]=score.split(";");
	    	  for(int i=0;i<str.length;i++){
	    		  list.add(str[i]);
	    	  }
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
	    			  rs.getString("teamH"),rs.getString("teamG"),
	    			  rs.getString("score"),rs.getString("type"),score, list));
	        //return vo;
	      }
	      conn.close();
	      stmt.close();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
		
	}
	
	private ArrayList<MatchInfoVO> get_A_matchInfo(String team){
		ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		try
	    {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection conn = DriverManager.getConnection(url,user, pwd);
		     Statement stmt = conn.createStatement();
	       ResultSet  rs=stmt.executeQuery("SELEFT * FROM matchinfo WHERE teamH='"+team+"' OR teamG='"+team+"'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
	       ArrayList<String> list=new ArrayList<>();
	      while (rs.next())
	      {    
	    	  
	    	  score=rs.getString("sc");
	    	  String str[]=score.split(";");
	    	  for(int i=0;i<str.length;i++){
	    		  list.add(str[i]);
	    	  }
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
	    			  rs.getString("teamH"),rs.getString("teamG"),
	    			  rs.getString("score"),rs.getString("type"),score, list));
	        //return vo;
	      }
	      conn.close();
	      stmt.close();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
	}
	
	@Override
	public String getLastHavingMatchDate() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
         Statement stmt;
		try {
			Connection conn;
			conn = DriverManager.getConnection(url,user, pwd);
			stmt = conn.createStatement(); 
			String str="select MAX(date) as max from matchinfo";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				return rs.getString("max");
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			 System.out.println("数据库读取最新的一个赛季出现问题。");
		}//
		return null;
	}

	@Override
	public String getNextHavingMatchDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchVO> getMatchByTeamTime(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<String> getAllSeason() {
		ArrayList<String> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
         Statement stmt;
		try {
			Connection conn;
			conn = DriverManager.getConnection(url,user, pwd);
			stmt = conn.createStatement(); 
			String str="select season from matchinfo";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				list.add(rs.getString("season"));
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return list;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason(String season, String teamA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_NotOver(String season, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ByMonth(String season, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDatesOfPro_ByMonth(String season, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ByDay(String season, int month, int day) {
ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		/************************
		 * 待好好想一想，未完成
		 * 
		 * ***/
		try
	    {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection conn = DriverManager.getConnection(url,user, pwd);
		     Statement stmt = conn.createStatement();
	       ResultSet  rs=stmt.executeQuery("SELEFT * FROM matchinfo WHERE date=day");
	        
	       String score;
	       
	      while (rs.next())
	      {      
	    	  score=rs.getString("sc");
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),
	    			  rs.getString("time"),rs.getString("teamH"),
	    			  rs.getString("teamG"),rs.getString("score"),
	    			  rs.getString("type"),score, getScores(score)));
	        //return vo;
	      }
	      conn.close();
	      stmt.close();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ForTeam(String season, int month,
			String teamabb) {
		ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		ArrayList<String> day=getData(season,month);
		
		try
	    {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection conn = DriverManager.getConnection(url,user, pwd);
		     Statement stmt = conn.createStatement();
	       ResultSet  rs=stmt.executeQuery("SELECT* FROM (SELEFT * FROM "
	       		+ "matchinfo WHERE teamH='"+teamabb+"' OR teamG='"+teamabb+"') WHERE "
	       		+ "date BETWEEN '"+day.get(0)+"' AND '"+day.get(1)+"'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
	       
	      while (rs.next())
	      {      
	    	  score=rs.getString("sc");
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),
	    			  rs.getString("time"),rs.getString("teamH"),
	    			  rs.getString("teamG"),rs.getString("score"),
	    			  rs.getString("type"),score, getScores(score)));
	        //return vo;
	      }
	      conn.close();
	      stmt.close();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
	}
	
	
	private ArrayList<String> getScores(String score){
		ArrayList<String> list=new ArrayList<>();
  	  String str[]=score.split(";");
  	  for(int i=0;i<str.length;i++){
  		  list.add(str[i]);
  	  }
  	  return list;
	}
	

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,
			int n) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private ArrayList<String> getData(String season,int month){
		ArrayList<String>list=new ArrayList<>();
		
		String sl[]=season.split("-");
		 String mon;
		String year;
		if(month>=10){
			year=sl[0];
			mon=""+month;
		}else{
			year=sl[1];
			mon="0"+month;
		}
		
		
		
		
		year="20"+year;
		list.add(year+"-"+mon+"-"+"01");
		list.add(year+"-"+mon+"-"+
		getEndDay(month,Integer.parseInt(year)));
		return list;
	}
	
	private String getEndDay(int month,int year){
		String day=null;
		if(month==2){
			if((year%100!=0&&year%4==0)|(year%400==0)){
				day=month+"-"+"28";
			}else{
				day=month+"-"+"29";
			}
			
		}else{
			if(month==4|month==6|month==9|month==11){
				day=month+"-"+"30";
			}else{
				day=month+"-"+"31";
			}
		}
		return null;
	}
		
	
}
