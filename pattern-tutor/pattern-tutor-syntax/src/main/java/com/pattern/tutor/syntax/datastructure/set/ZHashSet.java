package com.pattern.tutor.syntax.datastructure.set;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;

/**
 * @see Collection
 * @see Set
 * @see TreeSet
 * @see HashMap
 * @see HashSet
 */
// HashSet
public class ZHashSet<E> extends AbstractSet<E> 
	implements Set<E>, Cloneable, Serializable {

	private static final long serialVersionUID = 7556727555663012433L;

	private transient HashMap<E, Object> map;
	/* Dummy value to associate with an object in the backing map */
	private static final Object PRESENT = new Object();

	public ZHashSet() {
		map = new HashMap<>();
	}

	public ZHashSet(Collection<? extends E> c) {
		map = new HashMap<>(Math.max((int) (c.size() / 0.75f), 16));
		addAll(c);
	}

	public ZHashSet(int initialCapacity, int loadFactor) {
		map = new HashMap<>(initialCapacity, loadFactor);
	}

	public ZHashSet(int initialCapacity) {
		map = new HashMap<>(initialCapacity);
	}

	ZHashSet(int initialCapacity, int loadFactor, boolean dummy) {
		map = new LinkedHashMap<>(initialCapacity, loadFactor);
	}

	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	@Override
	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}

	@Override
	public boolean remove(Object o) {
		return map.remove(o) == PRESENT;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@SuppressWarnings("unchecked")
	protected Object clone() {
		try {
			ZHashSet<E> newSet = (ZHashSet<E>) super.clone();
			newSet.map = (HashMap<E, Object>) map.clone();
			return newSet;
		} catch (CloneNotSupportedException ex) {
			throw new InternalError(ex);
		}
	}

	/**
	 * no-realize
	 */
	@Override
	public Spliterator<E> spliterator() {
		return null;
	}
}
