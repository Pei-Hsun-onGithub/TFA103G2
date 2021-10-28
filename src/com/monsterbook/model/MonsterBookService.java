package com.monsterbook.model;

import java.util.List;

public class MonsterBookService {
	
	private MonsterBookDAO dao;
	
	public MonsterBookService() {
		dao = new MonsterBookDAOImpl();
	}
	
	public MonsterBook addMonsterBook (Integer minDemandLevel, String monsterName, String monsterAbility, byte[] monsterPic) {
		
		MonsterBook monsterbook = new MonsterBook();
		
		monsterbook.setMinDemandLevel(minDemandLevel);
		monsterbook.setMonsterName(monsterName);
		monsterbook.setMonsterAbility(monsterAbility);
		monsterbook.setMonsterPic(monsterPic);
		dao.add(monsterbook);
		
		return monsterbook;
	}
	
	public MonsterBook updateMonsterBook (Integer monsterId, Integer minDemandLevel, String monsterName, String monsterAbility, byte[] monsterPic) {
		
		MonsterBook monsterbook = new MonsterBook();
		
		monsterbook.setMonsterId(monsterId);
		monsterbook.setMinDemandLevel(minDemandLevel);
		monsterbook.setMonsterName(monsterName);
		monsterbook.setMonsterAbility(monsterAbility);
		monsterbook.setMonsterPic(monsterPic);
		dao.update(monsterbook);
		
		return monsterbook;
	}
	
	public void deleteMonsterBook(Integer monsterId) {
		dao.delete(monsterId);
	}
	
	public MonsterBook getOneMonsterBook(Integer monsterId) {
		return dao.findByPK(monsterId);
	}
	
	public List<MonsterBook> getAll() {
		return dao.getAll();
	}
	
	public MonsterBook getFirstMonsterNumber(String num) {
		
		if("1".equals(num)) 
			return this.dao.findByPK(1001);
		
		else if("2".equals(num)) 
			return this.dao.findByPK(1004);
		
		else if("3".equals(num)) 
			return this.dao.findByPK(1005);
		
		else
			return null;
	}
	

}
