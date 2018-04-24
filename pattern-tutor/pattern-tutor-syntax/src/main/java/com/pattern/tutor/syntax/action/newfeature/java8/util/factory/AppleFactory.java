package com.pattern.tutor.syntax.action.newfeature.java8.util.factory;

import java.util.Arrays;
import java.util.List;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Apple;

public class AppleFactory {

	public static List<Apple> generateInventory() {
		return Arrays.asList(new Apple(80, "green", "China"), new Apple(120, "green", "Australia"), new Apple(155, "green", "Canada"), new Apple(120, "red", "American"));
	}
}
