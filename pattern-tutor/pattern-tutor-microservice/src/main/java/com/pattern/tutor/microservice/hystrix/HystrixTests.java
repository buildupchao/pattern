package com.pattern.tutor.microservice.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.pattern.tutor.microservice.hystrix.service.PriceService;
import com.pattern.tutor.microservice.hystrix.service.ProductService;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author buildupchao
 *         Date: 2019/3/19 00:22
 * @since JDK 1.8
 */
public class HystrixTests {

    @Test
    public void testHystrixCache() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            ProductService productService = new ProductService();
            GetProductServiceCommand command1 = new GetProductServiceCommand(productService, 1L);

            GetProductServiceCommand command2 = new GetProductServiceCommand(productService, 1L);

            command1.execute();
            command2.execute();

            Assert.assertFalse(command1.isResponseFromCache());
            Assert.assertTrue(command2.isResponseFromCache());
        } finally {
            context.shutdown();
        }
    }

    @Test
    public void testHystrixMergeRequest() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            PriceService priceService = new PriceService();
            GetPriceServiceCommand command1 = new GetPriceServiceCommand(priceService, 1L);
            GetPriceServiceCommand command2 = new GetPriceServiceCommand(priceService, 2L);
            GetPriceServiceCommand command3 = new GetPriceServiceCommand(priceService, 3L);

            Future<Double> task1 = command1.queue();
            Future<Double> task2 = command2.queue();
            Future<Double> task3 = command3.queue();

            Double result1 = task1.get();
            Double result2 = task2.get();
            Double result3 = task3.get();

            System.out.printf("result1=[%2f], result2=[%2f], result3=[%2f]\n", result1, result2, result3);
        } finally {
            context.shutdown();
        }
    }
}
