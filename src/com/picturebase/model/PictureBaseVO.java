package com.picturebase.model;

import java.sql.Date;
import java.util.Arrays;

public class PictureBaseVO implements java.io.Serializable {
	
	private Integer picNo;
	private Integer articleNo;
	private byte[]  pic;
	
	public PictureBaseVO() {
		super();
	}
	
	public PictureBaseVO(Integer picNo, Integer articleNo, byte[]  pic ) {
		super();
		this.picNo = picNo;
		this.articleNo = articleNo;
		this.pic = pic;
		
	}
	
	
	public Integer getPicNo() {
		return picNo;
	}
	public void setPicNo(Integer picNo) {
		this.picNo = picNo;
	}
	public Integer getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
	public  byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic){
		this.pic =  pic;
	}

	@Override
	public String toString() {
		return "PictureBase [picNo=" + picNo + ", articleNo=" + articleNo + ", pic=" + pic + "]";
	}

}
