package com.pattern.tutor.syntax.collection.action;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class HashtableExample {
	
	public static void main(String[] args) {
		Hashtable<String, List<Object>> table = new Hashtable<>();
		table.put("A", Arrays.asList("3"));
		table.forEach((key, value) -> System.out.println(key + ":" + value));
	}
}
