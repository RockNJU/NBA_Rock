package bl_db.playerbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.Player_Avg;
import VO.SingleMatchPersonalDataVO;
import bl_db.common.EndDayInfo;
import bl_db.common.HotSort;
import bl_db.common.Sign;
import bl_db.teamrbl.Player_info;
import businessService.blservice.PlayerBLService;

public class Player implements PlayerBLService,Player_info{
	String url="jdbc:mysql://localhost/mysql";
    String user="ghl";
    String pwd="ghl13";		
    
    String currentSeason;
    String lastDate;
	
	ArrayList<PlayerInfoVO> infoList;
	
	   Connection conn ;
	     Statement stmt ;
	
	
	public Player(){
		EndDayInfo info=new EndDayInfo();
		try{
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  conn = DriverManager.getConnection(url,user, pwd);
		       stmt = conn.createStatement();
		       conn.setAutoCommit(false);
			}catch(Exception e){
				System.out.println("���ݿ����ӳ���"+e.toString());
			}
		infoList=new ArrayList<>();
		readBasicInfo();
		currentSeason=info.getCurrentSeason();
		
		System.out.println("���췽���У���ǰ������"+ currentSeason);
		lastDate=info.getLastDay();
	}
	
	
	
	private void readBasicInfo(){
		/*
		 * ���ڻ�ȡ��ǰʱ������Ա���µĻ�����Ϣ
		 * 
		 * */			  
			try {
				 
				String str="select * from playerinfo";
				ResultSet  rs=stmt.executeQuery(str);
				char chr=39;
				while(rs.next()){
					/*String name,String num,String p,String height,
			String weight,String birth,int age ,int exp
			,String school,String Ename*/
					
					infoList.add(new PlayerInfoVO(rs.getString("name").replace('��', chr),
							rs.getString("number"), rs.getString("position"),
							rs.getString("height"),rs.getString("weight"),rs.getString("birth"),
		    			  rs.getInt("age"),rs.getInt("exp"),
		    			  rs.getString("school").replace('��', chr),rs.getString("Ename")));
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
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
		String str="SELECT * FROM (SELECT *FROM player_data WHERE "
				+ "season='"+season+"')as "
				+ "data left join teaminfo on data.team =teaminfo.teamAbb";
			list=get_Data(str);
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,sortItem);/*Ĭ���Ե÷����򣬷���һ����������Ա������*/
		
	}
	
	@Override
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season) {
		
		ArrayList<PlayerSeasonDataVO> list= getAllPlayerSeasonData(season, "��ǰ��");
		list.addAll(getAllPlayerSeasonData(season, "������"));
		list.addAll(getAllPlayerSeasonData(season, "������"));
		return list;
	}
	
	@Override
	public ArrayList<PlayerSeasonDataVO> keyfind(String text) {
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
			String str="SELECT * FROM player_data as "
					+ "data left join teaminfo on data.team =teaminfo.teamAbb";
		list=get_Data(str);
		ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getInfo().getName().contains(text)|
					list.get(i).getInfo().getEname().contains(text)|
					list.get(i).getInfo().getHeight().contains(text)|
					list.get(i).getInfo().getNumber().contains(text)|
					list.get(i).getInfo().getPosition().contains(text)|
					list.get(i).getInfo().getSchool().contains(text)|
					list.get(i).getInfo().getBirth().contains(text)){
			result.add(list.get(i));
			}
		}
		return result;
		
	}

	
	public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,
			String teamAbb) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		try {
			
			//String ss="SELECT DISTINCT name from player_season_data where season='"+season+"' AND team='"+teamAbb+"'";
			
			String str="SELECT * from playerinfo where name "
					+ "in (SELECT DISTINCT name from player_season_data "
					+ "where season='"+season+"' AND team='"+teamAbb+"') ";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				list.add(new PlayerInfoVO(rs.getString("name").replace('��', chr),
						rs.getString("number"), rs.getString("position"),
						rs.getString("height"),rs.getString("weight"),rs.getString("birth"),
	    			  rs.getInt("age"),rs.getInt("exp"),
	    			  rs.getString("school").replace('��', chr),rs.getString("Ename")));
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
 * @return   ��ȡĳ��������  ĳ����Ա��ĳ�����ݵ��ܺ�
 */
	private	String getType(String date){
		String str[]=date.split("-");
		if(str[2].compareTo("04")>0){
			return "������";
		}else{
			return "������";
		}
			
	}
	
	
	@Override
	public ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item) {
		  
			
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
			String str="SELECT * FROM (SELECT *FROM player_data WHERE "
					+ "season='"+currentSeason+"' and type='"+getType(lastDate)+"')as "
					+ "data left join teaminfo on data.team =teaminfo.teamAbb";
		list=get_Data(str);
	HotSort sort=new HotSort();
	return sort.hotPlayer_Sort(list,item);/*Ĭ���Ե÷����򣬷���һ����������Ա������*/ 
	}

	 
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem) {
		ArrayList<PlayerSeasonDataVO> list= getAllPlayerSeasonData(currentSeason,"������");
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,sortItem);
	}

	
	public ArrayList<PlayerSeasonDataVO> get_Data(String sqlStr){
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();	 
		try {
			ResultSet  rs=stmt.executeQuery(sqlStr);
		
			 
			while(rs.next()){
				//System.out.println("name:  "+rs.getString("name"));
				PlayerSeasonDataVO vo=new PlayerSeasonDataVO(rs.getString("season"),rs.getString("type"),
						rs.getString("name"),getAPlayerInfo(rs.getString("name")),
						rs.getString("teamAbb"),rs.getString("division"),
						rs.getString("partition"),rs.getString("position"),
						rs.getInt("matchNum"),rs.getInt("startingNum"),
						rs.getDouble("time"),rs.getInt("fieldGoal"),
						rs.getInt("shootNum"),rs.getInt("t_fieldGoal"),
						rs.getInt("t_shootNum"),rs.getInt("freeThrowGoal"),
						rs.getInt("freeThrowNum"),rs.getInt("o_reboundNum"),
						rs.getInt("d_reboundNum"),rs.getInt("reboundNum"),
						rs.getInt("assistNum"),rs.getInt("stealNum"),
						rs.getInt("blockNum"),rs.getInt("turnoverNum"),
						rs.getInt("foulNum"),rs.getInt("pointNum"),
						rs.getDouble("assistEfficiency"),rs.getDouble("reboundEfficiency"),
						rs.getDouble("o_reboundEfficiency"),rs.getDouble("d_reboundEfficiency"),
						rs.getDouble("stealEfficiency"),rs.getDouble("usingPercentage"),
						rs.getDouble("blockEfficiency"),rs.getInt("seasonDoubleNum"),
						rs.getInt("seasonThreeNum"),
						null);;
						vo.setL_f_assist_rate(rs.getDouble("l_f_assist_rate"));
						vo.setL_f_point_rate(rs.getDouble("l_f_point_rate"));
						vo.setL_f_rebound_rate(rs.getDouble("l_f_rebound_rate"));
				
				
				list.add(vo);
			}
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return list;
	}

/*****************************************************************************
 * ���°���type�Ĳ��ֶ��ǵ�����Ҫ�����ģ�type��Ϊ�������ͣ��Σ£��ĳ������ͼ���������ǰ����
 ****************************************************************************/
	
	
	private ArrayList<PlayerSeasonDataVO> getAllPlayerSeasonData(String season, String type){
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
 
		String str="SELECT * FROM (SELECT *FROM player_data WHERE "
				+ "season='"+season+"' AND type='"+type+"')as "
				+ "data left join teaminfo on data.team =teaminfo.teamAbb";
			list=get_Data(str);
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,"pointNum");/*Ĭ���Ե÷����򣬷���һ����������Ա������*/
	}
	
	/**************************************************
	 * 
	 ************************************************/
	
	@Override
	public ArrayList<PlayerSeasonDataVO> sort_super(String season, String type,
			String position, String partition, String item, String sign, int num) {
		ArrayList<PlayerSeasonDataVO> list=getAllPlayerSeasonData( season, type);
		 list=sort_position(list,position);
		 list=sort_partition(list,partition);
		HotSort sort=new HotSort();
		list=sort.hotPlayer_Sort(list,item);
		return list;
	}

	@Override
	public ArrayList<PlayerInfoVO> getPlayerInfoByFirstChar(String firstchar) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getEname().startsWith(firstchar)){
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
		if(!partition.equals("���з���")){
			if(partition.equals("����")|partition.equals("����")){
				list=sort_division(list,partition);
			}else{
			list=sort_partition(list,partition);
			}
		}
		
		
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list,item);
	}

	/*
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season, String type,
			String name) {
		 
		 PlayerSeasonDataVO vo=new PlayerSeasonDataVO(season, "??",name,new PlayerInfoVO(name, "??","??","??"
				, "??","??", 0, 0,"??","??"), "??", "??", "??", "??",
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
		try {
			  
			String str="SELECT * FROM (SELECT name,season,type,position,"
					+ "l_f_assist_rate,l_f_rebound_rate,l_f_point_rate,"
					+ "team,COUNT(*) as match_sum, "
					+ "startingNum as start_sum,time as time_sum,"
					+ "fieldGoal as fieldGoal_sum,shootNum as shoot_sum,"
					+ "t_fieldGoal as t_fieldGoal_sum,t_shootNum as t_shoot_sum,"
					+ "freeThrowGoal  as freeThrowGoal_sum,"
					+ "freeThrowNum  as freeThrow_sum,"
					+ "o_ReboundNum  as o_rebound_sum,"
					+ "d_reboundNum as d_rebound_sum,"
					+ "assistNum as assist_sum,stealNum as steal_sum,"
					+ "reboundNum as rebound_sum,blockNum as block_sum,"
					+ "turnoverNum as turnover_sum,foulNum as foul_sum,"
					+ "pointNum as point_sum,"
					+ "AVG(efficiency) as eff,AVG(blockEfficiency)as blockEff,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(reboundEfficiency) as reboundEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(usingPercentage) as usingPct,"
					
					+ "seasonDoubleNum as double_sum,seasonThreeNum as three_sum "
					+ "FROM player_season_data WHERE season='"+season+"' AND type='"+type+"')as"
					+ "data left join teaminfo on data.team =teaminfo.teamAbb)";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			
			while(rs.next()){
				vo= new PlayerSeasonDataVO(season,rs.getString("type"),rs.getString("name"),
						getAPlayerInfo(rs.getString("name")),
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
				vo.setL_f_assist_rate(rs.getDouble("l_f_assist_rate"));
				vo.setL_f_point_rate(rs.getDouble("l_f_point_rate"));
				vo.setL_f_rebound_rate(rs.getDouble("l_f_rebound_rate"));
			}
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		 
		return vo;
	}
*/
	
	/******************************************
	 * 
	 *************************************/
	private  ArrayList<PlayerSeasonDataVO> sort_division(ArrayList<PlayerSeasonDataVO>list,
			String division) {
		 /*������ɸѡ*/
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
		/*����ط��д�˼��*/
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
		if(!partition.equals("���з���")){
			if(partition.equals("����")|partition.equals("����")){
				list=sort_division(list,partition);
			}else{
			list=sort_partition(list,partition);
			}
		}
		
		HotSort sort=new HotSort();
		return sort.hotPlayer_Sort(list, condition, reverse);
	}


	@Override
	public ArrayList<PlayerInfoVO> getPlayerInfo(String text) {
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getName().contains(text)|
					infoList.get(i).getEname().contains(text)|
					infoList.get(i).getHeight().contains(text)|
					infoList.get(i).getNumber().contains(text)|
					infoList.get(i).getPosition().contains(text)|
					infoList.get(i).getSchool().contains(text)|
					infoList.get(i).getBirth().contains(text)){
				list.add(infoList.get(i));
				;
			}
		}
		return list;
		 //�����ݿ���û�ж�Ӧ��Ա�Ļ�������ʱ������һ����ʾδ֪����Ϣ
	}

	
	private ArrayList<SingleMatchPersonalDataVO> get_A_season_records(String season,
			String name) {
		ArrayList<SingleMatchPersonalDataVO> list=new ArrayList<>();
		try {
			 
			String str="SELECT * FROM (SELECT * FROM "
					+ "player_season_data where season='"+season+"' AND name='"+name+"' order by date desc) as "
					+ "data left join teaminfo as info on data.team =info.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				//System.out.println("name:::"+rs.getString("name"));
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
	public ArrayList<SingleMatchPersonalDataVO> getLastFiveMatchData(
			String name) {
		ArrayList<SingleMatchPersonalDataVO> list=get_A_season_records(currentSeason, name);
		ArrayList<SingleMatchPersonalDataVO> result=new ArrayList<>();
		
		int num=list.size();
		
		if(num>5){
			num=5;
		}
		
		int count=0;
		for(int i=0;i<num;i++){
			result.add(list.get(i));
			if(count==5){
				break;			
			}	
			count++;
		}
		return result;
	}

	
	public static void main(String args[]){
		PlayerBLService pl=new Player();
		//ArrayList<PlayerInfoVO> infoList=pl.getTeamAllPlayer("14-15", "LAL");
		/*
		for(int i=0;i<infoList.size();i++){
			System.out.println("name:"+infoList.get(i).getName());
		}*/
	ArrayList<SingleMatchPersonalDataVO> list=pl.getLastFiveMatchData("�����");
		  PlayerSeasonDataVO vo=pl.get_Avg_PlayerSeasonData("14-15", "������");
		  System.out.println("name:"+vo.getPointNum());
		/* ArrayList<PlayerInfoVO> infoList=pl.getTeamAllPlayer("14-15","GSW");
		 for(int i=0;i<list.size();i++){
				System.out.println("name:"+list.get(i).getPlayerName()+"  :"+list.get(i).getDate()+  "   "+i);
			}*/
		 
		 // System.out.println("na*****me��"+pl.getPlayerOneData("�����", 10, "pointNum").length);
		 
		 //ArrayList<SingleMatchPersonalDataVO> list=pl.getTodayHotPlayer("pointNum");
		// System.out.println("vlidt...  :"+list.size());
		 
		/*   ArrayList<PlayerSeasonDataVO> list=pl.getSeasonHotPlayer("14-15", "pointNum");
		//ArrayList<SingleMatchPersonalDataVO> volist=pl.getASeasonMatchData("�����","14-15");
		
		System.out.println("��С��"+list.size());
		//ArrayList<PlayerSeasonDataVO> list=pl.getAllPlayerSeasonData("14-15","������");
		for(int i=0;i<list.size();i++){
			System.out.println("id:"+(1+i)+"   name:"+list.get(i).getName() 
					+"  points:"+list.get(i).getPointNum()+
					"  partition:"+list.get(i).getPartition()+"  :");
		} */
		
		
		/*ArrayList<PlayerInfoVO> list=pl.getPlayerInfoByFirstChar("A");;*/
		System.out.println("size��"+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("name: "+list.get(i).getPlayerName()+
					" position:"+list.get(i).getPartition());
			}
		double[] aa=pl.getPlayerOneData("�Ʊ�-��������",20, "pointNum");
		System.out.println("�Ʊȵĵ÷֣�"+aa[0]);
	}

	
	@Override
	public double[] getPlayerOneData(String name, int num, String item) {
		
		double list[]=null;
		ResultSet rs=null;
		
		//System.out.println("��ǰ������"+currentSeason);
		try {
			 
			String sqlStr="SELECT COUNT(*) AS num FROM player_season_data "
					+ "where name='"+name+"' AND season='"+currentSeason+"'";
			rs=stmt.executeQuery(sqlStr);
			int n=0;
			while(rs.next()){
				n=rs.getInt("num");
				//System.out.println("while��----"+n);
				break;
			}
			
			System.out.println("----"+n);
			 
			
			list=new double[num];
			list=addValue(list,num);
	        conn.commit();
			
			String str="SELECT "+item+" FROM player_season_data where "
					+ " name='"+name+"' AND season='"+currentSeason+"'";
			 rs=stmt.executeQuery(str);
			char chr=39;
			
			int count=0;
			if(num!=10&num!=20&num!=30){
				num=n;
				list=new double[num];
			}
			while(rs.next()){
				if(count==num){
					break;
				}
				//System.out.println("Ҫ�õ�����Ŀ  ��"+);
				list[count]=rs.getDouble(item);
				if(count==num){
					break;
				}
				count++;
			}
			 conn.commit();
		} catch (SQLException e) {
			System.out.println("����ԭ�� "+e.toString());
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
		 *��ȡ���һ���б�����ĳһ����Ŀ���ȵ���Ա 
		 * */
		//System.out.println("���һ�죻������"+lastDate);
		ArrayList<SingleMatchPersonalDataVO> list=new ArrayList<>();
		 
		try {
			 
			String str="SELECT* FROM(SELECT * FROM "
					+ "player_season_data where date='"+lastDate+"')as "
					+ "data left join teaminfo on data.team =teaminfo.teamAbb";
			ResultSet  rs=stmt.executeQuery(str);
			char chr=39;
			while(rs.next()){
				//System.out.println("name***:"+rs.getString("name"));
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
		HotSort sort=new HotSort();
		list=sort.hotSinglePlayer_Sort(list, item);
		return list;
		
	}

	@Override
	public ArrayList<PlayerSeasonDataVO> getAPlayerSeasonData(String name,
			String type) {
		/********************************************
		 * ��ȡ��Ա��������������
		 * ****************************************/
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		 
		  
		 
			String str="SELECT * FROM (SELECT *FROM player_data WHERE name='"+name+"'"
					+ " AND type='"+type+"' order by season desc)as "
					+ "data left join teaminfo on data.team =teaminfo.teamAbb";
			list=get_Data(str);
		return list;
	}

	@Override
	public PlayerInfoVO getAPlayerInfo(String name) {
			for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getEname().equals(name)||
					infoList.get(i).getName().equals(name)){
				return infoList.get(i);
					}
			}
			
			return new PlayerInfoVO(name, "??", "??", "??", "??", "??", 0, 0, "??", name);
	}

	@Override
	public PlayerSeasonDataVO getAPlayerSeasonData(String season, String type,
			String name) {
			PlayerSeasonDataVO vo=null;
		 
			String str="SELECT * FROM (SELECT *FROM player_data WHERE season='"+season+"' AND name='"+name+"' "
				+ "AND type='"+type+"')as "
					+ "data left join teaminfo on data.team =teaminfo.teamAbb";
/******************
 * 
 *************************/
			ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();	 
			try {
				ResultSet  rs=stmt.executeQuery(str);
			
				 
				while(rs.next()){
				System.out.println("name:  "+rs.getString("name"));
					 vo=new PlayerSeasonDataVO(rs.getString("season"),rs.getString("type"),
							rs.getString("name"),getAPlayerInfo(rs.getString("name")),
							rs.getString("teamAbb"),rs.getString("division"),
							rs.getString("partition"),rs.getString("position"),
							rs.getInt("matchNum"),rs.getInt("startingNum"),
							rs.getDouble("time"),rs.getInt("fieldGoal"),
							rs.getInt("shootNum"),rs.getInt("t_fieldGoal"),
							rs.getInt("t_shootNum"),rs.getInt("freeThrowGoal"),
							rs.getInt("freeThrowNum"),rs.getInt("o_reboundNum"),
							rs.getInt("d_reboundNum"),rs.getInt("reboundNum"),
							rs.getInt("assistNum"),rs.getInt("stealNum"),
							rs.getInt("blockNum"),rs.getInt("turnoverNum"),
							rs.getInt("foulNum"),rs.getInt("pointNum"),
							rs.getDouble("assistEfficiency"),rs.getDouble("reboundEfficiency"),
							rs.getDouble("o_reboundEfficiency"),rs.getDouble("d_reboundEfficiency"),
							rs.getDouble("stealEfficiency"),rs.getDouble("usingPercentage"),
							rs.getDouble("blockEfficiency"),rs.getInt("seasonDoubleNum"),
							rs.getInt("seasonThreeNum"),
							null);;
							vo.setL_f_assist_rate(rs.getDouble("l_f_assist_rate"));
							vo.setL_f_point_rate(rs.getDouble("l_f_point_rate"));
							vo.setL_f_rebound_rate(rs.getDouble("l_f_rebound_rate"));
					
					
					 
				}
				  conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//
		
		return vo;
	}



	@Override
	public String getEnglishName(String chinesename) {
		String result=chinesename;
		String str="SELECT Ename FROM playerinfo where name='"+chinesename+"'";
		try {
			ResultSet  rs=stmt.executeQuery(str);
		
			 
			while(rs.next()){	
				result=rs.getString("Ename");
				break;
			}
			  conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
	
		return result;
	}



	@Override
	public PlayerSeasonDataVO get_Avg_PlayerSeasonData(String season,
			String type) {
		PlayerSeasonDataVO vo=null;
		try {
			 
			String str=" SELECT type,"
					+ "avg(time) as time_sum,SUM(matchNum)as match_sum,"
					+ "avg(fieldGoal) as fieldGoal_sum,avg(shootNum) as shoot_sum,"
					+ "avg(t_fieldGoal) as t_fieldGoal_sum,avg(t_shootNum)as t_shoot_sum,"
					+ "avg(freeThrowGoal) as freeThrowGoal_sum,"
					+ "avg(freeThrowNum) as freeThrow_sum,"
					+ "avg(o_ReboundNum) as o_rebound_sum,"
					+ "avg(d_reboundNum)as d_rebound_sum,"
					+ "avg(assistNum)as assist_sum,avg(stealNum) as steal_sum,"
					+ "avg(reboundNum)as rebound_sum,avg(blockNum)as block_sum,"
					+ "avg(turnoverNum) as turnover_sum,avg(foulNum)as foul_sum,"
					+ "SUM(pointNum)as point_sum,"
					+ "AVG(efficiency) as eff,AVG(blockEfficiency)as blockEff,"
					+ "AVG(assistEfficiency)as assistEff,"
					+ "AVG(reboundEfficiency) as reboundEff,"
					+ "AVG(o_reboundEfficiency) as o_reboundEff,"
					+ "AVG(d_reboundEfficiency) as d_reboundEff,"
					+ "AVG(stealEfficiency) as stealEff,AVG(usingPercentage) as usingPct,"
					
					+ "SUM(seasonDoubleNum) as double_sum,SUM(seasonThreeNum) as three_sum "
					+ "FROM player_data WHERE type='"+type+"'"
					+ "and season='"+season+"' GROUP BY season,type";
			ResultSet  rs=stmt.executeQuery(str);

			
			while(rs.next()){
			vo=new PlayerSeasonDataVO(season,rs.getString("type"),
						"paly_avg",getAPlayerInfo("�����"),
						"--","--",
						"--","--",rs.getInt("match_sum")
						,25,
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
			  
				 
			}
			 conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		return vo;
	}

}
