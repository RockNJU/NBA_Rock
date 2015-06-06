package businessService.blservice;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	//TODO 2015/5/18 ��
	public ArrayList<String> getTeamByPartition(String partition);
	//TODO
	public ArrayList<PlayerSeasonDataVO> getKingPlayerForATeam(String tamename, String item);

		
	public ArrayList<TeamSeasonDataVO> sort_super(String season,String type,String item,String sign,int num);
	//TODO ���Ĭ������
	public String getdefaultseason();
	
	//TODO ������������
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season,String type);	
	//����ĳ��������������ӵ�����������Ϣ������Ĳ���Ϊ����

	public ArrayList<TeamSeasonDataVO> sort(String season,String type,String sortItem);  //��������������� ���Զ���ӽ�������󷵻�
	public ArrayList<TeamSeasonDataVO> sort(String season,String type,String[] condition,boolean[] reverse);  //���������Ͷ��������ʵ�� ���Զ���ӽ�������󷵻�
	
	
	
	//-------------------------------------------------------------------
	//���������������д��ȡһ֧�����ĳ�������ı�����Ϣ
	
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season);
	public double getTeamWinNum(String season, String teamAbb) ;
	//====================�������跽��============================
	//���������Ƴ�����  
	public ArrayList<TeamSeasonDataVO> sort(String[] condition,boolean[] reverse);  //���ݶ��������ʵ�� ���Զ���ӽ�������󷵻�
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season,String item);
	//����������ɸѡ������ ��ȡ�����ȵ���ӣ�������ǰ������
	//===========================�������跽��===========
	public ArrayList<TeamSeasonDataVO> getHotTeam(String item);   
	//����ɸѡ������ ��ȡ�����ȵ���ӣ����е�  ����������ǰ5

	//TODO ��֪�����ǵĸ��ݹؼ��ʲ��ҵ�������ʲô��˼���Ҿ���������ؼ��ʣ����ط���Ҫ��Ķ���arraylist��������ò��ÿ�������
	public ArrayList<TeamSeasonDataVO> find(String text);

	
	
}
