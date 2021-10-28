package com.foodarticle.model;

import java.util.List;


public class TsetFoodArticle {
	public static void main(String[] args) {
		
		FoodArticleDAO_interface dao = new FoodArticleJDBCDAO();
		
		//�s�W
		
		FoodArticleVO far1 = new FoodArticleVO();
//		far1.setUserId(1113);
//		far1.setRestaurantId(55592);
//		far1.setArticleTitle("�p�X���ӶQ");
//		far1.setArticleDate(java.sql.Date.valueOf("2016-01-01"));
//		far1.setArticleContent("�]�ӶQ�F�O�b�d�X�I,�A�ȥͯ��y���");
//		far1.setSta(0);
//		dao.add(far1);
		
		//�ק�
		
		//FoodArticle far2 = new FoodArticle();
		
//		far1.setArticleNo(3);
//		far1.setUserId(1113);
//		far1.setRestaurantId(55592);
//		far1.setArticleTitle("�p�X���ӶQ");
//		far1.setArticleDate(java.sql.Date.valueOf("2021-09-10"));
//		far1.setArticleContent("�]�ӶQ�F�O�b�d�X�I,�A�ȥͯ��y���");
//		far1.setSta(0);
//		dao.update(far1);
		//dao.update(far2);
		
		//�R��
		
		//dao.delete(4);
		
		//�d��one
		
//		FoodArticle far2 = dao.findByPrimaryKey(3);
//		System.out.print(far2.getArticleNo() + ",");
//		System.out.print(far2.getUserId() + ",");
//		System.out.print(far2.getRestaurantId() + ",");
//		System.out.print(far2.getArticleTitle() + ",");
//		System.out.print(far2.getArticleDate() + ",");
//		System.out.print(far2.getArticleContent() + ",");
//		System.out.println(far2.getSta());
		
		//�d�� all
		
//		List<FoodArticleVO> List = dao.getall();
//		for (FoodArticleVO far3 : List) {
//			System.out.print(far3.getArticleNo() + ",");
//			System.out.print(far3.getUserId() + ",");
//			System.out.print(far3.getRestaurantId() + ",");
//			System.out.print(far3.getArticleTitle() + ",");
//			System.out.print(far3.getArticleDate() + ",");
//			System.out.print(far3.getArticleContent() + ",");
//			System.out.println(far3.getSta());
//			System.out.println();
//		}
		 String words ="肯";
		List<FoodArticleVO> List = dao.searchKeyWord(words);
		System.out.println(List);
		
		
		
		
	}
}
