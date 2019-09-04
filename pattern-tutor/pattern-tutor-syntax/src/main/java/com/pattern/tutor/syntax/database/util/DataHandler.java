package com.pattern.tutor.syntax.database.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DataHandler {

	private static final HashMap<String, Integer> userNameMap = new HashMap<String, Integer>() {
		{
			put("周晓威", 142);
			put("韦海飞", 143);
			put("王先惠", 163);
			put("韩燕龙", 183);
			put("李静", 187);
			put("赵晓静", 188);
			put("张伟毅", 354);
			put("张鹤龙", 398);
			put("黄晓萍", 464);
		}
	};

	public static void main(String[] args) throws IOException {
		String base = "src/main/resources/database";
		String fileOutputPath = base;
		String formIdFile = "realFormIds.data";
		String userIdFile = "realUserIds.data";
		String targetIdRelationshipFile = "targetIdRelationship.result";
		BufferedReader formIdReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + formIdFile)));
		BufferedReader userIdReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOutputPath + "/" + userIdFile)));
		FileOutputStream targetDataWriter = new FileOutputStream(fileOutputPath + "/" + targetIdRelationshipFile, true);
		
		String formId = null;
		String userName = null;
		String insertDate = "2019-04-28 16:16:16";
		String insertSql = String.valueOf("insert into data_watch_method(form_id, user_id, type, email, create_time) values(%d, %d, 1, 'kszh_report@wps.cn', '%s');\n");
		while ((formId = formIdReader.readLine()) != null && (userName = userIdReader.readLine()) != null) {
			int realFormId = Integer.parseInt(formId);
			String realSql = String.format(insertSql, realFormId, userNameMap.get(userName), insertDate);
			targetDataWriter.write(realSql.getBytes());
		}
		
		if (targetDataWriter != null) {
			targetDataWriter.flush();
			targetDataWriter.close();
		}
		if (userIdReader != null) {
			userIdReader.close();
		}
		if (formIdReader != null) {
			formIdReader.close();
		}
		System.out.println("DONE");
	}
}
