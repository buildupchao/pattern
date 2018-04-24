package com.jangz.syntax.action.newfeature.java8.lambda;

import java.util.List;
import java.util.stream.Collectors;

import com.jangz.syntax.action.newfeature.java8.entity.Apple;
import com.jangz.syntax.action.newfeature.java8.util.DistinctUtils;
import com.jangz.syntax.action.newfeature.java8.util.factory.AppleFactory;
import com.jangz.utils.PrintlnUtils;

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
