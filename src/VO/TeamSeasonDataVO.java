package VO;
import java.util.ArrayList;

public class TeamSeasonDataVO {
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
	
	private ArrayList<TeamMatchVO> last_five_match;

    	
	public TeamSeasonDataVO(String season,String teamName,TeamInfoVO info,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency,TeamMatchVO first_match){
		
		last_five_match=new ArrayList<>();
		 last_five_match.add(first_match);
		this.season=season;
		this.teamAbb = teamName; 
		this.info=info;
		this.league=info.getDivision();
		this.partition=info.getPartition();
		this.fullName=info.getFullName();
		
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
	     fieldGoal_avg= fieldGoal;				    
		 shootNum_avg= shootNum;
		  t_fieldGoal_avg= T_fieldGoal;
		  t_shootNum_avg= T_shootNum;
		  freeThrowGoalNum_avg= freeThrowGoalNum;
		  freeThrowNum_avg= freeThrowNum;		 
		  o_ReboundNum_avg= O_ReboundNum;	 
		  d_ReboundNum_avg= D_ReboundNum;		 
		  assistNum_avg= assistNum;		 
		  stealNum_avg= stealNum;	 
		  reboundNum_avg= reboundNum;	 
		  blockNum_avg= blockNum;		 
		  turnoverNum_avg= turnoverNum;		 
		  foulNum_avg= foulNum;
		  pointNum_avg= pointNum;
		  
		  //////
		   defenseRound_avg=defenseRound;
		   offenseEfficiency_avg=offenseEfficiency;
         defenseEfficiency_avg=defenseEfficiency;
        stealEfficiency_avg=stealEfficiency;
         assistEfficiency_avg=assistEfficiency;
		  offensiveReboundEff_avg=O_ReboundEfficiency;
		 defenseReboundEff_avg=D_ReboundEfficiency;
		
	}
	

	 public void add_A_Match_Data(TeamMatchVO vo){
		
		 if(last_five_match.size()<5){
			 last_five_match.add(vo);
		 }else{
			 last_five_match.remove(0);
			 last_five_match.add(vo);
		 }
		 
		 matchNum++;
		 offenseRound=offenseRound+vo.getOffenseRound();
		 defenseRound=defenseRound+vo.getDefenseRound();
		 fieldGoal=fieldGoal+vo.getFieldGoal();
		 shootNum=vo.getShootNum()+shootNum;
		 t_fieldGoal=t_fieldGoal+vo.getT_fieldGoal();
		 t_shootNum=t_shootNum+vo.getT_shootNum();
		 freeThrowGoalNum=freeThrowGoalNum+vo.getFreeThrowGoalNum();
		 freeThrowNum=vo.getFreeThrowNum()+freeThrowNum;
		 o_ReboundNum=o_ReboundNum+vo.getO_ReboundNum();
		 d_ReboundNum=d_ReboundNum+vo.getD_ReboundNum();
		 
		 reboundNum=reboundNum+vo.getReboundNum();
		 assistNum=assistNum+vo.getAssistNum();
		 stealNum=stealNum+vo.getStealNum();
		 blockNum=blockNum+vo.getBlockNum();
		 turnoverNum=turnoverNum+vo.getTurnoverNum();
		 
		 foulNum=foulNum+vo.getFoulNum();
		 pointNum=pointNum+vo.getPointNum();
		 winNum=winNum+vo.getWinNum();
		 winRate=(double)winNum/matchNum;
		 
		 
		  shootPercentage=(double)fieldGoal/shootNum; 		 
		  t_shootPercentage=(double)t_fieldGoal/t_shootNum; 	 
		  freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum; 	
			  	
			  
		 offenseEfficiency = offenseEfficiency+vo.getOffenseEfficiency(); 	 
		 defenseEfficiency = defenseEfficiency+vo.getDefenseEfficiency(); 	 
			
 	 
		 stealEfficiency = stealEfficiency+vo.getStealEfficiency(); 	
		 assistEfficiency = assistEfficiency+vo.getAssistEfficiency(); 	 
			 
		 o_ReboundEfficiency = o_ReboundEfficiency+vo.getO_ReboundEfficiency(); 
		 d_ReboundEfficiency = d_ReboundEfficiency+vo.getD_ReboundEfficiency();
		 
		 
		 
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
			   defenseRound_avg=defenseRound/matchNum;
			   offenseEfficiency_avg=offenseEfficiency/matchNum;
              defenseEfficiency_avg=defenseEfficiency/matchNum;
             stealEfficiency_avg=stealEfficiency/matchNum;
             assistEfficiency_avg=assistEfficiency/matchNum;
			  offensiveReboundEff_avg=o_ReboundEfficiency/matchNum;
			 defenseReboundEff_avg=d_ReboundEfficiency/matchNum;
		 
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


		public int getFieldGoal() {
			return fieldGoal;
		}


		public double getFieldGoal_avg() {
			return fieldGoal_avg;
		}


		public int getShootNum() {
			return shootNum;
		}


		public double getShootNum_avg() {
			return shootNum_avg;
		}


		public int getT_fieldGoal() {
			return t_fieldGoal;
		}


		public double getT_fieldGoal_avg() {
			return t_fieldGoal_avg;
		}


		public int getT_shootNum() {
			return t_shootNum;
		}


		public double getT_shootNum_avg() {
			return t_shootNum_avg;
		}


		public int getFreeThrowGoalNum() {
			return freeThrowGoalNum;
		}


	 


		public int getFreeThrowNum() {
			return freeThrowNum;
		}


		public double getFreeThrowNum_avg() {
			return freeThrowNum_avg;
		}


		public int getO_ReboundNum() {
			return o_ReboundNum;
		}


		public double getO_ReboundNum_avg() {
			return o_ReboundNum_avg;
		}


		public int getD_ReboundNum() {
			return d_ReboundNum;
		}


		public double getD_ReboundNum_avg() {
			return d_ReboundNum_avg;
		}


		public int getAssistNum() {
			return assistNum;
		}


		public double getAssistNum_avg() {
			return assistNum_avg;
		}


		public int getStealNum() {
			return stealNum;
		}


		public double getStealNum_avg() {
			return stealNum_avg;
		}


		public int getReboundNum() {
			return reboundNum;
		}


		public double getReboundNum_avg() {
			return reboundNum_avg;
		}


		public int getBlockNum() {
			return blockNum;
		}


		public double getBlockNum_avg() {
			return blockNum_avg;
		}


		public int getTurnoverNum() {
			return turnoverNum;
		}


		public double getTurnoverNum_avg() {
			return turnoverNum_avg;
		}


		public double getFoulNum_avg() {
			return foulNum_avg;
		}


		public int getPointNum() {
			return pointNum;
		}


		public double getPointNum_avg() {
			return pointNum_avg;
		}


		public double getT_shootPercentage() {
			return t_shootPercentage;
		}


		public double getOffenseRound() {
			return offenseRound;
		}


		public double getOffenseRound_avg() {
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


		public ArrayList<TeamMatchVO> getLast_five_match() {
			return last_five_match;
		}


		public double getFreeThrowPercentage() {
			return freeThrowPercentage;
		}


		public int getFoulNum() {
			return foulNum;
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
