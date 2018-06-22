package com.pattern.tutor.syntax.scary;

import java.math.BigDecimal;

public class BigDecimalExpression {
	
	public static void main(String[] args) {
		System.out.println(new BigDecimal(0.0).doubleValue() == 0);
		System.out.println(new BigDecimal(0.00).doubleValue() == 0);
		System.out.println(new BigDecimal(0.000).doubleValue() == 0);
		System.out.println(new BigDecimal(00.0).doubleValue() == 0);
		System.out.println(new BigDecimal(00.00).doubleValue() == 0);
	}
}
