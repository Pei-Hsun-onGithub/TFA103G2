package com.meal.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealDAO_interface;
import com.meal.model.MealJDBCDAO;
import com.meal.model.MealVO;

public class MealServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		doPost(req, res);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
			
		req.setCharacterEncoding("UTF-8");
		
		/*************  取得前端的action以進行轉接    ***********************/
		
		String action = req.getParameter("action");
		
		/*******************  查詢全部       ******************/
		
		if("getAll".equals(action)) {
			
			MealDAO_interface mealDAO = new MealJDBCDAO();
			List<MealVO> list = mealDAO.getAll();
			req.setAttribute("list", list);
			
			RequestDispatcher toView =  req.getRequestDispatcher("/pei_pages/listAll.jsp");
			toView.forward(req, res);
			return;
		}
			
		
	}
}
