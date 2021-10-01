package com.address.model;

import java.util.*;

public interface AddressDAO_interface {
	 public void insert(AddressVO addressVO);
     public void update(AddressVO addressVO);
     public void delete(Integer deliveryAddid);
     public AddressVO findByPK(Integer deliveryAddid);
     public List<AddressVO> getAll();
     //查詢某部門的員工(一對多)(回傳 Set)
//     public Set<EmpVO> getEmpsByDeptno(Integer deliveryAddid);

}
