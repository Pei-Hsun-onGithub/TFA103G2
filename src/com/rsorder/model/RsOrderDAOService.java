package com.rsorder.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.orderlist.model.OrderListVO;
import com.rsorder.model.RsOrderVO;

public class RsOrderDAOService {

	private RsOrderDAO_interface dao;

	public RsOrderDAOService() {
		dao = new RsOrderDAO();
	}

	public RsOrderVO addRsOrderDAO(Integer userId, Integer restaurantId, Integer cardId, Integer deliveryAddId,
			Integer deliveryMethods, Date orderDay, Date resStrTime, Date resEndTime, Date delStrTime, Date delEndTime,
			Integer count, String texts, Integer sta) {

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

		return dao.insert(rsOrderVO);
	}

	public RsOrderVO addRsOrderDAO2(Integer userId, Integer cardId, Integer deliveryAddId) 
	
	{

		RsOrderVO rsOrderVO = new RsOrderVO();

		rsOrderVO.setUserId(userId);
		rsOrderVO.setCardId(cardId);
		rsOrderVO.setDeliveryAddId(deliveryAddId);

		return dao.insert2(rsOrderVO);
	}
	
	public RsOrderVO updateRsOrderDAO(Integer userId, Integer restaurantId, Integer cardId, Integer deliveryAddId,
			Integer deliveryMethods, Date orderDay, Date resStrTime, Date resEndTime, Date delStrTime, Date delEndTime,
			Integer count, String texts, Integer sta) {

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

	public List<RsOrderVO> getOrdersByUserId(Integer userId) {
		
		return this.dao.getOrdersByUserId(userId);
	}
	
	public Set<RsOrderVO> getRsOrderByUserId(Integer userId) {
		return dao.getRsOrderByUserId(userId);
	}
	
	public void insertWithOl(RsOrderVO rsOrderVO, List<OrderListVO> list) {
		dao.insertWithOl(rsOrderVO, list);
	}
}
	
	

