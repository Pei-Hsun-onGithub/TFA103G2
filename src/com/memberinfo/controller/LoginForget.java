package com.memberinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class LoginForget
 */
@WebServlet("/LoginForget")
public class LoginForget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public static class MailService {

		// 設定傳送郵件:至收信人的Email信箱,Email主旨,Email內容
		public void sendMail(String to, String subject, String messageText) {

			try {
				// 設定使用SSL連線至 Gmail smtp Server
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");

				// ●設定 gmail 的帳號 & 密碼 (將藉由你的Gmail來傳送Email)
				// ●須將myGmail的【安全性較低的應用程式存取權】打開
				final String myGmail = "ixlogic.wu@gmail.com";
				final String myGmail_password = "AAA45678AAA";
				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(myGmail, myGmail_password);
					}
				});

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myGmail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				// 設定信中的主旨
				message.setSubject(subject);
				// 設定信中的內容
				message.setText(messageText);

				Transport.send(message);
				System.out.println("傳送成功!");
			} catch (MessagingException e) {
				System.out.println("傳送失敗!");
				e.printStackTrace();
			}
		}
	}

	private static String returnAuthCode() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 8; i++) {
			int condition = (int) (Math.random() * 3) + 1;
			switch (condition) {
			case 1:
				char c1 = (char) ((int) (Math.random() * 26) + 65);
				sb.append(c1);
				break;
			case 2:
				char c2 = (char) ((int) (Math.random() * 26) + 97);
				sb.append(c2);
				break;
			case 3:
				sb.append((int) (Math.random() * 10));
			}
		}
		return sb.toString();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("forgot".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				String email = req.getParameter("email");
				System.out.println(email);
				MemberInfoService memberInfoSvc = new MemberInfoService();
				MemberInfo memberInfo2 = memberInfoSvc.findByEmail3(email);
				System.out.println(memberInfo2);
				

				if (memberInfo2 == null || !memberInfo2.getEmail().equals(email)) {
					errorMsgs.add("輸入帳號不存在");
					
					RequestDispatcher failureView = req.getRequestDispatcher("/login/Login-forget.jsp");
					failureView.forward(req, res);
					return;
					
				}
				
				String userName = memberInfo2.getUserName();
				String to = email;
				String subject = "密碼通知";

				String ch_name = userName;
				String passRandom = returnAuthCode();

				memberInfo2.setPwd(passRandom);

				if (!errorMsgs.isEmpty()) {
					System.out.println(1);
					RequestDispatcher failureView = req.getRequestDispatcher("/login/Login-forget.jsp");
					failureView.forward(req, res);
					return;
				}

				String messageText = "Hello! " + userName + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)";
				MailService mailService = new MailService();
				mailService.sendMail(to, subject, messageText);
				System.out.println(passRandom);

				req.setAttribute("memberInfo2", memberInfo2);
				String url = "/login/Login-login.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
				return;

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				System.out.println(22222);
				RequestDispatcher failureView = req.getRequestDispatcher("/login/Login-forget.jsp");
				failureView.forward(req, res);
			}
			
		}

	}

}
