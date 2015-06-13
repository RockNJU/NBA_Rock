package bl_db.playerbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;

public class PlayerControllerTest {
	PlayerController pp;
	@Before
	public void setUp() throws Exception {
		pp=new PlayerController();
	}

	@Test
	public void testPlayerController() {
		fail("Not yet implemented");
	}

	/*@Test
	public void testGetAllPlayerInfo() {
		System.out.println("进行测试获取球员个人信息：");
		ArrayList<PlayerInfoVO> list=pp.getAllPlayerInfo();
		System.out.println("size："+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("name: "+list.get(i).getName()+
					" position:"+list.get(i).getPosition());
			}
		System.out.println("进行测试获取球员个人信息--------end：");
		}*/

	@Test
	public void testGetSeasonHotPlayerStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerSeasonData() {
		ArrayList<PlayerSeasonDataVO> list=pp.getPlayerSeasonData("13-14");
		
		
		for(int i=0;i<list.size();i++){
			System.out.println("name: "+list.get(i).getName()+
					" position:"+list.get(i).getPosition());
			}
		System.out.println("进行测试获取球员赛季比赛信息--------end：");
	}

	@Test
	public void testKeyfind() {
		//ArrayList<PlayerSeasonDataVO> list=pp.sort_super("14-15","常规赛","前锋","中部","pointNum",">", 25);
		ArrayList<PlayerSeasonDataVO> list=pp.keyfind("A");
		for(int i=0;i<list.size();i++){
			System.out.println("name: "+list.get(i).getName()+
					" position:"+list.get(i).getPosition());
			}
		System.out.println("进行测试获取球员赛季比赛信息--------end：");
	}

	@Test
	public void testGetTeamAllPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMost_Progress_Player() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeasonHotPlayerString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSeasonHotPlayerStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSort_super() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerInfoByFirstChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortStringStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAPlayerSeasonMatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortStringStringStringStringStringArrayBooleanArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastFiveMatchData() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerOneData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetASeasonMatchData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTodayHotPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAPlayerSeasonDataStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAPlayerInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAPlayerSeasonDataStringStringString() {
		fail("Not yet implemented");
	}

}
