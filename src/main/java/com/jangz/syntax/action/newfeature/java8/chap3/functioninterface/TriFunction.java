package com.jangz.syntax.action.newfeature.java8.chap3.functioninterface;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);
}
