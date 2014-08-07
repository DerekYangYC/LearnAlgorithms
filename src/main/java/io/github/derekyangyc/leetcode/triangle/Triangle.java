package io.github.derekyangyc.leetcode.triangle;

import static io.github.derekyangyc.leetcode.utils.ListUtils.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Triangle {

	@Test
	@SuppressWarnings("unchecked")
	public void test() {
		List<List<Integer>> test01 = asList(asList(2), asList(3, 4), asList(6, 5, 7),
				asList(4, 1, 8, 3));
		List<List<Integer>> test02 = asList(asList(2), asList(3, 4), asList(6, 5, 2),
				asList(1, 5, 8, 3));

		assertEquals(11, minimumTotalWithDP(test01));
		assertEquals(11, minimumTotalWithDP(test02));
	}

	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int[] tmpMin = new int[triangle.size()];
		// add another array to cache the previous sum value
		int[] tmp = new int[triangle.size()];

		for (int k = 0; k < triangle.size(); k++) {

			List<Integer> list = triangle.get(k);

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					tmpMin[i] += list.get(i);
				} else if (i == list.size() - 1) {
					tmpMin[i] = list.get(i) + tmp[i - 1];
				} else {
					tmpMin[i] = list.get(i) + Math.min(tmp[i - 1], tmp[i]);
				}
			}
			
			//let tmp became the last calculation result
			for (int i = 0; i < list.size() && k != triangle.size() - 1; i++) {
				tmp[i] = tmpMin[i];
			}

		}

		int min = tmpMin[0];
		for (Integer i : tmpMin) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	public int minimumTotalWithDP(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		Integer[] min = triangle.get(triangle.size() - 1).toArray(new Integer[triangle.size()]);

		for (int i = triangle.size() - 2; i >= 0; i--) {

			for (int j = 0; j < triangle.get(i).size(); j++) {

				min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);

			}

		}

		return min[0];
	}

	public int minimumTotalWithDP2(List<List<Integer>> triangle) {

		for (int i = triangle.size() - 2; i >= 0; i--) {

			for (int j = 0; j < triangle.get(i).size(); j++) {

				triangle.get(i).set(
						j,
						Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))
								+ triangle.get(i).get(j));

			}

		}

		return triangle.get(0).get(0);
	}
}
