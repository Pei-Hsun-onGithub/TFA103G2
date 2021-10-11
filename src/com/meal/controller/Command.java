package com.meal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {


	public static Command createCommand(String action, HttpServletRequest req, HttpServletResponse res) {

		// register here!!
		
		if ("getAll".equals(action)) {
			return new MealGetAll(req, res);
		}
		if ("getOne_For_Display".equals(action)) {
			return new MealGetOne(req, res);
		}
		if ("insert".equals(action)) {
			return new MealInsert(req, res);
		}
		if ("getOne_For_Update".equals(action)) {
			return new MealGetOneForUpdate(req, res);
		}
		if ("update".equals(action)) {
			return new MealUpdate(req, res);
		}
		if ("delete".equals(action)) {
			return new MealDelete(req, res);
		}
		 
		return null;
	}

	public abstract void execute() throws ServletException, IOException;
	public abstract void setForwardURL(String url);
	public abstract void setErrorURL(String url);

	
}
