package com.achieveprogress.model;

import java.util.List;

public class TestJDBCDAO {
	
	public static void main(String[] args) {
		AchieveProgressDAO dao = new AchieveProgressDAOImpl();
		
		// 新增
//		AchieveProgress achp1 = new AchieveProgress();
//		achp1.setUserId(20210001);
//		achp1.setAchiId(2007);
//		achp1.setCurrentArticle(3);
//		achp1.setCurrentOrder(5);
//		achp1.setBeginDate(java.sql.Date.valueOf("2016-01-01"));
//		achp1.setSta(3);
//		dao.add(achp1);
		
		// 修改
//		AchieveProgress achp2 = new AchieveProgress();
//		achp2.setUserId(20210001);
//		achp2.setAchiId(2007);
//		achp2.setCurrentArticle(4);
//		achp2.setCurrentOrder(0);
//		achp2.setBeginDate(java.sql.Date.valueOf("2016-01-01"));
//		achp2.setSta(5);
//		dao.update(achp2);
		
		//刪除
//		dao.delete(20210001, 2007);
		
		//查詢
//		AchieveProgress achp3 = dao.findByPK(20210002, 2002);
//		System.out.print(achp3.getUserId() + ",");
//		System.out.print(achp3.getAchiId() + ",");
//		System.out.print(achp3.getCurrentArticle() + ",");
//		System.out.print(achp3.getCurrentOrder() + ",");
//		System.out.print(achp3.getBeginDate() + ",");
//		System.out.println(achp3.getSta());
//		System.out.println("---------------------");
		
		//查詢
//		List<AchieveProgress> list = dao.getAll();
//		for(AchieveProgress achp : list) {
//			System.out.print(achp.getUserId() + ",");
//			System.out.print(achp.getAchiId() + ",");
//			System.out.print(achp.getCurrentArticle() + ",");
//			System.out.print(achp.getCurrentOrder() + ",");
//			System.out.print(achp.getBeginDate() + ",");
//			System.out.print(achp.getSta());
//			System.out.println();
//		}
	}

}
