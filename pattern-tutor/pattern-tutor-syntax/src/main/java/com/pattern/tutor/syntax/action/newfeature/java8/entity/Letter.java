package com.pattern.tutor.syntax.action.newfeature.java8.entity;

public class Letter {
	
	public static String addHeader(String text) {
		return "From Raoul, Mario and Alan: " + text;
	}
	
	public static String addFooter(String text) {
		return text + " Kine regards";
	}
	
	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
}
