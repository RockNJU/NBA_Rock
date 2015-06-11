package bl_db.common;

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
	
	public static String getStartDate(String season){
		String se[]=season.split("-");
		String year="20"+se[0];
		String date=year+"-"+"09"+"01";
		return date;
	}
	
	public static String getEndDate(String season){
		String se[]=season.split("-");
		String year="20"+se[1];
		String date=year+"-"+"7"+"01";
		return date;
	}
	
	public static String getDate(String date){
		String str[]=date.split("-");    //date的格式xxxx-xx-xx
		return (str[1]+"-"+str[2]);
	}
}
