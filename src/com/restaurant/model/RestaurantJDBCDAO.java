package com.restaurant.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.sql.*;
import java.time.LocalTime;

public class RestaurantJDBCDAO implements RestaurantDAO_interface {

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	private static final String userid = "David";
	private static final String passwd = "123456";

	
	private static final String INSERT_STMT = "INSERT INTO Restaurant "
			+ "(restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)"
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT ="UPDATE Restaurant SET " +
		"restaurantname = ?, boss = ?, phone = ?, district = ?, city = ?, location = ?,"
	  + " opentime = ?, closetime = ?, dayoffid = ?, weeklyleave = ?, sta = ? " +
	    " WHERE restaurantid = ?";
	
	
	private static final String GET_ONE_STMT = "SELECT * FROM Restaurant WHERE restaurantid = ? ";
	private static final String GET_ALL_STMT = "SELECT * FROM Restaurant ";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. "
					+ ce.getMessage());
		}
	}
	
	


	@Override
	public RestaurantVO insert(RestaurantVO restaurantVO) {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			
			String[] cols = { "restaurantId" };
			pstmt = con.prepareStatement(INSERT_STMT, cols);
			
			pstmt.setString(1, restaurantVO.getRestaurantName());
			pstmt.setString(2, restaurantVO.getBoss());
			pstmt.setString(3, restaurantVO.getPhone());
			pstmt.setString(4, restaurantVO.getDistrict());
			pstmt.setString(5, restaurantVO.getCity());
			pstmt.setString(6, restaurantVO.getLocation());
			pstmt.setTime(7, restaurantVO.getOpenTime());
			pstmt.setTime(8, restaurantVO.getCloseTime());
			pstmt.setInt(9, restaurantVO.getDayoffId());
			pstmt.setString(10, restaurantVO.getWeeklyLeave());
			pstmt.setInt(11, restaurantVO.getSta());
			
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				Integer key = rs.getInt(1); // 只支援欄位索引值取得自增主鍵值
				restaurantVO.setRestaurantId(key);
//				System.out.println("自增主鍵值 = " + key + "(剛新增成功的餐點編號)");
			} 
			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();					
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
		
		return restaurantVO;
	}



	@Override
	public void update(RestaurantVO restaurantVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setString(1, restaurantVO.getRestaurantName());
			pstmt.setString(2, restaurantVO.getBoss());
			pstmt.setString(3, restaurantVO.getPhone());
			pstmt.setString(4, restaurantVO.getDistrict());
			pstmt.setString(5, restaurantVO.getCity());
			pstmt.setString(6, restaurantVO.getLocation());
			pstmt.setTime(7, restaurantVO.getOpenTime());
			pstmt.setTime(8, restaurantVO.getCloseTime());
			pstmt.setInt(9, restaurantVO.getDayoffId());
			pstmt.setString(10, restaurantVO.getWeeklyLeave());
			pstmt.setInt(11, restaurantVO.getSta());
			pstmt.setInt(12, restaurantVO.getRestaurantId());
			
			pstmt.executeUpdate();
			
			
		} catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();					
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
	}



	@Override
	public void delete(Integer restaurantId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public RestaurantVO findByPrimaryKey(Integer restaurantId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RestaurantVO restVO = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, restaurantId);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
			    restVO = new RestaurantVO();
				restVO.setRestaurantId(restaurantId);
				restVO.setRestaurantName(rs.getString("restaurantname"));
				restVO.setBoss(rs.getString("boss"));
				restVO.setPhone(rs.getString("phone"));
				restVO.setDistrict(rs.getString("district"));
				restVO.setCity(rs.getString("city"));
				restVO.setLocation(rs.getString("location"));
				restVO.setOpenTime(rs.getTime("opentime"));
				restVO.setCloseTime(rs.getTime("closetime"));
				restVO.setDayoffId(rs.getInt("dayoffid"));
				restVO.setWeeklyLeave(rs.getString("weeklyleave"));
				restVO.setSta(rs.getInt("sta"));
				
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
			if(pstmt != null) {
				try {
					pstmt.close();					
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
		return restVO;
	}



	@Override
	public List<RestaurantVO> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		RestaurantVO restVO = null;
		List<RestaurantVO> rows = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();	
			
			rs = stmt.executeQuery(GET_ALL_STMT);
			rows = new ArrayList();

			while(rs.next()) {
			    restVO = new RestaurantVO();
				restVO.setRestaurantId(rs.getInt("restaurantid"));
				restVO.setRestaurantName(rs.getString("restaurantname"));
				restVO.setBoss(rs.getString("boss"));
				restVO.setPhone(rs.getString("phone"));
				restVO.setDistrict(rs.getString("district"));
				restVO.setCity(rs.getString("city"));
				restVO.setLocation(rs.getString("location"));
				restVO.setOpenTime(rs.getTime("opentime"));
				restVO.setCloseTime(rs.getTime("closetime"));
				restVO.setDayoffId(rs.getInt("dayoffid"));
				restVO.setWeeklyLeave(rs.getString("weeklyleave"));
				restVO.setSta(rs.getInt("sta"));
				
				rows.add(restVO);
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
		
		 RestaurantVO reVO = new  RestaurantVO();
		 RestaurantJDBCDAO DAO = new RestaurantJDBCDAO();
		 
		// insert一筆資料
//		 reVO.setRestaurantName("麥當勞");
//		 reVO.setBoss("鈴木一郎");
//		 reVO.setPhone("0934567332");
//		 reVO.setDistrict("高雄市");
//		 reVO.setCity("左營區");
//		 reVO.setLocation("文青路9號");
//		 reVO.setOpenTime(Time.valueOf(LocalTime.of(8, 00, 45)));
//		 reVO.setCloseTime(Time.valueOf(LocalTime.of(20, 30, 00)));
//		 reVO.setDayoffId(345);
//		 reVO.setWeeklyLeave("0100100");
//		 reVO.setSta(4);
//		 
//		 DAO.insert(reVO);
		 
		 
		 // Update一筆資料
//		 reVO.setRestaurantName("一蘭拉麵");
//		 reVO.setBoss("大谷祥平");
//		 reVO.setPhone("0911567332");
//		 reVO.setDistrict("台中市");
//		 reVO.setCity("豐原區");
//		 reVO.setLocation("中山路335號");
//		 reVO.setOpenTime(Time.valueOf(LocalTime.of(13, 00, 00)));
//		 reVO.setCloseTime(Time.valueOf(LocalTime.of(22, 30, 00)));
//		 reVO.setDayoffId(345);
//		 reVO.setWeeklyLeave("0000000");
//		 reVO.setSta(3);
//		 reVO.setRestaurantId(7002);
//		 
//		 DAO.update(reVO);
		 
		 // getByPK一筆資料
		 
//		 System.out.println(DAO.findByPrimaryKey(7002));
		 
		 // getAll
		 
		 for(RestaurantVO row : DAO.getAll()) {
			 System.out.println(row);
		 }
		 
	}

}
