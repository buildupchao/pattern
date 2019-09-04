package com.pattern.tutor.syntax.database.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class DbHiveTableCleanHelper {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		String base = "src/main/resources/database";
		String fileOutputPath = base;
		String clearHiveTableSqlData = "clearHiveTable.data";
		BufferedReader sqlReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + clearHiveTableSqlData)));
		
		String url = "jdbc:hive2://120.92.18.224:10030/default";
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Properties connectionProps = new Properties();
        connectionProps.put("user", "dw");
        connectionProps.put("password", "LSF8iFh3");
		Connection connection = DriverManager.getConnection(url, connectionProps);
		Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		String sql = null;
		while (StringUtils.isNoneBlank((sql = sqlReader.readLine()))) {
			try {
				System.out.println(sql);
				statement.execute(sql);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("no handle!");
			}
		}
		
		if (sqlReader != null) {
			sqlReader.close();
		}
		System.out.println("DONE");
	}
}
