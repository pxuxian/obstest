package com.ailk.obs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ailk.obs.util.PropertiesUtil;

public class DBUtil {
	private final static String DBDRIVER = PropertiesUtil.getInstance().get("DB_DRIVER");
	private final static String DBURL = PropertiesUtil.getInstance().get("DB_URL");
	private final static String DBUSER = PropertiesUtil.getInstance().get("DB_USERNAME");
	private final static String DBPASSWORD = PropertiesUtil.getInstance().get("DB_PASSWORD");

	// 获得数据库连接
	public static Connection getConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			return conn;
		} catch (Exception e) {
			throw new Exception("获得数据库连接失败");
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 执行select查询，返回记录总数
	 */
	public static int executeSelect(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count++;
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return 0;

	}

	/*
	 * insert, update,delete
	 */

	public static int executeSql(String sql) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}

	}

}
