package UI.common;

import java.io.Serializable;

public class History implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;
	String type;
	String content;
	
	public History(String date,String type,String content){
		this.date=date;
		this.type=type;
		this.content=content;
	}

	public String getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}
}
