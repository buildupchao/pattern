## ZooKeeper (动物饲养员/管理员)

### **一、ZK简要介绍**

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

### **二、ZK应用场景剖析**

ZooKeeper是一个<strong>高可用的分布式数据管理与系统协调框架。</strong>基于对Paxos算法的实现，使该框架保证了分布式环境中数据的强一致性，也正是基于这样的特性，使得ZK解决很多分布式问题。

值得注意的是，ZK并非天生就是为这些应用场景设计的，都是后来众多开发者根绝其框架的特性，利用其提供的一系列API接口（或者成为原语集），摸索出来的典型使用方法。

#### **1.命名服务（Naming Service)**

命名服务是分布式系统中比较常见的一类场景。在分布式系统中，通过使用命名服务，客户端应用能够根据指定名字来获取资源或服务的地址，提供者等信息。

被命名的实体通常可以是集群中的机器，提供的服务地址，远程对象等 —— 这些我们都可以通常他们为名字（Name）。

其中较为常见的就是一些分布式服务框架中的服务地址列表。通过调用ZK提供的创建结点的API，能够很容易创建一个全局唯一的path，这个path就可以作为一个名称。

e g:

阿里开源的分布式服务框架 ` Dubbo ` 中使用ZK来作为其命名服务，维护全局的服务地址列表。<br/>
Dubbo实现中：<br/>
- 服务提供者

在服务启动时，向ZK上的指定结点 ` /dubbo/${serviceName}/providers `目录下写入自己的URL地址，这个操作就完成了服务的发布。

- 服务消费者

在服务启动时，订阅 ` /dubbo/${serviceName}/providers `目录下的提供者的URL地址，并向 ` /dubbo/${serviceName}/consumers `目录下写入自己的URL地址。

Note:所有向ZK上注册的地址都是临时结点，这样就能够保证服务提供者和消费者能够给自动感应资源的变化。<br/>

另外，Dubbo还有针对服务粒度的监控，方法时订阅 ` /dubbo/${serviceName} `目录下所有提供者和消费者的信息。