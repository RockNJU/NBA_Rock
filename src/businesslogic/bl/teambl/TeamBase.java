package businesslogic.bl.teambl;

public class TeamBase {
	public String getDivision(String teamAbb){
		/*根据球队返回分区*/
		if(teamAbb.equals(    "ATL")|teamAbb.equals("BKN")|teamAbb.equals("CHI")|
				teamAbb.equals("DET")|teamAbb.equals("MIA")|teamAbb.equals("ORL")|
				teamAbb.equals("PHI")|teamAbb.equals("TOR")|teamAbb.equals("CHA")|
				teamAbb.equals("WAS")|teamAbb.equals("DET")|teamAbb.equals("CLE")|
				teamAbb.equals("IND")|teamAbb.equals("MIL")|teamAbb.equals("NYK")){
			return "E";
		}else{
		return "W";
		}
	}
	
	public String getpartition(String teamAbb){
		if(teamAbb.equals("ATL")|teamAbb.equals("CHA")|teamAbb.equals("MIA")
				|teamAbb.equals("WAS")|teamAbb.equals("ORL")){
			return "Southeast";
			
		}else if(teamAbb.equals("DAL")|teamAbb.equals("NOP")|teamAbb.equals("SAS")
				|teamAbb.equals("HUO")|teamAbb.equals("MEM")){
			
			return "Southwest";
		}else if(teamAbb.equals("DEN")|teamAbb.equals("POR")|teamAbb.equals("UTA")
				|teamAbb.equals("MIN")|teamAbb.equals("OKC")){
			
			return "Northwest";
		}else if(teamAbb.equals("BKN")|teamAbb.equals("PHI")|teamAbb.equals("TOR")
				|teamAbb.equals("BOS")|teamAbb.equals("NYK")){
			
			return "Atlantic";
		}else if(teamAbb.equals("CHI")|teamAbb.equals("CLE")|teamAbb.equals("DET")
				|teamAbb.equals("MIL")|teamAbb.equals("IND")){
		
			return "Central";
		} 
		else
			return "Pacific";
	}
}
