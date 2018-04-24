package com.jangz.syntax.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapSortByValue {
	
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
		sortByValue(map).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}
	
	static Map<String, String> sortByValue(Map<String, String> map) {
		if (Objects.isNull(map) || map.isEmpty()) {
			return null;
		}
		
		Map<String, String> sortMap = new LinkedHashMap<>();
		List<Map.Entry<String, String>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, new MapValueComparator());
		
		entryList.forEach(entry -> {
			sortMap.put(entry.getKey(), entry.getValue());
		});
		return sortMap;
	}
}
