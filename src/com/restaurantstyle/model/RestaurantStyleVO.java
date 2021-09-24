package com.restaurantstyle.model;

public class RestaurantStyleVO implements java.io.Serializable {

	private Integer restaurantId;
	private Integer styleId;
	
	public RestaurantStyleVO() {}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	@Override
	public String toString() {
		return "RestaurantStyleVO [restaurantId=" + restaurantId + ", styleId=" + styleId + "]";
	}
	
	
}
