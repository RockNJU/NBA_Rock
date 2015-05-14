package businesslogic.bl.playerbl;

import java.util.ArrayList;

import businesslogic.bl.center.LastMatchDay;
import businesslogic.data.PlayerDataController;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerDataFactory {
	/**
	 *������Ա�����������Ļ�����Ϣ
	 **/
	ArrayList<PlayerInfoVO> infoList;
	ArrayList<PlayerSeasonData> dataList;
	private LastMatchDay lastDay;
	
	
	public PlayerDataFactory(String player_path){
		PlayerDataController plc=new PlayerDataController(player_path);
		infoList=plc.getAllPlayer();
		lastDay=new LastMatchDay("--","--");
		dataList=new ArrayList<>();
	}
	
	
	
	public void addPlayer_matchData(ArrayList<SingleMatchPersonalDataVO> list){
		
		lastDay.setSeason(list.get(0).getSeason());
		lastDay.setDate(list.get(0).getDate());
		for(int i=0;i<dataList.size();i++){
			//�����ݲֿ����Ѿ������ݵ�ʱ�������ݲֿ����������
			if(dataList.get(i).getSeason().equals(list.get(0).getSeason())){
			
				for(int k=0;k<list.size();k++){
				 dataList.get(i).updatePlayerSeasonData(list.get(k));
				}
				return;
			}
		}
		
		/*
		 * �����ݲֿ���û�ж�Ӧ�������ݵ�ʱ���½��ֿ��µ�һ��֧��֧
		 * */
		
		//System.out.println("��ӵĵ�  " +dataList.size()+"  ����:"+list.get(0).getSeason());
		PlayerSeasonData newData=new PlayerSeasonData(list.get(0).getSeason(),infoList);
		
		for(int k=0;k<list.size();k++){
			newData.updatePlayerSeasonData(list.get(k));
		}
		dataList.add(newData);
		
	}
	
	public ArrayList<PlayerInfoVO> getInfoList() {
		return infoList;
	}
	
	public ArrayList<PlayerSeasonDataVO> get_MostImprove(){
		
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(lastDay.getSeason())){
				return dataList.get(i).getPlayerDataList();
			}
		}
		return null;
	}
	
	public ArrayList<PlayerSeasonDataVO> getSeasonDataList(String season) {
		/*���������Ϊ����������ĳ��������������Ա�ı���������Ϣ*/
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).getPlayerDataList();
			}
		}
		return null;
	}
	
	public ArrayList<PlayerInfoVO> get_A_Team_Player(String season,String teamAbb){
		
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).get_A_Team_Player(teamAbb);
			}
		}
		return null;
	}
	
	
	public ArrayList<PlayerSeasonDataVO> get_Related_Player(String item){
		
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).season.equals(lastDay.getSeason())){
				return dataList.get(i).get_Related_Player(item);
			}
		}
		return new ArrayList<PlayerSeasonDataVO>();
	}

	public LastMatchDay getLastDay() {
		return lastDay;
	}
	
	
	
}
