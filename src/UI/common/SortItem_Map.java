package UI.common;

import java.util.HashMap;
import java.util.Map;

public class SortItem_Map {
     Map<String, String> map=new HashMap<String, String>();
 
	
   public SortItem_Map(){
	   /*	private double =0;         //最近五场得分的提升率
	private double =0; 		//最近五场助攻的提升率
	private double =0;	int winNum;						 //胜利场数
		//最近五场篮板的提升率    //投篮效率*/
	   
	   map.put("胜利场数", "winNum");
	   map.put("胜率", "winRate");
	   
	   map.put("近五场得分提升率", "l_f_point_rate");
	   map.put("近五场助攻提升率", "l_f_assist_rate");
	   map.put("近五场篮板提升率", "l_f_rebound_rate");
	   
	   map.put("GmSc效率值", "gmSc");
	
	   map.put("篮板率", "reboundEfficiency_avg");
	   map.put("助攻率", "assistEfficiency_avg");
	   
	   map.put("真实命中率", "realShootPercentage");
	   map.put("投篮效率", "shootEfficiency");
	   map.put("盖帽率", "blockEfficiency_avg");
	   map.put("使用率", "usingPercentage_avg");
	   map.put("失误率", "turnoverPercentage");
	   map.put("抢断率", "stealEfficiency_avg");
	   map.put("防守效率", "defenseReboundEff_avg"); 
	   map.put("进攻效率", "offensiveReboundEff_avg");
	   /////////////
	   
	   map.put("两双数", "seasonDoubleNum");
	   map.put("三双数", "seasonThreeNum");
	   
	   map.put("投篮命中率", "shootPercentage");
	   map.put("三分命中率", "t_shootPercentage");
	   map.put("罚球命中率", "freeThrowPercentage");
	   
	   map.put("进攻篮板率", "o_ReboundEfficiency_avg");
	   map.put("防守篮板率", "d_ReboundEfficiency_avg");
	   
	   map.put("进攻回合", "offenseRound_avg");
	   
	   
	   map.put("参赛场数", "matchNum");
	   map.put("先发场数", "startingNum");
	   map.put("上场时间", "time_avg");
	   map.put("投篮命中数", "fieldGoal_avg");
	   map.put("投篮出手数", "shootNum_avg");
	   map.put("三分命中数", "t_fieldGoal_avg");
	   map.put("三分出手数", "t_shootNum_avg");
	   //////
	   map.put("得分", "pointNum_avg");
	   map.put("效率", "efficiency");
	   
	   map.put("效率 ", "efficiency");//后面多一个空格
	   map.put("犯规", "foulNum_avg");
	   map.put("失误", "turnoverNum_avg");
	   map.put("盖帽", "blockNum_avg");
	   map.put("篮板", "reboundNum_avg");
	   map.put("抢断", "stealNum_avg");
	   map.put("助攻", "assistNum_avg");
	   map.put("防守篮板", "d_ReboundNum_avg");
	   map.put("进攻篮板", "o_ReboundNum_avg");
	   map.put("罚篮数", "freeThrowNum_avg");
	   map.put("罚球数", "freeThrowNum_avg");
	   map.put("罚篮命中数", "freeThrowGoalNum_avg");
	   map.put("罚球命中数", "freeThrowGoalNum_avg");
	   ////////
	   
	   
	   map.put("防守", "d_ReboundNum_avg");
	   map.put("进攻", "o_ReboundNum_avg");
	   
	   map.put("防守篮板数", "d_ReboundNum_avg");
	   map.put("进攻篮板数", "o_ReboundNum_avg");
	   //---------------------
	   map.put("盖帽率 ", "blockEfficiency_avg");
	   map.put("篮板数", "reboundNum");
	   map.put("助攻数", "assistNum");
	   map.put("盖帽数", "blockNum");
	   map.put("抢断数", "stealNum");
	   map.put("犯规数", "foulNum");
	   map.put("失误数", "turoverNum");
	   map.put("得分总", "pointNum");
	   
	  
	   //map.put("", "");   
   }
   
   public String getItem(String item){
	   
	   System.out.println("传进来的item："+item);
	   
	   if(map.get(item)==null){
		   return "pointNum_avg";
	   }
	   return map.get(item).toString();
   }
   
   public static void main(String args[]){
	   SortItem_Map m=new SortItem_Map();
	   System.out.println("999"+"\u524D\u950B");
	   System.out.println("锟揭就检！"+m.getItem("\u524D\u950B"));
   }
   
}
