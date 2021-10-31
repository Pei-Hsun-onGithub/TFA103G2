package com.meal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.meal.model.MealService;
import com.meal.model.MealVO;

import util.ErrorMessages;

@MultipartConfig
public class MealServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		if ("getAll".equals(action)) {

			Command getAllMeal = Command.createCommand("getAll", req, res);
			getAllMeal.setForwardURL("/pei_pages/listAllMeal.jsp");
			getAllMeal.execute();
		}

		if ("getOne_For_Display".equals(action)) {

			Command getOneMeal = Command.createCommand("getOne_For_Display", req, res);
			getOneMeal.setForwardURL("/pei_pages/listOneMeal.jsp");
			getOneMeal.setErrorURL("/pei_pages/listOneMeal.jsp");
			getOneMeal.execute();

		}

		if ("insert".equals(action)) {

			Command insertOne = Command.createCommand("insert", req, res);
			insertOne.setForwardURL("/pei_pages/listOneMeal.jsp");
			insertOne.setErrorURL("/vendor_meal_upload.jsp");
			insertOne.execute();

		}

		if ("insert2".equals(action)) {

			Command insertOne = Command.createCommand("insert2", req, res);
			insertOne.setForwardURL("/pei_pages/listOneMeal.jsp");
			insertOne.setErrorURL("/vendor_meal_upload.jsp");
			insertOne.execute();

		}

		if ("getOne_For_Update".equals(action)) {

			Command getOneForUpdate = Command.createCommand("getOne_For_Update", req, res);
			getOneForUpdate.setForwardURL("/pei_pages/updateOneMeal.jsp");
			getOneForUpdate.execute();

		}

		if ("update".equals(action)) {

			Command update = Command.createCommand("update", req, res);
			update.setForwardURL("/pei_pages/listAllMeal.jsp");
			update.execute();
		}

		if ("delete".equals(action)) {
			Command delete = Command.createCommand("delete", req, res);
			delete.setForwardURL("/pei_pages/listAllMeal.jsp");
			delete.execute();
		}

		if ("mealErrorVerify".equals(action)) {

			Gson gson = new Gson();
			ErrorMessages errors = new ErrorMessages();

			String item = req.getParameter("param");

			PrintWriter out = res.getWriter();

			if ("0".equals(item)) {

				String mealName = req.getParameter("item");

				if (mealName == null || mealName.trim().length() == 0) {
					errors.setNoEmpty("no name empty");
					out.write(gson.toJson(errors));
					return;
				} 
				// 都沒有錯誤回傳空的錯誤訊息物件
				out.write(gson.toJson(errors));
				return;
			}
			if ("1".equals(item)) {
				
				String unitPrice = req.getParameter("item");
				String unitPriceReg = "^[(0-9_)]{1,6}$";
				if (unitPrice == null || unitPrice.trim().length() == 0) {
					errors.setNoEmpty("no name empty");
					out.write(gson.toJson(errors));
					return;
					
				} else if (!(unitPrice.trim().matches(unitPriceReg))) {
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
}
