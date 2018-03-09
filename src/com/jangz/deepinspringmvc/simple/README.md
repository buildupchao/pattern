XmlBeanFactory初始化顺序:

bf:BeanFactoryTest

1#, new ClassPathResource('beanFactoryTest.xml')

=> classPathResource: ClassPathResource

2#, resource: Resource

=> bf: BeanFactoryTest

3#, new XmlBeanFactory(resource)

=> xmlBeanFactory: XmlBeanFactory

3.1#, loadBeanDefinition(resource)

=> reader: XmlBeanDefinitionReader

3.2#, loadedBeanDefinitionNum: int

=> xmlBeanFactory: xmlBeanFactory

4#, bf: BeanFactory

=> bf: BeanFactoryTest