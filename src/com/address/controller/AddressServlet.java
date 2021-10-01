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
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("deliveryAddId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�~�e�a�}�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer deliveryAddId = null;
				try {
					deliveryAddId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�~�e�a�}�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(deliveryAddId);
				if (addressVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("addressVO", addressVO); // ��Ʈw���X��addressVO����,�s�Jreq
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneAddress.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllAddress.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId"));
				
				/***************************2.�}�l�d�߸��****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(deliveryAddId);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("addressVO", addressVO);         // ��Ʈw���X��addressVO����,�s�Jreq
				String url = "/address/update_address_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_address_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_address_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
				
//				String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("���u�m�W: �ФŪť�");
//				} else if(!ename.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//	            }
				
				String job = req.getParameter("job").trim();
				if (job == null || job.trim().length() == 0) {
					errorMsgs.add("¾��ФŪť�");
				}	
				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
//				}

				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("�~���ж�Ʀr.");
				}

				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("�����ж�Ʀr.");
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
					req.setAttribute("addressVO", addressVO); // �t����J�榡���~��addressVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/address/update_address_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.updateAddress(addressno, ename, job, hiredate, sal,comm, deptno);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("addressVO", addressVO); // ��Ʈwupdate���\��,���T����addressVO����,�s�Jreq
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneAddress.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/update_address_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addAddress.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				String ename = req.getParameter("ename");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (ename == null || ename.trim().length() == 0) {
					errorMsgs.add("���u�m�W: �ФŪť�");
				} else if(!ename.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				String job = req.getParameter("job").trim();
				if (job == null || job.trim().length() == 0) {
					errorMsgs.add("¾��ФŪť�");
				}
				
				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}
				
				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("�~���ж�Ʀr.");
				}
				
				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("�����ж�Ʀr.");
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
					req.setAttribute("addressVO", addressVO); // �t����J�榡���~��addressVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/address/addAddress.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.addAddress(ename, job, hiredate, sal, comm, deptno);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllAddress.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/addAddress.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllAddress.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer addressno = new Integer(req.getParameter("addressno"));
				
				/***************************2.�}�l�R�����***************************************/
				AddressService addressSvc = new AddressService();
				addressSvc.deleteAddress(addressno);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
