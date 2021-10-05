package com.monsterbook.model;

import java.util.List;

public class MonsterBookService {
	
	private MonsterBookDAO dao;
	
	public MonsterBookService() {
		dao = new MonsterBookDAOImpl();
	}
	
	public MonsterBook addMonsterBook (int minDemandLevel, String monsterName, String monsterAbility, byte[] monsterPic) {
		
		MonsterBook monsterbook = new MonsterBook();
		
		monsterbook.setMinDemandLevel(minDemandLevel);
		monsterbook.setMonsterName(monsterName);
		monsterbook.setMonsterAbility(monsterAbility);
		monsterbook.setMonsterPic(monsterPic);
		dao.add(monsterbook);
		
		return monsterbook;
	}
	
	public MonsterBook updateMonsterBook (int minDemandLevel, String monsterName, String monsterAbility, byte[] monsterPic) {
		
		MonsterBook monsterbook = new MonsterBook();
		
		monsterbook.setMinDemandLevel(minDemandLevel);
		monsterbook.setMonsterName(monsterName);
		monsterbook.setMonsterAbility(monsterAbility);
		monsterbook.setMonsterPic(monsterPic);
		dao.update(monsterbook);
		
		return monsterbook;
	}
	
	public void deleteMonsterBook(int monsterId) {
		dao.delete(monsterId);
	}
	
	public MonsterBook getOneMonsterBook(int monsterId) {
		return dao.findByPK(monsterId);
	}
	
	public List<MonsterBook> gerAll() {
		return dao.getAll();
	}

}
