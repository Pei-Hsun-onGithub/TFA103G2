package com.message.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class MessageVO implements java.io.Serializable {
	private Integer msgNo;
	private Integer articleNo;
	private Integer userId;
	private Timestamp msgDate;
	private String msgContent;
	private Integer sta ;
	
	public MessageVO() {
		super();
	}
	
	public MessageVO(Integer msgNo, Integer articleNo,Integer userId, Timestamp msgDate, String msgContent, Integer sta) {
		super();
		this.msgNo = msgNo;
		this.articleNo = articleNo;
		this.userId = userId;
		this.msgDate = msgDate;
		this.msgContent = msgContent;
		this.sta = sta;
	}


	public Integer getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(Integer msgNo) {
		this.msgNo = msgNo;
	}

	public Integer getArticleNo() {
		return articleNo;
	}
	
	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Timestamp getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Timestamp msgDate) {
		this.msgDate = msgDate;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}

	@Override
	public String toString() {
		return "Message [msgNo=" + msgNo + ", articleNo=" + articleNo + ", msgDate=" + msgDate + ", msgContent="
				+ msgContent + ", sta=" + sta + "]";
	}
	
	
	
	
	
}
