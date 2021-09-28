package com.achieveprogress.model;

import java.util.List;

public interface AchieveProgressDAO {
	
	void add(AchieveProgress achieveprogress);
	void update(AchieveProgress achieveprogress);
	void delete(int userId, int achiId);
	AchieveProgress findByPK(int userId, int achiId);
	List<AchieveProgress> getAll();

}
