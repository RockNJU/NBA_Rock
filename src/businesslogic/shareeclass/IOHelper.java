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
			  			      /*读取序列化文件，以ArrayList的形式读出*/
								try {
									list =  ois.readObject();
								} catch (ClassNotFoundException e) {
									list=new Object();
								}
								ois.close();
			  	  }catch(Exception e){
			  		  System.out.println("文件读取出错！"+e.toString());
			  	  }
					return list;
				}
		
		public void writeFile(String fileName,Object list) {
			/*读取序列化文件，写入整个ArrayList，list里是需要保存对象*/
			try{
	    	ObjectOutputStream out = new ObjectOutputStream
	    			(new FileOutputStream(fileName));  	
	    			out.writeObject(list);
	    			out.close();	
	    			System.out.println("书写成功！");
			}catch(Exception e){
				System.out.println("文件写入出错"+e.toString());
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

