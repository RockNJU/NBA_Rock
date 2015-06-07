package businesslogic.bl.matchbl;

import java.util.ArrayList;

import businessService.blservice.MatchBLService;
import businesslogic.bl.center.HotSort;
import VO.MatchInfoVO;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;

public class MatchController implements MatchBLService{
	MatchDataFactory matchFactory;
	
	public MatchController(){
		matchFactory=new MatchDataFactory();
	}
	
	public void add_A_match(MatchVO vo){
		/*往比赛数据仓库中添加一条比赛记录*/
		matchFactory.add_A_match(vo);
	}
	
	

	@Override
	public ArrayList<String>getAllSeason() {
		// TODO Auto-generated method stub
		return matchFactory.getAllSeason();
	}

	@Override
	public ArrayList<MatchVO> getMatchByTeamTime(String date) {
		// TODO Auto-generated method stub
		return matchFactory.get_A_Day_match(date);
	}

	public MatchVO getMatchByTeam(String date, String team) {
		// TODO Auto-generated method stub
		return matchFactory.get_A_match(date, team);
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item) {
		// TODO Auto-generated method stub
		ArrayList<SingleMatchPersonalDataVO> list= matchFactory.get_A_Aay_playMatchData();
		HotSort sort=new HotSort();
		list= sort.hotSinglePlayer_Sort(list, item);
		ArrayList<SingleMatchPersonalDataVO> result=new ArrayList<>();
		for(int i=0;i<5;i++){
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return matchFactory.get_A_Season_team_match(season, teamAbb);
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,
			int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_NotOver(String season, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ByMonth(String season, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDatesOfPro_ByMonth(String season, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ByDay(String season, int month, int day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfoVO> getPro_ForTeam(String season, int month,
			String teamabb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastHavingMatchDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNextHavingMatchDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
