package VO;

import java.io.Serializable;
import java.util.ArrayList;


public class TeamMatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 */
	
	private String season;					//赛季
	private String teamName;				//球队名称
	private int   points; 					// 得分
	private int lost_points;                //一场比赛中的失分
	private String date;                    //比赛日期 
	
	private int  reboundNum; 				// 
	private int O_ReboundNum; 			 
	private int D_ReboundNum; 			 
	private int assistNum; 					 
	private int turnoverNum;			 
	private int stealNum; 			 
	private int foulNum; 				 
	private int fieldGoal; 			 
	private int shootNum; 				 
	private int T_fieldGoal; 			 
	private int T_shootNum;				 
	private int freeThrowGoalNum; 		 
	private int freeThrowNum; 				 
	private int blockNum; 
	
	private double offenseRound; 		 
	private double defenseRound; 			 
	
	

	private double freeThrowPercentage ; 
	private double threePointPercentage ; 
	private double shootPercentage ;  
	private double assistEfficiency ; 	 
	private double O_ReboundEfficiency ; 
	private double D_ReboundEfficiency ;  
	private double stealEfficiency ; 	 
	private double defenseEfficiency;  
	private double offenseEfficiency ; 	 
     
	private int winNum;
	String opp_team;
	private ArrayList<SingleMatchPersonalDataVO> individualData;                        

	public TeamMatchVO(String season,String teamName, int winNum,
			String date,String opp_team,int pointNum,int lost_point,
			int reboundNum, int O_ReboundNum, int D_ReboundNum,
			int assistNum, int turnoverNum, int stealNum, int foulNum,
			int fieldGoal, int shootNum, int T_fieldGoal, int T_shootNum,
			int freeThrowGoalNum, int freeThrowNum, int blockNum,
			double offenseRound, double defenseRound,
			double O_ReboundEfficiency,double D_ReboundEfficiency,
			ArrayList<SingleMatchPersonalDataVO> individualData) {
		
		this.winNum=winNum;
		this.date=date;
		this.opp_team=opp_team;
		this.season=season;
		this.teamName = teamName;
		this.points = pointNum;
		this.reboundNum = reboundNum;
		this.O_ReboundNum = O_ReboundNum;
		this.D_ReboundNum = D_ReboundNum;
		this.assistNum = assistNum;
		this.turnoverNum = turnoverNum;
		this.stealNum = stealNum;
		this.foulNum = foulNum;
		this.fieldGoal = fieldGoal;
		this.shootNum = shootNum;
		this.T_fieldGoal = T_fieldGoal;
		this.T_shootNum = T_shootNum;
		this.freeThrowGoalNum = freeThrowGoalNum;
		this.freeThrowNum = freeThrowNum;
		this.blockNum = blockNum;
		this.offenseRound = offenseRound;
		this.defenseRound = defenseRound;
		this.lost_points=lost_point;
		this.individualData = individualData;

		this.freeThrowPercentage = (double)freeThrowGoalNum/freeThrowNum;  
		this.threePointPercentage = (double)T_fieldGoal/T_shootNum;  
		this.shootPercentage = (double)fieldGoal/shootNum;  
		
		this.assistEfficiency = (double)assistNum/(offenseRound/100);  //每一百个进攻回合，球队的助攻数
		this.O_ReboundEfficiency = O_ReboundEfficiency; 
		this.D_ReboundEfficiency = D_ReboundEfficiency;  
		this.stealEfficiency = stealNum/(defenseRound/100);  
		this.defenseEfficiency = (double)lost_points/(defenseRound/100);  
		this.offenseEfficiency = (double)points/(offenseRound/100);  

	}
	
	
	public String getSeason(){
		return season;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public int getPointNum() {
		return points;
	}

	public void setPointNum(int i) {
		this.points = i;
	}

	public int getReboundNum(){
		return reboundNum;
	}

	public void setReboundNum(int i) {
		this.reboundNum = i;
	}

	public int getO_ReboundNum() {
		return O_ReboundNum;
	}

	public void setO_ReboundNum(int i) {
		this.O_ReboundNum = i;
	}

	public int getD_ReboundNum() {
		return D_ReboundNum;
	}

	public void setD_ReboundNum(int i) {
		this.D_ReboundNum = i;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public void setAssistNum(int i) {
		this.assistNum = i;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public void setTurnoverNum(int i) {
		this.turnoverNum = i;
	}

	public int getStealNum() {
		return stealNum;
	}

	public void setStealNum(int i) {
		this.stealNum = i;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(int i) {
		this.foulNum = i;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public void setFieldGoal(int i) {
		this.fieldGoal = i;
	}

	public int getShootNum() {
		return shootNum;
	}

	public void setShootNum(int i) {
		this.shootNum = i;
	}

	public int getT_fieldGoal() {
		return T_fieldGoal;
	}

	public void setT_fieldGoal(int i) {
		this.T_fieldGoal = i;
	}

	public int getT_shootNum() {
		return T_shootNum;
	}

	public void setT_shootNum(int i) {
		this.T_shootNum = i;
	}

	public int getFreeThrowGoalNum() {
		return freeThrowGoalNum;
	}

	public void setFreeThrowGoalNum(int i) {
		this.freeThrowGoalNum = i;
	}

	public int getFreeThrowNum() {
		return freeThrowNum;
	}

	public void setFreeThrowNum(int i) {
		this.freeThrowNum = i;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(int i) {
		this.blockNum = i;
	}

	public double getOffenseRound() {
		return offenseRound;
	}

	public void setOffenseRound(double d) {
		this.offenseRound = d;
	}

	public double getDefenseRound() {
		return defenseRound;
	}

	public void setDefenseRound(double d) {
		this.defenseRound = d;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(double d) {
		this.freeThrowPercentage = d;
	}

	public double getThreePointPercentage() {
		return threePointPercentage;
	}

	public void setThreePointPercentage(double d) {
		this.threePointPercentage = d;
	}

	public double getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(double d) {
		this.shootPercentage = d;
	}

	public double getAssistEfficiency() {
		return assistEfficiency;
	}

	public void setAssistEfficiency(double d) {
		this.assistEfficiency = d;
	}

	public double getO_ReboundEfficiency() {
		return O_ReboundEfficiency;
	}

	public void setO_ReboundEfficiency(double d) {
		this.O_ReboundEfficiency = d;
	}

	public double getD_ReboundEfficiency() {
		return D_ReboundEfficiency;
	}

	public void setD_ReboundEfficiency(double d) {
		this.D_ReboundEfficiency = d;
	}

	public double getStealEfficiency() {
		return stealEfficiency;
	}

	public void setStealEfficiency(double d) {
		this.stealEfficiency = d;
	}

	public double getDefenseEfficiency(){
		return defenseEfficiency;
	}

	public void setDefenseEfficiency(double d) {
		this.defenseEfficiency = d;
	}

	public double getOffenseEfficiency() {
		return offenseEfficiency;
	}

	public void setOffenseEfficiency(double d){
		this.offenseEfficiency = d;
	}


	public ArrayList<SingleMatchPersonalDataVO> getIndividualData() {
		return individualData;
	}


	public String getDate() {
		return date;
	}


	public String getOpp_team() {
		return opp_team;
	}


	public int getWinNum() {
		return winNum;
	}

}
