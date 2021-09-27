package com.OrderList.modle;

import java.util.List;

public class TestOrderListDAO {

	public static void main(String[] args) {
		OrderListDAO_interface dao = new OrderListDAO();

		// 新增
//		OrderListVO ord1 = new OrderListVO();
//		ord1.setOrderId(1);
//		ord1.setMealId(2);
//		ord1.setQuantity("12");
//		ord1.setUnitPrice("2023-12-31");
//		ord1.setNote("不好吃");
//		dao.insert(ord1);

		// 修改
		OrderListVO ord2 = new OrderListVO();
		ord2.setOrderId(1);
		ord2.setMealId(2);
		ord2.setQuantity("123478");
		ord2.setUnitPrice("20");;
		ord2.setNote("不吃");
		ord2.setOrderListId(2);
		

//		dao.update(ord2);
		
		// 刪除
//		dao.delete(1);
		

		// 查詢
//		OrderListVO ord3 = dao.findByPK(1);
//		System.out.println(ord3.toString());	
//		System.out.println("---------------------------------------------");

		// 查詢
		List<OrderListVO> list = dao.getAll();
		for (OrderListVO ord4 : list) {
		System.out.println(ord4.toString());
		}
	}
}

