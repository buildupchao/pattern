package com.jangz.test.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.jangz.test.iterator.exception.IteratorException;

public class IteratorExceptionExample {
	
	public static void main(String[] args) {
		List<Integer> numbers = generateSimpleIntegerList();
		numbers.stream().forEach(x -> System.out.print(x + "\t"));
		System.out.println(", length: " + numbers.size());
		
//		removeByIterator(numbers);
		removeByBasicStructure(numbers);
	}
	
	private static List<Integer> generateSimpleIntegerList() {
		List<Integer> result = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			result.add(rand.nextInt(100));
		}
		return result; 
	}
	
	protected static void removeByIterator(List<?> numbers) {
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
	
	protected static void removeByBasicStructure(List<?> numbers) {
		for (Object element : numbers) {
			if (element != null) {
				try {
					numbers.remove(element);
					System.out.println("left numbers: " + numbers.stream().map(number -> number.toString()).collect(Collectors.joining(", ")));
					System.out.println("[removeByBasicStructure] remove element: " + element);
				} catch (Exception e) {
					throw new IteratorException("[removeByBasicStructure] element: " + element);
				}
			}
		}
	}
}
