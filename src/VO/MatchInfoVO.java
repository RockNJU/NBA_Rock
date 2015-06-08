package VO;

import java.util.ArrayList;

public class MatchInfoVO {
	/*������Ϣ����������Ϣ�б������ڣ���������֧�������д*/
	
	
	String season;
	private String date;		//�������ڣ���ʽxxxx-xx-xx
	private String time;        //�����ľ������ڡ�
	private String team_H;		//��������
	private String team_G;      //�Ͷ�����
	private String score;       //��ӱȷ�
	private String type;        //�������ͣ������������Ǽ�����
	private String isOver;
	private ArrayList<String> sc; //ÿС�ڵıȷ�
	String link;
	
	public MatchInfoVO(String date,String time,String teamH,
			String teamG,String isOver,
			String score,String type,ArrayList<String> cs,String link){
		this.isOver=isOver;
		this.date=date;
		this.time=time;
		this.team_H=teamH;
		this.team_G=teamG;
		this.sc=cs;
		this.score=score;
		this.type=type;
		this.link=link;
	}

	public String getLink(){
		return link;
	}
	public String getIsOver(){
		return isOver;
	}
	public String getMatchType(){
		return type;
	}
	public String getScore(){
		return score;
	}
	
	public ArrayList<String> getScores(){
		return sc;
	}
	
	public String getTime(){
		return time;
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


	public void setDate(String date) {
		this.date = date;
	}
	
}
