package com.jangz.syntax.newfeature.chap6;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import com.jangz.syntax.newfeature.entity.Dish;

public class GroupingByExample {
	
	public static void main(String[] args) {
//		usingGrouping();
		
//		convertResultType();
		
		otherCollector();
	}
	
	public static void usingGrouping() {
		Dish.menu.stream().collect(groupingBy(Dish::getType)).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		System.out.println("-------------------------------");
		
		Dish.menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIEF;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}))).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		System.out.println("-------------------------------");
		
		Dish.menu.stream().collect(groupingBy(Dish::getType, counting())).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		System.out.println("-------------------------------");
		
		Dish.menu.stream().collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories)))).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		System.out.println("-------------------------------");
	}
	
	public static void convertResultType() {
		Map<Dish.Type, Dish> mostCaloricByType = Dish.menu.stream()
				.collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
		mostCaloricByType.forEach((key, value) -> System.out.println(key + " : " + value));
	}
	
	public static void otherCollector() {
		Dish.menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIEF;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}, toCollection(HashSet::new))))
		.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}

	public enum CaloricLevel {
		DIEF, NORMAL, FAT
	}
}
