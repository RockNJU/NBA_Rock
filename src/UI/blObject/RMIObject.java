package UI.blObject;

import java.util.ArrayList;

import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;
import bl_db.matchbl.Match_Controller;
import businessService.blservice.*;
import businesslogic.bl.center.CenterController;



public class RMIObject {
	CenterController contr;
	public RMIObject(){
		contr=new CenterController();
	}
	public RMIObject(String player_path,String team_path,String match_path){
		contr=new CenterController(player_path,team_path,match_path);
	}
	public MatchBLService  getMatchObject(){
		MatchBLService match=new Match_Controller();
		return match;
	}
	
	public PlayerBLService getPlayerObject(){
		PlayerBLService player=contr.getPlayer();
		return player;
	}
	
	public TeamBLService getTeamObject(){
		TeamBLService team=contr.getTeam();
		return team;
	}
	
	public static void main(String args[]){
		RMIObject m=new RMIObject();
		TeamBLService team=m.getTeamObject();
		PlayerBLService player=m.getPlayerObject();
		MatchBLService mac=m.getMatchObject();
		
	
		
		 //ArrayList<PlayerSeasonDataVO> pl=player.sort("13-14", "C", "  ", "offensiveReboundEff_avg");
		/*
		for(int i=0;i<pl.size();i++){
			System.out.println("������"+pl.get(i).getName()+"    ��Աλ�ã�"+pl.get(i).getPosition()
					+"   �ȷ�������"+pl.get(i).getStartingNum()+"    ����������"+pl.get(i).getMatchNum());
			 
			//System.out.println("������"+pl.get(i).getName()+"  ��Ա�������壺"+pl.get(i).getD_ReboundNum_avg()
				//	+"    �÷֣�"+pl.get(i).getPointNum_avg());
		} */
		
		/*ArrayList<TeamSeasonDataVO> list=team.getAllTeamSeasonData("13-14");
		for(int i=0;i<list.size();i++){
			System.out.println("--������"+list.get(i).getTeamName()+"; ���ػغϣ�  "+list.get(i).getDefenseRound());
		}
		// MatchVO  vo=mac.getMatchByTeam("2013-12-03","TOR");
		 
		for(int i=0;i<list.size();i++){
			System.out.println("--������"+list.get(i).getDate()+"������"+list.get(i).getHostTeam().getTeamName());
		}
		 
		 System.out.println("--������"+vo.getDate()+"��--Ա---����"+
		 vo.get_GuestTeam_Highest_point().getPlayerName()+"���÷֣�"+vo.get_GuestTeam_Highest_point().getPointNum());
			
		System.out.println("RMIObject���Խ�����");*/
	}
	
}
