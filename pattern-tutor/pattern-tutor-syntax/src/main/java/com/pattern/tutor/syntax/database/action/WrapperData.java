package com.pattern.tutor.syntax.database.action;

import com.pattern.tutor.syntax.database.util.SqlHelper;

public class WrapperData {

	public static void main(String[] args) {
		SqlHelper sqlHelper = new SqlHelper();
		/*sqlHelper.setPrefix("'");
		sqlHelper.setSuffix("'");*/
		sqlHelper.loadData(System.getProperty("user.dir") + "/src/main/java/com/pattern/tutor/syntax/database/userid.sql");
		sqlHelper.fire();
		sqlHelper.groupBy();
		System.out.println("DONE.");
	}
}
