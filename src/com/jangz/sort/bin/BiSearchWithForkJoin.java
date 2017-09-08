package com.jangz.sort.bin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class BiSearchWithForkJoin extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3336653511071960347L;
	
	private final int threshold;
	private final BinarySearchProblem problem;
	private int result;
	private final int numberToSearch;
	
	
	
	public BiSearchWithForkJoin(BinarySearchProblem problem, int threshold, int numberToSearch) {
		this.problem = problem;
		this.threshold = threshold;
		this.numberToSearch = numberToSearch;
	}

	@Override
	protected void compute() {
		if (problem.size < threshold) {
			// 小于阀值，就直接用普通的二分查找
			result = problem.searchSequentially(numberToSearch);
		} else {
			// 分解子任务
			int midPoint = problem.size / 2;
			BiSearchWithForkJoin left = new BiSearchWithForkJoin(problem.subProblem(0, midPoint), threshold, numberToSearch);
			BiSearchWithForkJoin right = new BiSearchWithForkJoin(problem.subProblem(midPoint + 1, problem.size - 1), threshold, numberToSearch);
			invokeAll(left, right);
			result = Math.max(left.result, right.result);
		}
	}
	
	// 构造数据
	private static final int[] data = new int[10_000_000];
	static {
		for (int i = 0; i < 10_000_000; i++) {
			data[i] = i;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchProblem problem = new BinarySearchProblem(data, 0, data.length);
		int threshold = 100;
		int nThreads = 10;

		// 查找10_000_000所在的下标
		BiSearchWithForkJoin biSearchWithForkJoin = new BiSearchWithForkJoin(problem, threshold, 100_0000);
		ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
		forkJoinPool.invoke(biSearchWithForkJoin);
		System.out.printf("Result is: %d%n", biSearchWithForkJoin.result);
	}
	
}
