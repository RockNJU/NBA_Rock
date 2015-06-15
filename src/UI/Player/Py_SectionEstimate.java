package UI.Player;

import java.math.BigDecimal;
import java.util.ArrayList;

import UI.main.init;
import VO.SingleMatchPersonalDataVO;

/** 
 * @author  作者 E-mail: 
 * @date 创建时间：2015年6月15日 上午12:53:45 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */

public class Py_SectionEstimate {
	
	public String name;

	//各项属性的区间值申明
	Double[] estimatePoint = new Double[2]; 
	Double[] estimateBlock = new Double[2];
	Double[] estimateRebound = new Double[2];
	Double[] estimateAssist = new Double[2];
	Double[] estimateSteal = new Double[2];
	Double[] estimateFoul = new Double[2];
	Double[] estimateTurnover = new Double[2];
	Double[] estimateOR = new Double[2];
	Double[] estimateDR = new Double[2];
	Double[] estimateFreeThrow = new Double[2];
	Double[] estimateFreeThrowGoal = new Double[2];
	Double[] estimateTShoot = new Double[2];
	Double[] estimateTField = new Double[2];
	Double[] estimateShoot = new Double[2];
	Double[] estimateFieldGoal = new Double[2];
	
	
	public Double[] getEstimatePoint(){
		return estimatePoint;
	}
	
	public Double[] getEstimateBlock(){
		return estimateBlock;
	}
	
	public Double[] getEstimateRebound(){
		return estimateRebound;
	}
	
	public Double[] getEstimateAssist(){
		return estimateAssist;
	}
	
	public Double[] getEstimateSteal(){
		return estimateSteal;
	}
	
	public Double[] getEstimateFoul(){
		return estimateFoul;
	}
	
	public Double[] getEstimateTurnover(){
		return estimateTurnover;
	}
	
	public Double[] getEstimateOR(){
		return estimateOR;
	}
	
	public Double[] getEstimateDR(){
		return estimateDR;
	}
	
	public Double[] getEstimateFreeThrow(){
		return estimateFreeThrow;
	}
	
	public Double[] getEstimateFreeThrowGoal(){
		return estimateFreeThrowGoal;
	}
	
	public Double[] getEstimateTShoot(){
		return estimateTShoot;
	}
	
	public Double[] getEstimateTField(){
		return estimateTField;
	}
	
	public Double[] getEstimateShoot(){
		return estimateShoot;
	}
	
	public Double[] getEstimateFieldGoal(){
		return estimateFieldGoal;
	}
	
	public Py_SectionEstimate(String name){
		this.name = name;
		calculateSection();
	}
	

	private void calculateSection() {

		//ArrayList<SingleMatchPersonalDataVO> season11data = init.pbl
				//.getASeasonMatchData(name, "11-12");
		//ArrayList<SingleMatchPersonalDataVO> season12data = init.pbl
				//.getASeasonMatchData(name, "12-13");
		//ArrayList<SingleMatchPersonalDataVO> season13data = init.pbl
				//.getASeasonMatchData(name, "13-14");
		ArrayList<SingleMatchPersonalDataVO> season11data = init.pbl
				.getASeasonMatchData(name, "14-15");

		//season11data.addAll(season12data);
		//season11data.addAll(season13data);
		//season11data.addAll(season14data);
        //用以存放某一属性的所有值
		ArrayList<Double> pointlist = new ArrayList<Double>(); 
		ArrayList<Double> blocklist = new ArrayList<Double>();
		ArrayList<Double> reboundlist = new ArrayList<Double>();
		ArrayList<Double> assistlist = new ArrayList<Double>();
		ArrayList<Double> steallist = new ArrayList<Double>();
		ArrayList<Double> foullist = new ArrayList<Double>();
		ArrayList<Double> turnoverlist = new ArrayList<Double>();
		ArrayList<Double> ORlist = new ArrayList<Double>();
		ArrayList<Double> DRlist = new ArrayList<Double>();
		ArrayList<Double> freeThrowlist = new ArrayList<Double>();
		ArrayList<Double> freeThrowGoallist = new ArrayList<Double>();
		ArrayList<Double> TShootlist = new ArrayList<Double>();
		ArrayList<Double> TFieldlist = new ArrayList<Double>();
		ArrayList<Double> shootlist = new ArrayList<Double>();
		ArrayList<Double> fieldGoallist = new ArrayList<Double>();
		
		for (int i = 0; i < season11data.size(); i++) {
			pointlist.add((double) season11data.get(i).getPointNum()); 
			blocklist.add((double) season11data.get(i).getBlockNum());
			reboundlist.add((double) season11data.get(i).getReboundNum());
			assistlist.add((double) season11data.get(i).getAssistNum());
			steallist.add((double) season11data.get(i).getStealNum());
			foullist.add((double) season11data.get(i).getFoulNum());
			turnoverlist.add((double) season11data.get(i).getTurnoverNum());
			ORlist.add((double) season11data.get(i).getO_ReboundNum());
			DRlist.add((double) season11data.get(i).getD_ReboundNum());
			freeThrowlist.add((double) season11data.get(i).getFreeThrowNum());
			freeThrowGoallist.add((double) season11data.get(i).getFreeThrowGoalNum());
			TShootlist.add((double) season11data.get(i).getT_shootNum());
			TFieldlist.add((double) season11data.get(i).getT_fieldGoal());
			shootlist.add((double) season11data.get(i).getShootNum());
			fieldGoallist.add((double) season11data.get(i).getFieldGoal());
		}
		
		SectionEstimate se = new SectionEstimate(season11data.size());
		estimatePoint = se.sectionCal(pointlist); 
		estimateBlock = se.sectionCal(blocklist);
		estimateRebound = se.sectionCal(reboundlist);
		estimateAssist = se.sectionCal(assistlist);
		estimateSteal = se.sectionCal(steallist);
		estimateFoul = se.sectionCal(foullist);
		estimateTurnover = se.sectionCal(turnoverlist);
		estimateOR = se.sectionCal(ORlist);
		estimateDR = se.sectionCal(DRlist);
		estimateFreeThrow = se.sectionCal(freeThrowlist);
		estimateFreeThrowGoal = se.sectionCal(freeThrowGoallist);
		estimateTShoot = se.sectionCal(TShootlist);
		estimateTField = se.sectionCal(TFieldlist);
		estimateShoot = se.sectionCal(shootlist);
		estimateFieldGoal = se.sectionCal(fieldGoallist);
		

		}
	
	
	//内部类  用来实现单总体均值区间估计算法
	public class SectionEstimate {
		
		private double sumX = 0;     //x的和
		private double averageX;     //x的平均值
		private double S;    //样本标注差
		private double n;    //样本容量
		private double sumDeltaX2;  //(Xi-X)^2 的和
		private double Z1 = 0.5987;    //查正太分布表所得
		private double Z2 = 0.5398;    //查正太分布表所得

		ArrayList<Double> datalist = new ArrayList<Double>();

		
		public SectionEstimate(int num) {
			this.n = num;
		}
		/**
		 * 返回值x的区间估计的值.
		 */

		public Double[] sectionCal(ArrayList<Double> data){
			
		    datalist = data;
			for (int i = 0; i < datalist.size(); ++i) {
				sumX = sumX + datalist.get(i);
			}
			averageX = (double)(sumX/n);
			for (int i = 0; i < datalist.size(); ++i) {
				sumDeltaX2 = sumDeltaX2 + (data.get(i) - averageX)*(data.get(i) - averageX);
			}
			S = Math.sqrt((double)(sumDeltaX2/n));
			
			Double result[] = new Double[2];
			result[0] = averageX - (double)S*Z1/Math.sqrt(n);
			result[1] = averageX + (double)S*Z1/Math.sqrt(n);
			result[0] = round(result[0],4);
			result[1] = round(result[1],4);
			
			System.out.println(sumX+"    "+sumDeltaX2+"    "+S+"    " +n);
			//System.out.println(result[0]+"   "+result[1]);
			return result;
			
			
			
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
  
	}
	
}
