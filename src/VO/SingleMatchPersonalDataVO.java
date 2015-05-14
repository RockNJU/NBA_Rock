package VO;

import java.io.Serializable;

public class SingleMatchPersonalDataVO implements Serializable{
	
	/**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private String season;					//赛季
	 private String date;					//比赛日期
	 private String playerName;				//球员姓名
	 private String playerReverseName;       //球员姓名的反置
	 private String division;		 //球员目前所效力球队所在的分区
	 private String partition;		 //球员所效力球队所在的赛区
	 private String playerPosition;			//球员位置
	 private double time;					//球员上场时间
	 private int fieldGoal;					//进球数
	 private int shootNum;					//投篮总数
	 private int t_fieldGoal;				//三分进球数
	 private int t_shootNum;				//三分投射数
	 private int freeThrowGoalNum;			//罚篮进球数
	 private int freeThrowNum;				//罚篮总数
	 private int o_ReboundNum;				//进攻篮板数
	 private int d_ReboundNum;				//防守篮板数
	 private int reboundNum;				//篮板总数
	 private int assistNum;				    //助攻数
	 private int stealNum;					//抢断数
	 private int blockNum;					//盖帽数
	 private int turnoverNum;				//失误数
	 private int pointNum;					//得分
	 private int foulNum;					//犯规数
	 
		private double shootEfficiency=0 ;		//投篮效率
		private double assistEfficiency;        //助攻率__
		private double reboundEfficiency;       //篮板率__
		private double offensiveReboundEff;     //进攻篮板率__
		private double defenseReboundEff;     	//防守篮板率__
		private double stealEfficiency;			//抢断率__
		private double turnoverPercentage=0;    //失误率
		private double usingPercentage=0;         //使用率__
		private double realShootPercentage =0;			//真实投篮命中率
		private double blockEfficiency=0;			//盖帽率__
		private double gmSc;
		
		private String teamName;                  //本场比赛所效力的球队
	 
	 public SingleMatchPersonalDataVO(String season,String date,String name,String team,
			 String division,String partition,String p,double time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int steal,int blockNum,int turnoverNum,
			 int foulNum,int points, double assistEfficiency,
			 double reboundEfficiency,double offensiveReboundEff,
			 double defenseReboundEff,double stealEfficiency,
			 double usingPercentage,double blockEfficiency){
		 this.teamName=team;
		 this.season=season;
		 this.date=date;
		 this.playerName=name;
		 if(name.trim().contains(" ")){
				String str[]=name.split(" ");
				this.playerReverseName=str[1]+" "+str[0];
				}else{
					this.playerReverseName=name;
				}
		 this.division=division;
		 this.partition=partition;
		 
		 this.playerPosition=p;
		 this.time=time;
		 this.fieldGoal=fieldGoal;
		 this.shootNum=shootNum;
		 this.t_fieldGoal=T_fieldGoal;
		 this.t_shootNum=T_shootNum;
		 this.freeThrowGoalNum=freeThrowGoalNum;
		 this.freeThrowNum=freeThrowNum;
		 this.o_ReboundNum=O_R_N;
		 this.d_ReboundNum=D_R_N;
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
		 
		   if(shootNum!=0){
			   /*(投篮命中数+0.5×三分命中数)÷投篮出手数*/
			   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
		 // 
		  }
		   
		   if((shootNum+0.44*freeThrowNum)!=0){
			   realShootPercentage=(double)points/(2*(shootNum+0.44*freeThrowNum));
		   }
		 // assistEfficiency;        
			//  reboundEfficiency;       
			 // offensiveReboundEff;   
			  //stealEfficiency;			
		   turnoverPercentage=(double)turnoverNum/((shootNum-T_shootNum)+0.44*
				   freeThrowNum+turnoverNum); 
		   
			  //usingPercentage;    
			  gmSc=points+fieldGoal*0.4-0.7*shootNum-
					  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*o_ReboundNum+0.3*d_ReboundNum
					  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
		 
		 
	 }

	 
	 public String getTeamName(){
		 return teamName;
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
		return t_fieldGoal;
	}

	public int getT_shootNum() {
		return t_shootNum;
	}

	public int getFreeThrowGoalNum() {
		
		return freeThrowGoalNum;
	}

	public int getFreeThrowNum() {
		return freeThrowNum;
	}

	public int getO_ReboundNum() {
		return o_ReboundNum;
	}

	public int getD_ReboundNum() {
		return d_ReboundNum;
	}

	 

	public int getAssistNum() {
		return assistNum;
	}
 

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

 
	
	public double getThreePointPercentage(){
		if(t_shootNum==0)
			return 0;
		else
			return (double)t_fieldGoal/t_shootNum;
	}
	 
	public double getShootPercentage() {
		if(shootNum==0)
			return 0;
		else
			return (double)fieldGoal/shootNum;
	}
	 
	public double getShootEfficiency() {
		return shootEfficiency;
	}
	 
	public double getGmSc() {
		return gmSc;
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

	public double getTurnoverPercentage() {
		return turnoverPercentage;
	}

	public double getUsingPercentage() {
		return usingPercentage;
	}

	public double getRealShootPercentage() {
		return realShootPercentage;
	}

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


	public String getDivision() {
		return division;
	}

	public String getPartition() {
		return partition;
	}

	public String getPlayerReverseName(){
		return playerReverseName;
	}


	public int getReboundNum() {
		return reboundNum;
	}


	public int getStealNum() {
		return stealNum;
	}


	public int getBlockNum() {
		return blockNum;
	}


	public int getPointNum() {
		return pointNum;
	}

	 

}
