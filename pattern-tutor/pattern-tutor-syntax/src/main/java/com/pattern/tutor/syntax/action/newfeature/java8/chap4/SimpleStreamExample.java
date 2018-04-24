package com.pattern.tutor.syntax.action.newfeature.java8.chap4;

import static java.util.Comparator.comparing;

import java.util.List;
import java.util.stream.Collectors;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Dish;

public class SimpleStreamExample {

	public static void main(String[] args) {
		System.out.println(getLowCaloricDishesName(Dish.menu));
		System.out.println("------------------------------------");
		
		System.out.println(getThreeHighCaloricDishNames(Dish.menu));
	}

	public static List<String> getLowCaloricDishesName(List<Dish> list) {
		return list.stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories)).map(Dish::getName)
				.collect(Collectors.toList());
	}

	public static List<String> getThreeHighCaloricDishNames(List<Dish> list) {
		return list.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3)
				.collect(Collectors.toList());
	}
}
