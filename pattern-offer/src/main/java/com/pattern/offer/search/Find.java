package com.pattern.offer.search;

public class Find {

	public static boolean find(int[][] array, int num) {
		assert array != null;
		
		int row = array.length - 1;
		int col = 0;
		
		
		
		return false;
	}
	
	public static void main(String args[]) {
		int[][] testarray = {
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}
		};
		System.out.println(find(testarray, 10));
	}

}
