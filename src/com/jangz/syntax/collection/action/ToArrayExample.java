package com.jangz.syntax.collection.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArrayExample {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(2);
		list.add("guan");
		list.add("bao");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		Arrays.stream(array).forEach(System.out::println);
	}
}
