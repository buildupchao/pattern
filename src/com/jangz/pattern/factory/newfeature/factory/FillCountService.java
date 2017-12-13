package com.jangz.pattern.factory.newfeature.factory;

import com.jangz.pattern.factory.newfeature.CountRecoder;

@FunctionalInterface
public interface FillCountService {
	void filleCount(CountRecoder countRecoder, int count);
}
