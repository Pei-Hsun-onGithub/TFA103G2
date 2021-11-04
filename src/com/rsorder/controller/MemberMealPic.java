package com.rsorder.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meal.model.*;

public class MemberMealPic extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		Integer mealId = new Integer(req.getParameter("mealId"));

		MealService mealSvc = new MealService();
		MealVO mealvo = mealSvc.findMealByPrimaryKey(mealId);

		try {

			byte[] imgBytes = mealvo.getMealImg();
			res.getOutputStream().write(imgBytes);

		} catch (NullPointerException e) {
			// �p�G�S���Ӥ��A��J�w�]���Ϥ�!
			try {
				File notFoundImage = new File(
						"C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\pictest\\girl.png");
				// System.out.println("getServletContext().getContextPath() ="
				// +getServletContext().getContextPath())
				// getServletContext().getContextPath());
				// System.out.println("notFoundImage.exists()=" + notFoundImage.exists());
				FileInputStream fin = new FileInputStream(notFoundImage);
				byte[] notFoundImgBytes = new byte[fin.available()];
				fin.read(notFoundImgBytes);
				res.getOutputStream().write(notFoundImgBytes);

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}