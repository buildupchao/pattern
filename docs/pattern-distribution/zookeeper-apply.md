## ZooKeeper (动物饲养员/管理员)

ZooKeeper是一个类似HDFS的树形文件结构，可以用来保证数据在（ZK）集群之间的数据的事务性一致。

ZooKeeper有watch事件，是一次性触发的，当watch监视的数据发生变化时，通知设置了该watch的client，即watcher。

ZooKeeper有三个角色：Learner, Follower, Observer

ZooKeeper应用场景：
- 统一命名服务（Name Service)
- 配置管理（Configuration Management）
- 集群管理（Group Membership）
- 共享锁（Locks）
- 队列管理

ZooKeeper集群搭建注意点（zoo.cfg）：
- data目录
- 服务器配置列表：
```
server.0=master:2888:3888
server.1=slave1:2888:3888
server.2=slave2:2888:3888
```
- myid文件
```
master => 0
slave1 => 1
slave2 => 2
```

ZooKeeper命令：
- 启动：``` zkServer.sh start ```
- 状态：``` zkServer.sh status ```
- 连接客户端: ``` zkCli.sh -h 172.0.0.1 ```
```
ls /
ls /zookeeper
create /test zk
get /test
set /test new_zk
```

Note: 创建结点类型有两种，短暂（ephemeral)，持久（persistent)