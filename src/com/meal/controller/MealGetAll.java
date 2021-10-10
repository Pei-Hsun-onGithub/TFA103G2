package com.meal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class MealGetAll extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;
	
	public MealGetAll(HttpServletRequest req, HttpServletResponse res){
		
		this.req = req;
		this.res = res;
	}
	
	@Override
	public void execute() throws ServletException, IOException {
		
		MealService service = new MealService();
		List<MealVO> list = service.getAll();
		req.setAttribute("list", list);

		RequestDispatcher toView = req.getRequestDispatcher(this.forwardTo);
	
		toView.forward(req, res);
		
		return;
		
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
