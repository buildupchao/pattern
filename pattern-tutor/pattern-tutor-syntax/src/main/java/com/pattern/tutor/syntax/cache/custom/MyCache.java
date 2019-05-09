package com.pattern.tutor.syntax.cache.custom;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author buildupchao
 * @date: 2019/4/1 20:34
 * @since JDK 1.8
 */
public class MyCache<K, V> {

    private final ConcurrentHashMap<K, V> caches = new ConcurrentHashMap<K, V>();

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.io.temp"));
    }
}
