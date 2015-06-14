package businessService.blservice;
import java.util.ArrayList;
import VO.MatchInfoVO;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
public interface MatchBLService {
	//获得默认赛季、本月的未进行的所有比赛的赛程
	public ArrayList<MatchInfoVO> getPro_NotOver(String season,int month);
	
	   //获得赛程（某赛季、某月的赛程）所需要的方法(no need)
	   public ArrayList<MatchInfoVO> getPro_ByMonth(String season,int month);
	   
	   //对上面获得的ArrayList<MatchInfoVO>进行处理,获得   （某赛季、某月的赛程）【是上个方法的返回值】中有比赛的日期
	   public ArrayList<String> getDatesOfPro_ByMonth(String season,int month);
	   //获得赛程（某赛季、某月、某天的赛程）所需要的方法    month和day可以商榷
	   public ArrayList<MatchInfoVO> getPro_ByDay(String season,int month,int day);
	  
	   //获得球队赛程（某赛季、某月、某球队）
	   public ArrayList<MatchInfoVO> getPro_ForTeam(String season,int month,String teamabb);

	   //TODO 获得最后有比赛的日期
		public String getLastHavingMatchDate();
		
		//TODO 获得传入日期后最近一场比赛的日期 这里的date 2014-01-02 形式有问题可以改
		public String getNextHavingMatchDate(String date);
		
		// 获得赛季以供选择，形式最好是"13-14赛季",这个是公用的、
		public ArrayList<String> getAllSeason();
		
		
		ArrayList<MatchInfoVO> getMatchBySeason(String season,String type,String teamA);
		
		ArrayList<MatchInfoVO> getMatchByTeamTime(String date);			
        //  根据输入的日期获取这一天所有的比赛信息
      //比赛信息 MatchInfo 详见matchbl里的MAtchInfo定义，
      //我认为这比之前的用-隔开的String方便，省去你们的分割操作
		
		public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,int n);//获取当天的热点球员，传入的是热点项目
		
		MatchVO getMatchByTeam(String data,String teamA);

		
		/*
	        //根据球队的缩写和比赛日期获取某一场比赛的数据，返回一个MatchVO
	

	
*/
}
