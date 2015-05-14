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
	private String fullName;			 
	private String teamAbb;             
	private String location;			 
	private String  division;			 
	private String partition;			 
	private String homeGround;			 
	private String formedTime;			 
	
	public TeamInfoVO(String fullName,String abb,String location,String d,
			String partition,String home,String time){
		this.fullName=fullName;
		this.teamAbb=abb;
		this.location=location;
		this.division=d;
		this.partition=partition;
		this.homeGround=home;
		this.formedTime=time;
		
		
	}

	public String getFullName() {
		return fullName;
	}

	public String getTeamAbb() {
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
}
