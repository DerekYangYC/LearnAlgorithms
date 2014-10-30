package io.github.derekyangyc.leetcode.coordinate;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UniquePaths {

	@Test
	public void test() {
		assertEquals(0, uniquePaths(0, 0));
	}
	
	
	//Use dp
	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0) {
			return 0;
		}

		int[][] paths = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 || j == 0) {
					paths[i][j] = 1;
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}

			}
		}

		return paths[m - 1][n - 1];
	}
	
	//Use Recursion
	public int uniquePaths2(int m, int n) {

		if (m <= 0 || n <= 0)
			return 0;

		return cal(m - 1, n - 1);

	}
	public int cal(int i, int j) {
		if (i == 0 || j == 0) {
			return 1;
		} else {
			return cal(i - 1, j) + cal(i, j - 1);
		}
	}

}
