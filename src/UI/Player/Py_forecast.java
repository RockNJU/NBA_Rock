package UI.Player;

import java.math.BigDecimal;
import java.util.ArrayList;

import UI.main.init;
import VO.SingleMatchPersonalDataVO;
import bl_db.playerbl.Player;
import businessService.blservice.PlayerBLService;

/**
 * @author ���� E-mail:
 * @date ����ʱ�䣺2015��6��14�� ����9:09:51
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

		ArrayList<Double> formalData = new ArrayList<Double>();     //���Դ��ĳһ���Ե�����ֵ
		switch (property) {

		case "�ܷ�":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getPointNum());
			}
			return regressionAnalyse(formalData);

		case "������":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getReboundNum());
			}
			return regressionAnalyse(formalData);

		case "������":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getAssistNum());
			}
			return regressionAnalyse(formalData);

		case "��ñ��":
			for (int i = 0; i < season11data.size(); i++) {
				formalData.add((double) season11data.get(i).getBlockNum());
			}
			return regressionAnalyse(formalData);

		case "������":
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
	 * ����Աĳһ����������������������Իع����    �����Լ���    ��Ԥ��
	 * */
	private double regressionAnalyse(ArrayList<Double> list) {

		double estimatedValue = 0;
		DataPoint[] pointlist = new DataPoint[list.size()];
        for(int i=0;i<list.size();i++){  //�������ݵ�   ���������Իع�����㷨    ��һ���ڲ���
        	pointlist[i] = new DataPoint(i+1,list.get(i));
        }
        RegressionLine  line = new RegressionLine(pointlist);
		System.out.println("\n�ع��߹�ʽ:  y = " + line.getA1() + "x + "
				+ line.getA0());
		System.out.println("��     R^2 = " + line.getR());
        estimatedValue = line.at(list.size());
		
		return estimatedValue;
	}
	
	
	
	//�ڲ���   ������װX��Y�����
	class DataPoint {

		public double x;      //xֵ
		public double y;      //yֵ

		public DataPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	//�ڲ���  ����ʵ�����Իع��㷨
	class RegressionLine {// implements Evaluatable
		
		private double sumX;     //x�ĺ�
		private double sumY;     //y�ĺ�
		private double sumXX;    //x^2�ĺ�
		private double sumXY;    //x*y�ĺ�
		private double sumYY;    //y^2�ĺ�
		private double sumDeltaY; //yi-y �ĺ�
		private double sumDeltaY2;  //(yi-y)^2 �ĺ�

		//��� 
		private double sse;
		private double sst;
		private double E;
		private String[] xy;
		private ArrayList listX;
		private ArrayList listY;
		private int XMin, XMax, YMin, YMax;

		private float a0;             //����ϵ��a0
		private float a1;             //����ϵ��a1
		private int pn;                //���ݵ������
		private boolean coefsValid;     //ϵ���Ƿ���Ч

		
		public RegressionLine() {
			XMax = 0;
			YMax = 0;
			pn = 0;
			xy = new String[2];
			listX = new ArrayList();
			listY = new ArrayList();
		}

		/**
		 * ���ݵ������
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
		 *���ص�ǰ���ݵ������
		 */
		public int getDataPointCount() {
			return pn;
		}

		/**
		 *����ϵ��a0
		 */
		public float getA0() {
			validateCoefficients();
			return a0;
		}

		/**
		 * ����ϵ��a1
		 */
		public float getA1() {
			validateCoefficients();
			return a1;
		}

		/**
		 * ����xֵ���ܺ�
		 */
		public double getSumX() {
			return sumX;
		}

		/**
		 *����yֵ���ܺ�
		 */
		public double getSumY() {
			return sumY;
		}

		/**
		 *����x^2 ���ܺ�
		 */
		public double getSumXX() {
			return sumXX;
		}

		/**
		 *����x*y���ܺ�
		 */
		public double getSumXY() {
			return sumXY;
		}
		/**
		 *����y^2���ܺ�
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
		 * ����һ���µ����ݵ�: ���¸���͵���ֵ  �Լ����ֵ.
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

			// ��ÿ����ľ����������ArrayList�У�����

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
		 * ����ֵx�����Է��̵�ֵ. (Implementation of Evaluatable.)
		 */
		public float at(int x) {
			if (pn < 2)
				return Float.NaN;

			validateCoefficients();
			return a0 + a1 * x;
		}

		/**
		 * ����
		 */
		public void reset() {
			pn = 0;
			sumX = sumY = sumXX = sumXY = 0;
			coefsValid = false;
		}

		/**
		 * ����ϵ��ֵΪ��Ч. ���㷽��ϵ�� y=ax+b �е�a
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
		 * �������
		 */
		public double getR() {
			// �������list�������ĸ
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

		// ����ʵ�־�ȷ����������
		public double round(double v, int scale) {

			if (scale < 0) {
				throw new IllegalArgumentException(
						"The scale must be a positive integer or zero");
			}

			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

		}
       //���Ե���������
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
