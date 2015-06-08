package businessService.blservice;

import java.util.ArrayList;

import VO.*;

public interface PlayerBLService{
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item);//��ȡ������ȵ���Ա����������ȵ���Ŀ

	//TODO ���ڵ���ʲô��ɸѡ---֮ǰд���Ǹ��ݱ��ġ����������á�
		//�����ֵΪ �������������͡��������ݡ����ţ���������п����������ַ�Ҳ�п�����Ӣ���ַ�����ֵ
		public ArrayList<PlayerSeasonDataVO> sort_super(String season,String type,String position,String partition,String item,String sign,int num);
		//TODO ����ĸ�����Ա
		public ArrayList<PlayerInfoVO> getPlayerInfoByFirstChar(String firstchar);
		//TODO ��������Ѿ�ʵ�ֵġ���������Ҫ�ĳ�ArrayListΪ����ֵ������name�ǲ��֣�������ĸ����//������Ա�����ֻ�ȡ��Ա�Ļ�����Ϣ
		public ArrayList<PlayerInfoVO> getPlayerInfo(String name);   
		//TODO ��Ҫ������������Ϊɸѡ��Ա����֮ǰ��������Ҫ��
		public ArrayList<PlayerSeasonDataVO> sort(String season,String type,String position,String partition,String item);
		
		//���մ����������ȡ���������е�������Ա����������
		public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  
		//TODO ��Ҫ������������//Ϊɸѡ��Ա��ʵ�ֶ༶���򣬽�֮ǰ��������Ҫ��
		public ArrayList<PlayerSeasonDataVO> sort(String season,String type,String position,String partition,
				 String[] condition,boolean[] reverse);
		public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //��ȡ������Ա�Ļ�����Ϣ
		public ArrayList<PlayerSeasonDataVO> keyfind( String text);
		//��ȡ�������ȵ���Ա,����Ĳ�����������ɸѡ��Ŀ
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);
		
		//TODO
		//������˵��׼����vo����峡����ɾ������Ҳ�����ˣ���Ҫ�ķ����Ҷ�д����
		//��ý��峡����ֻ��������������ǰĬ�ϣ��������;Ϳ���ѡ��ɣ������ҽ��淽���
		public ArrayList<SingleMatchPersonalDataVO> getLastFiveMatchData(String name);
		//���һ����Ա��������������
		public ArrayList<PlayerSeasonDataVO> getAPlayerSeasonData(String name,String type);
		//���������Ա��according
		public  ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item);
		//����ͼ�Ա�ĳ�����ݣ���Ա����,����������10����20����30��������������,��Ӧ�������ƣ�ƽ���÷֣����ֵȵȣ���	���û�����ݣ����Ӧλ�÷���0
		public double[] getPlayerOneData(String name,int num,String what);
		//���һ����Ա���������ı���
		public ArrayList<SingleMatchPersonalDataVO> getASeasonMatchData(String na, String season);
		//TODO ��Ҫ������������//������Ա������ȡ��Ա��ĳ�������ı�������
		
		public PlayerInfoVO getAPlayerInfo(String name);
		public PlayerSeasonDataVO getAPlayerSeasonData(String season,String type,String name);
	/**	
	//��Ҫ�ķ��������ȵ㷽����û�п�	
		
	//------------------------------------------------------------------------------------
	//�����ڷ�����ʱû���õ�
		public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,String teamAbb);    
		//������ӵ���д��ȡ������е���Ա��������ʵ����Կ��Ƿ������еĻ�����Ϣ������������	
	//--------------------------------------------------------------------
	 * 
		
	 *
		/////////////////////////���½ӿڽ�Ϊ���Է���		
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem);//��ȡ�����������ȵ���Ա,����Ĳ�����������ɸѡ��Ŀ
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem,int n);//��ȡ�����������ȵ���Ա,����ɸѡ��Ŀ�ͷ������ݸ���
		public  ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(String item,int n);//��ȡ���������Ա ������ɸѡ��Ŀ�ͷ������ݸ���
		
		public ArrayList<PlayerSeasonDataVO> getSortInfo(String position,String league,String age,String[] condition,boolean[] reverse);
		 */
}
