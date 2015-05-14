package businessService.blservice;
import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season);	
	//����ĳ��������������ӵ�����������Ϣ������Ĳ���Ϊ����
	
	//TODO ������teaminfovo
	public TeamSeasonDataVO get_A_TeamSeasonData(String season,String teamAbb);	
	public TeamInfoVO get_A_TeamInfo(String season,String teamAbb);	
	//���������������д��ȡһ֧�����ĳ�������ı�����Ϣ
	
	public double getTeamWinNum(String season,String teamAbb);
	//������������ӻ�ȡһ֧��ӵ�ʤ�ʣ�ע����һ������ǰ���µģ�ʤ����TeamSeasonDataVO���Ѿ����ˣ��Ҳ�֪���費��Ҫ
	
	
	
	public ArrayList<TeamSeasonDataVO> sort(String season,String sortItem);  //��������������� ���Զ���ӽ�������󷵻�
	
	
	
	public ArrayList<TeamSeasonDataVO> sort(String season,String[] condition,boolean[] reverse);  //���������Ͷ��������ʵ�� ���Զ���ӽ�������󷵻�
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
