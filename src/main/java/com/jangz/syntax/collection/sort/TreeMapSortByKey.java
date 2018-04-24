package com.jangz.syntax.collection.sort;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapSortByKey {
	
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<>();
		map.put("4", "Chace Peng");
		map.put("3", "Jonas Si");
		map.put("2", "Grace Wang");
		map.put("1", "David Ji");
		
		System.out.println("Before sort:");
		map.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println("After sort:");
		sortByKey(map).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}
	
	public static Map<String, String> sortByKey(Map<String, String> map) {
		if (Objects.isNull(map) || map.isEmpty()) {
			return null;
		}
		
		Map<String, String> sortMap = new TreeMap<>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}
}
