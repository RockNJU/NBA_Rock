package businesslogic.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import VO.PlayerInfoVO;
import businesslogic.PO.PlayerInfoPO;
import businesslogic.dataservice.PlayerDataService;
import businesslogic.shareeclass.FileList;

public class PlayerDataController implements PlayerDataService {
	
	private ArrayList<PlayerInfoVO> playerList;
	String player_path;
	public PlayerDataController(String path){
		this.player_path=path;
		playerList=new ArrayList<PlayerInfoVO>();
		readObject();
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		PlayerDataController da=new PlayerDataController("NBAdata//players");
		ArrayList<PlayerInfoVO> pl=da.getAllPlayer();
		System.out.println("è¿›å…¥mainå‡½æ•°è¿›è¡Œæµ‹è¯•ï¼ "+pl.size());
		for(int i=0;i<pl.size();i++){
			//System.out.println("---:"+pl.get(i).getName()+pl.get(i).getName().length()+";-----"+i);
		}
	}
	
	@Override
	public ArrayList<PlayerInfoVO> getAllPlayer() {
		// TODO Auto-generated method stub
		return playerList;
	}
	
	
	private void readObject() {
		 /*
	 
		  * 
		  * */
		       
		    	ArrayList<String> strList=new ArrayList<>();
		    	String FILE_IN = player_path;  
		        File f = new File(FILE_IN);  
		        List<String> list = new ArrayList<String>();  
		        list = FileList.getFileList(f);  
		        String encoding="UTF-8";
		        //System.out.println(list.size());  
		       
		        int i=0;
		       
		        for (String l : list) {
		        	try{ 
		        	//BufferedReader br = new BufferedReader(new FileReader(new File(l))); 
		      //  System.out.println("***********:"+l);;
		        	InputStreamReader read = new InputStreamReader(
		                    new FileInputStream(new File(l)),encoding);
		        	BufferedReader br = new BufferedReader(read);
		        	
		        	
		        	String  line ;
		        	int num=1;
		        	while((line=br.readLine())!=null){

		        		if(num%2==0){
		        		String  str1[]=line.split("¨U");
		        		String str2[]=str1[1].split("©¦");
		        		strList.add(str2[1].trim());
		           // System.out.println(line+"******"+str[1]);
		        	}
		        		num++;
		        }
		        	
		        		 int exp=0;
		        		if(!strList.get(7).equals("R")){
		        			exp=Integer.parseInt(strList.get(7));
		        		}
		        		/*String name,int num,String p,String height,
			double weight,String birth,int age ,int exp
			,String school*/
		        		//System.out.println(i+"-------"+strList.get(0)+";"+strList.get(1)+";"+strList.get(4)+";"+strList.get(6));
		        		playerList.add(new PlayerInfoVO(strList.get(0) ,strList.get(1),
		        				strList.get(2),strList.get(3),Double.parseDouble(strList.get(4)),
		        				strList.get(5),Integer.parseInt(strList.get(6)),
		        				exp,strList.get(8)));
		        		strList.clear();
		        	}//end for
		  
		catch(Exception e){
			System.out.println("¶ÁÐ´ÎÄ¼þ´íÎó£º "+e.toString());
			continue;
		} 
		     i++;   }
	}	       
	  }


