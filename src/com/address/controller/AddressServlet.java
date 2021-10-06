package com.address.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.address.model.*;
import com.address.model.AddressVO;

public class AddressServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

//===============================================================================================	

		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD
			System.out.println("hello--1");

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
				String str = req.getParameter("deliveryAddId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�~�e�a�}�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				Integer deliveryAddId = null;
				try {
					deliveryAddId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�~�e�a�}�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 2.�}�l�d�߸�� *****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(deliveryAddId);
				if (addressVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
					failureView.forward(req, res);
					return;// �{�����_
				}

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
				req.setAttribute("addressVO", addressVO); // ��Ʈw���X��addressVO����,�s�Jreq
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneAddress.jsp
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllAddress.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				Integer addId = new Integer(req.getParameter("deliveryAddId"));

				/*************************** 2.�}�l�d�߸�� ****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(addId);

				/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
				req.setAttribute("addressVO", addressVO); // ��Ʈw���X��addressVO����,�s�Jreq
				String url = "/address/update_address_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_address_input.jsp
				successView.forward(req, res);
				return;

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
				return;
			}
		}

//================================================================================================================		

		if ("update".equals(action)) { // �Ӧ�update_address_input.jsp���ШD
			System.out.println("update");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/

				try {
					String a = req.getParameter("deliveryAddId").trim();
					System.out.println(a);
					Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
//					System.out.println(deliveryAddId);
				} catch (Exception e) {
					System.err.println("���b�o");
				}

				Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userId").trim());
//		System.out.println(userId);
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("�ж�|���s��");
				}

				String customerName = req.getParameter("customerName");
				System.out.println(customerName);
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (customerName == null || customerName.trim().length() == 0) {
					errorMsgs.add("���\�H�m�W: �ФŪť�");
				} else if (!customerName.trim().matches(enameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���\�H�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
				}

				String deliverPhone = req.getParameter("deliverPhone");
//		System.out.println(deliverPhone);
				String deliverPhoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (deliverPhone == null || deliverPhone.trim().length() == 0) {
					errorMsgs.add("�q�ܸ��X: �ФŪť�");
				} else if (!deliverPhone.trim().matches(deliverPhoneReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�ж�g�q�ܸ��X�C");
				}

				String deliverAddress = req.getParameter("deliverAddress");
				System.out.println(deliverAddress);
				String AddressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,100}$";
				if (deliverAddress == null || deliverAddress.trim().length() == 0) {
					errorMsgs.add("�a�}: �ФŪť�");
				} else if (!deliverAddress.trim().matches(AddressReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�a�}: �u��O���B�^��r���B�Ʀr , �B���ץ��ݦb100����");
				}

				String buildingName = req.getParameter("buildingName");
				System.out.println(buildingName);

				String note = req.getParameter("note");
				System.out.println(note);

				Integer sta = new Integer(req.getParameter("sta").trim());
				// �]���Oget get���O�r��C�Ʀr�^�ӭn�૬�A�ҥH��new�C
				System.out.println(sta);

				Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
				System.out.println(deliveryAddId);

				AddressVO addressVO = new AddressVO();
				addressVO.setUserId(userId);
				addressVO.setCustomerName(customerName);
				addressVO.setDeliverPhone(deliverPhone);
				addressVO.setDeliverAddress(deliverAddress);
				addressVO.setBuildingName(buildingName);
				addressVO.setNote(note);
				addressVO.setSta(sta);
				addressVO.setDeliveryAddId(deliveryAddId);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					System.out.println(errorMsgs.size());
					System.out.println("hahaha");
					req.setAttribute("addressVO", addressVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/address/update_address_input.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.updateAddress(userId, customerName, deliverPhone, deliverAddress, buildingName,
						note, sta, deliveryAddId);

				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("addressVO", addressVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				System.out.println("transfor");
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);
				return;

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());
			}
			RequestDispatcher failureView = req.getRequestDispatcher("update_address_input.jsp");
			failureView.forward(req, res);
		}

//===========================================================================================

		if ("insert".equals(action)) { // �Ӧ�addAddress.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
//				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//				try {
//					String a = req.getParameter("deliveryAddId").trim();
//					System.out.println(a);
//					Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
//		System.out.println(deliveryAddId);
//				} catch (Exception e) {
//					System.err.println("���b�o");
//				}

				Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userId").trim());
System.out.println("1.userId="+userId);
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("�ж�|���s��");
				}

				String customerName = req.getParameter("customerName");
System.out.println("2.customerName="+ customerName);
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{2,10}$";
				if (customerName == null || customerName.trim().length() == 0) {
					errorMsgs.add("���\�H�m�W: �ФŪť�");
				} else if (!customerName.trim().matches(enameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���\�H�m�W: �u��O���B�^��r���B�Ʀr , �B���ץ��ݦb2��10����");
				}

				String deliverPhone = req.getParameter("deliverPhone");
System.out.println("3.deliverPhone="+deliverPhone);
				String deliverPhoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (deliverPhone == null || deliverPhone.trim().length() == 0) {
					errorMsgs.add("�q�ܸ��X: �ФŪť�");
				} else if (!deliverPhone.trim().matches(deliverPhoneReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�ж�g�q�ܸ��X�C");
				}

				String deliverAddress = req.getParameter("deliverAddress");
System.out.println("4.deliverAddress="+ deliverAddress);
				String AddressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,100}$";
				if (deliverAddress == null || deliverAddress.trim().length() == 0) {
					errorMsgs.add("�a�}: �ФŪť�");
				} else if (!deliverAddress.trim().matches(AddressReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�a�}: �u��O���B�^��r���B�Ʀr , �B���ץ��ݦb100����");
				}

				String buildingName = req.getParameter("buildingName");
System.out.println("5.buildingName="+ buildingName);

				String note = req.getParameter("note");
System.out.println("6.note="+note);

				Integer sta = new Integer(req.getParameter("sta").trim());
//�]���Oget get���O�r��C�Ʀr�^�ӭn�૬�A�ҥH��new�C
System.out.println("7.sta="+sta);

//				Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
//System.out.println("8.deliveryAddId="+deliveryAddId);

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
					System.out.println(errorMsgs.size());
					System.out.println("hahaha");
					req.setAttribute("addressVO", addressVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/address/addAddress.jsp");
					failureView.forward(req, res);
					return; // �{�����_
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.addAddress(userId, customerName, deliverPhone, deliverAddress, buildingName,
						note, sta);

				/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
				req.setAttribute("addressVO", addressVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				System.out.println("transfor");
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);
				return;

				/*************************** ��L�i�઺���~�B�z *************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:" + e.getMessage());
			}
			RequestDispatcher failureView = req.getRequestDispatcher("update_address_input.jsp");
			failureView.forward(req, res);
		}
//		
//===================================================================================================
//		
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.�����ШD�Ѽ� ***************************************/
				Integer deleteAddId = new Integer(req.getParameter("deliveryAddId"));

				/*************************** 2.�}�l�R����� ***************************************/
				AddressService empSvc = new AddressService();
				empSvc.deleteAddress(deleteAddId);

				/*************************** 3.�R������,�ǳ����(Send the Success view) ***********/
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
