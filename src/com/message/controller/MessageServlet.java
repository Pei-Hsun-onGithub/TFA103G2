package com.message.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.favofoodarticle.model.FavoFoodArticleService;
import com.favofoodarticle.model.FavoFoodArticleVO;
import com.foodarticle.model.*;
import com.message.model.*;
import com.picturebase.model.PictureBaseService;
import com.picturebase.model.PictureBaseVO;

@WebServlet
public class MessageServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("msgAdd".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				Integer articleNo =new Integer(req.getParameter("articleNo"));
				System.out.println(articleNo);
				
				
				
				Integer userId= new Integer(req.getParameter("userId"));

				
				
				String msgContent = req.getParameter("msgContent");
				if(msgContent == null ||msgContent.length() == 0  ) {
					errorMsgs.add("內容:請勿空白");
				}
				
				Integer sta = new Integer(req.getParameter("sta"));
												
				/*把使用者塡好的資料裝進VO裡*/
				MessageVO msgVO = new MessageVO();
				msgVO.setUserId(userId);
				msgVO.setMsgContent(msgContent);
				msgVO.setSta(sta);
				
				/*文章VO 圖片VO保留  收藏保留*/
				
				FoodArticleService faSC = new FoodArticleService();
				FoodArticleVO faVO = faSC.getOneArticle(articleNo) ;
				PictureBaseService pbSC = new PictureBaseService();
				List<PictureBaseVO> list =  pbSC.getPicturesOfAr(articleNo);
				HttpSession session = req.getSession();
				FavoFoodArticleService favoarSc =new FavoFoodArticleService();
				FavoFoodArticleVO favfooVO = favoarSc.getOneFavoFoodArticle(userId, articleNo);
				
				
				
				if(!errorMsgs.isEmpty()) {
					
					session.setAttribute("list", list);
					req.setAttribute("msgVO", msgVO);
					req.setAttribute("faVO", faVO);
					req.setAttribute("favfooVO", favfooVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/article/oneFA_allMsg.jsp");
					failureView.forward(req, res);
					return;					
				}
				
				MessageService msgSVC = new MessageService();
				msgSVC.addMessage(articleNo, userId, msgContent, sta);
				List<MessageVO> msgList = msgSVC.getMsgsOfAr(articleNo);
				
				
				session.setAttribute("list", list);
				req.setAttribute("faVO", faVO);
				req.setAttribute("msgList", msgList);
				req.setAttribute("favfooVO", favfooVO);
				
				RequestDispatcher successView = req.getRequestDispatcher("/article/oneFA_allMsg.jsp");
				successView.forward(req,res);		
				
								
			}catch(Exception e) {
				e.printStackTrace();
				errorMsgs.add("新增失敗"+e.getMessage());					
				RequestDispatcher failureView = req.getRequestDispatcher("/article/addFA.jsp");
				failureView.forward(req, res);
			}
				
			
		}
	
	
	}			
	
}
