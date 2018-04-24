package com.jangz.offer.constru;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CPU {
	static int num = Runtime.getRuntime().availableProcessors();
	static CyclicBarrier k = new CyclicBarrier(num);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < num; i++) {
			new Thread(new Run()).start();
		}
	}

	static class Run implements Runnable {

		public void run() {
			int busyTime = 10;
			int idleTime = busyTime;
			try {
				k.await();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (BrokenBarrierException e1) {
				e1.printStackTrace();
			}
			while (true) {
				long startTime = System.currentTimeMillis();
				while ((System.currentTimeMillis() - startTime) <= busyTime)
					;
				try {
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}