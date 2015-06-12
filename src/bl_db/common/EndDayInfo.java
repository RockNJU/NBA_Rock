package bl_db.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EndDayInfo {
	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";		
    String currentSeason;
	String lastDay;
    Connection conn ;
    Statement stmt ;
    public EndDayInfo(){
    	try{
    		  Class.forName("com.mysql.jdbc.Driver").newInstance();
    		  conn = DriverManager.getConnection(url,user, pwd);
    	       stmt = conn.createStatement();
    	       conn.setAutoCommit(false);
    		}catch(Exception e){
    			System.out.println("���ݿ����ӳ���"+e.toString());
    		}
      	currentSeason=getCurrentSeason();
      	lastDay=getLastDate();
    }
    private String getLastDate(){
		String result="2015-06-12";
		try {
			 
			String str="select MAX(date) as max from team_season_data";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				result= rs.getString("max");
			}
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return result;/*Ĭ�������*/
	}
	
	private String getCurrent_Season(){
		String result="14-15";
		try {
			 
			String str="select MAX(season) as max from team_season_data";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				result= rs.getString("max");
			}
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return result;/*Ĭ�������*/
	}
	public String getLastDay() {
		return lastDay;
	}
	public String getCurrentSeason(){
		return currentSeason;
	}
}
