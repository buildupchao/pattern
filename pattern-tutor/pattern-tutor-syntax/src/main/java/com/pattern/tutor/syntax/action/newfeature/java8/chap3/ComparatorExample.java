package com.pattern.tutor.syntax.action.newfeature.java8.chap3;

import static java.util.Comparator.comparing;

import java.util.List;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Apple;
import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.AppleFactory;
import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.StringFactory;

public class ComparatorExample {

	public static void main(String[] args) {
		List<Apple> inventory = AppleFactory.generateInventory();
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));

		inventory.stream().forEach(System.out::println);
		System.out.println("--------------------------------");

		List<String> strList = StringFactory.generateSingleCharacterList();
		strList.sort(String::compareToIgnoreCase);
		strList.forEach(System.out::println);
	}
}
