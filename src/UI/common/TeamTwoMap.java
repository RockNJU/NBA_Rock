package UI.common;

import java.util.HashMap;
import java.util.Map;

public class TeamTwoMap {
	
		 Map<String, String> map=new HashMap<String, String>();
		
		
		   public TeamTwoMap(){
			   map.put( "亚特兰大老鹰","老鹰");	
			   map.put( "布鲁克林篮网","篮网");
			   map.put("凯尔特人","凯尔特人" );
			   map.put("夏洛特黄蜂", "黄蜂");
			   map.put("芝加哥公牛", "公牛");
			   map.put("克里夫兰骑士","骑士" );
			   map.put("达拉斯小牛", "小牛");
			   map.put("丹佛掘金","掘金" );
			   map.put("底特律活塞", "活塞");
			   map.put("金州勇士","勇士" );
			   map.put("休斯顿火箭", "火箭");
			   map.put("印第安纳步行者","步行者" );
			   map.put("洛杉矶快船","快船" );
			   map.put("洛杉矶湖人","湖人" );	   
			   
			   map.put( "孟菲斯灰熊","灰熊");

			   map.put("迈阿密热火", "热火");
			   map.put("密尔沃基雄鹿","雄鹿" );
			   map.put("明尼苏达森林狼","森林狼" );
			   map.put("新奥尔良鹈鹕", "鹈鹕");
			   map.put("纽约尼克斯","尼克斯" );
			   map.put("俄克拉荷马雷霆", "雷霆");
			   map.put("奥兰多魔术", "魔术");
			   
			   map.put("费城76人","76人" );	   
			   
			   map.put( "菲尼克斯太阳","太阳");
			   //
			   map.put( "波特兰开拓者","开拓者");
			   map.put( "萨克拉门托国王","国王");
			   map.put( "圣安东尼奥马刺","马刺");
			    
			   map.put("多伦多猛龙", "猛龙");
			   map.put("犹他爵士", "爵士");
			   map.put("华盛顿奇才","奇才" );
			   
		/************************************	   
		 *************************************/
			   map.put( "老鹰","亚特兰大老鹰");	
			   map.put( "篮网","布鲁克林篮网");
			   map.put("凯尔特人","凯尔特人" );
			   map.put("黄蜂","夏洛特黄蜂");
			   map.put("公牛", "芝加哥公牛");
			   map.put("骑士","克里夫兰骑士" );
			   map.put("小牛", "达拉斯小牛");
			   map.put("掘金","丹佛掘金" );
			   map.put("活塞", "底特律活塞");
			   map.put("勇士","金州勇士" );
			   map.put("火箭", "休斯顿火箭");
			   map.put("步行者","印第安纳步行者" );
			   map.put("快船","洛杉矶快船" );
			   map.put("湖人","洛杉矶湖人" );	   
			   
			   map.put( "灰熊","孟菲斯灰熊");

			   map.put("热火", "迈阿密热火");
			   map.put("雄鹿","密尔沃基雄鹿" );
			   map.put("森林狼","明尼苏达森林狼" );
			   map.put("鹈鹕", "新奥尔良鹈鹕");
			   map.put("尼克斯","纽约尼克斯" );
			   map.put("雷霆", "俄克拉荷马雷霆");
			   map.put("魔术", "奥兰多魔术");
			   
			   map.put("76人","费城76人" );	   
			   
			   map.put( "太阳","菲尼克斯太阳");
			   //
			   map.put( "开拓者","波特兰开拓者");
			   map.put( "国王","萨克拉门托国王");
			   map.put( "马刺","圣安东尼奥马刺");
			    
			   map.put("猛龙", "多伦多猛龙");
			   map.put("爵士", "犹他爵士");
			   map.put("奇才","华盛顿奇才" );
			   
			
			   map.put("unknown", "??");	   
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
			   TeamTwoMap map=new TeamTwoMap();
			   System.out.println(map.getFullName("爵士"));
		   }
	}

