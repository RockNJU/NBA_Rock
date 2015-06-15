package bl_db.common;

import java.util.HashMap;
import java.util.Map;

public class Team_map {
	 Map<String, String> map=new HashMap<String, String>();
	  
	
	   public Team_map(){
		   map.put( "ATL","��ӥ");	
		   map.put( "BKN","����");
		   map.put("BOS","��������" );
		   map.put("CHA", "�Ʒ�");
		   map.put("CHI", "��ţ");
		   map.put("CLE","��ʿ" );
		   map.put("DAL", "Сţ");
		   map.put("DEN","���" );
		   map.put("DET", "����");
		   map.put("GSW","��ʿ" );
		   
		   
		   //---------------------
		   map.put("HOU", "���");
		   map.put("IND","������" );
		   map.put("LAC","�촬" );
		   map.put("LAL","����" );	   
		   
		   map.put( "MEM","����");

		   map.put("MIA", "�Ȼ�");
		   map.put("MIL","��¹" );
		   map.put("MIN","ɭ����" );
		    
		   map.put("NOP", "����");
		   map.put("NYK","���˹" );
		   map.put("OKC", "����");
		   map.put("ORL", "ħ��");
		   //map.put("", "");   
		   
		   map.put("PHI","76��" );	   
		   
		   map.put( "PHX","̫��");
		   //
		   map.put( "POR","������");
		   map.put( "SAC","����");
		   map.put( "SAS","���");
		    
		   map.put("TOR", "����");
		   map.put("UTA", "��ʿ");
		   map.put("WAS","���" );
		   
	/************************************	   
	 *************************************/
		   
		   
		   map.put("��ӥ", "ATL");
		   map.put("����", "BKN");
		   map.put("��������", "BOS");
		   map.put("�Ʒ�", "CHA");
		   map.put("��ţ", "CHI");
		   map.put("��ʿ", "CLE");
		   map.put("Сţ", "DAL");
		   map.put("���", "DEN");
		   map.put("����", "DET");
		   map.put("��ʿ", "GSW");
		   
		   
		   //---------------------
		   map.put("���", "HOU");
		   map.put("������", "IND");
		   map.put("�촬", "LAC");
		   map.put("����", "LAL");	   
		   
		   map.put("����", "MEM");

		   map.put("�Ȼ�", "MIA");
		   map.put("Bucks", "MIL");
		   map.put("TimBerwolves", "MIN");
		    
		   map.put("����", "NOP");
		   map.put("���˹", "NYK");
		   map.put("����", "OKC");
		   map.put("ħ��", "ORL");
		   //map.put("", "");   
		   
		   map.put("76��", "PHI");	   
		   
		   map.put("̫��", "PHX");
		   //
		   map.put("������", "POR");
		   map.put("����", "SAC");
		   map.put("���", "SAS");
		    
		   map.put("����", "TOR");
		   map.put("��ʿ1", "UTA");
		   map.put("���", "WAS");
		   map.put("unknown", "??");
		   
		   /**************************************************************************************/
		   map.put("����������ӥ", "ATL");
		   map.put("��³��������", "BKN");
		   map.put("��ʿ�ٿ�������", "BOS");
		   map.put("�����ػƷ�", "CHA");
		   map.put("֥�Ӹ繫ţ", "CHI");
		   map.put("���������ʿ", "CLE");
		   map.put("����˹Сţ", "DAL");
		   map.put("������", "DEN");
		   map.put("�����ɻ���", "DET");
		   map.put("������ʿ", "GSW");
		   
		   
		   //---------------------
		   map.put("��˹�ٻ��", "HOU");
		   map.put("ӡ�ڰ��ɲ�����", "IND");
		   map.put("��ɼ�촬", "LAC");
		   map.put("��ɼ����", "LAL");	   
		   
		   map.put("�Ϸ�˹����", "MEM");

		   map.put("�������Ȼ�", "MIA");
		   map.put("�ܶ��ֻ���¹", "MIL");
		   map.put("�����մ�ɭ����", "MIN");
		    
		   map.put("�°¶�������", "NOP");
		   map.put("ŦԼ���˹", "NYK");
		   map.put("�������������", "OKC");
		   map.put("������ħ��", "ORL");
		   //map.put("", "");   
		   
		   map.put("�ѳ�76��", "PHI");	   
		   
		   map.put("�����˹̫��", "PHX");
		   //
		   map.put("������������", "POR");
		   map.put("���������й���", "SAC");
		   map.put("ʥ����������", "SAS");
		    
		   map.put("���׶�����", "TOR");
		   map.put("������ʿ", "UTA");
		   map.put("��ʢ�����", "WAS");
		   
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
		   System.out.println(map.getFullName("��ʿ"));
	   }
}
