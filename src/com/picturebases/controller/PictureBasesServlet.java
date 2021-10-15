package com.picturebases.controller;



import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.foodarticle.model.FoodArticleService;
import com.foodarticle.model.FoodArticleVO;
import com.picturebase.model.PictureBaseService;
import com.picturebase.model.PictureBaseVO;

@MultipartConfig

public class PictureBasesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	
	
		if("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				
				/*==============文章代碼===============*/
				
				
				
				
				
			/*==============新增圖片===============*/	
				byte[] pic=null;
				Collection<Part> parts = req.getParts();
				for(Part part : parts) {
					if(part.getSize()>0) {
					InputStream imgIn =part.getInputStream();
					pic =new byte[imgIn.available()];
					imgIn.read(pic);
					}else {
						errorMsgs.add("請新增最少一張圖片");
					}
					
				}
				
//				PictureBaseVO pbVO = new PictureBaseVO();
//				pbVO.setArticleNo(articleNo);
//				pbVO.setPic(pic);
				
				
				if(!errorMsgs.isEmpty()) {
					req.setAttribute("pbVO", pbVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/addFA.jsp");
					failureView.forward(req, res);
					return;
					}
					
				   PictureBaseService pbSvc = new PictureBaseService();
				   pbVO = pbSvc.addPictureBase(articleNo, pic);
					
					RequestDispatcher successView = req.getRequestDispatcher("/listallFA.jsp");
					successView.forward(req,res);
				
				
				
				
			}catch(Exception e) {
				
			}
			
		}
		
	
		
		
		
		
	
		
		
	}
	
}
