package com.jangz.syntax.newfeature.lambda;

import java.util.List;
import java.util.stream.Collectors;

import com.jangz.syntax.newfeature.entity.Apple;
import com.jangz.syntax.newfeature.util.DistinctUtils;
import com.jangz.syntax.newfeature.util.factory.AppleFactory;
import com.jangz.syntax.util.PrintlnUtils;

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
