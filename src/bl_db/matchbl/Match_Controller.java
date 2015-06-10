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
 
import bl_db.common.Team_map;
import businessService.blservice.MatchBLService;

public class Match_Controller implements MatchBLService{

	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";		
    String currentSeason;
	
    Connection conn ;
    Statement stmt ;
    
    public Match_Controller(){
    	
    	try{
  		  Class.forName("com.mysql.jdbc.Driver").newInstance();
  		  conn = DriverManager.getConnection(url,user, pwd);
  	       stmt = conn.createStatement();
  	       conn.setAutoCommit(false);
  		}catch(Exception e){
  			System.out.println("数据库连接出错："+e.toString());
  		}
    	//currentSeason=getCurrentSeason();
    }
    
	private ArrayList<MatchInfoVO> getMatchInfo(String date1,String date2){
		ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		try
	    {
			 
		     
	       ResultSet  rs=stmt.executeQuery("SELECT * FROM matchinfo WHERE date BETWEEN '"+date1+"' AND '"+date2+"'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
 
	      while (rs.next())
	      {    
	    	  
	    	  score=rs.getString("scores");
	    	 
	    	  /*String date,String time,String teamH,
			String teamG,String isOver,
			String score,String type,ArrayList<String> cs,String link*/
	    	  
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
	    			  rs.getString("teamH"),rs.getString("teamG"),rs.getString("isOver"),
	    			  rs.getString("score"),rs.getString("type"),
	    			  getScores(score),rs.getString("link")));
	        //return vo;
	      }
	      conn.commit();
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
			 
		    Team_map map=new Team_map();
		    team=map.getFullName(team);
		    
	       ResultSet  rs=stmt.executeQuery("SELECT * FROM matchinfo WHERE teamH='"+team+"' OR teamG='"+team+"'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
	      while (rs.next())
	      {    
	    	  
	    	  score=rs.getString("scores");
	    	  
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
	    			  rs.getString("teamH"),rs.getString("teamG"),rs.getString("isOver"),
	    			  rs.getString("score"),rs.getString("type"), getScores(score),rs.getString("link")));
	        //return vo;
	      }
	      conn.commit();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
	}
	
	@Override
	public String getLastHavingMatchDate() {
		  
		try {
			 
			String str="select MAX(date) as max from matchinfo";
			ResultSet  rs=stmt.executeQuery(str);
		 String result=null;
			while(rs.next()){
				result= rs.getString("max");
				break;
			}
			  conn.commit();
			  return result;
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
	public ArrayList<String> getAllSeason() {
		ArrayList<String> list=new ArrayList<>();
 ;
		try {
		 
			String str="select distinct season from team_season_data";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				list.add(rs.getString("season")+"赛季");
			}
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return list;
	}

	public ArrayList<MatchVO> getMatchBySeason(String season, String teamA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_NotOver(String season, int month) {
		// TODO Auto-generated method stub
		
		/******************************
		 * 某个赛季某个月的还没有进行比赛的比赛赛程
		 * ****************************/
		
	ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
	ArrayList<String> daylist=getData(season,month);
		try
	    {
			 
	       ResultSet  rs=stmt.executeQuery("SELECT * FROM(SELECT * FROM matchinfo WHERE "
	       		+ "date BETWEEN '"+daylist.get(0)+"' AND '"+daylist.get(1)+"') "
	       		+ " as new_match WHERE isOver='未赛'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
	      while (rs.next())
	      {        	  
	    	  score=rs.getString("scores");
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
	    			  rs.getString("teamH"),rs.getString("teamG"),rs.getString("isOver"),
	    			  rs.getString("score"),rs.getString("type"), 
	    			  getScores(score),rs.getString("link")));
	        //return vo;
	      }
	      conn.commit();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
		
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ByMonth(String season, int month) {
		ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		ArrayList<String> daylist=getData(season,month);
			try
		    {
				
		       ResultSet  rs=stmt.executeQuery("SELECT * FROM matchinfo WHERE "
		       		+ "date BETWEEN '"+daylist.get(0)+"' AND '"+daylist.get(1)+"'");
		       /***************
		        * String date,String time,String teamH,
				String teamG,String type,ArrayList<String> cs
		        ************/
		       String score;
		      while (rs.next())
		      {        	  
		    	  score=rs.getString("scores");
		    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
		    			  rs.getString("teamH"),rs.getString("teamG"),rs.getString("isOver"),
		    			  rs.getString("score"),rs.getString("type"), 
		    			  getScores(score),rs.getString("link")));
		        //return vo;
		      }
		    conn.commit();
		}catch (Exception ex)
		    {
		      System.out.println("Error : " + ex.toString());
		    }
		
			return infoList;
	}

	@Override
	public ArrayList<String> getDatesOfPro_ByMonth(String season, int month) {
		/*************************************************
		 * 获取某个赛季某个月有比赛的所有日期
		 ********************************************/
		
        ArrayList<String> list = new ArrayList<>();
		
		ArrayList<String> daylist=getData(season,month);
			try
		    {
				 
		       ResultSet  rs=stmt.executeQuery("SELECT distinct date FROM matchinfo WHERE "
		       		+ "date BETWEEN '"+daylist.get(0)+"' AND '"+daylist.get(1)+"'");
		      while (rs.next())
		      {        	  
		    	  list.add(rs.getString("date"));
		      }
		     conn.commit();
		}catch (Exception ex)
		    {
		      System.out.println("Error : " + ex.toString());
		    }
		
			return list;
		 
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ByDay(String season, int month, int day) {
		ArrayList<MatchInfoVO> infoList = new ArrayList<>();
		
		/************************
		 *获取某个赛季某个月的，某一天的比赛记录
		 * 
		 * *******************/
		String date=getDate(season,month,day);
		
		try
	    {
			 
	       ResultSet  rs=stmt.executeQuery("SELECT * FROM matchinfo WHERE date='"+date+"'");
	        
	       String score;
	       
	      while (rs.next())
	      {      
	    	  score=rs.getString("scores");
	    	  
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),rs.getString("time"),
	    			  rs.getString("teamH"),rs.getString("teamG"),rs.getString("isOver"),
	    			  rs.getString("score"),rs.getString("type"), getScores(score),rs.getString("link")));
	        //return vo;
	      }
	      conn.commit();
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
		Team_map map=new Team_map();
		
		try
	    {
			 
	       ResultSet  rs=stmt.executeQuery("SELECT* FROM (SELECT * FROM "
	       		+ "matchinfo WHERE teamH='"+teamabb+"' OR teamG='"+map.getFullName(teamabb)+"') as new_match WHERE "
	       		+ "date BETWEEN '"+day.get(0)+"' AND '"+day.get(1)+"'");
	       /***************
	        * String date,String time,String teamH,
			String teamG,String type,ArrayList<String> cs
	        ************/
	       String score;
	       
	      while (rs.next())
	      {      
	    	  score=rs.getString("scores");
	    	  infoList.add(new MatchInfoVO(rs.getString("date"),
	    			  rs.getString("time"), rs.getString("teamH"),
	    			  rs.getString("teamG"),rs.getString("isOver"),
	    			  rs.getString("score"),rs.getString("type"), 
	    			  getScores(score),rs.getString("link")));
	        //return vo;
	      }
	      conn.commit();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
		return infoList;
	}
	
	
	private ArrayList<String> getScores(String score){
		ArrayList<String> list=new ArrayList<>();
  	  String str[]=score.split(";");
  	  for(int i=1;i<str.length;i++){
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

	
	
	private String getDate(String season,int month,int dy){
		String sl[]=season.split("-");
		 String mon;
		 String day;
		String year;
		if(month>=10){
			year=sl[0];
			mon=""+month;
		}else{
			year=sl[1];
			mon="0"+month;
		}
		
		if(dy<10){
			day="0"+dy;
		}else{
			day=""+dy;
		}
		
		year="20"+year;		
		return (year+"-"+mon+"-"+day);
		
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
		list.add(year+"-"+mon+"-"+getEndDay(month,Integer.parseInt(year)));
		return list;
	}
	
	private String getEndDay(int month,int year){
		String day=null;
		if(month==2){
			if((year%100!=0&&year%4==0)|(year%400==0)){
				day="28";
			}else{
				day="29";
			}
			
		}else{
			if(month==4|month==6|month==9|month==11){
				day="30";
			}else{
				day="31";
			}
		}
		return day;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason(String season, String type,
			String teamA) {
		// TODO Auto-generated method stub
		return null;
	}
		public static void main(String args[]){
			Match_Controller match=new Match_Controller();
			//ArrayList<MatchInfoVO> list=match.getPro_ByDay("14-15", 3, 2);
			//ArrayList<MatchInfoVO> list=match.get_A_matchInfo("快船");
			//ArrayList<MatchInfoVO> list=match.getPro_ByMonth("14-15", 1);
			
			ArrayList<MatchInfoVO> list=match.getPro_ForTeam("14-15", 1, "湖人");
			//ArrayList<MatchInfoVO> list=match.getPro_NotOver("14-15", 6);
			//ArrayList<String> list=match.getDatesOfPro_ByMonth("14-15", 1);
			//ArrayList<String> list=match.getData("14-15", 2);
			
			for(int i=0;i<list.size();i++){
				 System.out.println("date："+list.get(i).getDate()+"; "
						+ " score:"+list.get(i).getScore()+"; "
								+ " teamH:"+list.get(i).getTeam_H()+"; teamG: "+
						list.get(i).getTeam_G()+list.get(i).getScores());
			 
				System.out.println("----:"+list.get(i));
			}
		}
	
}
