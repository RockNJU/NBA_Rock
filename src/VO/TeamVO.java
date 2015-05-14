package VO;

import java.io.Serializable;

public class TeamVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 
	 
	 * 
	 * 
	 * */
	private TeamInfoVO info;				 
	private TeamSeasonDataVO data;		 
	
	public  TeamVO(TeamInfoVO info,TeamSeasonDataVO data){
		this.info=info;
		this.data=data;
	}

	public TeamInfoVO getInfo() {
		return info;
	}

	public TeamSeasonDataVO getData() {
		return data;
	}
}
