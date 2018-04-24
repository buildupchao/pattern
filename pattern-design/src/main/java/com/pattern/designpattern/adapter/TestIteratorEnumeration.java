package com.pattern.designpattern.adapter;

import java.util.ArrayList;
import java.util.logging.Logger;

public class TestIteratorEnumeration {

	private static final Logger log = Logger.getLogger("TestIteratorEnumeration");

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("jangz");
		list.add("Forward");
		list.add("Sunny");

		IteratorEnumeration<String> enumeration = new IteratorEnumeration<>(list.iterator());
		while (enumeration.hasMoreElements()) {
			log.info(enumeration.nextElement());
		}
	}

}
