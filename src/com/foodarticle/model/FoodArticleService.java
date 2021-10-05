package com.foodarticle.model;

import java.sql.Date;
import java.util.List;

public class FoodArticleService {
	
	private FoodArticleDAO_interface dao;
	
	public FoodArticleService() {
		dao = new FoodArticleJDBCDAO();
	}
	
	public FoodArticleVO addFoodArticle(Integer userId, Integer restaurantId,
			String articleTitle, Date articleDate, String articleContent, Integer sta) {
		
		FoodArticleVO foodArticleVO = new FoodArticleVO();
		
		foodArticleVO.setUserId(userId);
		foodArticleVO.setRestaurantId(restaurantId);
		foodArticleVO.setArticleTitle(articleTitle);
		foodArticleVO.setArticleDate(articleDate);
		foodArticleVO.setArticleContent(articleContent);
		foodArticleVO.setSta(sta);
		dao.add(foodArticleVO);
		
		return foodArticleVO;
	}
	
	public FoodArticleVO updateFoodArticle(Integer articleNo, Integer userId, Integer restaurantId,
			String articleTitle, Date articleDate, String articleContent, Integer sta) {
		
		FoodArticleVO foodArticleVO = new FoodArticleVO();
		
		foodArticleVO.setArticleNo(articleNo);
		foodArticleVO.setUserId(userId);
		foodArticleVO.setRestaurantId(restaurantId);
		foodArticleVO.setArticleTitle(articleTitle);
		foodArticleVO.setArticleDate(articleDate);
		foodArticleVO.setArticleContent(articleContent);
		foodArticleVO.setSta(sta);		
		
		return foodArticleVO;
	}
	
	public void deleteFoodArticle(Integer articleNo){
		dao.delete(articleNo);
	}
	
	public FoodArticleVO getOneArticle(Integer articleNo) {
		return dao.findByPrimaryKey(articleNo);
	}
	
	public List<FoodArticleVO> getall(){
		return dao.getall();
	}

}
