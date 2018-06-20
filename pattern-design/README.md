### JDK中的设计模式

#### 1.什么是设计模式

- 反复出现的问题

- 增强软件的灵活性

- 适应软件不断变化

#### 2.学习JDK中设计模式的好处

- 借鉴优秀代码的设计，有助于提高代码设计能力

- JDK的设计中体现了大多数设计模式，是学习设计模式的较好的方式

- 可以更加深入的了解JDK

#### 3.类间关系 

继承，委托，依赖，聚合，组合

#### 4.介绍方式

- 作用：归纳某设计模式的基本要点

- JDK中体现：某设计模式在JDK中是怎样体现出来的

- 类图：某设计模式在JDK中所对应的类图

#### 5.经典设计模式在JDK中的体现

> Note: 26 examples for JDK source.

##### 5.1 Singleton(单例)
作用：保证类只有一个实例；提供一个全局访问点<br/>
JDK中体现：<br/>
Runtime, NumberFormat<br/>

##### 5.2 Factory(静态工厂)
作用：代替构造方法创建对象；方法名比构造函数清晰<br/>
JDK中体现：<br/>
Integer.valueOf, Class.forName<br/>

##### 5.3 Factory Method(工厂方法)
作用：子类决定哪一个类实例化<br/>
JDK中体现：<br/>
Collector.iterator方法<br/>

##### 5.4 Abstract Factory(抽象方法)
作用：创建某一种类的对象<br/>
JDK中体现：<br/>
java.sql包, UIManager（Swing外观）<br/>

##### 5.5 Builder(构造者)
作用：将构造逻辑提到单独的类中；分离类的构造逻辑和表现<br/>
JDK中体现：DocumentBuilder(org.w3c.dom)<br/>

##### 5.6 Prototype(原型)
作用：复制对象；浅复制、深复制<br/>
JDK中体现：Object.clone, Cloneable<br/>

##### 5.7 Adapter(适配器)
作用：使不兼容的接口相容<br/>
JDK中体现：java.io.InputStreamReader(InputStream), java.io.OutputStreamWriter(OutputStream)<br/>

##### 5.8 Brideg(桥接)
作用：将抽象部分与其实现部分分离，使它们都可以独立地变化<br/>
JDK中体现：java.util.logging中的Handler和Formatter<br/>

##### 5.9 Composite(组合)
作用：一致地对待组合对象和独立对象<br/>
JDK中体现：org.w3c.dom, javax.swing.JComponent#add(Component)<br/>

##### 5.10 Decorator(装饰器)
作用：为类添加新的功能；放置类继承带来的爆炸式增长<br/>
JDK中体现：java.io包, java.util.Collections#synchronizedList(List)<br/>

##### 5.11 Facade(外观)
作用：封装一组交互类，一致对外提供接口；封装子系统，简化子系统调用<br/>
JDK中体现：java.util.logging包<br/>

##### 5.12 FlyWeight(享元)
作用：共享对象，节省内存<br/>
JDK中体现：Integer.valueOf(int i), Character.valueOf(char c), String常量池<br/>

##### 5.13 Proxy(代理)
作用：透明调用被代理对象，无需知道复杂实现细节；增加被代理类的功能<br/>
JDK中体现：动态代理；RMI<br/>

##### 5.14 Iterator(迭代器)
作用：将集合的迭代和集合本身分离<br/>
JDK中体现：Iterator, Enumeration接口<br/>

##### 5.15 Observer(观察者)
作用：通知对象状态改变<br/>
JDK中体现：(1) java.util.Observer, Observable; (2) Swing中的Listener<br/>

##### 5.16 Mediator(协调者)
作用：用于协调多个类的操作<br/>
JDK中体现：Swing的ButtonGroup<br/>

##### 5.17 Template method(模版方法)
作用：定义算法的结构，子类只实现不同的部分<br/>
JDK中体现：ThreadPoolExecutor.Worker<br/>

##### 5.18 Strategy(策略)
作用：提供不同的算法<br/>
JDK中的体现：ThreadPoolExecutor中的四种拒绝策略<br/>

##### 5.19 Chain of Responsibility(责任链)
作用：请求会被责任链上的对象处理，但是客户端不知道请求会被哪些对象处理<br/>
JDK中体现：(1) java.util.logging.Logger会将log委托给parent logger (2) ClassLoader的委托模型

##### 5.20 Command(命令)
作用：封装操作，是接口一致；将调用者和接收者在空间和时间上解耦合<br/>
JDK中体现：Runnable, Callable, ThreadPoolExecutor<br/>

##### 5.21 Null Object(空对象)
作用：不需要每次判空，对待空值，如何对待一个相同接口的对象<br/>
JDK中体现：Collection.EMPTY_LIST<br/>

##### 5.22 State(状态)
作用：将主对象和其状态分离，状态对象负责主对象的状态转换，使主对象类功能减弱<br/>
JDK中体现：未发现<br/>

##### 5.23 Visitor(访问者)
作用：异构的类间添加聚合操作；搜集聚合数据<br/>
JDK中体现：未发现<br/>

##### 5.24 Interpreter(解释器)
作用：用一组类代表某一规则<br/>
JDK中体现：java.util.regex.Pattern<br/>

##### 5.25 Memento(备忘录)
作用：保持对象状态，需要时可恢复<br/>
JDK中体现：未发现<br/>

#### Reference Resource Link

- Design Pattern(GOF)

- Software Architecture Design Patterns in Java

- JDK 5 Codumentation

- [http://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns](http://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns)

- [http://java.csdn.net/a/20101129/282644.html](http://java.csdn.net/a/20101129/282644.html)

- [JDK中设计模式](https://www.cnblogs.com/zhousysu/p/5483862.html)
