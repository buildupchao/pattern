package com.pattern.distribution.component.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedDoubleBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Random;

/**
 * @author buildupchao
 * @date 2019/12/07 23:55
 * @since JDK 1.8
 */
public class ZkCuratorDoubleBarrier {

    static final String CONNECT_ADDRESS = "127.0.0.1:2181";

    static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) {
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

                    DistributedDoubleBarrier barrier = new DistributedDoubleBarrier(factory, "/super", 5);
                    Thread.sleep(1000 * (new Random().nextInt(3)));
                    System.out.println(Thread.currentThread().getName() + "已经准备");

                    barrier.enter();
                    System.out.println("同时开始运行...");
                    Thread.sleep(1000 * (new Random().nextInt(3)));

                    System.out.println(Thread.currentThread().getName() + "准备完毕");

                    barrier.leave();
                    System.out.println("同时退出运行...");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }, "t" + i).start();
        }
    }
}
