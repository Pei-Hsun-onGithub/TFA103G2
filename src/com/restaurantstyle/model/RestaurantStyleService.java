package com.restaurantstyle.model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantStyleService {

	private RestaurantStyleDAO_interface dao;
	
	public RestaurantStyleService() {
		this.dao = new RestaurantStyleJDBCDAO();
	}
	public RestaurantStyleService(RestaurantStyleDAO_interface dao) {
		this.dao = dao;
	}
	
	public RestaurantStyleVO addRestaurantStyle(Integer restaurantId, Integer styleId) {
		
		RestaurantStyleVO restStyleVO = new RestaurantStyleVO();
		restStyleVO.setRestaurantId(restaurantId);
		restStyleVO.setStyleId(styleId);
		
		this.dao.insert(restStyleVO);
		
		return restStyleVO;
	}
	
	public List<RestaurantStyleVO> getAllRestaurantStyles() {
		return this.dao.getAll();
	}
	
	public RestaurantStyleVO updateRestaurantStyle(Integer newRestaurantId, Integer newStyleId, Integer oldRestaurantId, Integer oldStyleId) {
		
		RestaurantStyleVO newOne = new RestaurantStyleVO();
		RestaurantStyleVO oldOne = new RestaurantStyleVO();
		newOne.setRestaurantId(newRestaurantId);
		newOne.setStyleId(newStyleId);
		oldOne.setRestaurantId(oldRestaurantId);
		oldOne.setStyleId(oldStyleId);
		
		this.dao.update(newOne, oldOne);
		return newOne;
		
	}
	
	public List<RestaurantStyleVO> getRestaurantStylesByRestaurantId(Integer id) {
		List<RestaurantStyleVO> results = new ArrayList<>();
		for(RestaurantStyleVO restStyleVO : this.dao.getAll()) {
			if(id != null && id.equals(restStyleVO.getRestaurantId())) {
				results.add(restStyleVO);
			}
		}
		return results;
	}
}
