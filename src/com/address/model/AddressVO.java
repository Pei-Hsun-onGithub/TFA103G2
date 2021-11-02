package com.address.model;

public class AddressVO implements java.io.Serializable {
	private Integer deliveryAddId;
	private Integer userId;
	private String customerName;
	private String deliverPhone;
	private String deliverAddress;
	private String buildingName;
	private String note;
	private Integer sta;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingName == null) ? 0 : buildingName.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((deliverAddress == null) ? 0 : deliverAddress.hashCode());
		result = prime * result + ((deliverPhone == null) ? 0 : deliverPhone.hashCode());
		result = prime * result + ((deliveryAddId == null) ? 0 : deliveryAddId.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((sta == null) ? 0 : sta.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressVO other = (AddressVO) obj;
		if (buildingName == null) {
			if (other.buildingName != null)
				return false;
		} else if (!buildingName.equals(other.buildingName))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (deliverAddress == null) {
			if (other.deliverAddress != null)
				return false;
		} else if (!deliverAddress.equals(other.deliverAddress))
			return false;
		if (deliverPhone == null) {
			if (other.deliverPhone != null)
				return false;
		} else if (!deliverPhone.equals(other.deliverPhone))
			return false;
		if (deliveryAddId == null) {
			if (other.deliveryAddId != null)
				return false;
		} else if (!deliveryAddId.equals(other.deliveryAddId))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (sta == null) {
			if (other.sta != null)
				return false;
		} else if (!sta.equals(other.sta))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	public Integer getDeliveryAddId() {
		return deliveryAddId;
	}
	public void setDeliveryAddId(Integer deliveryAddId) {
		this.deliveryAddId = deliveryAddId;
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
