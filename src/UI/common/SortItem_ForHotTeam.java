package UI.common;

import java.util.HashMap;
import java.util.Map;

public class SortItem_ForHotTeam {

	     Map<String, String> map=new HashMap<String, String>();
	 
		
	   public SortItem_ForHotTeam(){
		
		   //////
		   map.put("�÷�", "pointNum");
		 
		   map.put("��ñ", "blockNum");
		   map.put("����", "reboundNum");
		   map.put("����", "stealNum");
		   map.put("����", "assistNum");
		   map.put("Ͷ��������", "shootPercentage");
		   map.put("����������", "t_shootPercentage");
		   map.put("����������", "freeThrowPercentage");
		   
		   
		  
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
