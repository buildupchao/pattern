package com.jangz.syntax.action.newfeature.java8.chap4;

import com.jangz.syntax.action.newfeature.java8.entity.Dish;

public class TerminalOperationExample {

	public static void main(String[] args) {
		long count = Dish.menu.stream().filter(d -> d.getCalories() > 300).distinct().limit(3).count();
		System.out.println(count);
	}
}
