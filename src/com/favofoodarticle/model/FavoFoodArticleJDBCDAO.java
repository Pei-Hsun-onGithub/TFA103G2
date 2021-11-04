package com.favofoodarticle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.card.model.CardVO;

import util.copy.Util;

public class FavoFoodArticleJDBCDAO implements FavoFoodArticleDAO_interface {
	
	public static final String INSERT_STMT = "INSERT INTO FavoFoodArticle (userId, articleNo) VALUES(?, ?)";
	//public static final String UPDATE = "UPDATE FavoFoodArticle SET msgDate=?, articledate=?, msgContext=?, sta=? where articleno=? && userId=? ";
	public static final String DELETE = "DELETE FROM FavoFoodArticle WHERE userId =? && articleNo=? ";
	public static final String FIND_BY_PK = "SELECT * FROM FavoFoodArticle WHERE userId = ? && articleNo= ?";
	public static final String GET_ALL = "SELECT * FROM FavoFoodArticle";
	public static final String GET_ALL_FAVO_FOOD_ARTICLE_BY_USER_ID = "SELECT * FROM FAVOFOODARTICLE WHERE USERID = ?";
	
	static {
		try {
			Class.forName(Util.DRIVER);			
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}								
	}

	@Override
	public void add(FavoFoodArticleVO favofooar) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1,favofooar.getUserId());
			pstmt.setInt(2,favofooar.getArticleNo());	
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
	public void update(FavoFoodArticleVO favofooar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer userId, Integer articleNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1,userId);
			pstmt.setInt(2,articleNo);
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
	public FavoFoodArticleVO findByPrimaryKey(Integer userId, Integer articleNo) {
		FavoFoodArticleVO ffa = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			
			pstmt.setInt(1,userId);
			pstmt.setInt(2,articleNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ffa = new FavoFoodArticleVO();
				ffa.setUserId(rs.getInt("userId"));
				ffa.setArticleNo(rs.getInt("articleNo"));										
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
		return ffa;		
	}

	@Override
	public List<FavoFoodArticleVO> getall() {
		List<FavoFoodArticleVO> favofooarList = new ArrayList<>();
		FavoFoodArticleVO favofooar = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				favofooar = new FavoFoodArticleVO();
				favofooar.setArticleNo(rs.getInt("userId"));
				favofooar.setUserId(rs.getInt("articleNo"));
				favofooarList.add(favofooar);							
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
		
		return favofooarList;
	}
	
	@Override
	public Set<FavoFoodArticleVO> getAllFavoFoodArticleByUserId(Integer userId) {
		Set<FavoFoodArticleVO> favofoodarticleset = new LinkedHashSet<FavoFoodArticleVO>();
		FavoFoodArticleVO favofoodarticle = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_FAVO_FOOD_ARTICLE_BY_USER_ID);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				favofoodarticle = new FavoFoodArticleVO();
				favofoodarticle.setArticleNo(rs.getInt("articleNo"));
				favofoodarticle.setUserId(rs.getInt("userId"));
				favofoodarticleset.add(favofoodarticle);							
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return favofoodarticleset;
	}
	
}
