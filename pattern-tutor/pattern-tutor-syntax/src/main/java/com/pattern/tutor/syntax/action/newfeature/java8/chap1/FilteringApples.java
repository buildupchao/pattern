package com.pattern.tutor.syntax.action.newfeature.java8.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Apple;
import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.AppleFactory;

/**
 * Created by yachao on 17/12/10.
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = AppleFactory.generateInventory();

//        filterGreenApples(inventory).stream().forEach(System.out::println);

//        filterHeavyApples(inventory).stream().forEach(System.out::println);

//        filterApples(inventory, FilteringApples::isGreenApple).stream().forEach(System.out::println);

//        filterApples(inventory, FilteringApples::isHeavyApple).stream().forEach(System.out::println);

//        filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor())).stream().forEach(System.out::println);

//        filterApples(inventory, (Apple apple) -> apple.getWeight() > 150).stream().forEach(System.out::println);

        filterApples(inventory, (Apple apple) -> "brown".equals(apple.getColor()) || apple.getWeight() <= 80).stream().forEach(System.out::println);;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
