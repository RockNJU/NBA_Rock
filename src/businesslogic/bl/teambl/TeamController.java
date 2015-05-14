package businesslogic.bl.teambl;
import java.util.ArrayList;

import businessService.blservice.TeamBLService;
import businesslogic.bl.center.HotSort;
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

	@Override
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season) {
		// TODO Auto-generated method stub
		return teamFactory.getALLTeamSeasonData(season);
	}

	@Override
	public TeamSeasonDataVO get_A_TeamSeasonData(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_TeamSeasonData(season, teamAbb);
	}

	@Override
	public double getTeamWinNum(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_TeamSeasonData(season, teamAbb).getWinRate();
	}
	@Override
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


	@Override
	public TeamInfoVO get_A_TeamInfo(String s,String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_teamInfo(teamAbb);
	}


	@Override
	public ArrayList<TeamSeasonDataVO> sort(String season, String[] condition,
			boolean[] reverse) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(season);
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, condition, reverse);
	}


	@Override
	public ArrayList<TeamSeasonDataVO> sort(String[] condition,
			boolean[] reverse) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(
				teamFactory.getLastDay().getSeason());
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list,condition,reverse);
	}


	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String item) {
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(
				teamFactory.getLastDay().getSeason());
		HotSort sort=new HotSort();
		return sort.hotTeam_Sort(list, item);
	}

}
