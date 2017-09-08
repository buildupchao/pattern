package com.jangz.sort.quick;

import java.util.concurrent.ForkJoinTask;

import org.junit.Test;

public class TestSortTask {
	
	@Test
	public void testSort() throws Exception {
		long[] array = new long[100];
		
		ForkJoinTask sort = new SortTask(array);
//		ForkJoinPool pool
	}
	
}
