## **分布式事务（JTA）**

### **分布式事务一致性**
CAP理论、BASE

强一致性（ACID）-> 酸性
<br/>
弱一致性（BASE） -> 碱性

> 避免分布式事务

> 弱一致性

最终一致性 -> 消息队列来辅助

最终一致性<br/>

1.最大化重试
2.


支付宝的异步通知，每个订单的异步通知实行分频率发送：<br/>
15s -> 3m 10m 30m 30m 1h 2h 6h 15h<br/>
主动查询

![](https://github.com/buildupchao/ImgStore/blob/master/patterns/state_machine.png?raw=true)

状态机：<br/>
1.实现幂等，通过状态，where status=1<br/>
2.通过状态来驱动数据的变化<br/>
3.业务流程会更加清晰