package com.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import util.copy.Util;

public  class MessageJDBCDAO implements MessageDAO_interface {

	public static final String INSERT_STMT = "INSERT INTO Message (articleNo,userId, msgDate, msgContent, sta) VALUES(?, ?, ?, ?,?)";
	public static final String UPDATE = "UPDATE Message SET msgDate=?, msgdate=?, msgContext=?, sta=? where msgno=?";
	public static final String DELETE = "DELETE FROM Message WHERE msgno =?";
	public static final String FIND_BY_FK = "SELECT * FROM Message WHERE articleno = ?";
	public static final String GET_ALL = "SELECT * FROM Message";

	static {
		try {
			Class.forName(Util.DRIVER);			
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}								
	
		
	
}

	@Override
	public void add(MessageVO message) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1,message.getArticleNo());
			pstmt.setInt(2,message.getUserId());
			pstmt.setDate(3,message.getMsgDate());
			pstmt.setString(4,message.getMsgContent());
			pstmt.setInt(5,message.getSta());
			pstmt.executeUpdate();
		
		}catch(SQLException se) {
			se.printStackTrace();
		
		}finally {
			
			if(pstmt != null) {
				try {
				pstmt.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
			
			if( con != null) {
				try {
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
			
		}
		
	}

	@Override
	public void update(MessageVO message) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);			
			
			pstmt.setDate(1,message.getMsgDate());
			pstmt.setString(2,message.getMsgContent());
			pstmt.setInt(3,message.getSta());			
			pstmt.setInt(4,message.getMsgNo());
			pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
				pstmt.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
			
			if( con != null) {
				try {
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void delete(Integer msgNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1,msgNo);
			pstmt.executeUpdate();	
		
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
				pstmt.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
			
			if( con != null) {
				try {
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public MessageVO findByFK(Integer articleNo) {
		MessageVO me = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_FK);
			
			pstmt.setInt(1,articleNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				me = new MessageVO();
				me.setMsgNo(rs.getInt("msgNo"));
				me.setArticleNo(rs.getInt("articleNo"));
				me.setMsgDate(rs.getDate("msgDate"));
				me.setMsgContent(rs.getString("msgContent"));
				me.setSta(rs.getInt("sta"));
				
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally{
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}			
			
			if(pstmt != null) {
				try {
				pstmt.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
				
			if( con != null) {
				try {
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		return me;
		
	}

	
	public List<MessageVO> getall() {
		List<MessageVO> meList = new ArrayList<>();
		MessageVO me = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				me = new MessageVO();
				me.setMsgNo(rs.getInt("msgNo"));
				me.setArticleNo(rs.getInt("articleNo"));
				me.setMsgDate(rs.getDate("msgDate"));
				me.setMsgContent(rs.getString("msgContent"));
				me.setSta(rs.getInt("sta"));
				meList.add(me);
				
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally{
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}			
			
			if(pstmt != null) {
				try {
				pstmt.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
				
			if( con != null) {
				try {
					con.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return meList;
	}
}