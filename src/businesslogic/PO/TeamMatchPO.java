package businesslogic.PO;

import java.util.ArrayList;
public class TeamMatchPO {
	/*
	 * 
	 * ����һ��������һ֧��ӵĳ־û�����
	 * ֻ�ɶ��������޸� 
	 * 
	 * */
	private String season;					//����
	private String teamName;				//�������
	
	private int fieldGoal;					//Ͷ��������
	 private int shootNum;					//Ͷ��������
	 private int T_fieldGoal;				//������������
	 private int T_shootNum;				//�����������
	 private int freeThrowGoalNum;			//����������
	 private int freeThrowNum;				//���������
	 private int O_ReboundNum;				//������ǰ����������
	 private int D_ReboundNum;				//���أ��󳡣�������
	 private int reboundNum;				//��������
	 private int assistNum;				    //������
	 private int stealNum;					//������
	 private int blockNum;					//��ñ��
	 private int turnoverNum;				//ʧ����
	 private int foulNum;					//������
	 private int points;					//�÷�	
	 
	 private double allTime;                //������Ա���ϳ�ʱ�䣬���ڼ����Ա��������
	
	
	private ArrayList<SingleMatchPersonalDataPO> individualData;		//�ó�������������Ա��������Ϣ
	
	public TeamMatchPO(String season,String teamName,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int stealNum,int blockNum,int turnoverNum,
			 int foulNum,int points ,double allTime,ArrayList<SingleMatchPersonalDataPO> individualData){
		 this.season=season;
		 this.teamName= teamName;
		
		 this.allTime=allTime;
		 this.fieldGoal=fieldGoal;
		 this.shootNum=shootNum;
		 this.T_fieldGoal=T_fieldGoal;
		 this.T_shootNum=T_shootNum;
		 this.freeThrowGoalNum=freeThrowGoalNum;
		 this.freeThrowNum=freeThrowNum;
		 this.O_ReboundNum=O_R_N;
		 this.D_ReboundNum=D_R_N;
		 this.reboundNum=reboundNum;
		 this.stealNum=stealNum;
		 this.assistNum=assistNum;
		 this.blockNum=blockNum;
		 this.turnoverNum=turnoverNum;
		 this.foulNum=foulNum;
		 this.points=points;
		 this.individualData= individualData;
		
	}
	
	public String getSeason(){
		return season;
	}
	public String getTeamName() {
		return teamName;
	}
	public int getFieldGoal() {
		return fieldGoal;
	}

	public int getShootNum() {
		return shootNum;
	}

	public int getT_fieldGoal() {
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

	public int getPoints() {
		return points;
	}
	 
	public int getStealNum() {
		return stealNum;
	}
	public ArrayList<SingleMatchPersonalDataPO> getIndividualData() {
		return individualData;
	}

	public double getAllTime() {
		return allTime;
	}
}
