package com.address.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.address.model.*;
import com.address.model.AddressVO;

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
							.getRequestDispatcher("/address/select_page.jsp");
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
							.getRequestDispatcher("/address/select_page.jsp");
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
							.getRequestDispatcher("/address/select_page.jsp");
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
						.getRequestDispatcher("/address/select_page.jsp");
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
				Integer userId = new Integer(req.getParameter("userId"));
				
				/***************************2.�}�l�d�߸��****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(userId);
								
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
		
		
if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
				
			Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userId").trim());
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("�ж�|���s��");
				}

				String customerName = req.getParameter("customerName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (customerName == null || customerName.trim().length() == 0) {
					errorMsgs.add("���\�H�m�W: �ФŪť�");
				} else if(!customerName.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���\�H�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				String deliverPhone = req.getParameter("deliverPhone");
				String deliverPhoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if(!deliverPhone.trim().matches(deliverPhoneReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("");
	            }
				
				String deliverAddress = req.getParameter("deliverAddress");
				String AddressReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]{100}$";
				if (deliverAddress == null || deliverAddress.trim().length() == 0) {
					errorMsgs.add("�a�}: �ФŪť�");
	            } else if(!deliverAddress.trim().matches(AddressReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�a�}: �u��O���B�^��r���B�Ʀr , �B���ץ��ݦb100����");
	            }
				
				String buildingName = req.getParameter("buildingName");
				String note = req.getParameter("note");
				Integer sta = new Integer(req.getParameter("sta").trim());
				//�]���Oget get���O�r��C�Ʀr�^�ӭn�૬�A�ҥH��new�C

				AddressVO addressVO = new AddressVO();
				addressVO.setUserId(userId);
				addressVO.setCustomerName(customerName);
				addressVO.setDeliverPhone(deliverPhone);
				addressVO.setDeliverAddress(deliverAddress);
				addressVO.setBuildingName(buildingName);
				addressVO.setNote(note);
				addressVO.setSta(sta);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("addressVO", addressVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/address/update_address_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.updateAddress(userId,customerName,deliverPhone,deliverAddress,buildingName,note,sta);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("addressVO", addressVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/address/update_address_input.jsp");
				failureView.forward(req, res);
			}
		}

//        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("���u�m�W: �ФŪť�");
//				} else if(!ename.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//	            }
//				
//String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("¾��ФŪť�");
//				}
//				
//				java.sql.Date hiredate = null;
//				try {
//hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
//				}
//				
//				Double sal = null;
//				try {
//sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("�~���ж�Ʀr.");
//				}
//				
//				Double comm = null;
//				try {
//comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("�����ж�Ʀr.");
//				}
//				
//Integer deptno = new Integer(req.getParameter("deptno").trim());
//
//				EmpVO empVO = new EmpVO();
//				empVO.setEname(ename);
//				empVO.setJob(job);
//				empVO.setHiredate(hiredate);
//				empVO.setSal(sal);
//				empVO.setComm(comm);
//				empVO.setDeptno(deptno);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("empVO", empVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/addEmp.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//				
//				/***************************2.�}�l�s�W���***************************************/
//				EmpService empSvc = new EmpService();
//				empVO = empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);
//				
//				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
//				successView.forward(req, res);				
//				
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/addEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.�����ШD�Ѽ�***************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.�}�l�R�����***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
//				successView.forward(req, res);
//				
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("�R����ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
	}
}
