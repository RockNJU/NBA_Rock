package businessService.blservice;
import java.util.ArrayList;

import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
public interface MatchBLService {
	
	ArrayList<MatchVO> getMatchByTeamTime(String date); 
	            /*  ������������ڻ�ȡ��һ�����еı�����Ϣ
	          ������Ϣ MatchInfo ���matchbl���MAtchInfo���壬
	          ����Ϊ���֮ǰ����-������String���㣬ʡȥ���ǵķָ����               
	                         */
	MatchVO getMatchByTeam(String data,String teamA);
	        //������ӵ���д�ͱ������ڻ�ȡĳһ�����������ݣ�����һ��MatchVO
	
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item);//��ȡ������ȵ���Ա����������ȵ���Ŀ
	public ArrayList<SingleMatchPersonalDataVO> getTodayHotPlayer(String item,int n);//��ȡ������ȵ���Ա����������ȵ���Ŀ
	
	//TODO ��������Թ�ѡ����ʽ�����"13-14����",����ǹ��õġ�
	public ArrayList<String> getAllSeason();
	//TODO 
	ArrayList<MatchVO> getMatchBySeason(String season,String teamA);

}
