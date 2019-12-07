package com.pattern.distribution.component.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author buildupchao
 * @date 2019/12/07 23:46
 * @since JDK 1.8
 */
public class ZkCuratorAtomicInteger {

    static final String CONNECT_ADDRESS = "127.0.0.1:2181";

    static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        CuratorFramework factory = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDRESS)
                .sessionTimeoutMs(SESSION_TIMEOUT)
                .retryPolicy(retryPolicy)
                .build();
        factory.start();

        DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(factory, "/super", new RetryNTimes(3, 1000));

        AtomicValue<Integer> value = atomicInteger.add(1);
        System.out.println(value.succeeded());
        // 最新值
        System.out.println(value.postValue());
        // 原始值
        System.out.println(value.preValue());

        factory.close();
    }
}
