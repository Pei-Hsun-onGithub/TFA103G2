package com.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.model.RestaurantService;
import com.restaurant.model.RestaurantVO;
import com.restaurantstyle.model.RestaurantStyleService;
import com.restaurantstyle.model.RestaurantStyleVO;
import com.style.model.StyleService;

public class RestInsert extends Command {


	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;
	

	public RestInsert(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}
	@Override
	public void execute() throws ServletException, IOException {
		
		RestaurantService restSvc = new RestaurantService();
		
		// 1. �^���e�ݸ��
		
		String restaurantName = req.getParameter("restaurantName");
//		System.out.println("restaurantName=" + restaurantName);
		
		
		java.sql.Time openTime = transformTimeAsSqlTimeFormat(req.getParameter("openTime"));
//		System.out.println("openTime=" + openTime);
		
		java.sql.Time closeTime = transformTimeAsSqlTimeFormat(req.getParameter("closeTime"));
//		System.out.println("closeTime=" + closeTime);
		
		/**********  WeeklyLeave  ***********/
		
		// checked = on ; unchecked = null
		List<String> days = new ArrayList<>();
		days.add(req.getParameter("Mon"));
		days.add(req.getParameter("Tue"));
		days.add(req.getParameter("Wed"));
		days.add(req.getParameter("Thu"));
		days.add(req.getParameter("Fri"));
		days.add(req.getParameter("Sat"));
		days.add(req.getParameter("Sun"));
		
		String weeklyLeave = getWeeklyLeaveFrom(days);
//		System.out.println("weeklyLeave=" + weeklyLeave);
		
		Integer dayoffId = new Integer(req.getParameter("dayoffId"));
		String district = req.getParameter("district");
		String city = req.getParameter("city");
		String location = req.getParameter("location");
		String boss = req.getParameter("boss");
		String phone = req.getParameter("phone");
		Integer sta = new Integer(req.getParameter("sta"));
		
		
		
		// 2. �P���[�h���q
		
		RestaurantVO restVO = restSvc.addRestaurant(restaurantName, boss, phone, district, city, location, openTime, closeTime, dayoffId, weeklyLeave, sta);
//		System.out.println("restVO=" + restVO);
		
		// �^�����p���ORestaurantStyle�һݪ����
//		Integer styleId = new Integer(req.getParameter("restaurantStyle"));
		Integer styleId1 = null;
		Integer styleId2 = null;
		Integer styleId3 = null;
		
		if(!req.getParameter("style1").equals("")) {
			 styleId1 = new Integer(req.getParameter("style1"));			
		}
		if(!req.getParameter("style2").equals("")) {
			styleId2 = new Integer(req.getParameter("style2"));			
		}
		if(!req.getParameter("style3").equals("")) {
			styleId3 = new Integer(req.getParameter("style3"));			
		}
	
		Integer restaurantId = restVO.getRestaurantId();
		
		
		
		// 3.1 ��e��ƨ����p���ORestaurantStyle��controller�ӱN��ƤJ�w,��restaurantstyle��controller��forward��view
		
		req.setAttribute("restVO", restVO);
		
		req.setAttribute("action", "insert");
		req.setAttribute("restaurantId", restaurantId);
		req.setAttribute("styleId1", styleId1);
		req.setAttribute("styleId2", styleId2);
		req.setAttribute("styleId3", styleId3);
		
		HttpSession session = req.getSession();
		// �O�s�s�W���\���\�U�s��
		session.setAttribute("restaurantId", restaurantId);
		
		
		RequestDispatcher toRestStyleServlet = req.getRequestDispatcher("/restaurantstyle/restaurantstyle.do");
		toRestStyleServlet.forward(req, res);
		
		
		
		
	}
	
	
	
	
	private java.sql.Time transformTimeAsSqlTimeFormat(String time) {
		return java.sql.Time.valueOf(new StringBuffer(time).append(":00").toString());
	}
	
	private String getWeeklyLeaveFrom(List<String> days) {
		
		StringBuffer weeklyLeaveBuilder = new StringBuffer();
		for(String day : days) {
			if("on".equals(day)) 
				// ����~
				weeklyLeaveBuilder.append("1");
			else
				//��~
				weeklyLeaveBuilder.append("0");
		}
		return weeklyLeaveBuilder.toString();
	}

	@Override
	public void setForwardURL(String url) {
		this.forwardTo = url;
		
	}

	@Override
	public void setErrorURL(String url) {
		this.ErrorTo = url;
		
	}

}
