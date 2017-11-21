package com.jangz.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String user = "root";
	private static final String password = "root";

	public static Connection getConnction() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {

		}
	}
}
