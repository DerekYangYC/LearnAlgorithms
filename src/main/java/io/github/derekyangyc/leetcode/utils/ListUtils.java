package io.github.derekyangyc.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

	public static <T> List<T> asList(T... items) {
		List<T> list = new ArrayList<T>();
		for (T item : items) {
			list.add(item);
		}
		return list;
	}

}
