package com.memberinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Signout")
public class SignOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 登出後要移除session上的userId
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.removeAttribute("userId");
		
		RequestDispatcher toLoginLoginView = req.getRequestDispatcher("/login/Login-login.jsp");
		toLoginLoginView.forward(req, res);
	}
}