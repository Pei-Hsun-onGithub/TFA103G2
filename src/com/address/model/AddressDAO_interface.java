package com.address.model;

import java.util.*;

import com.address.model.AddressVO;

public interface AddressDAO_interface {
	 public void insert(AddressVO addressVO);
     public void update(AddressVO addressVO);
     public void delete(Integer deliveryAddid);
     public AddressVO findByPK(Integer deliveryAddid);
     public List<AddressVO> getAll();
     public Set<AddressVO> getAddressByUserId(Integer userId);
     //�d�߬Y���������u(�@��h)(�^�� Set)
//     public Set<EmpVO> getEmpsByDeptno(Integer deliveryAddid);

}
