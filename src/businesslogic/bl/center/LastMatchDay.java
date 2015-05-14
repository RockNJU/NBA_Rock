package businesslogic.bl.center;

public class LastMatchDay {
	private String season;
	private String date;
	
	public LastMatchDay(String season,String date ){
		this.season=season;
		this.date=date;
	}
	public String getSeason() {
		return season;
	}
	public String getDate() {
		return date;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
