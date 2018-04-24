package com.jangz.test.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class MyList<T> implements Iterable<T> {

	T[] elements;
	private int size;
	
	public MyList(T[] elements) {
		this.elements = elements;
		this.size = elements.length;
	}

	public MyList() {
		this.elements = (T[]) new Object[16];
	}
	
	public void add(T element) {
		if (size < 16) {
			elements[size++] = element;
		}
	}
	
	public void remove(T element) {
		Arrays.asList(elements).remove(element);
	}
	
	@Override
	public Iterator<T> iterator() {
		return Arrays.asList(elements).iterator();
	}
}
