package com.restaurantstyle.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.style.model.StyleJDBCDAO;
import com.style.model.StyleVO;

public class RestaurantStyleJDBCDAO implements RestaurantStyleDAO_interface{

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	private static final String userid = "David";
	private static final String passwd = "123456";
	
	private static final String INSERT_STMT = "INSERT INTO RestaurantStyle (restaurantId, styleId) VALUES (?, ?)";
	
	private static final String UPDATE_STMT = "UPDATE RestaurantStyle SET restaurantId = ?, styleId = ? WHERE restaurantId = ? AND styleId=?";
	
	private static final String DELETE = "DELETE FROM RestaurantStyle where restaurantId = ? and styleId = ?";
	private static final String GET_ALL_STMT = "SELECT * FROM RestaurantStyle ";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());
		}
	}
	
	
	@Override
	public void insert(RestaurantStyleVO restaurantStyleVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, restaurantStyleVO.getRestaurantId());
			pstmt.setInt(2, restaurantStyleVO.getStyleId());
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		
	}
	
	@Override
	public void update(RestaurantStyleVO newRestaurantStyleVO, RestaurantStyleVO oldRestaurantStyleVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, newRestaurantStyleVO.getRestaurantId());
			pstmt.setInt(2, newRestaurantStyleVO.getStyleId());
			pstmt.setInt(3, oldRestaurantStyleVO.getRestaurantId());
			pstmt.setInt(4, oldRestaurantStyleVO.getStyleId());
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		
	}

	

	@Override
	public void delete(RestaurantStyleVO restaurantStyleVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, restaurantStyleVO.getRestaurantId());
			pstmt.setInt(2, restaurantStyleVO.getStyleId());
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	}

	

	@Override
	public List<RestaurantStyleVO> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		RestaurantStyleVO restaurantStyleVO = null;
		List<RestaurantStyleVO> rows = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();	
			
			rs = stmt.executeQuery(GET_ALL_STMT);
			rows = new ArrayList();

			while(rs.next()) {
				restaurantStyleVO = new RestaurantStyleVO();
				restaurantStyleVO.setRestaurantId((rs.getInt("restaurantid")));
				restaurantStyleVO.setStyleId(rs.getInt("styleid"));
				
				rows.add(restaurantStyleVO);
			}
			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();					
				} catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(stmt != null) {
				try {
					stmt.close();					
				} catch(SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();					
				} catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return rows;
	}

	public static void main(String[] args) {
		RestaurantStyleJDBCDAO rsDAO = new RestaurantStyleJDBCDAO();
		RestaurantStyleVO restaurantStyleVO = new RestaurantStyleVO();
		
		restaurantStyleVO.setRestaurantId(7001);
		restaurantStyleVO.setStyleId(50);
		
		/* test insert */
		rsDAO.insert(restaurantStyleVO);
		/* test delete */
//		rsDAO.delete(restaurantStyleVO);
	      /*test getAll*/
	 for(RestaurantStyleVO row : rsDAO.getAll()) {
		 System.out.println(row);
	 }

	}

}
