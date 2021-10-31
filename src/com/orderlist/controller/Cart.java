package com.orderlist.controller;

public class Cart implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer mealId;
	private String mealName;
	private Integer unitPrice;
	private Integer quantity;
	
	public Cart() {
		mealId = 0;
		mealName = "";
		quantity = 0;
		unitPrice = 0;
	}



	public Integer getMealId() {
		return mealId;
	}



	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}



	public String getMealName() {
		return mealName;
	}



	public void setMealName(String mealName) {
		this.mealName = mealName;
	}



	public Integer getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "cart [mealId=" + mealId + ", mealName=" + mealName + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mealName == null) ? 0 : mealName.hashCode());
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
		Cart other = (Cart) obj;
		if (mealName == null) {
			if (other.mealName != null)
				return false;
		} else if (!mealName.equals(other.mealName))
			return false;
		return true;
	}
}