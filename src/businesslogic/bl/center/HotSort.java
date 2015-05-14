package businesslogic.bl.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamSeasonDataVO;

public class HotSort {
	
	// 热点球员的排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String condition) {

		// 先按名称排序
		Collections.sort(playerSeasondata, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				PlayerSeasonDataVO p1 = (PlayerSeasonDataVO) o1;
				PlayerSeasonDataVO p2 = (PlayerSeasonDataVO) o2;
				String name1 = p1.getReverseName();
				String name2 = p2.getReverseName();
				return name1.compareTo(name2);
			}
		});

		// 创建针对某个属性的升序比较
		Comparator player_compare = new BeanComparator(condition);
		// 默认的是升序，这里用一个降序
		player_compare = new ReverseComparator(player_compare);
		// 开始排序
		Collections.sort(playerSeasondata, player_compare);

		return playerSeasondata;
	}
	
	
	// 赛季热点球员的多属性按优先级排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String[] condition,boolean[] reverse) {
    // 先按名称排序
		Collections.sort(playerSeasondata, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				PlayerSeasonDataVO p1 = (PlayerSeasonDataVO) o1;
				PlayerSeasonDataVO p2 = (PlayerSeasonDataVO) o2;
				String name1 = p1.getReverseName();
				String name2 = p2.getReverseName();
				return name1.compareTo(name2);
			}
		});

	       //创建多属性排序链
        ComparatorChain cc = new ComparatorChain();
        //String conditions[]={"pointNum_avg","assistNum_avg","foulNum_avg"};
       // boolean reverses[] = {true,true,false};
        //第一个参数是指定排序的属性，第二个参数指定降序升序
        for(int i=0;i<condition.length;i++){
        	if(condition[i]!=null){
        		cc.addComparator(new BeanComparator(condition[i]), reverse[i]);
        		//System.out.println("conditions333"+ condition[i]);
        	}
        	
        }
        Collections.sort(playerSeasondata,cc );
      // for(int i=0;i<playerSeasondata.size();i++){
       // 	PlayerSeasonDataVO pvo = playerSeasondata.get(i);
           // System.out.println(pvo.getName()+"  "+pvo.getTeamName()+"  ["+pvo.getReboundNum_avg()+"]"+"  ["+pvo.getStartingNum()+"]"+"  ["+pvo.getMatchNum()+"]");
        	
     //   }
		return playerSeasondata;
	}


	// 赛季热点球队的排序方法
	@SuppressWarnings("unchecked")
	public ArrayList<TeamSeasonDataVO> hotTeam_Sort(
			ArrayList<TeamSeasonDataVO> teamSeasondata, String condition) {

		// 先按名称排序
		Collections.sort(teamSeasondata, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				TeamSeasonDataVO p1 = (TeamSeasonDataVO) o1;
				TeamSeasonDataVO p2 = (TeamSeasonDataVO) o2;
				String name1 = p1.getTeamName();
				String name2 = p2.getTeamName();
				return name1.compareTo(name2);
			}
		});

		// 创建针对某个属性的升序比较
		@SuppressWarnings("rawtypes")
		Comparator team_compare = new BeanComparator(condition);
		// 默认的是升序，这里用一个降序
		team_compare = new ReverseComparator(team_compare);
		// 开始排序
		Collections.sort(teamSeasondata, team_compare);
		return teamSeasondata;

	}
	
	// 赛季热点球队的多属性按优先级排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<TeamSeasonDataVO> hotTeam_Sort(
			ArrayList<TeamSeasonDataVO> teamSeasondata, String[] condition,boolean[] reverse) {
    // 先按名称排序
		Collections.sort(teamSeasondata, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				TeamSeasonDataVO p1 = (TeamSeasonDataVO) o1;
				TeamSeasonDataVO p2 = (TeamSeasonDataVO) o2;
				String name1 = p1.getTeamName();
				String name2 = p2.getTeamName();
				return name1.compareTo(name2);
			}
		});

	       //创建多属性排序链
        ComparatorChain cc = new ComparatorChain();
        //第一个参数是指定排序的属性，第二个参数指定降序升序
        for(int i=0;i<condition.length;i++){
        	if(condition[i]!=null){
        		cc.addComparator(new BeanComparator(condition[i]), reverse[i]);
        	}
        }
        Collections.sort(teamSeasondata,cc );
		return teamSeasondata;
	}



	// 当天热点球员的排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<SingleMatchPersonalDataVO> hotSinglePlayer_Sort(
			ArrayList<SingleMatchPersonalDataVO> playerSeasondata,
			String condition) {

		// 先按名称排序
		Collections.sort(playerSeasondata, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				SingleMatchPersonalDataVO p1 = (SingleMatchPersonalDataVO) o1;
				SingleMatchPersonalDataVO p2 = (SingleMatchPersonalDataVO) o2;
				String name1 = p1.getPlayerReverseName();
				String name2 = p2.getPlayerReverseName();
				return name1.compareTo(name2);
			}
		});

		// 创建针对某个属性的升序比较
		Comparator player_compare = new BeanComparator(condition);
		// 默认的是升序，这里用一个降序
		player_compare = new ReverseComparator(player_compare);
		// 开始排序
		Collections.sort(playerSeasondata, player_compare);

		return playerSeasondata;
	}
	
	
	// 当天热点球员的多属性按优先级排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<SingleMatchPersonalDataVO> hotSinglePlayer_Sort(
			ArrayList<SingleMatchPersonalDataVO> playerSeasondata, String[] condition,boolean[] reverse) {
    // 先按名称排序
		Collections.sort(playerSeasondata, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				SingleMatchPersonalDataVO p1 = (SingleMatchPersonalDataVO) o1;
				SingleMatchPersonalDataVO p2 = (SingleMatchPersonalDataVO) o2;
				String name1 = p1.getPlayerReverseName();
				String name2 = p2.getPlayerReverseName();
				return name1.compareTo(name2);
			}
		});

	       //创建多属性排序链
        ComparatorChain cc = new ComparatorChain();
        //第一个参数是指定排序的属性，第二个参数指定降序升序
        for(int i=0;i<condition.length;i++){
        	if(condition[i]!=null){
        		cc.addComparator(new BeanComparator(condition[i]), reverse[i]);
        	}
        }
        Collections.sort(playerSeasondata,cc );
		return playerSeasondata;
	}


 
	/*public static void main(String[] args){
		System.out.println("进入main函数：");
		PlayerSeasonDataVO pvo1 = new PlayerSeasonDataVO("13-14", "John", null, "Eagle", "front", null, null, 1, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 35, 190, 100, 10, 10, 10, 10, 10, 10, 160, 150, null);
		PlayerSeasonDataVO pvo2 = new PlayerSeasonDataVO("13-14", "Bob", null, "EDG", "front", null, null, 1, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 34, 190, 102, 10, 10, 10, 10, 10, 130, 160, null);
		PlayerSeasonDataVO pvo3 = new PlayerSeasonDataVO("13-14", "William", null, "OMG", "front", null, null, 1, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 36, 190, 107, 10, 10, 10, 10, 10, 144, 144, 160, null);
		PlayerSeasonDataVO pvo4 = new PlayerSeasonDataVO("13-14", "Swen", null, "Tiger", "front", null, null, 1, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 55, 107, 10, 10, 10, 10, 10, 10, 10, 156, 99, null);
		PlayerSeasonDataVO pvo5 = new PlayerSeasonDataVO("13-14", "Keven", null, "Rabbit", "front", null, null, 1, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 22, 107, 105, 10, 10, 10, 10, 10, 111, 111, 99, null);
		PlayerSeasonDataVO pvo6 = new PlayerSeasonDataVO("13-14", "Blues", null, "WE", "front", null, null, 1, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 33, 107, 109, 10, 10, 10, 10, 10, 10, 90, 135, null);
		ArrayList<PlayerSeasonDataVO> list = new ArrayList<PlayerSeasonDataVO>();
		list.add(pvo1);
		list.add(pvo2);
		list.add(pvo3);
		list.add(pvo4);
		list.add(pvo5);
		list.add(pvo6);
		
		HotSort h= new HotSort();
	
	       System.out.println("----------------排序前-------------------------");
	        for(PlayerSeasonDataVO pvo:list){
	            System.out.println(pvo.getName()+"  "+pvo.getTeamName()+"  ["+pvo.getPointNum()+"]"+"  ["+pvo.getSeasonThreeNum()+"]"+"  ["+pvo.getSeasonDoubleNum()+"]");
	        }
	        System.out.println("-----------------多属性排序，排序后-------------------");
	        String[] conditions = {"pointNum_avg","assistNum_avg","foulNum_avg"};
	        boolean[] reverse = {true,true,false};
	        list = h.hotPlayer_Sort(list, conditions,reverse);
	        
	        for(PlayerSeasonDataVO pvo:list){
	            System.out.println(pvo.getName()+"  "+"  ["+pvo.getPointNum_avg()+"]"+"  ["+pvo.getAssistNum_avg()+"]"+"  ["+pvo.getFoulNum_avg()+"]");
	        }
	        
		
		
		
	}*/
}