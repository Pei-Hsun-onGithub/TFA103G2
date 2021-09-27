package com.Card.modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.Util;



public class CardDAO implements CardDAO_interface{

	private static final String INSERT = "INSERT INTO Card (userId,cardHolder,cardNumber,deadLine,cvv,BillAddress,zipCode,sta) VALUES (?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Card set userId =?, cardHolder=?, cardNumber=?, deadLine=?, cvv=?, BillAddress=?, zipCode=?, sta=? WHERE cardId = ?";
	private static final String DELETE = "DELETE FROM Card WHERE cardId = ?";	
	private static final String GET_ALL = "SELECT * FROM Card";
	private static final String FIND_BY_PK = "SELECT * FROM Card WHERE cardId = ?";


	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(CardVO cardVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, cardVO.getUserId());
			pstmt.setString(2, cardVO.getCardHolder());
			pstmt.setString(3, cardVO.getCardNumber());
			pstmt.setDate(4, cardVO.getDeadLine());
			pstmt.setString(5, cardVO.getCvv());
			pstmt.setString(6, cardVO.getBillAddress());
			pstmt.setString(7, cardVO.getZipCode());
			pstmt.setInt(8, cardVO.getSta());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
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
	public void update(CardVO cardVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, cardVO.getUserId());
			pstmt.setString(2, cardVO.getCardHolder());
			pstmt.setString(3, cardVO.getCardNumber());
			pstmt.setDate(4, cardVO.getDeadLine());
			pstmt.setString(5, cardVO.getCvv());
			pstmt.setString(6, cardVO.getBillAddress());
			pstmt.setString(7, cardVO.getZipCode());
			pstmt.setInt(8, cardVO.getSta());
			pstmt.setInt(9, cardVO.getCardId());

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
	public void delete(Integer cardId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, cardId);
			
			pstmt.executeUpdate();
			
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
	public CardVO findByPK(Integer cardId) {
		CardVO add = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, cardId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				add = new CardVO();
				add.setCardId(rs.getInt("cardId"));
				add.setUserId(rs.getInt("userId"));
				add.setCardHolder(rs.getString("cardHolder"));
				add.setCardNumber(rs.getString("cardNumber"));
				add.setDeadLine(rs.getDate("deadLine"));
				add.setCvv(rs.getString("cvv"));
				add.setBillAddress(rs.getString("billAddress"));
				add.setZipCode(rs.getString("zipCode"));
				add.setSta(rs.getInt("sta"));
				
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

		return add;
	}

	@Override
	public List<CardVO> getAll() {
		List<CardVO> cardList = new ArrayList<>();
		CardVO card = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				card = new CardVO();
				card.setCardId(rs.getInt("cardId"));
				card.setUserId(rs.getInt("userId"));
				card.setCardHolder(rs.getString("cardHolder"));
				card.setCardNumber(rs.getString("cardNumber"));
				card.setDeadLine(rs.getDate("deadLine"));
				card.setCvv(rs.getString("cvv"));
				card.setBillAddress(rs.getString("billAddress"));
				card.setZipCode(rs.getString("zipCode"));
				card.setSta(rs.getInt("sta"));
				cardList.add(card);
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
		return cardList;
	}
}
