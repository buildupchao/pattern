package com.pattern.tutor.syntax.cache.redis;

import java.util.Set;

import com.pattern.common.utils.PrintlnUtils;
import com.pattern.tutor.syntax.cache.util.RedisUtils;

import redis.clients.jedis.Jedis;

public class SortSetExample {

	public static void main(String[] args) {
		Jedis jedis = RedisUtils.connect();
		RedisSortSet sortSet = new RedisSortSet(jedis);
		
		String key = "hotmessage";
		sortSet.zadd(key, 300, "20");
		Set<String> results = sortSet.zrange(key, 0, 100);
		PrintlnUtils.println("results=[" + String.join(",", results) + "]");
		
		sortSet.zremrangebyrank(key, 4, 4);
		
		results = sortSet.zrange(key, 0, 100);
		PrintlnUtils.println("results=[" + String.join(",", results) + "]");
		
		results = sortSet.zrevrange(key, 0, 2);
		PrintlnUtils.println("results=[" + String.join(",", results) + "]");
	}
	
	
}
