package com.card.model;

import java.sql.Date;
import java.util.List;

import com.card.model.CardVO;

public class CardDAOService {

	private CardDAO_interface dao;

	public CardDAOService() {
		dao = new CardDAO();
	}

	public CardVO addCardDAO(Integer userId, String cardHolder, String cardNumber, Date deadLine, String cvv, String billAddress, String zipCode, Integer sta) {
		
		CardVO cardVO = new CardVO();
		
		cardVO.setUserId(userId);
		cardVO.setCardHolder(cardHolder);
		cardVO.setCardNumber(cardNumber);
		cardVO.setDeadLine(deadLine);
		cardVO.setCvv(cvv);
		cardVO.setBillAddress(billAddress);
		cardVO.setZipCode(zipCode);
		cardVO.setSta(sta);
		dao.insert(cardVO);
		
		return cardVO;
	}
	
	public CardVO updateCardDAO(Integer userId, String cardHolder, String cardNumber, Date deadLine, String cvv, String billAddress, String zipCode, Integer sta) {
		
		CardVO cardVO = new CardVO();
		
		cardVO.setUserId(userId);
		cardVO.setCardHolder(cardHolder);
		cardVO.setCardNumber(cardNumber);
		cardVO.setDeadLine(deadLine);
		cardVO.setCvv(cvv);
		cardVO.setBillAddress(billAddress);
		cardVO.setZipCode(zipCode);
		cardVO.setSta(sta);
		dao.update(cardVO);
		
		return cardVO;
	}	

	public void deleteCardDAO(Integer carId) {
		dao.delete(carId);
	}	
	
		public CardVO getCardVAO(Integer carId) {
		return dao.findByPK(carId);
	}
		
		public List<CardVO> getAll() {
		return dao.getAll();
	}	
	
}
