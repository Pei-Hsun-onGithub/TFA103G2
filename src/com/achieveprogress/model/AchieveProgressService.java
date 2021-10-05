package com.achieveprogress.model;

import java.sql.Date;
import java.util.List;

public class AchieveProgressService {
	
	private AchieveProgressDAO dao;
	
	public AchieveProgressService() {
		dao = new AchieveProgressDAOImpl();
	}
	
	public AchieveProgress addAchieveProgress (int currentArticle, int currentOrder, Date beginDate, int sta) {
		
		AchieveProgress achieveprogress = new AchieveProgress();
		
		achieveprogress.setCurrentArticle(currentArticle);
		achieveprogress.setCurrentOrder(currentOrder);
		achieveprogress.setBeginDate(beginDate);
		achieveprogress.setSta(sta);
		dao.add(achieveprogress);

		return achieveprogress;
	}
	
	public AchieveProgress updateAchieveProgress (int currentArticle, int currentOrder, Date beginDate, int sta) {
		
		AchieveProgress achieveprogress = new AchieveProgress();
		
		achieveprogress.setCurrentArticle(currentArticle);
		achieveprogress.setCurrentOrder(currentOrder);
		achieveprogress.setBeginDate(beginDate);
		achieveprogress.setSta(sta);
		dao.update(achieveprogress);

		return achieveprogress;
	}
	
	public void deleteAchieveProgress(int userId, int achiId) {
		dao.delete(userId, achiId);
	}
	
	public AchieveProgress getOneAchieveProgress(int userId, int achiId) {
		return dao.findByPK(userId, achiId);
	}
	
	public List<AchieveProgress> getAll() {
		return dao.getAll();
	}

}
