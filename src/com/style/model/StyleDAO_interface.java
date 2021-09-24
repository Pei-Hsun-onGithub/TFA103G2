package com.style.model;

import java.util.List;

import com.meal.model.MealVO;

public interface StyleDAO_interface {
	public void insert(StyleVO styleVO);
	public void update(StyleVO StyleVO);
	public void delete(Integer styleId);
	public StyleVO findByPrimaryKey(Integer styleId);
	public List<StyleVO> getAll();
}
