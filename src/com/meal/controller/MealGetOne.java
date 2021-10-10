package com.meal.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class MealGetOne extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;

	public MealGetOne(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}

	@Override
	public void execute() throws ServletException, IOException {

		List<String> errMsgs = new LinkedList<String>();
		req.setAttribute("errMsgs", errMsgs);

		Integer mealid = null;
		try {
			mealid = new Integer(req.getParameter("mealId"));
		} catch (NumberFormatException e) {
			errMsgs.add("餐點編號必須是數字，例如 : 502");
		}
		if (!errMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher(this.ErrorTo);
			failureView.forward(req, res);
			return;// 程式中斷
		}

		MealService service = new MealService();
		MealVO mealVO = service.findMealByPrimaryKey(mealid);
		if (mealVO == null) {

			errMsgs.add("查無此資料!");
			RequestDispatcher failureView = req.getRequestDispatcher(this.ErrorTo);
			failureView.forward(req, res);
			return;
		}

		req.setAttribute("mealVO", mealVO);
		RequestDispatcher toListOneView = req.getRequestDispatcher(this.forwardTo);
		toListOneView.forward(req, res);

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
