package com.pattern.tutor.syntax.test.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.pattern.tutor.syntax.util.SearchFormatterUtil;

public class SearchFormatterUtilTests {

	@Test
	public void testFormat() throws Exception {
		
		List<String> values = Arrays.asList("wps_mini_1_2", "wps_mini", "q_wps_mini_2", "q_wps_mini");
		List<String> targetData = SearchFormatterUtil.format("wps_mini", values, String::valueOf);
		String result = Joiner.on(",").join(targetData);
		System.out.printf("result=[%s]", result);
	}
}
