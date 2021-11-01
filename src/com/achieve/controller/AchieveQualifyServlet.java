package com.achieve.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.achieve.model.Achieve;
import com.achieve.model.AchieveService;


@WebServlet("/achieve/AchieveQualify.do")
public class AchieveQualifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// res.setContentType("image/png");
		
		String action = request.getParameter("action");
		
		if("triggerAchieveMission".equals(action)) {
			
			ServletContext servletContext = this.getServletContext();
			Integer archieveId = new Integer(request.getParameter("achieveId"));
			
			AchieveService achieveSvc = new AchieveService();
			Achieve achieveVO = achieveSvc.getOneAchieve(archieveId);
			
			
				servletContext.setAttribute("achieveMission", achieveVO);
			
			
			RequestDispatcher toBackgroungManagerView = request.getRequestDispatcher("/pei_pages/addAchievment.jsp");
			toBackgroungManagerView.forward(request, response);
		}
	}
}
