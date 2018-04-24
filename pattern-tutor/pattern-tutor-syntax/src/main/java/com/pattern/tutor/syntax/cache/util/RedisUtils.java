package com.pattern.tutor.syntax.cache.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class RedisUtils {
	
	public static final String DEFAULT_PATH = "src/main/java/com/pattern/tutor/syntax/cache";
	
	public static Jedis connect() {
		Properties properties = new Properties();
		try {
			properties.load(Files.newInputStream(Paths.get(DEFAULT_PATH + "/jedis.properties")));

			String host = properties.getProperty("jedis.host");
			int port = Integer.parseInt(Optional.ofNullable(properties.getProperty("jedis.port")).orElse("6379"));
			Jedis jedis = new Jedis(host, port);
			jedis.connect();
			
			log.info("PING -> {}", jedis.ping());
			
			return jedis;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
