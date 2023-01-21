package com.algo.twopointers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizeK_239 {

	public static void main(String[] args) {
		// int[] arr = { 10, 2, 5, 8, 9, 3, 6, 11 };
		// int k = 3;

		// int[] arr = { 1 };
		// int window = 1;

		int[] arr = { 9, 10, 9, -7, -4, -8, 2, -6 };
		int k = 5;

		int[] maxOfSubArrays = getMaxFromSubArrays(arr, k);

		for (int a : maxOfSubArrays) {
			System.out.print(a + " ");
		}
	}

	private static int[] getMaxFromSubArrays(int[] arr, int k) {

		List<Integer> result = new ArrayList<>();

		Deque<Integer> deq = new ArrayDeque<>();
		int i = 0;
		int j = 0;

		while (j < arr.length) {

			if (j - i + 1 < k) {

				while (deq.size() > 0 && deq.peek() < arr[j]) {
					deq.poll();
				}

				deq.offer(arr[j]);
				j++;

			} else {
				// reached at window size

				while (deq.size() > 0 && deq.peek() < arr[j]) {
					deq.poll();
				}

				deq.offer(arr[j]);
				result.add(deq.peek());

				if (deq.peek() == arr[i]) {
					deq.poll();

					while (deq.size() > 0 && deq.peek() < arr[j]) {
						deq.poll();
					}
				}

				i++;
				j++;

			}

		}

		int[] ans = new int[result.size()];

		for (int l = 0; l < ans.length; l++) {
			ans[l] = result.get(l);
		}

		return ans;

	}

}
