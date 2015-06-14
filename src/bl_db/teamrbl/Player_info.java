package bl_db.teamrbl;

import java.util.ArrayList;

import VO.PlayerSeasonDataVO;

public interface Player_info {
	public ArrayList<PlayerSeasonDataVO> get_Data(String sqlStr);
}
