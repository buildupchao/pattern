package com.pattern.codingthinking.algothinking.crack;

import java.util.ArrayList;

public class LetHeapOutOfMemory {
	
	public static void main(String[] args) {
		LetHeapOutOfMemory let = new LetHeapOutOfMemory();
		let.testHeap();
	}
	
	public void testHeap() {
		int size = 200_000_000;
		while (true) {
			ArrayList<Integer> list = new ArrayList<>(size);
			size = list.size();
		}
	}
}
