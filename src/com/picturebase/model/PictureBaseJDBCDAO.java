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
	public static final String FIND_ONE_IMAGE ="SELECT * FROM PictureBase WHERE articleno = ? ORDER BY picno LIMIT 1";
	
	
	public static final String FIND_ONE_BY_PK ="SELECT * FROM fm01.PictureBase WHERE picno = ?;";
	
	
			                                 

	
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
		public List<PictureBaseVO> findByFK(Integer articleNo) {
			List<PictureBaseVO> list = new ArrayList<>();
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
					list.add(pb);
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
			return list;		
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

		@Override
		public void insertWithArticle(PictureBaseVO pbVO, Connection con) {
			PreparedStatement pstmt = null;
			
			try {
				pstmt=con.prepareStatement(INSERT_STMT);
				pstmt.setInt(1,pbVO.getArticleNo());	
				pstmt.setBytes(2, pbVO.getPic());								
				pstmt.executeUpdate();
				
				
				
			}catch (SQLException se) {
				if (con != null) {
					try {
						// 3●設定於當有exception發生時之catch區塊內
						System.err.print("Transaction is being ");
						System.err.println("rolled back-由-emp");
						con.rollback();
					} catch (SQLException excep) {
						throw new RuntimeException("rollback error occured. "
								+ excep.getMessage());
					}
				}
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
			}
			
			
		}

		@Override
		public PictureBaseVO findOnePic(Integer articleNo) {			
			PictureBaseVO pbVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(FIND_ONE_IMAGE);
				
				
				pstmt.setInt(1,articleNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					pbVO = new PictureBaseVO();
					pbVO.setPicNo(rs.getInt("picNo"));
					pbVO.setArticleNo(rs.getInt("articleNo"));
					pbVO.setPic(rs.getBytes("pic"));
					
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
			return pbVO;
			
		}

		@Override
		public PictureBaseVO findOnePicByPK(Integer picNo) {
			PictureBaseVO pbVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(FIND_ONE_BY_PK);
				
				
				pstmt.setInt(1,picNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					pbVO = new PictureBaseVO();
					pbVO.setPicNo(rs.getInt("picNo"));
					pbVO.setArticleNo(rs.getInt("articleNo"));
					pbVO.setPic(rs.getBytes("pic"));
					
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
			return pbVO;
		}
		
			
}
