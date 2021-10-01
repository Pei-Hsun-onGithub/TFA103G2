package com.monsterbook.model;

import java.util.List;

public interface MonsterBookDAO {
	
	void add(MonsterBook monsterbook);
	void update(MonsterBook monsterbook);
	void delete(int monsterId);
	MonsterBook findByPK(int monsterId);
	List<MonsterBook> getAll();

}
