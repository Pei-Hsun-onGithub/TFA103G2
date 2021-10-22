package com.message.model;

import java.sql.Date;

public class TestMsg {
	
	public static void main(String[] args) {
		MessageDAO_interface dao = new MessageJDBCDAO();
		
		MessageVO msg = new MessageVO();				
		
		//新增
		
		msg.setArticleNo(2);		
		msg.setUserId(20210002);
		msg.setMsgContent("去冰要加錢,不推");
		msg.setSta(1);
		dao.add(msg);
		
	}

}
