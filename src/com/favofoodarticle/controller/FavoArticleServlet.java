package com.favofoodarticle.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.favofoodarticle.model.*;

@WebServlet("/favofoodarticle/FavoArticle.do")
public class FavoArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		

		
		if("insertFavoArticle".equals(action)) {
						
			Integer articleNo = new Integer(req.getParameter("articleNo"));
			Integer userId = new Integer(req.getParameter("userId"));
			
//			System.out.println("articleNo"+articleNo);
//			System.out.println("userId"+userId);
			
			FavoFoodArticleService favoarSc =new FavoFoodArticleService();
			FavoFoodArticleVO favfooVO = favoarSc.addFavoFoodArticle(userId, articleNo);
			
			
			
			
		}
	
	}
}