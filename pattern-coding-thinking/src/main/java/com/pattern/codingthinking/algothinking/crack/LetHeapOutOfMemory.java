package com.pattern.codingthinking.algothinking.crack;

import java.util.ArrayList;
import java.util.List;

/**
 * Test heap OutOfMemoryError issue
 * JVM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp
 * @author buildupchao
 *         Date: 2019/01/30 15:45
 * @since JDK 1.8
 */
public class LetHeapOutOfMemory {
	
	public static void main(String[] args) {
		LetHeapOutOfMemory let = new LetHeapOutOfMemory();
		let.testHeap();
	}
	
	public void testHeap() {
		List<String> list = new ArrayList<>(10);
		while (true) {
			list.add("1");
		}
	}
}
