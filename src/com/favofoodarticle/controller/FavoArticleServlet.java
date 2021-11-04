package com.favofoodarticle.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.favofoodarticle.model.*;
import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;


@WebServlet("/favofoodarticle/FavoArticle.do")
public class FavoArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		

		System.out.println(action);
//		FavoFoodArticleService favofoodarticleSvc = new FavoFoodArticleService();
//		Set<FavoFoodArticleVO> favofoodarticleset = favofoodarticleSvc.getAllFavoFoodArticleByUserId(20210001);
//		System.out.println(favofoodarticleset);
		
		
		
			Integer articleNo = new Integer(req.getParameter("articleNo"));
			Integer userId = new Integer(req.getParameter("userId"));						
			
			System.out.println("articleNo"+articleNo);
			System.out.println("userId"+userId);
			
			FavoFoodArticleService favoarSc =new FavoFoodArticleService();
			FavoFoodArticleVO favfooVO = favoarSc.addFavoFoodArticle(userId, articleNo);
		
			
//			if ("getAllFavoFoodArticle".equals(action)) {
//				
//				MemberInfoService memberSvc = new MemberInfoService();
//				HttpSession session = req.getSession();
//				MemberInfo mem = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
//				req.setAttribute("memberinfo", mem);
//				
//				
//				Integer member = mem.getUserId();
//				FavoFoodArticleService favofoodarticleSvc = new FavoFoodArticleService();
//				Set<FavoFoodArticleVO> favofoodarticleset = favofoodarticleSvc.getAllFavoFoodArticleByUserId(member);
//				req.setAttribute("favofoodarticleset", favofoodarticleset);
//				String url = "/Gary_pages/Member07.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
//				successView.forward(req, res);
//				
//				
//			}
		
		
			
			
			
		
	
	}
}



