package com.foodarticle.model;

import java.util.List;

import com.picturebase.model.PictureBaseVO;

public interface FoodArticleDAO_interface {
	
	public void add(FoodArticleVO foodArticle);
	public void update(FoodArticleVO foodArticle);
	public void delete(Integer articleNo);
	FoodArticleVO findByPrimaryKey(Integer articleNo);
	List<FoodArticleVO> getall();
//	public boolean insertWithPic(FoodArticleVO foodArticleVO, List<PictureBaseVO> list);
	public void insertWithPic(FoodArticleVO foodArticleVO, List<PictureBaseVO> list);
	List<FoodArticleVO> getPopular();
	List<FoodArticleVO> searchKeyWord (String words);
}
