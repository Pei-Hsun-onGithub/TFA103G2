package com.message.model;

import java.util.List;


public interface MessageDAO_interface {
	public void add(MessageVO message);
	public void update(MessageVO message);
	public void delete(Integer msgNo);
	List<MessageVO> findByFK(Integer articleNo);
	List<MessageVO> getall();
}
