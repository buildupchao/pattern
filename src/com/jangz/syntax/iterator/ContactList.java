package com.jangz.syntax.iterator;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ContactList extends ArrayList<String> {
	
	private static final long serialVersionUID = -7938096318820818916L;
	
	private static final Logger log = Logger.getLogger("ContactList");
	
	public void forEach(Consumer<? super String> action) {
		super.forEach(action);
	}
	
	static class ContactAction implements Consumer<String> {

		@Override
		public void accept(String t) {
			log.info(t + " is your contact.");
		}
		
	}
}
