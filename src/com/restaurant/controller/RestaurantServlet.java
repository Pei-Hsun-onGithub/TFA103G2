package com.restaurant.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.restaurant.controller.Command;
import com.restaurant.model.RestaurantVO;
import com.restaurantstyle.model.RestaurantStyleVO;

import util.ErrorMessages;

public class RestaurantServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		if ("insert".equals(action)) {
			Command insert = Command.createCommand("insert", req, res);
			insert.execute();
		}
		if ("update".equals(action)) {
			Command update = Command.createCommand("update", req, res);
			update.execute();
		}

		if ("test".equals(action)) {
			Gson gson = new Gson();

			ErrorMessages errors = new ErrorMessages();
			PrintWriter out = res.getWriter();
			String restaurantName = req.getParameter("restaurantName");
			
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (restaurantName == null || restaurantName.trim().length() == 0) {
				errors.setNoEmpty("no name empty");
				out.write(gson.toJson(errors));
				return;

			} else if (!(restaurantName.trim().matches(enameReg))) {
				errors.setErrorFormatName("formate Errors");
				out.write(gson.toJson(errors));
				return;
			}
			// 都沒有錯誤回傳空的錯誤訊息物件
			out.write(gson.toJson(errors));
			return;
		}
	}
}
//"員工姓名: 請勿空白"
//員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間