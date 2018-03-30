Stream API:
创建与管理中间集合所导致的性能消耗也随之消失：顺序执行，
流执行要比相应的循环版本快两倍。并行执行对于大型数据集
来说会产生非常棒的加速效果。

在多核上的独立执行是通过为每个核分配一个不同的线程来实现的，
每个线程会执行整个工作的一个子任务，在该例中就是待处理的集合
元素的一个子集。比如说，加入有一个四核处理器和包含了N个元素
的一个列表，程序可以定义一个solve算法，将任务分解以实现并行
执行，就像下面这样：
```
if the task list contains more that N/4 elements {
	letftTask = task.getLeftHalf()
	rightTask = task.getRightHalf()
	doInParallel {
		leftResult = leftTask.solve()
		rightResult = rightTask.solve()
	}
	result = combine(leftResult, rightResult)
} else {
	result = task.solveSequentially()
}
```

上述伪代码非常简化地阐述了并行处理，递归分解的模式 — 递归地将大任务分解为小任务以并行执行，
直到子任务变得“足够小”从而能串行执行为止。
实现递归分解要了解如何以这种方式来分解任务，如何执行足够小的任务而不必再进一步分割，如何将
这些小任务的执行结果合并到一起。到底该如何分割取决于数据源；在该例中，分割列表有着显而易见
的实现。
将子任务的执行结果合并起来通常是通过对其应用管道终止操作来实现的。

[Java的fork/join框架就应用了该模式，只不过它是从线程池中为新的子任务分配线程而不是创建
新的线程。](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/2018-03-30_132953.bmp)