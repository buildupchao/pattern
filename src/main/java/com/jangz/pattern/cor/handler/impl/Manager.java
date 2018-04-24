package com.jangz.pattern.cor.handler.impl;

import com.jangz.pattern.cor.handler.PriceHandler;

/**
 * 
 * Manager
 * 
 * <p>
 * 
 * @author jangz
 * @since 1.0
 * @see
 */
public class Manager extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount >= 0.70) {
			System.out.format("%s批准了折扣:%2f%n", this.getClass().getSimpleName(), discount);
		} else {
			successor.processDiscount(discount);
		}
	}

}
