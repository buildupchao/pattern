package com.jangz.pattern.apply.noifelse3;

import java.util.ArrayList;
import java.util.List;

public class Pattern<T> {
	private T t;
	
	private List<Matcher<T>> matches;

	private Pattern(T t) {
		this.t = t;
		matches = new ArrayList<>();
	}
	
	public static <T> Pattern<T> with(T t) {
		return new Pattern<T>(t);
	}
	
	public Pattern<T> matcher(Matcher<T> matcher) {
		matches.add(matcher);
		return this;
	}
	
	public void match() {
		for (Matcher<T> matcher : matches) {
			if (matcher.match(t)) {
				break;
			}
		}
	}
}
