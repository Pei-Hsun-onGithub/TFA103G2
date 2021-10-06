package com.picturebase.model;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class PibServlet extends HttpServlet {
	Connection con ;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("image/gif");
		ServletOutputStream out =res.getOutputStream();
		
		try {
			Statement stmt = con.createStatement();
			String picno = req.getParameter("picno");
			ResultSet rs= stmt.executeQuery(
					"select pic from PictureBase where picno ="+picno
					);
			
			if(rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("pic"));
				byte[] buf = new byte[4*1024];
				int len ;
				while((len = in.read(buf))!=-1 ) {
					out.write(buf, 0, len);
				}
				in.close();			
			}else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			rs.close();
			stmt.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void init () throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei",
					"root","password");
		}catch(ClassNotFoundException e) {
			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
		}catch(SQLException e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}
	
	
	

}
