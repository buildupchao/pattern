package com.jangz.database.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbHelper {

	private static final String BASE = "src/com/jangz/database";

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	private void initParams() {
		String pathname = System.getProperty("usr.dir") + "/" + BASE + "/jdbc.properties";
		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(pathname)));
			Properties properties = new Properties();
			properties.load(inputStream);
			driverClassName = properties.getProperty("driverClassName");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Connection connect() {
		initParams();
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
