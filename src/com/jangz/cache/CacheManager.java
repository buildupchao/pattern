package com.jangz.cache;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 
 * Created by jangz on 12/12/17
 * http://blog.csdn.net/sinat_30474567/article/details/51886814
 */
public class CacheManager {

	private static final String strFormDict = "formDictformMain";

	public static final String findAllEstate = "findAllEstate";

	private static Map<String, Object> cacheMap = new ConcurrentHashMap<>();

	public CacheManager() {
	}

	public static boolean getSimpleFlag(String key) {
		try {
			return (boolean) cacheMap.get(key);
		} catch (NullPointerException e) {
		}
		return false;
	}

	public static long getServerStartdt(String key) {
		try {
			return (Long) cacheMap.get(key);
		} catch (Exception e) {
			return 0;
		}
	}

	public static synchronized boolean setSimpleFlag(String key, boolean flag) {
		if (flag && getSimpleFlag(key)) {
			return false;
		} else {
			cacheMap.put(key, flag);
			return true;
		}
	}

	public static synchronized boolean setSimpleFlag(String key, long serverbegrundt) {
		if (Objects.isNull(cacheMap.get(key))) {
			cacheMap.put(key, serverbegrundt);
			return true;
		} else {
			return false;
		}
	}

	public static synchronized Cache getCache(String key) {
		return (Cache) cacheMap.get(key);
	}

	public static synchronized boolean hasCache(String key) {
		return cacheMap.containsKey(key);
	}

	public static synchronized void clearAll() {
		cacheMap.clear();
	}

	public static synchronized void clearAll(String type) {
		List<String> keyArray = cacheMap.entrySet().stream()
			.map(entry -> entry.getKey())
			.filter(key -> key.startsWith(type))
			.collect(Collectors.toList());
		
		for (String key : keyArray) {
			clearOnly(key);
		}
	}
	
	public static synchronized void clearOnly(String key) {
		cacheMap.remove(key);
	}
	
	public static synchronized void putCache(String key, Cache cache) {
		cacheMap.put(key, cache);
	}
	
	public static Cache getCacheInfo(String key) {
		if (hasCache(key)) {
			Cache cache = getCache(key);
			if (cacheExpired(cache)) {
				cache.setExpired(true);
				clearOnly(key);
			}
			return cache;
		} else {
			return null;
		}
	}
	
	public static void putCacheInfo(String key, Cache cache, long dt, boolean expired) {
		Cache newCache = new Cache();
		newCache.setKey(key);
		newCache.setTimeOut(dt + System.currentTimeMillis());
		newCache.setValue(cache);
		newCache.setExpired(expired); // when cache default loading, status of termination is false
		cacheMap.put(key, newCache);
	}
	
	public static void putCacheInfo(String key, Cache cache, long dt) {
		Cache newCache = new Cache();
		newCache.setKey(key);
		newCache.setTimeOut(System.currentTimeMillis());
		newCache.setValue(cache);
		newCache.setExpired(false);
		cacheMap.put(key, newCache);
	}
	
	public static boolean cacheExpired(Cache cache) {
		if (null == cache) {
			return false;
		}
		long nowDt = System.currentTimeMillis();
		long cacheDt = cache.getTimeOut();
		if (cacheDt <= 0 || cacheDt > nowDt) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int getCacheSize() {
		return cacheMap.size();
	}
	
	public static int getCacheSize(String type) {
		return (int) cacheMap.entrySet().stream()
				.map(entry -> entry.getKey())
				.filter(key -> key.indexOf(type) != -1)
				.count();
	}
	
	public static List<String> getCacheAllKey() {
		return cacheMap.entrySet().stream()
				.map(entry -> entry.getKey())
				.collect(Collectors.toList());
	}
	
	public static List<String> getCacheListKey(String type) {
		return cacheMap.entrySet().stream()
				.map(entry -> entry.getKey())
				.filter(key -> key.indexOf(type) != -1)
				.collect(Collectors.toList());
	}
}
