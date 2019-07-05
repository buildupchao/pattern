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
Java | * [x] | * [x]
Scala | * [x] | * [x]
Python | * [x] | * [x]
R | * [x] | 第三方
SQL | * [x] | * [x]

