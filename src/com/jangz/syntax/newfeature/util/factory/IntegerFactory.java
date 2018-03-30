package com.jangz.syntax.newfeature.util.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerFactory {
	
	public static List<Integer> generateIntegerList() {
		return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}
	
	public static List<Integer> generateIntegerList(Integer startInclusive, Integer endInclusive) {
		return IntStream.rangeClosed(startInclusive, endInclusive).boxed().collect(Collectors.toList());
	}
}
