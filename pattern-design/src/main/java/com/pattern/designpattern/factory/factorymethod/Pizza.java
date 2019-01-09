package com.pattern.designpattern.factory.factorymethod;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public abstract class Pizza {
	
	private static final Logger log = Logger.getLogger("Pizza");
	
	String name;
	String dough;
	String sauce;
	List<String> toppings = new ArrayList<>();
	
	public void prepare() {
		log.info("Prepare " + name);
		log.info("Tossing dough...");
		log.info("Adding sauce...");
		log.info("Adding toppings: ");
		for (int i = 0; i < toppings.size(); i++) {
			log.info("  " + toppings.get(i));
		}
	}
	
	public void bake() {
		log.info("Bake for 25 minutes at 350");
	}
	
	public void cut() {
		log.info("Cutting the pizza into diagonal slices");
	}
	
	public void box() {
		log.info("Place pizza in official PizzaStore box");
	}
	
	public String getName() {
		return name;
	}
}
