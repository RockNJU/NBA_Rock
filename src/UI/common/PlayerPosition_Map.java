package UI.common;

import java.util.HashMap;
import java.util.Map;

public class PlayerPosition_Map{
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public PlayerPosition_Map(){
		   map.put("ǰ��", "F");
		   map.put("����", "G");
		   map.put("�з�", "C");
		  // map.put("�÷�/����/����", "");
	   }
	   public String getItem(String item){
			   return map.get(item).toString();
	   }
}