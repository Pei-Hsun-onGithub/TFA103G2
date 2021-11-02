package com.orderlist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orderlist.model.OrderListVO;
import com.rsorder.model.RsOrderDAOService;
import com.rsorder.model.RsOrderVO;


@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println(action);
		
		if ("insert".equals(action)) { 
			System.out.println("裡面");
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				
				
/***********************RsOder*************************/
				HttpSession session = req.getSession();
				Integer userId = (Integer) session.getAttribute("userId");
//				Integer userId = new Integer(req.getParameter("userId"));
System.out.println("1.userId="+userId);
				
				String delivery = req.getParameter("deliveryAddId");
				Integer deliveryAddId = null;
				if (delivery == null || (delivery.length())==0) {
					errorMsgs.add("請選擇地址");
System.out.println("2.delivery="+delivery);
				}else {
					deliveryAddId = new Integer(delivery);
System.out.println("3.delivery="+delivery);
				}
				
				String card = req.getParameter("cardId");
				Integer cardId = null;
				if (card == null) {
					errorMsgs.add("請選擇信用卡");
System.out.println("4.cardId="+cardId);
				}else {
					cardId = new Integer(card);
System.out.println("5.cardId="+cardId);
				}

				RsOrderVO rsOrderVO = new RsOrderVO();
				rsOrderVO.setUserId(userId);
				rsOrderVO.setDeliveryAddId(deliveryAddId);
				rsOrderVO.setCardId(cardId);
				System.out.println("5.rsOrderVO="+rsOrderVO.toString());

/***********************RsOder*************************/	
				
				Vector<Cart> buylist = (Vector<Cart>) session.getAttribute("shoppingcart");
				
				OrderListVO orderListVO = null;
				List<OrderListVO> orList = new ArrayList<OrderListVO>() ;
				
				
				for (int index = 0; index < buylist.size(); index++) {
						Cart order = buylist.get(index);
						orderListVO = new OrderListVO();
						orderListVO.setMealId(order.getMealId());
						orderListVO.setQuantity(order.getQuantity());
						orderListVO.setUnitPrice(order.getUnitPrice());
						orList.add(orderListVO);
						
				}


				if (!errorMsgs.isEmpty()) {

					req.setAttribute("rsOrderVO", rsOrderVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/meal/Checkout.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				RsOrderDAOService rsorderSvc = new RsOrderDAOService();
				
				rsorderSvc.insertWithOl(rsOrderVO, orList);
				
				

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("rsOrderVO", rsOrderVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/home.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
				return;

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				e.printStackTrace();
			}
			RequestDispatcher failureView = req.getRequestDispatcher("/meal/Checkout.jsp");
			failureView.forward(req, res);
		}
	
		
	}
}
