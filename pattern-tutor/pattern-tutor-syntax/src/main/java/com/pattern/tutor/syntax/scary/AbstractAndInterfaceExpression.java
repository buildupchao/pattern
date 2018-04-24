package com.pattern.tutor.syntax.scary;

public abstract class AbstractAndInterfaceExpression {
	
}

interface InterfaceExpression {

	default void run() {
		System.out.println("This method is not abstract or final.");
	}
}