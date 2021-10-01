package com.achieve.model;

import java.util.List;

public interface AchieveDAO {
	
	void add(Achieve achieve);
	void update(Achieve achieve);
	void delete(int achiId);
	Achieve findByPK(int achiId);
	List<Achieve> getAll();
}
