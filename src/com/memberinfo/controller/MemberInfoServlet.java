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
		
		
//		if ("getOne_For_Display".equals(action)) { // ä¾†è‡ªselect_page.jsp?„è?æ±?
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.?¥æ”¶è«‹æ??ƒæ•¸ - è¼¸å…¥?¼å??„éŒ¯èª¤è???*********************/
//				String str = req.getParameter("empno");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("è«‹è¼¸?¥å“¡å·¥ç·¨??);
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//ç¨‹å?ä¸­æ–·
//				}
//				
//				Integer empno = null;
//				try {
//					empno = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("?¡å·¥ç·¨è??¼å?ä¸æ­£ç¢?);
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//ç¨‹å?ä¸­æ–·
//				}
//				
//				/***************************2.?‹å??¥è©¢è³‡æ?*****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//				if (empVO == null) {
//					errorMsgs.add("?¥ç„¡è³‡æ?");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//ç¨‹å?ä¸­æ–·
//				}
//				
//				/***************************3.?¥è©¢å®Œæ?,æº–å?è½‰äº¤(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // è³‡æ?åº«å??ºç?empVO?©ä»¶,å­˜å…¥req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ?å?è½‰äº¤ listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************?¶ä??¯èƒ½?„éŒ¯èª¤è???************************************/
//			} catch (Exception e) {
//				errorMsgs.add("?¡æ??–å?è³‡æ?:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // ä¾†è‡ªlistAllEmp.jsp?„è?æ±?
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try {
//				/***************************1.?¥æ”¶è«‹æ??ƒæ•¸****************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.?‹å??¥è©¢è³‡æ?****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//								
//				/***************************3.?¥è©¢å®Œæ?,æº–å?è½‰äº¤(Send the Success view)************/
//				req.setAttribute("empVO", empVO);         // è³‡æ?åº«å??ºç?empVO?©ä»¶,å­˜å…¥req
//				String url = "/emp/update_emp_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// ?å?è½‰äº¤ update_emp_input.jsp
//				successView.forward(req, res);
//
//				/***************************?¶ä??¯èƒ½?„éŒ¯èª¤è???*********************************/
//			} catch (Exception e) {
//				errorMsgs.add("?¡æ??–å?è¦ä¿®?¹ç?è³‡æ?:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("update".equals(action)) { // ä¾†è‡ªupdate_emp_input.jsp?„è?æ±?
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				/***************************1.?¥æ”¶è«‹æ??ƒæ•¸ - è¼¸å…¥?¼å??„éŒ¯èª¤è???*********************/
//Integer empno = new Integer(req.getParameter("empno").trim());
//				
//String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("?¡å·¥å§“å?: è«‹å‹¿ç©ºç™½");
//				} else if(!ename.trim().matches(enameReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
//					errorMsgs.add("?¡å·¥å§“å?: ?ªèƒ½?¯ä¸­?è‹±?‡å?æ¯ã€æ•¸å­—å?_ , ä¸”é•·åº¦å??€????0ä¹‹é?");
//	            }
//				
//String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("?·ä?è«‹å‹¿ç©ºç™½");
//				}	
//				
//				java.sql.Date hiredate = null;
//				try {
//hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("è«‹è¼¸?¥æ—¥??");
//				}
//
//				Double sal = null;
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("?ªæ°´è«‹å¡«?¸å?.");
//				}
//
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("?é?è«‹å¡«?¸å?.");
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
//					req.setAttribute("empVO", empVO); // ?«æ?è¼¸å…¥?¼å??¯èª¤?„empVO?©ä»¶,ä¹Ÿå??¥req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //ç¨‹å?ä¸­æ–·
//				}
//				
//				/***************************2.?‹å?ä¿®æ”¹è³‡æ?*****************************************/
//				EmpService empSvc = new EmpService();
//				empVO = empSvc.updateEmp(empno, ename, job, hiredate, sal,comm, deptno);
//				
//				/***************************3.ä¿®æ”¹å®Œæ?,æº–å?è½‰äº¤(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // è³‡æ?åº«update?å?å¾?æ­?¢º?„ç?empVO?©ä»¶,å­˜å…¥req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ä¿®æ”¹?å?å¾?è½‰äº¤listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************?¶ä??¯èƒ½?„éŒ¯èª¤è???************************************/
//			} catch (Exception e) {
//				errorMsgs.add("ä¿®æ”¹è³‡æ?å¤±æ?:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/update_emp_input.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		if ("delete".equals(action)) { // ä¾†è‡ªlistAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.?¥æ”¶è«‹æ??ƒæ•¸***************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.?‹å??ªé™¤è³‡æ?***************************************/
//				EmpService empSvc = new EmpService();
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.?ªé™¤å®Œæ?,æº–å?è½‰äº¤(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// ?ªé™¤?å?å¾?è½‰äº¤?é€å‡º?ªé™¤?„ä?æºç¶²??
//				successView.forward(req, res);
//				
//				/***************************?¶ä??¯èƒ½?„éŒ¯èª¤è???*********************************/
//			} catch (Exception e) {
//				errorMsgs.add("?ªé™¤è³‡æ?å¤±æ?:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
		
		

		
//        if ("insert".equals(action)) { // ä¾†è‡ªaddEmp.jsp?„è?æ±? 
//
//		// List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//		//	req.setAttribute("errorMsgs", errorMsgs);
//			MemberInfoService memberSvc1 = new MemberInfoService();
//			MemberInfo member1 = memberSvc1.getOneMemberInfo(20210001);
//			req.setAttribute("memberinfo", member1);
//			String url = "/Gary_pages/Member01.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // ï¿½ï¿½ï¿½\ï¿½ï¿½ï¿?listOneEmp.jsp
//			successView.forward(req, res);
//		}
		
		/*************************************?ƒå“¡ä¸­å?***************************************/			
		
<<<<<<< HEAD
		if("getOnePwd".equals(action)) {

		// List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
		//	req.setAttribute("errorMsgs", errorMsgs);
			MemberInfoService memberSvc = new MemberInfoService();
			MemberInfo member = memberSvc.getOneMemberInfo(20210001);
			req.setAttribute("memberinfo", member);
			String url = "/Gary_pages/Member02.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ¦¨¥\Âà¥æ listOneEmp.jsp
			successView.forward(req, res);
		}
		

		
		if("update".equals(action)) {
			

			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 1. §ì¨úªí³æ¸ê®Æ¡A¿ù»~¸ê®Æ³B²z
			try {

				Integer userId = new Integer(req.getParameter("userId"));
				String userName = req.getParameter("userName");
				String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (userName == null || (userName.trim().length()) == 0) {
					errorMsgs.add("©m¦W: ½Ğ¤ÅªÅ¥Õ");
				} else if(!userName.trim().matches(userNameReg)) { //¥H¤U½m²ß¥¿«h(³W)ªí¥Ü¦¡(regular-expression)
					errorMsgs.add("©m¦W: ¥u¯à¬O¤¤¡B­^¤å¦r¥À¡B¼Æ¦r©M_ , ¥Bªø«×¥²»İ¦b2¨ì10¤§¶¡");
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
					errorMsgs.add("¹q¸Ü¸¹½X: ½Ğ¤ÅªÅ¥Õ");
				} else if(!phone.trim().matches(phoneReg)) { //¥H¤U½m²ß¥¿«h(³W)ªí¥Ü¦¡(regular-expression)
					errorMsgs.add("¹q¸Ü¸¹½X:¼Æ¦r , ¥Bªø«×¥²»İ¬°10¡A¶}ÀY¬°09¶}ÀY");					
	            }	

				// ¹Ï¤ù¤W¶Ç
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
					req.setAttribute("memberinfo", memberInfo); // §t¦³¿é¤J®æ¦¡¿ù»~ªºempVOª«¥ó,¤]¦s¤Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/Member01.jsp");
					failureView.forward(req, res);
					System.out.println("aaa");
					return;
				}

				// 2. «ù¤[¤Æ
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.updateMemberInfo(userId, email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, lv, exp, sta);
				System.out.println("bbb");
				// 3. Âà¥æ¦Ü®i¥Ü¼h

				req.setAttribute("memberinfo", memberInfo); // ¸ê®Æ®wupdate¦¨¥\«á,¥¿½TªºªºempVOª«¥ó,¦s¤Jreq
				String url = "/Gary_pages/Member01.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ­×§ï¦¨¥\«á,Âà¥ælistOneEmp.jsp
=======
		if("getOneEmail".equals(action)) {

			// List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
			//	req.setAttribute("errorMsgs", errorMsgs);
				MemberInfoService memberSvc2 = new MemberInfoService();
				MemberInfo member2 = memberSvc2.getOneMemberInfo(20210001);
				req.setAttribute("memberinfo", member2);
				String url = "/Gary_pages/Member01-email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ï¿½ï¿½ï¿½\ï¿½ï¿½ï¿?listOneEmp.jsp
>>>>>>> 5d662f9b8d90e736a64275d0e0da7de0477519a6
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/Member01.jsp");
				failureView.forward(req, res);
			}

		}
		
<<<<<<< HEAD
		if("updatePwd".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 1. §ì¨úªí³æ¸ê®Æ¡A¿ù»~¸ê®Æ³B²z
			try {
				
				Integer userId = new Integer(req.getParameter("userId"));
				String userName = req.getParameter("userName");
				String pwd = req.getParameter("pwd");
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

				
				String newPwd = req.getParameter("newpwd");
				String newPwdReg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
				if (newPwd == null || newPwd.trim().length() == 0) {
					errorMsgs.add("±K½X: ½Ğ¤ÅªÅ¥Õ");
				} else if(!newPwd.trim().matches(newPwdReg)) { 
					errorMsgs.add("±K½X: ±K½Xªø«×¦Ü¤ÖÀ³¸Ó³]©w 8 ½X¥H¤W¡A¦Ó¥B­n²V¦X¤j¤p¼g­^¤å¦r¥À¡B¼Æ¦r©M¯S®í²Å¸¹");
	            } 
//				else {
//	            	MemberInfoService memberInfoSvc1 = new MemberInfoService();
//	            	boolean MemberInfo= memberInfoSvc1.findByPwd(pwd);
//	            	
//	            	if (MemberInfo) {
////	            		System.out.println("¦³¸g¹L");
//	            		errorMsgs.add("¦¹±K½X»P·í«e±K½X­«½Æ¡A½Ğ­«·s¿é¤J");
//	            	}
//	            }
				
				String newPwd2 = req.getParameter("newpwd2");
				if (newPwd2 == null || newPwd2.trim().length() == 0) {
					errorMsgs.add("±K½X2: ½Ğ¤ÅªÅ¥Õ");
				} else if(newPwd.equals(newPwd2) == false) { 
					errorMsgs.add("±K½X: ±z¨â¦¸¿é¤J±K½X¤£¤@­P");
	            }
				
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
					req.setAttribute("memberinfo", memberInfo); // §t¦³¿é¤J®æ¦¡¿ù»~ªºempVOª«¥ó,¤]¦s¤Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/Member02.jsp");
					failureView.forward(req, res);
					System.out.println("aaa");
					return;
				}

				// 2. «ù¤[¤Æ
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.updateMemberInfo(userId, email, newPwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, lv, exp, sta);
				System.out.println("bbb");
				// 3. Âà¥æ¦Ü®i¥Ü¼h

				req.setAttribute("memberinfo", memberInfo); // ¸ê®Æ®wupdate¦¨¥\«á,¥¿½TªºªºempVOª«¥ó,¦s¤Jreq
				String url = "/Gary_pages/Member02.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ­×§ï¦¨¥\«á,Âà¥ælistOneEmp.jsp
=======
		if("getOnePhone".equals(action)) {

			// List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
			//	req.setAttribute("errorMsgs", errorMsgs);
				MemberInfoService memberSvc3 = new MemberInfoService();
				MemberInfo member3 = memberSvc3.getOneMemberInfo(20210001);
				req.setAttribute("memberinfo", member3);
				String url = "/Gary_pages/Member01-phone.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ï¿½ï¿½ï¿½\ï¿½ï¿½ï¿?listOneEmp.jsp
>>>>>>> 5d662f9b8d90e736a64275d0e0da7de0477519a6
				successView.forward(req, res);

			
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/Member02.jsp");
				failureView.forward(req, res);
			}
			
		}
		
<<<<<<< HEAD

		
        if ("insert".equals(action)) { // ¨Ó¦ÛaddEmp.jspªº½Ğ¨D  
			
=======
		
/*************************************?ƒå“¡è¨»å?***************************************/		
		
        if ("insert".equals(action)) { 

>>>>>>> 5d662f9b8d90e736a64275d0e0da7de0477519a6
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
		/***********************1.?¥æ”¶è«‹æ??ƒæ•¸ - è¼¸å…¥?¼å??„éŒ¯èª¤è???************************/

String email = req.getParameter("email");
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("?»å??µä»¶: è«‹å‹¿ç©ºç™½");
				} else if(!email.trim().matches(emailReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
					errorMsgs.add("?»å??µä»¶: ä¸ç¬¦?ˆé›»å­éƒµä»¶å‘½?è?ç¯?);
	            } else {
	            	MemberInfoService memberInfoSvc = new MemberInfoService();
	            	boolean MemberInfo = memberInfoSvc.findByEmail(email);
	            	
	            	if (MemberInfo) {
	            		errorMsgs.add("æ­¤å¸³?Ÿå·²è¨»å?");
	            	}	            	
	            }
				
				
String pwd = req.getParameter("pwd");
				String pwdlReg = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
				if (pwd == null || pwd.trim().length() == 0) {
					errorMsgs.add("å¯†ç¢¼: è«‹å‹¿ç©ºç™½");
				} else if(!pwd.trim().matches(pwdlReg)) { 
					errorMsgs.add("å¯†ç¢¼: å¯†ç¢¼?·åº¦?³å??‰è©²è¨­å? 8 ç¢¼ä»¥ä¸Šï??Œä?è¦æ··?ˆå¤§å°å¯«?±æ?å­—æ??æ•¸å­—å??¹æ?ç¬¦è?");
	            }
				
				
String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("å¯†ç¢¼2: è«‹å‹¿ç©ºç™½");
				} else if(pwd.equals(pwd2) == false) { 
					errorMsgs.add("å¯†ç¢¼: ?¨å…©æ¬¡è¼¸?¥å?ç¢¼ä?ä¸€??);
	            }
				
				
				java.sql.Date birthday = null;
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("è«‹è¼¸?¥æ—¥??");
				}
				
				
String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("å§“å?: è«‹å‹¿ç©ºç™½");
				} else if(!userName.trim().matches(enameReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
					errorMsgs.add("å§“å?: ?ªèƒ½?¯ä¸­?è‹±?‡å?æ¯ã€æ•¸å­—å?_ , ä¸”é•·åº¦å??€????0ä¹‹é?");
	            }
				
				
String gender = req.getParameter("gender");

String phone = req.getParameter("phone");		
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("?»è©±?Ÿç¢¼: è«‹å‹¿ç©ºç™½");
				} else if(!phone.trim().matches(phoneReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
					errorMsgs.add("?»è©±?Ÿç¢¼:?¸å? , ä¸”é•·åº¦å??€??0ï¼Œé??­ç‚º09?‹é ­");					
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
					req.setAttribute("memberInfo", memberInfo); // ?«æ?è¼¸å…¥?¼å??¯èª¤?„empVO?©ä»¶,ä¹Ÿå??¥req
					req.setAttribute("memberInfo2", memberInfo2);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/login/Login-custome-regist.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.?‹å??°å?è³‡æ?***************************************/			
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone,null,registerDate,0,0,1001,null,1,0,1);
				HttpSession session = req.getSession();
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("memberInfo", memberInfo);
				
				/***************************3.?°å?å®Œæ?,æº–å?è½‰äº¤(Send the Success view)***********/
				
				String url = "/pei_pages/monsterChoose.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ?°å??å?å¾Œè?äº¤vendor_meal_upload.jsp
				successView.forward(req, res);				
				
				/***************************?¶ä??¯èƒ½?„éŒ¯èª¤è???*********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("è¨»å?å¤±æ?:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/login/Login-custome-regist.jsp");
				failureView.forward(req, res);
			}
		}
		
        
/************************************å» å?è¨»å?************************************/
		
        if ("insert2".equals(action)) { // ä¾†è‡ªaddEmp.jsp?„è?æ±? 
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
		/***********************1.?¥æ”¶è«‹æ??ƒæ•¸ - è¼¸å…¥?¼å??„éŒ¯èª¤è???************************/

String email = req.getParameter("email");
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("?»å??µä»¶: è«‹å‹¿ç©ºç™½");
				} else if(!email.trim().matches(emailReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
					errorMsgs.add("?»å??µä»¶: ä¸ç¬¦?ˆé›»å­éƒµä»¶å‘½?è?ç¯?);
	            } else {
	            	MemberInfoService memberInfoSvc = new MemberInfoService();
	            	boolean MemberInfo = memberInfoSvc.findByEmail(email);
	            	
	            	if (MemberInfo) {
	            		errorMsgs.add("æ­¤å¸³?Ÿå·²è¨»å?");
	            	}	            	
	            }
				
				
String pwd = req.getParameter("pwd");
				String pwdlReg = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
				if (pwd == null || pwd.trim().length() == 0) {
					errorMsgs.add("å¯†ç¢¼: è«‹å‹¿ç©ºç™½");
				} else if(!pwd.trim().matches(pwdlReg)) { 
					errorMsgs.add("å¯†ç¢¼: å¯†ç¢¼?·åº¦?³å??‰è©²è¨­å? 8 ç¢¼ä»¥ä¸Šï??Œä?è¦æ··?ˆå¤§å°å¯«?±æ?å­—æ??æ•¸å­—å??¹æ?ç¬¦è?");
	            }
				
				
String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("å¯†ç¢¼2: è«‹å‹¿ç©ºç™½");
				} else if(pwd.equals(pwd2) == false) { 
					errorMsgs.add("å¯†ç¢¼: ?¨å…©æ¬¡è¼¸?¥å?ç¢¼ä?ä¸€??);
	            }
				
				
				java.sql.Date birthday = null;
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("è«‹è¼¸?¥æ—¥??");
				}
				
				
String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("å§“å?: è«‹å‹¿ç©ºç™½");
				} else if(!userName.trim().matches(enameReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
					errorMsgs.add("å§“å?: ?ªèƒ½?¯ä¸­?è‹±?‡å?æ¯ã€æ•¸å­—å?_ , ä¸”é•·åº¦å??€????0ä¹‹é?");
	            }
				
				
String gender = req.getParameter("gender");

String phone = req.getParameter("phone");		
				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("?»è©±?Ÿç¢¼: è«‹å‹¿ç©ºç™½");
				} else if(!phone.trim().matches(phoneReg)) { //ä»¥ä?ç·´ç?æ­??(è¦?è¡¨ç¤ºå¼?regular-expression)
					errorMsgs.add("?»è©±?Ÿç¢¼:?¸å? , ä¸”é•·åº¦å??€??0ï¼Œé??­ç‚º09?‹é ­");					
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
					req.setAttribute("memberInfo", memberInfo); // ?«æ?è¼¸å…¥?¼å??¯èª¤?„empVO?©ä»¶,ä¹Ÿå??¥req
					req.setAttribute("memberInfo2", memberInfo2);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/login/Login-vendor-regist.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.?‹å??°å?è³‡æ?***************************************/			
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone,null,registerDate,0,0,1001,null,1,0,4);
				//System.out.println("memberInfo="+memberInfo);
				HttpSession session = req.getSession();
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("memberInfo", memberInfo);
				
				
				/***************************3.?°å?å®Œæ?,æº–å?è½‰äº¤(Send the Success view)***********/
				String url = "/pei_pages/vendor_restaurant_addInfo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ?°å??å?å¾Œè?äº¤vendor_meal_upload.jsp
				successView.forward(req, res);				
				
				/***************************?¶ä??¯èƒ½?„éŒ¯èª¤è???*********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("è¨»å?å¤±æ?:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/login/Login-vendor-regist.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
