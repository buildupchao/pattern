package com.jangz.pattern.apply.noifelse4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Client {
	
	private Customer customer;
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testConsume() {
		try {
			customer.consume();
		} catch (MovieException e) {
			System.out.println("Movie doesn't exist");
		}
	}
}
