package org.coursera.algoI.week1;

import java.util.Arrays;

public class WeightedQuickUnion {

	private final int[] id;
	private final int[] size;
	private final int capacity;

	public WeightedQuickUnion(int capacity) {

		id = new int[capacity];
		size = new int[capacity];
		this.capacity = capacity;

		for (int i = 0; i < this.capacity; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	public int find(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public void union(int p, int q) {

		int left = find(p);
		int right = find(q);

		if (size[left] < size[right]) {
			id[left] = right;
			size[right] += size[left]; //size[left]+=size[right] at first, and it's not correct.
		} else {
			id[right] = left;
			size[left] += size[right];//
		}
	}

	public void print() {
		System.out.println(Arrays.toString(id));
		System.out.println(Arrays.toString(size));
	}

	public static void main(String[] args) {
		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		wqu.union(9, 7);
		wqu.union(2, 3);
		wqu.union(7, 3);
		wqu.union(5, 8);
		wqu.union(1, 8);
		wqu.union(5, 4);
		wqu.union(0, 8);
		wqu.union(1, 3);
		wqu.union(7, 6);
		wqu.print();
	}

}
