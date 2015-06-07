package businesslogic.bl.teambl;
import java.util.ArrayList;

import businessService.blservice.TeamBLService;
import businesslogic.bl.center.HotSort;
import VO.PlayerSeasonDataVO;
import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public class TeamController implements TeamBLService,TeamInfo_player{
       private TeamDataFactory teamFactory;
       
       public TeamController(String path){
    	   teamFactory=new TeamDataFactory(path);
       }

       
       public void updateTeamData(TeamMatchVO vo){
    	   teamFactory.update_A_matchData(vo);
    	   TeamMatchVO mvo1=new TeamMatchVO(null, null, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
    	   
    	   
       }
       
	@Override
	public TeamInfoVO getTeam_info(String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_teamInfo(teamAbb);
	}

	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season) {
		// TODO Auto-generated method stub
		return teamFactory.getALLTeamSeasonData(season);
	}

	public TeamSeasonDataVO get_A_TeamSeasonData(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_TeamSeasonData(season, teamAbb);
	}

	public double getTeamWinNum(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_TeamSeasonData(season, teamAbb).getWinRate();
	}
	public ArrayList<TeamSeasonDataVO> sort(String season, String sortItem) {
		// TODO Auto-generated method stub
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(season);
		HotSort sort=new HotSort();
		
		return sort.hotTeam_Sort(list,sortItem);
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season, String item) {
		// TODO Auto-generated method stub
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(season);
		HotSort sort=new HotSort();
		
		list= sort.hotTeam_Sort(list,item);
		ArrayList<TeamSeasonDataVO> result=new ArrayList<>();
		for(int i=0;i<5;i++){
			result.add(list.get(i));
		}
		return result;
	}


	@Override
	public ArrayList<TeamSeasonDataVO> find(String text) {
		// TODO Auto-generated method stub
		return teamFactory.get_team_related_Info(text);
	}


	public TeamInfoVO get_A_TeamInfo(String s,String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_teamInfo(teamAbb);
	}


	public ArrayList<TeamSeasonDataVO> sort(String season, String[] condition,
			boolean[] reverse) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(season);
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, condition, reverse);
	}


	public ArrayList<TeamSeasonDataVO> sort(String[] condition,
			boolean[] reverse) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(
				teamFactory.getLastDay().getSeason());
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list,condition,reverse);
	}


	public ArrayList<TeamSeasonDataVO> getHotTeam(String item) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(
				teamFactory.getLastDay().getSeason());
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, item);
	}


	@Override
	public ArrayList<String> getTeamByPartition(String partition) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(
				teamFactory.getLastDay().getSeason());
		
		ArrayList<String> result=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getInfo().getPartition().equals(partition)){
				result.add(list.get(i).getInfo().getTeamAbb());
			}
		}
		return result;
	}


	@Override
	public String getdefaultseason() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<PlayerSeasonDataVO> getKingPlayerForATeam(String tamename,
			String item) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TeamSeasonDataVO> sort_super(String season, String type,
			String item, String sign, int num) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season,
			String type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TeamSeasonDataVO> sort(String season, String type,
			String sortItem) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TeamSeasonDataVO> sort(String season, String type,
			String[] condition, boolean[] reverse) {
		// TODO Auto-generated method stub
		return null;
	}

}
