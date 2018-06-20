package com.pattern.tutor.syntax.test.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import com.pattern.tutor.syntax.test.iterator.exception.IteratorException;

public class IterableExceptionExample {
	
	public static void main(String[] args) {
		Integer[] numberArr = generateSimpleIntegerList();
		Arrays.stream(numberArr).forEach(x -> System.out.print(x + "\t"));
		System.out.println(", length: " + numberArr.length);

		MyList<Integer> numbers = new MyList<>(numberArr);
		removeByIterator(numbers);
	}
	
	private static Integer[] generateSimpleIntegerList() {
		Integer[] result = new Integer[10];
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			result[i] = rand.nextInt(100);
		}
		return result; 
	}
	
	protected static void removeByIterator(MyList<?> numbers) {
		Iterator<?> iter = numbers.iterator();
		while (iter.hasNext()) {
			Object element = iter.next();
			if (element != null) {
				try {
					iter.remove();
					System.out.println("[removeByIterator] remove element: " + element);
				} catch (Exception e) {	
					throw new IteratorException("[removeByIterator] element: " + element);
				}
			}
		}
	}
}
