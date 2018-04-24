package com.pattern.designpattern.factory.newfeature.factory;

import java.util.HashMap;
import java.util.Map;

public class FillCountServiceFactory {

	private static final Integer FIRST_STAGE = 1;
	private static final Integer SECOND_STAGE = 2;
	private static final Integer THIRD_STAGE = 3;
	private static final Integer FORTH_STAGE = 4;
	private static final Integer FIFTH_STAGE = 5;
	private static final Integer SIXTH_STAGE = 6;
	
	private static Map<Integer, FillCountService> fillCountServiceMap = new HashMap<>();

	static {
		fillCountServiceMap.put(FIRST_STAGE, (countRecoder, count) -> countRecoder.setCountOfFirstStage(count));
		fillCountServiceMap.put(SECOND_STAGE, (countRecoder, count) -> countRecoder.setCountOfSecondStage(count));
		fillCountServiceMap.put(THIRD_STAGE, (countRecoder, count) -> countRecoder.setCountOfThirdStage(count));
		fillCountServiceMap.put(FORTH_STAGE, (countRecoder, count) -> countRecoder.setCountOfForthStage(count));
		fillCountServiceMap.put(FIFTH_STAGE, (countRecoder, count) -> countRecoder.setCountOfFifthStage(count));
		fillCountServiceMap.put(SIXTH_STAGE, (countRecoder, count) -> countRecoder.setCountOfSixthStage(count));
	}

	public static FillCountService getFillCountStrategy(int statusCode) {
		return fillCountServiceMap.get(statusCode);
	}

}
