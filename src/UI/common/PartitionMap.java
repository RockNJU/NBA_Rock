package UI.common;

import java.util.HashMap;
import java.util.Map;

public class PartitionMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public PartitionMap(){
		   map.put("���з���", "  ");
		   map.put("����", "E");
		   map.put("����", "W");
		   
		   map.put("̫ƽ��", "Pacific");
		   map.put("������", "Atlantic");
		   map.put("����", "Southwest");
		   map.put("����", "Central");
		   map.put("����", "Northwest");
		   map.put("����", "Southeast");
		   
		   map.put( "  ","���з���");
		   map.put("E","����" );
		   map.put( "W","����");
		   
		   map.put("Pacific","̫ƽ��" );
		   map.put( "Atlantic","������");
		   map.put( "Southwest","����");
		   map.put("Central", "����");
		   map.put("Northwest", "����");
		   map.put( "Southeast","����");
		   
		  // map.put("�÷�/����/����", "");
	   }
	   public String getItem(String item){
		   if(map.get(item)==null){
			   return "pointNum_avg";
		   }else
		   return map.get(item).toString();
	   }
}
