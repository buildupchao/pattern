package com.pattern.distribution.component.zk.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * @author buildupchao
 * @date 2019/12/07 23:17
 * @since JDK 1.8
 */
public class ZkClientBase {

    /**
     * zookeeper address
     */
    static final String CONNECT_ADDR = "127.0.0.1:2181";

    /**
     * session timeout (millis)
     */
    static final int SESSION_OUTTIME = 5000;

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient(new ZkConnection(CONNECT_ADDR), 5000);

        zkClient.createEphemeral("/temp");
        zkClient.createPersistent("/super/c1", true);
        zkClient.writeData("/super/c1", "test_data");
        String data = zkClient.readData("/super/c1");
        System.out.println(data);
        Thread.sleep(10000);

        zkClient.delete("/temp");
        zkClient.deleteRecursive("/super");
    }
}
