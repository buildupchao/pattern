package com.jangz.syntax.newfeature.chap2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jangz.syntax.newfeature.entity.Apple;
import com.jangz.syntax.newfeature.util.factory.AppleFactory;

public class AppleComparator {

	public static void main(String[] args) {
		List<Apple> inventory = AppleFactory.generateInventory();
		inventory.forEach(System.out::println);
		System.out.println("------------------------------");

		sort(inventory);
		inventory.forEach(System.out::println);
		System.out.println("------------------------------");
		
		List<Apple> newInventory = AppleFactory.generateInventory();
		newInventory.sort((Apple a1, Apple a2) -> (a1.getWeight() - a2.getWeight()));
		newInventory.forEach(System.out::println);
	}

	public static void sort(List<Apple> inventory) {
		Comparator<Apple> byWeight = new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return (o1.getWeight() - o2.getWeight());
			}
		};

		Collections.sort(inventory, byWeight);
	}
}
