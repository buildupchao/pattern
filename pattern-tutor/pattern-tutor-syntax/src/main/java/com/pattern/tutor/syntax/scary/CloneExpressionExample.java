package com.pattern.tutor.syntax.scary;

public class CloneExpressionExample {
	
	public static void main(String[] args) {
		deepClone();
	}
	
	public static void deepClone() {
		CloneExpression clone = new CloneExpression("Spark", 23, 90);
		
		try {
			CloneExpression cloneObj = (CloneExpression) clone.clone();
			System.out.println(cloneObj);
			cloneObj.getHeart().setHeartBeats(100);
			System.out.println(cloneObj);
			System.out.println(clone);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
