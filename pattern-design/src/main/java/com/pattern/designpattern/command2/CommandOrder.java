package com.pattern.designpattern.command2;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class CommandOrder extends HystrixCommand<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommandOrder.class);
	
	private String orderName;
	
	public CommandOrder(String orderName) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("OrderGroup"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("OrderPool"))
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
						.withCoreSize(10)
						.withKeepAliveTimeMinutes(5)
						.withMaxQueueSize(10)
						.withQueueSizeRejectionThreshold(10000)
				)
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
				)
		);
		
		this.orderName = orderName;
	}
	
	@Override
	protected String run() throws Exception {
		LOGGER.info("orderName=[{}]", orderName);
		
		TimeUnit.MILLISECONDS.sleep(100);
		return "OrderName=" + orderName;
	}

}
