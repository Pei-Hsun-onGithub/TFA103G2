package com.restaurantstyle.model;

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
}
