package com.pattern.tutor.deepinjvm.load;

public class WaitLoadExample {
	
	static int i = 3;
	
	static {
		System.out.printf("execute static initialization block! i=%d\n", i);
	}
}
