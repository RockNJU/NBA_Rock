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
	double beforeU;
	double afterX;
	double afterU;
	int datasize;
	double Z;
	double P;

	public static void main(String[] args) {
		// 勒布朗·詹姆斯
		// getAPlayerSeasonData(String season,String type,String name);
		String name = "勒布朗-詹姆斯";
		ArrayList<SingleMatchPersonalDataVO> playerbefore = init.pbl
				.getASeasonMatchData(name, "13-14");// MIA
		ArrayList<SingleMatchPersonalDataVO> playerafter = init.pbl
				.getASeasonMatchData(name, "14-15");// CLE
		System.out.print(playerbefore.get(0).getTeamName()
				+ playerafter.get(0).getTeamName()+"\n");
		TrunTeam tt = new TrunTeam();
		tt.isbetterafterturn(playerbefore, playerafter);
	}

	public void ischangealot(
			ArrayList<SingleMatchPersonalDataVO> playerbefore,
			ArrayList<SingleMatchPersonalDataVO> playerafter){
		playerBefore = playerbefore;
		playerAfter = playerafter;
		double[] dataAfter = getdata(playerafter);
		double[] dataBefore = getdata(playerbefore);
		datasize = dataAfter.length;
		beforeX = calculateX(dataBefore);
		beforeU = calculateU(dataBefore, beforeX);
		afterX = calculateX(dataAfter);
		afterU = calculateU(dataAfter, afterX);

	}
	
	// 默认是得分_队员转队后表现是不是有明显变化
	public void isbetterafterturn(
			ArrayList<SingleMatchPersonalDataVO> playerbefore,
			ArrayList<SingleMatchPersonalDataVO> playerafter) {
		playerBefore = playerbefore;
		playerAfter = playerafter;
		double[] dataAfter = getdata(playerafter);
		double[] dataBefore = getdata(playerbefore);
		datasize = dataAfter.length;
		beforeX = calculateX(dataBefore);
		beforeU = calculateU(dataBefore, beforeX);
		afterX = calculateX(dataAfter);
		afterU = calculateU(dataAfter, afterX);
		Z = calculateZ(beforeX, beforeU, afterX);
		P =  calc(Z);

		System.out.println(beforeX + ";" +afterX+";"+ beforeU + ";" + Z + ";" + P);
	}

	public double calculateZ(double beforeX, double beforeU, double afterX) {
		double result = 0;
		result = (afterX - beforeX) / (Math.sqrt(beforeU) / Math.sqrt(datasize));
		return result;
	}

	public double calculateU(double[] data, double X) {
		double total = 0;
		for (double temp : data) {
			total = total + (temp - X) * (temp - X);
		}
		return total;
	}

	public double calculateX(double[] data) {
		double result = 0;
		double total = 0;
		int time = 0;
		for (double temp : data) {
			total = total + temp;
			time++;
		}
		result = total / time;
		return result;
	}

	public double[] getdata(ArrayList<SingleMatchPersonalDataVO> playerdata) {
		double[] output = new double[playerdata.size()];
		int i = 0;
		for (SingleMatchPersonalDataVO smvo : playerdata) {
			output[i] = smvo.getPointNum();
			i++;
		}
		return output;
	}

		public static double calc(double u) {
			double y = Math.abs(u);
			double y2 = y * y;
			double z = Math.exp(-0.5 * y2) * 0.398942280401432678;
			double p = 0;
			int k = 28;
			double s = -1;
			double fj = k;

			if (y > 3) {
				// 当y>3时
				for (int i = 1; i <= k; i++) {
					p = fj / (y + p);
					fj = fj - 1.0;
				}
				p = z / (y + p);
			} else {
				// 当y<3时
				for (int i = 1; i <= k; i++) {
					p = fj * y2 / (2.0 * fj + 1.0 + s * p);
					s = -s;
					fj = fj - 1.0;
				}
				p = 0.5 - z * y / (1 - p);
			}
			if (u > 0)
				p = 1.0 - p;
			return p;
		}

		public void test() {
			for (double d = 0; d < 5.0; d += 0.1) {
				System.out.println(d + "," + calc(d));
			}
		}
	
}
