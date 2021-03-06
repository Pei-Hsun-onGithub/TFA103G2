package com.orderlist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.Util;

public class OrderListDAO implements OrderListDAO_interface {

	private static final String INSERT = "INSERT INTO OrderList (orderId,mealId,quantity,unitPrice,note) VALUES (?,?,?,?,?)";
	private static final String UPDATE = "UPDATE OrderList set orderId =?, mealId =?, quantity =?, unitPrice =?, note=? WHERE orderListId = ?";
	private static final String DELETE = "DELETE FROM OrderList WHERE orderListId = ?";
	private static final String GET_ALL = "SELECT * FROM OrderList";
	private static final String FIND_BY_PK = "SELECT * FROM OrderList WHERE orderListId = ?";
	private static final String GET_TOTAL_PRICE_BT_ORDER_ID = "select sum(quantity * unitprice) as total from orderlist where orderid = ?";
	private static final String GET_ALL_ORDERLIST_BY_ORDER_ID = "SELECT * FROM ORDERLIST WHERE ORDERID = ? ";
	
			static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public OrderListVO insert(OrderListVO orderListVO) {

		Connection con = null;

		String[] cols = { "orderListId" };
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT, cols);

			pstmt.setInt(1, orderListVO.getOrderId());
			pstmt.setInt(2, orderListVO.getMealId());
			pstmt.setInt(3, orderListVO.getQuantity());
			pstmt.setInt(4, orderListVO.getUnitPrice());
			pstmt.setString(5, orderListVO.getNote());

			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				Integer key = rs.getInt(1); // �u�䴩�����ޭȨ��o�ۼW�D���
				orderListVO.setOrderListId(key);
//				System.out.println("�ۼW�D��� = " + key + "(��s�W���\���\�I�s��)");
			}

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
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
		return orderListVO;
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
			pstmt.setInt(3, orderListVO.getQuantity());
			pstmt.setInt(4, orderListVO.getUnitPrice());
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
				ord.setQuantity(rs.getInt("quantity"));
				ord.setUnitPrice(rs.getInt("unitPrice"));
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
				ord.setQuantity(rs.getInt("quantity"));
				ord.setUnitPrice(rs.getInt("unitPrice"));
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

	@Override
	public void insertWithRsOrder(OrderListVO orderListVO, Connection con) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, orderListVO.getOrderId());
			pstmt.setInt(2, orderListVO.getMealId());
			pstmt.setInt(3, orderListVO.getQuantity());
			pstmt.setInt(4, orderListVO.getUnitPrice());
			pstmt.setString(5, orderListVO.getNote());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-emp");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}
	
	@Override
	public Integer getTotalPriceByOrderId(Integer orderId) {
		Integer total = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_TOTAL_PRICE_BT_ORDER_ID);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				total = rs.getInt(1);	
			}
			
			
			
			
		}catch (SQLException se) {
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
		return total;
		
	}
	
	@Override
	public Set<OrderListVO> getAllOrderListByOrderId(Integer orderId) {
		Set<OrderListVO> orderlistset = new LinkedHashSet<OrderListVO>();
		OrderListVO orderlist = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_ORDERLIST_BY_ORDER_ID);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				orderlist = new OrderListVO();
				orderlist.setOrderId(rs.getInt("orderId"));
				orderlist.setMealId(rs.getInt("mealId"));
				orderlist.setQuantity(rs.getInt("quantity"));
				orderlist.setUnitPrice(rs.getInt("unitPrice"));
				orderlist.setNote(rs.getString("note"));
				orderlist.setOrderListId(rs.getInt("orderListId"));
				orderlistset.add(orderlist);
				
			}
			
	}catch (SQLException se) {
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
	return orderlistset;
		}
}
