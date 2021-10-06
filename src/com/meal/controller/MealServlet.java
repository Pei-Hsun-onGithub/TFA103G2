package com.meal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.meal.model.MealService;
import com.meal.model.MealVO;

@MultipartConfig
public class MealServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		/************* 取得前端的action以進行轉接 ***********************/

		String action = req.getParameter("action");

		/******************* 查詢全部 ******************/

		if ("getAll".equals(action)) {

			MealService service = new MealService();
			List<MealVO> list = service.getAll();
			req.setAttribute("list", list);

			RequestDispatcher toView = req.getRequestDispatcher("/pei_pages/listAllMeal.jsp");
			toView.forward(req, res);
			return;
		}

		/******************* 新增一筆資料 ******************/

		if ("insert".equals(action)) {

			Map<String, String> errMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errMsgs", errMsgs);
			MealService service = new MealService();
			// 1. 抓取表單資料，錯誤資料處理
			try {

				String mealName = req.getParameter("mealName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (!mealName.trim().matches(enameReg)) {
					errMsgs.put(mealName, "請輸入正確中英文與0~9的數字");
				} else if (mealName.trim().length() == 0) {
					errMsgs.put(mealName, "請輸入資料，不要空白");
				}
				
				if(!errMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/addOneMeal.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer sta = null;
				try {
					sta = new Integer(req.getParameter("sta"));
				} catch (NumberFormatException e) {
					errMsgs.put("sta", "狀態請輸入數字");
				}
				String mealType = req.getParameter("mealType");

				Integer unitPrice = null;
				try {
					unitPrice = new Integer(req.getParameter("unitPrice"));
				} catch (NumberFormatException e) {
					errMsgs.put("unitPrice", "單價請輸入數字");
				}

				Timestamp launchDate = java.sql.Timestamp.valueOf(req.getParameter("launchDate"));

				Integer launchDays = null;
				try {
					launchDays = new Integer(req.getParameter("launchDays"));
				} catch (NumberFormatException e) {
					errMsgs.put("launchDays", "天數請輸入數字");
				}

				String mealDescription = req.getParameter("mealDescription");

				Integer restaurantId = null;
				try {
					restaurantId = new Integer(req.getParameter("restaurantId"));
				} catch (NumberFormatException e) {
					errMsgs.put("restaurantId", "餐廳編號請輸入數字");
				}

				// 圖片上傳
				byte[] mealImg = null;
				Part part = req.getPart("myUploadImg");
				if (part.getSize() > 0) {
					InputStream in = part.getInputStream();
					mealImg = new byte[in.available()];
					in.read(mealImg);
					in.close();

				}
			

				// 2. 持久化
				MealVO mealVO = service.addMeal(sta, mealName, mealType, unitPrice, launchDate, launchDays,
						mealDescription, mealImg, restaurantId);

				// 3. 轉交至展示層
				req.setAttribute("mealVO", mealVO);
				RequestDispatcher toListOneView = req.getRequestDispatcher("/pei_pages/listOneMeal.jsp");
				toListOneView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/************************* 修改一筆資料 **************************************/

		if ("getOne_For_Update".equals(action)) {

			// 1. 抓取頁面送來的PK值
			Integer mealid = new Integer(req.getParameter("mealId"));

			MealService service = new MealService();
			MealVO mealVO = service.findMealByPrimaryKey(mealid);

			req.setAttribute("UpdatingMealVO", mealVO);
			RequestDispatcher toListOneView = req.getRequestDispatcher("/pei_pages/updateOneMeal.jsp");
			toListOneView.forward(req, res);

		}

		/************************ 更新一筆資料 *********************************************/

		if ("update".equals(action)) {

			MealService service = new MealService();
			// 1. 抓取頁面送來的PK值

			Integer mealid = new Integer(req.getParameter("mealId"));

			Map<String, String> errMsgs = new LinkedHashMap<String, String>();

			// 1. 抓取表單資料，錯誤資料處理
			try {

				String mealName = req.getParameter("mealName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (!mealName.trim().matches(enameReg)) {
					errMsgs.put(mealName, "請輸入正確中英文與0~9的數字");
				} else if (mealName.trim().length() == 0) {
					errMsgs.put(mealName, "請輸入資料，不要空白");
				}
				Integer sta = null;
				try {
					sta = new Integer(req.getParameter("sta"));
				} catch (NumberFormatException e) {
					errMsgs.put("sta", "狀態請輸入數字");
				}
				String mealType = req.getParameter("mealType");

				Integer unitPrice = null;
				try {
					unitPrice = new Integer(req.getParameter("unitPrice"));
				} catch (NumberFormatException e) {
					errMsgs.put("unitPrice", "單價請輸入數字");
				}

				Timestamp launchDate = java.sql.Timestamp.valueOf(req.getParameter("launchDate"));

				Integer launchDays = null;
				try {
					launchDays = new Integer(req.getParameter("launchDays"));
				} catch (NumberFormatException e) {
					errMsgs.put("launchDays", "天數請輸入數字");
				}

				String mealDescription = req.getParameter("mealDescription");

				Integer restaurantId = null;
				try {
					restaurantId = new Integer(req.getParameter("restaurantId"));
				} catch (NumberFormatException e) {
					errMsgs.put("restaurantId", "餐廳編號請輸入數字");
				}

				// 圖片上傳
				byte[] mealImg = null;

				Part part = req.getPart("myUploadImg");
				if (part.getSize() > 0) {
					InputStream in = part.getInputStream();
					mealImg = new byte[in.available()];
					in.read(mealImg);
					in.close();
				}

				// 2. 持久化
				MealVO mealVO = service.updateMeal(mealid, sta, mealName, mealType, unitPrice, launchDate, launchDays,
						mealDescription, mealImg, restaurantId);

				// 3. 轉交至展示層

				req.setAttribute("list", service.getAll());
				RequestDispatcher toListallView = req.getRequestDispatcher("/pei_pages/listAllMeal.jsp");
				toListallView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		/************************ 刪除一筆資料 *********************************************/
		
		if("delete".equals(action)) {
			MealService service = new MealService();
			// 1. 抓取頁面送來的PK值

			Integer mealid = new Integer(req.getParameter("mealId"));
			
			// 2.刪除資料庫檔案
			service.deleteMeal(mealid);
			
			// 3.展示層反映結果
			
			req.setAttribute("list", service.getAll());
			RequestDispatcher toListallView = req.getRequestDispatcher("/pei_pages/listAllMeal.jsp");
			toListallView.forward(req, res);
		}

	}
}
