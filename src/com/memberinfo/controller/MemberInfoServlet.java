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
@MultipartConfig
public class MemberInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
//		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				String str = req.getParameter("empno");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("�п�J���u�s��");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				Integer empno = null;
//				try {
//					empno = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("���u�s���榡�����T");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************2.�}�l�d�߸��*****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//				if (empVO == null) {
//					errorMsgs.add("�d�L���");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/select_page.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
//				
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // ��Ʈw���X��empVO����,�s�Jreq
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�L�k���o���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try {
//				/***************************1.�����ШD�Ѽ�****************************************/
//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.�}�l�d�߸��****************************************/
//				EmpService empSvc = new EmpService();
//				EmpVO empVO = empSvc.getOneEmp(empno);
//								
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
//				req.setAttribute("empVO", empVO);         // ��Ʈw���X��empVO����,�s�Jreq
//				String url = "/emp/update_emp_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//		
//		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//Integer empno = new Integer(req.getParameter("empno").trim());
//				
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
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("�~���ж�Ʀr.");
//				}
//
//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("�����ж�Ʀr.");
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
//					req.setAttribute("empVO", empVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�ק���*****************************************/
//				EmpService empSvc = new EmpService();
//				empVO = empSvc.updateEmp(empno, ename, job, hiredate, sal,comm, deptno);
//				
//				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
//				req.setAttribute("empVO", empVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/update_emp_input.jsp");
//				failureView.forward(req, res);
//			}
//		}
		if("getOne".equals(action)) {

		// List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
		//	req.setAttribute("errorMsgs", errorMsgs);
			MemberInfoService memberSvc1 = new MemberInfoService();
			MemberInfo member1 = memberSvc1.getOneMemberInfo(20210001);
			req.setAttribute("memberinfo", member1);
			String url = "/Gary_pages/Member01.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if("getOnePwd".equals(action)) {

		// List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
		//	req.setAttribute("errorMsgs", errorMsgs);
			MemberInfoService memberSvc = new MemberInfoService();
			MemberInfo member = memberSvc.getOneMemberInfo(20210001);
			req.setAttribute("memberinfo", member);
			String url = "/Gary_pages/Member02.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
		

		
		if("update".equals(action)) {
			

			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 1. �������ơA���~��ƳB�z
			try {

				Integer userId = new Integer(req.getParameter("userId"));
				String userName = req.getParameter("userName");
				String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (userName == null || (userName.trim().length()) == 0) {
					errorMsgs.add("�m�W: �ФŪť�");
				} else if(!userName.trim().matches(userNameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
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
				} else if(!phone.trim().matches(phoneReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
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
					req.setAttribute("memberinfo", memberInfo); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/Member01.jsp");
					failureView.forward(req, res);
					System.out.println("aaa");
					return;
				}

				// 2. ���[��
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.updateMemberInfo(userId, email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, lv, exp, sta);
				System.out.println("bbb");
				// 3. ���ܮi�ܼh

				req.setAttribute("memberinfo", memberInfo); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/Gary_pages/Member01.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/Member01.jsp");
				failureView.forward(req, res);
			}

		}
		
		if("updatePwd".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 1. �������ơA���~��ƳB�z
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
					errorMsgs.add("�K�X: �ФŪť�");
				} else if(!newPwd.trim().matches(newPwdReg)) { 
					errorMsgs.add("�K�X: �K�X���צܤ����ӳ]�w 8 �X�H�W�A�ӥB�n�V�X�j�p�g�^��r���B�Ʀr�M�S��Ÿ�");
	            } 
//				else {
//	            	MemberInfoService memberInfoSvc1 = new MemberInfoService();
//	            	boolean MemberInfo= memberInfoSvc1.findByPwd(pwd);
//	            	
//	            	if (MemberInfo) {
////	            		System.out.println("���g�L");
//	            		errorMsgs.add("���K�X�P��e�K�X���ơA�Э��s��J");
//	            	}
//	            }
				
				String newPwd2 = req.getParameter("newpwd2");
				if (newPwd2 == null || newPwd2.trim().length() == 0) {
					errorMsgs.add("�K�X2: �ФŪť�");
				} else if(newPwd.equals(newPwd2) == false) { 
					errorMsgs.add("�K�X: �z�⦸��J�K�X���@�P");
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
					req.setAttribute("memberinfo", memberInfo); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/Gary_pages/Member02.jsp");
					failureView.forward(req, res);
					System.out.println("aaa");
					return;
				}

				// 2. ���[��
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.updateMemberInfo(userId, email, newPwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, lv, exp, sta);
				System.out.println("bbb");
				// 3. ���ܮi�ܼh

				req.setAttribute("memberinfo", memberInfo); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/Gary_pages/Member02.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);

			
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Gary_pages/Member02.jsp");
				failureView.forward(req, res);
			}
			
		}
		

		
        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
//			System.out.println("1="+errorMsgs);
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				

				
				
				



//				Integer empno = new Integer(req.getParameter("empno"));
//				
//				/***************************2.�}�l�d�߸��****************************************/

				
				
		
//				System.out.println(MemberInfo3);
				

				String email = req.getParameter("email");
				
	
				String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("�q�l�l��: �ФŪť�");
				} else if(!email.trim().matches(emailReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�q�l�l��: ���ŦX�q�l�l��R�W�W�d");
	            } else {
	            	MemberInfoService memberInfoSvc3 = new MemberInfoService();
	            	boolean MemberInfo3 = memberInfoSvc3.findByEmail(email);
	            	
	            	if (MemberInfo3) {
	            		System.out.println("���g�L");
	            		errorMsgs.add("���b���w���U");
	            	}	            	
	            }
				
				
				
				String pwd = req.getParameter("pwd");
				String pwdlReg = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
				if (pwd == null || pwd.trim().length() == 0) {
					errorMsgs.add("�K�X: �ФŪť�");
				} else if(!pwd.trim().matches(pwdlReg)) { 
					errorMsgs.add("�K�X: �K�X���צܤ����ӳ]�w 8 �X�H�W�A�ӥB�n�V�X�j�p�g�^��r���B�Ʀr�M�S��Ÿ�");
	            }
				
				String pwd2 = req.getParameter("pwd2");
				if (pwd2 == null || pwd2.trim().length() == 0) {
					errorMsgs.add("�K�X2: �ФŪť�");
				} else if(pwd.equals(pwd2) == false) { 
					errorMsgs.add("�K�X: �z�⦸��J�K�X���@�P");
	            }
				
				java.sql.Date birthday = null;
				
				try {
					birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
				} catch (IllegalArgumentException e) {
					birthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}
				
				String userName = req.getParameter("userName");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (userName == null || userName.trim().length() == 0) {
					errorMsgs.add("�m�W: �ФŪť�");
				} else if(!userName.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				String gender = req.getParameter("gender");
				String phone = req.getParameter("phone");

				String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("�q�ܸ��X: �ФŪť�");
				} else if(!phone.trim().matches(phoneReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�q�ܸ��X:�Ʀr , �B���ץ��ݬ�10�A�}�Y��09�}�Y");					
	            }	
				
				

				java.sql.Date registerDate = new java.sql.Date(System.currentTimeMillis());
				
				MemberInfo memberInfo2 = new MemberInfo();
				memberInfo2.setPwd(pwd2);
				
				MemberInfo memberInfo = new MemberInfo();
				//System.out.println("memberInfo="+memberInfo);
				memberInfo.setEmail(email);
				memberInfo.setPwd(pwd);
				memberInfo.setUserName(userName);
				memberInfo.setGender(gender);
				memberInfo.setBirthday(birthday);
				memberInfo.setPhone(phone);
				memberInfo.setRegisterDate(registerDate);

				// Send the use back to the form, if there were errors
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberInfo", memberInfo); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/login/Login-custome-regist.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
//				MemberInfoService memberInfoServiceSvc = new MemberInfoService();
//				memberInfo = memberInfoServiceSvc.addMemberInfo(memberInfo);
				
				MemberInfoService memberInfoSvc = new MemberInfoService();
				memberInfo = memberInfoSvc.addMemberInfo(email, pwd, userName, gender, birthday, phone,null,registerDate,0,0,1001,null,1,0,1);
//				System.out.println(memberInfo.toString());
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/pei_pages/vendor_meal_upload.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����vendor_meal_upload.jsp
				//System.out.println("successView=" + successView);
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("���U����:"+e.getMessage());
//				System.out.println("2="+errorMsgs);
//				System.out.println(e);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/login/Login-custome-regist.jsp");
				failureView.forward(req, res);
			}
		}
		
		
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
