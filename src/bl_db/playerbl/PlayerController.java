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
import bl_db.common.HotSort;
import bl_db.common.Sign;
import businessService.blservice.PlayerBLService;

/********************************************************
 * 使用数据库的逻辑层 的球 员模块的代码实现
 * 接口与迭代二的都相同 往后会考虑添加新的功能
 * 再考虑新接口的添加
 * *****************************************************/
public class PlayerController implements PlayerBLService{
	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";		
    
    String currentSeason;
    String lastDate;
	
	ArrayList<PlayerInfoVO> infoList;
	
	   Connection conn ;
	     Statement stmt ;
	
	
	public PlayerController(){
		try{
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  conn = DriverManager.getConnection(url,user, pwd);
		       stmt = conn.createStatement();
		       conn.setAutoCommit(false);
			}catch(Exception e){
				System.out.println("数据库连接出错："+e.toString());
			}
		readBasicInfo();
		currentSeason=getCurrentSeason();
		lastDate=getLastDate();
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
		
		return result;/*默认情况下*/
	}
	
	private String getCurrentSeason(){
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
		
		return result;/*默认情况下*/
	}
	
	private void readBasicInfo(){
		/*
		 * 用于获取当前时间下球员最新的基本信息
		 * 
		 * */
			ArrayList<PlayerInfoVO> infoList=new ArrayList<>();
			  
			try {
				 
				String str="select * from playerinfo";
				ResultSet  rs=stmt.executeQuery(str);
				char chr=39;
				while(rs.next()){
					/*String name,String num,String p,String height,
			String weight,String birth,int age ,int exp
			,String school,String Ename*/
					
					infoList.add(new PlayerInfoVO(rs.getString("name").replace('’', chr),
							rs.getString("number"), rs.getString("position"),
							rs.getString("height"),rs.getString("weight"),rs.getString("birth"),
		    			  rs.getInt("age"),rs.getInt("exp"),
		    			  rs.getString("school").replace('’', chr),rs.getString("Ename")));
				}
				 conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//
	}
	
	private PlayerInfoVO getInfo(String name){
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getName().equals(name)){
				return infoList.get(i);
			}
		}
		
		return new PlayerInfoVO(name, "??", "??", "??", "??", "??", 0, 0, "??", "??");
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

	
	public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,
			String teamAbb) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		try {
				String sqlStr=" SELECT name";
			
			String str="SELECT  playerinfo.name, number, playerinfo.position,"
					+ " height,distinct  weight,"
					+ " birth,age,"
					+ " exp,  school, Ename)"
					+ " FROM playerinfo,player_season_data "
					+ "WHERE player_season_data.team= '"+teamAbb+"' "
				    + "AND player_season_data.season='"+season+"' "
				    + "and playerinfo.name=player_season_data.name";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				list.add(new PlayerInfoVO(rs.getString("name").replace('’', chr),
						rs.getString("number"), rs.getString("position"),
						rs.getString("height"),rs.getString("weight"),rs.getString("birth"),
	    			  rs.getInt("age"),rs.getInt("exp"),
	    			  rs.getString("school").replace('’', chr),rs.getString("Ename")));
			}
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		
		return list;
	}
/****************************************
 * 
 * @param name
 * @param item
 * @param season
 * @return   获取某个赛季的  某个球员的某乡数据的总和
 */
	private int sumItem(String name,String item,String season){
		 
		try {
	 
			ResultSet  rs;
			 
			
			String sqlStr="SELECT SUM("+item+") AS sum FROM player_season_data"
					+ " where name='"+name+"' AND season='"+currentSeason+"'";
			rs=stmt.executeQuery(sqlStr);
			int sum=rs.getInt("sum");
		
			conn.commit();
		      return sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return 0;    //当数据库中没有对应的记录的时候，返回默认的 0	
	}
	
	private int get_Last_Five(String name,String season,String item){
		int sum=0;
	 
    
		try {
			 
			ResultSet  rs;
			 
			
			String sqlStr="SELECT * FROM (SELECT "+item+" FROM player_season_data"
					+ " where name='"+name+"' AND season='"+currentSeason+"') ORDER BY　date desc";
			rs=stmt.executeQuery(sqlStr);
			while(rs.next()){
				sum=sum+rs.getInt(""+item+"");
			}
			
			  conn.commit();
		      return sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return 0;    //当数据库中没有对应的记录的时候，返回默认的 0	
	}
	
	
	@Override
	public ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem) {
		ArrayList<PlayerSeasonDataVO> list= getAllPlayerSeasonData(currentSeason,"常规赛");
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,sortItem);
	}

	 
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem,
			int n) {
		ArrayList<PlayerSeasonDataVO> list= getAllPlayerSeasonData(currentSeason,"常规赛");
		HotSort sort=new HotSort();
		list=sort.hotPlayer_Sort(list,sortItem);
		ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
		for(int i=0;i<n;i++){
			result.add(list.get(i));
		}
		return result;
	}

	
	

/*****************************************************************************
 * 以下包含type的部分都是迭代三要求做的，type即为比赛类型（ＮＢＡ的常规赛和季后赛，季前赛）
 ****************************************************************************/
	private ArrayList<PlayerSeasonDataVO> getData(String sqlStr){
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();	 
		try {
			ResultSet  rs=stmt.executeQuery(sqlStr);
		
			char chr=39;
			int rebound_rate=0;
			int point_rate=0;
			int assist_rate=0;
			
			while(rs.next()){
				PlayerSeasonDataVO vo=new PlayerSeasonDataVO(rs.getString("season"),
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
		return list;
	}
	
	
	private ArrayList<PlayerSeasonDataVO> getAllPlayerSeasonData(String season, String type){
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
		 
			 
			String str="SELECT * FROM (SELECT name,season,position,"
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
					+ "FROM player_season_data WHERE season='"+season+"' AND type='"+type+"'"
					+ "GROUP BY season,type,name)as "
					+ "data left join teaminfo on data.name =teaminfo.teamAbb";
			list=getData(str);
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,"pointNum");/*默认以得分排序，返回一个赛季的球员的数据*/
	}
	
	/**************************************************
	 * 
	 ************************************************/
	
	@Override
	public ArrayList<PlayerSeasonDataVO> sort_super(String season, String type,
			String position, String partition, String item, String sign, int num) {
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
		sign=Sign.getSign(sign);
		try {
			 
			String str="SELECT * FROM (SELECT name,"
					+ "position,team,COUNT(*) as match_sum,"
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
					+ "FROM player_season_data WHERE season='"+season+"' "
					+ "AND type='"+type+"' "
					+ " GROUP BY season,type,team HAVING AVG("+item+")"+""+sign+" "+num+") as "
					+ "data right join teaminfo as info on data.team =info.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
	
			char chr=39;
			while(rs.next()){
				System.out.println("球员： "+rs.getString("name")+"  得分："+rs.getString("point_sum"));
				list.add(new PlayerSeasonDataVO(season,rs.getString("name"),null,
						rs.getString("teamAbb"),rs.getString("division"),
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

	
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season, String type,
			String name) {
		 
		 
		try {
			  
			String str="SELECT name,division,partition,position,"
					+ "teamAbb,SUM(matchNum) as match_num, "
					+ "SUM(startingNum) as start_num,SUM(time) as time_sum,"
					+ "SUM(fieldGoal) as fieldGoal_sum,SUM(shootNum) as shoot_sum,"
					+ "SUM(t_fieldGoal) as t_fieldGoal_sum,SUM(t_shootNum)as t_shoot_sum,"
					+ "SUM(freeThrowGoal) as freeThrowGoal_sum,"
					+ "SUM(freeThrowNum) as freeThrow_sum,"
					+ "SUM(o_ReboundNum) as o_rebound_sum,SUM(d_reboundNum)as d_rebound_sum,"
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block-sum,"
					+ "SUM(tunrnoverNum) as turnover_sum,SUM(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,"
					+ "AVG(efficiency) as eff,AVG(blockEfficiency)as blockEff,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(reboundEfficiency) as reboundEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,"
					+ "AVG(usingPercentage) as usingPct,"
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
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return new PlayerSeasonDataVO(season, name,new PlayerInfoVO(name, "??","??","??"
				, "??","??", 0, 0,"??","??"), "??", "??", "??", "??",
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
	
	private ArrayList<PlayerSeasonDataVO> sort_position(
			ArrayList<PlayerSeasonDataVO>list,String position){
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

	
	private ArrayList<SingleMatchPersonalDataVO> get_A_season_records(String season,
			String name) {
		ArrayList<SingleMatchPersonalDataVO> list=new ArrayList<>();
		 
		try {
			 
			String str="SELECT * FROM (SELECT * FROM "
					+ "palyer_season_data where season='"+currentSeason+"' AND name='"+name+"') as "
					+ "data right join teaminfo as info on data.team =info.team";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				
				list.add( new SingleMatchPersonalDataVO(rs.getString("season"), 
						rs.getString("date"),rs.getString("name"),
						rs.getString("team"),rs.getString("division"),
						rs.getString("partition"), rs.getString("position"),
						rs.getDouble("time"),rs.getInt("fieldGoal"),
						rs.getInt("shootNum"), rs.getInt("t_fieldGoal"),
						rs.getInt("t_shootNum"),rs.getInt("freeTrowGoal"),
						rs.getInt("freeTrowNum"),rs.getInt("o_ReboundNum"),
						rs.getInt("d_ReboundNum"),rs.getInt("reboundNum"),
						rs.getInt("assistNum"),rs.getInt("stealNum"),
						rs.getInt("blockNum"),rs.getInt("tunoverNum"), 
						rs.getInt("foulNum"),rs.getInt("pointNum"), 
						rs.getDouble("assistEffiency"),rs.getInt("reboundEfficiency"),
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
	public ArrayList<SingleMatchPersonalDataVO> getLastFiveMatchData(
			String name) {
		ArrayList<SingleMatchPersonalDataVO> list=get_A_season_records(currentSeason, name);
		ArrayList<SingleMatchPersonalDataVO> result=new ArrayList<>();
		
		int count=0;
		for(int i=0;i<list.size();i++){
			result.add(list.get(i));
			count++;
			if(count==5)
				break;			
		}	
		return list;
	}

	
	public static void main(String args[]){
		PlayerController pl=new PlayerController();
		//ArrayList<PlayerInfoVO> infoList=pl.getTeamAllPlayer("14-15", "LAL");
		/*
		for(int i=0;i<infoList.size();i++){
			System.out.println("name:"+infoList.get(i).getName());
		}*/
		//ArrayList<PlayerSeasonDataVO> list=pl.getAllPlayerSeasonData("13-14", "常规赛");
		
		ArrayList<PlayerSeasonDataVO> list=pl.getAPlayerSeasonData("林书豪","常规赛");
		
		//ArrayList<PlayerSeasonDataVO> list=pl.sort_super("14-15", "常规赛","前锋","东部","pointNum", "≥",25);
		for(int i=0;i<list.size();i++){
			System.out.println("id:"+(1+i)+"   name:"+list.get(i).getName() +"  points:"+list.get(i).getPointNum());
		}
		
	}

	
	@Override
	public double[] getPlayerOneData(String name, int num, String item) {
		
		double list[]=null;
		ResultSet rs=null;
		try {
			 
			String sqlStr="SELECT COUNT(*) AS num FROM player_season_data"
					+ " where name='"+name+"' AND season='"+currentSeason+"'";
			rs=stmt.executeQuery(sqlStr);
			int n=rs.getInt("num");
			
			
			if(num>n){
				num=n;
			}
			
			list=new double[num];
			list=addValue(list,num);
	        conn.commit();
			
			String str="SELECT "+item+" FROM palyer_season_data where "
					+ " name='"+name+"' AND season='"+currentSeason+"'";
			 rs=stmt.executeQuery(str);
			char chr=39;
			
			int count=0;
			
			while(rs.next()){
				list[count]=rs.getDouble(item);
				if(count==num){
					break;
				}
			}
			 conn.commit();
		} catch (SQLException e) {
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
	
	
	
	@Override
	public ArrayList<SingleMatchPersonalDataVO> getASeasonMatchData(String name,
			String season) {
		return get_A_season_records(season,name);
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item) {
		 
		/*****************************************
		 *获取最后一天有比赛的某一个项目的热点球员 
		 * */
		ArrayList<SingleMatchPersonalDataVO> list=new ArrayList<>();
		 
		try {
			 
			String str="SELECT * FROM "
					+ "player_season_data where date='"+lastDate+"' ORDER BY '"+item+"'";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				
				list.add( new SingleMatchPersonalDataVO(rs.getString("season"), 
						rs.getString("date"),rs.getString("name"),
						rs.getString("team"),rs.getString("division"),
						rs.getString("partition"), rs.getString("position"),
						rs.getDouble("time"),rs.getInt("fieldGoal"),
						rs.getInt("shootNum"), rs.getInt("t_fieldGoal"),
						rs.getInt("t_shootNum"),rs.getInt("freeTrowGoal"),
						rs.getInt("freeTrowNum"),rs.getInt("o_ReboundNum"),
						rs.getInt("d_ReboundNum"),rs.getInt("reboundNum"),
						rs.getInt("assistNum"),rs.getInt("stealNum"),
						rs.getInt("blockNum"),rs.getInt("tunoverNum"), 
						rs.getInt("foulNum"),rs.getInt("pointNum"), 
						rs.getDouble("assistEffiency"),rs.getInt("reboundEfficiency"),
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
	public ArrayList<PlayerSeasonDataVO> getAPlayerSeasonData(String name,
			String type) {
		/********************************************
		 * 获取球员所有赛季的数据
		 * ****************************************/
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
		try {
		 
			String str="SELECT * FROM (SELECT name,season,position,"
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
					+ "FROM player_season_data where type='"+type+"' AND name='"+name+"'"
					+ "GROUP BY season,type,season)as "
					+ "data left join teaminfo as info on data.team =info.teamAbb";
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
				PlayerSeasonDataVO vo=new PlayerSeasonDataVO(rs.getString("season"),rs.getString("name"),null,
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
		return list;
	}

	@Override
	public PlayerInfoVO getAPlayerInfo(String name) {
			for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getEname().equals(name)){
				return infoList.get(i);
					}
			}
			
			return new PlayerInfoVO(name, "??", "??", "??", "??", "??", 0, 0, "??", name);
	}

	@Override
	public PlayerSeasonDataVO getAPlayerSeasonData(String season, String type,
			String name) {
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
		try {
			 
			String str="SELECT * FROM (SELECT player.name,division,partition,position,"
					+ "teamAbb,COUNT(*) as match_sum, "
					+ "SUM(startingNum) as start_num,SUM(time) as time_sum,"
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
					+ "FROM player_season_data,playerinfo WHERE name='"+name+"' AND type='"+type+"'"
					+ "and season='"+season+"' GROUP BY season,type)as "
					+ "data right join playerinfo as info on data.name =info.name";
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
				PlayerSeasonDataVO vo=new PlayerSeasonDataVO(rs.getString("season"),rs.getString("name"),null,
						rs.getString("team"),rs.getString("division"),
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
						rs.getDouble("blockEff"),rs.getInt("double_sum"),
						rs.getInt("three_sum"),
						null);
				return vo;
				 
			}
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return null;
	}
	
	private PlayerSeasonDataVO  addImproveData(PlayerSeasonDataVO vo,String season,String name){
		
		if(vo.getMatchNum()<=5){
			return vo;
		}
		
		 
		try {
			  
			String str="SELECT COUNT(*) as match_sum, "
					+ "SUM(assistNum)as assist_sum,SUM(stealNum) as steal_sum,"
					+ "SUM(reboundNum)as rebound_sum,SUM(blockNum)as block_sum,"
					+ "SUM(pointNum)as point_sum FROM "
					+ "(SELECT name,"
					+ " assistNum,stealNum,"
					+ " reboundNum ,blockNum ,pointNum ,"
					+ "FROM player_season_data,playerinfo WHERE name='"+name+"' "
					+ "and season='"+season+"')as "
					+ "new_data";
			ResultSet  rs=stmt.executeQuery(str);
			 
			
			char chr=39;
			int rebound_rate=0;
			int point_rate=0;
			int assist_rate=0;
			int num=0;
			
			int rebound_sum=0;
			int assist_sum=0;
			int point_sum=0;
			
			while(rs.next()){
				rebound_sum=rs.getInt("rebound_sum");
				assist_sum=rs.getInt("assist_sum");
				point_sum=rs.getInt("point_sum");
				break; 
			}
			 
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		
		return vo;
	}
	

}
