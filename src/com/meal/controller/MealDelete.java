package com.meal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// 1. ��������e�Ӫ�PK��

		Integer mealid = new Integer(req.getParameter("mealId"));
		

		// 2.�U�[��Ʈw�ɮ�
		service.changeMealStateAsOffShelf(mealid);
		

		// 3.�i�ܼh�ϬM���G
	
		HttpSession session = req.getSession();
		Integer restaurantId = (Integer) session.getAttribute("restaurantId");
		req.setAttribute("list", service.findMealByRestaurant(restaurantId));
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
