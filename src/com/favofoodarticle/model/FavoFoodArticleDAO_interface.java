package com.favofoodarticle.model;

import java.util.List;
import java.util.Set;



public interface FavoFoodArticleDAO_interface {
	public void add(FavoFoodArticleVO favofooar);
	public void update(FavoFoodArticleVO favofooar);
	public void delete(Integer userId, Integer articleNo);
	public FavoFoodArticleVO findByPrimaryKey(Integer userId, Integer articleNo);
	public List<FavoFoodArticleVO> getall();
	public Set<FavoFoodArticleVO> getAllFavoFoodArticleByUserId(Integer userId);
}
