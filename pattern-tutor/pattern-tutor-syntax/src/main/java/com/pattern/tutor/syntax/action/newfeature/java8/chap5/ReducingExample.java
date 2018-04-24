package com.pattern.tutor.syntax.action.newfeature.java8.chap5;

import java.util.List;
import java.util.Optional;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Dish;
import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.IntegerFactory;

public class ReducingExample {
	
	public static void main(String[] args) {
		List<Integer> numbers = IntegerFactory.generateIntegerList();
		System.out.println(sumWithInitial(numbers));
		
		System.out.println("max: " + max(numbers));
		
		System.out.println("min: " + min(numbers));
		
		System.out.println("count: " + countVegetian());
	}
	
	public static Optional<Integer> sum(List<Integer> numbers) {
		return numbers.stream().reduce(Integer::sum);
	}
	
	public static Integer sumWithInitial(List<Integer> numbers) {
		return numbers.stream().reduce(0, Integer::sum);
	}
	
	public static Optional<Integer> max(List<Integer> numbers) {
		return numbers.stream().reduce(Integer::max);
	}
	
	public static Optional<Integer> min(List<Integer> numbers) {
		return numbers.stream().reduce(Integer::min);
	}
	
	public static Long countVegetian() {
//		return Dish.menu.stream().map(d -> 1).reduce(0, Integer::sum);
		return Dish.menu.stream().count();
	}
}
