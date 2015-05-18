package businesslogic.shareeclass;
import java.io.*;
import java.util.ArrayList;

import businesslogic.bl.matchbl.MatchController;
import VO.MatchVO;

public class IOHelper {
	
		public Object readFile(String fileName) {
			  Object list=new ArrayList<>();			
			  	  try{
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(new File(fileName)));
			  			      /*��ȡ���л��ļ�����ArrayList����ʽ����*/
								try {
									list =  ois.readObject();
								} catch (ClassNotFoundException e) {
									list=new Object();
								}
								ois.close();
			  	  }catch(Exception e){
			  		  System.out.println("�ļ���ȡ����"+e.toString());
			  	  }
					return list;
				}
		
		public void writeFile(String fileName,Object list) {
			/*��ȡ���л��ļ���д������ArrayList��list������Ҫ�������*/
			try{
	    	ObjectOutputStream out = new ObjectOutputStream
	    			(new FileOutputStream(fileName));  	
	    			out.writeObject(list);
	    			out.close();	
	    			System.out.println("��д�ɹ���");
			}catch(Exception e){
				System.out.println("�ļ�д�����"+e.toString());
			}
		}
		
		public static void main(String args[]){
			ArrayList<MatchVO>list=new ArrayList<MatchVO>();
			MatchController mc=new MatchController();
			//list=mc.getAllMatchVO();
			IOHelper io=new IOHelper();
			ArrayList<MatchVO> dp=new ArrayList<MatchVO>();
			io.writeFile("mvo.obj", list.get(0));
			System.out.println("***********");
				 
		} 
		
}

