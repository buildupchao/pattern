package com.pattern.tutor.syntax.test.exception;

import org.junit.Test;

/**
 * @author buildupchao
 * @date 2019/09/19 17:31
 * @since JDK 1.8
 */
public class ExceptionTest {

	@Test
	public void testFinishExceptionally() throws Exception {
		
		try {
			int i = 1 / 0;
		} catch (ArithmeticException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("execute after exception");
		System.out.println("DONE");
	}
}
