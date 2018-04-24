package com.pattern.tutor.syntax.collection.action;

import java.util.ArrayList;
import java.util.List;

public class SubListExample {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		// ArrayList<Integer> subList = (ArrayList<Integer>) list.subList(1, 3);
		List<Integer> subList = list.subList(1, 3);
//		list.remove(4);
		for (Integer number : subList) {
			System.out.println(number);
		}
	}
}
