package businessService.blservice;

import java.util.ArrayList;

import VO.*;

public interface PlayerBLService{
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item);//获取当天的热点球员，传入的是热点项目

	//TODO 大于等于什么的筛选---之前写的是根据表格的、并不能适用、
		//传入的值为 赛季、赛季类型、查找依据、符号（这个符号有可能是中文字符也有可能是英文字符）、值
		public ArrayList<PlayerSeasonDataVO> sort_super(String season,String type,String position,String partition,String item,String sign,int num);
		//TODO 首字母获得球员
		public ArrayList<PlayerInfoVO> getPlayerInfoByFirstChar(String firstchar);
		//TODO 这个是你已经实现的、但是我需要改成ArrayList为返回值、并且name是部分，就是字母或单姓//根据球员的名字获取球员的基本信息
		public ArrayList<PlayerInfoVO> getPlayerInfo(String name);   
		//TODO 需要加上赛季类型为筛选球员，较之前有赛季的要求
		public ArrayList<PlayerSeasonDataVO> sort(String season,String type,String position,String partition,String item);
		
		//按照传入的赛季获取整个赛季中的所有球员的赛季数据
		public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  
		//TODO 需要加上赛季类型//为筛选球员，实现多级排序，较之前有赛季的要求
		public ArrayList<PlayerSeasonDataVO> sort(String season,String type,String position,String partition,
				 String[] condition,boolean[] reverse);
		public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //获取所有球员的基本信息
		public ArrayList<PlayerSeasonDataVO> keyfind( String text);
		//获取赛季的热点球员,传入的参数是赛季和筛选项目
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);
		
		//TODO
		//由于你说你准备把vo里近五场比赛删掉，我也不管了，我要的方法我都写出来
		//获得近五场——只有姓名，赛季当前默认，赛季类型就可以选择吧，这样我界面方便点
		public ArrayList<SingleMatchPersonalDataVO> getLastFiveMatchData(String name);
		//获得一个球员所有赛季的数据
		public ArrayList<PlayerSeasonDataVO> getAPlayerSeasonData(String name,String type);
		//进步最快球员，according
		public  ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item);
		//折线图对比某项数据，球员名称,数据数量（10场，20场，30场，整个赛季）,对应数据名称（平均得分，三分等等））	如果没有数据，则对应位置返回0
		public double[] getPlayerOneData(String name,int num,String what);
		//获得一个球员整个赛季的比赛
		public ArrayList<SingleMatchPersonalDataVO> getASeasonMatchData(String na, String season);
		//TODO 需要加上赛季类型//根据球员姓名获取球员的某个赛季的比赛数据
		
		public PlayerInfoVO getAPlayerInfo(String name);
		public PlayerSeasonDataVO getAPlayerSeasonData(String season,String type,String name);
	/**	
	//需要的方法——热点方面我没有看	
		
	//------------------------------------------------------------------------------------
	//区域内方法暂时没有用到
		public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,String teamAbb);    
		//根据球队的缩写获取球队所有的球员姓名，其实你可以考虑返回所有的基本信息，这容易做到	
	//--------------------------------------------------------------------
	 * 
		
	 *
		/////////////////////////以下接口仅为测试服务		
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem);//获取最新赛季的热点球员,传入的参数是赛季和筛选项目
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem,int n);//获取最新赛季的热点球员,传入筛选项目和返回数据个数
		public  ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item,int n);//获取进步最快球员 ，传入筛选项目和返回数据个数
		
		public ArrayList<PlayerSeasonDataVO> getSortInfo(String position,String league,String age,String[] condition,boolean[] reverse);
		 */
}
