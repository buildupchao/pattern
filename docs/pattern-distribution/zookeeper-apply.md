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

zoo.cfg配置文件参数：
- tickTime

基本事件单元，以毫秒为单位。这个时间是作为ZK服务器之间或客户端与服务器之间维持心跳的时间间隔。

- dataDir

存储内存中数据库快照的位置，顾名思义即使ZK保存数据的目录，默认情况下，ZK将些数据的日志文件也保存在这个目录里。

- clientPort

这个端口就是客户端连接ZK服务器的端口，ZK会监听这个端口，接受客户端的访问请求。

- initLimit

这个配置项是用来配置ZK接受客户端初始化连接时最长能忍受多少个心跳时间间隔数。当已经超过10个心跳的时间（也就是tickTime)长度后，ZK服务器还没有接收到客户端的返回信息，那么表示这个客户端连接失败。总的时间长度就是10*2000=20秒

- syncLimit

这个配置项表示Leader与Follower之间发送消息，请求和应答时间长度，最长不能超过多少个tickTime的时间长度，总的时间长度就是5*2000=10秒

server.A = B:C:D
```
A表示这个是第几号服务器，
B是这个服务器的地址
C表示的是这个服务器与集群中的Leader，服务器交换信息的端口
D表示的万一集群中的Leader服务器挂了，需要一个端口来重新进行选举，选出一个新的Leader
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