package UI.blObject;

import bl_db.matchbl.Match_Controller;
import businessService.blservice.MatchBLService;

public class Test {
	public static void main(String args[]){
		MatchBLService bl=new Match_Controller();
		System.out.println("kkkkkkill---->"+bl.getLastHavingMatchDate());
	}
}
