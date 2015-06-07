package businessService.blservice;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	//TODO 获得默认赛季
	public String getdefaultseason();
	public ArrayList<String> getTeamByPartition(String partition);
	//TODO
	public ArrayList<PlayerSeasonDataVO> getKingPlayerForATeam(String tamename, String item);
	//获得球队 按赛季来的   整个赛季的数据
	public ArrayList<TeamSeasonDataVO> getATeamSeasonData(String na,String seasontype);
		
	public ArrayList<TeamSeasonDataVO> sort_super(String season,String type,String item,String sign,int num);

	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season,String type);	
	//返回某个赛季的所有球队的现有赛季信息，传入的参数为赛季

	public ArrayList<TeamSeasonDataVO> sort(String season,String type,String sortItem);  //根据赛季和排序的 属性对球队进行排序后返回
	public ArrayList<TeamSeasonDataVO> sort(String season,String type,String[] condition,boolean[] reverse);  //根据赛季和多重排序的实现 属性对球队进行排序后返回
	//TODO 不知道你们的根据关键词查找到底理解的什么意思，我觉得是输入关键词，返回符合要求的队伍arraylist，另外觉得不用考虑赛季
		public ArrayList<TeamSeasonDataVO> find(String text);
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season,String item);
	//根据赛季和筛选的条件 获取赛季热点球队，即排名前五的球队
	public ArrayList<TeamMatchVO> getLastFiveMatchData(String na,String seasontype);
	//蝴蝶一个球队整个赛季的比赛
	public ArrayList<TeamMatchVO> getASeasonMatchData(String na,String season);
	
	/*
	//TODO 2015/5/18 加
	
	
	//TODO 加入赛季类型
	
	
	
	//-------------------------------------------------------------------
	//根据赛季和球队缩写获取一支球队在某个赛季的比赛信息
	
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season);
	public double getTeamWinNum(String season, String teamAbb) ;
	//====================测试所需方法============================
	//排序条件移除赛季  
	public ArrayList<TeamSeasonDataVO> sort(String[] condition,boolean[] reverse);  //根据多重排序的实现 属性对球队进行排序后返回

	//===========================测试所需方法===========

	
*/
	
	
	
}
