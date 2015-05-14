package VO;

public class MatchInfo {
	/*比赛信息，包含的信息有比赛日期，比赛的两支队伍的缩写*/
	private String date;		//比赛日期，格式xxxx-xx-xx
	private String team_H;		//主队名称
	private String team_G;      //客队名称
	
	public MatchInfo(String date,String teamH,String teamG){
		this.date=date;
		this.team_H=teamH;
		this.team_G=teamG;
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
