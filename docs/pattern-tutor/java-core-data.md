# 如何保存/恢复Java应用程序核心内存数据现场？

## **0. 背景**
不论是单体应用还是分布式应用，总是会有些许迭代或者紧急Fix bug上线的神操作。但是如果不是那么幸运，当时还存在大量核心内存中数据在进行计算等逻辑，此时终止项目，就会出现核心数据或者状态丢失的不利情况，后续即使上线完成也要尽快追加数据。

```
那是否存在某种技巧???：在需要终止应用的时候，能够监听到终止操作，并保存核心数据现场，然后再终止应用，而后在应用恢复后，再进行核心数据恢复。

答案是肯定的。
```

### **0.1 技术储备**

```
Runtime.getRuntime().addShutdownHook(Thread thread);
```
<!-- more -->
我们可以借助于JDK为我们所提供的上述**钩子**方法。这个方法的意思就是在JVM中增加一个关闭的钩子，当JVM关闭的时候，会执行系统中已经设置的所有通过方法addShutdownHook添加的钩子，当系统执行完这些钩子后，JVM才会关闭。所以这些钩子可以在JVM关闭的时候进行**内存清理、对象销毁以及核心数据现场保存**等操作。


## **1. 假设一种场景**
### **1.1 保存现场，为应用保驾护航**
我们应用程序运行中，在内存中存储着Map<String, User>（用户唯一标识符和用户信息的映射关系），此时，突然需要紧急处理某个bug并打包上线。

用户映射关系已经建立好了，我们总不能因为紧急上线就让用户重新登录一次，只是为了构建这个映射关系？？？这样显然不是很合理，其次还有用户流失的风险，我们怎么可以去冒着被大boss怒怼这般的大风险呢，搞不好年终奖还没有，哈哈哈哈哈……

那我们换个思路，我们要解决的问题是什么呢？因为Map<String, User>是在内存中保存的，一但应用终止，内存资源释放，内存中数据当然无存……所以，我们的目标就是**保存这个处于内存中的Map对象**，对不对？那就简单了，我们可以**把这个对象序列化存储到本地文件里面**不就好了吗？是不是很简单？然后呢，只需要在应用程序被终止前序列化且保存到本地文件，就可以了。

理好了思路，那就开始Coding吧！

```
	private static final HashMap<String, User> cacheData = new HashMap<>();
    private static final String filePath = System.getProperty("user.dir")
				     			+ File.separator + "save_point.binary";

	Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                saveData();
            }
        });

	private static void saveData() {
        ObjectOutputStream oos = null;
        try {
            File cacheFile = new File(filePath);
            if (!cacheFile.exists()) {
                cacheFile.createNewFile();
            }
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(cacheData);
            oos.flush();
        } catch (IOException ex) {
            LOGGER.error("save memory data error", ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                LOGGER.error("close ObjectOutputStream error", ex);
            }
        }
    }
```

这样我们就可以保证Map<String, User>这个映射关系保存好了。

### **1.2 恢复现场，让应用快速飞翔**

既然我们保存了内存数据现场，那在应用启动后，我们相应的也需要进行数据现场恢复，这样才能保证应用平滑过渡到终止前状态，同时用户还能无感知。

继续Coding...

```
	@PostConstruct
	public void resoverData() {
        ObjectInputStream ois = null;
        try {
            File cacheFile = new File(filePath);
            if (cacheFile.exists()) {
                ois = new ObjectInputStream(new FileInputStream(filePath));
                Map<String, User> cacheMap =
                					(Map<String, User>) ois.readObject();
                for (Map.Entry<String, User> entry : cacheMap.entrySet()) {
                    cacheData.put(entry.getKey(), entry.getValue());
                }
                LOGGER.info("Recover memory data successfully, cacheData={}"
                							, cacheData.toString());
            }
        } catch (Exception ex) {
            LOGGER.error("recover memory data error", ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                LOGGER.error("close ObjectInputStream error", ex);
            }
        }
    }
```

是不是整个过程似曾相识？没错，就是Java IO流 **ObjectInputStream**和**ObjectOutputStream**的应用。但是有一点需要注意，使用对象流的时候，需要保证被序列化的对象必须实现了**Serializable**接口，这样才能正常使用。

应用整体调用逻辑如下（测试的时候，第一次需要正常调用generateAndPutData()方法，终止项目保存现场后，需要把generateAndPutData()注释掉，看看时候正确恢复现场了。）：
```
	@SpringBootApplication
	public class SavePointApplication {

    private static final Logger LOGGER =
    				LoggerFactory.getLogger(SavePointApplication.class);

    private static final HashMap<String, User> cacheData = new HashMap<>();
    private static final String filePath = System.getProperty("user.dir")
    				+ File.separator + "save_point.binary";

    public static void main(String[] args) {
        SpringApplication.run(SavePointApplication.class, args);

        LOGGER.info("save_point filePath={}", filePath);
        generateAndPutData();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                saveData();
            }
        });
    }

	private static void generateAndPutData() {
        cacheData.put("test1", new User(1L, "testName1"));
        cacheData.put("test2", new User(2L, "testName2"));
        cacheData.put("test3", new User(3L, "testName3"));
    }
```

## **2. Fuck! 没有保存现场?!**

为什么应用程序终止时没有保存现场状态呢？那就要细说一下关闭钩子(shutdown hooks)了。

- 如果JVM因异常关闭，那么子线程（Hook本质上也是子线程）将不会停止。但在JVM被强行关闭时，这些线程都会被强行结束。

- 关闭钩子本质是一个线程（也称为Hook线程），用来监听JVM的关闭。通过Runtime的addShutdownHook可以向JVM注册一个关闭钩子。Hook线程在JVM正常关闭才会执行，强制关闭时不会执行。

- JVM中注册的多个关闭钩子是并发执行的，无法保证执行顺序，当所有Hook线程执行完毕，runFinalizersOnExit为true,JVM会先运行终结器，然后停止。

所以，如果我们直接使用的**kill -9 processId**命令直接强制关闭的应用程序，JVM都被强制关闭了，还怎么运行我们的Java代码呢？嘿嘿，所以我们可以尝试着用如下命令替代**kill -9 processId**:
```
kill processId
kill -2 processId
kill -15 processId
```

通过上述命令进行终止应用的时候，是不是我们看到我们项目下成功生成了 **save_point.binary** 文件了，哈哈哈哈哈……

## **3. 使用关闭钩子有哪些注意事项呢？**

- hook线程会延迟JVM的关闭时间，所以尽可能减少执行时间。
- 关闭钩子中不要调用system.exit()，会卡主JVM的关闭过程。但是可以调用Runtime.halt()
- 不能在钩子中进行钩子的添加和删除，会抛IllegalStateException
- 在system.exit()后添加的钩子无效，因为此时JVM已经关闭了。
- 当JVM收到SIGTERM命令（比如操作系统在关闭时）后，如果钩子线程在一定时间没有完成，那么Hook线程可能在执行过程中被终止。
- Hook线程也会抛错，若未捕获，则钩子的执行序列会被停止。
