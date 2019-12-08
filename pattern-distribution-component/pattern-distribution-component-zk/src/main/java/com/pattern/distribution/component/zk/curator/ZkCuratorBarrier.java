package com.pattern.distribution.component.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author buildupchao
 * @date 2019/12/07 23:55
 * @since JDK 1.8
 */
public class ZkCuratorBarrier {

    static final String CONNECT_ADDRESS = "127.0.0.1:2181";

    static final int SESSION_TIMEOUT = 5000;

    static DistributedBarrier barrier = null;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                try {
                    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
                    CuratorFramework factory = CuratorFrameworkFactory.builder()
                            .connectString(CONNECT_ADDRESS)
                            .sessionTimeoutMs(SESSION_TIMEOUT)
                            .retryPolicy(retryPolicy)
                            .build();
                    factory.start();

                    barrier = new DistributedBarrier(factory, "/super");
                    System.out.println(Thread.currentThread().getName() + "设置barrier!");

                    barrier.setBarrier(); // 设置
                    barrier.waitOnBarrier(); // 等待

                    System.out.println("--------开始执行程序-------");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }, "t" + i).start();
        }

        Thread.sleep(5000);
        barrier.removeBarrier(); // 释放，如果不释放barrier，则线程会一直等待
    }
}
