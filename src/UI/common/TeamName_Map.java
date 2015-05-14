package UI.common;

import java.util.HashMap;
import java.util.Map;

public class TeamName_Map {
	Map<String, String> map=new HashMap<String, String>();
	  
	
	   public TeamName_Map(){
		   map.put( "ATL","Hawks");	
		   map.put( "BKN","Nets");
		   map.put("BOS","Celtics" );
		   map.put("CHA", "Hornets");
		   map.put("CHI", "Bulls");
		   map.put("CLE","Cavaliers" );
		   map.put("DAL", "Mavericks");
		   map.put("DEN","Nuggets" );
		   map.put("DET", "Pistons");
		   map.put("GSW","Warriors" );
		   
		   
		   //---------------------
		   map.put("HOU", "Rockets");
		   map.put("IND","Pacers" );
		   map.put("LAC","Clippers" );
		   map.put("LAL","Lakers" );	   
		   
		   map.put( "MEM","Grizzlies");

		   map.put("MIA", "Heat");
		   map.put("MIL","Bucks" );
		   map.put("MIN","TimBerwolves" );
		    
		   map.put("NOP", "Pelicans");
		   map.put("NYK","Knicks" );
		   map.put("OKC", "Thunder");
		   map.put("ORL", "Magic");
		   //map.put("", "");   
		   
		   map.put("PHI","76ers" );	   
		   
		   map.put( "PHX","Suns");
		   //
		   map.put( "POR","Trail Blazers");
		   map.put( "SAC","Kings");
		   map.put( "SAS","Spurs");
		    
		   map.put("TOR", "Raptors");
		   map.put("UTA", "Jazz");
		   map.put("WAS","Wizards" );
		   
		   
		   
		   
		   map.put("Hawks", "ATL");
		   map.put("Nets", "BKN");
		   map.put("Celtics", "BOS");
		   map.put("Hornets", "CHA");
		   map.put("Bulls", "CHI");
		   map.put("Cavaliers", "CLE");
		   map.put("Mavericks", "DAL");
		   map.put("Nuggets", "DEN");
		   map.put("Pistons", "DET");
		   map.put("Warriors", "GSW");
		   
		   
		   //---------------------
		   map.put("Rockets", "HOU");
		   map.put("Pacers", "IND");
		   map.put("Clippers", "LAC");
		   map.put("Lakers", "LAL");	   
		   
		   map.put("Grizzlies", "MEM");

		   map.put("Heat", "MIA");
		   map.put("Bucks", "MIL");
		   map.put("TimBerwolves", "MIN");
		    
		   map.put("Pelicans", "NOP");
		   map.put("Knicks", "NYK");
		   map.put("Thunder", "OKC");
		   map.put("Magic", "ORL");
		   //map.put("", "");   
		   
		   map.put("76ers", "PHI");	   
		   
		   map.put("Suns", "PHX");
		   //
		   map.put("Trail Blazers", "POR");
		   map.put("Kings", "SAC");
		   map.put("Spurs", "SAS");
		    
		   map.put("Raptors", "TOR");
		   map.put("Jazz", "UTA");
		   map.put("Wizards", "WAS");
		   map.put("unknown", "??");
	   }
	   
	   public String getFullName(String item){
		   if(map.get(item)==null){
			   return "unknown";
		   }
		   return map.get(item).toString();
	   }
}
