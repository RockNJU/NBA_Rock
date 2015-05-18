package businesslogic.dataservice;
import java.util.ArrayList;
import VO.TeamInfoVO;


public interface TeamDataService {
	ArrayList<TeamInfoVO>  getTeamInfoList(); 		//返回所有球队的基本信息
}
