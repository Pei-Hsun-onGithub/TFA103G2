package com.achieve.model;

import java.io.Serializable;
import java.sql.Date;

public class Achieve implements Serializable {
	
	private int achiId;
	private String achiName;
	private String descript;
	private Date openDate;
	private int validDays;
	private int achiArticle;
	private int achiOrder;
	private int gainFeed;
	private int gainGold;
	private byte[] achiPic;
	
	public Achieve() {
	} 
	
	public Achieve(int achiId, String achiName, String descript, Date openDate, int validDays, int achiArticle,
			int achiOrder, int gainFeed, int gainGold, byte[] achiPic) {
		this.achiId = achiId;
		this.achiName = achiName;
		this.descript = descript;
		this.openDate = openDate;
		this.validDays = validDays;
		this.achiArticle = achiArticle;
		this.achiOrder = achiOrder;
		this.gainFeed = gainFeed;
		this.gainGold = gainGold;
		this.achiPic = achiPic;
	}

	public int getAchiId() {
		return achiId;
	}

	public void setAchiId(int achiId) {
		this.achiId = achiId;
	}

	public String getAchiName() {
		return achiName;
	}

	public void setAchiName(String achiName) {
		this.achiName = achiName;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getValidDays() {
		return validDays;
	}

	public void setValidDays(int validDays) {
		this.validDays = validDays;
	}

	public int getAchiArticle() {
		return achiArticle;
	}

	public void setAchiArticle(int achiArticle) {
		this.achiArticle = achiArticle;
	}

	public int getAchiOrder() {
		return achiOrder;
	}

	public void setAchiOrder(int achiOrder) {
		this.achiOrder = achiOrder;
	}

	public int getGainFeed() {
		return gainFeed;
	}

	public void setGainFeed(int gainFeed) {
		this.gainFeed = gainFeed;
	}

	public int getGainGold() {
		return gainGold;
	}

	public void setGainGold(int gainGold) {
		this.gainGold = gainGold;
	}

	public byte[] getAchiPic() {
		return achiPic;
	}

	public void setAchiPic(byte[] achiPic) {
		this.achiPic = achiPic;
	}
	
}
