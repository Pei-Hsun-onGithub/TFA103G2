package com.foodarticle.model;

import java.util.List;

public interface FoodArticleDAO_interface {
	
	public void add(FoodArticleVO foodArticle);
	public void update(FoodArticleVO foodArticle);
	public void delete(Integer articleNo);
	FoodArticleVO findByPrimaryKey(Integer articleNo);
	List<FoodArticleVO> getall();
	
	
}
