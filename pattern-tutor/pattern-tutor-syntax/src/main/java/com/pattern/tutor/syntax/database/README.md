### Mybatis: Sqlsession -> Executor -> StatementHandler -> ResultHandler<br/>
JDBC: Connection -> Statement -> Result<br/>
<br/>
<br/>
1, 为什么默认使用的语句是 PrepareStatementHandler？<br/>
2, #是什么时候被替换的，为什么对应的 BoundSql，$时没有映射，#有映射？<br/>
<br/>
Mybatis的初始化阶段，仅列出大致路径，<br/>
Mybatis是通过SqlSessionFactory build出来的，会解析映射文件，大致路径就是<br/>
<br/>
SqlSessionFactoryBuilder -> XmlConfigBuilder -> XMLMapperBuilder -> XMLStatementBuilder<br/>
<br/>
在XMLStatementBuilder的 parseStatementNode 负责了生成MappedStatement，首先回答第一个问题。当你不指定 statementType 时， Mybatis默认使用的就是 PrepareStatementHandler，这里的 StatementType，在后续流程中使用 RoutingStatementHandler 选择使用哪一个 StatementHandler。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/1.jpg)
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/2.jpg)
<br/>
<br/>
BoundSql中包含了Sql主体，同时其中的参数映射决定了后续是否要进行参数化，在$和#时，表现是不同的。<br/>
<br/>
BoundSql来自于 MappedStatement，在MappedStatement中，获取BoundSql的任务委托给SqlSource接口。所以接下来主要看SqlSource是如何生成的。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/3.jpg)
<br/>
XMLLandDriver可以理解为就是用来解析Mybatis定制的XML符合的语句。它会把具体解析符号的职责交给XMLScriptBuilder的parseScriptNode方法。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/4.jpg)
<br/>
parseDynamicTags中会把语句用TextSql包装起来，然后使用isDynamic方法，在方法中使用 GenericTokenParse判断是否是动态语句。如果其中包括$,就是动态的，如果是#就不是动态的，使用的Handler是DynamicCheckerTokenParser。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/5.jpg)
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/6.jpg)
<br/>
在进入parse方法后，主要看以下这一段。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/7.jpg)
<br/>
这里会使用TokenHandler不同的实现类，对表达式进行进一步的处理，这里是对Sql之后的完善，在判断isDynamic中，使用的是DynamicCheckerTokenParser，一个最简单的实现。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/8.jpg)
<br/>
parse完成后，如果isDynamic是true的话，就是动态语句，使用DynamicSqlSource。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/9.jpg)
<br/>
如果是非动态的话，其实一般就是指使用了#的语句，使用RawSqlSource，在其中，还会进一步解析。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/10.jpg)
<br/>
从下图中可以看出，这个TokenParser这回使用的是#{}，而且使用的是ParameterMappingTokenHandler。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/11.jpg)
<br/>
ParameterMappingTokenHandler的handlerToken方法中，完成了添加参数映射和替换#{value}为？的职责。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/12.jpg)
<br/>
从以上我们可以知道，使用#在初始化阶段，会被替换成？号，同时生成参数映射，而使用$在初始化阶段，没有什么特别的地方，仅仅做了一个是否动态语句的判断。<br/>
<br/>
在初始化完毕后，我们进入getBoundSql方法，看一下DynamicSqlSource和StaticSource在此刻做了什么，首先是DynamicSqlSource。<br/>
<br/>
在其中，首先会生成一个DynamicContext，主要就是生成 bindings，一个是"_parameter" -> 'anything' OR 'x' = 'x'，一个是 "_databaseId" ->  "null"<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/13.jpg)
<br/>
然后使用apply方法，我理解这里是要去做替换了。具体还是使用${}去判断，和上文一致，只不过这里使用的是BindingTokenParser。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/14.jpg)
<br/>
看一下BindingTokenParser的HandleToken方法。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/15.jpg)
<br/>
上述代码的效果，就是会使用Ognl，使用value在Bindings中，找对应的值，最后返回，拼接在Sql中，这也就是为什么会有Sql注入风险的原因。使用value是因为Ognl去找的时候，就会使用value这个默认值，所以需要在bindings额外加入这么一个键值对。<br/>
<br/>
接下来是生成SqlSource，使用的是SqlSourceBuilder的parse方法。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/16.jpg)
<br/>
在前文介绍过，在这个parse方法中，使用#{}来判断的，所以走不到ParameterMappingTokenHandler的handlerToken方法，也就无法添加参数映射了，这个直接返回一个StaticSqlSource，这也解析了为什么使用$时，参数映射为空。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/17.jpg)
<br/>
再接下去就是获取BoundSql，使用的是StaticSqlSource，直接根据参数，实例化一个，参数映射为空。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/18.jpg)
<br/>
当使用#的时候，使用的就是StaticSqlSource，直接实例化，因为参数映射在之前初始化的阶段，也生成好了，所以很简单的一个流程。<br/>
![](https://github.com/Zychaowill/ImgStore/blob/master/Java/images/19.jpg)
<br/>
本文主要剖析了Mybatis中$和#两种符号使用上的不同，以及使用这两种符号时，源码流程上的区别。建议都是用#号，在orm这层也规避到Sql注入的风险。

<br/><br/><br/>

### MySQL数据库

- [建表规约](https://github.com/Zychaowill/pattern/blob/master/pattern-tutor/pattern-tutor-syntax/src/main/java/com/pattern/tutor/syntax/database/CREATE_TABLE.md)

- [索引规约](https://github.com/Zychaowill/pattern/blob/master/pattern-tutor/pattern-tutor-syntax/src/main/java/com/pattern/tutor/syntax/database/INDEX_DEAL.md)

- [SQL语句]()

- [ORM映射]()