package com.achieveprogress.model;

import java.io.Serializable;
import java.sql.Date;

public class AchieveProgress implements Serializable {
	
	private int userId;
	private int achiId;
	private int currentArticle;
	private int currentOrder;
	private Date beginDate;
	private int sta;
	
	public AchieveProgress() {
	}

	public AchieveProgress(int userId, int achiId, int currentArticle, int currentOrder, Date beginDate, int sta) {
		this.userId = userId;
		this.achiId = achiId;
		this.currentArticle = currentArticle;
		this.currentOrder = currentOrder;
		this.beginDate = beginDate;
		this.sta = sta;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAchiId() {
		return achiId;
	}

	public void setAchiId(int achiId) {
		this.achiId = achiId;
	}

	public int getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(int currentArticle) {
		this.currentArticle = currentArticle;
	}

	public int getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(int currentOrder) {
		this.currentOrder = currentOrder;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public int getSta() {
		return sta;
	}

	public void setSta(int sta) {
		this.sta = sta;
	}
	
}
