package com.jangz.syntax.newfeature.chap6;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import com.jangz.syntax.newfeature.entity.Dish;

public class CollectingExample {

	public static void main(String[] args) {
		/*
		 * usingMaxBy();
		 * 
		 * usingSummingInt();
		 * 
		 * usingAveragingInt();
		 * 
		 * usingSummarizingInt();
		 */

		usingJoiningWithSeparator();

		usingReducing();
	}

	public static void usingMaxBy() {
		Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));

		System.out.println(mostCalorieDish.orElse(new Dish("default", false, 0, null)));
	}

	public static void usingSummingInt() {
		Integer totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));

		System.out.println("usingSummingInt: " + totalCalories);
	}

	public static void usingAveragingInt() {
		Double averageCalories = Dish.menu.stream().collect(averagingInt(Dish::getCalories));

		System.out.println("usingAveragingInt: " + averageCalories);
	}

	public static void usingSummarizingInt() {
		IntSummaryStatistics menuCalories = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));

		System.out.println("usingSummarizingInt[menuCalories]: " + menuCalories);
	}

	public static String usingJoining(String separator) {
		return Dish.menu.stream().map(Dish::getName).collect(joining(separator));
	}

	public static void usingJoiningWithSeparator() {
		String shortName = usingJoining(",");

		System.out.println(shortName);
	}

	public static void usingReducing() {
		int totalCalories = Dish.menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
		Optional<Dish> mostCaloriesDish = Dish.menu.stream()
				.collect(reducing((a, b) -> a.getCalories() > b.getCalories() ? a : b));
		
		int sameTotalCalories = Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
		
		String shortName = Dish.menu.stream().map(Dish::getName).collect(reducing((s, t) -> s + t)).get();
		
		System.out.println("usingReducing[totalCalories]: " + totalCalories);
		System.out.println(
				"usingReducing[mostCaloriesDish]: " + mostCaloriesDish.orElse(new Dish("default", false, 0, null)));
		System.out.println("usingReducing[sameTotalCalories]: " + sameTotalCalories);
		System.out.println("usingReducing[shortName]: " + shortName);
	}
}
