package com.meal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class PhotoServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		// res.setContentType("image/png");

		Integer mealId = new Integer(req.getParameter("id"));
		// System.out.println("mealId=" + mealId);
		MealService mealSvc = new MealService();
		MealVO mealVO = mealSvc.findMealByPrimaryKey(mealId);
		try {

			byte[] imgBytes = mealVO.getMealImg();
			res.getOutputStream().write(imgBytes);
			
		} catch (NullPointerException e) {
			// 如果沒有照片，放入預設的圖片!
			try {
				File notFoundImage = new File(
						"C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\images\\not-found-image.png");
				// System.out.println("getServletContext().getContextPath() =" +getServletContext().getContextPath())
				// getServletContext().getContextPath());
				// System.out.println("notFoundImage.exists()=" + notFoundImage.exists());
				FileInputStream fin = new FileInputStream(notFoundImage);
				byte[] notFoundimgBytes = new byte[fin.available()];
				fin.read(notFoundimgBytes);
				res.getOutputStream().write(notFoundimgBytes);

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}