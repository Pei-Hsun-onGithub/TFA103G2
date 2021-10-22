package com.picturebases.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.picturebase.model.*;


@WebServlet("/ImageSingleServlet")
public class ImageSingleServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("image/gif");		
		ServletOutputStream out = res.getOutputStream();		
		Integer id = new Integer(req.getParameter("Id"));
		PictureBaseService pbSVC = new PictureBaseService();
		PictureBaseVO pbVO =new PictureBaseVO();
		pbVO = pbSVC.OnePicOfAr(id);
		out.write(pbVO.getPic());
		System.out.println(id);
		
		//byte[] xxx = VO.getPic();
		
			
	}

}
