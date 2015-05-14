package VO;

 

 

import java.io.Serializable;

  public class A_player_match_data implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String season;					//赛季
	 private String date;					//比赛日期
	 private String teamAbb;				//所属球队
	 private String playerName;				//球员姓名
	 private String playerPosition;			//球员位置
	 private double time;					//球员上场时间
	 private int fieldGoal;					//进球数
	 private int shootNum;					//投篮总数
	 private int T_fieldGoal;				//三分进球数
	 private int T_shootNum;				//三分投射数
	 private int freeThrowGoalNum;			//罚篮进球数
	 private int freeThrowNum;				//罚篮总数
	 private int O_ReboundNum;				//进攻篮板数
	 private int D_ReboundNum;				//防守篮板数
	 private int reboundNum;				//篮板总数
	 private int assistNum;				    //助攻数
	 private int stealNum;					//抢断数
	 private int blockNum;					//盖帽数
	 private int turnoverNum;				//失误数
	 private int foulNum;					//犯规数
	 private int pointNum;					//得分
	 
		private double assistEfficiency;        //助攻率__
		private double reboundEfficiency;       //篮板率__
		private double offensiveReboundEff;     //进攻篮板率__
		private double defenseReboundEff;     	//防守篮板率__
		private double stealEfficiency;			//抢断率__
		//private double turnoverPercentage=0;    //失误率
		private double usingPercentage=0;       //使用率__
		private double blockEfficiency;			//盖帽率__
		private double GmSc;
	    

	 public  A_player_match_data(String season,String date,
			 String team,String name,
			 String p,double time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,
			 int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,
			 int steal,int blockNum,int turnoverNum,
			 int foulNum,int points, double assistEfficiency,
			 double reboundEfficiency,double offensiveReboundEff,
			 double defenseReboundEff,double stealEfficiency,
			 double usingPercentage,double blockEfficiency){
		 this.season=season;
		 this.date=date;
		 this.teamAbb=team;
		 this.playerName=name;
		 this.playerPosition=p;
		 this.time=time;
		 this.fieldGoal=fieldGoal;
		 this.shootNum=shootNum;
		 this.T_fieldGoal=T_fieldGoal;
		 this.T_shootNum=T_shootNum;
		 this.freeThrowGoalNum=freeThrowGoalNum;
		 this.freeThrowNum=freeThrowNum;
		 this.O_ReboundNum=O_R_N;
		 this.D_ReboundNum=D_R_N;
		 this.reboundNum=reboundNum;
		 this.assistNum=assistNum;
		 this.stealNum=steal;
		 this.blockNum=blockNum;
		 this.turnoverNum=turnoverNum;
		 this.foulNum=foulNum;
		 this.pointNum=points;
		 
		 this.assistEfficiency=assistEfficiency;
		 this.reboundEfficiency=reboundEfficiency;
		 this.offensiveReboundEff=offensiveReboundEff;
		 this.defenseReboundEff=defenseReboundEff;
		 this.stealEfficiency=stealEfficiency;
		 this.usingPercentage=usingPercentage;
		 this.blockEfficiency=blockEfficiency;
		 
		 
		   /*if(shootNum!=0){
			   //(投篮命中数+0.5×三分命中数)÷投篮出手数
			   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
		 // 
		  }
		   
		   if((shootNum+0.44*freeThrowNum)!=0){
			   realShootPercentage=points/(2*(shootNum+0.44*freeThrowNum));
		   }
		 // assistEfficiency;        
			//  reboundEfficiency;       
			 // offensiveReboundEff;   
			  //stealEfficiency;			
		   turnoverPercentage=turnoverNum/((shootNum-T_shootNum)+0.44*
				   freeThrowNum+turnoverNum); */
		   
			  //usingPercentage;    
			  GmSc=points+fieldGoal*0.4-0.7*shootNum-
					  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*O_ReboundNum+0.3*D_ReboundNum
					  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
		 
		 
	 }

	 public String getTeamAbb(){
		 return teamAbb;
	 }
	 
	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public double getTime() {
		return time;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public int getShootNum() {
		return shootNum;
	}

	public int getT_fieldGoal(){
		return T_fieldGoal;
	}

	public int getT_shootNum() {
		return T_shootNum;
	}

	public int getFreeThrowGoalNum() {
		
		return freeThrowGoalNum;
	}

	public int getFreeThrowNum() {
		return freeThrowNum;
	}

	public int getO_ReboundNum() {
		return O_ReboundNum;
	}

	public int getD_ReboundNum() {
		return D_ReboundNum;
	}

	public int getReboundNum() {
		return reboundNum;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public int getPoints(){
		return pointNum;
	}
	public int getStealNum(){
		return stealNum;
	}
	
	public double getThreePointPercentage(){
		if(T_shootNum==0)
			return 0;
		else
			return (double)T_fieldGoal/T_shootNum;
	}
	 
	public double getShootPercentage() {
		if(shootNum==0)
			return 0;
		else
			return (double)fieldGoal/shootNum;
	}
	 /*
	public double getShootEfficiency() {
		return shootEfficiency;
	}*/
	 
	public double getGmSc() {
		return GmSc;
	}

	public String getSeason() {
		return season;
	}

	public String getDate() {
		return date;
	}

	public double getFreeThrowPercentage() {
		if(freeThrowNum==0)
			return 0;
		else
			return (double)freeThrowGoalNum/freeThrowNum;
	}
/*
	public double getTurnoverPercentage() {
		return turnoverPercentage;
	}*/

	public double getUsingPercentage() {
		return usingPercentage;
	}
/*
	public double getRealShootPercentage() {
		return realShootPercentage;
	}*/

	public double getAssistEfficiency() {
		return assistEfficiency;
	}

	public double getReboundEfficiency() {
		return reboundEfficiency;
	}

	public double getOffensiveReboundEff() {
		return offensiveReboundEff;
	}

	public double getDefenseReboundEff() {
		return defenseReboundEff;
	}

	public double getStealEfficiency() {
		return stealEfficiency;
	}

	public double getBlockEfficiency() {
		return blockEfficiency;
	}

}
