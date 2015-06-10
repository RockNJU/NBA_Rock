package bl_db.matchbl;

import VO.TeamMatchVO;

public interface TeamInfo {
	TeamMatchVO getTeamMatch(String date,String teamAbb);
}
