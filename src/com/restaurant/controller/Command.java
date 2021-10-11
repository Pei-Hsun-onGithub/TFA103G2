package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {

	public static Command createCommand(String action, HttpServletRequest req, HttpServletResponse res) {

		// register here!!
		if ("insert".equals(action)) {
			return new RestInsert(req, res);
		}

		return null;
	}

	public abstract void execute() throws ServletException, IOException;

	public abstract void setForwardURL(String url);

	public abstract void setErrorURL(String url);

}
