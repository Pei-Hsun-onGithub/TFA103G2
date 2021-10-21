package com.foodarticle.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;


import com.foodarticle.model.*;
import com.message.model.*;
import com.picturebase.model.*;


@MultipartConfig
public class FoodArticleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException{
        		
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");/*��html��action�ݩʥΦr���ܼƱ���*/
//			res.setContentType("image/gif");
//			ServletOutputStream out = res.getOutputStream();
			
			
           /* �s�W�峹�M�Ϥ����O�P�@��form���,�P�@��request,
            * �p�G�n���Ⱖservlet�i�H�g�p�U�{��,
            * ��Ĥ@��servlet�����쪺req&res�Ǩ�U�@��servletX*/            
//			req.getRequestDispatcher("PictureBasesServlet��url").forward(req, res);
										
			
            /*��user�b�e�ݫ�"�e�X"��,�e�ШD�i��,�P�_user�e���Ȧ��L�ŦX�]�w*/
			
			if("getOne_For_Display".equals(action)){//from select_pageFA���ШD
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs",errorMsgs);
			//	System.out.println(action);
			
				try {
				
					String str = req.getParameter("articleNo");
						if(str==null || (str.trim()).length()==0) {
							errorMsgs.add("�п�J�峹�s��");
							System.out.println(str);
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
			      /*�a�ۤ峹pk�i��Ƨ�۹������峹VO*/
						FoodArticleService faSC = new FoodArticleService();
						FoodArticleVO faVO = faSC.getOneArticle(articleNo) ;
				  	  
						PictureBaseService pbSC = new PictureBaseService();
						MessageService msgSC = new MessageService ();
						
					/*-------------------�d�L���--------------------------*/	
						if(faVO ==null) {
							errorMsgs.add("�d�L���");
						}						
						if(!errorMsgs.isEmpty()) {
							RequestDispatcher falureView = req.getRequestDispatcher("/select_pageFA.jsp");
							falureView.forward(req,res);
							return;//�{�����_
						}
			/*-------------------����wpk���峹,�ǳưe���e��-----------------*/	
						
						/*�a�ۤ峹fk�i��Ƨ�۹������Ϥ�VO*/
						List<PictureBaseVO> list =  pbSC.getPicturesOfAr(articleNo);
						List<MessageVO> msgList = msgSC.getMsgsOfAr(articleNo);
						HttpSession session = req.getSession();
						
						session.setAttribute("list", list);
						req.setAttribute("faVO", faVO);
						req.setAttribute("msgList", msgList);
						System.out.println(msgList);
						RequestDispatcher successView = req.getRequestDispatcher("/article/oneFA_allMsg.jsp");//��浹oneFA_allMsg.jsp
						successView.forward(req, res);
		  
			/*-------------------------��L���~-----------------------------*/			
				}catch(Exception e) {
					System.out.println(1);
					e.printStackTrace();
					errorMsgs.add("�L�k���o���"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/article/listallFA.jsp");
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
				System.out.println("insert");
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
			String userId =(req.getParameter("userId")).trim();
					String rule1 = "^[0-9]{8}$";
					Integer userIdCheck= null;
//System.out.println("userId");
//System.out.println(userId);
					if(userId == null || (userId.length()) ==0 ) {
						errorMsgs.add("�|��id: �ФŪť�");
					}else if(!userId.matches(rule1)){
						errorMsgs.add("�|��id�u��O8�ӼƦr");
					}else {
					    userIdCheck =new Integer(userId);
					}
					String rule2 = "^[0-9]{4}$";
			        String restaurantId = (req.getParameter("restaurantId").trim());
					Integer resIdCheck = null;
					if(restaurantId == null || (restaurantId.length()) ==0 ) {
						errorMsgs.add("�\�Uid: �ФŪť�");
//System.out.println(restaurantId);
					}else if(!restaurantId.matches(rule2)){
						errorMsgs.add("�\�Uid�u��O4�ӼƦr");
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
					System.out.println(1);
					FoodArticleVO faVO = new FoodArticleVO();
					faVO.setUserId(userIdCheck);
					faVO.setRestaurantId(resIdCheck);
					faVO.setArticleTitle(articleTitle);
					faVO.setArticleDate(articleDate);
					faVO.setArticleContent(articleContent);
					faVO.setSta(sta);
					
					
					/*�W�ǹϤ�*/						
					
					List<PictureBaseVO> list = new ArrayList<PictureBaseVO>();
					PictureBaseVO pbVO = null;					
					
					byte[] pic=null;
					Collection<Part> parts = req.getParts();
				
				/*getParts�|��form���̤��ެO��r�٬O�ɮ׳���i��,
				 * �ҥH����getName��������name����,
				 * �h���z���ɮץH�~����r*/			
					
					for(Part part : parts) {
						String partName = part.getName();
						
				/*�n�b�j�餺�Ыع���,�C�]�@���j��N�O�~�|�O�s��vo	*/	
						pbVO = new PictureBaseVO();
						if(partName.equals("imgfile")) {
							if(part.getSize()>0) {
								InputStream imgIn = part.getInputStream();
								pic = new byte[imgIn.available()];
								imgIn.read(pic);
								pbVO.setPic(pic);
								list.add(pbVO);
								System.out.println(pbVO);
								}else {
									errorMsgs.add("�зs�W�̤֤@�i�Ϥ�");
								}
						}
			
					}																			
					if(!errorMsgs.isEmpty()) {
					HttpSession session = req.getSession();
					req.setAttribute("faVO", faVO);
			//		req.setAttribute("pbVO", pbVO);
					session.setAttribute("list", list);
					
					RequestDispatcher failureView = req.getRequestDispatcher("/article/addFA.jsp");
					failureView.forward(req, res);
					return;
					}
					
					FoodArticleService faSvc = new FoodArticleService();					

					/*�峹�M�Ϥ��P�ɭn�s�W,�ҥH�n�P�ɰe�峹VO �Ϥ�list����Ʈw���峹pk���Ϥ�*/	
					faSvc.addtWithPic(faVO, list);															
					RequestDispatcher successView = req.getRequestDispatcher("/article/listOneFA.jsp");
					successView.forward(req,res);														
					
				}catch(Exception e){	
					e.printStackTrace();
					errorMsgs.add("�s�W��ƥ���"+e.getMessage());					
					RequestDispatcher failureView = req.getRequestDispatcher("/article/addFA.jsp");
					failureView.forward(req, res);
				}
			}
			
			
			
			
//			if("delete".equals(action)) {
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs",errorMsgs );
//				
//				try {
//					
//					Integer articleNo = new Integer(req.getParameter("articleNo"));
//					
//					FoodArticleService faSvc = new FoodArticleService();
//					faSvc.deleteFoodArticle(articleNo);
//					
//					RequestDispatcher successView = req.getRequestDispatcher("/listallFA.jsp");
//					successView.forward(req,res);
//				}catch(Exception e) {
//					errorMsgs.add("��ƧR������"+e.getMessage());
//					RequestDispatcher failureView = req.getRequestDispatcher("/listallFA.jsp");
//					failureView.forward(req,res);
//					
//				}
//			}

	}
}