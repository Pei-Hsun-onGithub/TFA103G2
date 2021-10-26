package com.memberinfo.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.memberinfo.model.*;

public class MemberInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String str = req.getParameter("empno");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入員工編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				Integer empno = null;
//				try {
//					empno = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("員工編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************2.開始查詢資料*****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//				if (empVO == null) {
//					errorMsgs.add("查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try {
//				/***************************1.接收請求參數****************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.開始查詢資料****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//								
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				req.setAttribute("empVO", empVO);         // 資料庫取出的empVO物件,存入req
//				String url = "/emp/update_emp_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//Integer empno = new Integer(req.getParameter("empno").trim());
//				
//String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
//String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}	
//				
//				java.sql.Date hiredate = null;
//				try {
//hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//
//				Double sal = null;
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//
//Integer deptno = new Integer(req.getParameter("deptno").trim());
//
//				EmpVO empVO = new EmpVO();
//				empVO.setEmpno(empno);
//				empVO.setEname(ename);
//				empVO.setJob(job);
//				empVO.setHiredate(hiredate);
//				empVO.setSal(sal);
//				empVO.setComm(comm);
//				empVO.setDeptno(deptno);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始修改資料*****************************************/
//				EmpService empSvc = new EmpService();
//				empVO = empSvc.updateEmp(empno, ename, job, hiredate, sal,comm, deptno);
//				
//				/***************************3.修改完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("修改資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/update_emp_input.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.接收請求參數***************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.開始刪除資料***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("刪除資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
		
		

		
//        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
//
//		// List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//		//	req.setAttribute("errorMsgs", errorMsgs);
//			MemberInfoService memberSvc1 = new MemberInfoService();
//			MemberInfo member1 = memberSvc1.getOneMemberInfo(20210001);
//			req.setAttribute("memberinfo", member1);
//			String url = "/Gary_pages/Member01.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
//			successView.forward(req, res);
//		}
		
		/*************************************會員中心***************************************/			
		
		if("getOneEmail".equals(action)) {

			// List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
			//	req.setAttribute("errorMsgs", errorMsgs);
				MemberInfoService memberSvc2 = new MemberInfoService();
				MemberInfo member2 = memberSvc2.getOneMemberInfo(20210001);
				req.setAttribute("memberinfo", member2);
				String url = "/Gary_pages/Member01-email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);
		}
		
		if("getOnePhone".equals(action)) {

			// List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
			//	req.setAttribute("errorMsgs", errorMsgs);
				MemberInfoService memberSvc3 = new MemberInfoService();
				MemberInfo member3 = memberSvc3.getOneMemberInfo(20210001);
				req.setAttribute("memberinfo", member3);
				String url = "/Gary_pages/Member01-phone.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
/*************************************會員註冊***************************************/		
		
        if ("insert".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
		/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

String email = req.getParameter("email");
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("電子郵件: 請勿空白");
				} else if(!email.trim().matches(emailReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("電子郵件: 不符合電子郵件命名規範");
	            } else {
	            	MemberInfoService memberInfoSvc = new MemberInfoService();
	            	boolean MemberInfo = memberInfoSvc.findByEmail(email);
	            	
	            	if (MemberInfo) {
	            		errorMsgs.add("此帳號已註冊");
	            	}	            	
	            }
				
				
String pwd = req.getParameter("pwd");
				String pwdlReg = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
				if (pwd == null || pwd.trim().length() == 0) {
					errorMsgs.add("密碼: 請勿空白");
				} else if(!pwd.trim().matches(pwdlReg)) { 
					errorMsgs.add("密碼: 密碼長度至少應該設定 8 碼以上，而且要混合大小寫英文字母、數字和特殊符號");
	            }
				
				
String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("密碼2: 請勿空白");
				} else if(pwd.equals(pwd2) == false) { 
					errorMsgs.add("密碼: 您兩次輸入密碼不一致");
	            }
				
				
				java.sql.Date birthday = null;
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				
String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("姓名: 請勿空白");
				} else if(!userName.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				
String gender = req.getParameter("gender");

String phone = req.getParameter("phone");		
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("電話號碼: 請勿空白");
				} else if(!phone.trim().matches(phoneReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("電話號碼:數字 , 且長度必需為10，開頭為09開頭");					
	            }	
				
				
				java.sql.Date registerDate = new java.sql.Date(System.currentTimeMillis());
				
				MemberInfo memberInfo2 = new MemberInfo();
				memberInfo2.setPwd(pwd2);
				
				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setEmail(email);
				memberInfo.setPwd(pwd);
				memberInfo.setUserName(userName);
				memberInfo.setGender(gender);
				memberInfo.setBirthday(birthday);
				memberInfo.setPhone(phone);
				memberInfo.setRegisterDate(registerDate);

				// Send the use back to the form, if there were errors
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberInfo", memberInfo); // 含有輸入格式錯誤的empVO物件,也存入req
					req.setAttribute("memberInfo2", memberInfo2);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/login/Login-custome-regist.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/			
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone,null,registerDate,0,0,1001,null,1,0,1);
				HttpSession session = req.getSession();
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("memberInfo", memberInfo);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				
				String url = "/pei_pages/monsterChoose.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交vendor_meal_upload.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("註冊失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/login/Login-custome-regist.jsp");
				failureView.forward(req, res);
			}
		}
		
        
/************************************廠商註冊************************************/
		
        if ("insert2".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
		/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

String email = req.getParameter("email");
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("電子郵件: 請勿空白");
				} else if(!email.trim().matches(emailReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("電子郵件: 不符合電子郵件命名規範");
	            } else {
	            	MemberInfoService memberInfoSvc = new MemberInfoService();
	            	boolean MemberInfo = memberInfoSvc.findByEmail(email);
	            	
	            	if (MemberInfo) {
	            		errorMsgs.add("此帳號已註冊");
	            	}	            	
	            }
				
				
String pwd = req.getParameter("pwd");
				String pwdlReg = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
				if (pwd == null || pwd.trim().length() == 0) {
					errorMsgs.add("密碼: 請勿空白");
				} else if(!pwd.trim().matches(pwdlReg)) { 
					errorMsgs.add("密碼: 密碼長度至少應該設定 8 碼以上，而且要混合大小寫英文字母、數字和特殊符號");
	            }
				
				
String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("密碼2: 請勿空白");
				} else if(pwd.equals(pwd2) == false) { 
					errorMsgs.add("密碼: 您兩次輸入密碼不一致");
	            }
				
				
				java.sql.Date birthday = null;
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				
String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("姓名: 請勿空白");
				} else if(!userName.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				
String gender = req.getParameter("gender");

String phone = req.getParameter("phone");		
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("電話號碼: 請勿空白");
				} else if(!phone.trim().matches(phoneReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("電話號碼:數字 , 且長度必需為10，開頭為09開頭");					
	            }	
				

				java.sql.Date registerDate = new java.sql.Date(System.currentTimeMillis());
				
				MemberInfo memberInfo2 = new MemberInfo();
				memberInfo2.setPwd(pwd2);
				
				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setEmail(email);
				memberInfo.setPwd(pwd);
				memberInfo.setUserName(userName);
				memberInfo.setGender(gender);
				memberInfo.setBirthday(birthday);
				memberInfo.setPhone(phone);
				memberInfo.setRegisterDate(registerDate);

				// Send the use back to the form, if there were errors
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberInfo", memberInfo); // 含有輸入格式錯誤的empVO物件,也存入req
					req.setAttribute("memberInfo2", memberInfo2);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/login/Login-vendor-regist.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/			
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone,null,registerDate,0,0,1001,null,1,0,4);
				//System.out.println("memberInfo="+memberInfo);
				HttpSession session = req.getSession();
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("memberInfo", memberInfo);
				
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/pei_pages/vendor_restaurant_addInfo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交vendor_meal_upload.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("註冊失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/login/Login-vendor-regist.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
