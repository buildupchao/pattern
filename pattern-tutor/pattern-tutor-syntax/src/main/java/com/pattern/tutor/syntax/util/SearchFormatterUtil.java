package com.pattern.tutor.syntax.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangyachao
 * @date 2018/11/20 10:20
 * @since JDK 1.8
 * @description 数据匹配工具类：equals > startsWith > contains
 */
public class SearchFormatterUtil {

    public static <T> List<T> format(String searchKeyword, List<T> list, Function<T, String> keyGenerator) {
        return format(searchKeyword, list, keyGenerator, null);
    }

    public static <T> List<T> format(String searchKeyword, List<T> list, Function<T, String> keyGenerator, Function<T, String> downKeyGenerator) {
        if (StringUtils.isEmpty(searchKeyword) || CollectionUtils.isEmpty(list) || Objects.isNull(keyGenerator)) {
            return list;
        }

        Map<Boolean, List<T>> partitionByEqualMap = list.stream()
                .sorted(Comparator.comparing(keyGenerator))
                .collect(Collectors.partitioningBy(t -> keyGenerator.apply(t).equals(searchKeyword)));
        List<T> results = Lists.newArrayListWithCapacity(list.size());

        // equals
        List<T> equalsList = partitionByEqualMap.getOrDefault(Boolean.TRUE, Lists.newArrayListWithCapacity(0));
        if (Objects.nonNull(downKeyGenerator)) {
            equalsList = equalsList.stream().sorted(Comparator.comparing(downKeyGenerator)).collect(Collectors.toList());
        }
        results.addAll(equalsList);

        Map<Boolean, List<T>> partitionByStartMap = partitionByEqualMap.getOrDefault(Boolean.FALSE, Lists.newArrayListWithCapacity(0))
                .stream().collect(Collectors.partitioningBy(t -> keyGenerator.apply(t).startsWith(searchKeyword)));

        // starts with
        List<T> startsList = partitionByStartMap.getOrDefault(Boolean.TRUE, Lists.newArrayListWithCapacity(0));
        results.addAll(startsList);

        // likes
        List<T> likesList = partitionByStartMap.getOrDefault(Boolean.FALSE, Lists.newArrayListWithCapacity(0));
        results.addAll(likesList);
        return results;
    }
}
