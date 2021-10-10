package com.meal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class MealInsert extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;
	

	public MealInsert(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}
	
	@Override
	public void execute() throws ServletException, IOException {
		List<String> errMsgs = new LinkedList<String>();
		req.setAttribute("errMsgs", errMsgs);
		MealService service = new MealService();
		// 1. �������ơA���~��ƳB�z
		try {

			String mealName = req.getParameter("mealName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

			if (!mealName.trim().matches(enameReg)) {
				errMsgs.add("�п�J���T���^��P0~9���Ʀr");
			} else if (mealName == null || mealName.trim().length() == 0) {
				errMsgs.add("�п�J��ơA���n�ť�");
			}


			Integer sta = null;
			try {
				sta = new Integer(req.getParameter("sta").trim());
			} catch (NumberFormatException e) {
				errMsgs.add("���A�п�J�Ʀr");
			}
			String mealType = req.getParameter("mealType");

			Integer unitPrice = null;
			try {
				unitPrice = new Integer(req.getParameter("unitPrice"));
			} catch (NumberFormatException e) {
				unitPrice = new Integer("0");
				errMsgs.add("����п�J�Ʀr");
			}

			Timestamp launchDate = java.sql.Timestamp.valueOf(req.getParameter("launchDate"));

			Integer launchDays = null;
			try {
				launchDays = new Integer(req.getParameter("launchDays"));
			} catch (NumberFormatException e) {
				launchDays = new Integer("30");
				errMsgs.add("�Ѽƽп�J�Ʀr");
			}

			String mealDescription = req.getParameter("mealDescription");

			Integer restaurantId = null;
			try {
				restaurantId = new Integer(req.getParameter("restaurantId"));
			} catch (NumberFormatException e) {
				errMsgs.add("�\�U�s���п�J�Ʀr");
			}

			// �Ϥ��W��
			byte[] mealImg = null;
			Part part = req.getPart("myUploadImg");
			if (part.getSize() > 0) {
				InputStream in = part.getInputStream();
				mealImg = new byte[in.available()];
				in.read(mealImg);
				in.close();

			}
			
			
			if (!errMsgs.isEmpty()) {
				
				MealVO errMealVO = new MealVO();
				errMealVO.setMealName(mealName);
				errMealVO.setSta(sta);
				errMealVO.setUnitPrice(unitPrice);
				errMealVO.setLaunchDate(launchDate);
				errMealVO.setLaunchDays(launchDays);
				errMealVO.setRestaurantId(restaurantId);
				errMealVO.setMealImg(mealImg);
				errMealVO.setMealDescription(mealDescription);
				
				RequestDispatcher failureView = req.getRequestDispatcher(this.ErrorTo);
				req.setAttribute("UpdatingMealVO", errMealVO);
				failureView.forward(req, res);
				return;// �{�����_
			}
			
			

			// 2. ���[��
			MealVO mealVO = service.addMeal(sta, mealName, mealType, unitPrice, launchDate, launchDays,
					mealDescription, mealImg, restaurantId);

			// 3. ���ܮi�ܼh
			req.setAttribute("mealVO", mealVO);
			RequestDispatcher toListOneView = req.getRequestDispatcher(this.forwardTo);
			toListOneView.forward(req, res);

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
