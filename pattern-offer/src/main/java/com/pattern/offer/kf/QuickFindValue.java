package com.pattern.offer.kf;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by buildupchao on 2018/6/22.
 */
@Slf4j
public class QuickFindValue {

    public boolean find(int value, int[] elements) {
        log.info("value={}", value);

        boolean result = false;
        int middle = 0;
        int low = 0;
        int high = elements.length;

        while (low < high) {
            middle = (low + high) / 2;
            if (elements[middle] == value) {
                result = true;
                break;
            } else if (elements[middle] > value) {
                high = middle;
            } else if (elements[middle] < value) {
                low = middle;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] elements = new int[10];
        Random random = new Random();
        for (int i = 0; i < elements.length; i++) {
            elements[i] = random.nextInt(100);
        }

        log.info("Elements={}", Arrays.stream(elements).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        boolean result = new QuickFindValue().find(elements[elements.length / 2], elements);
        log.info("The result of finding is {}", result);
    }
}
