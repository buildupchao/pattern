package com.jangz.syntax.newfeature.chap3;

import static java.util.Comparator.comparing;

import java.util.List;

import com.jangz.syntax.newfeature.entity.Apple;
import com.jangz.syntax.newfeature.util.factory.AppleFactory;
import com.jangz.syntax.newfeature.util.factory.StringFactory;

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
