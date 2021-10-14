package com.restaurantstyle.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.restaurantstyle.model.RestaurantStyleService;
import com.restaurantstyle.model.RestaurantStyleVO;

public class RestaurantStyleServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		if ("insert".equals(action)) {
			RestaurantStyleService restStyleSvc = new RestaurantStyleService();
			
			// 擷取來自其他Controller的資料
			Integer styleId1 = (Integer) req.getAttribute("styleId1");
			Integer styleId2 = (Integer) req.getAttribute("styleId2");
			Integer styleId3 = (Integer) req.getAttribute("styleId3");
			Integer restaurantId = (Integer) req.getAttribute("restaurantId");
//			System.out.println("styleId1=" + styleId1);
//			System.out.println("styleId2=" + styleId2);
//			System.out.println("styleId3=" + styleId3);
			
			// 資料入庫
			if(styleId1 != null) {
				RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId1);
			}
			if(styleId2 != null) {
				RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId2);
			}
			if(styleId3 != null) {
				RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId3);
			}
			
			
//			System.out.println("restStyleVO=" + restStyleVO);
		}
	}

}
