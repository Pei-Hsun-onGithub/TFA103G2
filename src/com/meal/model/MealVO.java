package com.meal.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class MealVO implements java.io.Serializable {
	
	private Integer mealId;
	private Integer sta;
	private String mealName;
	private String mealType;
	private Integer unitPrice;
	private Timestamp launchDate;
	private Integer launchDays;
	private String mealDescription;
	private byte[] mealImg;
	private Integer restaurantId;
	
	public MealVO() {}

	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Timestamp getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Timestamp launchDate) {
		this.launchDate = launchDate;
	}

	public Integer getLaunchDays() {
		return launchDays;
	}

	public void setLaunchDays(Integer launchDays) {
		this.launchDays = launchDays;
	}

	public String getMealDescription() {
		return mealDescription;
	}

	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}

	public byte[] getMealImg() {
		return mealImg;
	}

	public void setMealImg(byte[] mealImg) {
		this.mealImg = mealImg;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "MealVO [mealId=" + mealId + ", sta=" + sta + ", mealName=" + mealName + ", mealType=" + mealType
				+ ", unitPrice=" + unitPrice + ", launchDate=" + launchDate + ", launchDays=" + launchDays
				+ ", mealDescription=" + mealDescription + ", mealImg=" + Arrays.toString(mealImg) + ", restaurantId="
				+ restaurantId + "]";
	}
	
	
}
