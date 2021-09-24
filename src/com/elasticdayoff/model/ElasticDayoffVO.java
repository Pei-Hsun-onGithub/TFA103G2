package com.elasticdayoff.model;

public class ElasticDayoffVO implements java.io.Serializable {

	private Integer dayoffId;
	private Integer restaurantId;
	private String newWeeklyLeave;
	
	public ElasticDayoffVO() {}

	public Integer getDayoffId() {
		return dayoffId;
	}

	public void setDayoffId(Integer dayoffId) {
		this.dayoffId = dayoffId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getNewWeeklyLeave() {
		return newWeeklyLeave;
	}

	public void setNewWeekLeave(String newWeekLeave) {
		this.newWeeklyLeave = newWeekLeave;
	}

	@Override
	public String toString() {
		return "ElasticDayoffVO [dayoffId=" + dayoffId + ", restaurantId=" + restaurantId + ", newWeekLeave="
				+ newWeeklyLeave + "]";
	}
	
	
}
