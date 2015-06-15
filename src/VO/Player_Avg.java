package VO;

import java.util.ArrayList;

public class Player_Avg {

	/**
	 * 
	 */
	
	String season;					 //����
	String type;
	private String name;					 //��Ա����
	private String reverseName;            //��Ա��������
	
	private int age;					//���䣬Ϊ��������ӵ�����
	
	PlayerInfoVO info;
	
	private String teamName;		 //���������,Ϊ��ӵ���д
	private String league;		 //��ԱĿǰ��Ч��������ڵķ���
	private String partition;		 //��Ա��Ч��������ڵ�����
	private String position;	     //����λ��
	private int matchNum;		 	 //��������
	private int startingNum;	     //�׷�����
	 
	   private double time;		    //����ʱ��
	  private double time_avg;       //����ƽ��ʱ��
	 
	    int fieldGoal; 					 //Ͷ��������
		double fieldGoal_avg;
		int shootNum; 				     //Ͷ��������
		double shootNum_avg;
		int t_fieldGoal; 				 //����������
		double t_fieldGoal_avg;
		int t_shootNum; 				 //���ֳ�����
		double t_shootNum_avg;
		int freeThrowGoalNum; 			 //����������
		double freeThrowGoalNum_avg;
		int freeThrowNum; 				 //��������
		double freeThrowNum_avg;
		int o_ReboundNum; 				 //����������
		double o_ReboundNum_avg;
		int d_ReboundNum; 				 //����������
		double d_ReboundNum_avg;
		int assistNum;					 //������
		double assistNum_avg;
		int stealNum; 					 //������
		double stealNum_avg;
		int reboundNum; 				 //������
		double reboundNum_avg;
		int blockNum; 					 //��ñ��
		double blockNum_avg;
		int turnoverNum; 			     //ʧ����
		double turnoverNum_avg;
		int foulNum; 					 //������
		double foulNum_avg;
		int pointNum; 					 //�÷�
		double pointNum_avg;
	 
	private double efficiency; 		 //Ч��
	private double blockEfficiency;	 //��ñЧ��	 
	
	private double freeThrowPercentage;		//����������
	private double shootPercentage;			//Ͷ��������
	private double t_shootPercentage;		//������������
	
	private double shootEfficiency;		    //Ͷ��Ч��
	
	private double assistEfficiency;        //������
	private double reboundEfficiency;       //������
	private double offensiveReboundEff;     //����������
	private double defenseReboundEff;	    //����������
	private double stealEfficiency;			//������
	private double turnoverPercentage;      //ʧ����
	private double usingPercentage;         //ʹ����
	
	private double assistEfficiency_avg;        //������
	private double reboundEfficiency_avg;       //������
	private double offensiveReboundEff_avg;     //����������
	private double defenseReboundEff_avg;	    //����������
	private double stealEfficiency_avg;			//������
	private double usingPercentage_avg;         //ʹ����
	private double blockEfficiency_avg;	 //����Ч��
	private double realShootPercentage=0;	//��ʵͶ��������
	private double gmSc;				    //GmScЧ��ֵ
	private int seasonDoubleNum;		    //������˫��
	private int seasonThreeNum;  		    //������˫��
	
	private ArrayList<SingleMatchPersonalDataVO> last_five_match_data; //����峡����������
	
	private double l_f_point_rate=0;         //����峡�÷ֵ�������
	private double l_f_assist_rate=0; 		//����峡������������
	private double l_f_rebound_rate=0;		//����峡�����������
	
	public Player_Avg(String season,String type,String name,
			PlayerInfoVO info,String teamName,
			String division,String partition,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,
		 int freeThrowNum,int O_R_N,int D_R_N,int reboundNum,
		 int assistNum,int stealNum,int blockNum,int turnoverNum,
		 int foulNum,int points,
		                           double assistEfficiency,
		 double reboundEfficiency,double offensiveReboundEff,
		 double defenseReboundEff,double stealEfficiency,
		 double usingPercentage,double blockEfficiency,int doubleNum,
		 int threeNum,SingleMatchPersonalDataVO firstMatch){
				
				this.season=season;
				this.name=name;
				this.type=type;
				//this.age=info.getAge();
					if(name!=null){
				String str[]=name.trim().split(" ");
				if(str.length>1){
					//System.out.println("-----");
					this.reverseName=str[1]+" "+str[0];
				}else{
					this.reverseName=name;
				}
					}
				this.info=info;
				this.teamName=teamName;
			
				this.league=division;
				this.partition=partition;
				this.position=info.getPosition();
				this.matchNum=matchNum;
				this.startingNum=startingNum;
				this.time=time;
				this.blockNum=blockNum;
				
				this.freeThrowGoalNum=freeThrowGoalNum;
				this.freeThrowNum=freeThrowNum;
				this.blockEfficiency=blockEfficiency;
				this.reboundNum=reboundNum;
				this.o_ReboundNum=O_R_N;
				 this.d_ReboundNum=D_R_N;
				this.assistNum=assistNum;
				this.turnoverNum=turnoverNum;
				this.stealNum=stealNum;
				this.foulNum=foulNum;
				this.pointNum=points;
				
				this.shootNum=shootNum;
				this.t_shootNum=T_shootNum;
				this.fieldGoal=fieldGoal;
				this.t_fieldGoal=T_fieldGoal;
				/***************************************/
				 time_avg=time/matchNum;
				 fieldGoal_avg=(double)fieldGoal/matchNum;				    
				 shootNum_avg=(double)shootNum/matchNum;
				  t_fieldGoal_avg=(double)t_fieldGoal/matchNum;
				  t_shootNum_avg=(double)t_shootNum/matchNum;
				  freeThrowGoalNum_avg=(double)freeThrowGoalNum/matchNum;
				  freeThrowNum_avg=(double)freeThrowNum/matchNum;		 
				  o_ReboundNum_avg=(double)o_ReboundNum/matchNum;	 
				  d_ReboundNum_avg=(double)d_ReboundNum/matchNum;		 
				  assistNum_avg=(double)assistNum/matchNum;		 
				  stealNum_avg=(double)stealNum/matchNum;	 
				  reboundNum_avg=(double)reboundNum/matchNum;	 
				  blockNum_avg=(double)blockNum/matchNum;		 
				  turnoverNum_avg=(double)turnoverNum/matchNum;		 
				  foulNum_avg=(double)foulNum/matchNum;
				  pointNum_avg=(double)pointNum/matchNum;
				  /*****************************/
				
				this.assistEfficiency=assistEfficiency;
				this.reboundEfficiency=reboundEfficiency;
				this.offensiveReboundEff=offensiveReboundEff;
				this.defenseReboundEff=defenseReboundEff;
				this.stealEfficiency=stealEfficiency;
				this.usingPercentage=usingPercentage;
				
				this.seasonDoubleNum=doubleNum;
				this.seasonThreeNum=threeNum;	
				
				gmSc=pointNum+fieldGoal*0.4-0.7*shootNum-
						  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*o_ReboundNum+0.3*d_ReboundNum
						  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
				
				/*  ��ʵͶ�������ʣ� �÷֡�(2��(Ͷ��������+0.44�����������))*/
				if((shootNum+0.44*freeThrowNum)!=0)
				realShootPercentage=pointNum/(2*(shootNum+0.44*freeThrowNum));
				
				
				 if(shootNum!=0){
					   
					   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
				 // 
				  }else{
					  shootEfficiency=0;
				  }
				//////////////////*
				 
				  
						 efficiency=  pointNum+reboundNum+assistNum+stealNum+blockNum-
						   (shootNum-fieldGoal)  -(freeThrowNum-freeThrowGoalNum)-turnoverNum ;
					 
				   
				     assistEfficiency_avg=assistEfficiency;        //������
					  reboundEfficiency_avg=reboundEfficiency;       //������
					  offensiveReboundEff_avg=offensiveReboundEff;     //����������
					  defenseReboundEff_avg=defenseReboundEff;	    //����������
					  stealEfficiency_avg=stealEfficiency;			//������
					  blockEfficiency_avg=blockEfficiency;
					  usingPercentage_avg=usingPercentage;         //ʹ����
					  
					      if(freeThrowNum!=0)
					    freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;		//����������
					      if(shootNum!=0)
						 shootPercentage=(double)fieldGoal/shootNum;			//Ͷ��������
					      if(T_shootNum!=0)
						  t_shootPercentage=(double)T_fieldGoal/T_shootNum;		//������������
					      
					      if((shootNum-T_shootNum)!=0){	  
					 		 turnoverPercentage=(double)turnoverNum/((shootNum-T_shootNum)+0.44*
					 				   (double)freeThrowNum/matchNum+(double)turnoverNum/matchNum);
					 		 }else{ 
					 			 turnoverPercentage=0.44*(freeThrowNum+turnoverNum)/matchNum;
					 		 }
					      
	}
	

	
	
	public String getName(){
		
		return name;
	}
	public String getTeamName() {
		return teamName;
	}
	
	public String getType(){
		return type;
	}
	public String getPosition(){
		return position;
	}
	
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getMatchNum() {
		return matchNum;
	}
	
	public int getStartingNum() {
		return startingNum;
	}
	 
 
	public double getL_f_point_rate(){
	  return l_f_point_rate;
   }
	
	public double getL_f_assist_rate(){
		  return l_f_assist_rate;
	  }
	  
	public double getL_f_rebound_rate(){
		  return l_f_rebound_rate;
	  }
	

	 
	public double getFreeThrowPercentage() {
		 
		return freeThrowPercentage;
		 
	}
	 
 
	
	public double getT_shootPercentage(){
		return t_shootPercentage;  //��ȡ������������
	}
	public double getShootPercentage() {
		return shootPercentage;
	}
 
  


	public int getDoubleNum() {
		return seasonDoubleNum;
	}



	public int getThreeNum() {
		return seasonThreeNum;
	 
	}


	public String getSeason() {
		return season;
	}

 
	public int getSeasonDoubleNum() {
		return seasonDoubleNum;
	}


	public String getDivision() {
		return league;
	}


	public void setDivision(String division) {
		this.league = division;
	}

	public String getPartition() {
		return partition;
	}
	
	public void setPartition(String partition) {
		this.partition = partition;
	}




	public double getTime() {
		return time_avg;
	}


 


	public double getFieldGoal() {
		return fieldGoal_avg;
	}


 

	public double getShootNum() {
		return shootNum_avg;
	}

 
	public double getT_fieldGoal() {
		return t_fieldGoal_avg;
	}




	public double getT_shootNum() {
		return t_shootNum_avg;
	}

 

	public double getFreeThrowGoalNum() {
		return freeThrowGoalNum_avg;
	}


 

	public double getO_ReboundNum() {
		return o_ReboundNum_avg;
	}



	public double getD_ReboundNum() {
		return d_ReboundNum_avg;
	}

 

	public double getAssistNum() {
		return assistNum_avg;
	}

 
	public double getStealNum() {
		return stealNum_avg;
	}

	public double getReboundNum() {
		return reboundNum_avg;
	}

	public double getBlockNum() {
		return blockNum_avg;
	}

	public double getTurnoverNum() {
		return turnoverNum_avg;
	}

 
	public double getFoulNum() {
		return foulNum_avg;
	}
 
	public double getPointNum() {
		return pointNum_avg;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public double getShootEfficiency() {
		return shootEfficiency;
	}

	public double getTurnoverPercentage() {
		return turnoverPercentage;
	}



	public double getGmSc() {
		return gmSc;
	}



	public int getSeasonThreeNum() {
		return seasonThreeNum;
	}

	public void setPosition(String position) {
		this.position = position;
	}



	public PlayerInfoVO getInfo() {
		return info;
	}



	public String getReverseName() {
		return reverseName;
	}



 


	public double getFreeThrowNum() {
		return freeThrowNum_avg;
	}



	public double getAssistEfficiency() {
		return assistEfficiency_avg;
	}



	public double getReboundEfficiency() {
		return reboundEfficiency_avg;
	}



	public double getOffensiveReboundEff() {
		return offensiveReboundEff_avg;
	}



	public double getDefenseReboundEff() {
		return defenseReboundEff_avg;
	}



	public double getStealEfficiency() {
		return stealEfficiency_avg;
	}



	public double getUsingPercentage_avg() {
		return usingPercentage_avg;
	}



	public double getBlockEfficiency_avg() {
		return blockEfficiency_avg;
	}



	public int getAge() {
		return age;
	}



	public String getLeague() {
		return league;
	}




	public void setL_f_point_rate(double l_f_point_rate) {
		this.l_f_point_rate = l_f_point_rate;
	}




	public void setL_f_assist_rate(double l_f_assist_rate) {
		this.l_f_assist_rate = l_f_assist_rate;
	}




	public void setL_f_rebound_rate(double l_f_rebound_rate) {
		this.l_f_rebound_rate = l_f_rebound_rate;
	}
}
