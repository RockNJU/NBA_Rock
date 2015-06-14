package VO;

import java.util.ArrayList;
public class PlayerSeasonDataVO {

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
	
	private ArrayList<Integer> last_f_point=new ArrayList<>();
	private ArrayList<Integer> last_f_assist=new ArrayList<>();
	private ArrayList<Integer> last_f_rebound=new ArrayList<>();
	
	private double l_f_point_rate=0;         //����峡�÷ֵ�������
	private double l_f_assist_rate=0; 		//����峡������������
	private double l_f_rebound_rate=0;		//����峡�����������
	
	public PlayerSeasonDataVO(String season,String type,String name,
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
				this.position=position;
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
					      
					      last_five_match_data=new ArrayList<>(); 
					     last_five_match_data.add(firstMatch);
					     last_f_point.add( pointNum );
						 last_f_assist.add(assistNum );
						 last_f_rebound.add(reboundNum);
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
	
	 public void add_A_MatchData(SingleMatchPersonalDataVO vo){
		 
		 matchNum++;
		 time=time+vo.getTime();
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
		 
		 
		 gmSc=(pointNum+fieldGoal*0.4-0.7*shootNum-
				  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*o_ReboundNum+0.3*d_ReboundNum
				  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum)/matchNum;
		 if((shootNum+0.44*freeThrowNum)!=0)
				realShootPercentage=pointNum/(2*(shootNum+0.44*freeThrowNum));
		 
		 if(shootNum!=0){
			   
			   shootEfficiency=(fieldGoal+0.5*t_fieldGoal)/shootNum;
		 // 
		  }else{
			  shootEfficiency=0;
		  }
		 
		 int count=0;
		 if(vo.getPointNum()>=10)
			 count++;
		 if(vo.getReboundNum()>=10)
			 count++;
		 if(vo.getBlockNum()>=10)
			 count++;
		 if(vo.getStealNum()>=10)
			 count++;
		 if(vo.getAssistNum()>=10)
			 count++;
		 
		 if(count==2){
		 seasonDoubleNum++;
		 }else if(count==3){
		 seasonThreeNum++;   //������˫��
		 }
		 
		 if(vo.getPlayerPosition()!=null&vo.getPlayerPosition().length()!=0)
			 startingNum++;
		 
		 
		 
		 assistEfficiency= assistEfficiency+vo.getAssistEfficiency();
		  reboundEfficiency=reboundEfficiency+vo.getReboundEfficiency();
		  offensiveReboundEff=offensiveReboundEff + vo.getOffensiveReboundEff();
		  defenseReboundEff=defenseReboundEff+ vo.getDefenseReboundEff();
		 stealEfficiency=stealEfficiency+vo.getStealEfficiency();
		 usingPercentage=usingPercentage+ vo.getUsingPercentage();
		 blockEfficiency=blockEfficiency+vo.getBlockEfficiency();
		 
		 efficiency= (double)(pointNum+reboundNum+assistNum+stealNum+blockNum-
				   (shootNum-fieldGoal)  -(double)(freeThrowNum-freeThrowGoalNum)-turnoverNum)/matchNum;
		 
		 
		 if(freeThrowNum!=0)
			    freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;		//����������
			      if(shootNum!=0)
				 shootPercentage=(double)fieldGoal/shootNum;			//Ͷ��������
			      if(t_shootNum!=0)
				  t_shootPercentage=(double)t_fieldGoal/t_shootNum;		//������������
		 
		 if(shootNum!=0)
			 shootPercentage=(double)fieldGoal/shootNum ;
		 if(freeThrowNum!=0)
				freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;
		 if(t_shootNum!=0)
				t_shootPercentage=(double)t_fieldGoal/t_shootNum;
		 
		 if(last_f_point.size()<5){
			 last_f_point.add(vo.getPointNum());
			 last_f_assist.add(vo.getAssistNum());
			 last_f_rebound.add(vo.getReboundNum());
			 last_five_match_data.add(vo);
		 }else{
			 
			 last_f_point.remove(0);
			 last_f_assist.remove(0);
			 last_f_rebound.remove(0);
			 
			 last_five_match_data.remove(0);
			 last_five_match_data.add(vo);
			 
			 last_f_point.add(vo.getPointNum());
			 last_f_assist.add(vo.getAssistNum());
			 last_f_rebound.add(vo.getReboundNum());
			 
			  
			 double p_avg=(pointNum-get_last_five_Sum(last_f_point))/matchNum;
			 double a_avg=(assistNum-get_last_five_Sum(last_f_assist))/matchNum;
			 double r_avg=(reboundNum-get_last_five_Sum(last_f_rebound))/matchNum;
			 
			 if(p_avg!=0)
				 l_f_point_rate=(get_last_five_Sum(last_f_point)/5-p_avg)/p_avg;      //���5���÷�������
			 if(a_avg!=0)
				 l_f_assist_rate=(get_last_five_Sum(last_f_assist)/5-a_avg)/a_avg;    //���5������������
			 if(r_avg!=0)
			 	l_f_rebound_rate=(get_last_five_Sum(last_f_rebound)/5-r_avg)/r_avg;  //���5������������
			 
			 
		 }
		 
		 
		 
		 
		 /////////////////////////
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
		  /////////////
		  assistEfficiency_avg=assistEfficiency/matchNum;        //������
		  reboundEfficiency_avg=reboundEfficiency/matchNum;       //������
		  offensiveReboundEff_avg=offensiveReboundEff/matchNum;     //����������
		  defenseReboundEff_avg=defenseReboundEff/matchNum;	    //����������
		  stealEfficiency_avg=stealEfficiency/matchNum;			//������
		  blockEfficiency_avg=blockEfficiency/matchNum;
		  usingPercentage_avg=usingPercentage/matchNum;         //ʹ����
		  
		  if((shootNum-t_shootNum)!=0){	  
		 turnoverPercentage=(double)turnoverNum/((shootNum-t_shootNum)+0.44*
				   (double)freeThrowNum/matchNum+(double)turnoverNum/matchNum);
		 }else{ 
			 turnoverPercentage=0.44*(freeThrowNum+turnoverNum)/matchNum;
		 }
		 
	 }
	 
	private double get_last_five_Sum(ArrayList<Integer> list){
		 int sum=0;
		 for(int i=0;i<list.size();i++){
			 sum=sum+list.get(i);
		 }
		 return sum;
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
		return time;
	}



	public double getTime_avg() {
		return time_avg;
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



	public double getFreeThrowGoalNum_avg() {
		return freeThrowGoalNum_avg;
	}



	public int getFreeThrowNum() {
		return freeThrowNum;
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

	public int getBlockNum(){
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

	public int getFoulNum() {
		return foulNum;
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

	public double getEfficiency() {
		return efficiency;
	}

	public double getShootEfficiency() {
		return shootEfficiency;
	}

	public double getTurnoverPercentage() {
		return turnoverPercentage;
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

	public double getUsingPercentage() {
		return usingPercentage_avg;
	}

	public double getBlockEfficiency() {
		return blockEfficiency_avg;
	}

	public double getRealShootPercentage() {
		return realShootPercentage;
	}

	public double getGmSc() {
		return gmSc;
	}



	public int getSeasonThreeNum() {
		return seasonThreeNum;
	}



	public ArrayList<Integer> getLast_f_point() {
		return last_f_point;
	}



	public ArrayList<Integer> getLast_f_rebound() {
		return last_f_rebound;
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



	public ArrayList<SingleMatchPersonalDataVO> getLast_five_match_data() {
		return last_five_match_data;
	}



	public double getFreeThrowNum_avg() {
		return freeThrowNum_avg;
	}



	public double getAssistEfficiency_avg() {
		return assistEfficiency_avg;
	}



	public double getReboundEfficiency_avg() {
		return reboundEfficiency_avg;
	}



	public double getOffensiveReboundEff_avg() {
		return offensiveReboundEff_avg;
	}



	public double getDefenseReboundEff_avg() {
		return defenseReboundEff_avg;
	}



	public double getStealEfficiency_avg() {
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
