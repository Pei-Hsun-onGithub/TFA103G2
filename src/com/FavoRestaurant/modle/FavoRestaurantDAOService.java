package com.FavoRestaurant.modle;

import java.util.List;
import com.FavoRestaurant.modle.FavoRestaurantVO;

public class FavoRestaurantDAOService {

	private FavoRestaurantDAO_interface dao;

	public FavoRestaurantDAOService() {
		dao = new FavoRestaurantDAO();
	}

	public FavoRestaurantVO addFavoRestaurantDAO(Integer userId,Integer restaurantId) {
		
		FavoRestaurantVO favoRestaurantVO = new FavoRestaurantVO();	
		
		favoRestaurantVO.setUserId(userId);
		favoRestaurantVO.setRestaurantId(restaurantId);
		dao.insert(favoRestaurantVO);
		
		return favoRestaurantVO;
	}

	public void deleteFavoRestaurantDAO(Integer userId,Integer restaurantId) {	
		dao.delete( userId, restaurantId);
	}

	public List<FavoRestaurantVO> getAll() {
		return dao.getAll();
	}

}
