package com.algo;

import java.util.PriorityQueue;
import java.util.Queue;

public class findKthLargest_215 {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		int result = findKthLargest(arr, k);
		System.out.println(result);

	}

	public static int findKthLargest(int[] nums, int k) {

		Queue<Integer> queue = new PriorityQueue<>(); // default min heap

		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (queue.peek() < nums[i]) {
				queue.remove();
				queue.add(nums[i]);
			}
		}

		return queue.peek();

	}

}
