package com.picturebases.controller;



import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.picturebase.model.PictureBaseVO;



@WebServlet("/PictureBasesServlet")

public class PictureBasesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		HttpSession session = req.getSession();
		List<PictureBaseVO> pbList = (List<PictureBaseVO>) session.getAttribute("list");
		int i = new Integer(req.getParameter("id"));
		out.write(pbList.get(i).getPic());															
	}
	
}
