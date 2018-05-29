package com.pattern.tutor.syntax.database.action;

import com.pattern.tutor.syntax.database.util.SubSqlHelper;

public class SubSqlHelperData {
	
	public static void main(String[] args) {
		SubSqlHelper sqlHelper = new SubSqlHelper();
		/*sqlHelper.setPrefix("'");
		sqlHelper.setSuffix("'");*/
		sqlHelper.loadData(System.getProperty("user.dir") + "/src/main/java/com/pattern/tutor/syntax/database/sql.data");
		sqlHelper.fire();
//		sqlHelper.groupBy();
		System.out.println("DONE.");
	}
}
