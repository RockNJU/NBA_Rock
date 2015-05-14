package VO;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.bl.center.HotSort;

public class MatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String season;					//赛季
	private String date;					//比赛日期
	private String matchScore;				//比赛比分
	private ArrayList<String> scores;		//比赛的每节比分
	
	private TeamMatchVO  hostTeam;			//主队的比赛数据
	private TeamMatchVO  guestTeam;			//客队的比赛数据
	
	public MatchVO(String season,String date,String matchScore,
			ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt){
		this.season=season;
		this.date=date;
		this.matchScore=matchScore;
		this.scores=scores;
		this.hostTeam=ht;
		this.guestTeam=gt;	
	}

	public String getSeason() {
		return season;
	}

	public String getDate() {
		return date;
	}

	public String getMatchScore() {
		return matchScore;
	}

	public ArrayList<String> getScores() {
		return scores;
	}

	public TeamMatchVO getHostTeam() {
		return hostTeam;
	}

	public TeamMatchVO getGuestTeam() {
		return guestTeam;
	}
	private ArrayList<SingleMatchPersonalDataVO> H_sort(String item){
		ArrayList<SingleMatchPersonalDataVO> list=hostTeam.getIndividualData();
		//list.addAll(guestTeam.getIndividualData());
		HotSort sort=new HotSort();
		return sort.hotSinglePlayer_Sort(list, item);	
	}
	
	
	private ArrayList<SingleMatchPersonalDataVO> G_sort(String item){
		ArrayList<SingleMatchPersonalDataVO> list=guestTeam.getIndividualData();
		//list.addAll(guestTeam.getIndividualData());
		HotSort sort=new HotSort();
		return sort.hotSinglePlayer_Sort(list, item);	
	}
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_point(){
		/*获取一场比赛中客队得分王*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("pointNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_rebound(){
		/*获取一场比赛中客队篮板王*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("reboundNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_assist(){
		/*获取一场比赛中客队的助攻王**/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("assistNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_steal(){
		/*获取一场比赛中的客队抢断王*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("stealNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_block(){
		/*获取一场比赛中的客队盖帽王*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("blockNum");
		
		return list.get(0);
	}
	
	///////////////
	public SingleMatchPersonalDataVO get_HostTeam_Highest_point(){
		/*获取一场比赛中主队得分王*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("pointNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_rebound(){
		/*获取一场比赛中主队篮板王*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("reboundNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_assist(){
		/*获取一场比赛中的主队助攻王**/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("assistNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_steal(){
		/*获取一场比赛中的主队抢断王*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("stealNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_block(){
		/*获取一场比赛中的主队盖帽王*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("blockNum");
		
		return list.get(0);
	}
}
