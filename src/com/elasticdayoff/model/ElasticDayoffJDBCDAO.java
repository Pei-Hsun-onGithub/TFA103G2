package com.elasticdayoff.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meal.model.MealJDBCDAO;
import com.meal.model.MealVO;
import com.style.model.StyleVO;

public class ElasticDayoffJDBCDAO implements ElasticDayoffDAO_interface {
	
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	private static final String userid = "chou";
	private static final String passwd = "chou79";
	
	private static final String INSERT_STMT = "INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (?,?)";
	private static final String UPDATE_STMT = "UPDATE ElasticDayoff SET restaurantid = ?, newWeeklyleave = ? WHERE dayoffId = ?";
	private static final String DELETE = "DELETE FROM ElasticDayoff WHERE dayoffId = ? ";
	
	private static final String GET_ONE_STMT = "SELECT * FROM ElasticDayoff WHERE dayoffId = ? ";
	private static final String GET_ALL_STMT = "SELECT * FROM ElasticDayoff ";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());
		}
	}

	

	@Override
	public void insert(ElasticDayoffVO elasticDayoffVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, elasticDayoffVO.getRestaurantId());
			pstmt.setString(2, elasticDayoffVO.getNewWeeklyLeave());
			
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
	public void update(ElasticDayoffVO elasticDayoffVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

			
			pstmt.setInt(1, elasticDayoffVO.getRestaurantId());
			pstmt.setString(2, elasticDayoffVO.getNewWeeklyLeave());
			pstmt.setInt(3, elasticDayoffVO.getDayoffId());

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
	public void delete(Integer dayoffId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, dayoffId);
			
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
	public ElasticDayoffVO findByPrimaryKey(Integer dayoffId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ElasticDayoffVO elasticDayoffVO = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, dayoffId);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				elasticDayoffVO = new ElasticDayoffVO();
				elasticDayoffVO.setDayoffId(dayoffId);
				elasticDayoffVO.setRestaurantId(rs.getInt("restaurantid"));
				elasticDayoffVO.setNewWeekLeave(rs.getString("newWeeklyleave"));
				
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return elasticDayoffVO;
	}

	@Override
	public List<ElasticDayoffVO> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ElasticDayoffVO elasticDayoffVO = null;
		List<ElasticDayoffVO> rows = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();	
			
			rs = stmt.executeQuery(GET_ALL_STMT);
			rows = new ArrayList();

			while(rs.next()) {
				elasticDayoffVO = new ElasticDayoffVO();
				elasticDayoffVO.setDayoffId(rs.getInt("dayoffid"));
				elasticDayoffVO.setRestaurantId(rs.getInt("restaurantid"));
				elasticDayoffVO.setNewWeekLeave(rs.getString("newWeeklyleave"));
				
				rows.add(elasticDayoffVO);
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
		
		// test insert
		ElasticDayoffVO elasticVO = new ElasticDayoffVO();
		ElasticDayoffJDBCDAO eDAO = new ElasticDayoffJDBCDAO();
		
//		eDAO.insert(elasticVO);
		
		/* test update*/
		elasticVO.setDayoffId(43);
		elasticVO.setRestaurantId(7003);
		elasticVO.setNewWeekLeave("1111111");
		eDAO.update(elasticVO);
		/* test delete*/
//		eDAO.delete(41);
		
		/* test getByPK*/
//		System.out.println(eDAO.findByPrimaryKey(43));
		// test getAll
		 for(ElasticDayoffVO row : eDAO.getAll()) {
			 System.out.println(row);
		 }
		
	}

}
