# 设计并实现一个RPC框架

## **前言**

提前先祝大家春节快乐！好了，先简单聊聊。

我从事的是大数据开发相关的工作，主要负责的是大数据计算这块的内容。最近Hive集群跑任务总是会出现Thrift连接HS2相关问题，研究了解了下内部原理，突然来了兴趣，就想着自己也实现一个RPC框架，这样可以让自己在设计与实现RPC框架过程中，也能从中了解和解决一些问题，进而让自己能够更好的发展（哈哈，会不会说我有些剑走偏锋？不去解决问题，居然研究RPC。别急，这类问题已经解决了，后续我也会发文章详述的）。

## **RPC原理介绍**

![RPC框架原理图](https://github.com/buildupchao/ImgStore/blob/master/blog/RPC%E5%8E%9F%E7%90%86.png?raw=true)

原理图上我已经标出来流程序号，我们来走一遍：
- 1.Client以本地调用的方式调用服务
- 2.Client Stub接收到调用后，把服务调用相关信息组装成需要网络传输的消息体，并找到服务地址（host:port），对消息进行`编码`后交给Connector进行发送
- 3.Connector通过网络通道发送消息给Acceptor
- 4.Acceptor接收到消息后交给Server Stub
- 5.Server Stub对消息进行`解码`，并根据解码的结果通过`反射`调用本地服务
- 6.Server执行本地服务并返回结果给Server Stub
- 7.Server Stub对返回结果组装打包并`编码`后交给Acceptor进行发送
- 8.Acceptor通过网络通道发送消息给Connector
- 9.Connector接收到消息后交给Client Stub，Client Stub接收到消息并进行`解码`后转交给Client
- 10.Client获取到服务调用的最终结果

由此可见，主要需要RPC负责的是2~9这些步骤，也就是说，RPC主要职责就是把这些步骤封装起来，对用户透明，让用户像调用本地服务一样去使用。

## **技术选型**

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
