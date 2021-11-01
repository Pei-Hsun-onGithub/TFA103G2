package com.orderlist.model;

import java.util.List;

public class TestOrderListDAO {

	public static void main(String[] args) {
		OrderListDAO_interface dao = new OrderListDAO();

		// �s�W
//		OrderListVO ord1 = new OrderListVO();
//		ord1.setOrderId(1);
//		ord1.setMealId(2);
//		ord1.setQuantity("12");
//		ord1.setUnitPrice("2023-12-31");
//		ord1.setNote("���n�Y");
//		dao.insert(ord1);

		// �ק�
		OrderListVO ord2 = new OrderListVO();
		ord2.setOrderId(1);
		ord2.setMealId(2);
		ord2.setQuantity(2);
		ord2.setUnitPrice(2);;
		ord2.setNote("���Y");
		ord2.setOrderListId(2);
		

//		dao.update(ord2);
		
		// �R��
//		dao.delete(1);
		

		// �d��
//		OrderListVO ord3 = dao.findByPK(1);
//		System.out.println(ord3.toString());	
//		System.out.println("---------------------------------------------");

		// �d��
		List<OrderListVO> list = dao.getAll();
		for (OrderListVO ord4 : list) {
		System.out.println(ord4.toString());
		}
	}
}

