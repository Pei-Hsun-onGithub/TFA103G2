package com.meal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class PhotoServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/png");
		
		Integer mealId = new Integer(req.getParameter("id"));
		System.out.println("mealId=" + mealId);
		MealService mealSvc = new MealService();
		MealVO mealVO = mealSvc.findMealByPrimaryKey(mealId);
		res.getOutputStream().write(mealVO.getMealImg());
	}
}