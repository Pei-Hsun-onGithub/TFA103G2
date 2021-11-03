package com.meal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.meal.model.MealService;
import com.meal.model.MealVO;

public class MealInsert2 extends Command {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private String forwardTo;
	private String ErrorTo;
	

	public MealInsert2(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;

	}
	
	@Override
	public void execute() throws ServletException, IOException {
		List<String> errMsgs = new LinkedList<String>();
		req.setAttribute("errMsgs", errMsgs);
		MealService service = new MealService();
		// 1. 抓取表單資料，錯誤資料處理
		try {

//			String mealName = req.getParameter("mealName");
//			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//
//			if (!mealName.trim().matches(enameReg)) {
//				errMsgs.add("請輸入正確中英文與0~9的數字");
//			} else if (mealName == null || mealName.trim().length() == 0) {
//				errMsgs.add("請輸入資料，不要空白");
//			}


			Integer sta = null;
			try {
				sta = new Integer(req.getParameter("sta").trim());
			} catch (NumberFormatException e) {
				errMsgs.add("狀態請輸入數字");
			}
			String mealType = req.getParameter("mealType");

			
			
			Integer unitPrice = null;
			
			try {
				unitPrice = new Integer(req.getParameter("unitPrice"));
			} catch (NumberFormatException e) {
				unitPrice = new Integer("0");
				errMsgs.add("單價請輸入數字");
			}

			Timestamp launchDate = java.sql.Timestamp.valueOf(req.getParameter("launchDate"));

			Integer launchDays = null;
			try {
				launchDays = new Integer(req.getParameter("launchDays"));
			} catch (NumberFormatException e) {
				launchDays = new Integer("30");
				errMsgs.add("天數請輸入數字");
			}

			String mealDescription = req.getParameter("mealDescription");

			Integer restaurantId = null;
			try {
				restaurantId = new Integer(req.getParameter("restaurantId"));
			} catch (NumberFormatException e) {
				errMsgs.add("餐廳編號請輸入數字");
			}

			// 圖片上傳
			byte[] mealImg = null;
////			Part part = req.getPart("myUploadImg");
//			
//			Part part = req.getPart("myUploadImg");
//			if (part.getSize() > 0) {
//				InputStream in = part.getInputStream();
//				mealImg = new byte[in.available()];
//				System.out.println(mealImg);
//				in.read(mealImg);
//				in.close();
//
//			}
			
			String mealName = new String();
			
			List<String> myList = new ArrayList<String>();
			List<Integer> unitPr = new ArrayList<>();
			
	        myList.add("天使雞排");
	        unitPr.add(60);
	        myList.add("壽喜燒牛丼");
	        unitPr.add(150);
	        myList.add("茶碗蒸");
	        unitPr.add(30);
	        myList.add("番茄麵");
	        unitPr.add(150);
	        myList.add("牛肉麵");
	        unitPr.add(230);
	        myList.add("餛飩麵");
	        unitPr.add(120);
	        myList.add("玉子丼");
	        unitPr.add(130);
	        myList.add("雞肉飯");
	        unitPr.add(30);
	        myList.add("雞肉串");
	        unitPr.add(30);
	        myList.add("豬頭皮");  //10
	        unitPr.add(30);
	        myList.add("陽春麵");
	        unitPr.add(30);
	        myList.add("清湯麵");
	        unitPr.add(30);
	        myList.add("油麵");
	        unitPr.add(40);
	        myList.add("鐵蛋");
	        unitPr.add(10);
	        myList.add("貢丸湯");
	        unitPr.add(20);
	        myList.add("意麵");
	        unitPr.add(30);
	        myList.add("雞胗");
	        unitPr.add(40);
	        myList.add("蔬菜湯");
	        unitPr.add(30);
	        myList.add("白斬雞");
	        unitPr.add(100);

	       
	        
	        
	        
			if (!errMsgs.isEmpty()) {
				MealVO errMealVO = new MealVO();
				errMealVO.setMealName(mealName);
				errMealVO.setSta(sta);
				errMealVO.setUnitPrice(unitPrice);
				errMealVO.setLaunchDate(launchDate);
				errMealVO.setLaunchDays(launchDays);
				errMealVO.setRestaurantId(restaurantId);
				errMealVO.setMealImg(mealImg);
				errMealVO.setMealDescription(mealDescription);
				
				RequestDispatcher failureView = req.getRequestDispatcher(this.ErrorTo);
				req.setAttribute("UpdatingMealVO", errMealVO);
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
			

			// 2. 持久化
			
			String path = "C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\meal\\pic";
			File f = new File(path);
			String[] s = f.list();
			
			MealVO mealVO = new MealVO();
			
			for (int i = 0; i < s.length; i++) {
				String img = path + "\\" + s[i];
				mealImg = getPictureByteArray(img);
				mealVO = service.addMeal(sta, myList.get(i) , mealType, unitPr.get(i), launchDate, launchDays,
						mealDescription, mealImg, restaurantId);
			}
			

			// 3. 轉交至展示層
			req.setAttribute("mealVO", mealVO);
			RequestDispatcher toListOneView = req.getRequestDispatcher(this.forwardTo);
			toListOneView.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setForwardURL(String url) {
		this.forwardTo = url;
		
	}

	@Override
	public void setErrorURL(String url) {
		this.ErrorTo = url;
		
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
