package businesslogic.dataservice;
import java.util.ArrayList;
import businesslogic.PO.MatchPO;

public interface MatchDataService {
	/*
	 * ��Ϊ���ڸ���ֻ��һ����������˲�������ɸѡ����Ϊ������
	 * 
	 * */
	ArrayList<MatchPO> getAllMatch();
	MatchPO getMatch(String filepath);  		//team ��������ɣ����Ƕ�����д������HOU
	MatchPO getAMatch(String date,String teamName);		//�����ں�һ���ӻ�ȡһ����������
}
