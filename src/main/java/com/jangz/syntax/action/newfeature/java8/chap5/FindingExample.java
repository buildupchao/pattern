package com.jangz.syntax.action.newfeature.java8.chap5;

import java.util.Arrays;
import java.util.Optional;

import com.jangz.syntax.action.newfeature.java8.entity.Dish;

public class FindingExample {

	public static void main(String[] args) {
		anyMatch();
		
		allMatch();
		
		noneMatch();
		
		System.out.println(findAny());
		System.out.println(findFirst());
		
		findAny().ifPresent(d -> System.out.println(d.getName()));
	}
	
	public static void anyMatch() {
		if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		} else {
			System.out.println("Not anyMatch");
		}
	}
	
	public static void allMatch() {
		if (Dish.menu.stream().allMatch(d -> d.getCalories() < 1000)) {
			System.out.println("The menu is calories friendly!!");
		} else {
			System.out.println("Not allMatch");
		}
	}
	
	public static void noneMatch() {
		if (Dish.menu.stream().noneMatch(dish -> dish.getName().equals("Tomato"))) {
			System.out.println("no tomato");
		} else {
			System.out.println("has a tomato");
		}
	}
	
	public static Optional<Dish> findAny() {
		return Dish.menu.stream().filter(Dish::isVegetarian).findAny();
	}
	
	public static Optional<Integer> findFirst() {
		return Arrays.asList(1, 2, 3, 4, 5).stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
	}
}
