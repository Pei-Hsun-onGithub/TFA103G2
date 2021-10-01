package com.achieveprogress.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class AchieveProgressDAOImpl implements AchieveProgressDAO {
	
	private static final String INSERT_STMT = "INSERT INTO ACHIEVEPROGRESS(USERID, ACHIID, CURRENTARTICLE, CURRENTORDER, BEGINDATE, STA) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE ACHIEVEPROGRESS SET CURRENTARTICLE = ?, CURRENTORDER = ?, BEGINDATE = ?, STA = ? WHERE USERID = ? AND ACHIID = ?";
	private static final String DELETE_STMT = "DELETE FROM ACHIEVEPROGRESS WHERE USERID = ? AND ACHIID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM ACHIEVEPROGRESS WHERE USERID = ? AND ACHIID = ?";
	private static final String GET_ALL = "SELECT * FROM ACHIEVEPROGRESS";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(AchieveProgress achieveprogress) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, achieveprogress.getUserId());
			pstmt.setInt(2, achieveprogress.getAchiId());
			pstmt.setInt(3, achieveprogress.getCurrentArticle());
			pstmt.setInt(4, achieveprogress.getCurrentOrder());
			pstmt.setDate(5, achieveprogress.getBeginDate());
			pstmt.setInt(6, achieveprogress.getSta());
		
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
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
	}

	@Override
	public void update(AchieveProgress achieveprogress) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, achieveprogress.getCurrentArticle());
			pstmt.setInt(2, achieveprogress.getCurrentOrder());
			pstmt.setDate(3, achieveprogress.getBeginDate());
			pstmt.setInt(4, achieveprogress.getSta());
			pstmt.setInt(5, achieveprogress.getUserId());
			pstmt.setInt(6, achieveprogress.getAchiId());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
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
	}

	@Override
	public void delete(int userId, int achiId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, userId);
			pstmt.setInt(2, achiId);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
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
	}

	@Override
	public AchieveProgress findByPK(int userId, int achiId) {
		AchieveProgress achp = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, achiId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				achp = new AchieveProgress();
				achp.setUserId(rs.getInt("USERID"));
				achp.setAchiId(rs.getInt("ACHIID"));
				achp.setCurrentArticle(rs.getInt("CURRENTARTICLE"));
				achp.setCurrentOrder(rs.getInt("CURRENTORDER"));
				achp.setBeginDate(rs.getDate("BEGINDATE"));
				achp.setSta(rs.getInt("STA"));
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

		return achp;
	}

	@Override
	public List<AchieveProgress> getAll() {
		List<AchieveProgress> achpList = new ArrayList<>();
		AchieveProgress achp = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				achp = new AchieveProgress();
				achp.setUserId(rs.getInt("USERID"));
				achp.setAchiId(rs.getInt("ACHIID"));
				achp.setCurrentArticle(rs.getInt("CURRENTARTICLE"));
				achp.setCurrentOrder(rs.getInt("CURRENTORDER"));
				achp.setBeginDate(rs.getDate("BEGINDATE"));
				achp.setSta(rs.getInt("STA"));
				achpList.add(achp);
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
		return achpList;
	}

}
