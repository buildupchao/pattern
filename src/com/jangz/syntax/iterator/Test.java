package com.jangz.syntax.iterator;

import java.util.Objects;

import com.jangz.syntax.iterator.ContactList.ContactAction;

public class Test {

	public static void main(String[] args) {
		ContactList list = new ContactList();
		list.add("jangz");
		list.add("Bryan");
		list.add("David");
		
		Objects.requireNonNull(list);
		list.forEach(new ContactAction());
	}

}
