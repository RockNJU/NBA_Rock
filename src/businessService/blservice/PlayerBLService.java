package businessService.blservice;

import java.util.ArrayList;

import VO.*;

public interface PlayerBLService{
	//TODO ���ڵ���ʲô��ɸѡ---֮ǰд���Ǹ��ݱ��ġ����������á�
	//�����ֵΪ �������������͡��������ݡ����ţ���������п����������ַ�Ҳ�п�����Ӣ���ַ�����ֵ
	public ArrayList<PlayerSeasonDataVO> sort_super(String season,String type,String item,String sign,int num);

	//TODO ����ĸ�����Ա
	public ArrayList<PlayerInfoVO> getPlayerInfoByFirstChar(String firstchar);
	
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,String name);//������Ա������ȡ��Ա��ĳ�������ı�������

	//TODO ��������Ѿ�ʵ�ֵġ���������Ҫ�ĳ�ArrayListΪ����ֵ������name�ǲ��֣�������ĸ����
	public ArrayList<PlayerInfoVO> getPlayerInfo(String name);   //������Ա�����ֻ�ȡ��Ա�Ļ�����Ϣ
	public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //��ȡ������Ա�Ļ�����Ϣ
	
	//TODO ��Ҫ������������
	public ArrayList<PlayerSeasonDataVO> sort(String season,String type,String position,String partition,String item);/*Ϊɸѡ��Ա����֮ǰ��������Ҫ��*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);//��ȡ�������ȵ���Ա,����Ĳ�����������ɸѡ��Ŀ
	
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  //���մ����������ȡ���������е�������Ա����������
	
	 
	//     ��������-���д˹ؼ��ʵ���Ա�ı�����Ϣ��������Ϊ��������ֻ��ס���ջ�����ĸ
	public ArrayList<PlayerSeasonDataVO> keyfind( String text);
	
		public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,String teamAbb);    
		//������ӵ���д��ȡ������е���Ա��������ʵ����Կ��Ƿ������еĻ�����Ϣ������������
		
		public  ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item);

		public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String partition,
						 String[] condition,boolean[] reverse);/*Ϊɸѡ��Ա��ʵ�ֶ༶���򣬽�֮ǰ��������Ҫ��*/
		
		
		/////////////////////////���½ӿڽ�Ϊ���Է���
		
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem);//��ȡ�����������ȵ���Ա,����Ĳ�����������ɸѡ��Ŀ
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem,int n);//��ȡ�����������ȵ���Ա,����ɸѡ��Ŀ�ͷ������ݸ���
		public  ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item,int n);//��ȡ���������Ա ������ɸѡ��Ŀ�ͷ������ݸ���
		
		public ArrayList<PlayerSeasonDataVO> getSortInfo(String position,String league,String age,String[] condition,boolean[] reverse);
		 
}
