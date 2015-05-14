package businesslogic.dataservice;
import java.util.ArrayList;
import businesslogic.PO.MatchPO;

public interface MatchDataService {
	/*
	 * 因为现在给的只有一个赛季，因此不给出有筛选条件为赛季的
	 * 
	 * */
	ArrayList<MatchPO> getAllMatch();
	MatchPO getMatch(String filepath);  		//team 由两队组成，都是队名缩写，形如HOU
	MatchPO getAMatch(String date,String teamName);		//由日期和一个队获取一场比赛数据
}
