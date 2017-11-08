package com.jangz.syntax.collection.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class HashMapSortByKey {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("a", "dd");
		map.put("d", "bb");
		map.put("c", "cc");
		map.put("b", "aa");
		map.put("97", "aa");

		System.out.print("HashMap:");
		for (String key : map.keySet()) {
			System.out.print(map.get(key) + " ");
		}
		System.out.println();
		System.out.println("Before sort:");
		map.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println("After sort:");
		sortByValue(map).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}

	public static Map<String, String> sortByValue(Map<String, String> map) {
		if (Objects.isNull(map) || map.isEmpty()) {
			return null;
		}
		Set<Entry<String, String>> entries = map.entrySet();
		List<Entry<String, String>> list = new LinkedList<>(entries);
		Collections.sort(list, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1,
					Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});

		Map<String, String> result = new LinkedHashMap<>();
		list.forEach(entry -> {
			result.put(entry.getKey(), entry.getValue());
		});
		return result;
	}
}
