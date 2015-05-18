package businesslogic.bl.center;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamMatchVO;
import businesslogic.PO.MatchPO;
import businesslogic.PO.SingleMatchPersonalDataPO;
import businesslogic.PO.TeamMatchPO;
import businesslogic.bl.matchbl.MatchController;
import businesslogic.bl.playerbl.PlayerController;
import businesslogic.bl.teambl.TeamBase;
import businesslogic.bl.teambl.TeamController;
import businesslogic.data.MatchDataController;
import businesslogic.dataservice.MatchDataService;

public class CenterController {
	MatchController match;
	PlayerController player;
	TeamController team;
	PackageListener listener;
	
	String match_path;
	String player_path;
	String team_path;
	
	public CenterController(){
		 match=new MatchController();
		 player=new PlayerController("NBAdata\\players\\info");
		 team=new TeamController("NBAdata\\teams\\teams");
		 	match_path="NBAdata\\matches";
		init();
		listener=new PackageListener("NBAdata\\matches");
	}
	
	
	public void setPath(String player_path,String team_path,String match_path){
		this.match_path=match_path;
		this.player_path=player_path;
		this.team_path=team_path;
	}
	
	public CenterController(String player_path,String team_path,String match_path){
		
		this.match_path=match_path;
		this.player_path=player_path;
		this.team_path=team_path;
		match=new MatchController();
	    player=new PlayerController(player_path);
		team=new TeamController(team_path);
		init();
		listener=new PackageListener(match_path);
	}
	
	public static String time()
	 {
	  Date date=new Date();
	  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String time=format.format(date);
	  return time;
	 }
	
	public static void main(String args[]){
		System.out.println("����center��ʼ����ʱ�䣺"+time());
		CenterController c=new CenterController();
		//ArrayList<MatchInfo> list=c.match.getMatchByTeamTime("2014-01-01");
		/*for(int i=0;i<list.size();i++){
			System.out.println("ʱ�䣺"+list.get(i).getDate()+
				" ��ӣ�"+list.get(i).getTeam_H()+"-"+list.get(i).getTeam_G());
		}
	//	MatchVO vo=c.match.getMatchByTeam("2014-01-01", "CHA", "");
		
		for(int i=0;i<vo.getGuestTeam().getIndividualData().size();i++){
			System.out.println("---"+vo.getGuestTeam().getIndividualData().get(i).getPoints());
		}
		
		ArrayList<PlayerSeasonDataVO> listvo=c.player.getPlayerSeasonData("13-14");
		for(int i=0;i<listvo.size();i++){
			System.out.println("����;"+listvo.get(i).getName()+"   ���÷�"+listvo.get(i).getPointNum()+"   "+i);
		}
		*/
		System.out.println("���Խ���ʱ�䣺"+time());
	}
	
	private void init(){
		MatchDataService mc=new MatchDataController(match_path);
		ArrayList<MatchPO> polist=mc.getAllMatch();
		//System.out.println("��ʼ���У�---"+polist.size());
		MatchVO vo;
		for(int i=0;i<polist.size();i++){
			vo=matchpo_TO_po(polist.get(i));
			//System.out.println("��ӡ�������ڣ�"+vo.getDate());
			match.add_A_match(vo);
			 player.updatePlayerData(vo.getHostTeam().getIndividualData());
			 player.updatePlayerData(vo.getGuestTeam().getIndividualData());
			team.updateTeamData(vo.getHostTeam());
			team.updateTeamData(vo.getGuestTeam());
			
			//System.out.println("po->vo��ת����"+i);
		}
		
	//	System.out.println("��ʼ��������");
	}
	
	public void addMatch(MatchPO po){
		//System.out.println("��ӵ�po�Ƿ�Ϊ�գ�"+po==null);
		MatchVO vo=matchpo_TO_po(po);
		match.add_A_match(vo);
		 player.updatePlayerData(vo.getHostTeam().getIndividualData());
		 player.updatePlayerData(vo.getGuestTeam().getIndividualData());
		team.updateTeamData(vo.getHostTeam());
		team.updateTeamData(vo.getGuestTeam());
		
	}
	
	private  MatchVO matchpo_TO_po(MatchPO po){
	       /*�����غϣ����ӻغ�=Ͷ����+0.4*��ӷ�����-1.07*�����ӽ�������/�����ӽ�����
						��+���ַ������壩*Ͷʧ������+1.07*ʧ����**/
		//System.out.println("---matchpo_TO_po---��-��-"+po.getHostTeam()==null);
			TeamMatchPO H_po=po.getHostTeam();
			TeamMatchPO G_po=po.getGuestTeam();
			double H_offense_round=H_po.getShootNum()+0.4*H_po.getFreeThrowNum()-1.07*(
					(double)H_po.getO_ReboundNum()/(H_po.getO_ReboundNum()+G_po.getD_ReboundNum())*
					(H_po.getShootNum()-H_po.getFieldGoal()))+1.07*H_po.getTurnoverNum();
			
	        double G_offense_round=G_po.getShootNum()+0.4*G_po.getFreeThrowNum()-1.07*(
					(double)G_po.getO_ReboundNum()/(G_po.getO_ReboundNum()+H_po.getD_ReboundNum())*
					(G_po.getShootNum()-G_po.getFieldGoal()))+1.07*G_po.getTurnoverNum();
	        /* ��������Ч�ʣ�ǰ�����������/��ǰ����������+���ֺ���������*/
	        double H_offenseReboundeEff=(double)H_po.getO_ReboundNum()/(H_po.getO_ReboundNum()+G_po.getD_ReboundNum());
	        double G_offenseReboundeEff=(double)G_po.getO_ReboundNum()/(G_po.getO_ReboundNum()+H_po.getD_ReboundNum());
	        
	        TeamBase tb=new TeamBase();
	        
	        int Alltime=48*5+(po.getScores().size()-4)*5*5;
	        
	        String sco[]=po.getMatchScore().split("-");
	        int H_points=Integer.parseInt(sco[0]);
	        int G_points=Integer.parseInt(sco[1]);
	        
	        ArrayList<SingleMatchPersonalDataVO> H_player_list=playerMatchPO_To_VO(H_po.getTeamName(),Alltime,
	        		tb.getDivision(H_po.getTeamName()),tb.getpartition(H_po.getTeamName()),po.getSeason(),po.getDate(),
	        		H_po.getIndividualData(),
					H_po.getReboundNum(),G_po.getReboundNum(),H_po.getFieldGoal(),G_offense_round,
					G_po.getShootNum()-G_po.getT_shootNum(),H_po.getShootNum(),H_po.getFreeThrowNum(),H_po.getTurnoverNum()
					,H_po.getAllTime(),H_points,H_po.getPoints());
	        
	        ArrayList<SingleMatchPersonalDataVO> G_player_list=playerMatchPO_To_VO(G_po.getTeamName(),Alltime,
	        		tb.getDivision(G_po.getTeamName()),tb.getpartition(G_po.getTeamName()),po.getSeason(),po.getDate(),
	        		G_po.getIndividualData(),
					G_po.getReboundNum(),H_po.getReboundNum(),G_po.getFieldGoal(),H_offense_round,
					H_po.getShootNum()-H_po.getT_shootNum(),G_po.getShootNum(),G_po.getFreeThrowNum(),G_po.getTurnoverNum(),
					G_po.getAllTime(),G_points,G_po.getPoints());
	        /*String season,String teamName, 
				int winNum,int pointNum,int lost_point,
				int reboundNum, int O_ReboundNum, int D_ReboundNum,
				int assistNum, int turnoverNum, int stealNum, int foulNum,
				int fieldGoal, int shootNum, int T_fieldGoal, int T_shootNum,
				int freeThrowGoalNum, int freeThrowNum, int blockNum,
				double offenseRound, double defenseRound,
				double O_ReboundEfficiency,double D_ReboundEfficiency,
				ArrayList<SingleMatchPersonalDataVO> individualData*/
	      
	        int H_win=0,G_win=0;
	        if(H_points>G_points){
	        	H_win=1;
	        }else{
	        	G_win=1;
	        }
	        
	        TeamMatchVO H_team=new TeamMatchVO(po.getSeason(), H_po.getTeamName(),H_win,
	        		po.getDate(), G_po.getTeamName(), H_po.getPoints(),G_po.getPoints(), H_po.getReboundNum(),
	        		H_po.getO_ReboundNum(), H_po.getD_ReboundNum(), 
	        		H_po.getAssistNum(), H_po.getTurnoverNum(),
	        		H_po.getStealNum(), H_po.getFoulNum(), H_po.getFieldGoal(),
	        		H_po.getShootNum(), H_po.getT_fieldGoal(), 
	        		H_po.getT_shootNum(), H_po.getFreeThrowGoalNum()
	        		, H_po.getFreeThrowNum(),H_po.getBlockNum(), 
	        		H_offense_round, G_offense_round, 
	        		H_offenseReboundeEff, H_offenseReboundeEff, H_player_list);
	        
	        TeamMatchVO G_team=new TeamMatchVO(po.getSeason(), G_po.getTeamName(),G_win,
	        		po.getDate(), H_po.getTeamName(), G_po.getPoints(),H_po.getPoints(), G_po.getReboundNum(),
	        		G_po.getO_ReboundNum(), G_po.getD_ReboundNum(), 
	        		G_po.getAssistNum(), G_po.getTurnoverNum(),
	        		G_po.getStealNum(), G_po.getFoulNum(), G_po.getFieldGoal(),
	        		G_po.getShootNum(), G_po.getT_fieldGoal(), 
	        		G_po.getT_shootNum(), G_po.getFreeThrowGoalNum()
	        		, G_po.getFreeThrowNum(),G_po.getBlockNum(), 
	        		G_offense_round, H_offense_round, 
	        		G_offenseReboundeEff, G_offenseReboundeEff, G_player_list);
	        
	        
	        
			return new MatchVO(po.getSeason(),po.getDate(),po.getMatchScore(),po.getScores(),
					H_team,G_team);
			}
		
		private ArrayList<SingleMatchPersonalDataVO> playerMatchPO_To_VO(String team,
				double teamTime,String division,String partition,String season,
				String date,ArrayList<SingleMatchPersonalDataPO>list,
				int T_reboundNum,int E_reboundNum,int T_fieldGoal,double E_offenseRound,
				int E_two_shootNum,int T_shootNum,int T_freeThrowNum,int T_turnoverNum,
				  double allTime,int teamPoints,int allPoints){
			
			  double assistEff =0;        //������__
			  double reboundEff =0;       //������__
			  double offensiveReboundEff=0;     //����������__
			  double defenseReboundEff=0;     	//����������__
			  double stealEff =0;			//������__
			  double usingPer =0;         //ʹ����__
			  double blockEff =0;			//��ñ��__
			 ArrayList<SingleMatchPersonalDataVO> result=new ArrayList<>();
			 SingleMatchPersonalDataPO po;
			 
			 for(int i=0;i<list.size();i++){
				 po=list.get(i);
				 
				 
				 /*�ȴ���������*/
				 
				 
				 
				 if(po.getTime()<0){
					 po.setTime(teamTime-allTime);
				 }
				 if(po.getPoints()<0){
					 po.setPoints(teamPoints-allPoints);
				 }
				 
				 
				 
				 /*�����ʣ���Ա��������(��Ա�ϳ�ʱ���(���������Ա�ϳ�ʱ���5)������ܽ� ����-��Ա������)*/
				 if(po.getTime()!=0){
				 assistEff=(double)po.getAssistNum()/(po.getTime()/(allTime/5)*T_fieldGoal-po.getFieldGoal());
				/* �����ʣ���Ա��������(���������Ա�ϳ�ʱ���5)����Ա�ϳ�ʱ���(���������+����������)*/
				 reboundEff=(double)po.getReboundNum()*(allTime/5)/po.getTime()/(T_reboundNum+E_reboundNum);
				 offensiveReboundEff=(double)po.getO_ReboundNum()*(allTime/5)/po.getTime()/(T_reboundNum+E_reboundNum);
				 defenseReboundEff=(double)po.getD_ReboundNum()*(allTime/5)/po.getTime()/(T_reboundNum+E_reboundNum);
				 /*�����ʣ� ��Ա��������(���������Ա�ϳ�ʱ���5)����Ա�ϳ�ʱ��¶��ֽ�������)*/
				 stealEff=(double)po.getStealNum()*(allTime/5)/po.getTime()/E_offenseRound;
				 /*��ñ�ʣ���Ա��ñ����(���������Ա�ϳ�ʱ���5)����Ա�ϳ�ʱ��¶�����������ִ���*/
				 blockEff=(double)po.getBlockNum()*(allTime/5)/po.getTime()/E_two_shootNum;
				 /*ʹ���ʣ� (��Ա���ִ���+0.44����Ա�������+��Աʧ�����)��(���������Ա
				�ϳ�ʱ���5)����Ա�ϳ�ʱ���(�����������Ա���ִ���+0.44�����������Ա����
				����+���������Աʧ�����) */
				 usingPer=((po.getShootNum()+0.44*po.getFreeThrowNum()+po.getTurnoverNum())*
				 (allTime/5)/po.getTime())/(T_shootNum+0.44*T_freeThrowNum+T_turnoverNum);
				 }
				 /*String season,String date,String name,String p,String time,int fieldGoal,
				 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
				 int O_R_N,int D_R_N,int reboundNum,int assistNum,int steal,int blockNum,int turnoverNum,
				 int foulNum,int points, double assistEfficiency,
				 double reboundEfficiency,double offensiveReboundEff,
				 double defenseReboundEff,double stealEfficiency,
				 double usingPercentage,double blockEfficiency*/
				 
				 SingleMatchPersonalDataVO vo=new SingleMatchPersonalDataVO(season, date,
						 po.getPlayerName(),team,division,partition,po.getPlayerPosition(), 
						 po.getTime(),po.getFieldGoal(), po.getShootNum()
						 , po.getT_fieldGoal(), po.getT_shootNum(), 
						 po.getFreeThrowGoalNum(), po.getFreeThrowNum(),
						 po.getO_ReboundNum(), po.getD_ReboundNum(),
						 po.getReboundNum(), po.getAssistNum(), 
						 po.getStealNum(), po.getBlockNum(),
						 po.getTurnoverNum(), po.getFoulNum(), po.getPoints(),
						 assistEff, reboundEff, offensiveReboundEff,
						 defenseReboundEff, stealEff, usingPer, blockEff);
				 result.add(vo);
				 
			 }
			
			return result;
		}

		public MatchController getMatch() {
			return match;
		}

		public PlayerController getPlayer() {
			return player;
		}

		public TeamController getTeam() {
			return team;
		}
		
		
		///////////////////////
		 class PackageListener {
			 
			FileListenerThread f ;
			
		    public PackageListener(String filePath) {
		        String path = filePath;
		        f = new FileListenerThread(path);
		        Thread listener = new Thread(f);
		       // System.out.println("-----------------�������ķָ���--------------");
		        listener.start();
		    }

		}
		 
		class FileListenerThread implements Runnable{
		 
		    private String path;
		    ArrayList<String> addedFile = new ArrayList<String>();
		    @Override
		    public void run() {
		        //��Ҫ�������ļ���
		        File file = new File(path);
		        //ԭʼ�ļ��е��ļ�����
		        String[] fileList = file.list();
		       // System.out.println("compiling file path");
		        int orginalSize = file.list().length;
		        while(true){
		            int size = file.list().length;
		            if(size > orginalSize){
		               // System.out.println("�ļ�����������Ϊ�� "+(size-orginalSize));
		            	String[] newFileList = file.list();
		            	for(int i=0;i<newFileList.length;i++){
		            		boolean isOld = false;
		            		for(int j=0;j<fileList.length;j++){
		            			if(newFileList[i].equals(fileList[j])){
		            				isOld = true;
		            				break;
		            			}

		            		}
		            		
		        			if(!isOld){
		        				addNewFile(newFileList[i]);
		        				char c=92;
		        				MatchDataService mc=new MatchDataController(match_path);
		        				MatchPO po=mc.getMatch(path+"\\\\"+newFileList[i]);
		        			//	System.out.println("----***--��⵽���ļ�***��"+newFileList[i]);
		        				 // System.out.println("----***--��⵽���ļ���"+newFileList[i]+"------"
		        					//	+ "---�������ڣ�--��"+po.getDate());
		        				try {
		    		                //˯1��
		    		                Thread.sleep(1000);
		    		            } catch (InterruptedException e) {
		    		            }
		        				addMatch(po);
		        				//System.out.println("---------��⵽���ļ���"+newFileList[i]+"-------------��");
		        			} 
		            	}
		            	//System.out.println("?????");
		            	fileList = newFileList;
		                orginalSize = size;
		            }
		         
		            try {
		                //˯1��
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		            }
		        }
		    }
		     
		    private void addNewFile(String newFileName) {
				// TODO Auto-generated method stub
		    	addedFile.add(newFileName);
				
			}
		    
		    public ArrayList<String> getAddedFileList(){
		    	ArrayList<String> temp = addedFile;
		    	addedFile.clear();
		    	return temp;
		    }

			public FileListenerThread(String path){
		        this.path= path;
		    }
		}
	 
}
