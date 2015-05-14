package businesslogic.bl.playerbl;

import java.util.ArrayList;
 
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerSeasonData {
	String season;
	private ArrayList<PlayerInfoVO> infoList;
	ArrayList<PlayerSeasonDataVO> playerDataList;  //西部球员的比赛数据
	
	public PlayerSeasonData(String season,ArrayList<PlayerInfoVO> info){
		this.season=season;
		playerDataList=new ArrayList<>();
		this.infoList=info;
	}

	public String getSeason(){
		return season;
	}
    
	
	private String getPlayerPOsition(String name){
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getName().equals(name))
				return infoList.get(i).getPosition();
						
		}
		return "--";
	}
	
	public PlayerInfoVO get_PlayerInfo(String name){
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getName().equals(name))
				return infoList.get(i);
						
		}
		return new PlayerInfoVO(name, "--", "--", "--", 0, "--", 0, 0, "--");
	}
	
	public void updatePlayerSeasonData(SingleMatchPersonalDataVO vo){
		int i;
		for( i=0;i<playerDataList.size();i++){
			
			if(playerDataList.get(i).getName().equals(vo.getPlayerName())){
				playerDataList.get(i).add_A_MatchData(vo);
				playerDataList.get(i).setTeamName(vo.getTeamName());
				playerDataList.get(i).setDivision(vo.getDivision());
				playerDataList.get(i).setPartition(vo.getPartition());
				return;
				//当球员的数据仓库中已经存在其对应的赛季信息时，更新其信息。
			}
		}
		
		//System.out.println("添加第  "  +playerDataList.size()+ "  个球员 。");
		//当球员的赛季信息没有存在数据仓库中的时候，往其中添加数据
		int startingNum=0;
		int seasonDoubleNum=0;
		int seasonThreeNum=0;
		if(vo.getPlayerPosition()!=null&vo.getPlayerPosition().length()!=0){
			startingNum=1;
		}
		
		int count=0;
		 if(vo.getPointNum()>=10)
			 count++;
		 if(vo.getReboundNum()>=10)
			 count++;
		 if(vo.getBlockNum()>=10)
			 count++;
		 if(vo.getStealNum()>=10)
			 count++;
		 if(vo.getAssistNum()>=10)
			 count++;
		 
		 if(count==2){
		 seasonDoubleNum++;
		 }else if(count==3){
		 seasonThreeNum++;   //计算三双数
		 }
		
		PlayerSeasonDataVO newData=new PlayerSeasonDataVO(season,vo.getPlayerName(),
				get_PlayerInfo(vo.getPlayerName()), vo.getTeamName(),vo.getDivision(),
				vo.getPartition(),getPlayerPOsition(vo.getPlayerName()),1,startingNum,vo.getTime(),
				vo.getFieldGoal(),vo.getShootNum(),vo.getT_fieldGoal(),vo.getT_shootNum(),
				vo.getFreeThrowGoalNum(),vo.getFreeThrowNum(),vo.getO_ReboundNum(),
				vo.getD_ReboundNum(),vo.getReboundNum(),
				vo.getAssistNum(),vo.getStealNum(),vo.getBlockNum(),vo.getTurnoverNum(),
				vo.getFoulNum(),vo.getPointNum(),vo.getAssistEfficiency(),vo.getReboundEfficiency(),
				vo.getOffensiveReboundEff(),vo.getDefenseReboundEff(),
				vo.getStealEfficiency(),vo.getUsingPercentage(),
				vo.getBlockEfficiency(),seasonDoubleNum,seasonThreeNum,vo);
		playerDataList.add(newData);
		
	}
	
	public void setSeason(String season) {
		this.season = season;
	}

	public ArrayList<PlayerSeasonDataVO> getPlayerDataList() {
		return playerDataList;
	}

	public void setPlayerDataList(ArrayList<PlayerSeasonDataVO> playerDataList) {
		this.playerDataList = playerDataList;
	}
	
	public ArrayList<PlayerInfoVO> get_A_Team_Player(String teamAbb){
		ArrayList<PlayerInfoVO> list=new ArrayList<>();
		for(int i=0;i<playerDataList.size();i++){
			if(playerDataList.get(i).getTeamName().equals(teamAbb)){
				list.add(playerDataList.get(i).getInfo());
			}
		}
		return list;
	}
	
	public ArrayList<PlayerSeasonDataVO> get_Related_Player(String item){
		ArrayList<PlayerSeasonDataVO> list=new ArrayList<>();
		for(int i=0;i<playerDataList.size();i++){
			if(playerDataList.get(i).getTeamName().contains(item)|
					playerDataList.get(i).getName().contains(item)|
					playerDataList.get(i).getInfo().getPosition().contains(item)){
				list.add(playerDataList.get(i));
			}
		}
		return list;
	}
}
