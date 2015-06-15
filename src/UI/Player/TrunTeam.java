package UI.Player;

import java.util.ArrayList;

import UI.main.init;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class TrunTeam {
	static PlayerInfoVO pivo;
	ArrayList<SingleMatchPersonalDataVO> playerBefore;
	ArrayList<SingleMatchPersonalDataVO> playerAfter;
	double beforeX;

	public static void main(String[] args) {
		//勒布朗·詹姆斯
		//getAPlayerSeasonData(String season,String type,String name);
		String name = "勒布朗-詹姆斯";
		ArrayList<SingleMatchPersonalDataVO>	playerbefore = init.pbl.getASeasonMatchData(name,"13-14");//MIA
		ArrayList<SingleMatchPersonalDataVO>  playerafter = init.pbl.getASeasonMatchData(name,"14-15");//CLE
		System.out.print(playerbefore.get(0).getTeamName()+playerafter.get(0).getTeamName());
	}
	
	//默认是得分
	public void Isbetterafterturn(ArrayList<SingleMatchPersonalDataVO> playerbefore,ArrayList<SingleMatchPersonalDataVO> playerafter){
		playerBefore = playerbefore;
		playerAfter = playerafter;
		double[] dataAfter = getdata(playerafter);
		double[] dataBefore = getdata(playerbefore);
		
		beforeX = calculateX();
	}

	public double calculateX(double[] data){
		double result = 0;
		return result;
	}
	
	public double[] getdata(ArrayList<SingleMatchPersonalDataVO> playerdata){
		double[] output = new double[playerdata.size()];
		int i = 0;
		for(SingleMatchPersonalDataVO smvo:playerdata){
			output[i] = smvo.getPointNum();
			i++;
		}
		return output;
	}
}
