package com.rsorder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.orderlist.model.OrderListDAO;
import com.orderlist.model.OrderListVO;

import util.Util;

public class RsOrderDAO implements RsOrderDAO_interface{

	private static final String INSERT = "INSERT INTO RsOrder (userId,restaurantId,cardId,deliveryAddId,deliveryMethods,orderDay,resstrtime,resEndTime,delStrTime,delEndTime,count,texts,sta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT2 = "INSERT INTO RsOrder (userId,cardId,deliveryAddId) VALUES (?,?,?)";
	private static final String UPDATE = "UPDATE RsOrder set userId =?, restaurantId =?, cardId =?, deliveryAddId =?, deliveryMethods =?, orderDay =?, delEndTime =?, resEndTime =?, delStrTime =?, delEndTime =?, count =? , texts =? , sta =? WHERE orderId = ?";
	private static final String DELETE = "DELETE FROM RsOrder WHERE orderId = ?";	
	private static final String FIND_BY_PK = "SELECT * FROM RsOrder WHERE orderId = ?";
	private static final String GET_ALL = "SELECT * FROM RsOrder";
	private static final String GET_ALL_BY_USERID = "SELECT * FROM RsOrder WHERE userId = ?";
	
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	
	@Override
	public RsOrderVO insert(RsOrderVO rsOrderVO) {

		Connection con = null;
		
		String[] cols = { "orderId" };
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT, cols);

			pstmt.setInt(1, rsOrderVO.getUserId());
			pstmt.setInt(2, rsOrderVO.getRestaurantId());
			pstmt.setInt(3, rsOrderVO.getCardId());
			pstmt.setInt(4, rsOrderVO.getDeliveryAddId());
			pstmt.setInt(5, rsOrderVO.getDeliveryMethods());
			pstmt.setDate(6, rsOrderVO.getOrderDay());
			pstmt.setDate(7, rsOrderVO.getResStrTime());
			pstmt.setDate(8, rsOrderVO.getResEndTime());
			pstmt.setDate(9, rsOrderVO.getDelStrTime());
			pstmt.setDate(10, rsOrderVO.getDelEndTime());
			pstmt.setInt(11, rsOrderVO.getCount());
			pstmt.setString(12, rsOrderVO.getTexts());
			pstmt.setInt(13, rsOrderVO.getSta());
			
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				Integer key = rs.getInt(1); // �u�䴩�����ޭȨ��o�ۼW�D���
				rsOrderVO.setOrderId(key);
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
		
		return rsOrderVO;

	}
	
	@Override
	public RsOrderVO insert2(RsOrderVO rsOrderVO) {

		Connection con = null;
		
		String[] cols = { "orderId" };
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT, cols);

			pstmt.setInt(1, rsOrderVO.getUserId());
			pstmt.setInt(2, rsOrderVO.getCardId());
			pstmt.setInt(3, rsOrderVO.getDeliveryAddId());
						
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				Integer key = rs.getInt(1); 
				rsOrderVO.setOrderId(key);

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
		
		return rsOrderVO;

	}
	
	@Override
	public void update(RsOrderVO rsOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, rsOrderVO.getUserId());
			pstmt.setInt(2, rsOrderVO.getRestaurantId());
			pstmt.setInt(3, rsOrderVO.getCardId());
			pstmt.setInt(4, rsOrderVO.getDeliveryAddId());
			pstmt.setInt(5, rsOrderVO.getDeliveryMethods());
			pstmt.setDate(6, rsOrderVO.getOrderDay());
			pstmt.setDate(7, rsOrderVO.getResStrTime());
			pstmt.setDate(8, rsOrderVO.getResEndTime());
			pstmt.setDate(9, rsOrderVO.getDelStrTime());
			pstmt.setDate(10, rsOrderVO.getDelEndTime());
			pstmt.setInt(11, rsOrderVO.getCount());
			pstmt.setString(12, rsOrderVO.getTexts());
			pstmt.setInt(13, rsOrderVO.getSta());
			pstmt.setInt(14, rsOrderVO.getOrderId());
			
			
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
	public void delete(Integer orderId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, orderId);
			
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
	public RsOrderVO findByPK(Integer orderId) {
		RsOrderVO ord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ord = new RsOrderVO();
				ord.setOrderId(rs.getInt("orderId"));
				ord.setUserId(rs.getInt("userId"));
				ord.setRestaurantId(rs.getInt("restaurantId"));
				ord.setCardId(rs.getInt("cardId"));
				ord.setDeliveryAddId(rs.getInt("deliveryAddId"));
				ord.setDeliveryMethods(rs.getInt("deliveryMethods"));
				ord.setOrderDay(rs.getDate("orderDay"));
				ord.setResStrTime(rs.getDate("delEndTime"));
				ord.setResEndTime(rs.getDate("resEndTime"));
				ord.setDelStrTime(rs.getDate("delStrTime"));
				ord.setDelEndTime(rs.getDate("delEndTime"));
				ord.setCount(rs.getInt("count"));
				ord.setTexts(rs.getString("texts"));
				ord.setSta(rs.getInt("sta"));
				
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
	public List<RsOrderVO> getAll() {
		List<RsOrderVO> rsOrderList = new ArrayList<>();
		RsOrderVO ord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ord = new RsOrderVO();
				ord.setOrderId(rs.getInt("orderId"));
				ord.setUserId(rs.getInt("userId"));
				ord.setRestaurantId(rs.getInt("restaurantId"));
				ord.setCardId(rs.getInt("cardId"));
				ord.setDeliveryAddId(rs.getInt("deliveryAddId"));
				ord.setDeliveryMethods(rs.getInt("deliveryMethods"));
				ord.setOrderDay(rs.getDate("orderDay"));
				ord.setResStrTime(rs.getDate("delEndTime"));
				ord.setResEndTime(rs.getDate("resEndTime"));
				ord.setDelStrTime(rs.getDate("delStrTime"));
				ord.setDelEndTime(rs.getDate("delEndTime"));
				ord.setCount(rs.getInt("count"));
				ord.setTexts(rs.getString("texts"));
				ord.setSta(rs.getInt("sta"));
				rsOrderList.add(ord);
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
		return rsOrderList;
	}
	
	@Override
	public List<RsOrderVO> getOrdersByUserId(Integer userId) {
		
		List<RsOrderVO> rsOrderList = new ArrayList<>();
		RsOrderVO ord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_BY_USERID);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				ord = new RsOrderVO();
				ord.setOrderId(rs.getInt("orderId"));
				ord.setUserId(rs.getInt("userId"));
				ord.setRestaurantId(rs.getInt("restaurantId"));
				ord.setCardId(rs.getInt("cardId"));
				ord.setDeliveryAddId(rs.getInt("deliveryAddId"));
				ord.setDeliveryMethods(rs.getInt("deliveryMethods"));
				ord.setOrderDay(rs.getDate("orderDay"));
				ord.setResStrTime(rs.getDate("delEndTime"));
				ord.setResEndTime(rs.getDate("resEndTime"));
				ord.setDelStrTime(rs.getDate("delStrTime"));
				ord.setDelEndTime(rs.getDate("delEndTime"));
				ord.setCount(rs.getInt("count"));
				ord.setTexts(rs.getString("texts"));
				ord.setSta(rs.getInt("sta"));
				rsOrderList.add(ord);
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
		return rsOrderList;
	}

	@Override
	public void insertWithOl(RsOrderVO rsOrderVO, List<OrderListVO> list) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String[] cols = { "orderId" };
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			
			//先關閉AutoCommit在executeUpdate之前
			con.setAutoCommit(false);
			
			//先新增文章
			
			pstmt=con.prepareStatement(INSERT2, cols);
			pstmt.setInt(1, rsOrderVO.getUserId());
			pstmt.setInt(2, rsOrderVO.getCardId());
			pstmt.setInt(3, rsOrderVO.getDeliveryAddId());
						
			pstmt.executeUpdate();
			
			//抓出剛剛新增的rsorderpk
			
			String new_orderid =null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				new_orderid = rs.getString(1);
			}
			rs.close();
			
			//在同時另外一個OrderListDAO
			
			OrderListDAO orderListDAO = new OrderListDAO();
			
			for(OrderListVO orderListVO: list ) {
				System.out.println("orderListVO="+orderListVO);
				orderListVO.setOrderId(new Integer(new_orderid));
				orderListDAO.insertWithRsOrder(orderListVO, con);
				
			}
			
			con.commit();
			con.setAutoCommit(true);

			
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-dept");
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
		
	}
}
