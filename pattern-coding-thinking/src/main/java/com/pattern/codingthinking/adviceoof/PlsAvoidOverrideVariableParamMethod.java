package com.pattern.codingthinking.adviceoof;

import java.text.NumberFormat;

public class PlsAvoidOverrideVariableParamMethod {
	
	public void calPrice(int price, int discount) {
		float knockdownPrice = price * discount / 100.0F;
		System.out.println("简单折扣后的价格是: " + formatCurrency(knockdownPrice));
	}
	
	public void calPrice(int price, int... discounts) {
		float knockdownPrice = price;
		for (int discount : discounts) {
			knockdownPrice = knockdownPrice * discount / 100;
		}
		System.out.println("复杂折旧后的价格是: " + formatCurrency(knockdownPrice));
	}
	
	private String formatCurrency(float price) {
		return NumberFormat.getCurrencyInstance().format(price / 100);
	}
	
	public static void main(String[] args) {
		new PlsAvoidOverrideVariableParamMethod().calPrice(49900, 75); // 简单折扣
	}
}
