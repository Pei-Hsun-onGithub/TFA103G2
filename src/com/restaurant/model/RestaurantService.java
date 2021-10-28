package com.restaurant.model;

import java.sql.Time;
import java.util.List;

public class RestaurantService {

	public static final Integer MON = 1;
	public static final Integer TUE = 2;
	public static final Integer WED = 3;
	public static final Integer THUR = 4;
	public static final Integer FRI = 5;
	public static final Integer SAT = 6;
	public static final Integer SUN = 7;

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

	public RestaurantVO getRestaurantByPrimaryKey(Integer restaurantId) {
		return this.dao.findByPrimaryKey(restaurantId);
	}

	public RestaurantVO updateRestaurant(Integer restaurantId, String restaurantName, String boss, String phone,
			String district, String city, String location, Time openTime, Time closeTime, Integer dayoffId,
			String weeklyLeave, Integer sta) {

		RestaurantVO restVO = new RestaurantVO();
		
		restVO.setRestaurantId(restaurantId);
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
		
		this.dao.update(restVO);
		
		return restVO;
	}

	public String getCloseFlag(RestaurantVO restaurantVO, Integer dayOfWeek) {

		String weeklyLeave = restaurantVO.getWeeklyLeave();

		if (this.MON.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(0))
				return "checked";
			else
				return "";
		}
		if (this.TUE.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(1))
				return "checked";
			else
				return "";
		}
		if (this.WED.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(2))
				return "checked";
			else
				return "";
		}
		if (this.THUR.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(3))
				return "checked";
			else
				return "";
		}
		if (this.FRI.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(4))
				return "checked";
			else
				return "";
		}
		if (this.SAT.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(5))
				return "checked";
			else
				return "";
		}
		if (this.SUN.equals(dayOfWeek)) {
			if ('1' == weeklyLeave.charAt(6))
				return "checked";
			else
				return "";
		}

		return "";

	}
	
	public List<RestaurantVO> getAllRes(){
		return this.dao.getAll();										
		
	}
}
