package UI.common;

import java.util.HashMap;
import java.util.Map;

public class PartitionMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public PartitionMap(){
		   map.put("��", "  ");
		   map.put("����", "E");
		   map.put("����", "W");
		   
		   map.put("̫ƽ��", "Pacific");
		   map.put("������", "Atlantic");
		   map.put("����", "Southwest");
		   map.put("�в�", "Central");
		   map.put("������", "Northwest");
		   map.put("����", "Southeast");
		   
		   map.put( "  ","��");
		   map.put("E","����" );
		   map.put( "W","����");
		   
		   map.put("Pacific","̫ƽ��" );
		   map.put( "Atlantic","������");
		   map.put( "Southwest","����");
		   map.put("Central", "�в�");
		   map.put("Northwest", "������");
		   map.put( "Southeast","����");
		   
		  // map.put("�÷�/����/����", "");
	   }
	   public String getItem(String item){
		   System.out.println("��������item��"+item);
		   return map.get(item).toString();
	   }
}
