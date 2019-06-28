# pattern
deep design pattern

pattern刚开始只是一个作为设计模式总结汇总的项目，而后进行拆分且分包分模块行程当前模式。<br/>
模块如下：

- pattern-coding-thinking
- pattern-collector-java
- pattern-common
- pattern-design
- pattern-distribution
- pattern-offer
- pattern-tutor
	- pattern-tutor-jvm
	- pattern-tutor-mysql
	- pattern-tutor-netty
	- pattern-tutor-springmvc
	- pattern-tutor-syntax
<br/>

[设计模式](#深入设计模式) | [Spring MVC源码分析](#看透spring-mvc源代码分析与实践) | [Java](#java) | [分布式](#分布式)  |  [编程思想](#编程思想)  | [JVM](#jvm) | [数据库](#数据库)  
-----|---------------|------|-----|------|----|-----

- ### [深入设计模式](https://github.com/buildupchao/pattern/tree/master/pattern-design/src/main/java/com/pattern/designpattern)
	- OO设计原则
	-  工厂模式
	-  装饰器模式
	-  适配器模式
	-  代理模式
	-  责任链模式
	-  状态模式（状态 & 状态机）
	-  策略模式
	-  模板方法模式
	-  事件总线
	-  命令模式
	-  观察者模式
	- 单例模式（5种实现方式）
	- 原型模式

- ### [JVM](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-jvm)

- ### 数据库

- ### 看透Spring MVC源代码分析与实践
	- chapter 4 [Java中Socket的用法](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-springmvc/src/main/java/com/pattern/tutor/deepinspringmvc/socket)
	- chapter 5 [自己动手实现HTTP协议](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-springmvc/src/main/java/com/pattern/tutor/deepinspringmvc/http)
	- chapter 6 [详解Servlet](https://blog.csdn.net/qq_17776287/article/details/78118769)
	- [Bean 装载流程](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-springmvc/src/main/java/com/pattern/tutor/deepinspringmvc/simple)
	- [v5](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-springmvc/src/main/java/com/pattern/tutor/deepinspringmvc/v5)
		- AOP
		- Bean加载流程
		- Cache
		- ApplicationListener, 事件监听机制
		- FactoryBean
		- IOC & DI
		- Proxy, JDK动态代理 & Cglib动态代理
		- Webflux, 响应式编程
	- [sparrow: 一个轻量级Spring MVC实现项目](https://github.com/buildupchao/sparrow)
		
- ### Java
	- [Java 8 in Action](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-syntax/src/main/java/com/pattern/tutor/syntax/action/newfeature/java8)
	- [Java Classical Syntax](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-syntax/src/main/java/com/pattern/tutor/syntax)
		- [自己实现一个HashMap](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-syntax/src/main/java/com/pattern/tutor/syntax/collection/custom/map)
		- [Cache](https://github.com/buildupchao/pattern/tree/master/pattern-tutor/pattern-tutor-syntax/src/main/java/com/pattern/tutor/syntax/cache)
	- [A collector of Java basic knowledge used for my bro](https://github.com/buildupchao/pattern/tree/master/pattern-collector-java)
	
- ### 编程思想
	- [编程建议项](https://github.com/buildupchao/pattern/tree/master/pattern-coding-thinking/src/main/java/com/pattern/codingthinking/adviceoof)

- ### 分布式
	- [分布式服务框架](https://github.com/buildupchao/pattern/tree/master/pattern-distribution)
	- [zns：设计一个分布式RPC框架](https://github.com/buildupchao/zns)