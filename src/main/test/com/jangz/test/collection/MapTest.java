package com.jangz.test.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.putAll(getMap());
		map.put("f", 9);
		map.put("A", 0);
		map.forEach((key, value) -> {
			System.out.println("key: " + key + ", value: " + value);
		});
	}
	
	public static Map<String, Integer> getMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		return map;
	}
}
