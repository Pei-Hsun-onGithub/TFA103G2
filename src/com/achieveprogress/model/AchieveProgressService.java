package com.achieveprogress.model;

import java.sql.Date;
import java.util.List;

public class AchieveProgressService {
	
	private AchieveProgressDAO dao;
	
	public AchieveProgressService() {
		dao = new AchieveProgressDAOImpl();
	}
	
	public AchieveProgress addAchieveProgress (Integer userId, Integer achiId, Integer currentArticle, Integer currentOrder, Date beginDate, Integer sta) {
		
		AchieveProgress achieveprogress = new AchieveProgress();
		
		achieveprogress.setUserId(userId);
		achieveprogress.setAchiId(achiId);
		achieveprogress.setCurrentArticle(currentArticle);
		achieveprogress.setCurrentOrder(currentOrder);
		achieveprogress.setBeginDate(beginDate);
		achieveprogress.setSta(sta);
dao.add(achieveprogress);

		return achieveprogress;
	}
	
	public AchieveProgress updateAchieveProgress (Integer userId, Integer achiId, Integer currentArticle, Integer currentOrder, Date beginDate, Integer sta) {
		
		AchieveProgress achieveprogress = new AchieveProgress();
		
		achieveprogress.setUserId(userId);
		achieveprogress.setAchiId(achiId);
		achieveprogress.setCurrentArticle(currentArticle);
		achieveprogress.setCurrentOrder(currentOrder);
		achieveprogress.setBeginDate(beginDate);
		achieveprogress.setSta(sta);
		dao.update(achieveprogress);

		return achieveprogress;
	}
	
	public void deleteAchieveProgress(Integer userId, Integer achiId) {
		dao.delete(userId, achiId);
	}
	
	public AchieveProgress getOneAchieveProgress(Integer userId, Integer achiId) {
		return dao.findByPK(userId, achiId);
	}
	
	public List<AchieveProgress> getAll() {
		return dao.getAll();
	}

}
