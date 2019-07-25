package com.pattern.tutor.syntax.database.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author buildupchao
 * @date 2019/07/23 11:02
 * @since JDK 1.8
 */
public class DbCreateTableChecker {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "root";
		Connection conn = DBUtil.getConnection(url, user, password);
		Statement stmt = conn.createStatement();
		
		String sql = "create table test_create_1 (id int);";
		boolean success = stmt.execute(sql);
		System.out.println("create: " + success);
		
		String insertSql = "insert into test_create_1(id) values(25)";
		boolean insertSuccess = stmt.execute(insertSql);
		System.out.println("insert: " + insertSuccess);
		
		String selectSql = "select * from test_create_1";
		boolean selectSuccess = stmt.execute(selectSql);
		System.out.println("select: " + selectSuccess);
		
		DBUtil.close(conn, stmt, null);
	}
}
