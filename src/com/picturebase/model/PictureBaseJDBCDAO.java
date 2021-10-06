package com.picturebase.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import util.copy.Util;

public class PictureBaseJDBCDAO implements PictureBaseDAO_interface {
	public static final String INSERT_STMT = "INSERT INTO PictureBase (articleno, pic) VALUES(?, ?)";
	public static final String UPDATE = "UPDATE PictureBase SET pic=? where picno=?";
	public static final String DELETE = "DELETE FROM PictureBase WHERE picno =?";
	public static final String FIND_ONE = "SELECT * FROM PictureBase WHERE articleno = ? ";
	public static final String GET_ALL = "SELECT * FROM PictureBase";

	static {
		try {
			Class.forName(Util.DRIVER);			
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
		
		@Override
		public void add(PictureBaseVO  picbase) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
				pstmt = con.prepareStatement(INSERT_STMT);
				
				pstmt.setInt(1,picbase.getArticleNo());	
				pstmt.setBytes(2, picbase.getPic());								
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
		public void update(PictureBaseVO  picbase) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
				pstmt = con.prepareStatement(UPDATE);
				
				pstmt.setBytes(1,picbase.getPic());
				pstmt.setInt(2,picbase.getPicNo());
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

		
		public void delete(Integer picNo) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try{
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(DELETE);
				
				pstmt.setInt(1,picNo);
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
		public PictureBaseVO findByFK(Integer articleNo) {
			PictureBaseVO pb = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(FIND_ONE);
				
				
				pstmt.setInt(1,articleNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					pb = new PictureBaseVO();
					pb.setPicNo(rs.getInt("picNo"));
					pb.setArticleNo(rs.getInt("articleNo"));
					pb.setPic(rs.getBytes("pic"));
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
			return pb;		
		}

		@Override
		public List<PictureBaseVO> getall() {
			List<PictureBaseVO> picbaseList = new ArrayList<>();
			PictureBaseVO  picbase = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(GET_ALL);			
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					picbase = new PictureBaseVO();
					picbase.setPicNo(rs.getInt("picNo"));
					picbase.setArticleNo(rs.getInt("articleNo"));
					picbase.setPic(rs.getBytes("pic"));
					picbaseList.add(picbase);							
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
			
			return picbaseList;
		}
		
			
}
