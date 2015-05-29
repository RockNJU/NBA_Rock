package bl_db.teamrbl;

import java.util.ArrayList;

import VO.TeamSeasonDataVO;
import businessService.blservice.TeamBLService;

public class TeamController implements TeamBLService{

	@Override
	public ArrayList<String> getTeamByPartition(String partition) {
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
	public String getdefaultseason() {
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

	@Override
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTeamWinNum(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> sort(String[] condition,
			boolean[] reverse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season, String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> find(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
