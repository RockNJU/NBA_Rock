package VO;

public class Team_Avg {
	/**
	 * 
	 */
	 
	/* 
	 * ע�����������У�����׺_avg,��ƽ��ֵ�����������������е����µ�������������ͨ��get�������
	 */
 
	String season;					 //����
	String teamAbb; 				 //�����д
	private String fullName; 				 //���ȫ��
	private TeamInfoVO info;
	
	private String league;          //������ˣ�����ʾ�Ǵ��ڶ�����������
	private String partition;       //����������������磬����������
	
	int matchNum; 				     //�ѱ�������
	int winNum;						 //ʤ������
	double winRate;					//����ʤ��
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
	
	double shootPercentage; 		 //ȫ�ӵ�Ͷ��������
	double t_shootPercentage; 	     //ȫ�ӵ�������������
	double freeThrowPercentage; 	 //ȫ�ӵķ���������
	
	double offenseRound;
	double offenseRound_avg;
	
	private double defenseRound;   			//���ػغ�����
	private double defenseRound_avg=0;
	double offenseEfficiency = 0; 	
	double offenseEfficiency_avg;
	double defenseEfficiency = 0;
	double defenseEfficiency_avg;
	double stealEfficiency = 0; 
	double stealEfficiency_avg;
	double assistEfficiency = 0;
	double assistEfficiency_avg;
	private double o_ReboundEfficiency =0; 
	double offensiveReboundEff_avg;
	private double d_ReboundEfficiency =0;
	double defenseReboundEff_avg;
 

    	
	public Team_Avg(String season,String teamName,
			TeamInfoVO info,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,
	int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,
	double D_ReboundEfficiency,double stealEfficiency ,
	double assistEfficiency,TeamMatchVO first_match){
		this.o_ReboundEfficiency=O_ReboundEfficiency;
		this.d_ReboundEfficiency=D_ReboundEfficiency;
		this.season=season;
		this.teamAbb = teamName; 
		 this.info=info;
		//this.league=info.getDivision();
		this.partition=info.getPartition();
		this.fullName=info.getTeamAbb();
		 
		this.matchNum = matchNum ; 
		this.winNum = winNum;
		this.fieldGoal = fieldGoal ;  
		this.shootNum = shootNum ;  
		this.t_fieldGoal = T_fieldGoal ;  
		this.t_shootNum = T_shootNum ; 
		this.freeThrowGoalNum =  freeThrowGoalNum;  
		this.freeThrowNum = freeThrowNum;  
		this.o_ReboundNum = O_ReboundNum ;  
		this.d_ReboundNum =  D_ReboundNum;  
		this.assistNum =  assistNum;  
		this.stealNum = stealNum ;  
		this.reboundNum = reboundNum ; 
		this.blockNum = blockNum ;  
		this.turnoverNum = turnoverNum ;  
		this.foulNum = foulNum ;  
		this.pointNum = points ;  
		winRate=winNum;
		
		this.shootPercentage =  (double)fieldGoal/shootNum;  
		this.t_shootPercentage =(double)T_fieldGoal/T_shootNum ; 
		this.freeThrowPercentage = (double)freeThrowGoalNum/freeThrowNum ;  
		 
		this.offenseRound = offenseRound ;  
		
		this.offenseEfficiency = offenseEfficiency;  
		this.defenseEfficiency = defenseEfficiency;  
		
		this.stealEfficiency = stealEfficiency;  
		this.assistEfficiency = assistEfficiency;  
		
		this.o_ReboundEfficiency = O_ReboundEfficiency; 
		this.d_ReboundEfficiency = D_ReboundEfficiency;
		
		
		 /////////////////////
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
		  
		  //////
		   defenseRound_avg=defenseRound;
		   offenseEfficiency_avg=offenseEfficiency;
         defenseEfficiency_avg=defenseEfficiency;
        stealEfficiency_avg=stealEfficiency;
         assistEfficiency_avg=assistEfficiency;
		  offensiveReboundEff_avg=O_ReboundEfficiency;
		 defenseReboundEff_avg=D_ReboundEfficiency;
		
	}
	

	
	public String getSreason(){
		return season;
	}
	
	public String getTeamName() {
		return teamAbb;
	}

	 
 
	
	public int getMatchNum(){
		return matchNum;
	}
	
	public int getWinNum(){
		return winNum;
	}

	

	public double getWinRate(){
		return winRate;
	}
	 
		
		
		
		
	
		public String getSeason() {
			return season;
		}


		 

		public double getFieldGoal() {
			return fieldGoal_avg;
		}


		 

		public double getShootNum() {
			return shootNum_avg;
		}
 

		public double getT_fieldGoal_avg() {
			return t_fieldGoal_avg;
		}


		 


		public double getT_shootNum() {
			return t_shootNum_avg;
		}

 


		public double getFreeThrowNum() {
			return freeThrowNum_avg;
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


		public double getT_shootPercentage() {
			return t_shootPercentage;
		}

 

		public double getOffenseRound() {
			return offenseRound_avg;
		}


		public double getDefenseRound() {
			return defenseRound_avg;
		}


		public double getOffenseEfficiency() {
			return offenseEfficiency_avg;
		}


		 


		public double getDefenseEfficiency() {
			return defenseEfficiency_avg;
		}


		public double getStealEfficiency() {
			return stealEfficiency_avg;
		}


	 


		public double getAssistEfficiency() {
			return assistEfficiency_avg;
		}


	 


		public double getO_ReboundEfficiency() {
			return offensiveReboundEff_avg;
		}


		 


		public double getD_ReboundEfficiency() {
			return defenseReboundEff_avg;
		}


		public void setTeamName(String teamName) {
			this.teamAbb = teamName;
		}


		public TeamInfoVO getInfo() {
			return info;
		}

 

		public double getFreeThrowPercentage() {
			return freeThrowPercentage;
		}


		 

		public double getShootPercentage() {
			return shootPercentage;
		}


		public double getFreeThrowGoalNum_avg() {
			// TODO Auto-generated method stub
			return freeThrowGoalNum_avg;
		}


		public double getDefenseRound_avg() {
			return defenseRound_avg;
		}


		public double getOffenseEfficiency_avg() {
			return offenseEfficiency_avg;
		}


		public double getDefenseEfficiency_avg() {
			return defenseEfficiency_avg;
		}


		public double getStealEfficiency_avg() {
			return stealEfficiency_avg;
		}


		public double getAssistEfficiency_avg() {
			return assistEfficiency_avg;
		}


		public double getO_ReboundEfficiency_avg() {
			return offensiveReboundEff_avg;
		}


		public double getD_ReboundEfficiency_avg() {
			return defenseReboundEff_avg;
		}


		public String getTeamAbb() {
			return teamAbb;
		}


		public String getFullName() {
			return fullName;
		}


		public String getLeague() {
			return league;
		}


		public String getPartition() {
			return partition;
		}
}
