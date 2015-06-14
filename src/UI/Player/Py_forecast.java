package UI.Player;

import java.math.BigDecimal;
import java.util.ArrayList;

import UI.main.init;
import VO.SingleMatchPersonalDataVO;
import bl_db.playerbl.Player;
import businessService.blservice.PlayerBLService;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2015年6月14日 下午9:09:51
 * @version 1.0
 */
public class Py_forecast {

	public Py_forecast(){}
	public double getForecastProperty(String property, String name) {

		double result = 0;
		result = calculateForecast(property, name);
		return result;
	}

	private double calculateForecast(String property, String name) {

		ArrayList<SingleMatchPersonalDataVO> season11data = init.pbl
				.getASeasonMatchData(name, "11-12");
		ArrayList<SingleMatchPersonalDataVO> season12data = init.pbl
				.getASeasonMatchData(name, "12-13");
		ArrayList<SingleMatchPersonalDataVO> season13data = init.pbl
				.getASeasonMatchData(name, "13-14");
		ArrayList<SingleMatchPersonalDataVO> season14data = init.pbl
				.getASeasonMatchData(name, "14-15");

		season11data.addAll(season12data);
		season11data.addAll(season13data);
		season11data.addAll(season14data);

		ArrayList<Double> formalData = new ArrayList<Double>();     //用以存放某一属性的所有值
		switch (property) {

		case "总分":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getPointNum());
			}
			return regressionAnalyse(formalData);

		case "篮板数":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getReboundNum());
			}
			return regressionAnalyse(formalData);

		case "助攻数":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getAssistNum());
			}
			return regressionAnalyse(formalData);

		case "盖帽数":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getBlockNum());
			}
			return regressionAnalyse(formalData);

		case "抢断数":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getTurnoverNum());
			}
			return regressionAnalyse(formalData);

		default:
			return (Double) null;

		}

	}

	/*
	 * 
	 * 做球员某一项属性与其比赛场数的线性回归分析    显著性检验    与预测
	 * */
	private double regressionAnalyse(ArrayList<Double> list) {

		double estimatedValue = 0;
		DataPoint[] pointlist = new DataPoint[list.size()];
        for(int i=0;i<list.size();i++){  //定义数据点   并调用线性回归分析算法    是一个内部类
        	pointlist[i] = new DataPoint(i+1,list.get(i));
        }
        RegressionLine  line = new RegressionLine(pointlist);
		System.out.println("\n回归线公式:  y = " + line.getA1() + "x + "
				+ line.getA0());
		System.out.println("误差：     R^2 = " + line.getR());
        estimatedValue = line.at(list.size());
		
		return estimatedValue;
	}
	
	
	
	//内部类   用来封装X和Y坐标点
	class DataPoint {

		public double x;      //x值
		public double y;      //y值

		public DataPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	//内部类  用来实现线性回归算法
	class RegressionLine {// implements Evaluatable
		
		private double sumX;     //x的和
		private double sumY;     //y的和
		private double sumXX;    //x^2的和
		private double sumXY;    //x*y的和
		private double sumYY;    //y^2的和
		private double sumDeltaY; //yi-y 的和
		private double sumDeltaY2;  //(yi-y)^2 的和

		//误差 
		private double sse;
		private double sst;
		private double E;
		private String[] xy;
		private ArrayList listX;
		private ArrayList listY;
		private int XMin, XMax, YMin, YMax;

		private float a0;             //线性系数a0
		private float a1;             //线性系数a1
		private int pn;                //数据点的数量
		private boolean coefsValid;     //系数是否有效

		
		public RegressionLine() {
			XMax = 0;
			YMax = 0;
			pn = 0;
			xy = new String[2];
			listX = new ArrayList();
			listY = new ArrayList();
		}

		/**
		 * 数据点的数组
		 */
		public RegressionLine(DataPoint data[]) {
			pn = 0;
			xy = new String[2];
			listX = new ArrayList();
			listY = new ArrayList();
			for (int i = 0; i < data.length; ++i) {
				addDataPoint(data[i]);
			}
		}

		/**
		 *返回当前数据点的数量
		 */
		public int getDataPointCount() {
			return pn;
		}

		/**
		 *返回系数a0
		 */
		public float getA0() {
			validateCoefficients();
			return a0;
		}

		/**
		 * 返回系数a1
		 */
		public float getA1() {
			validateCoefficients();
			return a1;
		}

		/**
		 * 返回x值的总和
		 */
		public double getSumX() {
			return sumX;
		}

		/**
		 *返回y值的总和
		 */
		public double getSumY() {
			return sumY;
		}

		/**
		 *返回x^2 的总和
		 */
		public double getSumXX() {
			return sumXX;
		}

		/**
		 *返回x*y的总和
		 */
		public double getSumXY() {
			return sumXY;
		}
		/**
		 *返回y^2的总和
		 */
		public double getSumYY() {
			return sumYY;
		}
		
		public int getXMin() {
			return XMin;
		}

		public int getXMax() {
			return XMax;
		}

		public int getYMin() {
			return YMin;
		}

		public int getYMax() {
			return YMax;
		}

		/**
		 * 增添一个新的数据点: 更新各项和的数值  以及最大值.
		 */
		public void addDataPoint(DataPoint dataPoint) {
			sumX += dataPoint.x;
			sumY += dataPoint.y;
			sumXX += dataPoint.x * dataPoint.x;
			sumXY += dataPoint.x * dataPoint.y;
			sumYY += dataPoint.y * dataPoint.y;
           
			if (dataPoint.x > XMax) {     
				XMax = (int) dataPoint.x;
			}
			if (dataPoint.y > YMax) {
				YMax = (int) dataPoint.y;
			}

			// 把每个点的具体坐标存入ArrayList中，备用

			xy[0] = (int) dataPoint.x + "";
			xy[1] = (int) dataPoint.y + "";
			if (dataPoint.x != 0 && dataPoint.y != 0) {
				System.out.print(xy[0] + ",");
				System.out.println(xy[1]);

				try {
					// System.out.println("n:"+n);
					listX.add(pn, xy[0]);
					listY.add(pn, xy[1]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			++pn;
			coefsValid = false;
		}

		/**
		 * 返回值x的线性方程的值. (Implementation of Evaluatable.)
		 */
		public float at(int x) {
			if (pn < 2)
				return Float.NaN;

			validateCoefficients();
			return a0 + a1 * x;
		}

		/**
		 * 重置
		 */
		public void reset() {
			pn = 0;
			sumX = sumY = sumXX = sumXY = 0;
			coefsValid = false;
		}

		/**
		 * 设置系数值为有效. 计算方程系数 y=ax+b 中的a
		 */
		private void validateCoefficients() {
			if (coefsValid)
				return;

			if (pn >= 2) {
				float xBar = (float) sumX / pn;
				float yBar = (float) sumY / pn;

				a1 = (float) ((pn * sumXY - sumX * sumY) / (pn * sumXX - sumX
						* sumX));
				a0 = (float) (yBar - a1 * xBar);
			} else {
				a0 = a1 = Float.NaN;
			}

			coefsValid = true;
		}

		/**
		 * 返回误差
		 */
		public double getR() {
			// 遍历这个list并计算分母
			for (int i = 0; i < pn - 1; i++) {
				float Yi = (float) Integer.parseInt(listY.get(i).toString());
				float Y = at(Integer.parseInt(listX.get(i).toString()));
				float deltaY = Yi - Y;
				float deltaY2 = deltaY * deltaY;
				/*
				 * System.out.println("Yi:" + Yi); System.out.println("Y:" + Y);
				 * System.out.println("deltaY:" + deltaY);
				 * System.out.println("deltaY2:" + deltaY2);
				 */

				sumDeltaY2 += deltaY2;
				// System.out.println("sumDeltaY2:" + sumDeltaY2);

			}

			sst = sumYY - (sumY * sumY) / pn;
			// System.out.println("sst:" + sst);
			E = 1 - sumDeltaY2 / sst;

			return round(E, 4);
		}

		// 用于实现精确的四舍五入
		public double round(double v, int scale) {

			if (scale < 0) {
				throw new IllegalArgumentException(
						"The scale must be a positive integer or zero");
			}

			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

		}
       //粗略的四舍五入
		public float round(float v, int scale) {

			if (scale < 0) {
				throw new IllegalArgumentException(
						"The scale must be a positive integer or zero");
			}

			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).floatValue();

		}
	}
}
