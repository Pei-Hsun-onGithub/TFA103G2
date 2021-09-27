package com.Address.modle;

public class AddressVO implements java.io.Serializable {
	private Integer deliveryAddId;
	private Integer userId;
	private String customerName;
	private String deliverPhone;
	private String deliverAddress;
	private String buildingName;
	private String note;
	private Integer sta;

	public Integer getDeliveryAddid() {
		return deliveryAddId;
	}

	public void setDeliveryAddid(Integer deliveryAddid) {
		this.deliveryAddId = deliveryAddid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliverPhone() {
		return deliverPhone;
	}

	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}

	public String getDeliverAddress() {
		return deliverAddress;
	}

	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}

}
