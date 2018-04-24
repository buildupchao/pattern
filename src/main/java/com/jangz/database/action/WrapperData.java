package com.jangz.database.action;

import com.jangz.database.util.SqlHelper;

public class WrapperData {

	public static void main(String[] args) {
		SqlHelper sqlHelper = new SqlHelper();
		/*sqlHelper.setPrefix("'");
		sqlHelper.setSuffix("'");*/
		sqlHelper.loadData(System.getProperty("user.dir") + "/src/main/java/com/jangz/database/userid.sql");
		sqlHelper.fire();
		sqlHelper.groupBy();
		System.out.println("DONE.");
	}
}
