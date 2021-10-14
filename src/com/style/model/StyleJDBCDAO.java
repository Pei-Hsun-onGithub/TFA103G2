package com.style.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meal.model.MealVO;

public class StyleJDBCDAO implements StyleDAO_interface {

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/fm01?serverTimezone=Asia/Taipei";
	private static final String userid = "David";
	private static final String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO Style (styletype) VALUES (?)";
	private static final String UPDATE_STMT = "UPDATE Style SET styletype = ? WHERE styleid = ?";
	
	private static final String GET_ONE_STMT = "SELECT * FROM Style WHERE styleid = ? ";
	private static final String GET_ALL_STMT = "SELECT * FROM Style ";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());
		}
	}

	@Override
	public void insert(StyleVO styleVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, styleVO.getStyleType());
			
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
	public void update(StyleVO styleVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

			
			pstmt.setString(1, styleVO.getStyleType());
			pstmt.setInt(2, styleVO.getStyleId());

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
	public void delete(Integer styleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public StyleVO findByPrimaryKey(Integer styleId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StyleVO styleVO = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, styleId);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				styleVO = new StyleVO();
				styleVO.setStyleId(styleId);
				styleVO.setStyleType(rs.getString("styletype"));
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
		return styleVO;
	}

	@Override
	public List<StyleVO> getAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		StyleVO styleVO = null;
		List<StyleVO> rows = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();	
			
			rs = stmt.executeQuery(GET_ALL_STMT);
			rows = new ArrayList();

			while(rs.next()) {
				styleVO = new StyleVO();
				styleVO.setStyleId(rs.getInt("styleid"));
				styleVO.setStyleType(rs.getString("styletype"));
				
				rows.add(styleVO);
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
		StyleJDBCDAO sDAO = new StyleJDBCDAO();
		StyleVO sVO = new StyleVO();
		sVO.setStyleId(52);
		sVO.setStyleType("ªü´I¦½¦¡");
		
		/* test insert */
//		sDAO.insert(sVO);
		/* test getbyPK */
//		System.out.println(sDAO.findByPrimaryKey(51));
		 /* test getAll*/
		 for(StyleVO row : sDAO.getAll()) {
			 System.out.println(row);
		 }

	}

}
