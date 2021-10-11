package com.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.model.RestaurantService;
import com.restaurant.model.RestaurantVO;

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
		
		// 1. 擷取前端資料
		
		String restaurantName = req.getParameter("restaurantName");
//		System.out.println("restaurantName=" + restaurantName);
		
		
		java.sql.Time openTime = java.sql.Time.valueOf(new StringBuffer(req.getParameter("openTime")).append(":00").toString());
//		System.out.println("openTime=" + openTime);
		
		java.sql.Time closeTime = java.sql.Time.valueOf(new StringBuffer(req.getParameter("closeTime")).append(":00").toString());
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
		
		StringBuffer weeklyLeaveBuilder = new StringBuffer();
		for(String day : days) {
			if("on".equals(day)) 
				// 不營業
				weeklyLeaveBuilder.append("1");
			else
				//營業
				weeklyLeaveBuilder.append("0");
		}
		String weeklyLeave = weeklyLeaveBuilder.toString();
//		System.out.println("weeklyLeave=" + weeklyLeave);
		
		Integer dayoffId = new Integer(req.getParameter("dayoffId"));
		String district = req.getParameter("district");
		String city = req.getParameter("city");
		String location = req.getParameter("location");
		String boss = req.getParameter("boss");
		String phone = req.getParameter("phone");
		Integer sta = new Integer(req.getParameter("sta"));
		
		
		// 2. 與持久層溝通
		
		RestaurantVO restVO = restSvc.addRestaurant(restaurantName, boss, phone, district, city, location, openTime, closeTime, dayoffId, weeklyLeave, sta);
//		System.out.println("restVO=" + restVO);
		
		// 3. 轉送頁面
		
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
