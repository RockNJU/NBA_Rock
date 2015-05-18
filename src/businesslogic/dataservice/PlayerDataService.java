package businesslogic.dataservice;

import java.util.ArrayList;

import VO.PlayerInfoVO;
public interface PlayerDataService {
	ArrayList<PlayerInfoVO> getAllPlayer();  		//获取所有球员
}
