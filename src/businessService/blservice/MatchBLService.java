package businessService.blservice;
import java.util.ArrayList;

import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
public interface MatchBLService {
	
	   //TODO 获得最后有比赛的日期
		String getLastHavingMatchDate();
		
		//TODO 获得传入日期后最近一场比赛的日期 这里的date 2014-01-02 形式有问题可以改
		String getNextHavingMatchDate(String date);
		public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item);//获取当天的热点球员，传入的是热点项目

		// 获得赛季以供选择，形式最好是"13-14赛季",这个是公用的、
		public ArrayList<String> getAllSeason();
		
		
		ArrayList<MatchVO> getMatchBySeason(String season,String teamA);
		
		ArrayList<MatchVO> getMatchByTeamTime(String date);			
        //  根据输入的日期获取这一天所有的比赛信息
      //比赛信息 MatchInfo 详见matchbl里的MAtchInfo定义，
      //我认为这比之前的用-隔开的String方便，省去你们的分割操作
		
		
		/*
	
	
	
	               
	                         
	MatchVO getMatchByTeam(String data,String teamA);
	        //根据球队的缩写和比赛日期获取某一场比赛的数据，返回一个MatchVO
	

	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,int n);//获取当天的热点球员，传入的是热点项目
	


	
*/
}
