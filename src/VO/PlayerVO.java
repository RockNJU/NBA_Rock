package VO;

import java.io.Serializable;



public class PlayerVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*  
	 * 
 
	 * 
	 * */
	
	private PlayerInfoVO info;				 
	private PlayerSeasonDataVO data;			 
	
	public PlayerVO(PlayerInfoVO info,PlayerSeasonDataVO data){
		this.info=info;
		this.data=data;
		
	}

	public PlayerInfoVO getInfo() {
		return info;
	}

	public PlayerSeasonDataVO getData() {
		return data;
	}
	
}
