package businesslogic.bl.matchbl;

import java.util.ArrayList;

import businesslogic.bl.center.LastMatchDay;
import businesslogic.bl.center.SeasonInfo;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;

public class MatchDataFactory {
	ArrayList<MatchData> matchList;
	
	private LastMatchDay lastDay;
	
	public static void main(String args[]){
		MatchDataFactory l=new MatchDataFactory();
		ArrayList<MatchVO> list=l.get_A_Day_match("2013-12-03");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getDate());;
		}
	}
	public MatchDataFactory(){
 
		lastDay=new LastMatchDay("","");
		matchList=new ArrayList<>();
	}
	
	
	public ArrayList<String> getAllSeason(){
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<matchList.size();i++){
			list.add(matchList.get(i).getSeason()+"赛季");
		}
		return list;
	}
	
	public void add_A_match(MatchVO vo){
		
		lastDay.setSeason(vo.getSeason());
		lastDay.setDate(vo.getDate());
		for(int i=0;i<matchList.size();i++){
			/*当赛季子仓库已经存在，则直接添加*/
			if(matchList.get(i).getSeason().equals(vo.getSeason())){
				matchList.get(i).add_A_match(vo);
				/*System.out.println("添加比赛信息：" +vo.getDate()+"  ;"+
	vo.getHostTeam().getTeamName()+"-"+vo.getGuestTeam().getTeamName()+"比赛场数："+
				matchList.get(0).getMatchList().size());*/
				return;
			}
		}
				
		MatchData newSeason=new MatchData(vo.getSeason());
		newSeason.add_A_match(vo);
		matchList.add(newSeason);
		
	}
	
	public MatchVO get_A_match(String date,String teamb){
		String season=SeasonInfo.getSeason(date);
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(season)){
				return matchList.get(i).get_A_match(date, teamb);
			}
		}
		return null;
	}
	
	public ArrayList<MatchVO> get_A_Day_match(String date){
		String season=SeasonInfo.getSeason(date);
        //  System.out.println("赛季?："+season);
          
		for(int i=0;i<matchList.size();i++){
			//System.out.println("存在的赛季："+matchList.get(i).getSeason());
			if(matchList.get(i).getSeason().equals(season)){
			//	System.out.println("找到对应赛季。");
				return matchList.get(i).get_A_Day_Match(date);
			}
		}
		return null;  					//当对应的日期没有比赛信息时，返回null
	}

	public ArrayList<MatchVO> get_A_Season_team_match(String season,String teamAbb){
		
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(season)){
				return matchList.get(i).get_A_Season_Team_Match(teamAbb);
			}
		}
		return null;  					//当对应的日期没有比赛信息时，返回null
	}
	
	
	public ArrayList<SingleMatchPersonalDataVO> get_A_Aay_playMatchData(){
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(lastDay.getSeason())){
				return matchList.get(i).get_last_day_playerData(lastDay.getDate());
			}
		}
		
	
		return new ArrayList<SingleMatchPersonalDataVO>();
	}
	
}
