package com.meal.model;

import java.util.List;



public interface MealDAO_interface {
	
	public MealVO insert(MealVO mealVO);
	public void update(MealVO mealVO);
	public void delete(Integer mealId);
	public MealVO findByPrimaryKey(Integer mealId);
	public List<MealVO> getAll();
	public List<MealVO> getMealNew();

}
