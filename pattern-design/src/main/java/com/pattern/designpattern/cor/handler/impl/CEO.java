package com.pattern.designpattern.cor.handler.impl;

import com.pattern.designpattern.cor.handler.PriceHandler;

/**
 * 
 * CEO
 * 
 * <p>
 * 
 * @author jangz
 * @since 1.0
 * @see
 */
public class CEO extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount >= 0.55) {
			System.out.format("%s批准了折扣:%2f%n", this.getClass().getSimpleName(), discount);
		} else {
			System.out.format("%s拒绝了折扣:%2f%n", this.getClass().getSimpleName(), discount);
		}
	}

}
