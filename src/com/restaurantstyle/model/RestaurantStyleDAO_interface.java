package com.restaurantstyle.model;

import java.util.List;

public interface RestaurantStyleDAO_interface {

	public void insert(RestaurantStyleVO restaurantStyleVO);
	
	public void delete(RestaurantStyleVO restaurantStyleVO);
	
	public void update(RestaurantStyleVO newRestaurantStyleVO, RestaurantStyleVO oldRestaurantStyleVO);
	
	public List<RestaurantStyleVO> getAll();
}
