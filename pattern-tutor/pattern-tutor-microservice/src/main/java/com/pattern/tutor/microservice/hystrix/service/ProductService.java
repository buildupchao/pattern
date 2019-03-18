package com.pattern.tutor.microservice.hystrix.service;

/**
 * @author buildupchao
 *         Date: 2019/3/19 00:18
 * @since JDK 1.8
 */
public class ProductService {

    public String getProduct(Long id) {
        return "new-follower-" + id;
    }
}
