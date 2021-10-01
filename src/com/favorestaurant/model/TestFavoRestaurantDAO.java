package com.favorestaurant.model;

import java.util.List;

public class TestFavoRestaurantDAO {

	public static void main(String[] args) {
		FavoRestaurantDAO_interface dao = new FavoRestaurantDAO();

		// 新增
		FavoRestaurantVO favoRestaurant1 = new FavoRestaurantVO();
		favoRestaurant1.setUserId(2);
		favoRestaurant1.setRestaurantId(1);
		dao.insert(favoRestaurant1);

		
		// 刪除
		dao.delete(2,1);
		

		// 查詢
		List<FavoRestaurantVO> list = dao.getAll();
		for (FavoRestaurantVO favoRestaurant2 : list) {
		System.out.print(favoRestaurant2.getUserId() + ",");
		System.out.print(favoRestaurant2.getRestaurantId() + ",");
		System.out.println();
		}
	}
}

