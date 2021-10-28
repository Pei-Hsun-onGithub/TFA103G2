package com.orderlist.controller;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.orderlist.controller.Cart;

@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		
		@SuppressWarnings("unchecked")
		List<Cart> buylist = (Vector<Cart>) session.getAttribute("shoppingcart");
		String action = req.getParameter("action");

		if (!action.equals("CHECKOUT")) {

			// 刪除購物車中的書籍
			if (action.equals("DELETE")) {
				String del = req.getParameter("del");
				int d = Integer.parseInt(del);
				buylist.remove(d);
			}
			// 新增書籍至購物車中
			else if (action.equals("ADD")) {
				// 取得後來新增的書籍
				Cart acart = getCart(req);

				if (buylist == null) {
					buylist = new Vector<Cart>();
					buylist.add(acart);
				} else {
					if (buylist.contains(acart)) {
						Cart innerCart = buylist.get(buylist.indexOf(acart));
						innerCart.setQuantity(innerCart.getQuantity() + acart.getQuantity());
					} else {
						buylist.add(acart);
						
					}
				}
			}
			session.setAttribute("shoppingcart", buylist);
			String url = "/meal/Cart.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
			
		}

		// 結帳，計算購物車書籍價錢總數
		else if (action.equals("CHECKOUT")) {
			double total = 0;
			for (int i = 0; i < buylist.size(); i++) {
				Cart order = buylist.get(i);
				Integer unitPrice = order.getUnitPrice();
				Integer quantity = order.getQuantity();
				total += (unitPrice * quantity);
			}

			String amount = String.valueOf(total);
			req.setAttribute("amount", amount);
			String url = "/meal/checkout.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
	}

	private Cart getCart(HttpServletRequest req) {

		String mealId = req.getParameter("mealId");
		String mealName = req.getParameter("mealName");		
		String unitPrice = req.getParameter("unitPrice");
		String quantity = req.getParameter("quantity");

		Cart cart = new Cart();

		cart.setMealId(mealId);
		cart.setMealName(mealName);
		cart.setUnitPrice((new Integer(unitPrice)).intValue());
		cart.setQuantity((new Integer(quantity)).intValue());
		return cart;
	}
}