package UI.common;

import java.text.DecimalFormat;

public class OftenUseMethod {
	static public double changedouble(double a){
		return ((int)(a*100)/100.0);
	}
	
	public static String changeper(double xx_xx){
		double a=xx_xx*100;
		DecimalFormat df = new DecimalFormat("0");    
		String temp=String.valueOf(df.format(a));
		return temp;
	}
}
