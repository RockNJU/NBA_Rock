package businesslogic.bl.teambl;
import java.util.ArrayList;

import businesslogic.bl.center.LastMatchDay;
import businesslogic.data.TeamData;
import businesslogic.dataservice.TeamDataService;
import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class TeamDataFactory {
	  ArrayList<TeamInfoVO> infoList;
	  ArrayList<TeamSeasonData> dataList;
	  private LastMatchDay lastDay;
	  
	  public TeamDataFactory(String path){
		  TeamDataService td=new TeamData(path);
		  infoList=td.getTeamInfoList();
		  dataList=new ArrayList<>();
		  lastDay=new LastMatchDay("--","--");
	  }
	  
	 public TeamInfoVO get_A_teamInfo(String teamAbb){
		 for(int i=0;i<infoList.size();i++){
			 if(infoList.get(i).getTeamAbb().equals(teamAbb)|
					 infoList.get(i).getFullName().equals(teamAbb)){
				 return infoList.get(i);
			 }
		 }
		 return null;
	 } 
	  
	public void update_A_matchData(TeamMatchVO vo){
		/*添加一场比赛过后，球队的赛季信息发生变化*/
		lastDay.setSeason(vo.getSeason());
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(vo.getSeason())){
				dataList.get(i).updateTeamSeasonData(vo);
				return;
			}
		}
		
		
		
		//当球队数据仓库中没有对应赛季的数据时，添加一个赛季的ArrayList数据
		TeamSeasonData data=new TeamSeasonData(vo.getSeason(), infoList);
		data.updateTeamSeasonData(vo);
		dataList.add(data);
	}
	
	public TeamSeasonDataVO get_A_TeamSeasonData(String season,String teamAbb){
		ArrayList<TeamSeasonDataVO> list=getALLTeamSeasonData(season);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTeamName().equals(teamAbb))
				return list.get(i);
		}
		return null;
	}
	
	public ArrayList<TeamSeasonDataVO> getALLTeamSeasonData(String season){
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).getTeamSeasnList();   
				//返回整个赛季有的所有球队的赛季总体信息
			}
		}
		return null;   //当没有对应赛季的数据的时候，返回空。
	}
	
	
	public ArrayList<TeamInfoVO> getInfoList() {
		return infoList;
	}
	
	public void setInfoList(ArrayList<TeamInfoVO> infoList) {
		this.infoList = infoList;
	}
	public ArrayList<TeamSeasonData> getDataList(){
		return dataList;
	}
	
	public ArrayList<TeamSeasonDataVO> get_team_related_Info(String item){
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(lastDay.getSeason())){
				return dataList.get(i).get_Related_team(item);
			}
		}
		return null;
	}

	public LastMatchDay getLastDay() {
		return lastDay;
	}
}
