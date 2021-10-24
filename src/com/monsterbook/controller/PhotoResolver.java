package com.monsterbook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;

/**
 * Servlet implementation class PhotoResolver
 */
@WebServlet("/PhotoResolver")
public class PhotoResolver extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// res.setContentType("image/png");

		Integer monsterId = new Integer(request.getParameter("id"));
		// System.out.println("mealId=" + mealId);
		MonsterBookService monsterBookSvc = new MonsterBookService();
		MonsterBook monsterBookVO = monsterBookSvc.getOneMonsterBook(monsterId);
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
