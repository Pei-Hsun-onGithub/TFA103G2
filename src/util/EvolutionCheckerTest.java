package util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.levelexp.model.LevelExp;
import com.levelexp.model.LevelExpService;
import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;

public class EvolutionCheckerTest {
	
	LevelExpService levelExpSvc;
	List<LevelExp> levelExps;
	List<MonsterBook> monsters;
	EvolutionChecker evolutionChecker;
	MonsterBookService monsterSvc;
	MemberInfoService memeInfoSvc;
	Integer userId;
	MemberInfo memInfo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		levelExpSvc = new LevelExpService();
		levelExps = levelExpSvc.getAll();
		monsters = new MonsterBookService().getAll();
		evolutionChecker = new EvolutionChecker(levelExps, monsters);
		memeInfoSvc = new MemberInfoService();
		userId = 20210001;
		memInfo = memeInfoSvc.getOneMemberInfo(userId);
		monsterSvc = new MonsterBookService();
		
		
//		System.out.println("this time current monster Lv = " + memInfo.getLv());
//		System.out.println("this time current monster Exp = " + memInfo.getExp());
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsTimeToGrowup() {
		memInfo.setLv(2);
		memInfo.setExp(60);
		assertTrue(evolutionChecker.isTimeToGrowup(memInfo));
		
		memInfo.setLv(1);
		memInfo.setExp(20);
		assertTrue(evolutionChecker.isTimeToGrowup(memInfo));
		
	}
	@Test
	public void testIsTimeToEvolution() {
		memInfo.setLv(6);
		memInfo.setExp(60);
		
		assertTrue(evolutionChecker.isTimeToEvolution(memInfo));
	}
	@Test
	public void testGetBiggerMonsterLvCheck() {
		
		MonsterBook midiumMonster = monsterSvc.getOneMonsterBook(1004);
		MonsterBook biggestMonster = monsterSvc.getOneMonsterBook(1007);
		// 可以進化成中等怪獸的等級與經驗值(中等可用等級 Lv3 ~ Lv6)
		memInfo.setLv(2);
		memInfo.setExp(50);
		assertNull(evolutionChecker.getBiggerMonster(memInfo));
		
		memInfo.setLv(3);
		memInfo.setExp(50);
		assertEquals(midiumMonster.getMinDemandLevel(), evolutionChecker.getBiggerMonster(memInfo).getMinDemandLevel());
		assertNotEquals(biggestMonster.getMinDemandLevel(), evolutionChecker.getBiggerMonster(memInfo).getMinDemandLevel());
		
		memInfo.setLv(4);
		memInfo.setExp(50);
		assertEquals(midiumMonster.getMinDemandLevel(), evolutionChecker.getBiggerMonster(memInfo).getMinDemandLevel());
		assertNotEquals(biggestMonster.getMinDemandLevel(), evolutionChecker.getBiggerMonster(memInfo).getMinDemandLevel());
		
		memInfo.setLv(6);
		memInfo.setExp(50);
		assertNotEquals(midiumMonster.getMinDemandLevel(), evolutionChecker.getBiggerMonster(memInfo).getMinDemandLevel());
		assertEquals(biggestMonster.getMinDemandLevel(), evolutionChecker.getBiggerMonster(memInfo).getMinDemandLevel());
		
	}
	
	@Test
	public void testGetNewLevel() {
		
		memInfo.setLv(1);
		memInfo.setExp(10);
		assertEquals(new Integer(2), evolutionChecker.getNewLevel(memInfo));
		
		memInfo.setLv(3);
		memInfo.setExp(88);
		assertEquals(new Integer(3), evolutionChecker.getNewLevel(memInfo));
		
		memInfo.setLv(5);
		memInfo.setExp(0);
		assertEquals(new Integer(5), evolutionChecker.getNewLevel(memInfo));
		
	}

}
