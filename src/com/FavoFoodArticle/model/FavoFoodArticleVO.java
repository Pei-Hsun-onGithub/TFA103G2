package com.FavoFoodArticle.model;

public class FavoFoodArticleVO {
	private Integer userId;
	private Integer articleNo;
	
	public FavoFoodArticleVO() {
		super();
	}
	
	public FavoFoodArticleVO(Integer userId, Integer articleNo) {
		super();
		this.userId = userId;
		this.articleNo = articleNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
	 
	
	
	
	public Integer  getone() {
		 return articleNo;
	 }
	
}
