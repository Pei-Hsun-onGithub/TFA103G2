package com.message.model;

import java.sql.Date;
import java.util.List;

import com.foodarticle.model.FoodArticleVO;

public class MessageService {
	private MessageDAO_interface dao;
	
	public MessageService () {
		dao = new MessageJDBCDAO();
	}
	
	public MessageVO addMessage(Integer articleNo,Integer userId, Date msgDate, String msgContent, Integer sta) {
		MessageVO messageVO = new MessageVO();
		
		messageVO.setArticleNo(articleNo);
		messageVO.setMsgDate(msgDate);
		messageVO.setMsgContent(msgContent);
		messageVO.setSta(sta);
		dao.add(messageVO);
		
		return messageVO;
	}
	
	public MessageVO updateMessage(Integer msgNo, Date msgDate, String msgContent, Integer sta) {
		MessageVO messageVO = new MessageVO();
		
		messageVO.setMsgNo(msgNo);
		messageVO.setMsgDate(msgDate);
		messageVO.setMsgContent(msgContent);
		messageVO.setSta(sta);
		
		return messageVO;
	}
	
	public void deleteMessage(Integer msgNo) {
		dao.delete(msgNo);	
	}
	
	public MessageVO getMsgsOfAr(Integer articleNo) {
		MessageVO messageVO = new MessageVO();
		
		return dao.findByFK(articleNo);
	}
	
	public List<MessageVO> getall(){
		return dao.getall();
	}
	
	

}
