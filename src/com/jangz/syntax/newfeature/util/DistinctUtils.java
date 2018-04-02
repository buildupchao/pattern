package com.jangz.syntax.newfeature.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import com.jangz.syntax.newfeature.entity.Apple;

public class DistinctUtils {
	
	public static Predicate<Apple> distinct(Function<? super Apple, Integer> keyExtractor) {
		Map<Integer, Boolean> filter = new ConcurrentHashMap<>();
		return t -> filter.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
