package com.monsterbook.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class MonsterBookDAOImpl implements MonsterBookDAO {
	
	private static final String INSERT_STMT = "INSERT INTO MONSTERBOOK(MONSTERID, MINDEMANDLEVEL, MONSTERNAME, MONSTERABILITY, MONSTERPIC) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE MONSTERBOOK SET MINDEMANDLEVEL = ?, MONSTERNAME = ?, MONSTERABILITY = ?, MONSTERPIC = ? WHERE MONSTERID = ?";
	private static final String DELETE_STMT = "DELETE FROM MONSTERBOOK WHERE MONSTERID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM MONSTERBOOK WHERE MONSTERID = ?";
	private static final String GET_ALL = "SELECT * FROM MONSTERBOOK";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(MonsterBook monsterbook) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, monsterbook.getMonsterId());
			pstmt.setInt(2, monsterbook.getMinDemandLevel());
			pstmt.setString(3, monsterbook.getMonsterName());
			pstmt.setString(4, monsterbook.getMonsterAbility());
			pstmt.setBytes(5, monsterbook.getMonsterPic());
			
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
	public void update(MonsterBook monsterbook) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, monsterbook.getMinDemandLevel());
			pstmt.setString(2, monsterbook.getMonsterName());
			pstmt.setString(3, monsterbook.getMonsterAbility());
			pstmt.setBytes(4, monsterbook.getMonsterPic());
			pstmt.setInt(5, monsterbook.getMonsterId());

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
	public void delete(Integer monsterId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, monsterId);
			
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
	public MonsterBook findByPK(Integer monsterId) {
		MonsterBook mon = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, monsterId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mon = new MonsterBook();
				mon.setMonsterId(rs.getInt("MONSTERID"));
				mon.setMinDemandLevel(rs.getInt("MINDEMANDLEVEL"));
				mon.setMonsterName(rs.getString("MONSTERNAME"));
				mon.setMonsterAbility(rs.getString("MONSTERABILITY"));
				mon.setMonsterPic(rs.getBytes("MONSTERPIC"));
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

		return mon;
	}

	@Override
	public List<MonsterBook> getAll() {
		List<MonsterBook> monList = new ArrayList<>();
		MonsterBook mon = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mon = new MonsterBook();
				mon.setMonsterId(rs.getInt("MONSTERID"));
				mon.setMinDemandLevel(rs.getInt("MINDEMANDLEVEL"));
				mon.setMonsterName(rs.getString("MONSTERNAME"));
				mon.setMonsterAbility(rs.getString("MONSTERABILITY"));
				mon.setMonsterPic(rs.getBytes("MONSTERPIC"));
				monList.add(mon);
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
		return monList;
	}

}
