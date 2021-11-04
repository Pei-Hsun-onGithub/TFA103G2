package com.memberinfo.controller;

import java.io.*;

import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;

import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.memberinfo.model.*;

import com.memberinfo.model.*;

@MultipartConfig
public class MemberInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");




		/*************************************
		 * ?�員中�?
		 ***************************************/
		if ("getOne".equals(action)) {


			// List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			// req.setAttribute("errorMsgs", errorMsgs);
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo member = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", member);
			String url = "/Gary_pages/Member01.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOnePwd".equals(action)) {

			// List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			// req.setAttribute("errorMsgs", errorMsgs);
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo member = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", member);
			String url = "/Gary_pages/Member02.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���� listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// 1. �����������ơA���~���ƳB�z
			try {

				Integer userId = new Integer(req.getParameter("userId"));
				String userName = req.getParameter("userName");
				String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (userName == null || (userName.trim().length()) == 0) {
					errorMsgs.add("�m�W: �ФŪť�");
				} else if (!userName.trim().matches(userNameReg)) { // �H�U�m�ߥ��h(�W)���ܦ�(regular-expression)
					errorMsgs.add("�m�W: �u���O���B�^���r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
				}

				String email = req.getParameter("email");
				String pwd = req.getParameter("pwd");
				Date registerDate = java.sql.Date.valueOf(req.getParameter("registerDate").trim());

				String gender = req.getParameter("gender");
//				System.out.println("gender="+gender);

				Date birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				Integer gold = new Integer(req.getParameter("gold"));
				Integer feed = new Integer(req.getParameter("feed"));
				Integer monsterId = new Integer(req.getParameter("monsterId"));
				String monsterNickName = req.getParameter("monsterNickName");
				Integer lv = new Integer(req.getParameter("lv"));
				Integer exp = new Integer(req.getParameter("exp"));
				Integer sta = new Integer(req.getParameter("sta"));

				String phone = req.getParameter("phone");
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || (phone.trim().length() == 0)) {
					errorMsgs.add("�q�ܸ��X: �ФŪť�");
				} else if (!phone.trim().matches(phoneReg)) { // �H�U�m�ߥ��h(�W)���ܦ�(regular-expression)
					errorMsgs.add("�q�ܸ��X:�Ʀr , �B���ץ��ݬ�10�A�}�Y��09�}�Y");
				}

				// �Ϥ��W��
				byte[] pic = null;

				Part part = req.getPart("imgfile");
				if (part.getSize() > 0) {
					InputStream in = part.getInputStream();
					pic = new byte[in.available()];
					in.read(pic);
					in.close();
				}

				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserId(userId);
				memberInfo.setEmail(email);
				memberInfo.setPwd(pwd);
				memberInfo.setUserName(userName);
				memberInfo.setGender(gender);
				memberInfo.setBirthday(birthday);
				memberInfo.setPhone(phone);
				memberInfo.setPic(pic);
				memberInfo.setRegisterDate(registerDate);
				memberInfo.setGold(gold);
				memberInfo.setFeed(feed);
				memberInfo.setMonsterId(monsterId);
				memberInfo.setMonsterNickName(monsterNickName);
				memberInfo.setLv(lv);
				memberInfo.setExp(exp);
				memberInfo.setSta(sta);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberinfo", memberInfo); // �t�����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member01.jsp");
					failureView.forward(req, res);
					System.out.println("aaa");
					return;
				}

				// 2. ���[��
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.updateMemberInfo(userId, email, pwd, userName, gender, birthday, phone, pic,
						registerDate, gold, feed, monsterId, monsterNickName, lv, exp, sta);
				System.out.println("bbb");
				// 3. �����ܮi�ܼh

				req.setAttribute("memberinfo", memberInfo); // ���Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/Gary_pages/Member01.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,����listOneEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member01.jsp");
				failureView.forward(req, res);
			}

		}

		if ("updatePwd".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			HttpSession session = req.getSession();
			MemberInfo mem = (MemberInfo)session.getAttribute("memberInfo");
			System.out.println("mem=" + mem);
			String memberpwd = mem.getPwd();
			req.setAttribute("memberinfo", mem);
			// 1. �����������ơA���~���ƳB�z
			try {

				Integer userId = new Integer(req.getParameter("userId"));
				String userName = req.getParameter("userName");
				String nowpwd = req.getParameter("nowpwd");
				String email = req.getParameter("email");
				Date registerDate = java.sql.Date.valueOf(req.getParameter("registerDate").trim());
				String gender = req.getParameter("gender");
				Date birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				Integer gold = new Integer(req.getParameter("gold"));
				Integer feed = new Integer(req.getParameter("feed"));
				Integer monsterId = new Integer(req.getParameter("monsterId"));
				String monsterNickName = req.getParameter("monsterNickName");
				Integer lv = new Integer(req.getParameter("lv"));
				Integer exp = new Integer(req.getParameter("exp"));
				Integer sta = new Integer(req.getParameter("sta"));
				String phone = req.getParameter("phone");
				byte[] pic = null;
				System.out.println("nowpwd=" +nowpwd);
				System.out.println("memberpwd = " + memberpwd);
				if (nowpwd == null || nowpwd.trim().length() == 0) {
					errorMsgs.add("當前密碼:請勿空白，請重新輸入");
				} else if (!nowpwd.equals(memberpwd)) {
					errorMsgs.add("與原密碼輸入不一致，請重新確認");
				}
				
				
				String newPwd = req.getParameter("newpwd");
				String newPwdReg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
				if (newPwd == null || newPwd.trim().length() == 0) {
					errorMsgs.add("新密碼:請勿空白，請重新輸入");
				} else if (!newPwd.trim().matches(newPwdReg)) {
					errorMsgs.add("密碼不符合格式");
				}
//				else {
//	            	MemberInfoService memberInfoSvc1 = new MemberInfoService();
//	            	boolean MemberInfo= memberInfoSvc1.findByPwd(pwd);
//
//	            	if (MemberInfo) {
////	            		System.out.println("���g�L");
//	            		errorMsgs.add("���K�X�P���e�K�X���ơA�Э��s���J");
//	            	}
//	            }

				String newPwd2 = req.getParameter("newpwd2");
				if (newPwd2 == null || newPwd2.trim().length() == 0) {
					errorMsgs.add("驗證密碼2：請勿空白");
				} else if (newPwd.equals(newPwd2) == false) {
					errorMsgs.add("兩次密碼輸入不同，請重新確認");
				}

				MemberInfo memberInfo3 = new MemberInfo();
				memberInfo3.setPwd(nowpwd);
				MemberInfo memberInfo2 = new MemberInfo();
				memberInfo2.setPwd(newPwd2);

				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserId(userId);
				memberInfo.setEmail(email);
				memberInfo.setPwd(newPwd);
				memberInfo.setUserName(userName);
				memberInfo.setGender(gender);
				memberInfo.setBirthday(birthday);
				memberInfo.setPhone(phone);
				memberInfo.setPic(pic);
				memberInfo.setRegisterDate(registerDate);
				memberInfo.setGold(gold);
				memberInfo.setFeed(feed);
				memberInfo.setMonsterId(monsterId);
				memberInfo.setMonsterNickName(monsterNickName);
				memberInfo.setLv(lv);
				memberInfo.setExp(exp);
				memberInfo.setSta(sta);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberinfo", memberInfo); // �t�����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member02.jsp");
					failureView.forward(req, res);
					System.out.println("aaa");
					return;
				}

				// 2. ���[��
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.updateMemberInfo(userId, email, newPwd, userName, gender, birthday, phone,
						pic, registerDate, gold, feed, monsterId, monsterNickName, lv, exp, sta);
			
				session.setAttribute("pwd", memberInfo.getPwd());
				session.setAttribute("memberInfo", memberInfo);
				System.out.println("bbb");
				// 3. �����ܮi�ܼh

				req.setAttribute("memberinfo", memberInfo); // ���Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/Gary_pages/Member02.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,����listOneEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member02.jsp");
				System.out.println("在這");
				e.printStackTrace();
				failureView.forward(req, res);
			}

		}

		/*************************************
		 會員註冊
		 ***************************************/

		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.?�收請�??�數 - 輸入?��??�錯誤�??? ************************/

				String email = req.getParameter("email");
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("電子郵件: 請勿空白");
				} else if (!email.trim().matches(emailReg)) { 
					errorMsgs.add("電子郵件: 不符合電子郵件命名規則");
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
				} else if (!pwd.trim().matches(pwdlReg)) {
					errorMsgs.add("密碼長度至少應該設定 8 碼以上，而且要混合大小寫英文字母、數字和特殊符號。");
				}

				String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("密碼: 請勿空白");
				} else if (pwd.equals(pwd2) == false) {
					errorMsgs.add("密碼: 兩次輸入不一樣");
				}

				java.sql.Date birthday = null;
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期");
				}

				String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("姓名: 請勿空白");
				} else if (!userName.trim().matches(enameReg)) { 
					errorMsgs.add("姓名: 請符合命名規則，中英文且不超過10字");
				}

				String gender = req.getParameter("gender");

				String phone = req.getParameter("phone");
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("電話號碼: 請勿空白");
				} else if (!phone.trim().matches(phoneReg)) { 
					errorMsgs.add("電話號碼:長度不超過10碼，且為09開頭");
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
					req.setAttribute("memberInfo", memberInfo); 
					req.setAttribute("memberInfo2", memberInfo2);
					RequestDispatcher failureView = req.getRequestDispatcher("/login/Login-custome-regist.jsp");
					failureView.forward(req, res);
					return;
				}

				/***************************
				 * 2.?��??��?資�?
				 ***************************************/
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone, null,
						registerDate, 0, 0, 1001, null, 1, 0, 2);
				HttpSession session = req.getSession();
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("memberInfo", memberInfo);

				/*************************** 3.?��?完�?,準�?轉交(Send the Success view) ***********/

				String url = "/pei_pages/monsterChoose.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ?��??��?後�?交vendor_meal_upload.jsp
				successView.forward(req, res);

				/*************************** ?��??�能?�錯誤�??? *********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("註冊失敗" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/login/Login-custome-regist.jsp");
				failureView.forward(req, res);
			}
		}

		/************************************
		 廠商註冊
		 ************************************/

		if ("insert2".equals(action)) { // 來自addEmp.jsp?��?��?

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.?�收請�??�數 - 輸入?��??�錯誤�??? ************************/

				String email = req.getParameter("email");
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("電子郵件: 請勿空白");
				} else if (!email.trim().matches(emailReg)) { 
					errorMsgs.add("電子郵件: 不符合電子郵件命名規則");
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
				} else if (!pwd.trim().matches(pwdlReg)) {
					errorMsgs.add("密碼長度至少應該設定 8 碼以上，而且要混合大小寫英文字母、數字和特殊符號。");
				}

				String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("密碼: 請勿空白");
				} else if (pwd.equals(pwd2) == false) {
					errorMsgs.add("密碼:兩次輸入不一樣");
				}

				java.sql.Date birthday = null;
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期");
				}

				String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("姓名: 請勿空白");
				} else if (!userName.trim().matches(enameReg)) { // 以�?練�?��??(��?表示��?regular-expression)
					errorMsgs.add("姓名: 請符合命名規則，中英文且不超過10字");
				}

				String gender = req.getParameter("gender");

				String phone = req.getParameter("phone");
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("電話號碼: 請勿空白");
				} else if (!phone.trim().matches(phoneReg)) { // 以�?練�?��??(��?表示��?regular-expression)
					errorMsgs.add("電話號碼:長度不超過10碼，且為09開頭");
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
					req.setAttribute("memberInfo", memberInfo);
					req.setAttribute("memberInfo2", memberInfo2);
					RequestDispatcher failureView = req.getRequestDispatcher("/pei_pages/vendor_restaurant_addInfo.jsp");
					failureView.forward(req, res);
					return;
				}

				/***************************
				 * 2.?��??��?資�?
				 ***************************************/
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone, null,
						registerDate, 0, 0, 1001, null, 1, 0, 4);
				// System.out.println("memberInfo="+memberInfo);
				HttpSession session = req.getSession();
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("memberInfo", memberInfo);

				/*************************** 3.?��?完�?,準�?轉交(Send the Success view) ***********/
				String url = "/pei_pages/vendor_restaurant_addInfo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ?��??��?後�?交vendor_meal_upload.jsp
				successView.forward(req, res);

				/*************************** ?��??�能?�錯誤�??? *********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("註冊失敗" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/login/Login-vendor-regist.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
