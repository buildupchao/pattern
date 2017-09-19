package com.jangz.test.refer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReferList {
	
	public static void main(String[] args) {
//		testList();
		testStringBuffer();
	}
	
	public static void testList() {
		List<List<String>> fatherList = new LinkedList<>();
		List<String> childList = new ArrayList<>();
		childList.add("Before add child list");
		fatherList.add(childList);
		childList.add("after add child List");
		
		fatherList.stream().forEach(child -> {
			child.stream().forEach(str -> {
				System.out.println("content: " + str);
			});
		});
	}
	
	public static void testStringBuffer() {
		String str1 = "hello";
		String str2 = "world";
		
		System.out.println(str1 + "---" + str2);
		change(str1, str2);
		System.out.println(str1 + "---" + str2);
		
		StringBuffer buffer1 = new StringBuffer("hello");
		StringBuffer buffer2 = new StringBuffer("world");
		System.out.println(buffer1 + "---" + buffer2);
		change(buffer1, buffer2);
		System.out.println(buffer1 + "---" + buffer2);
	}
	
	private static void change(StringBuffer buffer1, StringBuffer buffer2) {
		buffer1 = buffer2;
		buffer2.append(buffer1);
	}
	
	private static void change(String str1, String str2) {
		str1 = str2;
		str2 = str1 + str2;
	}
}
