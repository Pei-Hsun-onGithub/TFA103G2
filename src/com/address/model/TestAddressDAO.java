package com.address.model;

import java.util.List;

public class TestAddressDAO {

	public static void main(String[] args) {
		AddressDAO_interface dao = new AddressDAO();

		// 穝糤
//		AddressVO add1 = new AddressVO();
//		add1.setUserId(1);
//		add1.setCustomerName("David");
//		add1.setDeliverPhone("34324");
//		add1.setDeliverAddress("ゅ跋");
//		add1.setBuildingName("加");
//		add1.setNote("次次");
//		add1.setSta(10);
//		dao.insert(add1);
//	
		// э
//		AddressVO add2 = new AddressVO();
//		add2.setUserId(1);
//		add2.setCustomerName("る獹");
//		add2.setDeliverPhone("0222983345");
//		add2.setDeliverAddress("カ");
//		add2.setBuildingName("加");
//		add2.setNote("и璶欢");
//		add2.setSta(1);
//		add2.setDeliveryAddid(5);
//		dao.update(add2);
		
		// 埃
//		dao.delete(2);
		

		// 琩高
//		AddressVO add3 = dao.findByPK(5);
//		System.out.print(add3.getDeliveryAddid() + ",");
//		System.out.print(add3.getUserId() + ",");
//		System.out.print(add3.getCustomerName() + ",");
//		System.out.print(add3.getDeliverPhone() + ",");
//		System.out.print(add3.getDeliverAddress() + ",");
//		System.out.print(add3.getBuildingName() + ",");
//		System.out.print(add3.getNote() +  ",");
//		System.out.println(add3.getSta() + ",");
//		System.out.println("---------------------------------------------");

		// 琩高
		List<AddressVO> list = dao.getAll();
		for (AddressVO add4 : list) {
			System.out.print(add4.getDeliveryAddId() + ",");
			System.out.print(add4.getUserId() + ",");
			System.out.print(add4.getCustomerName() + ",");
			System.out.print(add4.getDeliverPhone() + ",");
			System.out.print(add4.getDeliverAddress() + ",");
			System.out.print(add4.getBuildingName() + ",");
			System.out.print(add4.getNote() +  ",");
			System.out.println(add4.getSta() + ",");
			System.out.println();
		}
	}
}

