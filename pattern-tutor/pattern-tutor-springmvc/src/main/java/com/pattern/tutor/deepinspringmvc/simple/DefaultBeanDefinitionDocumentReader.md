### 1 DefaultBeanDefinitionDocumentReader.class

1#, 首先委托 BeanDefinitionParserDelegate 类的 parseBeanDefinitionElement 方法进行元素解析，
返回 BeanDefinitionHolder 类型的实例 bdHolder, 经过这个方法后， bdHolder 实例已经包含我们配置文件中配置
的各种属性了，例如 class, name, id, alias 之类的属性

2#, 当返回 bdHolder 不为空的情况下，若存在默认标签的子节点下再有自定义的属性，还需要再次对自定义标签进行解析

3#, 解析完成后，需要对解析后的 bdHolder 进行注册，同样，注册操作委托给了 BeanDefinitionReaderUtils 的
registerBeanDefinition 方法

4#, 最后发出响应时间，通知相关的监听器，这个 bean 已经加载完成了

```Java
/**
 * Process the given bean element, parsing the bean definition
 * and registering it with the registry.
 */
protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {
	BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);
	if (bdHolder != null) {
		bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);
		try {
			// Register the final decorated instance.
			BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, getReaderContext().getRegistry());
		}
		catch (BeanDefinitionStoreException ex) {
			getReaderContext().error("Failed to register bean definition with name '" +
					bdHolder.getBeanName() + "'", ele, ex);
		}
		// Send registration event.
		getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));
	}
}
```

### 2 BeanDefinitionParserDelegate.class

1#, 提取元素的 id 以及 name 属性
2#, 进一步解析其他所有属性并统一封装至 GenericBeanDefinition 类型的事例中
3#, 如果检测到 bean 没有指定 beanName, 那么使用默认规则为此 Bean 生成 beanName
4#, 将获取到的信息封装到 BeanDefinitionHolder 的实例中

```Java
	public BeanDefinitionHolder parseBeanDefinitionElement(Element ele, BeanDefinition containingBean)
``` 