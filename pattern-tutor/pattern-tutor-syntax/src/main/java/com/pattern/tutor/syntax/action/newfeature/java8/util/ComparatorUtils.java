package com.pattern.tutor.syntax.action.newfeature.java8.util;

import java.util.Comparator;
import java.util.function.Function;

public class ComparatorUtils {

	public static <T, U extends Comparable<U>> Comparator<T> comparator(Function<T, U> keyExtractor) {
		return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
	}
}
