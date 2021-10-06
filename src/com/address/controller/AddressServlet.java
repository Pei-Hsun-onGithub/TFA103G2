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

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			System.out.println("hello--1");

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String str = req.getParameter("deliveryAddId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入外送地址編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				Integer deliveryAddId = null;
				try {
					deliveryAddId = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("外送地址編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(deliveryAddId);
				if (addressVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("addressVO", addressVO); // 資料庫取出的addressVO物件,存入req
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneAddress.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/address/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllAddress.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				Integer addId = new Integer(req.getParameter("deliveryAddId"));

				/*************************** 2.開始查詢資料 ****************************************/
				AddressService addressSvc = new AddressService();
				AddressVO addressVO = addressSvc.getOneAddress(addId);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("addressVO", addressVO); // 資料庫取出的addressVO物件,存入req
				String url = "/address/update_address_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_address_input.jsp
				successView.forward(req, res);
				return;

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
				return;
			}
		}

//================================================================================================================		

		if ("update".equals(action)) { // 來自update_address_input.jsp的請求
			System.out.println("update");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

				try {
					String a = req.getParameter("deliveryAddId").trim();
					System.out.println(a);
					Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
//					System.out.println(deliveryAddId);
				} catch (Exception e) {
					System.err.println("錯在這");
				}

				Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userId").trim());
//		System.out.println(userId);
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("請填會員編號");
				}

				String customerName = req.getParameter("customerName");
				System.out.println(customerName);
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (customerName == null || customerName.trim().length() == 0) {
					errorMsgs.add("取餐人姓名: 請勿空白");
				} else if (!customerName.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("取餐人姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String deliverPhone = req.getParameter("deliverPhone");
//		System.out.println(deliverPhone);
				String deliverPhoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (deliverPhone == null || deliverPhone.trim().length() == 0) {
					errorMsgs.add("電話號碼: 請勿空白");
				} else if (!deliverPhone.trim().matches(deliverPhoneReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請填寫電話號碼。");
				}

				String deliverAddress = req.getParameter("deliverAddress");
				System.out.println(deliverAddress);
				String AddressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,100}$";
				if (deliverAddress == null || deliverAddress.trim().length() == 0) {
					errorMsgs.add("地址: 請勿空白");
				} else if (!deliverAddress.trim().matches(AddressReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("地址: 只能是中、英文字母、數字 , 且長度必需在100之間");
				}

				String buildingName = req.getParameter("buildingName");
				System.out.println(buildingName);

				String note = req.getParameter("note");
				System.out.println(note);

				Integer sta = new Integer(req.getParameter("sta").trim());
				// 因為是get get都是字串。數字回來要轉型，所以用new。
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
					req.setAttribute("addressVO", addressVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/address/update_address_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.updateAddress(userId, customerName, deliverPhone, deliverAddress, buildingName,
						note, sta, deliveryAddId);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("addressVO", addressVO); // 資料庫update成功後,正確的的empVO物件,存入req
				System.out.println("transfor");
				String url = "/address/listOneAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
				return;

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
			}
			RequestDispatcher failureView = req.getRequestDispatcher("update_address_input.jsp");
			failureView.forward(req, res);
		}

//===========================================================================================

		if ("insert".equals(action)) { // 來自addAddress.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				try {
//					String a = req.getParameter("deliveryAddId").trim();
//					System.out.println(a);
//					Integer deliveryAddId = new Integer(req.getParameter("deliveryAddId").trim());
//		System.out.println(deliveryAddId);
//				} catch (Exception e) {
//					System.err.println("錯在這");
//				}

				Integer userId = null;
				try {
					userId = new Integer(req.getParameter("userId").trim());
System.out.println("1.userId="+userId);
				} catch (NumberFormatException e) {
					userId = 0;
					errorMsgs.add("請填會員編號");
				}

				String customerName = req.getParameter("customerName");
System.out.println("2.customerName="+ customerName);
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{2,10}$";
				if (customerName == null || customerName.trim().length() == 0) {
					errorMsgs.add("取餐人姓名: 請勿空白");
				} else if (!customerName.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("取餐人姓名: 只能是中、英文字母、數字 , 且長度必需在2到10之間");
				}

				String deliverPhone = req.getParameter("deliverPhone");
System.out.println("3.deliverPhone="+deliverPhone);
				String deliverPhoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (deliverPhone == null || deliverPhone.trim().length() == 0) {
					errorMsgs.add("電話號碼: 請勿空白");
				} else if (!deliverPhone.trim().matches(deliverPhoneReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請填寫電話號碼。");
				}

				String deliverAddress = req.getParameter("deliverAddress");
System.out.println("4.deliverAddress="+ deliverAddress);
				String AddressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,100}$";
				if (deliverAddress == null || deliverAddress.trim().length() == 0) {
					errorMsgs.add("地址: 請勿空白");
				} else if (!deliverAddress.trim().matches(AddressReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("地址: 只能是中、英文字母、數字 , 且長度必需在100之間");
				}

				String buildingName = req.getParameter("buildingName");
System.out.println("5.buildingName="+ buildingName);

				String note = req.getParameter("note");
System.out.println("6.note="+note);

				Integer sta = new Integer(req.getParameter("sta").trim());
//因為是get get都是字串。數字回來要轉型，所以用new。
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
					req.setAttribute("addressVO", addressVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/address/addAddress.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				AddressService addressSvc = new AddressService();
				addressVO = addressSvc.addAddress(userId, customerName, deliverPhone, deliverAddress, buildingName,
						note, sta);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("addressVO", addressVO); // 資料庫update成功後,正確的的empVO物件,存入req
				System.out.println("transfor");
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
				return;

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
			}
			RequestDispatcher failureView = req.getRequestDispatcher("update_address_input.jsp");
			failureView.forward(req, res);
		}
//		
//===================================================================================================
//		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				Integer deleteAddId = new Integer(req.getParameter("deliveryAddId"));

				/*************************** 2.開始刪除資料 ***************************************/
				AddressService empSvc = new AddressService();
				empSvc.deleteAddress(deleteAddId);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/address/listAllAddress.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/address/listAllAddress.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
