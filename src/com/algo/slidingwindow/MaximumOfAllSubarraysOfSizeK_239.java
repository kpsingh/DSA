package com.algo.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizeK_239 {

	public static void main(String[] args) {
		// int[] arr = { 10, 2, 5, 8, 9, 3, 6};
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

		if (arr.length < k || arr.length == 0)
			return new int[0];

		ArrayList<Integer> result = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();

		int i = 0;
		int j = 0;

		while (j < arr.length) {

			if (j - i + 1 < k) {
				// window size < k

				while (deque.size() > 0 && deque.peekLast() < arr[j]) { // deque.peekLast() < arr[j] :: "<" or "<=" very
																		// IMP
					deque.pollLast();
				}
				deque.offerLast(arr[j]);
				j++;

			} else {

				// window size == k

				while (deque.size() > 0 && deque.peekLast() < arr[j]) { // deque.peekLast() < arr[j] :: "<" or "<=" very
																		// IMP
					deque.pollLast();
				}
				deque.offerLast(arr[j]);

				result.add(deque.peekFirst());

				if (arr[i] == deque.peekFirst()) {
					deque.pollFirst();
				}

				i++;
				j++;

			}
		}

		int[] ans = new int[result.size()];

		for (i = 0; i < ans.length; i++) {
			ans[i] = result.get(i);
		}

		return ans;
	}

}
