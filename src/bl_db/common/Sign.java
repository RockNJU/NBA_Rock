package bl_db.common;

public class Sign {
	
	public static String getSign(String sign){
		 
			String result=null;
			switch(sign){
			case "<":
				result="<";
				break;
			case ">":
				result=">";
				break;
			case "��":	
				result="<=";
				break;
			case "��":
				result=">=";
				break;
			default:
				result="=";
				
			}
			return result;
		 
	}
}
