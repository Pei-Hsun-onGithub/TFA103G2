package com.levelexp.model;

import java.util.List;

public class TestJDBCDAO {
	
	public static void main(String[] args) {
		LevelExpDAO dao = new LevelExpDAOImpl();
		
		// 新增
//		LevelExp lev1 = new LevelExp();
//		lev1.setLv(5);
//		lev1.setExpLow(1000);
//		lev1.setExpUp(10000);
//		dao.add(lev1);
		
		// 修改
//		LevelExp lev2 = new LevelExp();
//		lev2.setLv(2);
//		lev2.setExpLow(10);
//		lev2.setExpUp(80);
//		dao.update(lev2);
		
		//刪除
//		dao.delete(5);
		
		//查詢
//		LevelExp lev3 = dao.findByPK(1);
//		System.out.print(lev3.getLv() + ",");
//		System.out.print(lev3.getExpLow() + ",");
//		System.out.println(lev3.getExpUp());
//		System.out.println("---------------------");
		
		//查詢
		List<LevelExp> list = dao.getAll();
		for(LevelExp lev : list) {
			System.out.print(lev.getLv() + ",");
			System.out.print(lev.getExpLow() + ",");
			System.out.print(lev.getExpUp());
			System.out.println();
		}
		
	}

}
