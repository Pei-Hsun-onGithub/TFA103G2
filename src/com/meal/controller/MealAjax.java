package com.meal.controller;

import java.io.IOException;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.orderlist.controller.Cart;


@WebServlet("/MealAjax")
public class MealAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		Integer mealId = new Integer(req.getParameter("mealId"));
        String quantity = req.getParameter("count");
        System.out.println("mealId=		" + mealId );
        System.out.println("quantity=	" + quantity);
		
        
		@SuppressWarnings("unchecked")
		List<Cart> buylist = (Vector<Cart>) session.getAttribute("shoppingcart");
System.out.println("buylist=="+buylist.size());
		
			for (int i = 0; i < buylist.size(); i++) {
				Cart order = buylist.get(i);
				Integer mealId2 = order.getMealId();
				if(mealId2.equals(mealId)) {
					order.setQuantity((new Integer(quantity)).intValue()); 
System.out.println(order.getQuantity());
					session.setAttribute("shoppingcart", buylist);
				}	
			}
		
//		if (action.equals("CHECKOUT")) {
//		String url = "/meal/Checkout.jsp";
//		RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//		successView.forward(req, res);
		
		
		}
	
}
