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
