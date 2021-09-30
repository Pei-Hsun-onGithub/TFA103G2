package com.favorestaurant.model;

import java.util.List;

public class TestFavoRestaurantDAO {

	public static void main(String[] args) {
		FavoRestaurantDAO_interface dao = new FavoRestaurantDAO();

		// �s�W
		FavoRestaurantVO favoRestaurant1 = new FavoRestaurantVO();
		favoRestaurant1.setUserId(2);
		favoRestaurant1.setRestaurantId(1);
		dao.insert(favoRestaurant1);

		
		// �R��
		dao.delete(2,1);
		

		// �d��
		List<FavoRestaurantVO> list = dao.getAll();
		for (FavoRestaurantVO favoRestaurant2 : list) {
		System.out.print(favoRestaurant2.getUserId() + ",");
		System.out.print(favoRestaurant2.getRestaurantId() + ",");
		System.out.println();
		}
	}
}

