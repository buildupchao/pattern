package com.pattern.tutor.syntax.collection.layer;

import java.util.HashSet;

import com.pattern.tutor.syntax.collection.entity.KeyExample;

public class CollectionLayerRelationshipExample {
	
	public static void main(String[] args) {
		HashSet<KeyExample> set = new HashSet<>();
		set.add(new KeyExample("jangz", 7));
		set.add(new KeyExample("jangz", 12));
		
		System.out.printf("set size={%d}.\n", set.size());
	}
}
