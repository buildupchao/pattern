package com.pattern.tutor.syntax.collection.action;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 	 SubList will generate ConcurrentModificationException whatever do add, remove, iterate 
 * if Parent List change the total of elements.
 * @author buildupchao
 * @date 2019/07/01 09:06
 * @since JDK 1.8
 */
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
