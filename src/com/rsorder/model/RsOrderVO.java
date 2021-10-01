package com.rsorder.model;

import java.sql.Date;

public class RsOrderVO implements java.io.Serializable {
	
	private Integer orderId;
	private Integer userId;
	private Integer restaurantId;
	private Integer cardId;
	private Integer deliveryAddId;
	private Integer deliveryMethods;
	private Date orderDay;
	private Date resStrTime;
	private Date resEndTime;
	private Date delStrTime;
	private Date delEndTime;
	private Integer count;
	private String texts;
	private Integer sta;

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public Integer getDeliveryAddId() {
		return deliveryAddId;
	}
	public void setDeliveryAddId(Integer deliveryAddId) {
		this.deliveryAddId = deliveryAddId;
	}
	public Integer getDeliveryMethods() {
		return deliveryMethods;
	}
	public void setDeliveryMethods(Integer deliveryMethods) {
		this.deliveryMethods = deliveryMethods;
	}
	public Date getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(Date orderDay) {
		this.orderDay = orderDay;
	}
	public Date getResStrTime() {
		return resStrTime;
	}
	public void setResStrTime(Date resStrTime) {
		this.resStrTime = resStrTime;
	}
	public Date getResEndTime() {
		return resEndTime;
	}
	public void setResEndTime(Date resEndTime) {
		this.resEndTime = resEndTime;
	}
	public Date getDelStrTime() {
		return delStrTime;
	}
	public void setDelStrTime(Date delStrTime) {
		this.delStrTime = delStrTime;
	}
	public Date getDelEndTime() {
		return delEndTime;
	}
	public void setDelEndTime(Date delEndTime) {
		this.delEndTime = delEndTime;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}
	public Integer getSta() {
		return sta;
	}
	public void setSta(Integer sta) {
		this.sta = sta;
	}
	@Override
	public String toString() {
		return "RsOrderVO [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", cardId="
				+ cardId + ", deliveryAddId=" + deliveryAddId + ", deliveryMethods=" + deliveryMethods + ", orderDay="
				+ orderDay + ", resStrTime=" + resStrTime + ", resEndTime=" + resEndTime + ", delStrTime=" + delStrTime
				+ ", delEndTime=" + delEndTime + ", count=" + count + ", texts=" + texts + ", sta=" + sta + "]";
	}

}
	