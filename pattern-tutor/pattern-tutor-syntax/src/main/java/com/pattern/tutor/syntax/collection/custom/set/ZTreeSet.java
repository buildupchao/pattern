package com.pattern.tutor.syntax.collection.custom.set;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 * @see     Collection
 * @see     Set
 * @see     HashSet
 * @see     Comparable
 * @see     Comparator
 * @see     TreeMap
 */
public class ZTreeSet<E> extends AbstractSet<E> 
	implements NavigableSet<E>, Cloneable, Serializable {

	private static final long serialVersionUID = 3603120050942112957L;

	private transient NavigableMap<E, Object> m;
	
	private static final Object PRESENT = new Object(); 

	ZTreeSet(NavigableMap<E, Object> m) {
		this.m = m;
	}
	
	public ZTreeSet() {
		this(new TreeMap<E, Object>());
	}

	public ZTreeSet(Comparator<? super E> comparator) {
		this(new TreeMap<>(comparator));
	}
	
	public ZTreeSet(Collection<? extends E> c) {
		this();
		addAll(c);
	}
	
	public ZTreeSet(SortedSet<E> s) {
		this(s.comparator());
		addAll(s);
	}
	
	@Override
	public Comparator<? super E> comparator() {
		return m.comparator();
	}

	@Override
	public E first() {
		return m.firstKey();
	}

	@Override
	public E last() {
		return m.lastKey();
	}

	@Override
	public E lower(E e) {
		return m.lowerKey(e);
	}

	@Override
	public E floor(E e) {
		return m.floorKey(e);
	}

	@Override
	public E ceiling(E e) {
		return m.ceilingKey(e);
	}

	@Override
	public E higher(E e) {
		return m.higherKey(e);
	}

	@Override
	public E pollFirst() {
		Map.Entry<E, ?> e = m.pollFirstEntry();
		return (e == null) ? null : e.getKey();
	}

	@Override
	public E pollLast() {
		Map.Entry<E, ?> e = m.pollLastEntry();
		return (e == null) ? null : e.getKey();
	}

	@Override
	public NavigableSet<E> descendingSet() {
		return new ZTreeSet<>(m.descendingMap());
	}

	@Override
	public Iterator<E> descendingIterator() {
		return m.descendingKeySet().descendingIterator();
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
			E toElement, boolean toInclusive) {
		return null;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		return null;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		return null;
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		return null;
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		return null;
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return m.navigableKeySet().iterator();
	}

	@Override
	public int size() {
		return m.size();
	}
	
    public boolean isEmpty() {
        return m.isEmpty();
    }
}
