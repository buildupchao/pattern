package com.pattern.designpattern.cor;

import java.util.Random;

import com.pattern.designpattern.cor.handler.HandlerFactory;
import com.pattern.designpattern.cor.handler.PriceHandler;

public class ClientRequest {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		PriceHandler handler = null;
		for (int i = 1; i <= 100; i++) {
			handler = HandlerFactory.createPriceHandler();
			float requestDiscount = rand.nextFloat();
			handler.processDiscount(requestDiscount);
		}
	}
	
}
