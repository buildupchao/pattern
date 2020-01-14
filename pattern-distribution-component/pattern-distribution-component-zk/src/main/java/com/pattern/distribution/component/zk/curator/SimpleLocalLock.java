package com.pattern.distribution.component.zk.curator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buildupchao
 * @date 2019/12/07 23:41
 * @since JDK 1.8
 */
public class SimpleLocalLock {

    static ReentrantLock lock = new ReentrantLock();
    static int count = 10;

    public static void generateNo() {
        lock.lock();

        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    generateNo();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss|SSS");
                    System.out.println(simpleDateFormat.format(new Date()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }, "t" + i).start();
        }
        Thread.sleep(50);
        latch.countDown();
    }
}
