package com.jangz.structure.list;

import java.util.AbstractList;
import java.util.Hashtable;
import java.util.List;
import java.util.RandomAccess;
import java.util.Stack;

public class ZVector<E> extends AbstractList<E>
	implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

	private static final long serialVersionUID = 8030975378741792797L;

	public ZVector() {
		// Vector
//		 Hashtable table = new Hashtable<>();
//		 Stack stack = new Stack<>();
		// Comparable
		// Comparator
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}
