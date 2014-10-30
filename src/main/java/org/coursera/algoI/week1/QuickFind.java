package org.coursera.algoI.week1;

import java.util.Arrays;

public class QuickFind {

	private final int[] id;
	private final int size;

	public QuickFind(int capacity) {
		size = capacity;
		id = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			id[i] = i;
		}
	}

	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(7, 4);
		qf.union(9, 0);
		qf.union(4, 5);
		qf.union(4, 8);
		qf.union(3, 8);
		qf.union(6, 0);
		System.out.println(qf.getId());
	}

	public int find(int i) {
		return id[i];
	}

	public void union(int p, int q) {
		int left = id[p]; //
		int right = id[q]; //
		for (int i = 0; i < size; i++) {
			if (id[i] == left) {
				id[i] = right;
			}
		}
	}

	public String getId() {
		return Arrays.toString(id);
	}
}
