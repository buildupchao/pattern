package com.pattern.designpattern.cor.handler;

/**
 * 价格处理人，负责处理客户折扣申请
 * PriceHandler
 * 
 * <p>
 * 
 * @author jangz
 * @since 1.0
 * @see
 */
public abstract class PriceHandler {
	
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
	
	/**
	 * 处理折扣申请
	 */
	public abstract void processDiscount(float discount);
}
