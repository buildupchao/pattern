分布式存储系统
分布式计算系统
分布式管理系统

__________

分布式架构原理:
1#, 分布式架构演进过程
2#, 如何把应用从单机扩展到分布式
3#, CDN加速静态文件访问
4#, 系统监控，容灾，存储动态扩容
5#, 架构设计及业务驱动分化
6#, CAP，Base理论及其应用

分布式架构策略
分布式架构中间件:
Redis主从复制原理及无磁盘复制分析
图解Redis中AOF和RDB持久化策略的原理

分布式架构实践:
1#, 分布式全局ID生成方案
2#, Session跨越共享及企业级单点登录解决方案实践
3#, 分布式事务解决方案实践
4#, 高并发下的服务降级，限流实践
5#, 基于分布式架构下分布式锁的解决方案实践
6#, 分布式架构下实现分布式定时调整


———————————

微框架
Spring Cloud
Docker虚拟化
微服务架构


___________


性能优化
|
|/

垃圾收集
虚拟机
底层操作系统设置
(Java Tools for Source Code Optimization and Analysis)

Note: 没有两个应用程序可以使用相同的优化方式，也没有完美的优化Java应用程序的参考路径。
Need to have a right understanding for JVM and under-layer OS.

图解性能优化
（性能基准，性能优化到底是什么，衡量维度）

JVM调优
（知其然，知其所以然；什么是JVM运行时数据区；什么是JVM内存模型 JMM；各垃圾回收器使用场景(Throughput\CMS)；理解GC日志，从日志看端倪；实战MAT分析dump文件）

Tomcat调优
（How it works? 探查Tomcat的运行机制及框架；分析Tomcat县城模型；Tomcat系统参数认识及调优；基准测试）

MySQL调优
（理解MySQL底层B+ Tree机制；SQL执行计划详解；索引优化详解；SQL语句优化）


__________

Maven
Jenkins
Sonar
Git