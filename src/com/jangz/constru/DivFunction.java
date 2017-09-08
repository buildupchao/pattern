package com.jangz.constru;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DivFunction {
	
	private static final Logger log = Logger.getLogger("DivFunction");
	
	void DivArray(int[] pArray, int size) {
		if (pArray[0] == 0) {
			throw new ArithmeticException("Denominator can not be zero.");
		}
		
		for (int i = size - 1; i >= 0; i--) {
			pArray[i] /= pArray[0];
		}
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] pArray = new int[6];
		for (int i = 0; i < pArray.length; i++) {
			pArray[i] = r.nextInt(10);
		}
		int size = pArray.length;
		
		assert pArray == null;
		assert size != pArray.length;
		
		new DivFunction().DivArray(pArray, size);
		
		for (int i = 0; i < size; i++) {
			log.log(Level.INFO, "Element " + i + " is: " + pArray[i]);
		}
	}
}
