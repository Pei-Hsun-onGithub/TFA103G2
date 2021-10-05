package com.achieve.model;

import java.sql.Date;
import java.util.List;

public class AchieveService {
	
	private AchieveDAO dao;
	
	public AchieveService() {
		dao = new AchieveDAOImpl();
	}
	
	public Achieve addAchieve (String achiName, String descript, Date openDate, int validDays, int achiArticle,	int achiOrder, int gainFeed, int gainGold, byte[] achiPic) {
		
		Achieve achieve = new Achieve();
		
		achieve.setAchiName(achiName);
		achieve.setDescript(descript);
		achieve.setOpenDate(openDate);
		achieve.setValidDays(validDays);
		achieve.setAchiArticle(achiArticle);
		achieve.setAchiOrder(achiOrder);
		achieve.setGainFeed(gainFeed);
		achieve.setGainGold(gainGold);
		achieve.setAchiPic(achiPic);
		dao.add(achieve);
	
		return achieve;
	}

	public Achieve updateAchieve (String achiName, String descript, Date openDate, int validDays, int achiArticle,	int achiOrder, int gainFeed, int gainGold, byte[] achiPic) {
		
		Achieve achieve = new Achieve();
		
		achieve.setAchiName(achiName);
		achieve.setDescript(descript);
		achieve.setOpenDate(openDate);
		achieve.setValidDays(validDays);
		achieve.setAchiArticle(achiArticle);
		achieve.setAchiOrder(achiOrder);
		achieve.setGainFeed(gainFeed);
		achieve.setGainGold(gainGold);
		achieve.setAchiPic(achiPic);
		dao.update(achieve);
		
		return achieve;
	}
	
	public void deleteAchieve(int achiId) {
		dao.delete(achiId);
	}
	
	public Achieve getOneAchieve(int achiId) {
		return dao.findByPK(achiId);
	}
	
	public List<Achieve> getAll() {
		return dao.getAll();
	}
	
}
