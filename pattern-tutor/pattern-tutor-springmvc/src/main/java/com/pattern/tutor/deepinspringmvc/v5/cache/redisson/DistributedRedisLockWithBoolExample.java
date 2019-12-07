package com.pattern.tutor.deepinspringmvc.v5.cache.redisson;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;

/**
 * @author buildupchao
 * @date 2019/08/21 10:36
 * @since JDK 1.8
 */
public class DistributedRedisLockWithBoolExample {
	
	private static CountDownLatch finish = new CountDownLatch(2);
	private static final String KEY = "testlock";
	private static Config config;
	private static Redisson redisson;
	
	static {
		config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		redisson = (Redisson) Redisson.create(config);
	}
	
	public static void main(String[] args) {
		Thread thread1 = new LockWithBoolean("thread-1", finish);
		Thread thread2 = new LockWithBoolean("thread-2", finish);
		thread1.start();
		try {
			// 睡眠10秒钟，为了让thread1充分运行
			TimeUnit.SECONDS.sleep(10);
			
			thread2.start();
			
			// 让thread2等待锁 
			TimeUnit.SECONDS.sleep(10);
			
			// 中断正在等待锁的thread2，观察thread2会不会拿到锁
			thread2.interrupt();
			
			finish.await();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		} finally {
			redisson.shutdown();
		}
		System.out.println("ALL DONE");
	}
	
	static class LockWithBoolean extends Thread {
		
		private String name;
		private CountDownLatch latch;
		
		public LockWithBoolean(String name, CountDownLatch latch) {
			super();
			this.name = name;
			this.latch = latch;
		}

		/* 
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				RLock lock = redisson.getLock(KEY);
				lock.lock(2, TimeUnit.MINUTES);
				if (!Thread.currentThread().isInterrupted()) {
					System.out.printf("%s[id=%d] gets lock.\n", name, Thread.currentThread().getId());
					try {
						TimeUnit.MINUTES.sleep(1);
						for (int i = 0; i < 3; i++) {
							System.out.printf("%s[id=%d] is going to do homework %d time(s) after dinner.\n", name, Thread.currentThread().getId(),  i + 1);
						}
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.printf("%s[id=%d] does not get lock.\n", name, Thread.currentThread().getId());
				}
				System.out.printf("%s[id=%d] ends.\n", name, Thread.currentThread().getId());
			} finally {
				latch.countDown();
			}
		}
	}
}
