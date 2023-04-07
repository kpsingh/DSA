package com.ds.stack.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement_215 {

	public static void main(String[] args) {

		int[] arr = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;

		System.out.println(findKthLargest(arr, k));

	}

	public static int findKthLargest(int[] arr, int k) {

		Queue<Integer> q = new PriorityQueue<>(k);

		
		for (int a : arr) {
			if (q.size() < k) {
				q.add(a);
			} else {
				if (a > q.peek()) {
					q.remove();
					q.add(a);
				}
			}
		}

		return q.peek();

	}
}
