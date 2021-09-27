package com.RsOrder.modle;

import java.util.*;

public interface RsOrderDAO_interface {
	
	public void insert(RsOrderVO rsOrderVO);
	public void update(RsOrderVO rsOrderVO);
	public void delete(Integer orderId);
	public RsOrderVO findByPK(Integer orderId);
	public List<RsOrderVO> getAll();

}
