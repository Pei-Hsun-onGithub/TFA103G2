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
			Integer styleId = (Integer) req.getAttribute("styleId");
			Integer restaurantId = (Integer) req.getAttribute("restaurantId");
			
			// 資料入庫
			RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId);
//			System.out.println("restStyleVO=" + restStyleVO);
		}
	}

}
