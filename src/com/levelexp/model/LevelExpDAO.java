package com.levelexp.model;

import java.util.List;

public interface LevelExpDAO {
	
	void add(LevelExp levelexp);
	void update(LevelExp levelexp);
	void delete(int Lv);
	LevelExp findByPK(int Lv);
	List<LevelExp> getAll();

}
