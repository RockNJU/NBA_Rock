package businesslogic.bl.playerbl;
 
import java.util.ArrayList;

import businessService.blservice.PlayerBLService;
import businesslogic.bl.center.HotSort;
import VO.*;

public class PlayerController implements PlayerBLService {
	   PlayerDataFactory playerFactory;    
	   
	    public PlayerController(String player_path){
	    	playerFactory=new PlayerDataFactory(player_path);
	    }
		public void updatePlayerData(ArrayList<SingleMatchPersonalDataVO> list){
			/*һ�����������һ֧�����Ա�Ļ�����Ϣ*/
				playerFactory.addPlayer_matchData(list); 
				
		}
		
		public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,
				String name) {
			ArrayList<PlayerSeasonDataVO> list=getPlayerSeasonData(season);
			for(int i=0;i<list.size();i++){
				if(list.get(i).getName().equals(name)){
					return list.get(i);
				}
			}
			return null;
		}
		
		@Override
		public ArrayList<PlayerInfoVO> getAllPlayerInfo() {
			// TODO Auto-generated method stub
			return playerFactory.getInfoList();
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,
				String sortItem) {
			// TODO Auto-generated method stub
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(season) ;
			HotSort sort=new HotSort();
			list= sort.hotPlayer_Sort(list,sortItem);
			for(int i=0;i<5;i++){
				result.add(list.get(i));
			}
			return result;
		}
		
		@Override
		public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season) {
			// TODO Auto-generated method stub
			return playerFactory.getSeasonDataList(season);
		}
	///////////////////////////////////////һ�²�������������
		
		public ArrayList<PlayerSeasonDataVO> sort(String season,
				String position, String partition, String item) {
			// TODO Auto-generated method stub
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(season) ;
		//	System.out.println("ɸѡǰ��"+"list�Ĵ�С"+list.size());
			
			if(partition==null|partition.trim().length()==0){
				if(position.length()>=1){
					list=sort_position(list,position);
					//System.out.println("��Աλ��ɸѡ��"+"list�Ĵ�С��"+list.size());
				}
				HotSort sort=new HotSort();
				return sort.hotPlayer_Sort(list,item);
			}
			
			
			if(partition.trim().length()>1){
				list=sort_partition(list,partition);
				//System.out.println("����ɸѡ��"+"list�Ĵ�С��"+list.size());
				if(position.length()>=1){
					list=sort_position(list,position);
					//System.out.println("��Աλ��ɸѡ��"+"list�Ĵ�С��"+list.size());
				}
				HotSort sort=new HotSort();
				return sort.hotPlayer_Sort(list,item);
			}
			
			if(partition.trim().equals("E")|partition.equals("W")){
				
				list=sort_division(list,partition);
				
			//	System.out.println("Division����ɸѡ��"+"list�Ĵ�С��"+list.size());
			}
			
			
			if(position.length()>=1){
				list=sort_position(list,position);
				//System.out.println("��Աλ��ɸѡ��"+"list�Ĵ�С��"+list.size());
			}
			HotSort sort=new HotSort();
			return sort.hotPlayer_Sort(list,item);
		}
		private  ArrayList<PlayerSeasonDataVO> sort_division(ArrayList<PlayerSeasonDataVO>list,
				String division) {
			 /*������ɸѡ*/
			ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getDivision().equals(division)){
				vo.add(list.get(i));
				}
			}
			return vo;
			}
			
		 
		private ArrayList<PlayerSeasonDataVO> sort_partition(ArrayList<PlayerSeasonDataVO>list,
				String partition) {
			 
			ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getPartition().equals(partition)){
				vo.add(list.get(i));
				}
			}
			return vo;
		}
		
		private ArrayList<PlayerSeasonDataVO> sort_position(ArrayList<PlayerSeasonDataVO>list,String position){
			/*����ط��д�˼��*/
			ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getInfo().getPosition().contains(position)){
				vo.add(list.get(i));
				}
			}
			return vo;
			 
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> keyfind(String text) {
			// TODO Auto-generated method stub
			return playerFactory.get_Related_Player(text);
		}
		public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,String teamAbb) {
			// TODO Auto-generated method stub
			return playerFactory.get_A_Team_Player(season, teamAbb);
		}
		@Override
		public  ArrayList<PlayerSeasonDataVO>  getMost_Progress_Player(String item) {
			// TODO Auto-generated method stub
			
			ArrayList<PlayerSeasonDataVO> list= playerFactory.get_MostImprove() ;
			HotSort sort=new HotSort();
			
			list=sort.hotPlayer_Sort(list,item);
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			for(int i=0;i<5;i++){
				result.add(list.get(i));
			}
			 return result;
		}
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String sortItem) {
			// TODO Auto-generated method stub
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(playerFactory.getLastDay().getSeason()) ;
			HotSort sort=new HotSort();
			list= sort.hotPlayer_Sort(list,sortItem);
			for(int i=0;i<5;i++){
				result.add(list.get(i));
			}
			return result;
		}
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(
				String sortItem, int n) {
			// TODO Auto-generated method stub
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(playerFactory.getLastDay().getSeason()) ;
			HotSort sort=new HotSort();
			list= sort.hotPlayer_Sort(list,sortItem);
			for(int i=0;i<n;i++){
				result.add(list.get(i));
			}
			return result;
		}
		public ArrayList<PlayerSeasonDataVO> sort(String season,
				String position, String partition, String[] condition,
				boolean[] reverse) {
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(season) ;
			//	System.out.println("ɸѡǰ��"+"list�Ĵ�С"+list.size());
				
				if(partition==null|partition.trim().length()==0){
					if(position.length()>=1){
						list=sort_position(list,position);
						//System.out.println("��Աλ��ɸѡ��"+"list�Ĵ�С��"+list.size());
					}
					HotSort sort=new HotSort();
					return sort.hotPlayer_Sort(list, condition,
							  reverse);
				}
				
				
				if(partition.trim().length()>1){
					list=sort_partition(list,partition);
					//System.out.println("����ɸѡ��"+"list�Ĵ�С��"+list.size());
					if(position.length()>=1){
						list=sort_position(list,position);
						//System.out.println("��Աλ��ɸѡ��"+"list�Ĵ�С��"+list.size());
					}
					HotSort sort=new HotSort();
					return sort.hotPlayer_Sort(list, condition,
							  reverse);
				}
				
				if(partition.trim().equals("E")|partition.equals("W")){
					
					list=sort_division(list,partition);
					
				//	System.out.println("Division����ɸѡ��"+"list�Ĵ�С��"+list.size());
				}
				
				
				if(position.length()>=1){
					list=sort_position(list,position);
					//System.out.println("��Աλ��ɸѡ��"+"list�Ĵ�С��"+list.size());
				}
				HotSort sort=new HotSort();
				return sort.hotPlayer_Sort(list, condition,
						  reverse);
		}
		/*
		@Override
		public ArrayList<PlayerInfoVO> getSortInfo(String position,
				String league, String age) {
			// TODO Auto-generated method stub
			
			ArrayList<PlayerInfoVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(playerFactory.getLastDay().getSeason()) ;
			 
			if(league.equals("West")){
				//����
				list=sort_division(list,"W");
			}
			if(league.equals("East")){
				list=sort_division(list,"E");
			}
			if(position.equals("All")){
			list=sort_position(list,position);
			}
			
			
			for(int i=0;i<list.size();i++){
				result.add(list.get(i).getInfo());
			}
		
			if(age.equals("<=22")){
				result=sort_age(result,0,22);
			}else if(age.equals("22< X <=25")){
				result=sort_age(result,22,25);
			}else if(age.equals("25< X <=30")){
				result=sort_age(result,25,30);
			}else if(age.equals(">30")){
				result=sort_age(result,30,100);
			}
			else{
				return result;
			}
			
			return result;
		}
		
		*/
		
		
		private ArrayList<PlayerSeasonDataVO> sort_age(ArrayList<PlayerSeasonDataVO>list,int low,int high){
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getAge()<=high && list.get(i).getAge()>low){
					result.add(list.get(i));
				}
			}
			
			return result;
		}
		
		private ArrayList<PlayerInfoVO> sort_age1(ArrayList<PlayerInfoVO>list,int low,int high){
			ArrayList<PlayerInfoVO> result=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getAge()<=high && list.get(i).getAge()>low){
					result.add(list.get(i));
				}
			}
			
			return result;
		}
		
		public ArrayList<PlayerSeasonDataVO> getMost_Progress_Player(
				String item, int n) {
			// TODO Auto-generated method stub
			
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(playerFactory.getLastDay().getSeason()) ;
			HotSort sort=new HotSort();
			list= sort.hotPlayer_Sort(list,item);
			for(int i=0;i<n;i++){
				result.add(list.get(i));
			}
			return result; 
		}
		public ArrayList<PlayerSeasonDataVO> getSortInfo(String position,
				String league, String age, String[] condition, boolean[] reverse) {
			
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(playerFactory.getLastDay().getSeason()) ;
			 
			if(league.equals("West")){
				/*����*/
				list=sort_division(list,"W");
			}
			if(league.equals("East")){
				list=sort_division(list,"E");
			}
			if(!position.equals("All")){
			list=sort_position(list,position);
			}
			
			
			for(int i=0;i<list.size();i++){
				result.add(list.get(i));
			}
		
			if(age.equals("<=22")){
				result=sort_age(result,0,22);
			}else if(age.equals("22< X <=25")){
				result=sort_age(result,22,25);
			}else if(age.equals("25< X <=30")){
				result=sort_age(result,25,30);
			}else if(age.equals(">30")){
				result=sort_age(result,30,100);
			}
			else{
				;
			}
			
			HotSort sort=new HotSort();
			return sort.hotPlayer_Sort(result, condition,
					  reverse);
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> sort_super(String season,
				String type, String position, String partition, String item,
				String sign, int num) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerInfoVO> getPlayerInfoByFirstChar(String firstchar) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerInfoVO> getPlayerInfo(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> sort(String season, String type,
				String position, String partition, String item) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> sort(String season, String type,
				String position, String partition, String[] condition,
				boolean[] reverse) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<SingleMatchPersonalDataVO> getLastFiveMatchData(
				String name, String type) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> getAPlayerSaeasonData(String name,
				String type) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public double[] getPlayerOneData(String name, String num, String what) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
