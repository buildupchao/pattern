package com.pattern.tutor.syntax.collection.sort;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class MapValueComparator implements Comparator<Map.Entry<String, String>> {

	@Override
	public int compare(Entry<String, String> o1, Entry<String, String> o2) {
		return -o1.getValue().compareTo(o2.getValue());
	}

}
