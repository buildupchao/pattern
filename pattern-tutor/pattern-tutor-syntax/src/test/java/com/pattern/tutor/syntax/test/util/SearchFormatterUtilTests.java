package com.pattern.tutor.syntax.test.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.pattern.tutor.syntax.util.SearchFormatterUtil;

public class SearchFormatterUtilTests {

	@Test
	public void testFormat() throws Exception {
		
		List<String> values = Arrays.asList("oo_mini_1_2", "oo_mini", "q_oo_mini_2", "q_oo_mini");
		List<String> targetData = SearchFormatterUtil.format("oo_mini", values, String::valueOf);
		String result = Joiner.on(",").join(targetData);
		System.out.printf("result=[%s]", result);
	}
}
