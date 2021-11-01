package com.rsorder.model;

import java.util.*;

import com.orderlist.model.OrderListVO;

public interface RsOrderDAO_interface {
	
	public RsOrderVO insert(RsOrderVO rsOrderVO);
	public RsOrderVO insert2(RsOrderVO rsOrderVO);
	public void update(RsOrderVO rsOrderVO);
	public void delete(Integer orderId);
	public RsOrderVO findByPK(Integer orderId);
	public List<RsOrderVO> getAll();
	public List<RsOrderVO> getOrdersByUserId(Integer userId);
	public void insertWithOl (RsOrderVO rsOrderVO, List<OrderListVO> list);

}
