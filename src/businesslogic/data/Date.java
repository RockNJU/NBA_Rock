package businesslogic.data;

public class Date {
	public String getDate(String season,String date){
     
		String str[]=date.split("-");    //dateµÄ¸ñÊ½xxxx-xx-xx
	    String sea[]=season.split("-");
	    String year;
		if(str[0].compareTo("06")>=0&&str[0].compareTo("12")<=0){
			year="20"+sea[0]+"-"+date;
		}else{
			year="20"+sea[1]+"-"+date;
		}
		return year;
	}
	
	
	public static void main(String args[]){
		Date d=new Date();
		System.out.println(d.getDate("13-14", "01-03"));
	}
}
