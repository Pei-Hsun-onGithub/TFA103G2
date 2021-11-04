package com.orderlist.model;

import java.util.List;
import java.util.Set;

public interface OrderListDAO_interface {

	public OrderListVO insert(OrderListVO rsOrderVO);
	public void update(OrderListVO rsOrderVO);
	public void delete(Integer orderListid);
	public OrderListVO findByPK(Integer orderListid);
	public List<OrderListVO> getAll();
	public void insertWithRsOrder (OrderListVO orderListVO, java.sql.Connection con);
	
	
	public Integer getTotalPriceByOrderId(Integer orderId);
	
	public Set<OrderListVO> getAllOrderListByOrderId(Integer orderId);
}
