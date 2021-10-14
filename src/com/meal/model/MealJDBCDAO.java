package com.meal.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.model.RestaurantVO;

public class MealJDBCDAO implements MealDAO_interface {

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	private static final String userid = "David";
	private static final String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO Meal "
			+ "(sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_STMT = "UPDATE Meal SET "
			+ "sta = ?, mealname = ?, mealtype = ?, unitprice = ?, launchdate = ?, launchdays = ?,"
			+ " mealdescription = ?, mealimg = ?, restaurantid = ?" + " WHERE mealid = ?";
	
	private static final String DELETE = "DELETE FROM Meal WHERE mealid = ?";
	
	private static final String GET_ONE_STMT = "SELECT * FROM Meal WHERE mealid = ? ";
	private static final String GET_ALL_STMT = "SELECT * FROM Meal ";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());
		}
	}

	@Override
	public MealVO insert(MealVO mealVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			
			String[] cols = { "mealid" };
			
			pstmt = con.prepareStatement(INSERT_STMT, cols);

			pstmt.setInt(1, mealVO.getSta());
			pstmt.setString(2, mealVO.getMealName());
			pstmt.setString(3, mealVO.getMealType());
			pstmt.setInt(4, mealVO.getUnitPrice());
			pstmt.setTimestamp(5, mealVO.getLaunchDate());
			pstmt.setInt(6, mealVO.getLaunchDays());
			pstmt.setString(7, mealVO.getMealDescription());
			pstmt.setBytes(8, mealVO.getMealImg());
			pstmt.setInt(9, mealVO.getRestaurantId());

			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				Integer key = rs.getInt(1); // 只支援欄位索引值取得自增主鍵值
				mealVO.setMealId(key);
//				System.out.println("自增主鍵值 = " + key + "(剛新增成功的餐點編號)");
			} 
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		
		return mealVO;
	}

	@Override
	public void update(MealVO mealVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, mealVO.getSta());
			pstmt.setString(2, mealVO.getMealName());
			pstmt.setString(3, mealVO.getMealType());
			pstmt.setInt(4, mealVO.getUnitPrice());
			pstmt.setTimestamp(5, mealVO.getLaunchDate());
			pstmt.setInt(6, mealVO.getLaunchDays());
			pstmt.setString(7, mealVO.getMealDescription());
			pstmt.setBytes(8, mealVO.getMealImg());
			pstmt.setInt(9, mealVO.getRestaurantId());
			pstmt.setInt(10, mealVO.getMealId());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer mealId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mealId);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public MealVO findByPrimaryKey(Integer mealId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MealVO mealVO = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, mealId);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mealVO = new MealVO();
				mealVO.setMealId(mealId);
				mealVO.setSta(rs.getInt("sta"));
				mealVO.setMealName(rs.getString("mealname"));
				mealVO.setMealType(rs.getString("mealtype"));
				mealVO.setUnitPrice(rs.getInt("unitprice"));
				mealVO.setLaunchDate(rs.getTimestamp("launchdate"));
				mealVO.setLaunchDays(rs.getInt("launchdays"));
				mealVO.setMealDescription(rs.getString("mealDescription"));
				mealVO.setMealImg(rs.getBytes("mealimg"));
				mealVO.setRestaurantId(rs.getInt("restaurantid"));

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return mealVO;
	}

	@Override
	public List<MealVO> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		MealVO mealVO = null;
		List<MealVO> rows = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();	
			
			rs = stmt.executeQuery(GET_ALL_STMT);
			rows = new ArrayList();

			while(rs.next()) {
				mealVO = new MealVO();
				mealVO.setMealId(rs.getInt("mealid"));
				mealVO.setSta(rs.getInt("sta"));
				mealVO.setMealName(rs.getString("mealname"));
				mealVO.setMealType(rs.getString("mealtype"));
				mealVO.setUnitPrice(rs.getInt("unitprice"));
				mealVO.setLaunchDate(rs.getTimestamp("launchdate"));
				mealVO.setLaunchDays(rs.getInt("launchdays"));
				mealVO.setMealDescription(rs.getString("mealDescription"));
				mealVO.setMealImg(rs.getBytes("mealimg"));
				mealVO.setRestaurantId(rs.getInt("restaurantid"));
				
				rows.add(mealVO);
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

	public static byte[] getPictureInByteArray(String path) throws IOException {

		FileInputStream fis = new FileInputStream(path);
		byte[] pic = new byte[fis.available()];
		fis.read(pic);
		fis.close();
		return pic;
	}

	public static void main(String[] args) {
		// test Insert
		MealVO mvo = new MealVO();
		MealJDBCDAO mDAO = new MealJDBCDAO();
//		mvo.setSta(17);
//		mvo.setMealName("痛風美食鍋");
//		mvo.setMealType("海鮮火鍋");
//		mvo.setUnitPrice(678);
//		mvo.setLaunchDate(Timestamp.valueOf(LocalDateTime.of(2021, 4, 1, 07, 00, 00)));
//		mvo.setLaunchDays(90);
//		mvo.setMealDescription("保證吃到痛風才停止");
//
//		try {
//			mvo.setMealImg(getPictureInByteArray("./images/food.jpg"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		mvo.setRestaurantId(7002);
//
//		mDAO.insert(mvo);

		/* test Update  */
//		mvo.setMealId(501);
//		mvo.setSta(27);
//		mvo.setMealName("六塊雞桶");
//		mvo.setMealType("素食炸雞");
//		mvo.setUnitPrice(120);
//		mvo.setLaunchDate(Timestamp.valueOf(LocalDateTime.of(2021, 4, 1, 07, 00, 00)));
//		mvo.setLaunchDays(90);
//		mvo.setMealDescription("保證吃到痛風才停止");
//		try {
//			mvo.setMealImg(getPictureInByteArray("./images/R.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		mvo.setRestaurantId(7001);
//		mDAO.update(mvo);
		
		/* test findByPK  */
//		System.out.println(mDAO.findByPrimaryKey(501));
		/* test delete */
//		mDAO.delete(501);
		/* test getAll  */
		 for(MealVO row : mDAO.getAll()) {
			 System.out.println(row);
		 }
		
	}
}
