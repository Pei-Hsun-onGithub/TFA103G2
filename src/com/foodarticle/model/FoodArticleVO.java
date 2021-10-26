package com.foodarticle.model;

import java.sql.Date;

public class FoodArticleVO implements java.io.Serializable {
	

	private Integer articleNo;
	private Integer userId;
	private Integer restaurantId;
	private String articleTitle;
	private Date articleDate;
	private String articleContent;
	private Integer sta ;
	
	public FoodArticleVO() {
		super();
	}
	
	public FoodArticleVO(Integer articleNo, Integer userId, Integer restaurantId,
			String articleTitle, Date articleDate, String articleContent, Integer sta ) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.articleTitle = articleTitle;
		this.articleDate = articleDate;
		this.articleContent = articleContent;
		this.sta = sta;
		
	}
	
	public Integer getArticleNo () {
		return articleNo;
	}
	
	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
	
	public Integer getUserId () {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getRestaurantId () {
		return restaurantId;
	}
	
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getArticleTitle() {
		return articleTitle;
	}
	
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	public Date getArticleDate () {
		return articleDate;
	}
	
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}
	
	public String getArticleContent() {
		return articleContent;
	}
	
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	public Integer getSta () {
		return sta;
	}
	
	public void setSta(Integer sta) {
		this.sta = sta;
	}
	
	@Override
	public String toString() {
		return "FoodArticleVO [articleNo=" + articleNo + ", userId=" + userId + ", restaurantId=" + restaurantId
				+ ", articleTitle=" + articleTitle + ", articleDate=" + articleDate + ", articleContent="
				+ articleContent + ", sta=" + sta + "]";
	}
	
	
	
	
	
}
