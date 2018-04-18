其中一次测试结果:<br/>
> 本例测试了顺序流，传统叠加，和并行流对前一千万个自然数求和的时间，结果是传统叠加最快，并行流最慢。<br/>
> 原因如下：<br/>
> 1，Stream.iterate生成的装箱的对象，必须拆箱成数字才能求和<br/>
> 2，很难把iterate分成多个独立块来并行执行<br/>
<br/>
> 另外，像任何其他Java代码一样，分支/合并框架需要“预热”或者说要执行几遍才会被JIT编译器优化。这就是为什么在测试性能之前跑几遍程序很重要。<br/>
> PerformanceTestingCase测试案例就是这么做的。

```
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Sequential sum done in: 95
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Iterative sum done in: 2
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
Result: 50000005000000
ParallelStream sum done in: 136
```