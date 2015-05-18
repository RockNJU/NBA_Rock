package businesslogic.bl.test.matchtest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamMatchVO;
import businesslogic.bl.matchbl.MatchController;

public class MatchControllerTest {
	MatchController match;
	@Before
	public void setUp() throws Exception {
		System.out.println("进行准备工作。");
		match=new MatchController();
		ArrayList<SingleMatchPersonalDataVO> listA=new ArrayList<>();
		/*
		 * String season,String date,String name,String team,
			 String division,String partition,String p,double time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int steal,int blockNum,int turnoverNum,
			 int foulNum,int points, double assistEfficiency,
			 double reboundEfficiency,double offensiveReboundEff,
			 double defenseReboundEff,double stealEfficiency,
			 double usingPercentage,double blockEfficiency
		 * */
		
		/***测试数据------------------------------*****************************************/
		 ArrayList<SingleMatchPersonalDataVO> aa_list=new ArrayList<>();
			SingleMatchPersonalDataVO vqvo1=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "A_1", "teamA", "E", 
					"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 24,
					0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
										aa_list.add(vqvo1);
			SingleMatchPersonalDataVO qvo2=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "A_2", "teamA", "E", 
					"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3,19,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aa_list.add(qvo2);
			SingleMatchPersonalDataVO qvo3=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "A_3", "teamA", "E", 
					"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aa_list.add(qvo3);
			SingleMatchPersonalDataVO qvo4=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "A_4", "teamA", "E", 
					"Center", "G", 44, 4, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 11,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aa_list.add(qvo4);
			SingleMatchPersonalDataVO qvo5=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "A_5", "teamA", "E", 
					"Center", "G", 44, 8, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 16,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aa_list.add(qvo5);
			SingleMatchPersonalDataVO qvo6=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "A_6", "teamA", "E", 
					"Center", "G", 20, 3, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 6,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aa_list.add(qvo6);
				//总分=6+16+11+9+22+24=88
					TeamMatchVO team_AAA=getTeamMatchVO( aa_list,
							"12-13","teamA", 0,
							qvo6.getDate(),"teamB");
		/**------------------------------------------------------------------------------------------------------*/
			ArrayList<SingleMatchPersonalDataVO> bbb_list=new ArrayList<>();
			SingleMatchPersonalDataVO vq1=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "B_1", "teamB", "E", 
					"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 25,
					0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
											bbb_list.add(vq1);
					SingleMatchPersonalDataVO vq2=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "B_2", "teamB", "E", 
					"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 22,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										  bbb_list.add(vq2);
					SingleMatchPersonalDataVO vq3=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "B_3", "teamB", "E", 
					"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbb_list.add(vq3);
					SingleMatchPersonalDataVO vq4=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "B_4", "teamB", "E", 
					"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbb_list.add(vq4);
					SingleMatchPersonalDataVO vq5=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "B_5", "teamB", "E", 
					"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbb_list.add(vq5);
				   SingleMatchPersonalDataVO vq6=new SingleMatchPersonalDataVO("12-13", "2013-02-21", "B_6", "teamB", "E", 
						"Center", "G", 20, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbb_list.add(vq6);
					//该队的总分=12*3+9+22+25=92
										TeamMatchVO team_BB=getTeamMatchVO( aa_list,
												"12-13","teamA",1,
												vq1.getDate(),"teamA");
										ArrayList<String> sss=new ArrayList<>();
										sss.add("22-23");
										sss.add("22-24");
										sss.add("22-22");
										sss.add("22-23");
				/* MatchVO(String season,String date,String matchScore,
				ArrayList<String>sssres,TeamMatchVO ht,TeamMatchVO gt)*/
				MatchVO match1=new MatchVO("12-13",vq1.getDate(),"88-92",sss,team_AAA,team_BB);						
										
		
		/*--------------*************************************第二场比赛****************************************************/
		ArrayList<SingleMatchPersonalDataVO> a_list=new ArrayList<>();
		SingleMatchPersonalDataVO vo1=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "A_1", "teamA", "E", 
				"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 24,
				0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
									a_list.add(vo1);
		SingleMatchPersonalDataVO vo2=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "A_2", "teamA", "E", 
				"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3,19,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									a_list.add(vo2);
		SingleMatchPersonalDataVO vo3=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "A_3", "teamA", "E", 
				"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									a_list.add(vo3);
		SingleMatchPersonalDataVO vo4=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "A_4", "teamA", "E", 
				"Center", "G", 44, 4, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 11,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									a_list.add(vo4);
		SingleMatchPersonalDataVO vo5=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "A_5", "teamA", "E", 
				"Center", "G", 44, 8, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 16,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									a_list.add(vo5);
		SingleMatchPersonalDataVO vo6=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "A_6", "teamA", "E", 
				"Center", "G", 20, 3, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 6,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									a_list.add(vo6);
			//总分=6+16+11+9+22+24=88
				TeamMatchVO team_A=getTeamMatchVO( a_list,
						"13-14","teamA", 0,
						vo1.getDate(),"teamB");
	/**------------------------------------------------------------------------------------------------------*/
		ArrayList<SingleMatchPersonalDataVO> b_list=new ArrayList<>();
		SingleMatchPersonalDataVO v1=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "B_1", "teamB", "E", 
				"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 25,
				0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
										b_list.add(v1);
				SingleMatchPersonalDataVO v2=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "B_2", "teamB", "E", 
				"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 22,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									  b_list.add(v2);
				SingleMatchPersonalDataVO v3=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "B_3", "teamB", "E", 
				"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									b_list.add(v3);
				SingleMatchPersonalDataVO v4=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "B_4", "teamB", "E", 
				"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									b_list.add(v4);
				SingleMatchPersonalDataVO v5=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "B_5", "teamB", "E", 
				"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
				0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									b_list.add(v5);
			   SingleMatchPersonalDataVO v6=new SingleMatchPersonalDataVO("13-14", "2014-3-02", "B_6", "teamB", "E", 
					"Center", "G", 20, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
									b_list.add(v6);
				//该队的总分=12*3+9+22+25=92
									TeamMatchVO team_B=getTeamMatchVO( a_list,
											"13-14","teamA",1,
											vo1.getDate(),"teamA");
									ArrayList<String> sco=new ArrayList<>();
									sco.add("22-23");
									sco.add("22-24");
									sco.add("22-22");
									sco.add("22-23");
			/* MatchVO(String season,String date,String matchScore,
			ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt)*/
			MatchVO match2=new MatchVO("13-14",vo1.getDate(),"88-92",sco,team_A,team_B);						
									
		//---------------------------------------------------------------------------------------------第三场比赛
			ArrayList<SingleMatchPersonalDataVO> aaaa_list=new ArrayList<>();
			SingleMatchPersonalDataVO vv1=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "A_1", "teamA", "E", 
					"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 24,
					0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
										aaaa_list.add(vv1);
			SingleMatchPersonalDataVO vv2=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "A_2", "teamA", "E", 
					"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3,19,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aaaa_list.add(vv2);
			SingleMatchPersonalDataVO vv3=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "A_3", "teamA", "E", 
					"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aaaa_list.add(vv3);
			SingleMatchPersonalDataVO vv4=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "A_4", "teamA", "E", 
					"Center", "G", 44, 4, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 11,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aaaa_list.add(vv4);
			SingleMatchPersonalDataVO vv5=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "A_5", "teamA", "E", 
					"Center", "G", 44, 8, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 16,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aaaa_list.add(vv5);
			SingleMatchPersonalDataVO vv6=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "A_6", "teamA", "E", 
					"Center", "G", 20, 3, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 7,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										aaaa_list.add(vv6);
				//总分=6+16+11+9+22+24=88
					TeamMatchVO teamA3=getTeamMatchVO( aaaa_list,
							"13-14","teamA", 0,
							vv1.getDate(),"teamB");
		/**------------------------------------------------------------------------------------------------------*/
			ArrayList<SingleMatchPersonalDataVO> bbbb_list=new ArrayList<>();
			SingleMatchPersonalDataVO ve1=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "B_1", "teamB", "E", 
					"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 29,
					0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
											bbbb_list.add(ve1);
					SingleMatchPersonalDataVO ve2=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "B_2", "teamB", "E", 
					"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 22,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										  bbbb_list.add(ve2);
					SingleMatchPersonalDataVO ve3=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "B_3", "teamB", "E", 
					"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbbb_list.add(ve3);
					SingleMatchPersonalDataVO ve4=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "B_4", "teamB", "E", 
					"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbbb_list.add(v4);
					SingleMatchPersonalDataVO ve5=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "B_5", "teamB", "E", 
					"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
					0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbbb_list.add(ve5);
				   SingleMatchPersonalDataVO ve6=new SingleMatchPersonalDataVO("13-14", "2014-04-03", "B_6", "teamB", "E", 
						"Center", "G", 20, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
										bbbb_list.add(ve6);
					//该队的总分=12*3+9+22+25=92
										TeamMatchVO teamB3=getTeamMatchVO( bbbb_list,
												"13-14","teamB",1,
												vv1.getDate(),"teamA");
										ArrayList<String> sso=new ArrayList<>();
										sso.add("22-23");
										sso.add("22-24");
										sso.add("22-22");
										sso.add("22-28");
				/* MatchVO(String season,String date,String matchScore,
				ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt)*/
				MatchVO match3=new MatchVO("13-14",vv1.getDate(),"89-97",sso,teamA3,teamB3);	
			///////////////////////-----------------------------------------------------
				/***********************************----------------添加的第四场比赛*********--------------------------*/
				ArrayList<SingleMatchPersonalDataVO> sss_list=new ArrayList<>();
				SingleMatchPersonalDataVO vvvvvv1=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "A_1", "teamA", "E", 
						"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 24,
						0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
											sss_list.add(vvvvvv1);
				SingleMatchPersonalDataVO vvvvvv2=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "A_2", "teamA", "E", 
						"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3,19,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											sss_list.add(vvvvvv2);
				SingleMatchPersonalDataVO vvvvvv3=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "A_3", "teamA", "E", 
						"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											sss_list.add(vvvvvv3);
				SingleMatchPersonalDataVO vvvvvv4=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "A_4", "teamA", "E", 
						"Center", "G", 44, 4, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 11,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											sss_list.add(vvvvvv4);
				SingleMatchPersonalDataVO vvvvvv5=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "A_5", "teamA", "E", 
						"Center", "G", 44, 8, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 16,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											sss_list.add(vvvvvv5);
				SingleMatchPersonalDataVO vvvvvv6=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "A_6", "teamA", "E", 
						"Center", "G", 20, 3, 16, 0, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 7,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											sss_list.add(vvvvvv6);
					//总分=6+16+11+9+22+24=88
						TeamMatchVO teamA4=getTeamMatchVO( sss_list,
								"13-14","teamA", 0,
								vvvvvv1.getDate(),"teamB");
			/**------------------------------------------------------------------------------------------------------*/
				ArrayList<SingleMatchPersonalDataVO> bbbbbbbbbbbbb_list=new ArrayList<>();
				SingleMatchPersonalDataVO vveeeee1=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "B_1", "teamB", "E", 
						"Center", "C", 45, 9, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 29,
						0.63, 0.65, 0.3, 0.21, 0.12, 0.9, 0.3);
												bbbbbbbbbbbbb_list.add(vveeeee1);
						SingleMatchPersonalDataVO vveeeee2=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "B_2", "teamB", "E", 
						"Center", "F", 47, 8, 20, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 22,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											  bbbbbbbbbbbbb_list.add(vveeeee2);
						SingleMatchPersonalDataVO vveeeee3=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "B_3", "teamB", "E", 
						"Center", "F", 40, 3, 10, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 9,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											bbbbbbbbbbbbb_list.add(vveeeee3);
						SingleMatchPersonalDataVO vveeeee4=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "B_4", "teamB", "E", 
						"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											bbbbbbbbbbbbb_list.add(v4);
						SingleMatchPersonalDataVO vveeeee5=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "B_5", "teamB", "E", 
						"Center", "G", 44, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
						0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											bbbbbbbbbbbbb_list.add(vveeeee5);
					   SingleMatchPersonalDataVO vveeeee6=new SingleMatchPersonalDataVO("13-14", "2014-04-04", "B_6", "teamB", "E", 
							"Center", "G", 20, 8, 16, 3, 6, 3, 6, 6, 3, 9, 5, 1, 1, 6, 3, 12,
							0.63, 0.63, 0.3, 0.21, 0.12, 0.9, 0.3);
											bbbbbbbbbbbbb_list.add(vveeeee6);
						//该队的总分=12*3+9+22+25=92
											TeamMatchVO teamB4=getTeamMatchVO( bbbbbbbbbbbbb_list,
													"13-14","teamB",1,
													vvvvvv1.getDate(),"teamA");
											ArrayList<String> sssso=new ArrayList<>();
											sssso.add("29-22");
											sssso.add("23-24");
											sssso.add("22-22");
											sssso.add("22-28");
					/* MatchVO(String season,String date,String matchScore,
					ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt)*/
					MatchVO match4=new MatchVO("13-14",vvvvvv1.getDate(),"100-96",sssso,teamA4,teamB4);	
				///////////////////////----------------------------------------------
				
				/*---------------------------------------------------------------------------*/
				match.add_A_match(match1);
				match.add_A_match(match2);
				match.add_A_match(match3);
				match.add_A_match(match4);
	}
	public TeamMatchVO getTeamMatchVO(ArrayList<SingleMatchPersonalDataVO> list,
			String season,String teamName, int winNum,
			String date,String opp_team){
		/*String season,String teamName, int winNum,
			String date,String opp_team,int pointNum,int lost_point,
			int reboundNum, int O_ReboundNum, int D_ReboundNum,
			int assistNum, int turnoverNum, int stealNum, int foulNum,
			int fieldGoal, int shootNum, int T_fieldGoal, int T_shootNum,
			int freeThrowGoalNum, int freeThrowNum, int blockNum,
			double offenseRound, double defenseRound,
			double O_ReboundEfficiency,double D_ReboundEfficiency,
			ArrayList<SingleMatchPersonalDataVO> individualData*/
		int pointNum=0;
		//int lost_point=0;
		int reboundNum=0;
		int O_ReboundNum=0;
		int D_ReboundNum=0;
		int assistNum=0;
		int turnoverNum=0;
		int stealNum=0;
		int foulNum=0;
		int fieldGoal=0;int shootNum=0;
		int T_fieldGoal=0;
		int T_shootNum=0;
		int freeThrowGoalNum=0;
		int freeThrowNum=0;
		int blockNum=0;
		for(int i=0;i<list.size();i++){
			 pointNum=pointNum+list.get(i).getPointNum();
			  
			  reboundNum=reboundNum+list.get(i).getReboundNum();
			  O_ReboundNum=O_ReboundNum+list.get(i).getO_ReboundNum();
			  D_ReboundNum=D_ReboundNum+list.get(i).getD_ReboundNum();
			  assistNum=assistNum+list.get(i).getAssistNum();
			  turnoverNum=turnoverNum+list.get(i).getTurnoverNum();
			  stealNum=stealNum+list.get(i).getStealNum();
			  foulNum=foulNum+list.get(i).getFoulNum();
			  fieldGoal=fieldGoal+list.get(i).getFieldGoal();  
			  shootNum=shootNum+list.get(i).getShootNum();
			  T_fieldGoal=T_fieldGoal+list.get(i).getT_fieldGoal();
			  T_shootNum=T_shootNum+list.get(i).getT_shootNum();
			  freeThrowGoalNum=freeThrowGoalNum+freeThrowGoalNum;
			  freeThrowNum=freeThrowNum+list.get(i).getFreeThrowNum();
			  blockNum=blockNum+list.get(i).getBlockNum();
		}
		
		
		return new TeamMatchVO(  season,teamName,  winNum,
				 date,opp_team, pointNum ,56  , reboundNum ,O_ReboundNum,D_ReboundNum, assistNum ,
				  turnoverNum ,stealNum ,foulNum ,fieldGoal ,  shootNum ,T_fieldGoal ,T_shootNum ,
				  freeThrowGoalNum , freeThrowNum ,
				  blockNum,98,96,0.36,0.54,list);
	
	}
	
	@Test
	public void testGetAllSeason() {
		System.out.println("进行赛季获取的测试：");
		ArrayList<String> season=new ArrayList<>();
		season.add("12-13赛季");
		season.add("13-14赛季");
		ArrayList<String> result=match.getAllSeason();
		System.out.println("获取大小："+result.size()+";"+result.get(0));
		for(int i=0;i<result.size();i++){
			System.out.println("获得的赛季"+result.get(i)+";"+season.get(i));
			assertEquals(season.get(i),result.get(i));
			
		}
		
	}

	@Test
	public void testGetMatchByTeamTime() {
		ArrayList<MatchVO> list=match.getMatchByTeamTime("2014-04-03");
		ArrayList<String> so=new ArrayList<>();
		so.add("22-23");
		so.add("22-24");
		so.add("22-22");
		so.add("22-28");
		assertEquals("13-14",list.get(0).getSeason());
		assertEquals("89-97",list.get(0).getMatchScore());
		assertEquals("teamA",list.get(0).getHostTeam().getTeamName());
		assertEquals("teamB",list.get(0).getGuestTeam().getTeamName());
		assertEquals(so,list.get(0).getScores());
	}

	@Test
	public void testGetMatchByTeam() {
		 MatchVO vo=match.getMatchByTeam("2014-04-03", "teamA");
		 ArrayList<String> so=new ArrayList<>();
			so.add("22-23");
			so.add("22-24");
			so.add("22-22");
			so.add("22-28");
			System.out.println("----**Vo.getseasom:  "+vo.getSeason());
			assertEquals("13-14",vo.getSeason());
			assertEquals("89-97",vo.getMatchScore());
			assertEquals("teamA",vo.getHostTeam().getTeamName());
			assertEquals("teamB",vo.getGuestTeam().getTeamName());
	}

	@Test
	public void testGetMatchBySeason() {
		ArrayList<MatchVO> list=match.getMatchBySeason("13-14", "teamA");
		ArrayList<String> so1=new ArrayList<>();
		so1.add("22-23");
		so1.add("22-24");
		so1.add("22-22");
		so1.add("22-28");
		 
		assertEquals("13-14",list.get(1).getSeason());
		assertEquals("89-97",list.get(1).getMatchScore());
		assertEquals("teamA",list.get(1).getHostTeam().getTeamName());
		assertEquals("teamB",list.get(1).getGuestTeam().getTeamName());
		
		assertEquals(so1,list.get(1).getScores());
		//------------------------------------------------
		
		ArrayList<String> sssso=new ArrayList<>();
		sssso.add("29-22");
		sssso.add("23-24");
		sssso.add("22-22");
		sssso.add("22-28");
		 
		assertEquals("13-14",list.get(2).getSeason());
		assertEquals("100-96",list.get(2).getMatchScore());
		assertEquals("teamA",list.get(2).getHostTeam().getTeamName());
		assertEquals("teamB",list.get(2).getGuestTeam().getTeamName());
		
		assertEquals(sssso,list.get(2).getScores());
	}

	@Test
	public void testGetTodayHotPlayerStringInt() {
		ArrayList<SingleMatchPersonalDataVO> list=match.getTodayHotPlayer("pointNum");
		 
			assertEquals("B_1",list.get(0).getPlayerName());
			assertEquals(29,list.get(0).getPointNum());
			//-------------------------
			assertEquals("A_1",list.get(1).getPlayerName());
			assertEquals(24,list.get(1).getPointNum());
			
			assertEquals("B_2",list.get(2).getPlayerName());
			assertEquals(22,list.get(2).getPointNum());
		 
	}

}
