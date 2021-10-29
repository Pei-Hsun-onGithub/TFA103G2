package com.address.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.card.model.CardVO;

import util.Util;


public class AddressDAO implements AddressDAO_interface{

	private static final String INSERT = "INSERT INTO Address (userId,customerName,deliverPhone,deliverAddress,buildingName,note,sta) VALUES (?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Address set userId =?, customerName=?, deliverPhone=?, deliverAddress=?, buildingName=?, note=?,sta= ? WHERE deliveryAddid = ?";
	private static final String GET_ALL = "SELECT * FROM Address";
//	private static final String GET_ONE = "SELECT * FROM Address where deliveryAddid = ?";
	private static final String DELETE = "DELETE FROM Address WHERE deliveryAddid = ?";	
	private static final String FIND_BY_PK = "SELECT * FROM Address WHERE deliveryAddId = ?";
	private static final String GET_ADDRESS_BY_USERID = "SELECT * FROM ADDRESS WHERE userId = ? order by deliveryAddId";


	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
		
	@Override
	public void insert(AddressVO addressVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, addressVO.getUserId());
			pstmt.setString(2, addressVO.getCustomerName());
			pstmt.setString(3, addressVO.getDeliverPhone());
			pstmt.setString(4, addressVO.getDeliverAddress());
			pstmt.setString(5, addressVO.getBuildingName());
			pstmt.setString(6, addressVO.getNote());
			pstmt.setInt(7, addressVO.getSta());


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
	public void update(AddressVO addressVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, addressVO.getUserId());
			pstmt.setString(2, addressVO.getCustomerName());
			pstmt.setString(3, addressVO.getDeliverPhone());
			pstmt.setString(4, addressVO.getDeliverAddress());
			pstmt.setString(5, addressVO.getBuildingName());
			pstmt.setString(6, addressVO.getNote());
			pstmt.setInt(7, addressVO.getSta());
			pstmt.setInt(8, addressVO.getDeliveryAddId());

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
	public void delete(Integer deliveryAddId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, deliveryAddId);
			
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
	public AddressVO findByPK(Integer deliveryAddId) {
		AddressVO add = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, deliveryAddId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				add = new AddressVO();
				add.setDeliveryAddId(rs.getInt("deliveryAddId"));
				add.setUserId(rs.getInt("userId"));
				add.setCustomerName(rs.getString("customerName"));
				add.setDeliverPhone(rs.getString("deliverPhone"));
				add.setDeliverAddress(rs.getString("deliverAddress"));
				add.setBuildingName(rs.getString("buildingName"));
				add.setNote(rs.getString("note"));
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
	public List<AddressVO> getAll() {
		List<AddressVO> addresList = new ArrayList<>();
		AddressVO adre = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				adre = new AddressVO();
				adre.setDeliveryAddId(rs.getInt("deliveryAddId"));
				adre.setUserId(rs.getInt("userId"));
				adre.setCustomerName(rs.getString("customerName"));
				adre.setDeliverPhone(rs.getString("deliverPhone"));
				adre.setDeliverAddress(rs.getString("deliverAddress"));
				adre.setBuildingName(rs.getString("buildingName"));
				adre.setNote(rs.getString("note"));
				adre.setSta(rs.getInt("sta"));
				addresList.add(adre);
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
		return addresList;
	}
	
	
	@Override
	public Set<AddressVO> getAddressByUserId(Integer userId) {
		Set<AddressVO> addressset = new LinkedHashSet<AddressVO>();
		AddressVO address = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ADDRESS_BY_USERID);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				address = new AddressVO();
				address.setDeliveryAddId(rs.getInt("deliveryAddId"));
				address.setUserId(rs.getInt("userId"));
				address.setCustomerName(rs.getString("customerName"));
				address.setDeliverPhone(rs.getString("deliverPhone"));
				address.setDeliverAddress(rs.getString("deliverAddress"));
				address.setBuildingName(rs.getString("buildingName"));
				address.setNote(rs.getString("note"));
				address.setSta(rs.getInt("sta"));
				addressset.add(address);
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
		return addressset;
	}
}


