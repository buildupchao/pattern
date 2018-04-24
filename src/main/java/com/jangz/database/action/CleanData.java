package com.jangz.database.action;

import com.jangz.database.util.DataCleanHelper;

public class CleanData {
	
	public static void main(String[] args) {
		DataCleanHelper dataCleanHelper = new DataCleanHelper();
		dataCleanHelper.setRemoveStartLabel("<");
		dataCleanHelper.setSeparator(";");
		dataCleanHelper.setSqlWrapper("select userid from manager where firstname='%s' and lastname='%s' union all ");
		dataCleanHelper.loadData(System.getProperty("user.dir") + "/src/main/java/com/jangz/database/DataClean.data");
		dataCleanHelper.fire();
		System.out.println("DONE.");
	}
}
