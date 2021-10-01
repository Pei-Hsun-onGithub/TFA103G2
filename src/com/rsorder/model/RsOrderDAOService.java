package com.rsorder.model;

import java.sql.Date;
import java.util.List;

import com.rsorder.model.RsOrderVO;

public class RsOrderDAOService {

	private RsOrderDAO_interface dao;

	public RsOrderDAOService() {
		dao = new RsOrderDAO();
	}

	public RsOrderVO addRsOrderDAO(Integer userId, Integer restaurantId, Integer cardId, Integer deliveryAddId, Integer deliveryMethods, Date orderDay, Date resStrTime, Date resEndTime, Date delStrTime, Date delEndTime, Integer count, String texts, Integer sta) {
		
		RsOrderVO rsOrderVO = new RsOrderVO();

		rsOrderVO.setUserId(userId);
		rsOrderVO.setRestaurantId(restaurantId);
		rsOrderVO.setCardId(cardId);
		rsOrderVO.setDeliveryAddId(deliveryAddId);
		rsOrderVO.setDeliveryMethods(deliveryMethods);
		rsOrderVO.setOrderDay(orderDay);
		rsOrderVO.setResStrTime(resStrTime);
		rsOrderVO.setResEndTime(resEndTime);
		rsOrderVO.setDelStrTime(delStrTime);
		rsOrderVO.setDelEndTime(delEndTime);
		rsOrderVO.setCount(count);
		rsOrderVO.setTexts(texts);
		rsOrderVO.setSta(sta);
		dao.insert(rsOrderVO);
		
		return rsOrderVO;
	}
	
	public RsOrderVO updateRsOrderDAO(Integer userId, Integer restaurantId, Integer cardId, Integer deliveryAddId, Integer deliveryMethods, Date orderDay, Date resStrTime, Date resEndTime, Date delStrTime, Date delEndTime, Integer count, String texts, Integer sta) {
		
		RsOrderVO rsOrderVO = new RsOrderVO();
		rsOrderVO.setUserId(userId);
		rsOrderVO.setRestaurantId(restaurantId);
		rsOrderVO.setCardId(cardId);
		rsOrderVO.setDeliveryAddId(deliveryAddId);
		rsOrderVO.setDeliveryMethods(deliveryMethods);
		rsOrderVO.setOrderDay(orderDay);
		rsOrderVO.setResStrTime(resStrTime);
		rsOrderVO.setResEndTime(resEndTime);
		rsOrderVO.setDelStrTime(delStrTime);
		rsOrderVO.setDelEndTime(delEndTime);
		rsOrderVO.setCount(count);
		rsOrderVO.setTexts(texts);
		rsOrderVO.setSta(sta);
		dao.update(rsOrderVO);
		
		return rsOrderVO;
	}	

	public void deleteRsOrderDAO(Integer orderId) {
		dao.delete(orderId);
	}	
	
		public RsOrderVO getCardVAO(Integer orderId) {
		return dao.findByPK(orderId);
	}
		
		public List<RsOrderVO> getAll() {
		return dao.getAll();
	}	
	
}
