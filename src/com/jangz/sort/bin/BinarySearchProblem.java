package com.jangz.sort.bin;

import java.util.Arrays;

public class BinarySearchProblem {
	
	private final int[] numbers;
	
	private final int start;
	
	private final int end;
	
	public final int size;
	
	public BinarySearchProblem(int[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
		this.size = end - start;
	}
	
	public int searchSequentially(int numberToSearch) {
		return Arrays.binarySearch(numbers, start, end, numberToSearch);
	}
	
	public BinarySearchProblem subProblem(int subStart, int subEnd) {
		return new BinarySearchProblem(numbers, start + subStart, start + subEnd);
	}
	
	public int doSearch(int numberToSearch) {
		int result = -1;
		
		int low = start, high = end;
		int middle;
		
		while (low < high) {
			middle = (high - low) / 2;
			
			if (numbers[middle] < numberToSearch) {
				low = middle + 1;
			} else if (numbers[middle] > numberToSearch) {
				high = middle - 1;
			} else {
				result = middle;
			}
		}
		
		return result;
	}
}
