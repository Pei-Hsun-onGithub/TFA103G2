package com.address.model;

import java.util.List;
import java.util.Set;

public class AddressService {

	private AddressDAO_interface dao;

	public AddressService() {
		dao = new AddressDAO();
	}

	public AddressVO addAddress	(Integer userId, String customerName, String deliverPhone, String deliverAddress, String buildingName, String note, Integer sta) {
		
		AddressVO addressVO = new AddressVO();
		
		addressVO.setUserId(userId);
		addressVO.setCustomerName(customerName);
		addressVO.setDeliverPhone(deliverPhone);
		addressVO.setDeliverAddress(deliverAddress);
		addressVO.setBuildingName(buildingName);
		addressVO.setNote(note);
		addressVO.setSta(sta);
		dao.insert(addressVO);
		
		return addressVO;
	}

	public AddressVO updateAddress(Integer userId, String customerName, String deliverPhone, String deliverAddress, String buildingName, String note, Integer sta ,Integer deliveryAddId) {
		
		AddressVO addressVO = new AddressVO();
		addressVO.setUserId(userId);
		addressVO.setCustomerName(customerName);
		addressVO.setDeliverPhone(deliverPhone);
		addressVO.setDeliverAddress(deliverAddress);
		addressVO.setBuildingName(buildingName);
		addressVO.setNote(note);
		addressVO.setSta(sta);
		addressVO.setDeliveryAddId(deliveryAddId);
		dao.update(addressVO);
		
		return addressVO;
	}

	public void deleteAddress(Integer deliveryAddId) {
		dao.delete(deliveryAddId);
	}

	public AddressVO getOneAddress(Integer deliveryAddId) {
		return dao.findByPK(deliveryAddId);
	}

	public List<AddressVO> getAll() {
		return dao.getAll();
	}
	
	public Set<AddressVO> getAddressByUserId(Integer userId) {
		return dao.getAddressByUserId(userId);
	}

}
