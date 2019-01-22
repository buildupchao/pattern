package com.pattern.designpattern.command2;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class CommandUser extends HystrixCommand<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommandUser.class);
	
	private String userName;
	
	public CommandUser(String userName) {
		super(Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))
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
		
		this.userName = userName;
	}
	
	@Override
	protected String run() throws Exception {
		LOGGER.info("UserName=[{}]", userName);
		
		TimeUnit.MICROSECONDS.sleep(100);
		return "userName=" + userName;
	}

}
