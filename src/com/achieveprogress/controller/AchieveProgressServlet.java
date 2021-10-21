package com.achieveprogress.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.achieveprogress.model.*;

public class AchieveProgressServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			System.out.println("hello");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str1 = req.getParameter("userid");
				System.out.println("userid=" + str1);
				if (str1 == null || (str1.trim()).length() == 0) {
					errorMsgs.add("請輸入會員編號");
				}
				String str2 = req.getParameter("achiid");
				System.out.println("userid=" + str2);
				if (str2 == null || (str2.trim()).length() == 0) {
					errorMsgs.add("請輸入成就編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer userId = null;
				Integer achiId = null;
				try {
					userId = new Integer(str1);
					achiId = new Integer(str2);
				} catch (Exception e) {
					errorMsgs.add("格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				AchieveProgress achieveprogress = achieveprogressSvc.getOneAchieveProgress(userId, achiId);
				if (achieveprogress == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("achieveprogress", achieveprogress); // 資料庫取出的AchieveProgressVO物件,存入req
				String url = "/Gary_pages/listOneAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAchieveProgress.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllAchieveProgress.jsp的請求
			System.out.println("hello");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer userId = new Integer(req.getParameter("userid"));
				System.out.println("userId"+userId);
				Integer achiId = new Integer(req.getParameter("achiid"));
				System.out.println("achiid"+achiId);
				/***************************2.開始查詢資料****************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				AchieveProgress achieveprogress = achieveprogressSvc.getOneAchieveProgress(userId, achiId);
				System.out.println("xxx"+achieveprogress);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("achieveprogress", achieveprogress);         // 資料庫取出的AchieveProgressVO物件,存入req
				String url = "/Gary_pages/update_AchieveProgress_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_AchieveProgress_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				System.out.println("updateError");
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/listAllAchieveProgress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // 來自update_AchieveProgress_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/				
				Integer userId = new Integer(req.getParameter("userid").trim());
				
				Integer achiId = new Integer(req.getParameter("achiid").trim());
				
				Integer currentArticle = new Integer(req.getParameter("currentarticle").trim());
				
				Integer currentOrder = new Integer(req.getParameter("currentorder").trim());
								
				java.sql.Date beginDate = null;
				try {
					beginDate = java.sql.Date.valueOf(req.getParameter("begindate").trim());
				} catch (IllegalArgumentException e) {
					beginDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				Integer sta = new Integer(req.getParameter("sta").trim());

				AchieveProgress achieveprogress = new AchieveProgress();
				achieveprogress.setUserId(userId);
				achieveprogress.setAchiId(achiId);
				achieveprogress.setCurrentArticle(currentArticle);
				achieveprogress.setCurrentOrder(currentOrder);
				achieveprogress.setBeginDate(beginDate);
				achieveprogress.setSta(sta);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("achieveprogress", achieveprogress); // 含有輸入格式錯誤的AchieveProgressVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/update_AchieveProgress_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				achieveprogress = achieveprogressSvc.updateAchieveProgress(userId, achiId, currentArticle, currentOrder, beginDate, sta);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("achieveprogress", achieveprogress); // 資料庫update成功後,正確的的AchieveProgressVO物件,存入req
				String url = "/Gary_pages/listOneAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneAchieveProgress.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/update_AchieveProgress_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addAchieveProgress.jsp的請求  
			System.out.println("hello");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userid").trim());
					System.out.println("userId"+userId);
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("請填會員編號");
				}
				Integer achiId = null;
				try {
					achiId = new Integer(req.getParameter("achiid").trim());
					System.out.println("achiId"+achiId);
				} catch (NumberFormatException e) {
					achiId = 0;
					errorMsgs.add("請填成就編號");
				}
				Integer currentArticle = null;
				try {
					currentArticle = new Integer(req.getParameter("currentarticle").trim());
					System.out.println("currentarticle"+currentArticle);
				} catch (NumberFormatException e) {
					currentArticle = 0;
					errorMsgs.add("請填當前文章數量");
				}
				Integer currentOrder = null;
				try {
					currentOrder = new Integer(req.getParameter("currentorder").trim());
					System.out.println("currenOrder"+currentOrder);
				} catch (NumberFormatException e) {
					currentOrder = 0;
					errorMsgs.add("請填當前訂單數量");
				}
				java.sql.Date beginDate = null;
				try {
					beginDate = java.sql.Date.valueOf(req.getParameter("begindate").trim());
					System.out.println("begindate"+beginDate);
				} catch (IllegalArgumentException e) {
					beginDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				Integer sta = null;
				try {
					sta = new Integer(req.getParameter("sta").trim());
					System.out.println("sta"+sta);
				} catch (NumberFormatException e) {
					sta = 0;
					errorMsgs.add("請填狀態編號");
				}
				
				AchieveProgress achieveprogress = new AchieveProgress();
				achieveprogress.setUserId(userId);
				achieveprogress.setAchiId(achiId);
				achieveprogress.setCurrentArticle(currentArticle);
				achieveprogress.setCurrentOrder(currentOrder);
				achieveprogress.setBeginDate(beginDate);
				achieveprogress.setSta(sta);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("achieveprogress", achieveprogress); // 含有輸入格式錯誤的AchieveProgressVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/addAchieveProgress.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
achieveprogress = achieveprogressSvc.addAchieveProgress(userId, achiId, currentArticle, currentOrder, beginDate, sta);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/Gary_pages/listAllAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAchieveProgress.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/addAchieveProgress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllAchieveProgress.jsp
		System.out.println("hello");	
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer userId = new Integer(req.getParameter("userid"));
//				System.out.println(userId);
				Integer achiId = new Integer(req.getParameter("achiid"));
				System.out.println(achiId);
				/***************************2.開始刪除資料***************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				achieveprogressSvc.deleteAchieveProgress(userId, achiId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/Gary_pages/listAllAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/listAllAchieveProgress.jsp");
				failureView.forward(req, res);
			}
		}
	}
}