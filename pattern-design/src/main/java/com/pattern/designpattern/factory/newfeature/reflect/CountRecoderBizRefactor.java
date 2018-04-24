package com.pattern.designpattern.factory.newfeature.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pattern.designpattern.factory.newfeature.CountEntry;
import com.pattern.designpattern.factory.newfeature.CountRecoder;

/**
 * Code refactor for CountRecoderBiz
 * 
 * @see
 *
 * @author jangz
 * @since
 */
public class CountRecoderBizRefactor {
	
	private static Map<Integer, String> methodMap = new HashMap<>();
	
	static {
		methodMap.put(1, "setCountOfFirstStage");
		methodMap.put(2, "setCountOfSecondStage");
		methodMap.put(3, "setCountOfThirdStage");
		methodMap.put(4, "setCountOfForthStage");
		methodMap.put(5, "setCountOfFifthStage");
		methodMap.put(6, "setCountOfSixthStage");
	}
	
	public CountRecoder getCountRecoderByReflect(List<CountEntry> countEntries) {
		CountRecoder countRecoder = new CountRecoder();
		countEntries.stream().forEach(countEntry -> fillCount(countRecoder, countEntry));
		return countRecoder;
	}
	
	private void fillCount(CountRecoder shippingOrderCountDto, CountEntry countEntry) {
		String name = methodMap.get(countEntry.getCode());
		try {
			Method declaredMethod = CountRecoder.class.getMethod(name, Integer.class);
			declaredMethod.invoke(shippingOrderCountDto, countEntry.getCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
