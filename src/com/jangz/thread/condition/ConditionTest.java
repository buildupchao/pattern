package com.jangz.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
	
	public static void main(String[] args) {
		final ReentrantLock reentrantLock = new ReentrantLock();
		final Condition condition = reentrantLock.newCondition();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName() + "拿到锁");
				System.out.println(Thread.currentThread().getName() + "等待信号");
				
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "拿到信号");
				reentrantLock.unlock();
			}
		}, "线程1").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName() + "拿到锁");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "发出信号");
				condition.signalAll();
				reentrantLock.unlock();
			}
		}, "线程2").start();
	}
	
}
