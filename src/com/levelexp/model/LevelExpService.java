package com.levelexp.model;

import java.util.List;

public class LevelExpService {

	private LevelExpDAO dao;
	
	public LevelExpService() {
		dao = new LevelExpDAOImpl();
	}
	
	public LevelExp addLevelExp (int expLow, int expUp) {
		
		LevelExp levelexp = new LevelExp();
		
		levelexp.setExpLow(expLow);
		levelexp.setExpUp(expUp);
		dao.add(levelexp);
		
		return levelexp;
	}
	
	public LevelExp updateLevelExp (int expLow, int expUp) {
		
		LevelExp levelexp = new LevelExp();
		
		levelexp.setExpLow(expLow);
		levelexp.setExpUp(expUp);
		dao.update(levelexp);
		
		return levelexp;
	}
	
	public void deleteLevelExp(int lv) {
		dao.delete(lv);
	}
	
	public LevelExp getOneLevelExp(int lv) {
		return dao.findByPK(lv);
	}
	
	public List<LevelExp> getAll() {
		return dao.getAll();
	}
}
