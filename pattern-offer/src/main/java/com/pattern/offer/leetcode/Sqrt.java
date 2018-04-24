package com.pattern.offer.leetcode;

import java.util.logging.Logger;

/**
 * Compute and reture the square root of x.
 * @author jangz
 *
 */
public class Sqrt {
	
	private static final Logger log = Logger.getLogger("Sqrt");
	
	/**
	 * Implement int sqrt(int x)
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
		if (x <= 1) {
			return x;
		}
		
		int left = 1;
		int right = x;
		
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (mid == x/mid) {
				return mid;
			} else if (mid < x/mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) {
		int result = new Sqrt().sqrt(8);
		
		log.info("The sqrt(" + 8 + ") is " + result);
	}
}
