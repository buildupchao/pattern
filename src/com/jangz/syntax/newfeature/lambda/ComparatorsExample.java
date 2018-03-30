package com.jangz.syntax.newfeature.lambda;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Joiner;
import com.jangz.syntax.newfeature.entity.Apple;
import com.jangz.syntax.newfeature.util.ComparatorUtils;
import com.jangz.syntax.newfeature.util.factory.IntegerFactory;
import com.jangz.syntax.util.PrintlnUtils;

public class ComparatorsExample {

	public static void main(String[] args) {
//		new ComparatorsExample().compare(AppleFactory.generateInventory());
		
		List<Integer> numbers = IntegerFactory.randomInteger();
		PrintlnUtils.println(Joiner.on(",").join(numbers));
		new ComparatorsExample().compareUnsigned(numbers);
	}
	
	public <T, U extends Comparable<U>> void compare(List<Apple> apples) {
		apples.stream()
			.sorted(ComparatorUtils.comparator(Apple::getWeight))
			.forEach(System.out::println);
	}
	
	/**
	 * Magical sort.
	 * @see
	 * @param numbers
	 */
	public void compareUnsigned(List<Integer> numbers) {
		Collections.sort(numbers, Integer::compareUnsigned);
		PrintlnUtils.println(Joiner.on(",").join(numbers));
	}
}
