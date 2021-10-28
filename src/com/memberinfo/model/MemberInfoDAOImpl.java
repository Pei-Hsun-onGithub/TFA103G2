package com.memberinfo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class MemberInfoDAOImpl implements MemberInfoDAO {
	
	private static final String INSERT_STMT = "INSERT INTO MEMBERINFO(EMAIL, PWD, USERNAME, GENDER, BIRTHDAY, PHONE, PIC, REGISTERDATE, GOLD, FEED, MONSTERID, MONSTERNICKNAME, LV, EXP, STA) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE MEMBERINFO SET EMAIL = ?, PWD = ?, USERNAME = ?, GENDER = ?, BIRTHDAY = ?, PHONE = ?, PIC = ?, REGISTERDATE = ?, GOLD = ?, FEED = ?, MONSTERID = ?, MONSTERNICKNAME = ?, LV = ?, EXP = ?, STA = ? WHERE USERID = ?";
	private static final String DELETE_STMT = "DELETE FROM MEMBERINFO WHERE USERID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM MEMBERINFO WHERE USERID = ?";
	private static final String GET_ALL = "SELECT * FROM MEMBERINFO"; 
	private static final String FIND_BY_EMAIL = "SELECT * FROM MEMBERINFO WHERE EMAIL = ?";
	private static final String FIND_BY_PWD = "SELECT * FROM MEMBERINFO WHERE PWD = ?";
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(MemberInfo memberinfo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberinfo.getEmail());
			pstmt.setString(2, memberinfo.getPwd());
			pstmt.setString(3, memberinfo.getUserName());
			pstmt.setString(4, memberinfo.getGender());
			pstmt.setDate(5, memberinfo.getBirthday());
			pstmt.setString(6, memberinfo.getPhone());
			pstmt.setBytes(7, memberinfo.getPic());
			pstmt.setDate(8, memberinfo.getRegisterDate());
			pstmt.setInt(9, memberinfo.getGold());
			pstmt.setInt(10, memberinfo.getFeed());
			pstmt.setInt(11, memberinfo.getMonsterId());
			pstmt.setString(12, memberinfo.getMonsterNickName());
			pstmt.setInt(13, memberinfo.getLv());
			pstmt.setInt(14, memberinfo.getExp());
			pstmt.setInt(15, memberinfo.getSta());
		
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
	public void update(MemberInfo memberinfo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, memberinfo.getEmail());
			pstmt.setString(2, memberinfo.getPwd());
			pstmt.setString(3, memberinfo.getUserName());
			pstmt.setString(4, memberinfo.getGender());
			pstmt.setDate(5, memberinfo.getBirthday());
			pstmt.setString(6, memberinfo.getPhone());
			pstmt.setBytes(7, memberinfo.getPic());
			pstmt.setDate(8, memberinfo.getRegisterDate());
			pstmt.setInt(9, memberinfo.getGold());
			pstmt.setInt(10, memberinfo.getFeed());
			pstmt.setInt(11, memberinfo.getMonsterId());
			pstmt.setString(12, memberinfo.getMonsterNickName());
			pstmt.setInt(13, memberinfo.getLv());
			pstmt.setInt(14, memberinfo.getExp());
			pstmt.setInt(15, memberinfo.getSta());
			pstmt.setInt(16, memberinfo.getUserId());

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
	public void delete(Integer userId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, userId);
			
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
	public MemberInfo findByPK(Integer userId) {
		MemberInfo mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new MemberInfo();
				mem.setUserId(rs.getInt("USERID"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setPwd(rs.getString("PWD"));
				mem.setUserName(rs.getString("USERNAME"));
				mem.setGender(rs.getString("GENDER"));
				mem.setBirthday(rs.getDate("BIRTHDAY"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setPic(rs.getBytes("PIC"));
				mem.setRegisterDate(rs.getDate("REGISTERDATE"));
				mem.setGold(rs.getInt("GOLD"));
				mem.setFeed(rs.getInt("FEED"));
				mem.setMonsterId(rs.getInt("MONSTERID"));
				mem.setMonsterNickName(rs.getString("MONSTERNICKNAME"));
				mem.setLv(rs.getInt("LV"));
				mem.setExp(rs.getInt("EXP"));
				mem.setSta(rs.getInt("STA"));
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

		return mem;
	}

	@Override
	public List<MemberInfo> getAll() {
		List<MemberInfo> memList = new ArrayList<>();
		MemberInfo mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new MemberInfo();
				mem.setUserId(rs.getInt("USERID"));
				mem.setEmail(rs.getString("EMAIL"));
				mem.setPwd(rs.getString("PWD"));
				mem.setUserName(rs.getString("USERNAME"));
				mem.setGender(rs.getString("GENDER"));
				mem.setBirthday(rs.getDate("BIRTHDAY"));
				mem.setPhone(rs.getString("PHONE"));
				mem.setPic(rs.getBytes("PIC"));
				mem.setRegisterDate(rs.getDate("REGISTERDATE"));
				mem.setGold(rs.getInt("GOLD"));
				mem.setFeed(rs.getInt("FEED"));
				mem.setMonsterId(rs.getInt("MONSTERID"));
				mem.setMonsterNickName(rs.getString("MONSTERNICKNAME"));
				mem.setLv(rs.getInt("LV"));
				mem.setExp(rs.getInt("EXP"));
				mem.setSta(rs.getInt("STA"));
				memList.add(mem);
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
		return memList;
	}

	@Override
	public boolean selectEmail(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_EMAIL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return true;
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

		return false;
	}
	
	@Override
	public boolean selectPwd(String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PWD);
			pstmt.setString(1, pwd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return true;
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

		return false;
	}
}
