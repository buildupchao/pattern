package com.pattern.tutor.syntax.database.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataHandleHelper {
	
	public static void main(String[] args) throws IOException {
		String base = "src/main/resources/database";
		String fileOutputPath = base;
		String formIdFile = "sqlFormats.data";
		String userIdFile = "userIds.data";
		String targetIdRelationshipFile = "finalSqlResult.result";
		BufferedReader sqlFormatReader = null;
		BufferedReader userIdReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + userIdFile)));
		FileOutputStream targetDataWriter = new FileOutputStream(fileOutputPath + "/" + targetIdRelationshipFile, true);
		
		String sqlFormat = null;
		String userIdStr = null;
		while ((userIdStr = userIdReader.readLine()) != null) {
			int userId = Integer.parseInt(userIdStr);
			sqlFormatReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + formIdFile)));
			while ((sqlFormat = sqlFormatReader.readLine()) != null) {
				String realSql = String.format(sqlFormat, userId).concat("\n");
				targetDataWriter.write(realSql.getBytes());
			}
		}
		
		if (targetDataWriter != null) {
			targetDataWriter.flush();
			targetDataWriter.close();
		}
		if (userIdReader != null) {
			userIdReader.close();
		}
		if (sqlFormatReader != null) {
			sqlFormatReader.close();
		}
		System.out.println("DONE");
	}
}
