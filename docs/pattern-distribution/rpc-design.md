# 设计并实现一个RPC框架

## **前言**

提前先祝大家春节快乐！好了，先简单聊聊。

我从事的是大数据开发相关的工作，主要负责的是大数据计算这块的内容。最近Hive集群跑任务总是会出现Thrift连接HS2相关问题，研究了解了下内部原理，突然来了兴趣，就想着自己也实现一个RPC框架，这样可以让自己在设计与实现RPC框架过程中，也能从中了解和解决一些问题，进而让自己能够更好的发展（哈哈，会不会说我有些剑走偏锋？不去解决问题，居然研究RPC。别急，这类问题已经解决了，后续我也会发文章详述的）。

## **1 RPC流水线工程？**

![RPC框架原理图](https://github.com/buildupchao/ImgStore/blob/master/blog/RPC%E5%8E%9F%E7%90%86.png?raw=true)

原理图上我已经标出来流程序号，我们来走一遍：
- ① Client以本地调用的方式调用服务
- ② Client Stub接收到调用后，把服务调用相关信息组装成需要网络传输的消息体，并找到服务地址（host:port），对消息进行`编码`后交给Connector进行发送
- ③ Connector通过网络通道发送消息给Acceptor
- ④ Acceptor接收到消息后交给Server Stub
- ⑤ Server Stub对消息进行`解码`，并根据解码的结果通过`反射`调用本地服务
- ⑥ Server执行本地服务并返回结果给Server Stub
- ⑦ Server Stub对返回结果组装打包并`编码`后交给Acceptor进行发送
- ⑧ Acceptor通过网络通道发送消息给Connector
- ⑨ Connector接收到消息后交给Client Stub，Client Stub接收到消息并进行`解码`后转交给Client
- ⑩ Client获取到服务调用的最终结果

由此可见，主要需要RPC负责的是2~9这些步骤，也就是说，RPC主要职责就是把这些步骤封装起来，对用户透明，让用户像调用本地服务一样去使用。

## **2 为RPC做个技术选型**

- 序列化/反序列化

  首先排除Java的ObjectInputStream和ObjectOutputStream，因为不仅需要保证需要序列化或反序列化的类实现`Serializable`接口，还要保证JDK版本一致，公司应用So Many，使用的语言也众多，这显然是不可行的，考虑再三，决定采用Objesess。


- 通信技术

  同样我们首先排除Java的原生IO，因为进行消息读取的时候需要进行大量控制，如此晦涩难用，正好近段时间也一直在接触Netty相关技术，就不再纠结，直接命中Netty。


- 高并发技术

  远程调用技术一定会是多线程的，只有这样才能满足多个并发的处理请求。这个可以采用JDK提供的Executor。


- 服务注册与发现

  Zookeeper。当Server启动后，自动注册服务信息（包括host,port,还有nettyPort）到ZK中；当Client启动后，自动订阅获取需要远程调用的服务信息列表到本地缓存中。


- 负载均衡

  分布式系统都离不开负载均衡算法，好的负载均衡算法可以充分利用好不同服务器的计算资源，提高系统的并发量和运算能力。


- 非侵入式

  借助于Spring框架

RPC架构图如下：
![zns架构图](https://github.com/buildupchao/ImgStore/blob/master/blog/zns.png?raw=true)

## **3 让RPC梦想成真**

由架构图，我们知道RPC是C/S结构的。

### **3.1 先来一个单机版**

单机版的话比较简单，不需要考虑负载均衡（也就没有zookeeper)，会简单很多，但是只能用于本地测试使用。而RPC整体的思想是：为客户端创建服务代理类，然后构建客户端和服务端的通信通道以便于传输数据，服务端的话，就需要在接收到数据后，通过反射机制调用本地服务获取结果，继续通过通信通道返回给客户端，直到客户端获取到数据，这就是一次完整的RPC调用。

#### **3.1.1 创建服务代理**

可以采用JDK原生的Proxy.newProxyInstance和InvocationHandler创建一个代理类。详细细节网上博客众多，就不展开介绍了。当然，也可以采用CGLIB字节码技术实现。

![create-proxy](https://github.com/buildupchao/ImgStore/blob/master/blog/create-proxy.png?raw=true)

#### **3.1.2 构建通信通道 & 消息的发送与接收**

客户端通过Socket和服务端建立通信通道，保持连接。可以通过构建好的Socket获取`ObjectInputStream`和`ObjectOutputStream`。但是有一点需要注意，如果Client端先获取`ObjectOutputStream`，那么服务端只能先获取`ObjectInputStream`，不然就会出现死锁一直无法通信的。

#### **3.1.3 反射调用本地服务**

服务端根据请求各项信息，获取Method，在Service实例上反向调用该方法。

![reflection-invoke](https://github.com/buildupchao/ImgStore/blob/master/blog/reflection-invoke.png?raw=true)

### **3.2 再来一个分布式版本**

我们先从顶层架构来进行设计实现，也就是技术选型后的RPC架构图。主要涉及了借助于，Zookeeper实现的服务注册于发现。

#### **3.2.1 服务注册与发现**

当Server端启动后，自动将当前Server所提供的所有带有`@ZnsService`注解的Service Impl注册到Zookeeper中，在Zookeeper中存储数据结构为 ip:httpPort:acceptorPort

![service-provider](https://github.com/buildupchao/ImgStore/blob/master/blog/service-provider.png?raw=true)

![push-service-manager](https://github.com/buildupchao/ImgStore/blob/master/blog/push-service-manager.png?raw=true)

当Client端启动后，根据扫描到的带有`@ZnsClient`注解的Service Interface从Zookeeper中拉去Service提供者信息并缓存到本地，同时在Zookeeper上添加这些服务的监听事件，一旦有节点发生变动（上线/下线），就会立即更新本地缓存。

![pull-service-manager](https://github.com/buildupchao/ImgStore/blob/master/blog/pull-service-manager.png?raw=true)

#### **3.2.2 服务调用的负载均衡**

Client拉取到服务信息列表后，每个Service服务都对应一个地址list，所以针对连哪个server去调用服务，就需要设计一个负载均衡路由算法。当然，负载均衡算法的好坏，会关系到服务器计算资源、并发量和运算能力。不过，目前开发的`RPC`框架`zns`中只内置了`Random`算法，后续会继续补充完善。

![load-balance-strategy](https://github.com/buildupchao/ImgStore/blob/master/blog/load-balance-strategy.png?raw=true)

#### **3.2.3 网络通道**

- Acceptor

当Server端启动后，将同时启动一个`Acceptor`长连接线程，用于接收外部服务调用请求。内部包含了编解码以及反射调用本地服务机制。

![Acceptor](https://github.com/buildupchao/ImgStore/blob/master/blog/acceptor.png?raw=true)

![Acceptor-work](https://github.com/buildupchao/ImgStore/blob/master/blog/acceptor-work.png?raw=true)

- Connector

当Client端发起一个远程服务调用时，`ZnsRequestManager`将会启动一个`Connector`与`Acceptor`进行连接，同时会保存通道信息`ChannelHolder`到内部，直到请求完成，再进行通道信息销毁。

![Connector](https://github.com/buildupchao/ImgStore/blob/master/blog/connector.png?raw=true)

![Connector-work](https://github.com/buildupchao/ImgStore/blob/master/blog/connector-work.png?raw=true)

#### **3.2.4 请求池管理**

为了保证一定的请求并发，所以对服务调用请求进行了池化管理，这样可以等到消息返回再进行处理，不需要阻塞等待。

![request-pool](https://github.com/buildupchao/ImgStore/blob/master/blog/request-pool.png?raw=true)

#### **3.2.5 响应结果异步回调**

当Client端接收到远程服务调用返回的结果时，直接通知请求池进行处理，No care anything!

![async-callback](https://github.com/buildupchao/ImgStore/blob/master/blog/async-callback.png?raw=true)

## **4. 总结**

本次纯属是在解决Thrift连接HS2问题时，突然来了兴趣，就构思了几天RPC大概架构设计情况，便开始每天晚上疯狂敲代码实现。我把这个RPC框架命名为`zns`，现在已经完成了`1.0-SNAPSHOT`版本，可以正常使用了。在开发过程中，也遇到了一些平时忽略的小问题，还有些是工作工程中没有遇到或者遗漏的地方。因为是初期，所以会存在一些bug，如果你感兴趣的话，欢迎提PR和ISSUE，当然也欢迎把代码clone到本地研究学习。虽然就目前来看，想要做成一个真正稳定可投产使用的RPC框架还有短距离，但是我会坚持继续下去，毕竟RPC真的涉及到了很多点，只有真正开始做了，才能切身体会和感受到。Ya hoh!终于成功实现了v1.0，嘿嘿……

## **源码地址**

- [zns源码地址](https://github.com/buildupchao/zns)
- zns源码简单介绍：

  `zns`由`zns-api`, `zns-common`, `zns-client`, `zns-server`四个核心模块组成。`zns-service-api`, `zns-service-consumer`, `zns-service-provider`三个模块是对`zns`进行测试使用的案例。
