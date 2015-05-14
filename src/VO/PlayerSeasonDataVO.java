package VO;

import java.util.ArrayList;
public class PlayerSeasonDataVO {

	/**
	 * 
	 */
	
	String season;					 //赛季
	private String name;					 //球员姓名
	private String reverseName;            //球员姓名反置
	
	private int age;					//年龄，为测试新添加的属性
	
	PlayerInfoVO info;
	
	private String teamName;		 //所在球队名,为球队的缩写
	private String league;		 //球员目前所效力球队所在的分区
	private String partition;		 //球员所效力球队所在的赛区
	private String position;	     //场上位置
	private int matchNum;		 	 //出场次数
	private int startingNum;	     //首发场数
	 
	   private double time;		    //出场时间
	  private double time_avg;       //出场平均时间
	 
	    int fieldGoal; 					 //投篮命中数
		double fieldGoal_avg;
		int shootNum; 				     //投篮出手数
		double shootNum_avg;
		int t_fieldGoal; 				 //三分命中数
		double t_fieldGoal_avg;
		int t_shootNum; 				 //三分出手数
		double t_shootNum_avg;
		int freeThrowGoalNum; 			 //罚球命中数
		double freeThrowGoalNum_avg;
		int freeThrowNum; 				 //罚球总数
		double freeThrowNum_avg;
		int o_ReboundNum; 				 //进攻篮板数
		double o_ReboundNum_avg;
		int d_ReboundNum; 				 //防守篮板数
		double d_ReboundNum_avg;
		int assistNum;					 //助攻数
		double assistNum_avg;
		int stealNum; 					 //抢断数
		double stealNum_avg;
		int reboundNum; 				 //篮板数
		double reboundNum_avg;
		int blockNum; 					 //盖帽数
		double blockNum_avg;
		int turnoverNum; 			     //失误数
		double turnoverNum_avg;
		int foulNum; 					 //犯规数
		double foulNum_avg;
		int pointNum; 					 //得分
		double pointNum_avg;
	 
	private double efficiency; 		 //效率
	private double blockEfficiency;	 //盖帽效率	 
	
	private double freeThrowPercentage;		//罚球命中率
	private double shootPercentage;			//投篮命中率
	private double t_shootPercentage;		//三分球命中率
	
	private double shootEfficiency;		    //投篮效率
	
	private double assistEfficiency;        //助攻率
	private double reboundEfficiency;       //篮板率
	private double offensiveReboundEff;     //进攻篮板率
	private double defenseReboundEff;	    //防守篮板率
	private double stealEfficiency;			//抢断率
	private double turnoverPercentage;      //失误率
	private double usingPercentage;         //使用率
	
	private double assistEfficiency_avg;        //助攻率
	private double reboundEfficiency_avg;       //篮板率
	private double offensiveReboundEff_avg;     //进攻篮板率
	private double defenseReboundEff_avg;	    //防守篮板率
	private double stealEfficiency_avg;			//抢断率
	private double usingPercentage_avg;         //使用率
	private double blockEfficiency_avg;	 //篮板效率
	private double realShootPercentage=0;	//真实投篮命中率
	private double gmSc;				    //GmSc效率值
	private int seasonDoubleNum;		    //赛季两双数
	private int seasonThreeNum;  		    //赛季三双数
	
	private ArrayList<SingleMatchPersonalDataVO> last_five_match_data; //最近五场比赛的数据
	
	private ArrayList<Integer> last_f_point=new ArrayList<>();
	private ArrayList<Integer> last_f_assist=new ArrayList<>();
	private ArrayList<Integer> last_f_rebound=new ArrayList<>();
	
	private double l_f_point_rate=0;         //最近五场得分的提升率
	private double l_f_assist_rate=0; 		//最近五场助攻的提升率
	private double l_f_rebound_rate=0;		//最近五场篮板的提升率
	
	public PlayerSeasonDataVO(String season,String name,PlayerInfoVO info,String teamName,
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
				
				this.age=info.getAge();
					
				String str[]=name.trim().split(" ");
				if(str.length>1){
					//System.out.println("-----");
					this.reverseName=str[1]+" "+str[0];
				}else{
					this.reverseName=name;
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
				
				/*  真实投篮命中率： 得分÷(2×(投篮出手数+0.44×罚球出手数))*/
				if((shootNum+0.44*freeThrowNum)!=0)
				realShootPercentage=pointNum/(2*(shootNum+0.44*freeThrowNum));
				
				
				 if(shootNum!=0){
					   
					   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
				 // 
				  }else{
					  shootEfficiency=0;
				  }
				//////////////////*
				 time_avg=time;
				 fieldGoal_avg= fieldGoal;				    
				 shootNum_avg= shootNum;
				  t_fieldGoal_avg= T_fieldGoal;
				  t_shootNum_avg= T_shootNum;
				  freeThrowGoalNum_avg= freeThrowGoalNum;
				  freeThrowNum_avg= freeThrowNum;		 
				  o_ReboundNum_avg= o_ReboundNum;	 
				  d_ReboundNum_avg= d_ReboundNum;		 
				  assistNum_avg= assistNum;		 
				  stealNum_avg= stealNum;	 
				  reboundNum_avg= reboundNum;	 
				  blockNum_avg= blockNum;		 
				  turnoverNum_avg= turnoverNum;		 
				  foulNum_avg= foulNum;
				  pointNum_avg= pointNum;
				  
				  
						 efficiency=  pointNum+reboundNum+assistNum+stealNum+blockNum-
						   (shootNum-fieldGoal)  -(freeThrowNum-freeThrowGoalNum)-turnoverNum ;
					 
				   
				     assistEfficiency_avg=assistEfficiency;        //助攻率
					  reboundEfficiency_avg=reboundEfficiency;       //篮板率
					  offensiveReboundEff_avg=offensiveReboundEff;     //进攻篮板率
					  defenseReboundEff_avg=defenseReboundEff;	    //防守篮板率
					  stealEfficiency_avg=stealEfficiency;			//抢断率
					  blockEfficiency_avg=blockEfficiency;
					  usingPercentage_avg=usingPercentage;         //使用率
					  
					      if(freeThrowNum!=0)
					    freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;		//罚球命中率
					      if(shootNum!=0)
						 shootPercentage=(double)fieldGoal/shootNum;			//投篮命中率
					      if(T_shootNum!=0)
						  t_shootPercentage=(double)T_fieldGoal/T_shootNum;		//三分球命中率
					      
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
		 seasonThreeNum++;   //计算三双数
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
			    freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;		//罚球命中率
			      if(shootNum!=0)
				 shootPercentage=(double)fieldGoal/shootNum;			//投篮命中率
			      if(t_shootNum!=0)
				  t_shootPercentage=(double)t_fieldGoal/t_shootNum;		//三分球命中率
		 
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
				 l_f_point_rate=(get_last_five_Sum(last_f_point)/5-p_avg)/p_avg;      //最近5场得分提升率
			 if(a_avg!=0)
				 l_f_assist_rate=(get_last_five_Sum(last_f_assist)/5-a_avg)/a_avg;    //最近5场助攻提升率
			 if(r_avg!=0)
			 	l_f_rebound_rate=(get_last_five_Sum(last_f_rebound)/5-r_avg)/r_avg;  //最近5场篮板提升率
			 
			 
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
		  assistEfficiency_avg=assistEfficiency/matchNum;        //助攻率
		  reboundEfficiency_avg=reboundEfficiency/matchNum;       //篮板率
		  offensiveReboundEff_avg=offensiveReboundEff/matchNum;     //进攻篮板率
		  defenseReboundEff_avg=defenseReboundEff/matchNum;	    //防守篮板率
		  stealEfficiency_avg=stealEfficiency/matchNum;			//抢断率
		  blockEfficiency_avg=blockEfficiency/matchNum;
		  usingPercentage_avg=usingPercentage/matchNum;         //使用率
		  
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
		return t_shootPercentage;  //获取三分球命中率
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

	
}
