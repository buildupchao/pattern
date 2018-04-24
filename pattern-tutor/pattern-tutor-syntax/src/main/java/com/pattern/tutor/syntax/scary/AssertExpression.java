package com.pattern.tutor.syntax.scary;

public class AssertExpression {

	public static void usingAssertExpression() throws RuntimeException {
		Integer empty = null;
		
		requireNotEqual(empty != null, "Empty must be not empty!");
	}
	
	private static void requireNotEqual(boolean result, String msg) {
		if (!result) {
			throw new RuntimeException(msg);
		}
	}
	
	public static void main(String[] args) {
		usingAssertExpression();
	}
}
