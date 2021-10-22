package com.meal.model;

import java.sql.Timestamp;
import java.util.List;

public class MealService {

	private MealDAO_interface dao;

	public MealService() {
		dao = new MealJDBCDAO();
	}

	public MealService(MealDAO_interface dao) {
		this.dao = dao;
	}

	public MealVO addMeal(Integer sta, String mealName, String mealType, Integer unitPrice, Timestamp launchDate,
			Integer launchDays, String mealDescription, byte[] mealImg, Integer restaurantId) {

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

	public MealVO updateMeal(Integer mealId, Integer sta, String mealName, String mealType, Integer unitPrice,
			Timestamp launchDate, Integer launchDays, String mealDescription, byte[] mealImg, Integer restaurantId) {

		MealVO eachMeal = new MealVO();
		
		eachMeal.setMealId(mealId);
		eachMeal.setSta(sta);
		eachMeal.setMealName(mealName);
		eachMeal.setMealType(mealType);
		eachMeal.setUnitPrice(unitPrice);
		eachMeal.setLaunchDate(launchDate);
		eachMeal.setLaunchDays(launchDays);
		eachMeal.setMealDescription(mealDescription);
		eachMeal.setMealImg(mealImg);
		eachMeal.setRestaurantId(restaurantId);
		dao.update(eachMeal);
		return eachMeal;
	}

	public MealVO findMealByPrimaryKey(Integer mealId) {
		return this.dao.findByPrimaryKey(mealId);
	}

	public List<MealVO> getAll() {

		return this.dao.getAll();
	}
	
	
	public void changeMealStateAsOffShelf(Integer mealId) {
		
		// �U�[�\�I
		Integer offShelfStatus = new Integer(2);
		MealVO offShelfMeal = this.dao.findByPrimaryKey(mealId);
		offShelfMeal.setSta(offShelfStatus);
		this.dao.update(offShelfMeal);
		
	}

}
