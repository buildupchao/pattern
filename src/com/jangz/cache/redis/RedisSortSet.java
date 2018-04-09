package com.jangz.cache.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisSortSet {
	
	private Jedis jedis;
	
	public RedisSortSet(Jedis jedis) {
		this.jedis = jedis;
	}
	
	public Long zadd(String key, double score, String member) {
		return jedis.zadd(key, score, member);
	}
	
	public Set<String> zrange(String key, long start, long end) {
		return jedis.zrange(key, start, end);
	}
	
	public Set<String> zrevrange(String key, long start, long end) {
		return jedis.zrevrange(key, start, end);
	}
	
	public Long zcard(String key) {
		return jedis.zcard(key);
	}
	
	public Double zscore(String key, String member) {
		return jedis.zscore(key, member);
	}
	
	public Long zrem(String key, String member) {
		return jedis.zrem(key, member);
	}
	
	public Long zrank(String key, String member) {
		return jedis.zrank(key, member);
	}
	
	public Long zrevrank(String key, String member) {
		return jedis.zrevrank(key, member);
	}
	
	public Double zincrby(String key, double score, String member) {
		return jedis.zincrby(key, score, member);
	}
	
	public Long zremrangebyrank(String key, long start, long end) {
		return jedis.zremrangeByRank(key, start, end);
	}
}
