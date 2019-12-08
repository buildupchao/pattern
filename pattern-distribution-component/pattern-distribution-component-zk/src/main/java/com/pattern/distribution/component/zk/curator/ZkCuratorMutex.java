package com.pattern.distribution.component.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author buildupchao
 * @date 2019/12/07 23:46
 * @since JDK 1.8
 */
public class ZkCuratorMutex {

    static final String CONNECT_ADDRESS = "127.0.0.1:2181";

    static final int SESSION_TIMEOUT = 5000;

    static int count = 10;

    public static void generateNo() {
        count--;
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {
        // 1.重试策略：初试时间为1秒，重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);

        // 2.通过工厂创建连接
        CuratorFramework factory = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDRESS)
                .sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(retryPolicy)
                .build();

        // 3.开启连接
        factory.start();

        // 4.分布式锁
        final InterProcessMutex lock = new InterProcessMutex(factory, "/super");
        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    latch.await();

                    // 加锁
                    lock.acquire();

                    generateNo();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss|SSS");
                    System.out.println(simpleDateFormat.format(new Date()));

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "t" + i).start();
        }

        Thread.sleep(100);
        latch.countDown();
    }
}
