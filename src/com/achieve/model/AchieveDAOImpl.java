package com.achieve.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class AchieveDAOImpl implements AchieveDAO {
	
	private static final String INSERT_STMT = "INSERT INTO ACHIEVE( ACHINAME, DESCRIPT, OPENDATE, VALIDDAYS, ACHIARTICLE, ACHIORDER, GAINFEED, GAINGOLD, ACHIPIC) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE ACHIEVE SET ACHINAME = ?, DESCRIPT = ?, OPENDATE = ?, VALIDDAYS = ?, ACHIARTICLE = ?, ACHIORDER = ?, GAINFEED = ?, GAINGOLD = ?, ACHIPIC = ? WHERE ACHIID = ?";
	private static final String DELETE_STMT = "DELETE FROM ACHIEVE WHERE ACHIID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM ACHIEVE WHERE ACHIID = ?";
	private static final String GET_ALL = "SELECT * FROM ACHIEVE";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(Achieve achieve) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, achieve.getAchiName());
			pstmt.setString(2, achieve.getDescript());
			pstmt.setDate(3, achieve.getOpenDate());
			pstmt.setInt(4, achieve.getValidDays());
			pstmt.setInt(5, achieve.getAchiArticle());
			pstmt.setInt(6, achieve.getAchiOrder());
			pstmt.setInt(7, achieve.getGainFeed());
			pstmt.setInt(8, achieve.getGainGold());
			pstmt.setBytes(9, achieve.getAchiPic());
			

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
	public void update(Achieve achieve) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, achieve.getAchiName());
			pstmt.setString(2, achieve.getDescript());
			pstmt.setDate(3, achieve.getOpenDate());
			pstmt.setInt(4, achieve.getValidDays());
			pstmt.setInt(5, achieve.getAchiArticle());
			pstmt.setInt(6, achieve.getAchiOrder());
			pstmt.setInt(7, achieve.getGainFeed());
			pstmt.setInt(8, achieve.getGainGold());
			pstmt.setBytes(9, achieve.getAchiPic());
			pstmt.setInt(10, achieve.getAchiId());

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
	public void delete(Integer achiId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, achiId);
			
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
	public Achieve findByPK(Integer achiId) {
		Achieve ach = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, achiId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ach = new Achieve();
				ach.setAchiId(rs.getInt("ACHIID"));
				ach.setAchiName(rs.getString("ACHINAME"));
				ach.setDescript(rs.getString("DESCRIPT"));
				ach.setOpenDate(rs.getDate("OPENDATE"));
				ach.setValidDays(rs.getInt("VALIDDAYS"));
				ach.setAchiArticle(rs.getInt("ACHIARTICLE"));
				ach.setAchiOrder(rs.getInt("ACHIORDER"));
				ach.setGainFeed(rs.getInt("GAINFEED"));
				ach.setGainGold(rs.getInt("GAINGOLD"));
				ach.setAchiPic(rs.getBytes("ACHIPIC"));
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

		return ach;
	}

	@Override
	public List<Achieve> getAll() {
		List<Achieve> achList = new ArrayList<>();
		Achieve ach = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ach = new Achieve();
				ach.setAchiId(rs.getInt("ACHIID"));
				ach.setAchiName(rs.getString("ACHINAME"));
				ach.setDescript(rs.getString("DESCRIPT"));
				ach.setOpenDate(rs.getDate("OPENDATE"));
				ach.setValidDays(rs.getInt("VALIDDAYS"));
				ach.setAchiArticle(rs.getInt("ACHIARTICLE"));
				ach.setAchiOrder(rs.getInt("ACHIORDER"));
				ach.setGainFeed(rs.getInt("GAINFEED"));
				ach.setGainGold(rs.getInt("GAINGOLD"));
				ach.setAchiPic(rs.getBytes("ACHIPIC"));
				achList.add(ach);
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
		return achList;
	}
	
	
}
