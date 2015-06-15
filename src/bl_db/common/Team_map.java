package bl_db.common;

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
		   map.put("黄蜂", "CHA");
		   map.put("公牛", "CHI");
		   map.put("骑士", "CLE");
		   map.put("小牛", "DAL");
		   map.put("掘金", "DEN");
		   map.put("活塞", "DET");
		   map.put("勇士", "GSW");
		   
		   
		   //---------------------
		   map.put("火箭", "HOU");
		   map.put("步行者", "IND");
		   map.put("快船", "LAC");
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
		   map.put("爵士1", "UTA");
		   map.put("奇才", "WAS");
		   map.put("unknown", "??");
		   
		   /**************************************************************************************/
		   map.put("亚特兰大老鹰", "ATL");
		   map.put("布鲁克林篮网", "BKN");
		   map.put("波士顿凯尔特人", "BOS");
		   map.put("夏洛特黄蜂", "CHA");
		   map.put("芝加哥公牛", "CHI");
		   map.put("克里夫兰骑士", "CLE");
		   map.put("达拉斯小牛", "DAL");
		   map.put("丹佛掘金", "DEN");
		   map.put("底特律活塞", "DET");
		   map.put("金州勇士", "GSW");
		   
		   
		   //---------------------
		   map.put("休斯顿火箭", "HOU");
		   map.put("印第安纳步行者", "IND");
		   map.put("洛杉矶快船", "LAC");
		   map.put("洛杉矶湖人", "LAL");	   
		   
		   map.put("孟菲斯灰熊", "MEM");

		   map.put("迈阿密热火", "MIA");
		   map.put("密尔沃基雄鹿", "MIL");
		   map.put("明尼苏达森林狼", "MIN");
		    
		   map.put("新奥尔良鹈鹕", "NOP");
		   map.put("纽约尼克斯", "NYK");
		   map.put("俄克拉荷马雷霆", "OKC");
		   map.put("奥兰多魔术", "ORL");
		   //map.put("", "");   
		   
		   map.put("费城76人", "PHI");	   
		   
		   map.put("菲尼克斯太阳", "PHX");
		   //
		   map.put("波特兰开拓者", "POR");
		   map.put("萨克拉门托国王", "SAC");
		   map.put("圣安东尼奥马刺", "SAS");
		    
		   map.put("多伦多猛龙", "TOR");
		   map.put("犹他爵士", "UTA");
		   map.put("华盛顿奇才", "WAS");
		   
		   map.put("NULL", "NULL");
	   }
/**************************************************************************************/	   
	   public  String getFullName(String item){
		   if(map.get(item)==null){
			   return "unknown";
		   }
		   return map.get(item).toString();
	   }
	   
	   public static void main(String args[]){
		   Team_map map=new Team_map();
		   System.out.println(map.getFullName("爵士"));
	   }
}
