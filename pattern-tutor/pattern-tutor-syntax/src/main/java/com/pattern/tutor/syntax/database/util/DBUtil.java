package com.pattern.tutor.syntax.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DBUtil {

	private static final String url = "jdbc:mysql://120.92.42.115:3306/event-manager";
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

	public static void main(String[] args) throws SQLException, InterruptedException {
		new Thread(() -> {
			try {
				insert(2000, 2030);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				insert(1000, 1030);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public static void insert(int start, int end) throws SQLException, InterruptedException {
		Connection connction = getConnction();
		Statement statement = connction.createStatement();

		List<Integer> appIds = Arrays.asList(170, 76);
		for (int i = start; i < end; i++) {
//			String date = new DateTime(System.currentTimeMillis()).toString("yyyy-MM-dd HH:mm:ss");
			for (Integer appId : appIds) {
				String sql = String.format("INSERT INTO app_debug(app_id, decode_log, create_time) values(%d, \"{'test':'%s'}\", now())",
						appId,
						"test" + i
				);
				statement.executeUpdate(sql);
			}
			Thread.sleep(2000);
		}

		close(connction, statement, null);
		System.out.println("DONE");
	}
}
