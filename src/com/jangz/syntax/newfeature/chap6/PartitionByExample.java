package com.jangz.syntax.newfeature.chap6;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;

import com.jangz.syntax.newfeature.entity.Dish;

public class PartitionByExample {

	public static void main(String[] args) {
//		getVegetarianList();
		
		getPrimeList(100);
	}

	public static void getVegetarianList() {
		Dish.menu.stream().filter(Dish::isVegetarian).collect(toList()).forEach(System.out::println);
		System.out.println("-----------------------------------------");

		Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)))
				.forEach((key, value) -> {
					System.out.println(key + " : " + value);
				});
	}

	public static void getPrimeList(int n) {
		IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(candidate -> isPrime(candidate))).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}

	private static boolean isPrime(int candidate) {
		return IntStream.rangeClosed(2, (int) Math.sqrt(candidate)).noneMatch(i -> candidate % i == 0);
	}
}
