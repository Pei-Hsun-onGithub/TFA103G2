package com.restaurant.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.model.RestaurantService;
import com.restaurant.model.RestaurantVO;

public class RestUpdate extends Command{

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;
	

	public RestUpdate(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}
	
	@Override
	public void execute() throws ServletException, IOException {
	
		
		// 1. 擷取前端資料
		
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
		
		
		
		// 2. 與持久層溝通
		RestaurantService restSvc = new RestaurantService();
		HttpSession session = req.getSession();
		Integer usedRestaurantId = (Integer)session.getAttribute("restaurantId");
		RestaurantVO updatedRestVO = restSvc.updateRestaurant(usedRestaurantId, restaurantName, boss, phone, district, city, location, openTime, closeTime, dayoffId, weeklyLeave, sta);
		
//		System.out.println("restVO=" + restVO);
		
		// 擷取關聯類別RestaurantStyle所需的資料
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
	
		 
		
		
		
		// 3.1 轉送資料到關聯類別RestaurantStyle的controller來將資料入庫,由restaurantstyle的controller來forward到view
		
		req.setAttribute("updatedRestVO", updatedRestVO);
		
		req.setAttribute("action", "update");
		req.setAttribute("usedRestaurantId", usedRestaurantId);
		req.setAttribute("styleId1", styleId1);
		req.setAttribute("styleId2", styleId2);
		req.setAttribute("styleId3", styleId3);
		
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
				// 不營業
				weeklyLeaveBuilder.append("1");
			else
				//營業
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
