package com.orderlist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;

public class MemberOrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getAllOrderList".equals(action)) {


			// List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			// req.setAttribute("errorMsgs", errorMsgs);
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo member = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", member);
			String url = "/Gary_pages/Member05.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
	}
}
