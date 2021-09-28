package com.achieve.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestJDBCDAO {
	
	public static void main(String[] args) throws IOException {
		AchieveDAO dao = new AchieveDAOImpl();
		
		// 新增
//		Achieve ach1 = new Achieve();
//		byte[] data1 = getPictureByteArray("pictest/heart.png");
///		ach1.setAchiId(2013);
//		ach1.setAchiName("大胃王");
//		ach1.setDescript("成功完成訂單");
//		ach1.setOpenDate(java.sql.Date.valueOf("2016-01-01"));
//		ach1.setValidDays(30);
//		ach1.setAchiArticle(10);
//		ach1.setAchiOrder(10);
//		ach1.setGainFeed(100);
//		ach1.setGainGold(100);
//		ach1.setAchiPic(data1);
//		dao.add(ach1);
		

		// 修改
//		Achieve ach2 = new Achieve();
//		byte[] data2 = getPictureByteArray("pictest/heart.png");
//		ach2.setAchiId(2014);
//		ach2.setAchiName("掰掰");
//		ach2.setDescript("成功完成訂單");
//		ach2.setOpenDate(java.sql.Date.valueOf("2016-01-01"));
//		ach2.setValidDays(30);
//		ach2.setAchiArticle(50);
//		ach2.setAchiOrder(25);
//		ach2.setGainFeed(100);
//		ach2.setGainGold(100);
//		ach2.setAchiPic(data2);
//		dao.update(ach2);

		// 刪除
//		dao.delete(2015);

		// 查詢
//		Achieve ach3 = dao.findByPK(2002);
//		System.out.print(ach3.getAchiId() + ",");
//		System.out.print(ach3.getAchiName() + ",");
//		System.out.print(ach3.getDescript() + ",");
//		System.out.print(ach3.getOpenDate() + ",");
//		System.out.print(ach3.getValidDays() + ",");
//		System.out.print(ach3.getAchiArticle() + ",");
//		System.out.print(ach3.getAchiOrder() + ",");
//		System.out.print(ach3.getGainFeed() + ",");
//		System.out.print(ach3.getGainGold() + ",");
//		System.out.println(ach3.getAchiPic());
//		System.out.println("---------------------");

		// 查詢
		List<Achieve> list = dao.getAll();
		for (Achieve ach : list) {
			System.out.print(ach.getAchiId() + ",");
			System.out.print(ach.getAchiName() + ",");
			System.out.print(ach.getDescript() + ",");
			System.out.print(ach.getOpenDate() + ",");
			System.out.print(ach.getValidDays() + ",");
			System.out.print(ach.getAchiArticle() + ",");
			System.out.print(ach.getAchiOrder() + ",");
			System.out.print(ach.getGainFeed() + ",");
			System.out.print(ach.getGainGold() + ",");
			System.out.print(ach.getAchiPic());
			System.out.println();
		}
		
	}
	
	// 使用byte[]方式
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}


