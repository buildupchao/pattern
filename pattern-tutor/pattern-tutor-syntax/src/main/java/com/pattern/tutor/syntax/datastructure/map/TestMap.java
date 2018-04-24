package com.pattern.tutor.syntax.datastructure.map;

public class TestMap {
	
	public static void main(String[] args) {
		MyMap<String, String> myMap = new MyHashMap<String, String>();
		
		myMap.put("jangz", "Jang Zhang");
		
		System.out.println(myMap.get("jangz"));
		
		myMap.put("jangz", "Wolf");
		System.out.println(myMap.get("jangz"));
	}
}
