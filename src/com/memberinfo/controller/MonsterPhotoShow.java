package com.memberinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;

@WebServlet("/MonsterPhotoShow.do")
public class MonsterPhotoShow extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// res.setContentType("image/png");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		MemberInfoService memberSvc = new MemberInfoService();
		MemberInfo memberVO = memberSvc.getOneMemberInfo(userId);
		MonsterBookService monsterBookSvc = new MonsterBookService();
		MonsterBook monsterBookVO = monsterBookSvc.getOneMonsterBook(memberVO.getMonsterId());
		String monsterLevel = request.getParameter("type");
		
		if("M".equals(monsterLevel)) {
			Integer mediumMonsterId = monsterBookVO.getMonsterId() + 3;
			monsterBookVO = monsterBookSvc.getOneMonsterBook(mediumMonsterId);
		} else if("L".equals(monsterLevel)) {
			Integer HighMonsterId = monsterBookVO.getMonsterId() + 6;
			monsterBookVO = monsterBookSvc.getOneMonsterBook(HighMonsterId);
		}
		
		try {

			byte[] imgBytes = monsterBookVO.getMonsterPic();
			response.getOutputStream().write(imgBytes);
			
		} catch (NullPointerException e) {
			// �p�G�S���Ӥ��A��J�w�]���Ϥ�!
			try {
				File notFoundImage = new File(
						"C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\images\\not-found-image.png");
				// System.out.println("getServletContext().getContextPath() =" +getServletContext().getContextPath())
				// getServletContext().getContextPath());
				// System.out.println("notFoundImage.exists()=" + notFoundImage.exists());
				FileInputStream fin = new FileInputStream(notFoundImage);
				byte[] notFoundImgBytes = new byte[fin.available()];
				fin.read(notFoundImgBytes);
				response.getOutputStream().write(notFoundImgBytes);

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
