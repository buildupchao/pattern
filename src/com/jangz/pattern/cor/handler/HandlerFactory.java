package com.jangz.pattern.cor.handler;

import com.jangz.pattern.cor.handler.impl.CEO;
import com.jangz.pattern.cor.handler.impl.Director;
import com.jangz.pattern.cor.handler.impl.Manager;
import com.jangz.pattern.cor.handler.impl.Sales;

public class HandlerFactory {
	
	public static PriceHandler createPriceHandler() {
		Sales sales = new Sales();
		Manager manager = new Manager();
		Director director = new Director();
		CEO ceo = new CEO();
		
		sales.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(ceo);
		
		return sales;
	}
}
