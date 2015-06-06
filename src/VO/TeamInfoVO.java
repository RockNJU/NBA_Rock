package VO;

import java.io.Serializable;

public class TeamInfoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 
 
	 * 
	 * */
	private String city;
	private String TEname;			 
	private String team;             
	private String location;			 
	private String  division;			 
	private String partition;			 
	private String homeGround;			 
	private String formedTime;
	private String caoch_name;
	private String caoch_Ename;
	private String teamAbb;

	public TeamInfoVO(String city,String team,String TEname,
			String location,String division,String partition,
			String home,String time,String caoch_name,
			String caoch_Ename,String teamAbb){
		this.teamAbb=teamAbb;
		this.city=city;
		this.team=team;
		this.location=location;
		this.division=division;
		this.partition=partition;
		this.homeGround=home;
		this.formedTime=time;
		this.caoch_name=caoch_name;
		this.caoch_Ename=caoch_Ename;
		
	}

	public String getTeamAbb(){
		return teamAbb;
	}
	public String getLocation() {
		return location;
	}

	public String getDivision() {
		return division;
	}

	public String getPartition() {
		return partition;
	}

	public String getHomeGround() {
		return homeGround;
	}

	public String getFormedTime() {
		return formedTime;
	}


	public String getCity() {
		return city;
	}


	public String getTEname() {
		return TEname;
	}


	public String getTeam() {
		return team;
	}


	public String getCaoch_name() {
		return caoch_name;
	}


	public String getCaoch_Ename() {
		return caoch_Ename;
	}
}
