package com.jangz.syntax.newfeature.chap5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.jangz.syntax.newfeature.entity.Dish;

public class FilteringExample {

	public static void main(String[] args) {
//		filterByPredicate().forEach(System.out::println);
		
//		filterWithDistinct();
		
//		filterByPredicateWithLimit().forEach(System.out::println);
		
		filterByPredicateWithSkip().forEach(System.out::println);
	}

	public static List<Dish> filterByPredicate() {
		return Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
	}

	public static void filterWithDistinct() {
		Arrays.asList(1, 2, 1, 3, 3, 2, 4).stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
	}
	
	public static List<Dish> filterByPredicateWithLimit() {
		return Dish.menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
	}
	
	public static List<Dish> filterByPredicateWithSkip() {
		return Dish.menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
	}
}
