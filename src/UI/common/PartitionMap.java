package UI.common;

import java.util.HashMap;
import java.util.Map;

public class PartitionMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public PartitionMap(){
		   map.put("无", "  ");
		   map.put("东区", "E");
		   map.put("西区", "W");
		   
		   map.put("太平洋", "Pacific");
		   map.put("大西洋", "Atlantic");
		   map.put("西南", "Southwest");
		   map.put("中部", "Central");
		   map.put("西北部", "Northwest");
		   map.put("东南", "Southeast");
		   
		   map.put( "  ","无");
		   map.put("E","东区" );
		   map.put( "W","西区");
		   
		   map.put("Pacific","太平洋" );
		   map.put( "Atlantic","大西洋");
		   map.put( "Southwest","西南");
		   map.put("Central", "中部");
		   map.put("Northwest", "西北部");
		   map.put( "Southeast","东南");
		   
		  // map.put("得分/篮板/助攻", "");
	   }
	   public String getItem(String item){
		   System.out.println("传进来的item："+item);
		   return map.get(item).toString();
	   }
}
