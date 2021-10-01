package com.rsorder.model;

import java.util.List;

public class TestRsOrderDAO {

	public static void main(String[] args) {
		RsOrderDAO_interface dao = new RsOrderDAO();

		// 新增
//		RsOrderVO rsOrder1 = new RsOrderVO();
//		rsOrder1.setUserId(2);
//		rsOrder1.setRestaurantId(2);
//		rsOrder1.setCardId(2);
//		rsOrder1.setDeliveryAddId(2);
//		rsOrder1.setDeliveryMethods(0);
//		rsOrder1.setOrderDay(java.sql.Date.valueOf("2023-12-31"));
//		rsOrder1.setResStrTime(java.sql.Date.valueOf("2023-12-31"));
//		rsOrder1.setResEndTime(java.sql.Date.valueOf("2023-12-31"));
//		rsOrder1.setDelStrTime(java.sql.Date.valueOf("2023-12-31"));
//		rsOrder1.setDelEndTime(java.sql.Date.valueOf("2023-12-31"));
//		rsOrder1.setCount(5);
//		rsOrder1.setTexts("不好吃");
//		rsOrder1.setSta(1);
		
//		dao.insert(rsOrder1);
	
		// 修改
//		RsOrderVO rsOrder2 = new RsOrderVO();
//		rsOrder2.setOrderId(2);
//		rsOrder2.setUserId(2);
//		rsOrder2.setRestaurantId(2);
//		rsOrder2.setCardId(2);
//		rsOrder2.setDeliveryAddId(2);
//		rsOrder2.setDeliveryMethods(0);
//		rsOrder2.setOrderDay(java.sql.Date.valueOf("2023-12-31"));
//		rsOrder2.setResStrTime(java.sql.Date.valueOf("9999-12-31"));
//		rsOrder2.setResEndTime(java.sql.Date.valueOf("9999-12-31"));
//		rsOrder2.setDelStrTime(java.sql.Date.valueOf("9999-12-31"));
//		rsOrder2.setDelEndTime(java.sql.Date.valueOf("9999-12-31"));
//		rsOrder2.setCount(5);
//		rsOrder2.setTexts("好");
//		rsOrder2.setSta(1);
//		dao.update(rsOrder2);
	
		// 刪除
//		dao.delete(3);
		

		// 查詢
//		RsOrderVO rsOrder3 = dao.findByPK(2);
//		System.out.println(rsOrder3.toString());	
//		System.out.print(rsOrder3.getrsOrderId() + ",");
//		System.out.print(rsOrder3.getUserId() + ",");
//		System.out.print(rsOrder3.getrsOrderHolder() + ",");
//		System.out.print(rsOrder3.getrsOrderNumber() + ",");
//		System.out.print(rsOrder3.getDeadLine() + ",");
//		System.out.print(rsOrder3.getCvv() + ",");
//		System.out.print(rsOrder3.getBillAddress() +  ",");
//		System.out.print(rsOrder3.getZipCode() +  ",");
//		System.out.print(rsOrder3.getSta() +  ",");
//		System.out.println(rsOrder3.getSta() + ",");
//		System.out.println("---------------------------------------------");

		// 查詢
		List<RsOrderVO> list = dao.getAll();
		for (RsOrderVO rsOrder4 : list) {
		System.out.println(rsOrder4.toString());	
//		System.out.print(rsOrder4.getrsOrderId() + ",");
//		System.out.print(rsOrder4.getUserId() + ",");
//		System.out.print(rsOrder4.getrsOrderHolder() + ",");
//		System.out.print(rsOrder4.getrsOrderNumber() + ",");
//		System.out.print(rsOrder4.getDeadLine() + ",");
//		System.out.print(rsOrder4.getCvv() + ",");
//		System.out.print(rsOrder4.getBillAddress() +  ",");
//		System.out.print(rsOrder4.getZipCode() +  ",");
//		System.out.print(rsOrder4.getSta() +  ",");
//		System.out.println(rsOrder4.getSta() + ",");
//		System.out.println();
		}
	}
}

