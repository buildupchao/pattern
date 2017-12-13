package com.jangz.pattern.factory.newfeature.factory;

import java.util.List;

import com.jangz.pattern.factory.newfeature.CountEntry;
import com.jangz.pattern.factory.newfeature.CountRecoder;

public class CountRecoderBizNewRefactor {

	public CountRecoder getCountRecoder(List<CountEntry> countEntries) {
		CountRecoder countRecoder = new CountRecoder();
		countEntries.stream().forEach(countEntry -> FillCountServiceFactory.getFillCountStrategy(countEntry.getCode())
				.filleCount(countRecoder, countEntry.getCount()));
		return countRecoder;
	}
}
