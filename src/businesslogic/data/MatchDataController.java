package businesslogic.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import businesslogic.PO.*;
import businesslogic.dataservice.MatchDataService;
import businesslogic.shareeclass.FileList;



public class MatchDataController implements MatchDataService{
		/**
		 * 
		 * 
		 * **/
	private ArrayList<MatchPO> matchList;
	
	Date day;
	String match_path;
	int info[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	public MatchDataController(String path){
		this.match_path=path;
		matchList=new ArrayList<>();
		day=new Date();
		//readObject();
	}
	
	public static void main(String args[]){
		MatchDataController c=new MatchDataController("");
		 //MatchPO  po=c.getMatch("NBAdata\\matches\\12-13_11-11_ATL-LAC");
		ArrayList<MatchPO> m=c.getAllMatch();
		int i=0;
		 
		/* System.out.println(po.getDate()+";"+po.getHostTeam().getTeamName()+
				 	";"+po.getGuestTeam().getTeamName()+";"+po.getScores().toString()+"---"+(1+i));
		 */
	    MatchPO po;
		for(i=0;i<m.size();i++){
			po=m.get(i);
			 if(po.getScores().size()>4)
				 System.out.println(po.getDate()+"_"+po.getHostTeam().getTeamName()+
					 	"_"+po.getGuestTeam().getTeamName()+"_"+po.getScores().toString()+"---"+(1+i));
			 
		} 
	}
	
	
	@Override
	public ArrayList<MatchPO> getAllMatch() {
		// TODO Auto-generated method stub
		readObject();
		return matchList;
	}

	@Override
	public MatchPO getMatch(String filepath) {
		// TODO Auto-generated method stub
		//String file="NBAdata/matches/"+"13-14_"+date+"_"+teams;
		
		
		/*
		 * 
		 * */
		//System.out.println("新添加的文件路劲："+filepath);
		 String[]path=filepath.split("\\\\");
	        String s[]=path[path.length-1].split("_");
	         
	        String date=s[1];
	       String season=s[0];
	       
	       double H_allTime=0;
	       double G_allTime=0;
	 	//System.out.println("---------"+path.length);
        File f = new File(filepath);  
        String encoding="UTF-8";
		
		try{ 
        	//BufferedReader br = new BufferedReader(new FileReader(new File(l))); 
        
        	InputStreamReader read = new InputStreamReader(
                    new FileInputStream(f),encoding);
        	BufferedReader br = new BufferedReader(read); 	
        	String  line ;

         					 
         String matchScore="";				 
         ArrayList<String> scores=new ArrayList<String>();	
        String H_team="";
        String G_team="";
        
        ArrayList<SingleMatchPersonalDataPO> H_teamData=new ArrayList<SingleMatchPersonalDataPO> ();
        ArrayList<SingleMatchPersonalDataPO> G_teamData=new ArrayList<SingleMatchPersonalDataPO> ();
        
        int H_fieldGoal=0;					//投篮命中数
	   	   int H_shootNum=0;					//投篮出手数
	   	   int H_T_fieldGoal=0;				//三分球命中数
	   	   int H_T_shootNum=0;				//三分球出手数
	   	   int H_freeThrowGoalNum=0;			//罚球命中数
	   	   int H_freeThrowNum=0;				//罚球出手数
	   	   int H_O_ReboundNum=0;				//进攻（前场）篮板数
	   	   int H_D_ReboundNum=0;				//防守（后场）篮板数
	   	   int H_reboundNum=0;				//总篮板数
	   	   int H_assistNum=0;				    //助攻数
	   	   int H_stealNum=0;					//抢断数
	   	   int H_blockNum=0;					//盖帽数
	   	   int H_turnoverNum=0;				//失误数
	   	   int H_foulNum=0;					//犯规数
	   	   int H_points=0;					//得分
	   	   
	   	   int G_fieldGoal=0;					//投篮命中数
	   	   int G_shootNum=0;					//投篮出手数
	   	   int G_T_fieldGoal=0;				//三分球命中数
	   	   int G_T_shootNum=0;				//三分球出手数
	   	   int G_freeThrowGoalNum=0;			//罚球命中数
	   	   int G_freeThrowNum=0;				//罚球出手数
	   	   int G_O_ReboundNum=0;				//进攻（前场）篮板数
	   	   int G_D_ReboundNum=0;				//防守（后场）篮板数
	   	   int G_reboundNum=0;				//总篮板数
	   	   int G_assistNum=0;				    //助攻数
	   	   int G_stealNum=0;					//抢断数
	   	   int G_blockNum=0;					//盖帽数
	   	   int G_turnoverNum=0;				//失误数
	   	   int G_foulNum=0;					//犯规数
	   	   int G_points=0;					//得分
        int num=1;
        boolean isHostTeam=true;
        char chr=39;
        //line=br.readLine();
        	while((line=br.readLine())!=null){
        		line=line.trim();
        		if(num==1){
        		String  str1[]=line.split(";");
        		String  teamNames[]=str1[1].split("-");
        		H_team=teamNames[0];
        		G_team=teamNames[1];
        		date=str1[0];
        		matchScore=str1[2];
        		
        		}else if(num==2){
        		//	System.out.println("--分割比分--"+line);
        			String score[]=line.split(";");
        			for(int i=0;i<score.length;i++)
        			scores.add(score[i]);
        		}
        		else{
        			
        			if(line.length()==3&&num==3){
        	
        				continue;
        			}
        			if(line.length()==3&&num!=3){
        				isHostTeam=false;
        				continue;
        			}
        			if(isHostTeam){
        				String str[]=line.split(";");
        				changeStrToInt(str);
        				/*String name,String p,String time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int stealNum,int blockNum,int turnoverNum,
			 int foulNum,int points*/
        				 H_fieldGoal=H_fieldGoal+info[3];					//投篮命中数
    			   	     H_shootNum=H_shootNum+info[4];					//投篮出手数
    			   	     H_T_fieldGoal=H_T_fieldGoal+info[5];				//三分球命中数
    			   	     H_T_shootNum=H_T_shootNum+info[6];				//三分球出手数
    			   	     H_freeThrowGoalNum=H_freeThrowGoalNum+info[7];			//罚球命中数
    			   	     H_freeThrowNum=H_freeThrowNum+info[8];				//罚球出手数
    			   	     H_O_ReboundNum=H_O_ReboundNum+info[9];				//进攻（前场）篮板数
    			   	     H_D_ReboundNum=H_D_ReboundNum+info[10];				//防守（后场）篮板数
    			   	     H_reboundNum=H_reboundNum+info[11];				//总篮板数
    			   	     H_assistNum=H_assistNum+info[12];				    //助攻数
    			   	     H_stealNum=H_stealNum+info[13];					//抢断数
    			   	     H_blockNum=H_blockNum+info[14];					//盖帽数
    			   	     H_turnoverNum=H_turnoverNum+info[15];				//失误数
    			   	     H_foulNum=H_foulNum+info[16];					//犯规数
    			   	  if(info[17]>=0){
     			   	     H_points=H_points+getPoint(str[16]);					//得分
     			   	     }
     			   	   
     			   	  if(calTime(str[2])>=0){
	        			   	     H_allTime=calTime(str[2])+H_allTime;
	        			   	     }
    			   	     
    			   	    // System.out.println("文件：");
        				H_teamData.add(new SingleMatchPersonalDataPO(str[0].trim(),
        						str[1].trim(),calTime(str[2].trim()),
        						info[3],info[4],info[5],info[6],info[7],info[8],
        						info[9],info[10],info[11],info[12],info[13],info[14]
        						,info[15],info[16],info[17]));
        		
        			}else{
        				String str[]=line.split(";");
        				changeStrToInt(str);
        				G_fieldGoal=G_fieldGoal+info[3];					//投篮命中数
   			   	     G_shootNum=G_shootNum+info[4];					//投篮出手数
   			   	     G_T_fieldGoal=G_T_fieldGoal+info[5];				//三分球命中数
   			   	     G_T_shootNum=G_shootNum+info[6];				//三分球出手数
   			   	     G_freeThrowGoalNum=G_freeThrowGoalNum+info[7];			//罚球命中数
   			   	     G_freeThrowNum=G_freeThrowNum+info[8];				//罚球出手数
   			   	     G_O_ReboundNum=G_O_ReboundNum+info[9];				//进攻（前场）篮板数
   			   	     G_D_ReboundNum=H_D_ReboundNum+info[10];				//防守（后场）篮板数
   			   	     G_reboundNum=G_reboundNum+info[11];				//总篮板数
   			   	     G_assistNum=G_assistNum+info[12];				    //助攻数
   			   	     G_stealNum=G_stealNum+info[13];					//抢断数
   			   	     G_blockNum=G_blockNum+info[14];					//盖帽数
   			   	     G_turnoverNum=G_turnoverNum+info[15];				//失误数
   			   	     G_foulNum=G_foulNum+info[16];	
   			   	     //犯规数
   			   	if(info[17]>=0){
   			   		G_points=G_points+getPoint(str[16]);					//得分
			   	     }
			   	   
			   	  if(calTime(str[2])>=0){
			   		  G_allTime=calTime(str[2])+G_allTime;
   			   	     }		
        				G_teamData.add(new SingleMatchPersonalDataPO(str[0],str[1],calTime(str[2].trim()),
        						info[3],info[4],info[5],info[6],info[7],info[8],
        						info[9],info[10],info[11],info[12],info[13],info[14]
        						,info[15],info[16],info[17]));
        			}
        			
        		}
        		num++;
        }
        	 
			        	      return new MatchPO(season,day.getDate(season, date),matchScore,scores,
			        			(new TeamMatchPO(season,H_team,H_fieldGoal,H_shootNum,H_T_fieldGoal,H_T_shootNum
		        			   			  ,H_freeThrowGoalNum,H_freeThrowNum,H_O_ReboundNum,H_D_ReboundNum,
		        			   			  H_reboundNum,H_assistNum,H_stealNum,H_blockNum,H_turnoverNum,
		        			   			  G_foulNum,H_points,H_allTime,H_teamData)),
			        			(new TeamMatchPO(season,G_team,G_fieldGoal,G_shootNum,G_T_fieldGoal,G_T_shootNum
		        			   			  ,G_freeThrowGoalNum,G_freeThrowNum,G_O_ReboundNum,G_D_ReboundNum,
		        			   			  G_reboundNum,G_assistNum,G_stealNum,G_blockNum,G_turnoverNum,
		        			   			  G_foulNum,G_points,G_allTime,G_teamData)));
	        }catch(Exception e){
	        		System.out.println("error:"+e.toString());
	        		} 
		
		return null;
	}

	@Override
	public MatchPO getAMatch(String date, String teamName) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
	
	

	public ArrayList<MatchPO> getMatchList() {
		return matchList;
	}
	
	private void readObject(){
		 /*
		  *  
		  * 
		  * */
		int count=0;
		       
		        //readTxtFile(filePath);
		    
		    	String FILE_IN = match_path;  
		        File f = new File(FILE_IN);  
		        String encoding="UTF-8";
		        List<String> list = new ArrayList<String>();  
		        list = FileList.getFileList(f);  
		        
		        //System.out.println(list.size());  
		        
		        String season;

		       int H_fieldGoal ;					//投篮命中数
		   	   int H_shootNum;					//投篮出手数
		   	   int H_T_fieldGoal ;				//三分球命中数
		   	   int H_T_shootNum ;				//三分球出手数
		   	   int H_freeThrowGoalNum ;			//罚球命中数
		   	   int H_freeThrowNum ;				//罚球出手数
		   	   int H_O_ReboundNum ;				//进攻（前场）篮板数
		   	   int H_D_ReboundNum ;				//防守（后场）篮板数
		   	   int H_reboundNum ;				//总篮板数
		   	   int H_assistNum ;				    //助攻数
		   	   int H_stealNum ;					//抢断数
		   	   int H_blockNum ;					//盖帽数
		   	   int H_turnoverNum ;				//失误数
		   	   int H_foulNum ;					//犯规数
		   	   int H_points ;					//得分
		   	   
		   	   int G_fieldGoal ;					//投篮命中数
		   	   int G_shootNum ;					//投篮出手数
		   	   int G_T_fieldGoal ;				//三分球命中数
		   	   int G_T_shootNum ;				//三分球出手数
		   	   int G_freeThrowGoalNum ;			//罚球命中数
		   	   int G_freeThrowNum ;				//罚球出手数
		   	   int G_O_ReboundNum ;				//进攻（前场）篮板数
		   	   int G_D_ReboundNum ;				//防守（后场）篮板数
		   	   int G_reboundNum ;				//总篮板数
		   	   int G_assistNum ;				    //助攻数
		   	   int G_stealNum ;					//抢断数
		   	   int G_blockNum ;					//盖帽数
		   	   int G_turnoverNum ;				//失误数
		   	   int G_foulNum ;					//犯规数
		   	   int G_points ;					//得分
		        
		        double H_allTime;
		        double G_allTime;
		        
		        
		        for (String l:list) {
		        	H_allTime=0;
		        	G_allTime=0;
		        	
		      //  	System.out.println("最初的文件路劲："+l);
		        	/////
		        	  H_fieldGoal=0;					//投篮命中数
				   	     H_shootNum=0;					//投篮出手数
				   	     H_T_fieldGoal=0;				//三分球命中数
				   	    H_T_shootNum=0;				//三分球出手数
				   	    H_freeThrowGoalNum=0;			//罚球命中数
				   	     H_freeThrowNum=0;				//罚球出手数
				   	     H_O_ReboundNum=0;				//进攻（前场）篮板数
				   	    H_D_ReboundNum=0;				//防守（后场）篮板数
				   	   H_reboundNum=0;				//总篮板数
				   	    H_assistNum=0;				    //助攻数
				   	    H_stealNum=0;					//抢断数
				   	     H_blockNum=0;					//盖帽数
				   	    H_turnoverNum=0;				//失误数
				   	     H_foulNum=0;					//犯规数
				   	     H_points=0;					//得分
				   	   
				   	     G_fieldGoal=0;					//投篮命中数
				   	     G_shootNum=0;					//投篮出手数
				   	     G_T_fieldGoal=0;				//三分球命中数
				   	    G_T_shootNum=0;				//三分球出手数
				   	    G_freeThrowGoalNum=0;			//罚球命中数
				   	     G_freeThrowNum=0;				//罚球出手数
				   	     G_O_ReboundNum=0;				//进攻（前场）篮板数
				   	    G_D_ReboundNum=0;				//防守（后场）篮板数
				   	     G_reboundNum=0;				//总篮板数
				   	     G_assistNum=0;				    //助攻数
				   	    G_stealNum=0;					//抢断数
				   	     G_blockNum=0;					//盖帽数
				   	     G_turnoverNum=0;				//失误数
				   	     G_foulNum=0;					//犯规数
				   	    G_points=0;					//得分
		        	
		        	
		        	
		        	
		        	//////////
		         
		        	try{ 
		        	//BufferedReader br = new BufferedReader(new FileReader(new File(l))); 
		        
		        String[]path=l.split("\\\\");
		        String s[]=path[path.length-1].split("_");
		       //System.out.println("第 " +g+"场比赛");
		        season=s[0];
		        
		       
		        	InputStreamReader read = new InputStreamReader(
		                    new FileInputStream(new File(l)),encoding);
		        	BufferedReader br = new BufferedReader(read);
		        	
		        	
		        	String  line ;
		         
		       
		         String date="";				 
		         String matchScore="";				 
		         ArrayList<String> scores=new ArrayList<String>();	
		        String H_team="";
		        String G_team="";
		        
  			//  System.out.println("文件："+l+";"+count);
  			   count++;
		        /*
		         *    
		         * */
		        ArrayList<SingleMatchPersonalDataPO> H_teamData=new ArrayList<SingleMatchPersonalDataPO> ();
		        ArrayList<SingleMatchPersonalDataPO> G_teamData=new ArrayList<SingleMatchPersonalDataPO> ();
		        
		        int num=1;
		        boolean isHostTeam=true;
		        //line=br.readLine();
		        	while((line=br.readLine())!=null){
		        		//System.out.println("--"+line+"----");
		        		line=line.trim();
		        		if(num==1){
		        		String  str1[]=line.split(";");
		        		String  teamNames[]=str1[1].split("-");
		        		H_team=teamNames[0];
		        		G_team=teamNames[1];
		        		date=str1[0];
		        		matchScore=str1[2];
		        		
		        		}else if(num==2){
		        		//	System.out.println("--分割比分--"+line);
		        			String score[]=line.split(";");
		        			for(int i=0;i<score.length;i++)
		        			scores.add(score[i]);
		        			
		        			//System.out.println("--分割比分--"+score.toString());
		        		}
		        		else{
		        			
		        			if(line.length()==3&&num==3){
		        	
		        				continue;
		        			}
		        			if(line.length()==3&&num!=3){
		        				isHostTeam=false;
		        				continue;
		        			}
		        			if(isHostTeam){
		        				String str[]=line.split(";");
		        				changeStrToInt(str);
		        				/*int fieldGoal3,
			 int shootNum4,int T_fieldGoal5,int T_shootNum6,int freeThrowGoalNum7,int freeThrowNum8,
			 int O_R_N9,int D_R_N10,int reboundNum11,int assistNum12,int blockNum13,int turnoverNum14,
			 int foulNum15,int points16 */
		        				
		        				     H_fieldGoal=H_fieldGoal+info[3];					//投篮命中数
		        			   	     H_shootNum=H_shootNum+info[4];					//投篮出手数
		        			   	     H_T_fieldGoal=H_T_fieldGoal+info[5];				//三分球命中数
		        			   	     H_T_shootNum=H_T_shootNum+info[6];				//三分球出手数
		        			   	     H_freeThrowGoalNum=H_freeThrowGoalNum+info[7];			//罚球命中数
		        			   	     H_freeThrowNum=H_freeThrowNum+info[8];				//罚球出手数
		        			   	     H_O_ReboundNum=H_O_ReboundNum+info[9];				//进攻（前场）篮板数
		        			   	     H_D_ReboundNum=H_D_ReboundNum+info[10];				//防守（后场）篮板数
		        			   	     H_reboundNum=H_reboundNum+info[11];				//总篮板数
		        			   	     H_assistNum=H_assistNum+info[12];				    //助攻数
		        			   	     H_stealNum=H_stealNum+info[13];					//抢断数
		        			   	     H_blockNum=H_blockNum+info[14];					//盖帽数
		        			   	     H_turnoverNum=H_turnoverNum+info[15];				//失误数
		        			   	     H_foulNum=H_foulNum+info[16];					//犯规数
		        			   	      
		        			   	     if(info[17]>=0){
			        			   	     H_points=H_points+getPoint(str[16]);					//得分
			        			   	     }					//得分
		        				     
		        			   	     if(calTime(str[2])>=0){
		        			   	    	 H_allTime=calTime(str[2])+H_allTime;
		        			   	     }
		        				H_teamData.add(new SingleMatchPersonalDataPO(str[0].trim(),
		        						str[1].trim(),calTime(str[2]),
		        						info[3],info[4],info[5],info[6],info[7],info[8],
		        						info[9],info[10],info[11],info[12],info[13],info[14]
		        						,info[15],info[16],info[17]));
		        		
		        			}else{
		        				String str[]=line.split(";");
		        				changeStrToInt(str);
		        				/*String name0,String p1,String time2,int fieldGoal3,
			 int shootNum4,int T_fieldGoal5,int T_shootNum6,int freeThrowGoalNum7,int freeThrowNum8,
			 int O_R_N9,int D_R_N10,int reboundNum11,int assistNum12,int blockNum13,int turnoverNum14,
			 int foulNum15,int points16 */
		        				
		        				G_fieldGoal=G_fieldGoal+info[3];					//投篮命中数
	        			   	     G_shootNum=G_shootNum+info[4];					//投篮出手数
	        			   	     G_T_fieldGoal=G_T_fieldGoal+info[5];				//三分球命中数
	        			   	     G_T_shootNum=G_shootNum+info[6];				//三分球出手数
	        			   	     G_freeThrowGoalNum=G_freeThrowGoalNum+info[7];			//罚球命中数
	        			   	     G_freeThrowNum=G_freeThrowNum+info[8];				//罚球出手数
	        			   	     G_O_ReboundNum=G_O_ReboundNum+info[9];				//进攻（前场）篮板数
	        			   	     G_D_ReboundNum=H_D_ReboundNum+info[10];				//防守（后场）篮板数
	        			   	     G_reboundNum=G_reboundNum+info[11];				//总篮板数
	        			   	     G_assistNum=G_assistNum+info[12];				    //助攻数
	        			   	     G_stealNum=G_stealNum+info[13];					//抢断数
	        			   	     G_blockNum=G_blockNum+info[14];					//盖帽数
	        			   	     G_turnoverNum=G_turnoverNum+info[15];				//失误数
	        			   	     G_foulNum=G_foulNum+info[16];					//犯规数
	        			   	     
	        			   	     if(info[17]>=0){
	        			   	     G_points=G_points+getPoint(str[16]);					//得分
	        			   	     }
	        			   	   
	        			   	  if(calTime(str[2])>=0){
		        			   	     G_allTime=calTime(str[2])+G_allTime;
		        			   	     }
	        			   	     
		        				G_teamData.add(new SingleMatchPersonalDataPO(str[0].trim(),
		        						str[1],calTime(str[2]),info[3],info[4],
		        						info[5],info[6],info[7],info[8],
		        						info[9],info[10],info[11],info[12],info[13],info[14]
		        						,info[15],info[16],info[17]));
		        			}	

		        		}
		        		//String str2[]=str  
		        		//strList.add(str2[1].trim());
		           // System.out.println(line+"******"+str[1]);
		        		//line=br.readLine();
		        		num++;
		        }
		        	
		      
		        		
		        		
		        		/*String date,String matchScore,
						ArrayList<String>scores,TeamMatch ht,TeamMatch gt*/  
					        	 matchList.add(new MatchPO(season,day.getDate(season, date),matchScore,scores,
					        			(new TeamMatchPO(season,H_team,H_fieldGoal,H_shootNum,H_T_fieldGoal,H_T_shootNum
				        			   			  ,H_freeThrowGoalNum,H_freeThrowNum,H_O_ReboundNum,H_D_ReboundNum,
				        			   			  H_reboundNum,H_assistNum,H_stealNum,H_blockNum,H_turnoverNum,
				        			   			  G_foulNum,H_points,H_allTime,H_teamData)),
					        			(new TeamMatchPO(season,G_team,G_fieldGoal,G_shootNum,G_T_fieldGoal,G_T_shootNum
				        			   			  ,G_freeThrowGoalNum,G_freeThrowNum,G_O_ReboundNum,G_D_ReboundNum,
				        			   			  G_reboundNum,G_assistNum,G_stealNum,G_blockNum,G_turnoverNum,
				        			   			  G_foulNum,G_points,G_allTime,G_teamData)))); 
					        	 
			        }catch(Exception e){
			        		continue;
			        		} 
		        		
		        		/*playerList.add(new PlayerInfoPO(strList.get(0),Integer.parseInt(strList.get(1)),
		        				strList.get(2),strList.get(3),Double.parseDouble(strList.get(4)),
		        				strList.get(5),Integer.parseInt(strList.get(6)),exp,strList.get(7)));
		        		strList.clear();*/
		        	}//end for
		  	 
		      
		        
		        
	}
	
	private double calTime(String time){
		double result=0;
		
		if(time==null)
			return 0;
		
		time=time.trim();
		
		try{
			String s[]=time.split(":");
			result=Integer.parseInt(s[0])+(double)Integer.parseInt(s[1])/60;
		}catch(Exception e){
			result=-1;
			//System.out.println("时间转化错误："+e.toString());
		}
		return result;
	}

    private void changeStrToInt(String list[]){
    	for(int i=3;i<list.length;i++){
    		try{
    		info[i]=Integer.parseInt(list[i]);
    		}catch(Exception e){
    			info[i]=0;
    		}
    	}
    }

    private int getPoint(String point){
    	int result=0;
    	try{
    		result=Integer.parseInt(point);
    		}catch(Exception e){
    			result=-1;
    		}
    	return result;
    }
    
}
