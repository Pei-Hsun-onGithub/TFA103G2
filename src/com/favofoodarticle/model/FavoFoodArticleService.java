package com.favofoodarticle.model;

import java.util.List;

public class FavoFoodArticleService {
	
	private FavoFoodArticleDAO_interface dao;
	
	public FavoFoodArticleService() {
		dao = new FavoFoodArticleJDBCDAO();
	}
	
	public FavoFoodArticleVO addFavoFoodArticle(Integer userId, Integer articleNo) {
		FavoFoodArticleVO ffaVO = new FavoFoodArticleVO();
		
		ffaVO.setUserId(userId);
		ffaVO.setArticleNo(articleNo);
		dao.add(ffaVO);
		
		return ffaVO;
	}
	
	public void  updateFavoFoodArticleVO() {
		
	}
	
	public void deleteFavoFoodArticleVO(Integer userId, Integer articleNo) {
		dao.delete(userId, articleNo);
	}
	
	public FavoFoodArticleVO getOneFavoFoodArticle(Integer userId, Integer articleNo) {
		return dao.findByPrimaryKey(userId, articleNo);
	}
	
	public List<FavoFoodArticleVO> getall(){
		return dao.getall();
	}
	

}
