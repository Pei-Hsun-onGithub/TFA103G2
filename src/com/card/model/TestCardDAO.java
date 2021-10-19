package com.card.model;

import java.util.List;

public class TestCardDAO {

	public static void main(String[] args) {
		CardDAO_interface dao = new CardDAO();

		// ·s¼W
		CardVO card1 = new CardVO();
		card1.setUserId(20210001);
		card1.setCardHolder("¾G¥ì°·");
		card1.setCardNumber("1234567812345678");
		card1.setDeadLine(java.sql.Date.valueOf("2023-12-31"));
		card1.setCvv("466");
		System.out.println(card1.getCvv());
		card1.setBillAddress("¶³ªL¿¤ªê§ÀÂíªê¿³¦è¤Tµó27¸¹´Î");
		card1.setZipCode("632");
		card1.setSta(1);
		dao.insert(card1);

		// ­×§ï
//		CardVO card2 = new CardVO();
//		card2.setCardId(1);
//		card2.setUserId(1);
//		card2.setCardHolder("ÁÂ¾^¾W");
//		card2.setCardNumber("7890567834566789");
//		card2.setDeadLine(java.sql.Date.valueOf("2023-12-31"));
//		card2.setCvv("123");
//		card2.setBillAddress("¶³ªL¿¤ªê§ÀÂíªê¿³¦è¤Tµó27¸¹´Î");
//		card2.setZipCode("632");
//		card2.setSta(1);

//		dao.update(card2);
		
		// §R°£
//		dao.delete(1);
		

		// ¬d¸ß
//		CardVO card3 = dao.findByPK(2);
//		System.out.println(card3.toString());	
//		System.out.print(card3.getCardId() + ",");
//		System.out.print(card3.getUserId() + ",");
//		System.out.print(card3.getCardHolder() + ",");
//		System.out.print(card3.getCardNumber() + ",");
//		System.out.print(card3.getDeadLine() + ",");
//		System.out.print(card3.getCvv() + ",");
//		System.out.print(card3.getBillAddress() +  ",");
//		System.out.print(card3.getZipCode() +  ",");
//		System.out.print(card3.getSta() +  ",");
//		System.out.println(card3.getSta() + ",");
//		System.out.println("---------------------------------------------");

		// ¬d¸ß
//		List<CardVO> list = dao.getAll();
//		for (CardVO card4 : list) {
//		System.out.println(card4.toString());
//		System.out.print(card4.getCardId() + ",");
//		System.out.print(card4.getUserId() + ",");
//		System.out.print(card4.getCardHolder() + ",");
//		System.out.print(card4.getCardNumber() + ",");
//		System.out.print(card4.getDeadLine() + ",");
//		System.out.print(card4.getCvv() + ",");
//		System.out.print(card4.getBillAddress() +  ",");
//		System.out.print(card4.getZipCode() +  ",");
//		System.out.print(card4.getSta() +  ",");
//		System.out.println(card4.getSta() + ",");
//		System.out.println();
		
//		}
	}
}

