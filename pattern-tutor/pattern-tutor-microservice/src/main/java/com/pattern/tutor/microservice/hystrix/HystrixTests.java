package com.pattern.tutor.microservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.pattern.tutor.microservice.hystrix.service.ProductService;
import org.junit.Assert;

/**
 * @author buildupchao
 *         Date: 2019/3/19 00:22
 * @since JDK 1.8
 */
public class HystrixTests {

    public static void main(String[] args) {
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                .withRequestCacheEnabled(true);

        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            ProductService productService = new ProductService();
            GetProductServiceCommand command1 = new GetProductServiceCommand(
                    HystrixCommand.Setter
                            .withGroupKey(HystrixCommandGroupKey.Factory.asKey("get-product-group"))
                            .andCommandPropertiesDefaults(commandProperties),
                    productService,
                    1L
            );

            GetProductServiceCommand command2 = new GetProductServiceCommand(
                    HystrixCommand.Setter
                            .withGroupKey(HystrixCommandGroupKey.Factory.asKey("get-product-group"))
                            .andCommandPropertiesDefaults(commandProperties),
                    productService,
                    1L
            );

            command1.execute();
            command2.execute();

            Assert.assertFalse(command1.isResponseFromCache());
            Assert.assertTrue(command2.isResponseFromCache());
        } finally {
            context.shutdown();
        }
    }
}
