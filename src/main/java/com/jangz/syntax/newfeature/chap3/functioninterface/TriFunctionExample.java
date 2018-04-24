package com.jangz.syntax.newfeature.chap3.functioninterface;

import com.jangz.syntax.newfeature.entity.Color;

public class TriFunctionExample {
	
	public static void main(String[] args) {
		TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;
		
		Color color = colorFactory.apply(112, 120, 255);
		System.out.println(color);
	}
}