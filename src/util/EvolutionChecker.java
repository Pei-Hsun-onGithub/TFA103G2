package util;

import java.util.List;

import com.levelexp.model.LevelExp;
import com.memberinfo.model.MemberInfo;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;

public class EvolutionChecker {

	private List<LevelExp> levelexps;
	private List<MonsterBook> monsters = new MonsterBookService().getAll();
	
	public EvolutionChecker() {}
	public EvolutionChecker(List<LevelExp> levelexps) {
		this.levelexps = levelexps;
	}
	
	public boolean isTimeToGrowup(MemberInfo memInfo) {
		
		Integer currentMonsterLv = memInfo.getLv();
		Integer currentMonsterExp = memInfo.getExp();
		for(LevelExp level : this.levelexps) {
			
			// 先早出是哪種等級的怪獸
			if(currentMonsterLv == level.getLv()) {
				// 再看能不能成長
				if(currentMonsterExp >= level.getExpUp() ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTimeToEvolution(MemberInfo memInfo) {
		
		Integer currentMonsterLv = memInfo.getLv();
		
		// 進化成中等
		if(3 > currentMonsterLv ) {
			return false;
		}
		// 進化成高等
		if(6 > currentMonsterLv && currentMonsterLv > 3) {
			return false;
		}
		
		return true;
	}
	
	public MonsterBook getBiggerMonster(MemberInfo memInfo) {
		
		//給予中等怪獸
		if(memInfo.getLv() >= 3 && memInfo.getLv() < 6) {
			for(MonsterBook monster : monsters) {
				if(monster.getMinDemandLevel() == 3) {
					return monster;
				}
			}
			
		}
		//給予高等怪獸
		if(memInfo.getLv() >= 6) {
			for(MonsterBook monster : monsters) {
				if(monster.getMinDemandLevel() == 6) {
					return monster;
				}
			}
		}
		
		return null;
	}
}
