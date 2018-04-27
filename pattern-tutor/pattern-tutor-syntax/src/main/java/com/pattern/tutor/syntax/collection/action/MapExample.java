package com.pattern.tutor.syntax.collection.action;

import java.util.HashMap;
import java.util.Map;

import com.pattern.tutor.syntax.collection.entity.KeyExample;

public class MapExample {
	
	public static void main(String[] args) {
		HashMap<KeyExample, String> map = new HashMap<>();
		map.put(new KeyExample("jangz", 7), "jangz");
		map.put(new KeyExample("Zychaowill", 12), "Zychaowill");
		map.put(new KeyExample("小魔王先生", 17), "小魔王先生");
		
		for (Map.Entry<KeyExample, String> entry : map.entrySet()) {
			System.out.printf("name={%s}, number={%d}, value={%s}.\n", entry.getKey().getName(), entry.getKey().getNumber(), entry.getValue());
		}
	}
}
