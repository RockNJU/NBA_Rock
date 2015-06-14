package bl_db.teamrbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;
import bl_db.common.HotSort;
import bl_db.common.Sign;
import bl_db.common.Team_map;
import bl_db.matchbl.TeamInfo;
import businessService.blservice.TeamBLService;

public class Team_Controller implements TeamBLService ,TeamInfo{

	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";
    
    String currentSeason;
    ArrayList<TeamInfoVO> infoList;
    
    
    Connection conn ;
     Statement stmt ;
	
	public Team_Controller(){
		
		try{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  conn = DriverManager.getConnection(url,user, pwd);
	       stmt = conn.createStatement();
	       conn.setAutoCommit(false);
		}catch(Exception e){
			System.out.println("数据库连接出错："+e.toString());
		}
		
		infoList=new ArrayList<>();
		currentSeason=getCurrentSeason();
		readTeamBasicInfo();
		
		System.out.println("大小："+infoList.size());
	}
	
	
	private void readTeamBasicInfo(){
		
		try
	    {
			 
	       ResultSet  rs=stmt.executeQuery("select * from teaminfo");
	       
	      while (rs.next())
	      {
	    
	    	  
	    	  //System.out.println("？--？   "+rs.getString("teamAbb"));
	    	  
	    	infoList.add(new TeamInfoVO(rs.getString("team"),
	    			  rs.getString("Cname"),rs.getString("TEname"),
	    			  rs.getString("location"),rs.getString("division"),
	    			  rs.getString("partition"),rs.getString("homeGround"),
	    			  rs.getString("formedTime"),rs.getString("coach_name"),
	    			  rs.getString("coach_Ename"),rs.getString("teamAbb")));
	    	
	    	//System.out.println("？--？   "+rs.getString("teamAbb"));
	        //return vo;
	      }
	      conn.commit();
	}catch (Exception ex)
	    {
	      System.out.println("Error : " + ex.toString());
	    }
	
	}
	
	
	private String getCurrentSeason(){
		
		 
         
		try {
			  
			String str="select MAX(season) as max from team_season_data";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				return rs.getString("max");
			}
			conn.commit();
		} catch (SQLException e) {
			 System.out.println("数据库读取最新的一个赛季出现问题。");
		}//
		
		return "14-15";/*默认情况下*/
	}
	
	
	
	
	private ArrayList<TeamSeasonDataVO> getTeam_seasonData(String season,String type){
		
		
		//System.out.println("ArrayList<TeamSeasonDataVO> getTeam_seasonData(String season,String type)*******");
		ArrayList<TeamSeasonDataVO> list=new ArrayList<>();
	
      
          
		try {
			  
	        stmt = conn.createStatement(); 
					
			String str="SELECT * from (SELECT team_season_data.team,team_season_data.teamAbb,"
					+ "COUNT(*) as match_sum,SUM(winNum) as win_sum, "
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenseRound) as o_round_sum,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_season_data WHERE season='"+season+"'"
					+ " AND type='"+type+"'"
					+ " GROUP BY season,type,team) as "
					+ "data right join teaminfo as info on data.teamAbb =info.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			/********************************
			 * String season,String teamName,TeamInfoVO info,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double ,TeamMatchVO first_match
			 *******************************/
			char chr=39;
			while(rs.next()){
				
				
				/*System.out.println("球队----|||："+rs.getString("team")+";"+
				rs.getString("division")+";"+rs.getInt("point_sum"));*/
				
				list.add(new TeamSeasonDataVO(season,rs.getString("team"),
						
						new TeamInfoVO(rs.getString("team"),
				    			  rs.getString("Cname"),rs.getString("TEname"),
				    			  rs.getString("location"),rs.getString("division"),
				    			  rs.getString("partition"),rs.getString("homeGround"),
				    			  rs.getString("formedTime"),rs.getString("coach_name"),
				    			  rs.getString("coach_Ename"),rs.getString("teamAbb")),
		    			  
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
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return list;
		//HotSort sort=new HotSort();
		//return sort.hotTeam_Sort(list,"winRate");/*默认以得分排序，返回一个赛季的球员的数据*/
		
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
			 
			String str="SELECT * from(SELECT team_season_data.team,team_season_data.teamAbb,"
					+ "COUNT(*) as match_sum,SUM(winNum) as win_sum, "
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenseRound) as o_round_sum,"
					+ "AVG(AssistEfficiency)as assistEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_season_data WHERE season='"+season+"'"
					+ " AND type='"+type+"'"
					+ " GROUP BY season,type,team HAVING AVG("+item+")"+""+sign+" "+num+") as "
					+ "data right join teaminfo as info on data.teamAbb =info.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			
			char chr=39;
			while(rs.next()){
				
						list.add(new TeamSeasonDataVO(season,rs.getString("team"),
								
								new TeamInfoVO(rs.getString("team"),
						    			  rs.getString("Cname"),rs.getString("TEname"),
						    			  rs.getString("location"),rs.getString("division"),
						    			  rs.getString("partition"),rs.getString("homeGround"),
						    			  rs.getString("formedTime"),rs.getString("coach_name"),
						    			  rs.getString("coach_Ename"),rs.getString("teamAbb")),
				    			  
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
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return list;
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
		ArrayList<TeamSeasonDataVO> list=getTeam_seasonData(season,"常规赛");
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, item);
	}

	
	
	@Override
	public ArrayList<TeamSeasonDataVO> find(String text) {
		ArrayList<TeamSeasonDataVO> list=getTeam_seasonData(currentSeason,"常规赛");
		list.addAll(getTeam_seasonData(currentSeason,"季后赛"));
		list.addAll(getTeam_seasonData(currentSeason,"季前赛"));
		
		ArrayList<TeamSeasonDataVO> result=new ArrayList<>();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFullName().contains(text)
				|list.get(i).getInfo().getLocation().contains(text)|
				list.get(i).getInfo().getTeamAbb().contains(text)|
				list.get(i).getInfo().getTeam().equals(text)|
				list.get(i).getInfo().getTEname().contains(text)|
				list.get(i).getInfo().getFormedTime().contains(text)){
				result.add(list.get(i));
			}
		}
		
		return result;
	}


	@Override
	public ArrayList<PlayerSeasonDataVO> getKingPlayerForATeam(String teamname,
			String item) {
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		Team_map map=new Team_map(); 
		
		try {
			 
			String str="SELECT * FROM (SELECT name,position,"
					+ "team,COUNT(*) as match_sum, "
					+ "SUM(startingNum) as start_sum,SUM(time) as time_sum,"
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,"
					+ "SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,"
					+ "SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,"
					+ "AVG(efficiency) as eff,AVG(blockEfficiency)as blockEff,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(reboundEfficiency) as reboundEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(usingPercentage) as usingPct,"
					
					+ "SUM(seasonDoubleNum) as double_sum,SUM(seasonThreeNum) as three_sum "
					+ "FROM player_season_data WHERE season='"+currentSeason+"' AND team='"+map.getFullName(teamname)+"'"
					+ "GROUP BY season,name)as "
					+ "data left join teaminfo on data.name =teaminfo.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			/********************************
			 * String season,String name,PlayerInfoVO info,String teamName,
			String division,String partition,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoal,
		 int freeThrowNum,int O_R_N,int D_R_N,int reboundNum,
		 int assistNum,int stealNum,int blockNum,int turnoverNum,
		 int foulNum,int points,
		                           double assistEfficiency,
		 double reboundEfficiency,double offensiveReboundEff,
		 double defenseReboundEff,double stealEfficiency,
		 double usingPercentage,double blockEfficiency,int doubleNum,
		 int threeNum,SingleMatchPersonalDataVO firstMatch
			 *******************************/
			char chr=39;
			int rebound_rate=0;
			int point_rate=0;
			int assist_rate=0;
			
			while(rs.next()){
				PlayerSeasonDataVO vo=new PlayerSeasonDataVO(currentSeason,rs.getString("type"),
						rs.getString("name"),null,
						rs.getString("team"),rs.getString("division"),
						rs.getString("partition"),rs.getString("position"),
						rs.getInt("match_sum"),rs.getInt("start_sum"),
						rs.getDouble("time_sum"),rs.getInt("fieldGoal_sum"),
						rs.getInt("shoot_sum"),rs.getInt("t_fieldGoal_sum"),
						rs.getInt("t_shoot_sum"),rs.getInt("freeThrowGoal_sum"),
						rs.getInt("freeThrow_sum"),rs.getInt("o_rebound_sum"),
						rs.getInt("d_rebound_sum"),rs.getInt("rebound_sum"),
						rs.getInt("assist_sum"),rs.getInt("steal_sum"),
						rs.getInt("block_sum"),rs.getInt("turnover_sum"),
						rs.getInt("foul_sum"),rs.getInt("point_sum"),
						rs.getDouble("assistEff"),rs.getDouble("reboundEff"),
						rs.getDouble("o_reboundEff"),rs.getDouble("d_reboundEff"),
						rs.getDouble("stealEff"),rs.getDouble("usingPct"),
						rs.getDouble("blockEff"),rs.getInt("double_sum"),
						rs.getInt("three_sum"),
						null);
				list.add(vo);
			}
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,item);/*默认以得分排序，返回一个赛季的球员的数据*/
		 
	}
	
	public ArrayList<TeamInfoVO> getTeamInfoList(){
		return infoList;
	}
	
	public static void main(String args[]){
		Team_Controller team=new Team_Controller();
		
		
		ArrayList<TeamSeasonDataVO> list=team.getAllTeamSeasonData("13-14", "常规赛");
		 ArrayList<TeamMatchVO> volist=team.getASeasonMatchData("LAL", "11-12");
		ArrayList<TeamInfoVO> infoList=team.getTeamInfoList();
		//ArrayList<SingleMatchPersonalDataVO> inlist=team.getIndividualData("LAL","2012-04-29");
		/*for(int i=0;i<volist.size();i++){
			System.out.println("  队名："+volist.get(i).getTeamName()+"  对手："+volist.get(i).getOpp_team()+"  得分："+volist.get(i).getPointNum()+" date: "+volist.get(i).getDate());
		}*/
		/*
		  for(int i=0;i<inlist.size();i++){
			System.out.println("球队数据：  队名"+inlist.get(i).getTeamName()+
					"   得分:"+inlist.get(i).getPointNum()+";  姓名："+inlist.get(i).getPlayerName());
		}  */
		
		 
		for(int i=0;i<list.size();i++){
			System.out.println("球队信息："+infoList.get(i).getTeam()+";"+infoList.get(i).getDivision());
		} 
	}


	@Override
	public ArrayList<TeamSeasonDataVO> getATeamSeasonData(String team,
			String season) {
		ArrayList<TeamSeasonDataVO> list=new ArrayList<>();
		
	      
        
		try {
			 
	        stmt = conn.createStatement(); 
					
			String str="SELECT * from (SELECT team_season_data.team,team_season_data.teamAbb,"
					+ "COUNT(*) as match_sum,SUM(winNum) as win_sum, "
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenseRound) as o_round_sum,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_season_data WHERE season='"+season+"'"
					+ " AND teamAbb='"+team+"'"
					+ " GROUP BY season,type,team) as "
					+ "data right join teaminfo as info on data.team =info.team";
			ResultSet  rs=stmt.executeQuery(str);

			char chr=39;
			while(rs.next()){
				
				 
				
				list.add(new TeamSeasonDataVO(season,rs.getString("team"),
						
						new TeamInfoVO(rs.getString("team"),
				    			  rs.getString("Cname"),rs.getString("TEname"),
				    			  rs.getString("location"),rs.getString("division"),
				    			  rs.getString("partition"),rs.getString("homeGround"),
				    			  rs.getString("formedTime"),rs.getString("coach_name"),
				    			  rs.getString("coach_Ename"),rs.getString("teamAbb")),
		    			  
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
			 conn.commit();
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return list;
	}


	@Override
	public ArrayList<TeamMatchVO> getLastFiveMatchData(String team){
		ArrayList<TeamMatchVO> list=new ArrayList<>();
		
	       
      ;
		try {
			 
	        
	        String ss="(SELECT * FROM team_season_data where team='"+team+"' AND　season='"+currentSeason+"')";
	       // "SELECT TOP 5 FROM (SELECT* FROM team_season_data WHERE team='"+team+"' AND season='"+currentSeason+"') as temp ORDER BY date"	
	        
			String str="SELECT * FROM team_season_data WHERE teamAbb='"+team+"' AND season='"+currentSeason+"' ORDER BY date desc";
			ResultSet  rs=stmt.executeQuery(str);
			 int i=0;
		 
			while(rs.next()){
			   if(i>=5){
				   break;
			   }
				list.add(new TeamMatchVO(currentSeason,rs.getString("team"),rs.getInt("winNum"),
						rs.getString("date"),rs.getString("team_opp"),
						rs.getInt("pointNum"),rs.getInt("lost_points"),rs.getInt("reboundNum"),
						rs.getInt("o_ReboundNum"),rs.getInt("d_ReboundNum"),
						rs.getInt("assistNum"),rs.getInt("turnoverNum"),
						rs.getInt("stealNum"),rs.getInt("foulNum"),
						rs.getInt("fieldGoal"),rs.getInt("shootNum"),
						 rs.getInt("t_fieldGoal"),rs.getInt("t_shootNum"),
						 rs.getInt("freeThrowGoal"),rs.getInt("freeThrowNum"),
						 rs.getInt("blockNum"),rs.getInt("offenseRound"),
						 rs.getInt("defenseRound"),rs.getDouble("o_reboundEfficiency"),
						 rs.getDouble("d_reboundEfficiency"), null));
				i++;
			}
			  conn.commit();
		} catch (SQLException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		list=addindividualData(list,team);
		return list;
	}


	@Override
	public ArrayList<TeamMatchVO> getASeasonMatchData(String team, String season) {
		// TODO Auto-generated method stub
		/**********************************
		 * 获取某支球队某个赛季的所有参加了 的比赛数据
		 ********************************/
		ArrayList<TeamMatchVO> list=new ArrayList<>();
		
	      
       
		try {  
	         
			String str="SELECT * FROM team_season_data WHERE season='"+season+"' and teamAbb='"+team+"'";
			ResultSet  rs=stmt.executeQuery(str);
			 
			char chr=39;
			while(rs.next()){
				
				
 
				list.add(new TeamMatchVO(season,rs.getString("team"),rs.getInt("winNum"),
						rs.getString("date"),rs.getString("team_opp"),
						rs.getInt("pointNum"),rs.getInt("lost_points"),rs.getInt("reboundNum"),
						rs.getInt("o_ReboundNum"),rs.getInt("d_ReboundNum"),
						rs.getInt("assistNum"),rs.getInt("turnoverNum"),
						rs.getInt("stealNum"),rs.getInt("foulNum"),
						rs.getInt("fieldGoal"),rs.getInt("shootNum"),
						 rs.getInt("t_fieldGoal"),rs.getInt("t_shootNum"),
						 rs.getInt("freeThrowGoal"),rs.getInt("freeThrowNum"),
						 rs.getInt("blockNum"),rs.getInt("offenseRound"),
						 rs.getInt("defenseRound"),rs.getDouble("o_reboundEfficiency"),
						 rs.getDouble("d_reboundEfficiency"), null));
			}
			  conn.commit();
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		list=addindividualData(list,team);
		return list;
	}
	
	private ArrayList<TeamMatchVO> addindividualData(
			ArrayList<TeamMatchVO> list,String team){
		for(int i=0;i<list.size();i++){
			list.get(i).setIndividualData(getIndividualData(team,list.get(i).getDate()));
		}
		return list;
	}
	
	private ArrayList<SingleMatchPersonalDataVO> getIndividualData(String team,String date){
		ArrayList<SingleMatchPersonalDataVO> list=new ArrayList<>();
		 
		try {
			 
			String str="SELECT * FROM (SELECT * FROM "
					+ "player_season_data where date='"+date+"' AND team='"+team+"') as "
					+ "data left join teaminfo as info on data.team =info.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				//System.out.println("+++"+rs.getString("team"));
				list.add( new SingleMatchPersonalDataVO(rs.getString("season"), 
						rs.getString("date"),rs.getString("name"),
						rs.getString("team"),rs.getString("division"),
						rs.getString("partition"), rs.getString("position"),
						rs.getDouble("time"),rs.getInt("fieldGoal"),
						rs.getInt("shootNum"), rs.getInt("t_fieldGoal"),
						rs.getInt("t_shootNum"),rs.getInt("freeThrowGoal"),
						rs.getInt("freeThrowNum"),rs.getInt("o_ReboundNum"),
						rs.getInt("d_ReboundNum"),rs.getInt("reboundNum"),
						rs.getInt("assistNum"),rs.getInt("stealNum"),
						rs.getInt("blockNum"),rs.getInt("turnoverNum"), 
						rs.getInt("foulNum"),rs.getInt("pointNum"), 
						rs.getDouble("assistEfficiency"),rs.getInt("reboundEfficiency"),
						rs.getDouble("o_reboundEfficiency"), rs.getDouble("d_reboundEfficiency"),
						rs.getDouble("stealEfficiency"), rs.getDouble("usingPercentage"),
						rs.getDouble("blockEfficiency")));
			}
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return list;
	}


	@Override
	public TeamMatchVO getTeamMatch(String date, String teamAbb) {
		/**********************************
		 * 获取某支球队某个某一天参加的比赛
		 ********************************/
		 TeamMatchVO vo=null;
		
	      
       
		try {  
	         
			String str="SELECT * FROM team_season_data WHERE date='"+date+"' and teamAbb='"+teamAbb+"'";
			ResultSet  rs=stmt.executeQuery(str);
			 
			char chr=39;
			while(rs.next()){
				
				
 
				vo =new TeamMatchVO(rs.getString("season"),rs.getString("team"),rs.getInt("winNum"),
						rs.getString("date"),rs.getString("team_opp"),
						rs.getInt("pointNum"),rs.getInt("lost_points"),rs.getInt("reboundNum"),
						rs.getInt("o_ReboundNum"),rs.getInt("d_ReboundNum"),
						rs.getInt("assistNum"),rs.getInt("turnoverNum"),
						rs.getInt("stealNum"),rs.getInt("foulNum"),
						rs.getInt("fieldGoal"),rs.getInt("shootNum"),
						 rs.getInt("t_fieldGoal"),rs.getInt("t_shootNum"),
						 rs.getInt("freeThrowGoal"),rs.getInt("freeThrowNum"),
						 rs.getInt("blockNum"),rs.getInt("offenseRound"),
						 rs.getInt("defenseRound"),rs.getDouble("o_reboundEfficiency"),
						 rs.getDouble("d_reboundEfficiency"), null);
			}
			  conn.commit();
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return vo;
	}


	@Override
	public int getRank(String abb) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public TeamInfoVO getATeamInfo(String season, String name) {
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getTeamAbb().equals(name)){
				return infoList.get(i);
			}
		}
		return null;
	}


	@Override
	public TeamSeasonDataVO getATeamData(String season, String name) {
		Team_map map=new Team_map();
		TeamSeasonDataVO vo=null;
		try {
			  
	        stmt = conn.createStatement(); 
					
			String str="SELECT * from (SELECT team_season_data.team,team_season_data.teamAbb,"
					+ "COUNT(*) as match_sum,SUM(winNum) as win_sum, "
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,AVG(offenseRound) as o_round_sum,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(offenseEfficiency) as offenseEff,"
					+ "AVG(defenseEfficiency) as defenseEff "
					+ "FROM team_season_data WHERE season='"+season+"'"
					+ " AND team='"+map.getFullName(name)+"'"
					+ " GROUP BY season,type,team) as "
					+ "data right join teaminfo as info on data.teamAbb =info.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			
			while(rs.next()){
				vo=new TeamSeasonDataVO(season,rs.getString("team"),
						
						new TeamInfoVO(rs.getString("team"),
				    			  rs.getString("Cname"),rs.getString("TEname"),
				    			  rs.getString("location"),rs.getString("division"),
				    			  rs.getString("partition"),rs.getString("homeGround"),
				    			  rs.getString("formedTime"),rs.getString("coach_name"),
				    			  rs.getString("coach_Ename"),rs.getString("teamAbb")),
		    			  
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
						null);
				break;
			}
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return vo;
	}


	@Override
	public double[] getTeamOneData(String name, int num, String item) {
		double list[]=null;
		ResultSet rs=null;
		
		System.out.println("当前赛季："+currentSeason);
		try {
			 
			String sqlStr="SELECT COUNT(*) AS num FROM player_season_data "
					+ "where name='"+name+"' AND season='"+currentSeason+"'";
			rs=stmt.executeQuery(sqlStr);
			int n=0;
			while(rs.next()){
				n=rs.getInt("num");
				System.out.println("while中----"+n);
				break;
			}
			
			System.out.println("----"+n);
			
			if(num<n){
				num=n;
			}
			
			list=new double[num];
			list=addValue(list,num);
	        conn.commit();
			
			String str="SELECT "+item+" FROM player_season_data where "
					+ " name='"+name+"' AND season='"+currentSeason+"'";
			 rs=stmt.executeQuery(str);
			char chr=39;
			
			int count=0;
			
			while(rs.next()){
				list[count]=rs.getDouble(item);
				if(count==n){
					break;
				}
			}
			 conn.commit();
		} catch (SQLException e) {
			System.out.println("错误原因： "+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return list;
	}
	

	private double[] addValue(double list[],int num){
		for(int i=0;i<num;i++){
			list[i]=0;
		}
		return list;
	}
	
	
	
	/***************************************************************
	 * 
	 ***************************************************************/
	

}
