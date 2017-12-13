package com.jangz.syntax.newfeature.chap4;

import java.util.List;
import java.util.stream.Collectors;

import com.jangz.syntax.newfeature.entity.Dish;

import static java.util.Comparator.comparing;

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
