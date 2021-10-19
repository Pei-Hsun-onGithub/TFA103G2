package com.restaurantstyle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.model.RestaurantVO;
import com.restaurantstyle.model.RestaurantStyleService;
import com.restaurantstyle.model.RestaurantStyleVO;

public class RestaurantStyleServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		
		
		if ("insert".equals(action)) {
			RestaurantStyleService restStyleSvc = new RestaurantStyleService();
			

			// 擷取來自其他Controller的資料
			Integer styleId1 = (Integer) req.getAttribute("styleId1");
			Integer styleId2 = (Integer) req.getAttribute("styleId2");
			Integer styleId3 = (Integer) req.getAttribute("styleId3");
			Integer restaurantId = (Integer) req.getAttribute("restaurantId");
			RestaurantVO restVO = (RestaurantVO) req.getAttribute("restVO");


			// 資料入庫
			if (styleId1 != null) {
				RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId1);
				session.setAttribute("style1", restStyleVO.getStyleId());

			}
			if (styleId2 != null) {
				RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId2);
				session.setAttribute("style2", restStyleVO.getStyleId());
			}
			if (styleId3 != null) {
				RestaurantStyleVO restStyleVO = restStyleSvc.addRestaurantStyle(restaurantId, styleId3);
				session.setAttribute("style3", restStyleVO.getStyleId());
			}

			// 包裝要keep住的資料傳回view還原已填寫的部分

			req.setAttribute("restVO", restVO);

			RequestDispatcher toView = req.getRequestDispatcher("/pei_pages/vendor_restaurant_updateInfo.jsp");
			toView.forward(req, res);

		}

		if ("update".equals(action)) {
			
			RestaurantStyleService restStyleSvc = new RestaurantStyleService();
			// 擷取來自其他Controller的資料
			Integer newStyleId1 = (Integer) req.getAttribute("styleId1");
			Integer newStyleId2 = (Integer) req.getAttribute("styleId2");
			Integer newStyleId3 = (Integer) req.getAttribute("styleId3");
			
			// session內的style資料用來作為更新頁面，keep住資料用!
			Integer oldStyleId1 = (Integer) session.getAttribute("style1");
			Integer oldStyleId2 = (Integer) session.getAttribute("style2");
			Integer oldStyleId3 = (Integer) session.getAttribute("style3");
			
			Integer usedRestaurantId = (Integer) req.getAttribute("usedRestaurantId");
			RestaurantVO restVO = (RestaurantVO) req.getAttribute("updatedRestVO");
			

			// 資料更新
			if(newStyleId1 != null ) {
				if(oldStyleId1 == null) {
					//沒有舊的style就新增一個
					RestaurantStyleVO updatedRestStyleVO = restStyleSvc.addRestaurantStyle(usedRestaurantId, newStyleId1);
					session.setAttribute("style1", updatedRestStyleVO.getStyleId());
				}
				else {
					//已經有style就更新一個
					RestaurantStyleVO updatedRestStyleVO = restStyleSvc.updateRestaurantStyle(usedRestaurantId, newStyleId1, usedRestaurantId, oldStyleId1);
					session.setAttribute("style1", updatedRestStyleVO.getStyleId());
				}
			} else { //newStyleId1 == null
				if(oldStyleId1 != null) {
					//將舊的刪除
					restStyleSvc.deleteRestaurantStyle(usedRestaurantId, oldStyleId1);
					session.removeAttribute("style1");
				}
			}
			
			
			if(newStyleId2 != null ) {
				if(oldStyleId2 == null) {
					RestaurantStyleVO updatedRestStyleVO = restStyleSvc.addRestaurantStyle(usedRestaurantId, newStyleId2);
					session.setAttribute("style2", updatedRestStyleVO.getStyleId());
				}
				
				else {
					RestaurantStyleVO updatedRestStyleVO = restStyleSvc.updateRestaurantStyle(usedRestaurantId, newStyleId2, usedRestaurantId, oldStyleId2);
					session.setAttribute("style2", updatedRestStyleVO.getStyleId());
				}
			} else { //newStyleId2 == null
				if(oldStyleId2 != null) {
					//將舊的刪除
					restStyleSvc.deleteRestaurantStyle(usedRestaurantId, oldStyleId2);
					session.removeAttribute("style2");
				}
			}
			
			
			
			if(newStyleId3 != null ) {
				if(oldStyleId3 == null) {
					RestaurantStyleVO updatedRestStyleVO = restStyleSvc.addRestaurantStyle(usedRestaurantId, newStyleId3);
					session.setAttribute("style3", updatedRestStyleVO.getStyleId());
				}
				else {
					RestaurantStyleVO updatedRestStyleVO = restStyleSvc.updateRestaurantStyle(usedRestaurantId, newStyleId3, usedRestaurantId, oldStyleId3);
					session.setAttribute("style3", updatedRestStyleVO.getStyleId());
				}
			} else { //newStyleId3 == null
				if(oldStyleId3 != null) {
					//將舊的刪除
					restStyleSvc.deleteRestaurantStyle(usedRestaurantId, oldStyleId3);
					session.removeAttribute("style3");
				}
			}
			

			// 包裝要keep住的資料傳回view還原已填寫的部分

			req.setAttribute("restVO", restVO);

			RequestDispatcher toView = req.getRequestDispatcher("/pei_pages/vendor_restaurant_updateInfo.jsp");
			toView.forward(req, res);
		}
	}
}
