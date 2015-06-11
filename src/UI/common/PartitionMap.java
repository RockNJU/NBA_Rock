package UI.common;

import java.util.HashMap;
import java.util.Map;

public class PartitionMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public PartitionMap(){
		   map.put("所有分区", "  ");
		   map.put("东区", "E");
		   map.put("西区", "W");
		   
		   map.put("太平洋", "Pacific");
		   map.put("大西洋", "Atlantic");
		   map.put("西南", "Southwest");
		   map.put("中央", "Central");
		   map.put("西北", "Northwest");
		   map.put("东南", "Southeast");
		   
		   map.put( "  ","所有分区");
		   map.put("E","东区" );
		   map.put( "W","西区");
		   
		   map.put("Pacific","太平洋" );
		   map.put( "Atlantic","大西洋");
		   map.put( "Southwest","西南");
		   map.put("Central", "中央");
		   map.put("Northwest", "西北");
		   map.put( "Southeast","东南");
		   
		  // map.put("得分/篮板/助攻", "");
	   }
	   public String getItem(String item){
		   if(map.get(item)==null){
			   return "pointNum_avg";
		   }else
		   return map.get(item).toString();
	   }
}
