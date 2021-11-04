package com.rsorder.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.card.model.CardDAOService;
import com.card.model.CardVO;
import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.orderlist.model.OrderListDAOService;
import com.orderlist.model.OrderListVO;
import com.rsorder.model.RsOrderDAOService;
import com.rsorder.model.RsOrderVO;

import java.util.*;

@MultipartConfig

public class MemberHistoryOrderServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		System.out.println("action="+ action);
		
		
		if ("getAllOrderList".equals(action)) {
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo mem = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", mem);
			Integer member = mem.getUserId();
			RsOrderDAOService rsOrderSvc = new RsOrderDAOService();
			Set<RsOrderVO> rsorderset = rsOrderSvc.getRsOrderByUserId(member);
			req.setAttribute("rsorderset", rsorderset);
			String url = "/Gary_pages/Member05.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if("getOneOrderList".equals(action)) {
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo member = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", member);
			
			Integer orderid = new Integer(req.getParameter("orderId"));
			OrderListDAOService orderlistSvc = new OrderListDAOService();
			RsOrderDAOService rsorderSvc = new RsOrderDAOService();
			RsOrderVO rsordervo = rsorderSvc.getCardVAO(orderid);
			Set<OrderListVO> orderlistset = orderlistSvc.getAllOrderListByOrderId(orderid);
			req.setAttribute("orderlistset", orderlistset);
			req.setAttribute("rsordervo",rsordervo);
			
			
			String url = "/Gary_pages/Member05-showdetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
		
	}
}
