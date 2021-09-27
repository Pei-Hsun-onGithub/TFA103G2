package com.Address.modle;

import java.util.List;
import com.Address.modle.AddressVO;


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

	public AddressVO updateAddress(Integer userId, String customerName, String deliverPhone, String deliverAddress, String buildingName, String note, Integer sta) {
		
		AddressVO addressVO = new AddressVO();
		
		addressVO.setUserId(userId);
		addressVO.setCustomerName(customerName);
		addressVO.setDeliverPhone(deliverPhone);
		addressVO.setDeliverAddress(deliverAddress);
		addressVO.setBuildingName(buildingName);
		addressVO.setNote(note);
		addressVO.setSta(sta);
		dao.update(addressVO);
		
		return addressVO;
	}

	public void deleteAddress(Integer deliveryAddid) {
		dao.delete(deliveryAddid);
	}

	public AddressVO getOneAddress(Integer deliveryAddid) {
		return dao.findByPK(deliveryAddid);
	}

	public List<AddressVO> getAll() {
		return dao.getAll();
	}

}
