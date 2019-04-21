package com.pattern.tutor.deepinjvm.principle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author buildupchao
 * @date: 2019/4/21 10:57
 * @since JDK 1.8
 */
public class ForeachPrinciple {

    public static void main(String[] args) {
        List<String> values = new CopyOnWriteArrayList<String>() {{
            add("history");
            add("yesterday");
            add("today");
            add("tomorrow");
        }};

        // 与iterator使用位置有关，在元素操作之前使用会导致非强一致性
        Iterator<String> iterator = values.iterator();

        for (String value : values) {
            if ("history".equals(value)) {
                values.remove(value);
            }
        }
        System.out.println(values);

        while (iterator.hasNext()) {
            System.out.println("el: " + iterator.next());
        }
    }
}
