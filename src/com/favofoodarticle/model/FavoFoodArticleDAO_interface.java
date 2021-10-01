package com.favofoodarticle.model;

import java.util.List;



public interface FavoFoodArticleDAO_interface {
	public void insert(FavoFoodArticleVO favofooar);
	public void update(FavoFoodArticleVO favofooar);
	public void delete(Integer userId, Integer articleNo);
	FavoFoodArticleVO findByPrimaryKey(Integer userId, Integer articleNo);
	List<FavoFoodArticleVO> getAll();
	
	
}
