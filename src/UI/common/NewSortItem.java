package UI.common;

import java.util.HashMap;
import java.util.Map;

public class NewSortItem {
	
	     Map<String, String> map=new HashMap<String, String>();
	 
		
	   public NewSortItem(){
		   /*	private double =0;         //����峡�÷ֵ�������
		private double =0; 		//����峡������������
		private double =0;	int winNum;						 //ʤ������
			//����峡�����������    //Ͷ��Ч��*/
		   
		   map.put("ʤ������", "winNum");
		   map.put("ʤ��", "winRate");
		   
		   map.put("���峡�÷�������", "l_f_point_rate");
		   map.put("���峡����������", "l_f_assist_rate");
		   map.put("���峡����������", "l_f_rebound_rate");
		   
		   map.put("GmScЧ��ֵ", "gmSc");
		
		   map.put("������", "reboundEfficiency");
		   map.put("������", "assistEfficiency");
		   
		   map.put("��ʵ������", "realShootPercentage");
		   map.put("Ͷ��Ч��", "shootEfficiency");
		   map.put("��ñ��", "blockEfficiency");
		   map.put("ʹ����", "usingPercentage");
		   map.put("ʧ����", "turnoverPercentage");
		   map.put("������", "stealEfficiency");
		   map.put("����Ч��", "defenseReboundEff"); 
		   map.put("����Ч��", "offensiveReboundEff");
		   /////////////
		   
		   map.put("��˫��", "seasonDoubleNum");
		   map.put("��˫��", "seasonThreeNum");
		   
		   map.put("Ͷ��������", "shootPercentage");
		   map.put("����������", "t_shootPercentage");
		   map.put("����������", "freeThrowPercentage");
		   
		   map.put("����������", "o_ReboundEfficiency");
		   map.put("����������", "d_ReboundEfficiency");
		   
		   map.put("�����غ�", "offenseRound");
		   
		   
		   map.put("��������", "matchNum");
		   map.put("�ȷ�����", "startingNum");
		   map.put("�ϳ�ʱ��", "time");
		   map.put("Ͷ��������", "fieldGoal");
		   map.put("Ͷ��������", "shootNum");
		   map.put("����������", "t_fieldGoal");
		   map.put("���ֳ�����", "t_shootNum");
		   //////
		   map.put("�÷�", "pointNum");
		   map.put("Ч��", "efficiency");
		   map.put("����", "foulNum");
		   map.put("ʧ��", "turnoverNum");
		   map.put("��ñ", "blockNum");
		   map.put("����", "reboundNum");
		   map.put("����", "stealNum");
		   map.put("����", "assistNum");
		   map.put("��������", "d_ReboundNum");
		   map.put("��������", "o_ReboundNum");
		   map.put("������", "freeThrowNum");
		   map.put("���������", "freeThrowNum");
		   map.put("������", "freeThrowNum");
		   map.put("����������", "freeThrowGoalNum");
		   map.put("����������", "freeThrowGoalNum");
		   ////////
		   
		   
		   map.put("����", "d_ReboundNum");
		   map.put("����", "o_ReboundNum");
		   
		   map.put("����������", "d_ReboundNum");
		   map.put("����������", "o_ReboundNum");
		   //---------------------
		   map.put("��ñ�� ", "blockEfficiency");
		   map.put("������", "reboundNum");
		   map.put("������", "assistNum");
		   map.put("��ñ��", "blockNum");
		   map.put("������", "stealNum");
		   map.put("������", "foulNum");
		   map.put("ʧ����", "turnoverNum");
		   map.put("�ܷ�", "pointNum");
		   
		  
		   //map.put("", "");   
	   }
	   
	   public String getItem(String item){
		   
		
		   if(map.get(item)==null){
			   return "pointNum";
		   }
		   return map.get(item).toString();
	   }
	   
	   public static void main(String args[]){
		   SortItem_Map m=new SortItem_Map();

	   }
	   
	}
