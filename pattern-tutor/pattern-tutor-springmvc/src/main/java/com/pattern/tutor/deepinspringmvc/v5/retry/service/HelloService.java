package com.pattern.tutor.deepinspringmvc.v5.retry.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.pattern.tutor.deepinspringmvc.v5.retry.annotation.Retryable;

/**
 * @author buildupchao
 * @date 2019/08/26 09:52
 * @since JDK 1.8
 */
@Service
public class HelloService {

	private AtomicInteger retryTimes = new AtomicInteger(0);
	
	@Retryable(retryTimes = 4, retryInterval = 3000)
	public String hello(String name) {
		int times = retryTimes.incrementAndGet();
		if (times % 4 != 0) {
			throw new RuntimeException("network timeout, failed");
		}
		return "hello, " + name;
	}
}
