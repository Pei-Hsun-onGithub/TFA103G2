package com.meal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;

@WebServlet("/Mealsingle")
public class MealSingle extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

//		PrintWriter out = res.getWriter();

		Integer mealId = new Integer(req.getParameter("mealId"));

		MealService MealSvc = new MealService();
		MealVO MealVo = MealSvc.findMealByPrimaryKey(mealId);
		
		List<MealVO> mealList = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			MealVO vo = new MealVO();
			vo = MealSvc.findMealByPrimaryKey(mealId+i);
			if (vo != null) {
				mealList.add(vo);
			} else{
				vo = MealSvc.findMealByPrimaryKey(mealId-3);
				mealList.add(vo);
			}
			
		}
		

		req.setAttribute("MealVO", MealVo); // 資料庫update成功後,正確的的empVO物件,存入req
		req.setAttribute("mealList", mealList); // 資料庫update成功後,正確的的empVO物件,存入req
		
		String url = "/meal/Meal-single.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
		successView.forward(req, res);
		return;	
		
	}
}