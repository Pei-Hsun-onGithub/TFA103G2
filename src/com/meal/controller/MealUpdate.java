package com.meal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class MealUpdate extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;

	public MealUpdate(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}

	@Override
	public void execute() throws ServletException, IOException {

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
				HttpSession session = req.getSession();
				restaurantId = (Integer) session.getAttribute("restaurantId");
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

			req.setAttribute("list", service.findMealByRestaurant(restaurantId));
			RequestDispatcher toListallView = req.getRequestDispatcher(this.forwardTo);
			toListallView.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}

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
