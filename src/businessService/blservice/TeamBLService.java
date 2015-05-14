package businessService.blservice;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season);	
	//返回某个赛季的所有球队的现有赛季信息，传入的参数为赛季
	
	//TODO 跪求还有teaminfovo
	public TeamSeasonDataVO get_A_TeamSeasonData(String season,String teamAbb);	
	public TeamInfoVO get_A_TeamInfo(String season,String teamAbb);	
	//根据赛季和球队缩写获取一支球队在某个赛季的比赛信息
	
	public double getTeamWinNum(String season,String teamAbb);
	//根据赛季和球队获取一支球队的胜率，注：这一条是先前留下的，胜率在TeamSeasonDataVO里已经有了，我不知道需不需要
	
	
	
	public ArrayList<TeamSeasonDataVO> sort(String season,String sortItem);  //根据赛季和排序的 属性对球队进行排序后返回
	
	
	
	public ArrayList<TeamSeasonDataVO> sort(String season,String[] condition,boolean[] reverse);  //根据赛季和多重排序的实现 属性对球队进行排序后返回
	//====================测试所需方法============================
	//排序条件移除赛季  
	public ArrayList<TeamSeasonDataVO> sort(String[] condition,boolean[] reverse);  //根据多重排序的实现 属性对球队进行排序后返回
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season,String item);
	//根据赛季和筛选的条件 获取赛季热点球队，即排名前五的球队
	//===========================测试所需方法===========
	public ArrayList<TeamSeasonDataVO> getHotTeam(String item);   
	//根据筛选的条件 获取赛季热点球队，所有的  ，不仅仅是前5

	//TODO 不知道你们的根据关键词查找到底理解的什么意思，我觉得是输入关键词，返回符合要求的队伍arraylist，另外觉得不用考虑赛季
	public ArrayList<TeamSeasonDataVO> find(String text);
	
}
