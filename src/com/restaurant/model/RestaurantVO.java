package com.restaurant.model;

import java.sql.Time;

public class RestaurantVO implements java.io.Serializable {
	
	private Integer 	restaurantId;
	private String 		restaurantName;
	private String 		boss;
	private String 		phone;
	private String 		district;
	private String 		city;
	private String 		location;
	private Time 		openTime;
	private Time 		closeTime;
	private Integer 	dayoffId;
	private String 		weeklyLeave;
	private Integer 	sta;
	
	public RestaurantVO() {}
	
	

	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Time getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}
	public Time getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}
	public Integer getDayoffId() {
		return dayoffId;
	}
	public void setDayoffId(Integer dayoffId) {
		this.dayoffId = dayoffId;
	}
	public String getWeeklyLeave() {
		return weeklyLeave;
	}
	public void setWeeklyLeave(String weeklyLeave) {
		this.weeklyLeave = weeklyLeave;
	}
	public Integer getSta() {
		return sta;
	}
	public void setSta(Integer sta) {
		this.sta = sta;
	}

	@Override
	public String toString() {
		return "RestaurantVO [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", boss=" + boss
				+ ", phone=" + phone + ", district=" + district + ", city=" + city + ", location=" + location
				+ ", openTime=" + openTime + ", closeTime=" + closeTime + ", dayoffId=" + dayoffId + ", weeklyLeave="
				+ weeklyLeave + ", sta=" + sta + "]";
	}
	

}
