package com.jangz.pattern.factory;

import java.util.logging.Logger;

public class Test {
	
	private static final Logger log = Logger.getLogger("Test");
	
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		Pizza pizza = nyStore.orderPizza("cheese");
		log.info("Jang ordered a " + pizza.getName());
		
		log.info("-------------------------------------");
		pizza = nyStore.orderPizza("veggie");
		log.info("Bryan ordered a " + pizza.getName());
	}
	
}
