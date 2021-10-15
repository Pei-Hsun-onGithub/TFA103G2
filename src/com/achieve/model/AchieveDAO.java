package com.achieve.model;

import java.util.List;

public interface AchieveDAO {
	
	void add(Achieve achieve);
	void update(Achieve achieve);
	void delete(Integer achiId);
	Achieve findByPK(Integer achiId);
	List<Achieve> getAll();
}
