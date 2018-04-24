package com.pattern.designpattern.cor.handler.impl;

import com.pattern.designpattern.cor.handler.PriceHandler;

/**
 * 销售，可以批准5%以内的折扣
 * Sales
 * 
 * <p>
 * 
 * @author jangz
 * @since 1.0
 * @see
 */
public class Sales extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount >= 0.90) {
			System.out.format("%s批准了折扣: %2f%n", this.getClass().getSimpleName(), discount);
		} else {
			successor.processDiscount(discount);
		}
	}
	
	
}
