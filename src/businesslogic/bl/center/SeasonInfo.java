package businesslogic.bl.center;

public class SeasonInfo {
	public static String getSeason(String date){
		String str[]=date.split("-");    //date的格式xxxx-xx-xx
		
		int f_year,l_year;
		int year=Integer.parseInt(str[0].substring(2));
		int month=Integer.parseInt(str[1]);
		
		if(month>=10){
			f_year=year;
			l_year=year+1;
		}else{
			f_year=year-1;
			l_year=year;
		}
		String result=f_year+"-"+l_year;
		return result;
	}
	
	public static String getDate(String date){
		String str[]=date.split("-");    //date的格式xxxx-xx-xx
		return (str[1]+"-"+str[2]);
	}
}
