### pattern-tutor-netty

大型互联网分布式高并发通信技能 Netty

1. Netty是什么？
    
    NIO框架：非阻塞式(算不上异步，因为NIO框架并不完善，没有回调机制)
    
    Netty是一个高性能，异步事件驱动的NIO模型的通信框架

    异步事件驱动：回调机制 + 处理事情
    
    JDK提供的 Future 异步调用结果对象 => 承接未来的某个执行任务的结果的状态，可以提供对外查询

    并不提供主动推送，而且通知机制
    
    Netty扩展
    
    ChannelFuture + Listener监听机制
    
    Listener: 分工明细的去监听某个自己关注的事件
    
    放心设计异步方式

2. Netty设计组成部分以及如何运行工作？

    Channel
    
    三层架构设计：
        
    第一层：协议通信层（byte => NettyBean）
    
    第二层：职责链层（Reactor调度层）注册 Channel 事件处理形成职责链的模型
    
    第三层：纯业务处理层
        
        业务和协议通信解耦

3. Netty关键点的精髓

4. 将有一个代码案例来说明Netty的高明之处？