package com.foodarticle.model;

import java.sql.Date;
import java.util.List;

import com.picturebase.model.PictureBaseVO;

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
		dao.update(foodArticleVO);
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
	public List<FoodArticleVO> getArticlesByUserId(Integer userId) {
		return this.dao.getByUserId(userId);
	}
	
	public void addtWithPic(FoodArticleVO foodArticleVO, List<PictureBaseVO> list) {
		  dao.insertWithPic(foodArticleVO,list);	
	}
	
	public List<FoodArticleVO> getPopularArticle(){
		return dao.getPopular();
	}
	
	public List<FoodArticleVO> getByKeyWord(String words){
		return dao.searchKeyWord(words);
	}

	
	
//	public boolean addtWithPic(FoodArticleVO foodArticleVO, List<PictureBaseVO> list) {
//		 return dao.insertWithPic(foodArticleVO,list);	
//	}

}
