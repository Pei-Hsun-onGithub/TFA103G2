package com.achieveprogress.model;

import java.util.List;

public interface AchieveProgressDAO {
	
	void add(AchieveProgress achieveprogress);
	void update(AchieveProgress achieveprogress);
	void delete(Integer userId, Integer achiId);
	AchieveProgress findByPK(Integer userId, Integer achiId);
	List<AchieveProgress> getAll();

}
