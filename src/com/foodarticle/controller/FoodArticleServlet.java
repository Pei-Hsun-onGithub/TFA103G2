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
			String action = req.getParameter("action");/*抓html的action屬性用字串變數接值*/
			
/*當user在前端按"送出"鍵,送請求進來,判斷user送的值有無符合設定*/
			
			if("getOne_For_Display".equals(action)){//from select_pageFA的請求
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs",errorMsgs);
			//	System.out.println(action);
			
				try {
				
					String str = req.getParameter("articleNo");
						if(str==null || (str.trim()).length()==0) {
							errorMsgs.add("請輸入文章編號");
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
							errorMsgs.add("文章編號格式不對");
						}
						
						if(!errorMsgs.isEmpty()) {
							RequestDispatcher falureView = req.getRequestDispatcher("/select_pageFA.jsp");
							falureView.forward(req,res);
							return;//程式中斷
						}
			/*-------------------------查無資料-----------------------------*/
						FoodArticleService faSC = new FoodArticleService();
						FoodArticleVO faVO = faSC.getOneArticle(articleNo) ;
						if(faVO ==null) {
							errorMsgs.add("查無資料");
						}
						
						if(!errorMsgs.isEmpty()) {
							RequestDispatcher falureView = req.getRequestDispatcher("/select_pageFA.jsp");
							falureView.forward(req,res);
							return;//程式中斷
						}
			/*-------------------------查有資料,準備送給前端-----------------------------*/	
						req.setAttribute("faVO", faVO);
						RequestDispatcher successView = req.getRequestDispatcher("/listoneFA.jsp");//轉交給listoneFA
						successView.forward(req, res);
		  
						/*-------------------------其他錯誤-----------------------------*/			
				}catch(Exception e) {
					errorMsgs.add("無法取得資料"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/listallFA.jsp");
					failureView.forward(req, res);
				 }
			
			}
			
			if("getOne_For_Update".equals(action)) {//from listallFA的請求
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				//System.out.println("程式跑到這1");
				try {
					Integer articleNo = new Integer(req.getParameter("articleNo"));
					
					FoodArticleService faSvc = new FoodArticleService();
					FoodArticleVO faVO = faSvc.getOneArticle(articleNo);
					//System.out.println("程式跑到這2");
					
					req.setAttribute("faVO",faVO);
					String url = "/updateFA.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);//轉交updateFA.jsp
					successView.forward(req, res);
					//System.out.println("程式跑到這3");
	/*-------------其他錯誤處理----------*/				
				}catch(Exception e ) {
					errorMsgs.add("無法取得要修改的資料:"+e.getMessage());
					RequestDispatcher failure = req.getRequestDispatcher("/listallFA.jsp");
					failure.forward(req,res);
					//System.out.println("程式跑到這4");
				 }
			}
			
			if("update".equals(action)) {
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
//System.out.println("update");
				
				/*檢查前端輸入的資料有沒有符合規定*/	
				try {
					Integer articleNo = new Integer(req.getParameter("articleNo").trim());
//			System.out.println("1112"+articleNo);
					String rule = "^[1-9]{5}$";
					
					Integer userId =new Integer((req.getParameter("userId").trim()));
			//System.out.println("hello"+userId);
//					Integer userIdCheck= null;
//					if(userId == null || (userId.length()) ==0 ) {
//						errorMsgs.add("會員id: 請勿空白");
//					}else if(!userId.matches(rule)){
//						errorMsgs.add("會員id只能是4個數字");
//					}else {
//					    userIdCheck =new Integer(userId);
//					}				
//			System.out.println(userId);
					
					String restaurantId = (req.getParameter("restaurantId").trim());
//			System.out.println(restaurantId);
					Integer resIdCheck = null;
					if(restaurantId == null || (restaurantId.length()) ==0 ) {
						errorMsgs.add("餐廳id: 請勿空白");
					}else if(!restaurantId.matches(rule)){
						errorMsgs.add("餐廳id只能是5個數字");
					}else {
						resIdCheck = new Integer(restaurantId);
					}
					
					String articleTitle = (req.getParameter("articleTitle")).trim();
					if(articleTitle == null || (articleTitle.length()) ==0 ) {
						errorMsgs.add("標題: 請勿空白");
					}
					
					java.sql.Date articleDate = null;
					try {
						articleDate = java.sql.Date.valueOf((req.getParameter("articleDate")).trim());
					}catch(IllegalArgumentException e ) {
						articleDate = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請選擇日期");
					}
					
					String articleContent = req.getParameter("articleContent");
					if(articleContent == null || (articleContent.trim().length()) ==0 ) {
						errorMsgs.add("內容: 請勿空白");
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
					
/*如果user更新完資料按送出,有檢查到錯誤,會退回更新頁面,但填過且正確的資料會被保留在頁面上*/				
					if(!errorMsgs.isEmpty()) {
						req.setAttribute("faVO", faVO);
						RequestDispatcher failure = req.getRequestDispatcher("/updateFA.jsp");
						failure.forward(req,res);
						return;
					}
	/*開始修改資料*/			
					FoodArticleService faSVC = new FoodArticleService();
					faVO = faSVC.updateFoodArticle(articleNo, userId, resIdCheck, articleTitle, articleDate, articleContent, sta);
	/*修改完成準備轉交*/	
					
					req.setAttribute("faVO",  faVO);
					RequestDispatcher successView = req.getRequestDispatcher("/listoneFA.jsp");
					successView.forward(req,res);
					
				}catch(Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/updateFA.jsp");
					failureView.forward(req,res);
				}
			}
/*新增資料的請求*/			
			if("insert".equals(action)) {
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					String userId =(req.getParameter("userId")).trim();
					String rule1 = "^[1-9]{4}$";
					Integer userIdCheck= null;
					if(userId == null || (userId.length()) ==0 ) {
						errorMsgs.add("會員id: 請勿空白");
					}else if(!userId.matches(rule1)){
						errorMsgs.add("會員id只能是4個數字");
					}else {
					    userIdCheck =new Integer(userId);
					}
					String rule2 = "^[1-9]{5}$";
					String restaurantId = (req.getParameter("restaurantId").trim());
					Integer resIdCheck = null;
					if(restaurantId == null || (restaurantId.length()) ==0 ) {
						errorMsgs.add("餐廳id: 請勿空白");
					}else if(!restaurantId.matches(rule2)){
						errorMsgs.add("餐廳id只能是5個數字");
					}else {
						resIdCheck = new Integer(restaurantId);
					}
					
					String articleTitle = (req.getParameter("articleTitle")).trim();
					if(articleTitle == null || (articleTitle.length()) ==0 ) {
						errorMsgs.add("標題: 請勿空白");
					}
					
					java.sql.Date articleDate = null;
					try {
						articleDate = java.sql.Date.valueOf((req.getParameter("articleDate")).trim());
					}catch(IllegalArgumentException e ) {
						articleDate = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請選擇日期");
					}
					
					String articleContent = req.getParameter("articleContent");
					if(articleContent == null || (articleContent.trim().length()) ==0 ) {
						errorMsgs.add("內容: 請勿空白");
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
					errorMsgs.add("新增資料失敗"+e.getMessage());
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
					errorMsgs.add("資料刪除失敗"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/listallFA.jsp");
					failureView.forward(req,res);
					
				}
			}

	}
}