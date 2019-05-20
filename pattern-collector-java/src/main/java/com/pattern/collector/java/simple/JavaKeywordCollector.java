package com.pattern.collector.java.simple;

import java.util.Random;

/**
 * Java中关键字
 * @author buildupchao
 * @date 2019/05/20 15:00
 * @since JDK 1.8
 */
public class JavaKeywordCollector {
	/*
  	 *	基础数据类型关键字: 
  	 *  boolean :   true or false
  	 *	byte    :   1 byte (1个字节 = 8个bit位)
  	 *	char    :   2 bytes (两个字节)，默认值为 0,
  	 *	short   :   2 bytes，默认值为0
  	 *	int     :   4 bytes，默认值为0
  	 *	long    :   8 bytes，默认值为0
  	 *	float   :   4 bytes，默认值为0
  	 *	double  :   8 bytes，默认值为0
  	 *	String  :   默认值为null
	 */
	boolean condition = true;
	byte one = 1;
	char tag = '\n';
	short shortNumber = Short.MAX_VALUE;
	int number = Integer.MAX_VALUE;
	// 该类型可以选择性带后缀L或者l，首选L以避免和数字1混淆。
	long longNumber = 3L;
	// 该类型必须带后缀F或者f，首选F以避免混淆。
	float money = 200_000_00.00F;
	// 该类型可选择性带后缀D，因为会自动向上转型。
	double price = 19.88D;
	double newPrice = 19.88;
	double castPrice = 19;
	// String为对象类型，默认值为null。
	String ip = null;
	String finalIp = "127.0.0.1";
	
	/* 
	 *	访问权限关键字：
	 * 	public    ： 外部可访问 
	 *	protected ： 相同包下可以访问
	 *	private   ： 同一个类中可以访问
	 *	类声明关键字：
	 *	class
	 */
	public void publicMethod() {}
	public class PublicClass {}
	
	protected void protectedMethod() {}
	protected class ProtectedClass {}
	
	private void privateMethod() {}
	private class PrivateClass {}
	
	/*
	 *	条件分支关键字：
	 *  三目表达式                                           ：        It is true ? A : B; 
	 *	if - else if - else  : 
	 *  switch-case-default  :
	 *	for                  :
	 *	while                :
	 *	do-while             :
	 *	请注意：以下案例中，除if案例，其余如果没有if判断跳出循环则均为死循环，会导致CPU飙升
	 */
	public void serviceForConditionBranchKeyword() {
		boolean flag = new Random().nextBoolean();
		// 三目表达式
		int k = flag ? 1 : 2;
		System.out.println(k);
		
		// if分支语句
		if (flag) {
			System.out.println("flag is " + flag);
		} else if (System.currentTimeMillis() > 0) {
			System.out.println("flag is " + flag + " and now is greater 0.");
		} else {
			System.out.println("flag is " + " and now is less and equal than 0.");
		}
		
		// switch分支语句
		switch ("bro") {
			case "parent": {
				System.out.println("my parent");
				break;
			}
			case "grandfather": {
				System.out.println("grandfather");
				break;
			}
			default: {
				System.out.println("bro");
				break;
			}
		}
		
		// for循环语句
		for (;;) {
			if (System.currentTimeMillis() % 5 == 1) {
				break;
			}
		}
		
		// for循环标准案例：
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				continue;
			}
			System.out.println(i);
		}
		// 增强for循环案例，简称for-each，主要用于遍历数组，集合元素
		for (char ch : "hello world".toCharArray()) {
			System.out.println(ch);
		}
		
		
		while (flag) {
			if (System.currentTimeMillis() % 2 == 0) {
				break;
			}
		}
		
		do {
			if (System.currentTimeMillis() % 3 == 0) {
				break;
			}
		} while(flag);
	}
	
	/*
     *	创建对象关键字：
	 * 	new ： 仅能用于创建非抽象类以及提供了public构造方法的类（private class只能在类内部new，外部不能new，比如系统类System）
	 */
	String str = new String("hello, my bro");
	Random rand = new Random();
	long timestamp = System.currentTimeMillis();
	
	/*
	 *	接口、抽象类（或抽象方法）以及继承相关关键字：
	 * 	interface : 定义接口，接口中方法和变量均为public static final类型，即变量的值是不能修改的，引用类型除外。
	 *	abstract  : 定义抽象方法或者抽象类
	 *	extends   : 继承接口或者父类
	 *	implements: 实现接口
	 */
	interface Protocol {
		String protocolVersion = "1.1.6";
		
		String method();
	}
	interface SubProtocol extends Protocol {}
	
	class ProtocolImpl implements Protocol {

		@Override
		public String method() {
			System.out.println(protocolVersion);
			return "my protocolVersion is: "+ protocolVersion;
		}
		
	}
	
	abstract class AbstractClass {
		public abstract String method();
	}
	abstract class SubAbstractClass extends AbstractClass {}
	
	class AbstractClassImpl extends AbstractClass {

		@Override
		public String method() {
			return "hello world";
		}
	}
	
	/*
	 * 异常处理关键字：
	 * try-catch-finally, throw, throws
	 * catch   : 用于捕获异常信息
	 * finally : 一定会指定的代码块，一般用于资源释放
	 * throw   : 抛出自定义异常，例如： throw new RuntimeException("异常信息");
	 * throws  : 用于方法声明上抛出异常 
	 */
	public void handleException() throws Exception {
		int i = -1;
		try {
			i = 10 / 0;
			System.out.println(i);
		} catch (ArithmeticException ex) {
			throw new RuntimeException(ex.getMessage());
		} finally {
			i = Integer.MAX_VALUE;
			System.out.println(i);
		}
	}
	
	/*
	 * 对象引用关键字：
	 * this  : 当前对象上下文信息，代指当前类的对象
	 * super : 父类上下文信息，代指父类实例对象
	 */
	class Parent {
		protected String home = "HeNan";

		public Parent() {
			System.out.println("parent class constructor.");
		}
	}
	
	class Children extends Parent {

		public Children() {
			// 调用父类的构造方法
			super();
		}
		
		public Children(String myHome) {
			this.home = myHome;
		}
	}
	
	/*
	 * 断言关键字：
	 * assert   : 用于说明某个条件成立，如果成立则通过，不成立会抛出异常
	 */
	public void assertExpression() {
		long now = System.currentTimeMillis();
		assert now > 0;
		
		assert now <= 0;
	}
	
	/*
	 * 线程同步相关关键字：
	 * synchronized   :  用于同步线程
	 * volatile       :  用户保证线程读取内存中数据的一致性
	 */
	public synchronized void testMethodLock() {}
	public static synchronized void testClassLock() {}
	public void testObjectSynchronized() {
		synchronized (this) {
			System.out.println("test object synchronized");
		}
	}
	public void testClassSynchronized() {
		synchronized (JavaKeywordCollector.class) {
			System.out.println("test class synchronized");
		}
	}
}