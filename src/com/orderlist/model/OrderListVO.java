package com.orderlist.model;

public class OrderListVO implements java.io.Serializable {
	private Integer orderListId;
	private Integer orderId;
	private Integer mealId;
	private Integer quantity;
	private Integer unitPrice;
	private String note;
	

	public Integer getOrderListId() {
		return orderListId;
	}







	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}







	public Integer getOrderId() {
		return orderId;
	}







	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}







	public Integer getMealId() {
		return mealId;
	}







	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}







	public Integer getQuantity() {
		return quantity;
	}







	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}







	public Integer getUnitPrice() {
		return unitPrice;
	}







	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}







	public String getNote() {
		return note;
	}







	public void setNote(String note) {
		this.note = note;
	}







	@Override
	public String toString() {
		return "OrderListVO [orderListId=" + orderListId + ", orderId=" + orderId + ", mealId=" + mealId + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", note=" + note + "]";
	}

}