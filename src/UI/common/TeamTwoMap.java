package UI.common;

import java.util.HashMap;
import java.util.Map;

public class TeamTwoMap {
	
		 Map<String, String> map=new HashMap<String, String>();
		
		
		   public TeamTwoMap(){
			   map.put( "����������ӥ","��ӥ");	
			   map.put( "��³��������","����");
			   map.put("��������","��������" );
			   map.put("�����ػƷ�", "�Ʒ�");
			   map.put("֥�Ӹ繫ţ", "��ţ");
			   map.put("���������ʿ","��ʿ" );
			   map.put("����˹Сţ", "Сţ");
			   map.put("������","���" );
			   map.put("�����ɻ���", "����");
			   map.put("������ʿ","��ʿ" );
			   map.put("��˹�ٻ��", "���");
			   map.put("ӡ�ڰ��ɲ�����","������" );
			   map.put("��ɼ�촬","�촬" );
			   map.put("��ɼ����","����" );	   
			   
			   map.put( "�Ϸ�˹����","����");

			   map.put("�������Ȼ�", "�Ȼ�");
			   map.put("�ܶ��ֻ���¹","��¹" );
			   map.put("�����մ�ɭ����","ɭ����" );
			   map.put("�°¶�������", "����");
			   map.put("ŦԼ���˹","���˹" );
			   map.put("�������������", "����");
			   map.put("������ħ��", "ħ��");
			   
			   map.put("�ѳ�76��","76��" );	   
			   
			   map.put( "�����˹̫��","̫��");
			   //
			   map.put( "������������","������");
			   map.put( "���������й���","����");
			   map.put( "ʥ����������","���");
			    
			   map.put("���׶�����", "����");
			   map.put("������ʿ", "��ʿ");
			   map.put("��ʢ�����","���" );
			   
		/************************************	   
		 *************************************/
			   map.put( "��ӥ","����������ӥ");	
			   map.put( "����","��³��������");
			   map.put("��������","��������" );
			   map.put("�Ʒ�","�����ػƷ�");
			   map.put("��ţ", "֥�Ӹ繫ţ");
			   map.put("��ʿ","���������ʿ" );
			   map.put("Сţ", "����˹Сţ");
			   map.put("���","������" );
			   map.put("����", "�����ɻ���");
			   map.put("��ʿ","������ʿ" );
			   map.put("���", "��˹�ٻ��");
			   map.put("������","ӡ�ڰ��ɲ�����" );
			   map.put("�촬","��ɼ�촬" );
			   map.put("����","��ɼ����" );	   
			   
			   map.put( "����","�Ϸ�˹����");

			   map.put("�Ȼ�", "�������Ȼ�");
			   map.put("��¹","�ܶ��ֻ���¹" );
			   map.put("ɭ����","�����մ�ɭ����" );
			   map.put("����", "�°¶�������");
			   map.put("���˹","ŦԼ���˹" );
			   map.put("����", "�������������");
			   map.put("ħ��", "������ħ��");
			   
			   map.put("76��","�ѳ�76��" );	   
			   
			   map.put( "̫��","�����˹̫��");
			   //
			   map.put( "������","������������");
			   map.put( "����","���������й���");
			   map.put( "���","ʥ����������");
			    
			   map.put("����", "���׶�����");
			   map.put("��ʿ", "������ʿ");
			   map.put("���","��ʢ�����" );
			   
			
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
			   System.out.println(map.getFullName("��ʿ"));
		   }
	}

