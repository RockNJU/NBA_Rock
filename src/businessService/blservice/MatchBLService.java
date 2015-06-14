package businessService.blservice;
import java.util.ArrayList;
import VO.MatchInfoVO;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
public interface MatchBLService {
	//���Ĭ�����������µ�δ���е����б���������
	public ArrayList<MatchInfoVO> getPro_NotOver(String season,int month);
	
	   //������̣�ĳ������ĳ�µ����̣�����Ҫ�ķ���(no need)
	   public ArrayList<MatchInfoVO> getPro_ByMonth(String season,int month);
	   
	   //�������õ�ArrayList<MatchInfoVO>���д���,���   ��ĳ������ĳ�µ����̣������ϸ������ķ���ֵ�����б���������
	   public ArrayList<String> getDatesOfPro_ByMonth(String season,int month);
	   //������̣�ĳ������ĳ�¡�ĳ������̣�����Ҫ�ķ���    month��day������ȶ
	   public ArrayList<MatchInfoVO> getPro_ByDay(String season,int month,int day);
	  
	   //���������̣�ĳ������ĳ�¡�ĳ��ӣ�
	   public ArrayList<MatchInfoVO> getPro_ForTeam(String season,int month,String teamabb);

	   //TODO �������б���������
		public String getLastHavingMatchDate();
		
		//TODO ��ô������ں����һ������������ �����date 2014-01-02 ��ʽ��������Ը�
		public String getNextHavingMatchDate(String date);
		
		// ��������Թ�ѡ����ʽ�����"13-14����",����ǹ��õġ�
		public ArrayList<String> getAllSeason();
		
		
		ArrayList<MatchInfoVO> getMatchBySeason(String season,String type,String teamA);
		
		ArrayList<MatchInfoVO> getMatchByTeamTime(String date);			
        //  ������������ڻ�ȡ��һ�����еı�����Ϣ
      //������Ϣ MatchInfo ���matchbl���MAtchInfo���壬
      //����Ϊ���֮ǰ����-������String���㣬ʡȥ���ǵķָ����
		
		public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,int n);//��ȡ������ȵ���Ա����������ȵ���Ŀ
		
		MatchVO getMatchByTeam(String data,String teamA);

		
		/*
	        //������ӵ���д�ͱ������ڻ�ȡĳһ�����������ݣ�����һ��MatchVO
	

	
*/
}
