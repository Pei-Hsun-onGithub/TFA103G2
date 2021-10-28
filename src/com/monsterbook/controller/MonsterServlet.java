package com.monsterbook.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;

@MultipartConfig
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
		Integer userId = (Integer) session.getAttribute("userId");
		// 之後要換成上面的動態擷取userId
//		Integer userId = 20210002;

		if ("updateMonsterVOtoMemInfo".equals(action)) {

			String monsterNickName = req.getParameter("monsterNickName");
			Integer monsterId = new Integer(req.getParameter("monsterId"));
			Integer monsterLevel = new Integer(req.getParameter("originLevel"));
			Integer monsterExp = new Integer(req.getParameter("originExp"));

			MemberInfo memInfo = memInfoSvc.getOneMemberInfo(userId);

			memInfoSvc.updateMemberInfo(userId, memInfo.getEmail(), memInfo.getPwd(), memInfo.getUserName(),
					memInfo.getGender(), memInfo.getBirthday(), memInfo.getPhone(), memInfo.getPic(),
					memInfo.getRegisterDate(), memInfo.getGold(), memInfo.getFeed(), monsterId, monsterNickName,
					monsterLevel, monsterExp, memInfo.getSta());

			RequestDispatcher toHomeView = req.getRequestDispatcher("/home.jsp");
			toHomeView.forward(req, res);
		}

		
		if("getOneMonsterForUpdate".equals(action)) {
			
			Integer monsterId = new Integer(req.getParameter("monsterId"));
			MonsterBookService monsterSvc = new MonsterBookService();
			MonsterBook monsterVO = monsterSvc.getOneMonsterBook(monsterId);
			req.setAttribute("updatingmonsterVO", monsterVO);
			
			RequestDispatcher toUpdateView = req.getRequestDispatcher("/pei_pages/updateOneMonsterInfo.jsp");
			toUpdateView.forward(req, res);
		}
		
		if("updateOneMonster".equals(action)) {
			Integer monsterId = new Integer(req.getParameter("monsterId"));
			String monsterName = req.getParameter("monsterName");
			Integer monsterMinDemandLevel = new Integer(req.getParameter("monsterMinDemandLevel"));
			String monsterAbility = req.getParameter("monsterAbility");
			byte[] monsterPicture = null;
			
			Part part =	req.getPart("myUploadImg");
			if (part.getSize() > 0) {
				InputStream in = part.getInputStream();
				monsterPicture = new byte[in.available()];
				in.read(monsterPicture);
				in.close();

			}
			
			/*==================   錯誤處理驗證   =========================*/
			
			
			/*==================   轉送資料庫   =========================*/
			
			MonsterBookService monsterSvc = new MonsterBookService();
			monsterSvc.updateMonsterBook(monsterId, monsterMinDemandLevel, monsterName, monsterAbility, monsterPicture);
			RequestDispatcher toUpdateView = req.getRequestDispatcher("/pei_pages/listAllMonster.jsp");
			toUpdateView.forward(req, res);
 		}
	}
}
