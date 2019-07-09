package com.pattern.tutor.deepinspringmvc.v5.cache.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author buildupchao
 * @date 2019-07-08 23:28
 * @since JDK 1.8
 */
@Configuration
public class RedisConfig {

    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        return Redisson.create(config);
    }

    @Bean
    RLiveObjectService rLiveObjectService() {
        RedissonClient redisson = redisson();
        return redisson.getLiveObjectService();
    }
}
