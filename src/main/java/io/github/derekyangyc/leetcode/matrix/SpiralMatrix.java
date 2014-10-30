package io.github.derekyangyc.leetcode.matrix;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpiralMatrix {

	@Test
	public void test() {

		 int[][] test01 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9,
		 10, 11, 12 } };
		int[][] test02 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		int[][] test03 = { { 1, 2 }, { 3, 4 } };
		int[][] test04 = { { 1 } };
		int[][] test05 = { { 1 }, { 2 }, { 3 } };
		int[][] test06 = new int[][] { { 1, 2, 3, }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] test07 = new int[][] { { 1, 2, 3, 4 } };

		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
				spiralOrder(test01));
//		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 8, 7, 6, 5)),
//				spiralOrder(test02));
//		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 4, 3)), spiralOrder(test03));
//		assertEquals(new ArrayList<Integer>(Arrays.asList(1,2,3,4)),
//				spiralOrder(test07));
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		int rowMax = matrix.length - 1;
		int colMax = matrix[0].length - 1;

		int rowMin = 0;
		int colMin = 0;

		int row = 0;
		int col = 0;

		while (true) {

			// top
			while (col < colMax) {
				list.add(matrix[rowMin][col++]);
			}
			if (rowMin++ > rowMax)
				break;

			// right
			while (row < rowMax) {
				list.add(matrix[row++][colMax]);
			}
			if (colMax-- < colMin)
				break;

			// bottom
			while (col > colMin) { // col > 0
				list.add(matrix[rowMax][col--]);
			}
			if (rowMax-- < rowMin)
				break;

			// left
			while (row >= rowMin) { // row > 0
				list.add(matrix[row--][colMin]);
			}
			if (colMin++ > colMax)
				break;

			 col = colMin;
			 row = rowMin;
		}

		return list;
	}
}
