package com.pattern.tutor.syntax.action.newfeature.java8.stream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 *     针对Stream#collect(toMap)的NullPointerException问题处理方式
 * </p>
 * @author buildupchao
 * @date 2019/12/20 11:47
 * @since JDK 1.8
 */
public class ToMapCollectNullIssue {

    public static void main(String[] args) {
        testSimpleHandleToMap();

        testOptionalHandleToMap();

        testSupplierHandleToMap();
    }

    /**
     * 虽然可规避问题，但是表意仍不够明确
     */
    public static void testSimpleHandleToMap() {
        List<Pair> pairs = generateData();
        pairs.stream()
                .collect(Collectors.toMap(Pair::getLeft, pair -> pair.getRight() == null ? StringUtils.EMPTY : pair.getRight()))
                .forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    /**
     * 虽然可规避问题，但是表意不是足够明确
     */
    public static void testOptionalHandleToMap() {
        List<Pair> pairs = generateData();
        pairs.stream()
                .collect(Collectors.toMap(Pair::getLeft, pair -> Optional.ofNullable(pair.getRight())))
                .forEach((key, value) -> System.out.println(key + " -> " + value.orElse(StringUtils.EMPTY)));
    }

    /**
     * 仍然建议使用该种方式，表意明确，代码可读性更好。
     */
    public static void testSupplierHandleToMap() {
        List<Pair> pairs = generateData();
        pairs.stream()
                .collect(HashMap::new, (m, v) -> m.put(v.getLeft(), v.getRight()), HashMap::putAll)
                .forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static List<Pair> generateData() {
        return Arrays.asList(
                Pair.of("yesterday", new Integer(-1)),
                Pair.of("today", new Integer(0)),
                Pair.of("tomorrow", null)
        );
    }
}
