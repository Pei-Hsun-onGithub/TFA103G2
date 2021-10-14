package com.achieve.model;

import java.io.Serializable;
import java.sql.Date;

public class Achieve implements Serializable {
	
	private Integer achiId;
	private String achiName;
	private String descript;
	private Date openDate;
	private Integer validDays;
	private Integer achiArticle;
	private Integer achiOrder;
	private Integer gainFeed;
	private Integer gainGold;
	private byte[] achiPic;
	
	public Achieve() {
	} 
	
	public Achieve(Integer achiId, String achiName, String descript, Date openDate, Integer validDays, Integer achiArticle,
			Integer achiOrder, Integer gainFeed, Integer gainGold, byte[] achiPic) {
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

	public Integer getAchiId() {
		return achiId;
	}

	public void setAchiId(Integer achiId) {
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

	public Integer getValidDays() {
		return validDays;
	}

	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}

	public Integer getAchiArticle() {
		return achiArticle;
	}

	public void setAchiArticle(Integer achiArticle) {
		this.achiArticle = achiArticle;
	}

	public Integer getAchiOrder() {
		return achiOrder;
	}

	public void setAchiOrder(Integer achiOrder) {
		this.achiOrder = achiOrder;
	}

	public Integer getGainFeed() {
		return gainFeed;
	}

	public void setGainFeed(Integer gainFeed) {
		this.gainFeed = gainFeed;
	}

	public Integer getGainGold() {
		return gainGold;
	}

	public void setGainGold(Integer gainGold) {
		this.gainGold = gainGold;
	}

	public byte[] getAchiPic() {
		return achiPic;
	}

	public void setAchiPic(byte[] achiPic) {
		this.achiPic = achiPic;
	}
	
}
