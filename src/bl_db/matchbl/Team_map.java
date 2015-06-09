package bl_db.matchbl;

import java.util.HashMap;
import java.util.Map;

public class Team_map {
	 Map<String, String> map=new HashMap<String, String>();
	  
	
	   public Team_map(){
		   map.put( "ATL","老鹰");	
		   map.put( "BKN","篮网");
		   map.put("BOS","凯尔特人" );
		   map.put("CHA", "黄蜂");
		   map.put("CHI", "公牛");
		   map.put("CLE","骑士" );
		   map.put("DAL", "小牛");
		   map.put("DEN","掘金" );
		   map.put("DET", "活塞");
		   map.put("GSW","勇士" );
		   
		   
		   //---------------------
		   map.put("HOU", "火箭");
		   map.put("IND","步行者" );
		   map.put("LAC","快船" );
		   map.put("LAL","湖人" );	   
		   
		   map.put( "MEM","灰熊");

		   map.put("MIA", "热火");
		   map.put("MIL","雄鹿" );
		   map.put("MIN","森林狼" );
		    
		   map.put("NOP", "鹈鹕");
		   map.put("NYK","尼克斯" );
		   map.put("OKC", "雷霆");
		   map.put("ORL", "魔术");
		   //map.put("", "");   
		   
		   map.put("PHI","76人" );	   
		   
		   map.put( "PHX","太阳");
		   //
		   map.put( "POR","开拓者");
		   map.put( "SAC","国王");
		   map.put( "SAS","马刺");
		    
		   map.put("TOR", "猛龙");
		   map.put("UTA", "爵士");
		   map.put("WAS","奇才" );
		   
	/************************************	   
	 *************************************/
		   
		   
		   map.put("老鹰", "ATL");
		   map.put("篮网", "BKN");
		   map.put("凯尔特人", "BOS");
		   map.put("Hornets", "CHA");
		   map.put("公牛", "CHI");
		   map.put("骑士", "CLE");
		   map.put("小牛", "DAL");
		   map.put("掘金", "DEN");
		   map.put("活塞", "DET");
		   map.put("勇士", "GSW");
		   
		   
		   //---------------------
		   map.put("火箭", "HOU");
		   map.put("步行者", "IND");
		   map.put("快创", "LAC");
		   map.put("湖人", "LAL");	   
		   
		   map.put("灰熊", "MEM");

		   map.put("热火", "MIA");
		   map.put("Bucks", "MIL");
		   map.put("TimBerwolves", "MIN");
		    
		   map.put("鹈鹕", "NOP");
		   map.put("尼克斯", "NYK");
		   map.put("雷霆", "OKC");
		   map.put("魔术", "ORL");
		   //map.put("", "");   
		   
		   map.put("76人", "PHI");	   
		   
		   map.put("太阳", "PHX");
		   //
		   map.put("开拓者", "POR");
		   map.put("国王", "SAC");
		   map.put("马刺", "SAS");
		    
		   map.put("猛龙", "TOR");
		   map.put("爵士", "UTA");
		   map.put("奇才", "WAS");
		   map.put("unknown", "??");
	   }
	   
	   public  String getFullName(String item){
		   if(map.get(item)==null){
			   return "unknown";
		   }
		   return map.get(item).toString();
	   }
	   
	   public static void main(String args[]){
		   Team_map map=new Team_map();
		   System.out.println(map.getFullName("UTA"));
	   }
}
