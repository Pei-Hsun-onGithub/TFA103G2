package com.card.model;

import java.sql.Date;

public class CardVO implements java.io.Serializable {
	private Integer cardId;
	private Integer userId;
	private String cardHolder;
	private String cardNumber;
	private Date deadLine;
	private String cvv;
	private String billAddress;
	private String zipCode;
	private Integer sta;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getBillAddress() {
		return billAddress;
	}

	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}

	@Override
	public String toString() {
		return "CardVO [cardId=" + cardId + ", userId=" + userId + ", cardHolder=" + cardHolder + ", cardNumber="
				+ cardNumber + ", deadLine=" + deadLine + ", cvv=" + cvv + ", billAddress=" + billAddress + ", zipCode="
				+ zipCode + ", sta=" + sta + "]";
	}

}
