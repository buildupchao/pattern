package com.pattern.tutor.deepinspringmvc.v5.cache.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author buildupchao
 * @date: 2019/3/31 19:19
 * @since JDK 1.8
 */
@Configuration
public class BeanConfig {


    public LoadingCache<String, String> buildCache() {
        return CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return null;
                    }
                });
    }
}
