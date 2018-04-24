[强制] ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException异常，即java.util.RandomAccessSubList cannot be java.util.ArrayList。<br/>
[说明]subList返回的是ArrayList的内部类SubList，并不是ArrayList，而是ArrayList的一个视图，对于SubList子列表的所有操作最终会反映到原列表上。
<br/><br/>
[强制] 在subList场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增加、删除均会产生 ConcurrentModificationException 异常。
<br/><br/>
[强制] 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一样的数组，大小就是 list.size()
<br/><br/>
[强制] 使用工具类 Arrays.asList() 把数组转换成集合时，不能使用其修改集合相关的方法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。<br/>
[说明] asList的返回对象是一个 Arrays 的内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。<br/>
```Java
String[] str = new String[] {"you", "wu"};
List list = Arrays.asList(str);
第一种情况： list.add("yangguangbao"); 运行时异常。
第二种情况： str[0] = "gujin"; 那么 list.get(0) 也会随之修改。
```
<br/><br/>
[强制] 泛型通配符 <? extends T> 来接收返回的数据，此写法的泛型集合不能使用 add 方法，而<? super T> 不能使用 get 方法，作为接口调用赋值时易出错。<br/>
[说明] 扩展说一下 PECS （Producer Extends Consumer Super）原则：第一、频繁往外读取内容的，适合用 <? extends T>。第二、经常往里插入的，适合用 <? super T>。
<br/><br/>
[强制] 在JDK7版本及以上， Comparator 要满足如下三个条件，不然 Arrays.sort， Collections.sort 会报 IllegalArgumentException 异常。<br/>
[说明] 三个条件如下:<br/>
```
1）x, y的比较结果和y, x的比较结果相反
2）x>y, y>z, 则x>z
3）x=y，则x，z比较结果和y，z比较结果相同
```
<br/><br/>
[推荐] 高度注意 Map类集合 K/V能不能存储null值的情况，情况如下表：
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/2018-04-13_145555.bmp)
<br/><br/>
[参考] 合理利用好集合的有序性（sort）和稳定性（order），避免集合的无序性（unsort)和不稳定性（unorder）带来的负面影响。<br/>
[说明] 有序性是指遍历的结果是按某种比较规则依次排列的。稳定性指集合每次遍历的元素次序是一定的。如：ArrayList是 order/unsort；HashMap是unorder/unsort；TreeSet是order/sort。
<br/><br/>
[参考] 利用Set元素唯一的特性，可以快速对一个集合进行去重操作，避免使用List的contains方法进行遍历、对比、去重操作。