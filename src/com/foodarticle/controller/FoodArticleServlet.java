package com.foodarticle.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.foodarticle.model.*;

public class FoodArticleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException{
        		
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");/*��html��action�ݩʥΦr���ܼƱ���*/
			
/*��user�b�e�ݫ�"�e�X"��,�e�ШD�i��,�P�_user�e���Ȧ��L�ŦX�]�w*/
			
			if("getOne_For_Display".equals(action)){//from select_pageFA���ШD
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs",errorMsgs);
			//	System.out.println(action);
			
				try {
				
					String str = req.getParameter("articleNo");
						if(str==null || (str.trim()).length()==0) {
							errorMsgs.add("�п�J�峹�s��");
						}
						
						if(!errorMsgs.isEmpty()) {
							RequestDispatcher falureView = req.getRequestDispatcher("/select_pageFA.jsp");
							falureView.forward(req,res);
							return;
						}
						
						Integer articleNo = null;
						try {
							articleNo = new Integer(str);
							
						}catch(Exception e) {
							errorMsgs.add("�峹�s���榡����");
						}
						
						if(!errorMsgs.isEmpty()) {
							RequestDispatcher falureView = req.getRequestDispatcher("/select_pageFA.jsp");
							falureView.forward(req,res);
							return;//�{�����_
						}
			/*-------------------------�d�L���-----------------------------*/
						FoodArticleService faSC = new FoodArticleService();
						FoodArticleVO faVO = faSC.getOneArticle(articleNo) ;
						if(faVO ==null) {
							errorMsgs.add("�d�L���");
						}
						
						if(!errorMsgs.isEmpty()) {
							RequestDispatcher falureView = req.getRequestDispatcher("/select_pageFA.jsp");
							falureView.forward(req,res);
							return;//�{�����_
						}
			/*-------------------------�d�����,�ǳưe���e��-----------------------------*/	
						req.setAttribute("faVO", faVO);
						RequestDispatcher successView = req.getRequestDispatcher("/listoneFA.jsp");//��浹listoneFA
						successView.forward(req, res);
		  
						/*-------------------------��L���~-----------------------------*/			
				}catch(Exception e) {
					errorMsgs.add("�L�k���o���"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/listallFA.jsp");
					failureView.forward(req, res);
				 }
			
			}
			
			if("getOne_For_Update".equals(action)) {//from listallFA���ШD
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				//System.out.println("�{���]��o1");
				try {
					Integer articleNo = new Integer(req.getParameter("articleNo"));
					
					FoodArticleService faSvc = new FoodArticleService();
					FoodArticleVO faVO = faSvc.getOneArticle(articleNo);
					//System.out.println("�{���]��o2");
					
					req.setAttribute("faVO",faVO);
					String url = "/updateFA.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);//���updateFA.jsp
					successView.forward(req, res);
					//System.out.println("�{���]��o3");
	/*-------------��L���~�B�z----------*/				
				}catch(Exception e ) {
					errorMsgs.add("�L�k���o�n�ק諸���:"+e.getMessage());
					RequestDispatcher failure = req.getRequestDispatcher("/listallFA.jsp");
					failure.forward(req,res);
					//System.out.println("�{���]��o4");
				 }
			}
			
			if("update".equals(action)) {
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
//System.out.println("update");
				
				/*�ˬd�e�ݿ�J����Ʀ��S���ŦX�W�w*/	
				try {
					Integer articleNo = new Integer(req.getParameter("articleNo").trim());
//			System.out.println("1112"+articleNo);
					String rule = "^[1-9]{5}$";
					
					Integer userId =new Integer((req.getParameter("userId").trim()));
			//System.out.println("hello"+userId);
//					Integer userIdCheck= null;
//					if(userId == null || (userId.length()) ==0 ) {
//						errorMsgs.add("�|��id: �ФŪť�");
//					}else if(!userId.matches(rule)){
//						errorMsgs.add("�|��id�u��O4�ӼƦr");
//					}else {
//					    userIdCheck =new Integer(userId);
//					}				
//			System.out.println(userId);
					
					String restaurantId = (req.getParameter("restaurantId").trim());
//			System.out.println(restaurantId);
					Integer resIdCheck = null;
					if(restaurantId == null || (restaurantId.length()) ==0 ) {
						errorMsgs.add("�\�Uid: �ФŪť�");
					}else if(!restaurantId.matches(rule)){
						errorMsgs.add("�\�Uid�u��O5�ӼƦr");
					}else {
						resIdCheck = new Integer(restaurantId);
					}
					
					String articleTitle = (req.getParameter("articleTitle")).trim();
					if(articleTitle == null || (articleTitle.length()) ==0 ) {
						errorMsgs.add("���D: �ФŪť�");
					}
					
					java.sql.Date articleDate = null;
					try {
						articleDate = java.sql.Date.valueOf((req.getParameter("articleDate")).trim());
					}catch(IllegalArgumentException e ) {
						articleDate = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("�п�ܤ��");
					}
					
					String articleContent = req.getParameter("articleContent");
					if(articleContent == null || (articleContent.trim().length()) ==0 ) {
						errorMsgs.add("���e: �ФŪť�");
					}
					
					Integer sta = new Integer(req.getParameter("sta"));
					
					
					FoodArticleVO faVO = new FoodArticleVO();
					faVO.setArticleNo(articleNo);
					faVO.setUserId(userId);
					faVO.setRestaurantId(resIdCheck);
					faVO.setArticleTitle(articleTitle);
					faVO.setArticleDate(articleDate);
					faVO.setArticleContent(articleContent);
					faVO.setSta(sta);
					
//System.out.println(articleNo);
//System.out.println(userId);
//System.out.println(resIdCheck);
//System.out.println(articleTitle);
//System.out.println(articleDate);
//System.out.println(articleContent);
//System.out.println(sta);				
					
/*�p�Guser��s����ƫ��e�X,���ˬd����~,�|�h�^��s����,����L�B���T����Ʒ|�Q�O�d�b�����W*/				
					if(!errorMsgs.isEmpty()) {
						req.setAttribute("faVO", faVO);
						RequestDispatcher failure = req.getRequestDispatcher("/updateFA.jsp");
						failure.forward(req,res);
						return;
					}
	/*�}�l�ק���*/			
					FoodArticleService faSVC = new FoodArticleService();
					faVO = faSVC.updateFoodArticle(articleNo, userId, resIdCheck, articleTitle, articleDate, articleContent, sta);
	/*�ק粒���ǳ����*/	
					
					req.setAttribute("faVO",  faVO);
					RequestDispatcher successView = req.getRequestDispatcher("/listoneFA.jsp");
					successView.forward(req,res);
					
				}catch(Exception e) {
					errorMsgs.add("�ק��ƥ���:"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/updateFA.jsp");
					failureView.forward(req,res);
				}
			}
/*�s�W��ƪ��ШD*/			
			if("insert".equals(action)) {
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					String userId =(req.getParameter("userId")).trim();
					String rule1 = "^[1-9]{4}$";
					Integer userIdCheck= null;
					if(userId == null || (userId.length()) ==0 ) {
						errorMsgs.add("�|��id: �ФŪť�");
					}else if(!userId.matches(rule1)){
						errorMsgs.add("�|��id�u��O4�ӼƦr");
					}else {
					    userIdCheck =new Integer(userId);
					}
					String rule2 = "^[1-9]{5}$";
					String restaurantId = (req.getParameter("restaurantId").trim());
					Integer resIdCheck = null;
					if(restaurantId == null || (restaurantId.length()) ==0 ) {
						errorMsgs.add("�\�Uid: �ФŪť�");
					}else if(!restaurantId.matches(rule2)){
						errorMsgs.add("�\�Uid�u��O5�ӼƦr");
					}else {
						resIdCheck = new Integer(restaurantId);
					}
					
					String articleTitle = (req.getParameter("articleTitle")).trim();
					if(articleTitle == null || (articleTitle.length()) ==0 ) {
						errorMsgs.add("���D: �ФŪť�");
					}
					
					java.sql.Date articleDate = null;
					try {
						articleDate = java.sql.Date.valueOf((req.getParameter("articleDate")).trim());
					}catch(IllegalArgumentException e ) {
						articleDate = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("�п�ܤ��");
					}
					
					String articleContent = req.getParameter("articleContent");
					if(articleContent == null || (articleContent.trim().length()) ==0 ) {
						errorMsgs.add("���e: �ФŪť�");
					}
					
					Integer sta = new Integer(req.getParameter("sta"));
					
					FoodArticleVO faVO = new FoodArticleVO();
					faVO.setUserId(userIdCheck);
					faVO.setRestaurantId(resIdCheck);
					faVO.setArticleTitle(articleTitle);
					faVO.setArticleDate(articleDate);
					faVO.setArticleContent(articleContent);
					faVO.setSta(sta);
					
		
//			
					
					
					if(!errorMsgs.isEmpty()) {
					req.setAttribute("faVO", faVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/addFA.jsp");
					failureView.forward(req, res);
					return;
					}
					
					FoodArticleService faSvc = new FoodArticleService();
					faVO = faSvc.addFoodArticle(userIdCheck, resIdCheck, articleTitle, articleDate, articleContent, sta);
					
					RequestDispatcher successView = req.getRequestDispatcher("/listallFA.jsp");
					successView.forward(req,res);														
					
				}catch(Exception e){
					errorMsgs.add("�s�W��ƥ���"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/addFA.jsp");
					failureView.forward(req, res);
				}
			}
			
			if("delete".equals(action)) {
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs",errorMsgs );
				
				try {
					
					Integer articleNo = new Integer(req.getParameter("articleNo"));
					
					FoodArticleService faSvc = new FoodArticleService();
					faSvc.deleteFoodArticle(articleNo);
					
					RequestDispatcher successView = req.getRequestDispatcher("/listallFA.jsp");
					successView.forward(req,res);
				}catch(Exception e) {
					errorMsgs.add("��ƧR������"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/listallFA.jsp");
					failureView.forward(req,res);
					
				}
			}

	}
}