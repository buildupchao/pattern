package com.pattern.tutor.syntax.datastructure.map;

public interface MyMap<K, V> {
	
	public V put(K k, V v);
	
	public V get(K k);
	
	interface Entry<K, V> {
		
		public K getKey();
		
		public V getValue();
	}
}
