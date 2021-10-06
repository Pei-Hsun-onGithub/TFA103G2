package com.meal.model;

import java.sql.Timestamp;
import java.util.List;

public class MealService {

	private MealDAO_interface dao;
	
	public MealService() {
		dao = new MealJDBCDAO();
	}
	public MealService (MealDAO_interface dao) {
		this.dao = dao;
	}
	
	
	
	public MealVO addMeal(Integer sta, String mealName, String mealType,Integer unitPrice, 
			Timestamp launchDate, Integer launchDays, String mealDescription, byte[] mealImg, Integer restaurantId) {
		
		MealVO eachMeal = new MealVO();
		
		eachMeal.setSta(sta);
		eachMeal.setMealName(mealName);
		eachMeal.setMealType(mealType);
		eachMeal.setUnitPrice(unitPrice);
		eachMeal.setLaunchDate(launchDate);
		eachMeal.setLaunchDays(launchDays);
		eachMeal.setMealDescription(mealDescription);
		eachMeal.setMealImg(mealImg);
		eachMeal.setRestaurantId(restaurantId);
		
		
		return this.dao.insert(eachMeal);
		
	}
	
	public MealVO findMealByPrimaryKey(Integer mealId) {
		return dao.findByPrimaryKey(mealId);
	}
	public List<MealVO> getAll() {
		
		return this.dao.getAll();
	}
	
}
