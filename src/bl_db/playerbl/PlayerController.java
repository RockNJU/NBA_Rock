package bl_db.playerbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import businessService.blservice.PlayerBLService;
import businesslogic.bl.center.HotSort;

/*
 * 使用数据库的逻辑层
 * 的球 员模块的代码实现
 * 接口与迭代二的都相同
 * 往后会考虑添加新的功能
 * 再考虑新接口的添加
 * */
public class PlayerController implements PlayerBLService{
	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";		
    
    String currentSeason;
	
	ArrayList<PlayerInfoVO> infoList;
	
	public PlayerController(){
		readBasicInfo();
		currentSeason=getCurrentSeason();
	}
	
	private String getCurrentSeason(){
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
			String str="select MAX(season) as max from matchinfo";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				return rs.getString("max");
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return "14-15";/*默认情况下*/
	}
	
	private void readBasicInfo(){
		/*
		 * 用于获取当前时间下球员最新的基本信息
		 * 
		 * */
			ArrayList<PlayerInfoVO> infoList=new ArrayList<>();
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
				String str="select * from playerinfo";
				ResultSet  rs=stmt.executeQuery(str);
				char chr=39;
				while(rs.next()){
					infoList.add(new PlayerInfoVO(rs.getString("name").replace('’', chr),rs.getString("number"),
		    			  rs.getString("position"),rs.getString("height"),
		    			  rs.getDouble("weight"),rs.getString("birth"),
		    			  rs.getInt("age"),rs.getInt("exp"),rs.getString("school").replace('’', chr)));
				}
				  stmt.close();
			      conn.close();//使用完后就关闭数据库
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//
	}
	
	
	@Override
	public ArrayList<PlayerInfoVO> getAllPlayerInfo() {
		return infoList;
	}
	
	@Override
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,
			String sortItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> keyfind(String text) {
		return null;
		
	}

	@Override
	public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,
			String teamAbb) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		
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
			String str="SELECT name,number,position,height,weight,birth,age,exp,school"
					+ " FROM playerinfo,playerseasondata WHERE playerseasondata.teamAbb= '"+teamAbb+"' "
							+ "AND playerseasondata.season='"+season+"' playerinfo.name=playerseasondata.name";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				list.add(new PlayerInfoVO(rs.getString("name").replace('’', chr),rs.getString("number"),
	    			  rs.getString("position"),rs.getString("height"),
	    			  rs.getDouble("weight"),rs.getString("birth"),
	    			  rs.getInt("age"),rs.getInt("exp"),rs.getString("school").replace('’', chr)));
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
	public ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem,
			int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item,
			int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> getSortInfo(String position,
			String league, String age, String[] condition, boolean[] reverse) {
		// TODO Auto-generated method stub
		return null;
	}
/*****************************************************************************
 * 以下包含type的部分都是迭代三要求做的，type即为比赛类型（ＮＢＡ的常规赛和季后赛，季前赛）
 ****************************************************************************/
	
	
	
	private ArrayList<PlayerSeasonDataVO> getAllPlayerSeasonData(String season, String type){
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
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
			String str="SELECT name,division,partition,position,teamAbb,COUNT(*) as match_num, "
					+ "SUM(startingNum) as start_num,SUM(time) as time_sum,"
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoalNum) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(turnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,"
					+ "AVG(efficiency) as eff,AVG(blockEfficiency)as blockEff,"
					+ "AVG(assistEfficiency)as assistEff,AVG(reboundEfficiency) as reboundEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(usingPercentage) as usingPct,"
					
					+ "SUM(seasonDoubleNum) as double_sum,SUM(seasonThreeNum) as three_sum "
					+ "FROM player_season_data,playerinfo WHERE season='"+season+"' AND type='"+type+"'"
					+ "GROUP BY season,type,name";
			ResultSet  rs=stmt.executeQuery(str);
			/********************************
			 * String season,String name,PlayerInfoVO info,String teamName,
			String division,String partition,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,
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
			while(rs.next()){
				list.add(new PlayerSeasonDataVO(season,rs.getString("name"),null,
						rs.getString("teamAbb"),rs.getString("division"),
						rs.getString("partition"),rs.getString("position"),
						rs.getInt("match_sum"),rs.getInt("starting_sum"),
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
						rs.getDouble("blockEff"),rs.getInt("double_sum"),rs.getInt("three_sum"),
						null));
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,"pointNum");/*默认以得分排序，返回一个赛季的球员的数据*/
	}
	
	
	
	@Override
	public ArrayList<PlayerSeasonDataVO> sort_super(String season, String type,
			String position, String partition, String item, String sign, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerInfoVO> getPlayerInfoByFirstChar(String firstchar) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		for(int i=0;i<infoList.size();i++){
			if(list.get(i).getName().startsWith(firstchar)){
				list.add(infoList.get(i));
			}
		}	
		return list;
	}

	

	@Override
	public ArrayList<PlayerSeasonDataVO> sort(String season, String type,
			String position, String partition, String item) {
		ArrayList<PlayerSeasonDataVO> list=getAllPlayerSeasonData(season,type);
		list=sort_position(list,position);
		list=sort_partition(list,partition);
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,item);
	}

	@Override
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season, String type,
			String name) {
		 
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
			String str="SELECT name,division,partition,position,teamAbb,SUM(matchNum) as match_num, "
					+ "SUM(startingNum) as start_num,SUM(time) as time_sum,"
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoalNum) as freeThrowGoal_sum,SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block-sum,"
					+ "SUM(tunrnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,"
					+ "AVG(efficiency) as eff,AVG(blockEfficiency)as blockEff,"
					+ "AVG(assistEfficiency)as assistEff,AVG(reboundEfficiency) as reboundEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(usingPercentage) as usingPct,"
					+ "AVG(blockEfficiency) as blockEff,"
					+ "SUM(seasonDoubleNum) as double_sum,SUM(seasonThreeNum) as three_sum "
					+ "FROM player_season_data where name='"+name+"' GROUP BY season,type,name";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				return new PlayerSeasonDataVO(season,rs.getString("name"),null,
						rs.getString("teamAbb"),rs.getString("division"),
						rs.getString("partition"),rs.getString("position"),
						rs.getInt("match_sum"),rs.getInt("starting_sum"),
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
						rs.getDouble("blockEff"),rs.getInt("double_sum"),rs.getInt("three_sum"),
						null);
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return new PlayerSeasonDataVO(season, name, null, "??", "??", "??", "??",
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);/* 当在数据库中没有查询到的情况下  ,返回一个表示未知的数据*/
	}

	
	/******************************************
	 * 
	 *************************************/
	private  ArrayList<PlayerSeasonDataVO> sort_division(ArrayList<PlayerSeasonDataVO>list,
			String division) {
		 /*按联盟筛选*/
		ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDivision().equals(division)){
			vo.add(list.get(i));
			}
		}
		return vo;
		}
		
	 
	private ArrayList<PlayerSeasonDataVO> sort_partition(ArrayList<PlayerSeasonDataVO>list,
			String partition) {
		 
		ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getPartition().equals(partition)){
			vo.add(list.get(i));
			}
		}
		return vo;
	}
	
	private ArrayList<PlayerSeasonDataVO> sort_position(ArrayList<PlayerSeasonDataVO>list,String position){
		/*这个地方有待思考*/
		ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getInfo().getPosition().contains(position)){
			vo.add(list.get(i));
			}
		}
		return vo;
		 
	}
	

	@Override
	public ArrayList<PlayerSeasonDataVO> sort(String season, String type,
			String position, String partition, String[] condition,
			boolean[] reverse) {
		ArrayList<PlayerSeasonDataVO> list=getAllPlayerSeasonData(season,type);
		list=sort_position(list,position);
		list=sort_partition(list,partition);
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list, condition, reverse);
	}


	@Override
	public ArrayList<PlayerInfoVO> getPlayerInfo(String name) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getName().equals(name)){
				list.add(infoList.get(i));
			}
		}
		return list;
		 //当数据库中没有对应球员的基础数据时，返回一个表示未知的信息
	}

}
