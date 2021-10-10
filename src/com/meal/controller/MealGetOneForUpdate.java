package com.meal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class MealGetOneForUpdate extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;

	public MealGetOneForUpdate(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}

	@Override
	public void execute() throws ServletException, IOException {
		// 1. 抓取頁面送來的PK值
		Integer mealid = new Integer(req.getParameter("mealId"));

		MealService service = new MealService();
		MealVO mealVO = service.findMealByPrimaryKey(mealid);

		req.setAttribute("UpdatingMealVO", mealVO);
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
