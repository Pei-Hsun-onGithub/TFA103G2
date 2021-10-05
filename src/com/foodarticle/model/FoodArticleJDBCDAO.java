package com.foodarticle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodArticleJDBCDAO implements FoodArticleDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	
	
	public static final String INSERT_STMT = 
			"INSERT INTO FoodArticle (userid, restaurantid, articletitle, articledate, articlecontent, sta) VALUES(?, ?, ?, ?, ?, ?)";
	public static final String UPDATE = 
			"UPDATE FoodArticle SET restaurantid=?, articletitle=?, articledate=?, articlecontent=?, sta=? where articleno=?";
	public static final String DELETE = "DELETE FROM FoodArticle WHERE articleno =? ";
	public static final String FIND_BY_PK = "SELECT * FROM FoodArticle WHERE articleno = ?";
	public static final String GET_ALL = "SELECT * FROM FoodArticle";
	
	static {
		try {
			Class.forName(DRIVER);			
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}									
	}
	
	public void add(FoodArticleVO foodArticle) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			//pstmt.setInt(1,foodarticle.getArticleno());自動編號不用新增
			pstmt.setInt(1,foodArticle.getUserId());
			pstmt.setInt(2,foodArticle.getRestaurantId());
			pstmt.setString(3,foodArticle.getArticleTitle());
			pstmt.setDate(4,foodArticle.getArticleDate());
			pstmt.setString(5,foodArticle.getArticleContent());
			pstmt.setInt(6,foodArticle.getSta());
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
	public void update(FoodArticleVO foodArticle) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			
			pstmt.setInt(1,foodArticle.getRestaurantId());
			pstmt.setString(2,foodArticle.getArticleTitle());
			pstmt.setDate(3,foodArticle.getArticleDate());
			pstmt.setString(4,foodArticle.getArticleContent());
			pstmt.setInt(5,foodArticle.getSta());
			pstmt.setInt(6,foodArticle.getArticleNo());
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
	public void delete(Integer articleNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1,articleNo);
			
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
	public FoodArticleVO findByPrimaryKey(Integer articleNo) {
		// TODO Auto-generated method stub
		
		FoodArticleVO far =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			
			pstmt.setInt(1,articleNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				far = new FoodArticleVO();
				far.setArticleNo(rs.getInt("articleNo"));
				far.setUserId(rs.getInt("userId"));
				far.setRestaurantId(rs.getInt("restaurantId"));
				far.setArticleTitle(rs.getString("articleTitle"));
				far.setArticleDate(rs.getDate("articleDate"));
				far.setArticleContent(rs.getString("articleContent"));
				far.setSta(rs.getInt("sta"));
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
		return far;
	}
		
		
		
	

	@Override
	public List<FoodArticleVO> getall() {
		// TODO Auto-generated method stub
		List<FoodArticleVO> farList = new ArrayList<>();
		FoodArticleVO far =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				far = new FoodArticleVO();
				far.setArticleNo(rs.getInt("articleNo"));
				far.setUserId(rs.getInt("userId"));
				far.setRestaurantId(rs.getInt("restaurantId"));
				far.setArticleTitle(rs.getString("articleTitle"));
				far.setArticleDate(rs.getDate("articleDate"));
				far.setArticleContent(rs.getString("articleContent"));
				far.setSta(rs.getInt("sta"));
				farList.add(far);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
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
		
		return farList;
	}
	
}
