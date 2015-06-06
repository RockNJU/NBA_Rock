package VO;

import java.util.ArrayList;

public class MatchInfoVO {
	/*比赛信息，包含的信息有比赛日期，比赛的两支队伍的缩写*/
	
	private String date;		//比赛日期，格式xxxx-xx-xx
	private String time;        //比赛的具体日期。
	private String team_H;		//主队名称
	private String team_G;      //客队名称
	private String score;       //球队比分
	private String type;        //比赛类型，即常规赛还是季后赛
	private String isOver;
	private ArrayList<String> sc; //每小节的比分
	
	
	public MatchInfoVO(String date,String time,String teamH,
			String teamG,String isOver,
			String score,String type,ArrayList<String> cs){
		this.isOver=isOver;
		this.date=date;
		this.time=time;
		this.team_H=teamH;
		this.team_G=teamG;
		this.sc=cs;
		this.score=score;
	}

	
	public String getIsOver(){
		return isOver;
	}
	public String getMatchType(){
		return type;
	}
	public String getScore(){
		return score;
	}
	
	public ArrayList<String> getScores(){
		return sc;
	}
	
	public String getTime(){
		return time;
	} 
	
	public String getDate() {
		return date;
	}

	public String getTeam_H() {
		return team_H;
	}

	public String getTeam_G() {
		return team_G;
	}
}
