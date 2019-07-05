## Flink VS Spark

在流式计算领域，同一套系统需要同时兼具容错性和高性能其实非常难，同时他也是衡量和选择一个系统的标准。在这个领域，Flink和Spark无疑是彼此非常强劲的对手。

item | Record ACK | Micro-batching | Transactional updates | Distributed snapshots
-----|------------|----------------|-----------------------|----------------------
典型代表  |  Apache Storm | Apache Storm Trident,<br/> Apache Spark Streaming | Google Cloud Dataflow | Apache Flink
语义保证  |  At least once | Exactly once | Exactly once | Exactly once
延迟 | 低 | 高 | 较低（事务延迟） |低
吞吐 |低 | 高 | 较高（取决于做事务存储吞吐） | 高
计算模型 | 流 | 微批 | 流 | 流
容错开销 | 高 | 低 | 较低（取决于事务存储的吞吐）| 低
流控 | 较差 | 较差 | 好 | 好
业务灵活性（业务和容错分离）|部分|紧耦合|分离|分离
原理|Source保留其产生的所有记录备份，当源头一条记录的所有派生记录都被整个Topology处理完成，Source节点就可以删除其备份 | 连续的数据流不要切分到record级别，而是收敛切分为一批一批微批的、原子的数据进行类似Batch的计算，每个batch的数据可能会成功或失败处理，我们就对当前失败的这一小批数据进行处理即可 | 原子地记录数据的处理以及状态的更新（类似数据的WAL日志）。一旦系统出现Fail，可从记录的日志中恢复我们需要的中间计算状态和需要处理数据 | 确定当前流式计算的状态（包括正在处理的数据，以及Operator状态），生成该状态的一致快照，并存储在持久存储中

### 1.Flink VS Spark之API

Spark与Flink API情况如下：

API | Spark | Flink
----|-------|------
底层API | RDD | Process Function
核心API | DataFrame/DataSet/Structured Streaming | DataStream/DataSet
SQL | Spark SQL | Table API & SQL
机器学习 | MLlib | FlinkML
图计算 | GraphX | Gelly
其他 | - | CEP

Spark与Flink对开发语言的支持如下所示：

支持语言 | Spark | Flink
--------|----|------
Java | Y | Y
Scala | Y | Y
Python | Y | Y
R | Y | 第三方
SQL | Y | Y

### 2.Flink VS Spark之Connectors

Spark支持的Connectors如下所示：

![https://github.com/buildupchao/ImgStore/blob/master/patterns/flink-introduction-1.bmp](https://github.com/buildupchao/ImgStore/blob/master/patterns/flink-introduction-1.bmp?raw=true)

Flink支持的Connectors如下所示：

![https://github.com/buildupchao/ImgStore/blob/master/patterns/flink-introduction-2.bmp](https://github.com/buildupchao/ImgStore/blob/master/patterns/flink-introduction-2.bmp?raw=true)

从Flink和Spark Connectors对比可以看出，Spark与Flink支持的Connectors的数据差不多，目前来说可能Spark支持更多一些，Flink后续的支持也会逐步的完善。

### 3.Flink VS Spark之运行环境

Spark与Flink所支持的运行环境基本差不多，都比较广泛。

部署环境 | Spark | Flink
--------|----|------
Local(Single JVM) | Y | Y
Standalone Cluster | Y | Y
Yarn | Y | Y
Mesos | Y | Y
Kubernetes | Y | Y

### 4.Flink VS Spark之社区

Spark社区在规模和活跃程度上都是领先的，毕竟多了几年发展时间，同时背后的商业公司Databricks由于本土优势使得Spark在美国的影响力明显优于Flink。

而且作为一个德国公司，Data Artisans想在美国扩大影响力要更难一些。不过Flink社区也有一批稳定的支持者，达到了可持续发展的规模。

在中国情况可能会不一样一些。比如美国公司，中国公司做事情速度更快，更愿意尝试新技术。中国的一些创新场景也对实时性有更高的需求。这些都对Flink更友好一些。

### Summary

- Spark和Flink都是通用的开源大规模处理引擎，目标是在一个系统中支持所有的数据处理以带来效能的提升。两者都有相对成熟的生态系统。是下一代大数据引擎最有力的竞争者。

- Spark的生态总体更完善一些，在机器学习的集成和易用性上暂时领先。

- Flink在流式计算上有明显优势，核心架构和模型也更透彻和灵活一些。

-  在易用性方面两者也都还有一些地方有较大的的改进空间。接下来谁能尽快补上短板发挥强项就有更多机会。

- 总而言之，Flink和Spark没有谁强谁弱，只有哪个更适合当前的场景。