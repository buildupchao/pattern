package com.pattern.tutor.deepinspringmvc.v5.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.cache.LoadingCache;

/**
 * @author buildupchao
 * @date: 2019/3/31 19:19
 * @since JDK 1.8
 */
@ComponentScan
public class CacheTests {
	
	private static LoadingCache<String, String> cache;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CacheTests.class);
		
		cache = ctx.getBean(LoadingCache.class);
		
		CacheTests cacheTests = new CacheTests();
		
		cacheTests.testCacheUsing();
		
		cacheTests.testPrintCacheInfo();
	}
	
	public void testCacheUsing() {
		cache.put("yourName", "buildupchao");
	}
	
	public void testPrintCacheInfo() {
		System.out.println(cache.asMap());
	}
}
