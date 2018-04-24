package com.pattern.designpattern.factory.newfeature.factory;

import com.pattern.designpattern.factory.newfeature.CountRecoder;

@FunctionalInterface
public interface FillCountService {
	void filleCount(CountRecoder countRecoder, int count);
}
