package com.pattern.distribution.component.zk.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import java.util.List;

/**
 * @author buildupchao
 * @date 2019/12/07 23:28
 * @since JDK 1.8
 */
public class ZkClientWatcher {

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

        zkClient.subscribeChildChanges("/super", new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("parentPath: " + parentPath);
                System.out.println("currentChilds: " + currentChilds);
            }
        });

        zkClient.subscribeDataChanges("/super", new IZkDataListener() {
            @Override
            public void handleDataChange(String path, Object data) throws Exception {
                System.out.println("变更的结点： " + path + ", 变更内容为：" + data);
            }

            @Override
            public void handleDataDeleted(String path) throws Exception {
                System.out.println("删除的结点: " + path);

            }
        });

        Thread.sleep(3000);

        zkClient.createPersistent("/super");
        Thread.sleep(1000);
        zkClient.writeData("/super", "buildupchao", -1);

        zkClient.createPersistent("/super/c1", "c1_content");
        Thread.sleep(1000);

        zkClient.createPersistent("/super/c2", "c2_content");
        Thread.sleep(1000);

        zkClient.createPersistent("/super/c3", "c2_content");
        Thread.sleep(1000);
        zkClient.writeData("/super", "zyc", 1);

        zkClient.delete("/super/c2");
        Thread.sleep(1000);

        zkClient.deleteRecursive("/super");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
