package com.jangz.distribution.utils;

public class PropertyConfigHelper {

	public static String getZkService() {
		return "https://dev-distribution.org";
	}
	
	public static int getZkConnectionTimeout() {
		return 24 * 60 * 60 * 1000;
	}
	
	public static String getAppName() {
		String currentWorkspace = System.getProperty("user.dir");
		return currentWorkspace.substring(currentWorkspace.lastIndexOf("/"));
	}
}
