package bl_db.matchbl;

import java.util.ArrayList;

import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import businessService.blservice.MatchBLService;

public class MatchController implements MatchBLService{

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

	@Override
	public ArrayList<MatchVO> getMatchByTeamTime(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchVO getMatchByTeam(String data, String teamA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,
			int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getAllSeason() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason(String season, String teamA) {
		// TODO Auto-generated method stub
		return null;
	}

}
