package com.card.controller;

import java.io.*;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.card.model.*;
import com.favofoodarticle.model.FavoFoodArticleService;
import com.favofoodarticle.model.FavoFoodArticleVO;
import com.memberinfo.model.*;
import com.rsorder.model.RsOrderDAOService;
import com.rsorder.model.RsOrderVO;

@MultipartConfig

public class CardServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		RsOrderDAOService rsOrderSvc = new RsOrderDAOService();
		Set<RsOrderVO> rsorderset = rsOrderSvc.getRsOrderByUserId(20210001);
		System.out.println(rsorderset);
		FavoFoodArticleService favofoodarticleSvc = new FavoFoodArticleService();
		Set<FavoFoodArticleVO> favofoodarticleset = favofoodarticleSvc
				.getAllFavoFoodArticleByUserId(20210001);
		System.out.println(favofoodarticleset);
		if ("getAllCard".equals(action)) {
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo mem = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", mem);
			Integer member = mem.getUserId();
			CardDAOService cardSvc = new CardDAOService();
			Set<CardVO> cardset = cardSvc.getCardByUserId(member);
			req.setAttribute("cardset", cardset);
			String url = "/Gary_pages/Member03.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("showInsertCard".equals(action)) {

			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo member = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", member);
			String url = "/Gary_pages/Member03-addcard.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("showUpdateCard".equals(action)) {
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo member = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", member);
//
			Integer cardid = new Integer(req.getParameter("cardId"));
			CardDAOService cardSvc = new CardDAOService();
			CardVO card = cardSvc.getCardDAO(cardid);
			req.setAttribute("cardvo", card);

			String url = "/Gary_pages/Member03-editcard.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("insertOneCard".equals(action)) {
			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo mem = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", mem);

			List<String> errorMsgs = new LinkedList<String>();
//			System.out.println("1="+errorMsgs);
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				Integer userId = new Integer(req.getParameter("userId"));

				String cardHolder = req.getParameter("cardHolder");
				String cardHolderReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (cardHolder == null || cardHolder.trim().length() == 0) {
					errorMsgs.add("信用卡持有者空");
				} else if (!cardHolder.trim().matches(cardHolderReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("持有者名稱錯誤");
				}

				String cardNumber = req.getParameter("cardNumber");
				String cardVISAReg = "^4\\d{15}$";
				String cardMasterReg = "^5[1-5]\\d{14}$";
				String cardDiscoverReg = "^6(?:011\\d\\d|5\\d{4}|4[4-9]\\d{3}|22(?:1(?:2[6-9]|[3-9]\\d)|[2-8]\\d\\d|9(?:[01]\\d|2[0-5])))\\d{10}$";
				String cardJCBReg = "^35(?:2[89]|[3-8]\\d)\\d{12}$";
				String cardExpressReg = "^3[47]\\d{13}$";
				String cardUnionPayReg = "^62[0-5]\\d{13,16}$";
				String cardMaestroReg = "^(?:5[0678]\\d\\d|6304|6390|67\\d\\d)\\d{8,15}$";
				if (cardNumber == null || cardNumber.trim().length() == 0) {
					errorMsgs.add("信用卡號為空白");
				} else if (!cardNumber.trim().matches(cardVISAReg) && !cardNumber.trim().matches(cardMasterReg)
						&& !cardNumber.trim().matches(cardDiscoverReg) && !cardNumber.trim().matches(cardJCBReg)
						&& !cardNumber.trim().matches(cardExpressReg) && !cardNumber.trim().matches(cardUnionPayReg)
						&& !cardNumber.trim().matches(cardMaestroReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("不符合卡規");
				}

				Date deadLine = java.sql.Date.valueOf(req.getParameter("deadLine").trim());

				String cvv = req.getParameter("cvv");
				if (cvv == null || cvv.trim().length() == 0) {
					errorMsgs.add("cvv為空");
				}

				String billAddress = req.getParameter("billAddress");
				if (billAddress == null || billAddress.trim().length() == 0) {
					errorMsgs.add("地址為空");
				}

				String zipCode = req.getParameter("zipCode");
				if (zipCode == null || zipCode.trim().length() == 0) {
					errorMsgs.add("郵遞區號為空");
				}

				CardVO cardVO = new CardVO();
				cardVO.setUserId(userId);
				cardVO.setCardHolder(cardHolder);
				cardVO.setCardNumber(cardNumber);
				cardVO.setDeadLine(deadLine);
				cardVO.setCvv(cvv);
				cardVO.setBillAddress(billAddress);
				cardVO.setZipCode(zipCode);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("cardvo", cardVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member03-addcard.jsp");
					failureView.forward(req, res);
					return;
				}

				CardDAOService cardSvc = new CardDAOService();
				cardVO = cardSvc.addCardDAO(userId, cardHolder, cardNumber, deadLine, cvv, billAddress, zipCode, 1);
				System.out.println("bbb");
				Integer member = mem.getUserId();
				Set<CardVO> cardset = cardSvc.getCardByUserId(member);
				req.setAttribute("cardset", cardset);
				String url = "/Gary_pages/Member03.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("錯誤:" + e.getMessage());
				System.out.println("2=" + errorMsgs);
//				System.out.println(e);
				RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member03-addcard.jsp");
				failureView.forward(req, res);
			}

		}

		if ("updateOneCard".equals(action)) {

			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo mem = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", mem);

			List<String> errorMsgs = new LinkedList<String>();
//			System.out.println("1="+errorMsgs);
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				Integer cardId = new Integer(req.getParameter("cardId"));

				Set<CardVO> cardset = (Set<CardVO>) session.getAttribute("cardset");

				CardVO waitingForUpdatecCardVO = null;

				for (CardVO cardvo : cardset) {

					if (cardId.equals(cardvo.getCardId())) {
						waitingForUpdatecCardVO = cardvo;
					}
				}

				Integer userId = new Integer(req.getParameter("userId"));

				String cardHolder = req.getParameter("cardHolder");
				String cardHolderReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

				if (cardHolder == null || cardHolder.trim().length() == 0) {
					errorMsgs.add("���d�H: �ФŪť�");
				} else if (!cardHolder.trim().matches(cardHolderReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
				}

				String cardNumber = req.getParameter("cardNumber");
				String cardVISAReg = "^4\\d{15}$";
				String cardMasterReg = "^5[1-5]\\d{14}$";
				String cardDiscoverReg = "^6(?:011\\d\\d|5\\d{4}|4[4-9]\\d{3}|22(?:1(?:2[6-9]|[3-9]\\d)|[2-8]\\d\\d|9(?:[01]\\d|2[0-5])))\\d{10}$";
				String cardJCBReg = "^35(?:2[89]|[3-8]\\d)\\d{12}$";
				String cardExpressReg = "^3[47]\\d{13}$";
				String cardUnionPayReg = "^62[0-5]\\d{13,16}$";
				String cardMaestroReg = "^(?:5[0678]\\d\\d|6304|6390|67\\d\\d)\\d{8,15}$";
				if (cardNumber == null || cardNumber.trim().length() == 0) {
					errorMsgs.add("�H�Υd�d��: �ФŪť�");
				} else if (!cardNumber.trim().matches(cardVISAReg) && !cardNumber.trim().matches(cardMasterReg)
						&& !cardNumber.trim().matches(cardDiscoverReg) && !cardNumber.trim().matches(cardJCBReg)
						&& !cardNumber.trim().matches(cardExpressReg) && !cardNumber.trim().matches(cardUnionPayReg)
						&& !cardNumber.trim().matches(cardMaestroReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add(
							"�z��J���d�����ŦX:VISA�BMaster�BDiscover�BJCB�BAmerican Express�BChina UnionPay�BMaestro�d�ؤ��W�w�榡�A�Э��s�T�{���J�I");
				}

				Date deadLine = java.sql.Date.valueOf(req.getParameter("deadLine").trim());

				String cvv = req.getParameter("cvv");
				if (cvv == null || cvv.trim().length() == 0) {
					errorMsgs.add("�w���X: �ФŪť�");
				}

				String billAddress = req.getParameter("billAddress");
				if (billAddress == null || billAddress.trim().length() == 0) {
					errorMsgs.add("�a�}: �ФŪť�");
				}

				String zipCode = req.getParameter("zipCode");
				if (zipCode == null || zipCode.trim().length() == 0) {
					errorMsgs.add("�l���ϸ�: �ФŪť�");
				}

				Integer sta = new Integer(req.getParameter("sta"));

				waitingForUpdatecCardVO.setCardId(cardId);
				waitingForUpdatecCardVO.setUserId(userId);
				waitingForUpdatecCardVO.setCardHolder(cardHolder);
				waitingForUpdatecCardVO.setCardNumber(cardNumber);
				waitingForUpdatecCardVO.setDeadLine(deadLine);
				waitingForUpdatecCardVO.setCvv(cvv);
				waitingForUpdatecCardVO.setBillAddress(billAddress);
				waitingForUpdatecCardVO.setZipCode(zipCode);
				waitingForUpdatecCardVO.setSta(sta);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("cardvo", waitingForUpdatecCardVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member03-editcard.jsp");
					failureView.forward(req, res);
					return;
				}

				CardDAOService cardSvc = new CardDAOService();
				waitingForUpdatecCardVO = cardSvc.updateCardDAO(cardId, userId, cardHolder, cardNumber, deadLine, cvv,
						billAddress, zipCode, sta);

				req.setAttribute("cardset", cardset);
				session.setAttribute("cardset", cardset);

				String url = "/Gary_pages/Member03.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);

			} catch (Exception e) {
//				e.printStackTrace();
				errorMsgs.add("�s�W����:" + e.getMessage());
//				System.out.println("2="+errorMsgs);
//				System.out.println(e);
				RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member03-editcard.jsp");
				e.printStackTrace();
				failureView.forward(req, res);
			}

		}

		if ("deleteCard".equals(action)) {

			MemberInfoService memberSvc = new MemberInfoService();
			HttpSession session = req.getSession();
			MemberInfo mem = memberSvc.getOneMemberInfo((Integer) session.getAttribute("userId"));
			req.setAttribute("memberinfo", mem);

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				
				Integer cardId = new Integer(req.getParameter("cardId"));

				Set<CardVO> cardset = (Set<CardVO>) session.getAttribute("cardset");

				CardDAOService cardSvc = new CardDAOService();
				CardVO cardVO = cardSvc.getCardDAO(cardId);
				cardSvc.deleteCardDAO(cardId);

				cardset.remove(cardVO);

				req.setAttribute("cardset", cardset);
				session.setAttribute("cardset", cardset);
				
				String url = "/Gary_pages/Member03.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/Gary_pages/Member03.jsp");
				failureView.forward(req, res);
			}
		}
	}

}