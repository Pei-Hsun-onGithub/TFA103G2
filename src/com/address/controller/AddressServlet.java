package com.address.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.address.model.*;

public class AddressServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("deliveryAddId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入外送地址編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer deliveryAddId = null;
				try {
					deliveryAddId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("外送地址編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(deliveryAddId);
				if (addressVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("addressVO", addressVO); // 資料庫取出的addressVO物件,存入req
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAddress.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllAddress.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId"));
				
				/***************************2.開始查詢資料****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(deliveryAddId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("addressVO", addressVO);         // 資料庫取出的addressVO物件,存入req
				String url = "/address/update_address_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_address_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // 來自update_address_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
				
//				String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
				
				String job = req.getParameter("job").trim();
				if (job == null || job.trim().length() == 0) {
					errorMsgs.add("職位請勿空白");
				}	
				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}

				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("薪水請填數字.");
				}

				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("獎金請填數字.");
				}

				Integer deptno = new Integer(req.getParameter("deptno").trim());

				AddressVO addressVO = new AddressVO();
				addressVO.setAddressno(addressno);
				addressVO.setEname(ename);
				addressVO.setJob(job);
				addressVO.setHiredate(hiredate);
				addressVO.setSal(sal);
				addressVO.setComm(comm);
				addressVO.setDeptno(deptno);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isAddressty()) {
					req.setAttribute("addressVO", addressVO); // 含有輸入格式錯誤的addressVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/address/update_address_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.updateAddress(addressno, ename, job, hiredate, sal,comm, deptno);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("addressVO", addressVO); // 資料庫update成功後,正確的的addressVO物件,存入req
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneAddress.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/update_address_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addAddress.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String ename = req.getParameter("ename");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (ename == null || ename.trim().length() == 0) {
					errorMsgs.add("員工姓名: 請勿空白");
				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String job = req.getParameter("job").trim();
				if (job == null || job.trim().length() == 0) {
					errorMsgs.add("職位請勿空白");
				}
				
				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("薪水請填數字.");
				}
				
				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("獎金請填數字.");
				}
				
				Integer deptno = new Integer(req.getParameter("deptno").trim());

				AddressVO addressVO = new AddressVO();
				addressVO.setEname(ename);
				addressVO.setJob(job);
				addressVO.setHiredate(hiredate);
				addressVO.setSal(sal);
				addressVO.setComm(comm);
				addressVO.setDeptno(deptno);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isAddressty()) {
					req.setAttribute("addressVO", addressVO); // 含有輸入格式錯誤的addressVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/address/addAddress.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.addAddress(ename, job, hiredate, sal, comm, deptno);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAddress.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/addAddress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllAddress.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer addressno = new Integer(req.getParameter("addressno"));
				
				/***************************2.開始刪除資料***************************************/
				AddressService addressSvc = new AddressService();
				addressSvc.deleteAddress(addressno);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
