package VO;

public class MatchInfo {
	/*������Ϣ����������Ϣ�б������ڣ���������֧�������д*/
	private String date;		//�������ڣ���ʽxxxx-xx-xx
	private String team_H;		//��������
	private String team_G;      //�Ͷ�����
	
	public MatchInfo(String date,String teamH,String teamG){
		this.date=date;
		this.team_H=teamH;
		this.team_G=teamG;
	}

	public String getDate() {
		return date;
	}

	public String getTeam_H() {
		return team_H;
	}

	public String getTeam_G() {
		return team_G;
	}
	

}
