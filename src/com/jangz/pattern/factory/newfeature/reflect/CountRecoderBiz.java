package com.jangz.pattern.factory.newfeature.reflect;

import java.util.List;

import com.jangz.pattern.factory.newfeature.CountEntry;
import com.jangz.pattern.factory.newfeature.CountRecoder;

public class CountRecoderBiz {

	public CountRecoder getCountRecoder(List<CountEntry> countEntries) {
		CountRecoder countRecoder = new CountRecoder();
		for (CountEntry countEntry : countEntries) {
			if (1 == countEntry.getCode()) {
				countRecoder.setCountOfFirstStage(countEntry.getCount());
			} else if (2 == countEntry.getCode()) {
				countRecoder.setCountOfSecondStage(countEntry.getCount());
			} else if (3 == countEntry.getCode()) {
				countRecoder.setCountOfThirdStage(countEntry.getCount());
			} else if (4 == countEntry.getCode()) {
				countRecoder.setCountOfForthStage(countEntry.getCount());
			} else if (5 == countEntry.getCode()) {
				countRecoder.setCountOfFifthStage(countEntry.getCount());
			} else if (6 == countEntry.getCode()) {
				countRecoder.setCountOfSixthStage(countEntry.getCount());
			}
		}
		return countRecoder;
	}
}
