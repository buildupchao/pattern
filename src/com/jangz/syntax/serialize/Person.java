package com.jangz.syntax.serialize;

import java.io.Serializable;

/**
 * Created by yachao on 17/12/4.
 */
public class Person implements Serializable {

    private String name;
    private Integer age;
    transient private Character sex;
    private static String address;

    public Person() {
    }

    public Person(String name, Integer age, Character sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Person.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
