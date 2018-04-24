package com.pattern.tutor.syntax.collection.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForeachRemoveOrAddExample {
	
	public static void main(String[] args) {
//		throwConcurrentModificationException();
		iteratorRemove();
	}
	
	public static void iteratorRemove() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("2".equals(item)) {
				iterator.remove();
			}
		}
	}
	
	public static void throwConcurrentModificationException() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for (String item : list) {
			if ("2".equals(item)) {
				list.remove(item);
			}
		}
	}
}
