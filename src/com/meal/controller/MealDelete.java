package com.meal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;

public class MealDelete extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;

	public MealDelete(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}
	@Override
	public void execute() throws ServletException, IOException {
		MealService service = new MealService();
		// 1. 抓取頁面送來的PK值

		Integer mealid = new Integer(req.getParameter("mealId"));

		// 2.刪除資料庫檔案
		service.deleteMeal(mealid);

		// 3.展示層反映結果

		req.setAttribute("list", service.getAll());
		RequestDispatcher toListallView = req.getRequestDispatcher(this.forwardTo);
		toListallView.forward(req, res);
		
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
