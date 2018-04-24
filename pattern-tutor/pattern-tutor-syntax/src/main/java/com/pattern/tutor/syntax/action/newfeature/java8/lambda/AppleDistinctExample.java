package com.pattern.tutor.syntax.action.newfeature.java8.lambda;

import java.util.List;
import java.util.stream.Collectors;

import com.pattern.common.utils.PrintlnUtils;
import com.pattern.tutor.syntax.action.newfeature.java8.entity.Apple;
import com.pattern.tutor.syntax.action.newfeature.java8.util.DistinctUtils;
import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.AppleFactory;

public class AppleDistinctExample {

	public static void main(String[] args) {
		new AppleDistinctExample().distinct(AppleFactory.generateInventory());
	}
	
	public void distinct(List<Apple> apples) {
		apples.stream()
			.filter(DistinctUtils.distinct(Apple::getWeight))
			.collect(Collectors.toList())
			.forEach(PrintlnUtils::println);
	}
}
