package com.pattern.offer.alibaba.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {
	private ReentrantLock lock = new ReentrantLock();
	private Condition pollA = lock.newCondition();
	private Condition pollB = lock.newCondition();
	private Condition pollC = lock.newCondition();
	private volatile boolean isPollA = true;
	private volatile boolean isPollB = false;
	private volatile boolean isPollC = false;

	void print() {
		Thread a = new Thread(() -> {
			while (true) {
				try {
					lock.lock();
					while (!isPollA) {
						pollA.await();
					}
					printA();
					isPollA = false;
					isPollB = true;
					pollB.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		Thread b = new Thread(() -> {
			while (true) {
				try {
					lock.lock();
					while (!isPollB) {
						pollB.await();
					}
					printB();
					isPollB = false;
					isPollC = true;
					pollC.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		Thread c = new Thread(() -> {
			while (true) {
				try {
					lock.lock();
					while (!isPollC) {
						pollC.await();
					}
					printC();
					isPollC = false;
					isPollA = true;
					pollA.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		a.start();
		b.start();
		c.start();
	}

	void printA() {
		for (int i = 0; i < 5; i++) {
			System.out.println("AAAAAAAAAA");
		}
	}

	void printB() {
		for (int i = 0; i < 5; i++) {
			System.out.println("BBBBBBBBBB");
		}
	}

	void printC() {
		for (int i = 0; i < 5; i++) {
			System.out.println("CCCCCCCCCC");
		}
	}
}
