package com.OrderList.modle;

import java.util.List;


public interface OrderListDAO_interface {

	public void insert(OrderListVO rsOrderVO);
	public void update(OrderListVO rsOrderVO);
	public void delete(Integer orderListid);
	public OrderListVO findByPK(Integer orderListid);
	public List<OrderListVO> getAll();

}
