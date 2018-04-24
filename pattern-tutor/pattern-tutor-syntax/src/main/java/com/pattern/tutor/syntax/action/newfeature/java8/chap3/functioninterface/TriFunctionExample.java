package com.pattern.tutor.syntax.action.newfeature.java8.chap3.functioninterface;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Color;

public class TriFunctionExample {
	
	public static void main(String[] args) {
		TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;
		
		Color color = colorFactory.apply(112, 120, 255);
		System.out.println(color);
	}
}