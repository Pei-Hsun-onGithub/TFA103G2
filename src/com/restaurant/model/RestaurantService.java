package com.restaurant.model;

import java.sql.Time;

public class RestaurantService {

	private RestaurantDAO_interface dao;
	
	public RestaurantService() {
		this.dao = new RestaurantJDBCDAO();
	}
	public RestaurantService(RestaurantDAO_interface dao) {
		this.dao = dao;
	}
	

	
	
	public RestaurantVO addRestaurant(String restaurantName, String boss, String phone, String district, String city, 
			String location, Time openTime, Time closeTime, Integer dayoffId, String weeklyLeave, Integer sta) {
		RestaurantVO restVO = new RestaurantVO();
		
		restVO.setRestaurantName(restaurantName);
		restVO.setBoss(boss);
		restVO.setPhone(phone);
		restVO.setDistrict(district);
		restVO.setCity(city);
		restVO.setLocation(location);
		restVO.setOpenTime(openTime);
		restVO.setCloseTime(closeTime);
		restVO.setDayoffId(dayoffId);
		restVO.setWeeklyLeave(weeklyLeave);
		restVO.setSta(sta);
		
		return this.dao.insert(restVO);
	}
}

