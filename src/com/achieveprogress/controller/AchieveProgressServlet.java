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
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD
			System.out.println("hello");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str1 = req.getParameter("userid");
				System.out.println("userid=" + str1);
				if (str1 == null || (str1.trim()).length() == 0) {
					errorMsgs.add("�п�J�|���s��");
				}
				String str2 = req.getParameter("achiid");
				System.out.println("userid=" + str2);
				if (str2 == null || (str2.trim()).length() == 0) {
					errorMsgs.add("�п�J���N�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer userId = null;
				Integer achiId = null;
				try {
					userId = new Integer(str1);
					achiId = new Integer(str2);
				} catch (Exception e) {
					errorMsgs.add("�榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				AchieveProgress achieveprogress = achieveprogressSvc.getOneAchieveProgress(userId, achiId);
				if (achieveprogress == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("achieveprogress", achieveprogress); // ��Ʈw���X��AchieveProgressVO����,�s�Jreq
				String url = "/Gary_pages/listOneAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneAchieveProgress.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllAchieveProgress.jsp���ШD
			System.out.println("hello");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer userId = new Integer(req.getParameter("userid"));
				System.out.println("userId"+userId);
				Integer achiId = new Integer(req.getParameter("achiid"));
				System.out.println("achiid"+achiId);
				/***************************2.�}�l�d�߸��****************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				AchieveProgress achieveprogress = achieveprogressSvc.getOneAchieveProgress(userId, achiId);
				System.out.println("xxx"+achieveprogress);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("achieveprogress", achieveprogress);         // ��Ʈw���X��AchieveProgressVO����,�s�Jreq
				String url = "/Gary_pages/update_AchieveProgress_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_AchieveProgress_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				System.out.println("updateError");
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/listAllAchieveProgress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_AchieveProgress_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/				
				Integer userId = new Integer(req.getParameter("userid").trim());
				
				Integer achiId = new Integer(req.getParameter("achiid").trim());
				
				Integer currentArticle = new Integer(req.getParameter("currentarticle").trim());
				
				Integer currentOrder = new Integer(req.getParameter("currentorder").trim());
								
				java.sql.Date beginDate = null;
				try {
					beginDate = java.sql.Date.valueOf(req.getParameter("begindate").trim());
				} catch (IllegalArgumentException e) {
					beginDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
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
					req.setAttribute("achieveprogress", achieveprogress); // �t����J�榡���~��AchieveProgressVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/update_AchieveProgress_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				achieveprogress = achieveprogressSvc.updateAchieveProgress(userId, achiId, currentArticle, currentOrder, beginDate, sta);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("achieveprogress", achieveprogress); // ��Ʈwupdate���\��,���T����AchieveProgressVO����,�s�Jreq
				String url = "/Gary_pages/listOneAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneAchieveProgress.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/update_AchieveProgress_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addAchieveProgress.jsp���ШD  
			System.out.println("hello");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userid").trim());
					System.out.println("userId"+userId);
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("�ж�|���s��");
				}
				Integer achiId = null;
				try {
					achiId = new Integer(req.getParameter("achiid").trim());
					System.out.println("achiId"+achiId);
				} catch (NumberFormatException e) {
					achiId = 0;
					errorMsgs.add("�ж񦨴N�s��");
				}
				Integer currentArticle = null;
				try {
					currentArticle = new Integer(req.getParameter("currentarticle").trim());
					System.out.println("currentarticle"+currentArticle);
				} catch (NumberFormatException e) {
					currentArticle = 0;
					errorMsgs.add("�ж��e�峹�ƶq");
				}
				Integer currentOrder = null;
				try {
					currentOrder = new Integer(req.getParameter("currentorder").trim());
					System.out.println("currenOrder"+currentOrder);
				} catch (NumberFormatException e) {
					currentOrder = 0;
					errorMsgs.add("�ж��e�q��ƶq");
				}
				java.sql.Date beginDate = null;
				try {
					beginDate = java.sql.Date.valueOf(req.getParameter("begindate").trim());
					System.out.println("begindate"+beginDate);
				} catch (IllegalArgumentException e) {
					beginDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}
				Integer sta = null;
				try {
					sta = new Integer(req.getParameter("sta").trim());
					System.out.println("sta"+sta);
				} catch (NumberFormatException e) {
					sta = 0;
					errorMsgs.add("�ж񪬺A�s��");
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
					req.setAttribute("achieveprogress", achieveprogress); // �t����J�榡���~��AchieveProgressVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/addAchieveProgress.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
achieveprogress = achieveprogressSvc.addAchieveProgress(userId, achiId, currentArticle, currentOrder, beginDate, sta);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/Gary_pages/listAllAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllAchieveProgress.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/addAchieveProgress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllAchieveProgress.jsp
		System.out.println("hello");	
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer userId = new Integer(req.getParameter("userid"));
//				System.out.println(userId);
				Integer achiId = new Integer(req.getParameter("achiid"));
				System.out.println(achiId);
				/***************************2.�}�l�R�����***************************************/
				AchieveProgressService achieveprogressSvc = new AchieveProgressService();
				achieveprogressSvc.deleteAchieveProgress(userId, achiId);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/Gary_pages/listAllAchieveProgress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/listAllAchieveProgress.jsp");
				failureView.forward(req, res);
			}
		}
	}
}