package com.jangz.newfeature.chap3.functioninterface;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);
}
