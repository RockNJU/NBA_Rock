package UI.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SearchHistory {
		ArrayList<History> Team_list;
		ArrayList<History> Player_list;
		
		
		public static void main(String args[]){
			System.out.println("�������");
			SearchHistory s=new SearchHistory();
			History h=new History("-0000--","--+++-","****");
			s.add_player_History(h);
			
			ArrayList<History> list=s.get_player_History();
			
			for(int i=0;i<list.size();i++){
				System.out.println("���ڣ�"+list.get(i).getDate()+
						";���ͣ�"+list.get(i).getType()+";������"+list.get(i).getContent());
				}
			
			System.out.println("�������ԣ�");
		}
		
		 
		public SearchHistory(){
			Team_list=new ArrayList<>();
			Player_list=new ArrayList<>();
			
			Team_list= readFile("NBAdata\\teamHistory");
			Player_list= readFile("NBAdata\\playerHistory");
		}
		public void add_team_History(History h){
			Team_list.add(h);
			writeFile("NBAdata\\teamHistory",Team_list);
		}
		public ArrayList<History> get_team_History(){
			return Team_list;
		}
		
		public void add_player_History(History h){
			Player_list.add(h);
			writeFile("NBAdata\\playerHistory",Player_list);
		}
		public ArrayList<History> get_player_History(){
			return Player_list;
		}
		
		private void writeFile(String fileName,Object list) {
			/*��ȡ���л��ļ���д������ArrayList��list������Ҫ�������*/
	    	ObjectOutputStream out;
			try {
				out = new ObjectOutputStream
						(new FileOutputStream(fileName));
				out.writeObject(list);
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				 ;
			}  	
	    			
		}
		
		
		
		@SuppressWarnings("unchecked")
		private ArrayList<History> readFile(String fileName){
			   ArrayList<History> list=new ArrayList<>();			
			  	  
				try {	
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(new File(fileName)));
			  			      /*��ȡ���л��ļ�����ArrayList����ʽ����*/
									list =  (ArrayList<History>) ois.readObject();
									ois.close();
								} catch (Exception e) {
									
									list=new ArrayList<History>();
									//��û���ļ�ʱ�����쳣������һ���յĶ���
								}
								
					return list;
				}
		
}
