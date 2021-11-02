package com.foodarticle.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.favofoodarticle.model.*;
import com.foodarticle.model.*;
import com.message.model.*;
import com.picturebase.model.*;

@MultipartConfig
public class FoodArticleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");/* 抓html的action屬性用字串變數接值 */		

		/* 當user點選任一篇article會傳articleNo進servlet*/

		if ("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println(action);

			try {
				/*先抓出前端傳進來的articleNo,宣告一個變數接住*/				
				Integer articleNo = new Integer (req.getParameter("articleNo"));
				Integer userId = new Integer (req.getParameter("userId"));
				System.out.println("userId"+userId);

				/*由service帶著articleno進資料庫找相對應的article */			
				FoodArticleService faSC = new FoodArticleService();
				FoodArticleVO faVO = faSC.getOneArticle(articleNo);

				/*由service帶著articleno進資料庫找相對應的articlePictures */
				PictureBaseService pbSC = new PictureBaseService();
				List<PictureBaseVO> list = pbSC.getPicturesOfAr(articleNo);
				
				
				/*由service帶著articleno進資料庫找相對應的articleMessages */
				MessageService msgSC = new MessageService();
				List<MessageVO> msgList = msgSC.getMsgsOfAr(articleNo);
				
				/*由service帶著articleno userid進資料庫找相對應的favofooVO */
				FavoFoodArticleService favoarSc =new FavoFoodArticleService();
				FavoFoodArticleVO favfooVO = favoarSc.getOneFavoFoodArticle(userId, articleNo);
				
				/*判斷有無articleVO*/
				if (faVO == null) {
					errorMsgs.add("查無資料");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher falureView = req.getRequestDispatcher("/article/allFA.jsp");
					falureView.forward(req, res);
					return;// 程式中斷
				}
				
				
				/*資料庫有找到articleVO*/
				/*因為圖片要跑另一支servlet,所以先將user的req存在session
				 *再由圖片的servlet進session撈req,去資料庫取圖*/			
				
				HttpSession session = req.getSession();
				session.setAttribute("list", list);
				req.setAttribute("faVO", faVO);//給前端取值
				req.setAttribute("msgList", msgList);//給前端取值
				req.setAttribute("favfooVO", favfooVO);//給前端取值				
				
				/*將req送到指定頁面*/
				RequestDispatcher successView = req.getRequestDispatcher("/article/oneFA_allMsg.jsp");
				successView.forward(req, res);

				/*其他錯誤*/
			} catch (Exception e) {
		
				e.printStackTrace();
				errorMsgs.add("無法取得資料" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/article/allFA.jsp");
				failureView.forward(req, res);
			}

		}

		/*當user點選任"修改"傳進articleno進servlet*/
		
		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			// System.out.println("程式跑到這1");
			try {
				Integer articleNo = new Integer(req.getParameter("articleNo"));

				// 抓指定PK的文章
				FoodArticleService faSvc = new FoodArticleService();
				FoodArticleVO oldfaVO = faSvc.getOneArticle(articleNo);

				// 抓指定FK圖片
				PictureBaseService pbSvc = new PictureBaseService();
				List<PictureBaseVO> list = pbSvc.getPicturesOfAr(articleNo);

				HttpSession session = req.getSession();

				req.setAttribute("faVO", oldfaVO);
				session.setAttribute("list", list);
				
				String url = "/article/updateFA_pic.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				

				/*-------------其他錯誤處理----------*/
			} catch (Exception e) {
				
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failure = req.getRequestDispatcher("/listallFA.jsp");
				failure.forward(req, res);
				
			}
		}
		
		/*user按下"送出"會帶著article+pics進servlet*/
		
		if ("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
//System.out.println(action);

			/* 檢查前端輸入的資料有沒有符合規定 */
			try {
				
				/*一一抓出前端送進來的資料*/
				
				Integer articleNo = new Integer(req.getParameter("articleNo").trim());
				//System.out.println("articleNo=" + articleNo);
				//System.out.println("1112"+articleNo);				

				Integer userId = new Integer((req.getParameter("userId").trim()));				

				Integer restaurantId = new Integer (req.getParameter("restaurantId"));
							
				String articleTitle = (req.getParameter("articleTitle")).trim();
				if (articleTitle == null || (articleTitle.length()) == 0) {
					errorMsgs.add("標題: 請勿空白");
				}

				java.sql.Date articleDate = null;
				try {
					articleDate = java.sql.Date.valueOf((req.getParameter("articleDate")).trim());
				} catch (IllegalArgumentException e) {
					articleDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請選擇日期");
				}

				String articleContent = req.getParameter("articleContent");
				if (articleContent == null || (articleContent.trim().length()) == 0) {
					errorMsgs.add("內容: 請勿空白");
				}

				Integer sta = new Integer(req.getParameter("sta"));

				FoodArticleService foodArticleSvc = new FoodArticleService();

				FoodArticleVO faVO = foodArticleSvc.updateFoodArticle(articleNo, userId, restaurantId, articleTitle,
						articleDate, articleContent, sta);
				// System.out.println("faVO"+faVO);

				/*=========== 更新多筆圖片 ==============*/

				PictureBaseService picBaseSvc = new PictureBaseService();
				List<PictureBaseVO> oldPicBases = picBaseSvc.getPicturesOfAr(articleNo);
				
				int oldPicBasesSize = oldPicBases.size();

				PictureBaseVO pbVO = null;

				int pictureObtainedCount = 0;
				int index = 0;
				byte[] pic = null;
				Collection<Part> parts = req.getParts();

				/*
				 * getParts會把form表單裡不管是文字還是檔案都抓進來, 所以先用getName取元素的name的值, 去比對篩掉檔案以外的文字
				 */

				for (Part part : parts) {
					String partName = part.getName();

					/* 要在迴圈內創建實體,每跑一次迴圈就是才會是新的vo */

					if (partName.equals("imgfile")) {

						if (part.getSize() > 0) {
							// 成功抓到圖片就加一
							pictureObtainedCount++;
							
							InputStream imgIn = part.getInputStream();
							pic = new byte[imgIn.available()];
							imgIn.read(pic);
							
							// 原本的圖片數量比獲得的數量多或等於就做「更新」
							if (oldPicBasesSize >= pictureObtainedCount) {

								pbVO = oldPicBases.get(index);
								pbVO.setPic(pic);
								picBaseSvc.updatePictureBase(pbVO.getPicNo(), pic);
								index++;
								
								// 原本的圖片數量比獲得的數量少就做「新增」
							} else if (oldPicBasesSize < pictureObtainedCount) {
								PictureBaseVO picBasVO = picBaseSvc.addPictureBase(articleNo, pic);
								oldPicBases.add(index, picBasVO);
								index++;
							}
						} else {
							errorMsgs.add("請新增最少一張圖片");
						}
					}
				}

				// 當原本的圖片數量已經多過獲得的圖片數量，就把多餘的「刪除」
				if (oldPicBases.size() > pictureObtainedCount) {

					int oldSize = oldPicBases.size();
					// 獲得一個縮小的PicBases
					List<PictureBaseVO> smallPicBases = oldPicBases.subList(0, index);
					
					// 逐一刪除資料庫中沒有更新的舊圖片
					for (int deleteIndex = index; deleteIndex < oldSize; deleteIndex++) {
						
						PictureBaseVO deletingPicBasVO = oldPicBases.get(deleteIndex);
						picBaseSvc.deletePictureBase(deletingPicBasVO.getPicNo());
					}
					
					oldPicBases = smallPicBases;
				}
								
				/* 如果user更新完資料按送出,有檢查到錯誤,會退回更新頁面,但填過且正確的資料會被保留在頁面上 */

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("faVO", faVO);

					RequestDispatcher failure = req.getRequestDispatcher("/article/updateFA_pic.jsp");
					failure.forward(req, res);
					return;
				}
				/* 開始修改資料 */

				/* 修改完成準備轉交 */

				req.setAttribute("faVO", faVO);
				RequestDispatcher successView = req.getRequestDispatcher("/article/allFA_member.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				e.printStackTrace();
				RequestDispatcher failureView = req.getRequestDispatcher("/article/allFA_member.jsp");
				failureView.forward(req, res);
			}
		}

		
		/* 新增資料的請求 */
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("action"+action);

			try {
				Integer userId =new Integer (req.getParameter("userId"));
				System.out.println("userId"+userId);
				

				String restaurant = req.getParameter("restaurantId");
				

				Integer restaurantId = null;				
				if (restaurant == null || (restaurant.length()) == 0) {
					errorMsgs.add("請選擇餐廳");
<<<<<<< HEAD
				} else {
					userIdCheck = new Integer(userId);
				}
				String rule2 = "^[0-9]{4}$";
				String restaurantId = (req.getParameter("restaurantId").trim());
				Integer resIdCheck = null;
				if (restaurantId == null || (restaurantId.length()) == 0) {
					errorMsgs.add("餐廳id: 請勿空白");

				} else if (!restaurantId.matches(rule2)) {
					errorMsgs.add("餐廳id只能是4個數字");
=======
>>>>>>> 591ff0d946daedee1f8a6b85e1532d7e480bb32b
				} else {
					restaurantId = new Integer(restaurant);
				}

				String articleTitle = (req.getParameter("articleTitle")).trim();
				if (articleTitle == null || (articleTitle.length()) == 0) {
					errorMsgs.add("標題: 請勿空白");
				}

				java.sql.Date articleDate = null;
				try {
					articleDate = java.sql.Date.valueOf((req.getParameter("articleDate")).trim());
				} catch (IllegalArgumentException e) {
					articleDate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請選擇日期");
				}

				String articleContent = req.getParameter("articleContent");
				if (articleContent == null || (articleContent.trim().length()) == 0) {
					errorMsgs.add("內容: 請勿空白");
				}

				Integer sta = new Integer(req.getParameter("sta"));				

				/* 抓上傳的圖片 */

				List<PictureBaseVO> list = new ArrayList<PictureBaseVO>();
				PictureBaseVO pbVO = null;
				byte[] pic = null;
				Collection<Part> parts = req.getParts();

				/*
				 * getParts會把form表單裡不管是文字還是檔案都抓進來, 所以先用getName取元素的name的值, 去比對篩掉檔案以外的文字
				 */

				for (Part part : parts) {
					String partName = part.getName();

					/* 要在迴圈內創建實體,每跑一次迴圈就是才會是新的vo */
					pbVO = new PictureBaseVO();
					if (partName.equals("imgfile")) {
						if (part.getSize() > 0) {
							InputStream imgIn = part.getInputStream();
							pic = new byte[imgIn.available()];
							imgIn.read(pic);
							pbVO.setPic(pic);
							list.add(pbVO);
							System.out.println(pbVO);
						} else {
							errorMsgs.add("請新增最少一張圖片");
						}
					}
				}
				
				/*把前端送進來的值塞進articlleVO裡*/
				FoodArticleVO faVO = new FoodArticleVO();
				faVO.setUserId(userId);
				faVO.setRestaurantId(restaurantId);
				faVO.setArticleTitle(articleTitle);
				faVO.setArticleDate(articleDate);
				faVO.setArticleContent(articleContent);
				faVO.setSta(sta);
				
				if (!errorMsgs.isEmpty()) {
					HttpSession session = req.getSession();
					req.setAttribute("faVO", faVO);
					// req.setAttribute("pbVO", pbVO);
					session.setAttribute("list", list);

					RequestDispatcher failureView = req.getRequestDispatcher("/article/addFA.jsp");
					failureView.forward(req, res);
					return;
				}

				FoodArticleService faSvc = new FoodArticleService();

				/* 文章和圖片同時要新增,所以要同時送文章VO 圖片list給資料庫取文章pk給圖片 */
				faSvc.addtWithPic(faVO, list);
				RequestDispatcher successView = req.getRequestDispatcher("/article/allFA_member.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("新增資料失敗" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/article/addFA.jsp");
				failureView.forward(req, res);
			}
		}
			if("searchArticle".equals(action)) {
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				try {
					String words = req.getParameter("keyword");
					
					if (words == null || (words.trim()).length() == 0) {
						errorMsgs.add("請輸入關鍵字");
//						System.out.println(words);										
					}				
					
					FoodArticleService faSvc = new FoodArticleService();
					List<FoodArticleVO> someFaList = faSvc.getByKeyWord(words);
					
					if (someFaList.size()<=0) {
						errorMsgs.add("尚無相關食記");						
					}
					
					//沒有輸入關鍵字導回原頁面,出示error訊息	
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher falureView = req.getRequestDispatcher("/article/allFA.jsp");
						falureView.forward(req, res);
						return;
					}
					
					req.setAttribute("someFaList", someFaList);
					RequestDispatcher successView = req.getRequestDispatcher("/article/search_keyword.jsp");
					successView.forward(req, res);																				
					
				}catch(Exception e ) {
//					System.out.println(1);
					e.printStackTrace();
					errorMsgs.add("無法取得資料" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/article/allFA.jsp");
					failureView.forward(req, res);
				}
				
			}

			
			
//			if("delete".equals(action)) {
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs",errorMsgs );
//				
//				try {
//					
//					Integer articleNo = new Integer(req.getParameter("articleNo"));
//					
//					FoodArticleService faSvc = new FoodArticleService();
//					faSvc.deleteFoodArticle(articleNo);
//					
//					RequestDispatcher successView = req.getRequestDispatcher("/listallFA.jsp");
//					successView.forward(req,res);
//				}catch(Exception e) {
//					errorMsgs.add("資料刪除失敗"+e.getMessage());
//					RequestDispatcher failureView = req.getRequestDispatcher("/listallFA.jsp");
//					failureView.forward(req,res);
//					
//				}
//			}

	}
}