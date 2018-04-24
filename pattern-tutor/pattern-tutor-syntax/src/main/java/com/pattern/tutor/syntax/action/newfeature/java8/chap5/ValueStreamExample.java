package com.pattern.tutor.syntax.action.newfeature.java8.chap5;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Dish;
import com.pattern.tutor.syntax.action.newfeature.java8.entity.Tuple;

public class ValueStreamExample {

	public static void main(String[] args) {
/*		println(sum());

		println(convertToStream().findAny());

		println(getMaxByOptionalInt());

		println(generateNumbers(1, 100).count());

		println(newGenerateNumbers(1, 100).count());*/
		
		pythagoreanTheorem();
	}

	public static int sum() {
		return Dish.menu.stream().mapToInt(Dish::getCalories).sum();
	}

	public static Stream<Integer> convertToStream() {
		return Dish.menu.stream().mapToInt(Dish::getCalories).boxed();
	}

	public static int getMaxByOptionalInt() {
		return Dish.menu.stream().mapToInt(Dish::getCalories).max().orElse(Integer.MIN_VALUE);
	}

	public static IntStream generateNumbers(int start, int end) {
		return IntStream.range(start, end);
	}

	public static IntStream newGenerateNumbers(int start, int end) {
		return IntStream.rangeClosed(start, end);
	}

	public static void pythagoreanTheorem() {
		IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).boxed()
				.map(b -> new Tuple(a, b, Math.sqrt(a * a + b * b))).filter(t -> t.getC().doubleValue() % 1 == 0)
				.map(t -> new Tuple(t.getA(), t.getB(), t.getC().intValue())))
				.limit(5).forEach(System.out::println);
	}

	public static <T> void println(List<T> list) {
		list.stream().forEach(System.out::println);
		System.out.println("------------------------------------");
	}

	public static <T> void println(T t) {
		System.out.println(t);
		System.out.println("------------------------------------");
	}
}
