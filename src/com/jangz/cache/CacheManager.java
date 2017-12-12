package com.jangz.cache;

import java.util.HashMap;

/**
 * 
 * Created by jangz on 12/12/17
 */
public class CacheManager {

	private static final String strFormDict = "formDictformMain";

	public static final String findAllEstate = "findAllEstate";

	private static HashMap<String, Object> cacheMap = new HashMap<>();

	public CacheManager() {
	}
	
	public static boolean getSimpleFlag(String key) {
		return false;
	}
}
