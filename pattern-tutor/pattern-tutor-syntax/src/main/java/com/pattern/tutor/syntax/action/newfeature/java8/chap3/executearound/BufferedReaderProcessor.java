package com.pattern.tutor.syntax.action.newfeature.java8.chap3.executearound;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

	String process(BufferedReader in) throws IOException;
}
