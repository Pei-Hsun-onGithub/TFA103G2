package com.orderlist.model;

import java.util.List;

import com.orderlist.model.OrderListVO;

public class OrderListDAOService {

	private OrderListDAO_interface dao;

	public OrderListDAOService() {
		dao = new OrderListDAO();
	}

	public OrderListVO addOrderListDAO( Integer orderId, Integer mealId, String quantity, String unitPrice, String note) {
		
		OrderListVO orderListVO = new OrderListVO();
		
		orderListVO.setOrderId(orderId);
		orderListVO.setMealId(mealId);
		orderListVO.setQuantity(quantity);
		orderListVO.setUnitPrice(quantity);
		orderListVO.setNote(note);
		
		
		return dao.insert(orderListVO);
	}
	
	public OrderListVO updateOrderListDAO( Integer orderId, Integer mealId, String quantity, String unitPrice, String note) {
		
		OrderListVO orderListVO = new OrderListVO();
		
		orderListVO.setOrderId(orderId);
		orderListVO.setMealId(mealId);
		orderListVO.setQuantity(quantity);
		orderListVO.setUnitPrice(quantity);
		orderListVO.setNote(note);
		dao.update(orderListVO);
		
		return orderListVO;
	}

	public void deleteOrderListDAO(Integer orderListid) {
		dao.delete(orderListid);
	}

	public OrderListVO getOrderListVAO(Integer orderListid) {
		return dao.findByPK(orderListid);
	}

	public List<OrderListVO> getAll() {
		return dao.getAll();
	}

}
