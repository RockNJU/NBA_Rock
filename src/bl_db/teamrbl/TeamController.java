package bl_db.teamrbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.PlayerSeasonDataVO;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import bl_db.common.Sign;
import businessService.blservice.TeamBLService;
import businesslogic.bl.center.HotSort;

public class TeamController implements TeamBLService{

	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";
    
    String currentSeason;
    ArrayList<TeamInfoVO> infoList;
	
	public TeamController(){
		currentSeason=getCurrentSeason();
		readTeamBasicInfo();
	}
	
	
	private void readTeamBasicInfo(){
		
		try
	    {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection conn = DriverManager.getConnection(url,user, pwd);
		     Statement stmt = conn.createStatement();
	       ResultSet  rs=stmt.executeQuery("select * from teaminfo");
	       
	      while (rs.next())
	      {
	    	  /*
	    	   * String city,String team,String TEname,
			String location,String division,String partition,
			String home,String time,String caoch_name,
			String caoch_Ename,String teamAbb
	    	   * */
	    	  infoList.add(new TeamInfoVO(rs.getString("city"),
	    			  rs.getString("team"),rs.getString("TEname"),
	    			  rs.getString("location"),rs.getString("division"),
	    			  rs.getString("partition"),rs.getString("homeGround"),
	    			  rs.getString("formedTime"),rs.getString("coach_name"),
	    			  rs.getString("coach_Ename"),rs.getString("teamAbb")));
	        //return vo;
	      }
	      conn.close();
	      stmt.close();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
	}
	
	
	private String getCurrentSeason(){
		/*try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      */
         Statement stmt;
		try {
			Connection conn;
			conn = DriverManager.getConnection(url,user, pwd);
			stmt = conn.createStatement(); 
			String str="select MAX(season) as max from matchinfo";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				return rs.getString("max");
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			 System.out.println("数据库读取最新的一个赛季出现问题。");
		}//
		
		return "14-15";/*默认情况下*/
	}
	
	void test(){
		
	}
	
	
	private ArrayList<TeamSeasonDataVO> getTeam_seasonData(String season,String type){
		ArrayList<TeamSeasonDataVO> list=new ArrayList<>();
	
      
         Statement stmt;
		try {
			Connection conn;
			 Class.forName("org.sqlite.JDBC");  
	         conn = DriverManager.getConnection(url,user, pwd);
	       // conn = DriverManager.getConnection( "jdbc:sqlite:Data/test.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
					
			String str="SELECT team,teamAbb,"
					+ "COUNT(*) as match_num,SUM(winNum) as win_sum "
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoalNum) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenRound) as o_round_sum,"
					+ "AVG(assistEfficiency)as assistEff"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_season_data WHERE season='"+season+"' AND type='"+type+"'"
					+ " GROUP BY season,type,team";
			ResultSet  rs=stmt.executeQuery(str);
			/********************************
			 * String season,String teamName,TeamInfoVO info,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency,TeamMatchVO first_match
			 *******************************/
			char chr=39;
			while(rs.next()){
				list.add(new TeamSeasonDataVO(season,rs.getString("teamAbb"),null,
						rs.getInt("match_sum"),rs.getInt("win_sum"),rs.getInt("fieldGoal_sum"),
						rs.getInt("shoot_sum"),rs.getInt("t_fieldGoal_sum"),
						rs.getInt("t_shoot_sum"),rs.getInt("freeThrowGoal_sum"),
						rs.getInt("freeThrow_sum"),rs.getInt("o_rebound_sum"),
						rs.getInt("d_rebound_sum"),
						rs.getInt("assist_sum"),rs.getInt("steal_sum"),rs.getInt("rebound_sum"),
						rs.getInt("block_sum"),rs.getInt("turnover_sum"),
						rs.getInt("foul_sum"),rs.getInt("point_sum"),rs.getDouble("o_round_sum"),
						rs.getDouble("offenseEff"),rs.getDouble("defenseEff"),
						rs.getDouble("o_reboundEff"),rs.getDouble("d_reboundEff"),
						rs.getDouble("stealEff"),rs.getDouble("assistEff"),
						null));
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list,"winRate");/*默认以得分排序，返回一个赛季的球员的数据*/
		
	}
	
	
	@Override
	public ArrayList<String> getTeamByPartition(String partition) {
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getPartition().equals(partition)){
				list.add(infoList.get(i).getTeamAbb());
			}
		}
		return list;
	}

	
	
/***********************************************************
 * 	
 ***********************************************************/
	
	
	@Override
	public ArrayList<TeamSeasonDataVO> sort_super(String season, String type,
			String item, String sign, int num) {
		ArrayList<TeamSeasonDataVO> list=new ArrayList<>();
		sign=Sign.getSign(sign);
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
			String str="SELECT team,teamAbb,type,"
					+ "COUNT(*) as match_num,SUM(winNum) as win_sum,"
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenseRound) as o_round_sum,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_seasonn_data WHERE season='"+season+"' AND type='"+type+"'"
					+ " GROUP BY season,type,team HAVING AVG("+item+")"+""+sign+" "+num+"";
			ResultSet  rs=stmt.executeQuery(str);
			/********************************
			 * String season,String teamName,TeamInfoVO info,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency,TeamMatchVO first_match
			 *******************************/
			char chr=39;
			while(rs.next()){
				 
				list.add(new TeamSeasonDataVO(season,rs.getString("teamAbb"),null,
						rs.getInt("match_sum"),rs.getInt("win_sum"),rs.getInt("fieldGoal_sum"),
						rs.getInt("shoot_sum"),rs.getInt("t_fieldGoal_sum"),
						rs.getInt("t_shoot_sum"),rs.getInt("freeThrowGoal_sum"),
						rs.getInt("freeThrow_sum"),rs.getInt("o_rebound_sum"),
						rs.getInt("d_rebound_sum"),
						rs.getInt("assist_sum"),rs.getInt("steal_sum"),rs.getInt("rebound_sum"),
						rs.getInt("block_sum"),rs.getInt("turnover_sum"),
						rs.getInt("foul_sum"),rs.getInt("point_sum"),rs.getDouble("o_round_sum"),
						rs.getDouble("offenseEff"),rs.getDouble("defenseEff"),
						rs.getDouble("o_reboundEff"),rs.getDouble("d_reboundEff"),
						rs.getDouble("stealEff"),rs.getDouble("assistEff"),
						null));
				 
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return null;
	}

	@Override
	public String getdefaultseason() {
		return currentSeason+"赛季";
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season,
			String type) {
		return getTeam_seasonData(season,type);
		/*返回的默认按胜率排序*/
	}

	@Override
	public ArrayList<TeamSeasonDataVO> sort(String season, String type,
			String sortItem) {
		ArrayList<TeamSeasonDataVO> list=getTeam_seasonData(season,type);
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, sortItem);
	}

	@Override
	public ArrayList<TeamSeasonDataVO> sort(String season, String type,
			String[] condition, boolean[] reverse) {
		ArrayList<TeamSeasonDataVO> list=getTeam_seasonData(season,type);
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, condition, reverse);
	}



	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season, String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> find(String text) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<PlayerSeasonDataVO> getKingPlayerForATeam(String tamename,
			String item) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<TeamInfoVO> getTeamInfoList(){
		return infoList;
	}
	
	public static void main(String args[]){
		TeamController team=new TeamController();
	//	ArrayList<TeamSeasonDataVO> list=team.getTeam_seasonData("12-13","常规赛");
		ArrayList<TeamInfoVO> infoList=team.getTeamInfoList();
		/*for(int i=0;i<list.size();i++){
			System.out.println("球队数据：  队名"+list.get(i).getTeamName()+"   得分:"+list.get(i).getPointNum());
		}*/
		
		team.sort("11-12","常规赛","pointNum","≥",90);
		
		for(int i=0;i<infoList.size();i++){
			System.out.println("球队信息："+infoList.get(i).getTeam()+";"+infoList.get(i).getDivision());
		}
	}
	
	
	/***************************************************************
	 * 
	 ***************************************************************/
	public void sort(String season, String type,
			String item, String sign, int num) {
	 
		System.out.println(type);
		sign=Sign.getSign(sign);
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
			
			 /*String str="SELECT type,team,COUNT(*) as match_num,SUM(winNum) as win_sum,"
			 		+ "AVG(pointNum)as point_sum FROM team_seasonn_data "
			 		+ "WHERE type='常规赛' group by team,type HAVING AVG(pointNum)>90";
			//String str="SELECT *FROM team_seasonn_data";*/
			String str="SELECT team,teamAbb,type,"
					+ "COUNT(*) as match_num,SUM(winNum) as win_sum,"
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenseRound) as o_round_sum,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_season_data WHERE season='"+season+"' AND type='"+type+"'"
					+ " GROUP BY season,type,team HAVING AVG("+item+")"+""+sign+" "+num+"";
					 
			ResultSet  rs=stmt.executeQuery(str);
			 
			char chr=39;
			
			while(rs.next()){
				System.out.println(rs.getString("type")+";"+rs.getString("team")+";"+rs.getString("point_sum"));
						
				 
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		 
	}
	

}
