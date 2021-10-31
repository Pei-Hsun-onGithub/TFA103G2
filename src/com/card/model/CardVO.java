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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billAddress == null) ? 0 : billAddress.hashCode());
		result = prime * result + ((cardHolder == null) ? 0 : cardHolder.hashCode());
		result = prime * result + ((cardId == null) ? 0 : cardId.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
		result = prime * result + ((deadLine == null) ? 0 : deadLine.hashCode());
		result = prime * result + ((sta == null) ? 0 : sta.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		CardVO other = (CardVO) obj;
		if (billAddress == null) {
			if (other.billAddress != null)
				return false;
		} else if (!billAddress.equals(other.billAddress))
			return false;
		if (cardHolder == null) {
			if (other.cardHolder != null)
				return false;
		} else if (!cardHolder.equals(other.cardHolder))
			return false;
		if (cardId == null) {
			if (other.cardId != null)
				return false;
		} else if (!cardId.equals(other.cardId))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cvv == null) {
			if (other.cvv != null)
				return false;
		} else if (!cvv.equals(other.cvv))
			return false;
		if (deadLine == null) {
			if (other.deadLine != null)
				return false;
		} else if (!deadLine.equals(other.deadLine))
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
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

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
