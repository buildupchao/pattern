package com.pattern.tutor.microservice.hystrix.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buildupchao
 *         Date: 2019/3/19 00:57
 * @since JDK 1.8
 */
public class PriceService {

    public List<Double> getPrices(List<Long> ids) {
        List<Double> prices = Lists.newArrayListWithCapacity(ids.size());
        for (Long id : ids) {
            prices.add(RandomUtils.nextDouble(1, 5));
        }
        return prices;
    }
}
