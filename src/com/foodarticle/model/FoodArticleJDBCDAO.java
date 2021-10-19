package com.foodarticle.model;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.picturebase.model.PictureBaseJDBCDAO;
import com.picturebase.model.PictureBaseVO;

public class FoodArticleJDBCDAO implements FoodArticleDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	public static final String USER = "David";
	public static final String PASSWORD = "123456";
	
	
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
			
		  //pstmt.setInt(1,foodarticle.getArticleno());�ۼW�䤣�Τ�ʼW�[
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

	@Override
	public void insertWithPic(FoodArticleVO foodArticleVO, List<PictureBaseVO> list){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// ������autocommit,�bpstm.executeUpdate()���e
			con.setAutoCommit(false);
			
			//���s�W�峹
			
			String[] cols = {"articleno"};
			pstmt=con.prepareStatement(INSERT_STMT, cols);
			pstmt.setInt(1,foodArticleVO.getUserId());
			pstmt.setInt(2,foodArticleVO.getRestaurantId());
			pstmt.setString(3,foodArticleVO.getArticleTitle());
			pstmt.setDate(4,foodArticleVO.getArticleDate());
			pstmt.setString(5,foodArticleVO.getArticleContent());
			pstmt.setInt(6,foodArticleVO.getSta());
			pstmt.executeUpdate();
			
			//��X���s�W���ۼWpk
			
			String new_articleNo =null;
			ResultSet rs =  pstmt.getGeneratedKeys();
			if(rs.next()) {
				new_articleNo =rs.getString(1);
			}
			rs.close();
			
		//�A�P�ɷs�W�Ϥ�
			
			PictureBaseJDBCDAO pbdao = new PictureBaseJDBCDAO();
			
			for(PictureBaseVO pbVO: list) {
				System.out.println("jdbc="+pbVO);
				pbVO.setArticleNo(new Integer(new_articleNo));
				pbdao.insertWithArticle(pbVO, con);				
			}
			
			con.commit();
			con.setAutoCommit(true);			
			
			
		
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3���]�w���exception�o�ͮɤ�catch�϶���
					System.err.print("Transaction is being ");
					System.err.println("rolled back-��-dept");
					con.rollback();
//					return false;
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
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
//		return true;
		
		
		
	}
	
}
