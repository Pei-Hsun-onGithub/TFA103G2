package com.rsorder.model;

import java.util.*;

public interface RsOrderDAO_interface {
	
	public RsOrderVO insert(RsOrderVO rsOrderVO);
	public void update(RsOrderVO rsOrderVO);
	public void delete(Integer orderId);
	public RsOrderVO findByPK(Integer orderId);
	public List<RsOrderVO> getAll();
	public List<RsOrderVO> getOrdersByUserId(Integer userId);

}
