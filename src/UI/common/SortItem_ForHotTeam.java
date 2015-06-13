package UI.common;

import java.util.HashMap;
import java.util.Map;

public class SortItem_ForHotTeam {

	     Map<String, String> map=new HashMap<String, String>();
	 
		
	   public SortItem_ForHotTeam(){
		
		   //////
		   map.put("得分", "pointNum");
		 
		   map.put("盖帽", "blockNum");
		   map.put("篮板", "reboundNum");
		   map.put("抢断", "stealNum");
		   map.put("助攻", "assistNum");
		   map.put("投篮命中率", "shootPercentage");
		   map.put("三分命中率", "t_shootPercentage");
		   map.put("罚球命中率", "freeThrowPercentage");
		   
		   
		  
		   //map.put("", "");   
	   }
	   
	   public String getItem(String item){
		   
		
		   if(map.get(item)==null){
			   return "pointNum_avg";
		   }
		   return map.get(item).toString();
	   }
	   
	   public static void main(String args[]){
		   SortItem_Map m=new SortItem_Map();

	   }
	   
	}
