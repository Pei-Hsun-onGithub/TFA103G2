package com.favorestaurant.model;

public class FavoRestaurantVO implements java.io.Serializable {
	private Integer userId;
	private Integer restaurantId;

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

}
