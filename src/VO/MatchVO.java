package VO;

import java.io.Serializable;
import java.util.ArrayList;

import bl_db.common.HotSort;
public class MatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String season;					//����
	private String date;					//��������
	private String matchScore;				//�����ȷ�
	private ArrayList<String> scores;		//������ÿ�ڱȷ�
	
	private TeamMatchVO  hostTeam;			//���ӵı�������
	private TeamMatchVO  guestTeam;			//�Ͷӵı�������
	
	public MatchVO(String season,String date,String matchScore,
			ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt){
		this.season=season;
		this.date=date;
		this.matchScore=matchScore;
		this.scores=scores;
		this.hostTeam=ht;
		this.guestTeam=gt;	
	}

	public String getSeason() {
		return season;
	}

	public String getDate() {
		return date;
	}

	public String getMatchScore() {
		return matchScore;
	}

	public ArrayList<String> getScores() {
		return scores;
	}

	public TeamMatchVO getHostTeam() {
		return hostTeam;
	}

	public TeamMatchVO getGuestTeam() {
		return guestTeam;
	}
	private ArrayList<SingleMatchPersonalDataVO> H_sort(String item){
		ArrayList<SingleMatchPersonalDataVO> list=hostTeam.getIndividualData();
		//list.addAll(guestTeam.getIndividualData());
		HotSort sort=new HotSort();
		return sort.hotSinglePlayer_Sort(list, item);	
	}
	
	
	private ArrayList<SingleMatchPersonalDataVO> G_sort(String item){
		ArrayList<SingleMatchPersonalDataVO> list=guestTeam.getIndividualData();
		//list.addAll(guestTeam.getIndividualData());
		HotSort sort=new HotSort();
		return sort.hotSinglePlayer_Sort(list, item);	
	}
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_point(){
		/*��ȡһ�������пͶӵ÷���*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("pointNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_rebound(){
		/*��ȡһ�������пͶ�������*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("reboundNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_assist(){
		/*��ȡһ�������пͶӵ�������**/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("assistNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_steal(){
		/*��ȡһ�������еĿͶ�������*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("stealNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_GuestTeam_Highest_block(){
		/*��ȡһ�������еĿͶӸ�ñ��*/
		ArrayList<SingleMatchPersonalDataVO>list= G_sort("blockNum");
		
		return list.get(0);
	}
	
	///////////////
	public SingleMatchPersonalDataVO get_HostTeam_Highest_point(){
		/*��ȡһ�����������ӵ÷���*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("pointNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_rebound(){
		/*��ȡһ������������������*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("reboundNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_assist(){
		/*��ȡһ�������е�����������**/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("assistNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_steal(){
		/*��ȡһ�������е�����������*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("stealNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_HostTeam_Highest_block(){
		/*��ȡһ�������е����Ӹ�ñ��*/
		ArrayList<SingleMatchPersonalDataVO>list= H_sort("blockNum");
		
		return list.get(0);
	}

	public void setHostTeam(TeamMatchVO hostTeam) {
		this.hostTeam = hostTeam;
	}

	public void setGuestTeam(TeamMatchVO guestTeam) {
		this.guestTeam = guestTeam;
	}
}
