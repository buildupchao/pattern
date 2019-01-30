package com.pattern.codingthinking.adviceoof;

/**
 * @author buildupchao
 *         Date: 2019/1/30 21:02
 * @since JDK 1.8
 */
public class DoNotLetNullOrEmptyValueAffectVariableParamMethod {

    public void variableParamMethod(String str, Integer... args) {}

    public void variableParamMethod(String str, String... args) {}

    public static void main(String[] args) {
        DoNotLetNullOrEmptyValueAffectVariableParamMethod obj = new DoNotLetNullOrEmptyValueAffectVariableParamMethod();
        obj.variableParamMethod("test_case", 0);

        // these codes cannot pass compiler.
//        obj.variableParamMethod("test_case");
//        obj.intVariableParamMethod("test_case", "confuse-params");
//        obj.variableParamMethod("test_case", null);
    }
}
