package com.jangz.syntax.newfeature.chap5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.jangz.syntax.newfeature.entity.Dish;
import com.jangz.syntax.newfeature.entity.Pair;

public class MappingExample {

	public static void main(String[] args) {
		/*
		 * println(getNameList());
		 * System.out.println("-----------------------------------");
		 * 
		 * println(getNameLengthList());
		 * System.out.println("-----------------------------------");
		 * 
		 * println(getLengthList());
		 * System.out.println("-----------------------------------");
		 * 
		 * println(getUniqueCharacterList());
		 * System.out.println("-----------------------------------");
		 */

		println(map());
		System.out.println("-----------------------------------");

		println(flatMap());
		System.out.println("-----------------------------------");
		
		println(flatMapAndThreeMultiple());
	}

	public static List<String> getNameList() {
		return Dish.menu.stream().map(Dish::getName).collect(toList());
	}

	public static List<Integer> getNameLengthList() {
		return Dish.menu.stream().map(Dish::getName).map(String::length).collect(toList());
	}

	public static List<Integer> getLengthList() {
		return Arrays.asList("Java 8", "Lambda", "In", "Action").stream().map(String::length).collect(toList());
	}

	public static List<String> getUniqueCharacterList() {
		String[] arrayOfWords = { "Hello", "World" };
		return Arrays.stream(arrayOfWords).map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList());
	}

	public static List<Integer> map() {
		return Arrays.asList(1, 2, 3, 4, 5).stream().map(n -> n * n).collect(toList());
	}

	public static List<Pair> flatMap() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		return numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new Pair<Integer>(i, j))).collect(toList());
	}
	
	public static List<Pair> flatMapAndThreeMultiple() {
		return flatMap().stream().filter(pair -> (pair.sum() % 3 == 0)).collect(toList());
	}

	public static <T> void println(List<T> list) {
		list.forEach(System.out::println);
	}
}
