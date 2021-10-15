package com.monsterbook.model;

import java.util.List;

public interface MonsterBookDAO {
	
	void add(MonsterBook monsterbook);
	void update(MonsterBook monsterbook);
	void delete(Integer monsterId);
	MonsterBook findByPK(Integer monsterId);
	List<MonsterBook> getAll();

}
