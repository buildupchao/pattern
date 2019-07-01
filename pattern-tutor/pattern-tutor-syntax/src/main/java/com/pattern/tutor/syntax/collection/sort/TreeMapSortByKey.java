package com.pattern.tutor.syntax.collection.sort;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Default sort by key asc for TreeMap.
 * @author buildupchao
 * @date 2019/07/01 09:16
 * @since JDK 1.8
 */
public class TreeMapSortByKey {
	
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("4", "Chace Peng");
		map.put("3", "Jonas Si");
		map.put("2", "Grace Wang");
		map.put("1", "David Ji");
		
		System.out.println("Before sort:");
		System.out.println(map);
		
		System.out.println("After sort:");
		System.out.println(sortByKey(map));
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
