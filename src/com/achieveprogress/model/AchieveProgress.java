package com.achieveprogress.model;

import java.io.Serializable;
import java.sql.Date;

public class AchieveProgress implements Serializable {
	
	private Integer userId;
	private Integer achiId;
	private Integer currentArticle;
	private Integer currentOrder;
	private Date beginDate;
	private Integer sta;
	
	public AchieveProgress() {
	}

	public AchieveProgress(Integer userId, Integer achiId, Integer currentArticle, Integer currentOrder, Date beginDate, Integer sta) {
		this.userId = userId;
		this.achiId = achiId;
		this.currentArticle = currentArticle;
		this.currentOrder = currentOrder;
		this.beginDate = beginDate;
		this.sta = sta;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAchiId() {
		return achiId;
	}

	public void setAchiId(Integer achiId) {
		this.achiId = achiId;
	}

	public Integer getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(Integer currentArticle) {
		this.currentArticle = currentArticle;
	}

	public Integer getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Integer currentOrder) {
		this.currentOrder = currentOrder;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}
	
}
