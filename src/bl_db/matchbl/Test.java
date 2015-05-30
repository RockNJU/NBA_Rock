package bl_db.matchbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Test {
	String url="jdbc:mysql://localhost//mysql";
    String user="ghl";
    String pwd="ghl13";
    
    public static void main(String args[]){
    	Test test=new Test();
    	System.out.println(test.getLastHavingMatchDate());
    }
    
    public String getLastHavingMatchDate() {
    	
		try {
			 Class.forName("org.sqlite.JDBC");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		
          Statement stmt;
		
			Connection conn;
			conn = DriverManager.getConnection(url,user, pwd);
			stmt = conn.createStatement(); 
			String str="select MAX(formedTime) as max from teambaseinfo";
			ResultSet  rs=stmt.executeQuery(str);
		 
			while(rs.next()){
				return rs.getString("max");
			}
			  stmt.close();
		      conn.close();//使用完后就关闭数据库
		} catch (Exception e) {
			 System.out.println("数据库读取最新的一个赛季出现问题:"+e.toString());
		}//
		return null;
	}
}
