Spring的两种代理JDK和CGLIB<br/>
<br/>
- Java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
<br/>
- CGLIB动态代理是利用asm开源包，把代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
	- 如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP
	- 如果目标对象实现了接口，可以强制使用CGLIB实现AOP
	- 如果目标对象没有实现接口，必须采用CGLIB库，Spring会自动在JDK动态代理和CGLIB之间转换
	
```
如何强制使用CGLIB实现AOP？

（1）添加CGLIB库，SPRING_HOME/cglib/*.jar
（2）在Spring配置文件中加入<aop:aspectj-autoproxy proxy-target-class="true">

JDK动态代理和CGLIB字节码生成的区别？

（1）JDK动态代理只能对实现了接口的类生成代理，而不能针对类。
（2）CGLIB是针对类实现代理，主要是对指定的类生成一个[子类]，覆盖其中的方法。因为是继承，所以该类或方法最好不要生命成final。
```
<br/>
JDK代理是不需要依赖第三方库，只要JDK环境就可以进行代理，它有几个要求：

- 实现 InvocationHandler

- 使用Proxy.newProxyInstance产生代理对象

- 被代理的对象必须要实现接口

<br/>
CGLIB必须要依赖于CGLIB的类库，但是它需要类来实现任何接口代理的是指定的类的一个子类，覆盖其中的方法，是一种继承但是针对接口编程的环境下推荐使用JDK代理。<br/>
<br/>
在Hibernate中的拦截器其实现考虑到不需要其他接口的条件，Hibernate中的相关代理采用的是CGLIB来执行。