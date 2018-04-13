package com.jangz.syntax.collection.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetUnSortExample {
	
	public static void main(String[] args) {
		unSort();
	}
	
	public static void unSort() {
		Random random = new Random(47);
		Set<Integer> intSet = new HashSet<Integer>();
		for (int i = 0; i < 10_000; i++)
			intSet.add(random.nextInt(30) + (1 << 16));
		Iterator<Integer> iterator = intSet.iterator();
		while (iterator.hasNext())
			System.out.print((iterator.next() - (1 << 16)) + " ");
		System.out.println("\nsize:" + intSet.size());
	}
}
