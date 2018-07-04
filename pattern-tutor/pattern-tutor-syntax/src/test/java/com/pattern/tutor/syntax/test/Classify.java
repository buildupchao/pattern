package com.pattern.tutor.syntax.test;

import java.util.regex.Pattern;

public class Classify {
	
	public int classify(int number) {
		boolean belongsToFirst = 
				Pattern.matches("\\d{5}[1|2|3]\\d*", String.valueOf(number));
		
		return (belongsToFirst ? 1 : 2);
	}
	
	public int pickOut(int number) {
		
		return 1;
	}
	
	public static void main(String[] args) {
		Classify classify = new Classify();
		System.out.println(classify.classify(123451));
		System.out.println(classify.classify(123452));
		System.out.println(classify.classify(123453));
		System.out.println(classify.classify(1234530));
		System.out.println(classify.classify(1234520));
		System.out.println(classify.classify(1234510));
	}
}
