package com.monsterbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.monsterbook.model.MonsterBookService;

public class MonsterServlet extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		MemberInfoService memInfoSvc = new MemberInfoService();
		MonsterBookService monsterBookSvc = new MonsterBookService();
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		//之後要換成上面的動態擷取userId
//		Integer userId = 20210002;
		
		if("updateMonsterVOtoMemInfo".equals(action)) {
			
			String monsterNickName = req.getParameter("monsterNickName");
			Integer monsterId = new Integer(req.getParameter("monsterId"));
			Integer monsterLevel = new Integer(req.getParameter("originLevel"));
			Integer monsterExp = new Integer(req.getParameter("originExp"));
			
			MemberInfo memInfo = memInfoSvc.getOneMemberInfo(userId);
			
			
			memInfoSvc.updateMemberInfo(userId, memInfo.getEmail(), memInfo.getPwd(), memInfo.getUserName(), 
					memInfo.getGender(), memInfo.getBirthday(), memInfo.getPhone(), memInfo.getPic(), memInfo.getRegisterDate(), 
					memInfo.getGold(), memInfo.getFeed(), monsterId, monsterNickName, monsterLevel, monsterExp, memInfo.getSta());
			
			RequestDispatcher toHomeView = req.getRequestDispatcher("/home.jsp");
			toHomeView.forward(req, res);
		}
	}
}
