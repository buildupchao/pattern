package com.pattern.tutor.syntax.database.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbDataChecker {

	public static void main(String[] args) throws SQLException {
		String workspace = System.getProperty("user.dir");
		String base = "src/main/java/com/pattern/tutor/syntax/database";
		String fileOutputPath = workspace + "/" + base;
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connect = new DbHelper(fileOutputPath).connect();
			statement = connect.createStatement();
			String originSql = "select count(1) from user";
			String sql = "/*taskTraceLogId=3425*/" +
					originSql;
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				long count = rs.getInt(1);
				System.out.println(count);
			}
		} finally {
			DBUtil.close(connect, statement, rs);
		}
	}
}
