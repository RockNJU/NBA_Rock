package businesslogic.bl.teambl;

import java.util.ArrayList;

import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class TeamSeasonData {
	private String season;
	private ArrayList<TeamSeasonDataVO> teamSeasonList;
	private ArrayList<TeamInfoVO> infoList;
	
	public TeamSeasonData(String season,ArrayList<TeamInfoVO> list){
		this.season=season;	
		teamSeasonList=new ArrayList<TeamSeasonDataVO>();
		infoList=list;
	}
	
	
	public TeamInfoVO getTeamInfo(String teamAbb){
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getTeamAbb().equals(teamAbb)){
				return infoList.get(i);
			}
		}
		return new TeamInfoVO(teamAbb, teamAbb,"--", "--", "--", "--", "--", teamAbb, teamAbb, teamAbb, teamAbb);
	}
	
	public void updateTeamSeasonData(TeamMatchVO vo){
		for(int i=0;i<teamSeasonList.size();i++){
			if(teamSeasonList.get(i).getTeamName().equals(vo.getTeamName())){
				teamSeasonList.get(i).add_A_Match_Data(vo);      //�������б����Ѿ�����ĳ֧��ӵ�ʱ��ֱ�Ӹ��ݴ����������ݽ��и���
				return;
			}
		}
		/*
		 * String season,String teamName,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points, 
	 
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency
		 * */
		teamSeasonList.add(new TeamSeasonDataVO(vo.getSeason(),vo.getTeamName(),getTeamInfo(vo.getTeamName()), 1,vo.getWinNum(),
				vo.getFieldGoal(),vo.getShootNum(),vo.getT_fieldGoal(),vo.getT_shootNum(),
				vo.getFreeThrowGoalNum(),vo.getFreeThrowNum(),vo.getO_ReboundNum(),vo.getD_ReboundNum(),
				vo.getAssistNum(),vo.getStealNum(),vo.getReboundNum(),vo.getBlockNum(),vo.getTurnoverNum(),
				vo.getFoulNum(),vo.getPointNum(),vo.getOffenseRound(),vo.getOffenseEfficiency(),
				vo.getDefenseEfficiency(),vo.getO_ReboundEfficiency(),vo.getD_ReboundEfficiency(),
				vo.getStealEfficiency(),vo.getAssistEfficiency(), vo));            //�������б���û��ĳ֧��ӵ�ʱ�������֧��ӵ���Ϣ
	}
	
	
	
	public String getSeason() {
		return season;
	}
	
	public ArrayList<TeamSeasonDataVO> getTeamSeasnList() {
		return teamSeasonList;
	}
	
	public ArrayList<TeamSeasonDataVO> get_Related_team(String item){
		ArrayList<TeamSeasonDataVO> list=new ArrayList<>();
		for(int i=0;i<teamSeasonList.size();i++){
			if(teamSeasonList.get(i).getTeamName().contains(item)||
					teamSeasonList.get(i).getInfo().getTeam().equals(item)||
					teamSeasonList.get(i).getInfo().getDivision().equals(item)||
					teamSeasonList.get(i).getInfo().getPartition().contains(item)||
					teamSeasonList.get(i).getInfo().getLocation().equals(item)
					||teamSeasonList.get(i).getInfo().getHomeGround().contains(item)){
				list.add(teamSeasonList.get(i));
			}
		}
		return list;
		
	}
}
