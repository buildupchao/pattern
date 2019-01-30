package com.pattern.codingthinking.adviceoof;

/**
 * @author buildupchao
 *         Date: 2019/1/30 21:12
 * @since JDK 1.8
 */
public class PlsCareForOverrideVariableParamMethod {

    static class Parent {
        void func(int first, int... others) {
            System.out.printf("Call Parent function 'func'\n");
        }
    }

    static class Child extends Parent {
        @Override
        void func(int first, int[] others) {
            System.out.printf("Call Child function 'func'\n");
        }
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.func(100, 200);

        Child child = new Child();
        /**
         * This code will generate a compile error.
         */
//        child.func(100, 200);
    }
}
