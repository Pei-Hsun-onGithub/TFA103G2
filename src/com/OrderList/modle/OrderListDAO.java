package com.OrderList.modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.Util;

public class OrderListDAO implements OrderListDAO_interface{

	private static final String INSERT = "INSERT INTO OrderList (orderId,mealId,quantity,unitPrice,note) VALUES (?,?,?,?,?)";
	private static final String UPDATE = "UPDATE OrderList set orderId =?, mealId =?, quantity =?, unitPrice =?, note=? WHERE orderListId = ?";
	private static final String DELETE = "DELETE FROM OrderList WHERE orderListId = ?";	
	private static final String GET_ALL = "SELECT * FROM OrderList";
	private static final String FIND_BY_PK = "SELECT * FROM OrderList WHERE orderListId = ?";


	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(OrderListVO orderListVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, orderListVO.getOrderId());
			pstmt.setInt(2, orderListVO.getMealId());
			pstmt.setString(3, orderListVO.getQuantity());
			pstmt.setString(4, orderListVO.getUnitPrice());
			pstmt.setString(5, orderListVO.getNote());


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
	public void update(OrderListVO orderListVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, orderListVO.getOrderId());
			pstmt.setInt(2, orderListVO.getMealId());
			pstmt.setString(3, orderListVO.getQuantity());
			pstmt.setString(4, orderListVO.getUnitPrice());
			pstmt.setString(5, orderListVO.getNote());
			pstmt.setInt(6, orderListVO.getOrderListId());


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
	public void delete(Integer orderListId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, orderListId);
			
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
	public OrderListVO findByPK(Integer orderListId) {
		OrderListVO ord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, orderListId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ord = new OrderListVO();
				ord.setOrderListId(rs.getInt("orderListId"));
				ord.setOrderId(rs.getInt("orderId"));
				ord.setMealId(rs.getInt("mealId"));
				ord.setQuantity(rs.getString("quantity"));
				ord.setUnitPrice(rs.getString("unitPrice"));
				ord.setNote(rs.getString("note"));
			
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

		return ord;
	}

	@Override
	public List<OrderListVO> getAll() {
		List<OrderListVO> orderList = new ArrayList<>();
		OrderListVO ord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ord = new OrderListVO();
				ord.setOrderId(rs.getInt("orderId"));
				ord.setMealId(rs.getInt("mealId"));
				ord.setQuantity(rs.getString("mealId"));
				ord.setQuantity(rs.getString("quantity"));
				ord.setNote(rs.getString("note"));
				ord.setOrderListId(rs.getInt("orderListId"));
				orderList.add(ord);
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
		return orderList;
	}

}
