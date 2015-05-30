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
	    			  rs.getString("score"),rs.getString("type"),list));
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
	    			  rs.getString("score"),rs.getString("type"),list));
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
	public MatchVO getMatchByTeam(String data, String teamA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,
			int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getAllSeason() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason(String season, String teamA) {
		// TODO Auto-generated method stub
		return null;
	}

}
