package com.memberinfo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.achieve.model.Achieve;
import com.achieve.model.AchieveService;
import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/loginhandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 【檢查使用者輸入的帳號(email) 密碼(pwd)是否有效】
	// 【實際上應至資料庫搜尋比對】

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		/*	============= 在首次選取怪獸頁面之後，將預設的2004成就任務放入ServletContext==============  */
		
		AchieveService achieveSvc = new AchieveService();
		Achieve achieveVO = achieveSvc.getOneAchieve(2004);
		ServletContext servletContext = this.getServletContext();
		
		if(servletContext.getAttribute("achieveMission") == null) {
			servletContext.setAttribute("achieveMission", achieveVO);
		} 	
/*	============================================================================  */	
		
		
		
		PrintWriter out = res.getWriter();

		// 【取得使用者 帳號(email) 密碼(pwd)】
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");

		MemberInfoService memberInfoSvc = new MemberInfoService();
		boolean memberInfo = memberInfoSvc.findByEmail(email);

		MemberInfoService memberInfoSvc2 = new MemberInfoService();
		MemberInfo memberInfo2 = memberInfoSvc2.findByEmail2(email, pwd);

		// 【檢查該帳號 , 密碼是否有效】
// 【帳號無效時】
		if (!memberInfo) {
			out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
			out.println("<BODY>帳號不存在!<BR>");
			out.println("請按此重新登入 <A HREF=" + req.getContextPath() + "/login/Login-login.jsp>重新登入</A>");
			out.println("</BODY></HTML>");
// 【密碼無效時】	
		} else if (memberInfo2 == null) { 
			out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
			out.println("<BODY>密碼錯誤!<BR>");
			out.println("請按此重新登入 <A HREF=" + req.getContextPath() + "/login/Login-login.jsp>重新登入</A>");
			out.println("</BODY></HTML>");
// 【轉會員】			
		 
		} else if (memberInfo2.getSta().equals(2)||memberInfo2.getSta().equals(1)) { 
			Integer userId = memberInfo2.getUserId();
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			session.setAttribute("userId", userId);
			session.setAttribute("memberInfo", memberInfo2);
			
			String location = (String) session.getAttribute("location");
//*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
			if (location != null) {
				session.removeAttribute("location"); // 
				res.sendRedirect(location);
				return;
			} else {
				res.sendRedirect(req.getContextPath() + "/home.jsp"); 															// (-->如無來源網頁:則重導至login_success.jsp)
			}
// 【轉廠商】			
		} else if (memberInfo2.getSta().equals(4) || memberInfo2.getSta().equals(5)) { 
			Integer userId = memberInfo2.getUserId();
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			session.setAttribute("userId", userId);
			session.setAttribute("memberInfo", memberInfo2);

			String location = (String) session.getAttribute("location");
			if (location != null) {
				session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
				res.sendRedirect(location);
				return;
			} else {
				res.sendRedirect(req.getContextPath() + "/pei_pages/vendor_restaurant_updateInfo.jsp"); 														// (-->如無來源網頁:則重導至login_success.jsp)
			}
		}
	}
}