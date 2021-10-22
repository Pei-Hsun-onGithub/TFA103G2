package com.picturebases.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.picturebase.model.PictureBaseService;
import com.picturebase.model.PictureBaseVO;

@WebServlet("/PictureBasesServlet")

public class PictureBasesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		HttpSession session = req.getSession();
		List<PictureBaseVO> pbList = (List<PictureBaseVO>) session.getAttribute("list");
		int i = new Integer(req.getParameter("id"));
		out.write(pbList.get(i).getPic());	

		
		
		
		//		System.out.println("pbList=" +pbList);
		
		
		
		//		System.out.println("id=" + i);
//		
//		System.out.println("pbList=" +pbList);
//		String action = req.getParameter("action");
//		Integer articleId = new Integer(req.getParameter("articleId"));
//		System.out.println("articleId=" + articleId);
//		
//		PictureBaseService picBaseSvc = new PictureBaseService();
//		List<PictureBaseVO> articlePictures = picBaseSvc.getPicturesOfAr(articleId);
//		
//		if ("getOne_For_Display".equals(action)) {
//			out.write(articlePictures.get(articleId).getPic());
//			return;
//		}
//		if ("one".equals(action)) {
//			out.write(articlePictures.get(0).getPic());
//			return;
//		}
////		if ("two".equals(action)) {
////			out.write(articlePictures.get(1).getPic());
////			return;
////		}
////		if ("three".equals(action)) {
////			out.write(articlePictures.get(2).getPic());
////			return;
////		}
////		if ("four".equals(action)) {
////			out.write(articlePictures.get(3).getPic());
////			return;
////		}
//
	}

}
