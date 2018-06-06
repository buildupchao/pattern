package com.pattern.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class RequestUtils {

	/**
	 * So as to resolve the problem that cannot deliver too large data into get
	 * request.
	 */
	public static List<List<?>> splitList(List<?> list, int len) {
		if (CollectionUtils.isEmpty(list))
			return new ArrayList<List<?>>(0);

		int size = list.size();
		int count = (size + len - 1) / len;
		List<List<?>> result = new ArrayList<List<?>>(count);
		for (int i = 0; i < count; i++) {
			List<?> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}

	public static <T> Map<T, Boolean> transform(List<T> list) {
		if (CollectionUtils.isEmpty(list))
			return new HashMap<>(0);
		Boolean empty = Boolean.TRUE;
		Map<T, Boolean> result = new HashMap<>(list.size());
		for (T t : list) {
			result.put(t, empty);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> Map<T, Boolean> transform(T... args) {
		if (ArrayUtils.isEmpty(args))
			return new HashMap<>(0);
		Boolean empty = Boolean.TRUE;
		Map<T, Boolean> result = new HashMap<>(args.length);
		for (T t : args) {
			result.put(t, empty);
		}
		return result;
	}
}
