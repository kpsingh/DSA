package com.algo.twopointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		// int[] arr = { 10, 2, 5, 8, 9, 3, 6, 11 };
		// int window = 3;

		// int[] arr = { 1 };
		// int window = 1;

		int[] arr = { 9, 10, 9, -7, -4, -8, 2, -6 };
		int k = 5;

		List<Integer> maxOfSubArrays = getMaxFromSubArrays(arr, k);

		for (int a : maxOfSubArrays) {
			System.out.print(a + " ");
		}
	}

	private static List<Integer> getMaxFromSubArrays(int[] arr, int k) {

		List<Integer> maxOfSubArrays = new ArrayList<>();

		Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());

		int i = 0;
		int j = 0;

		while (j < arr.length) {

			if (j - i + 1 < k) {
				queue.add(arr[j]);
				j++;
			} else {
				queue.add(arr[j]);
				maxOfSubArrays.add(queue.peek());

				if (arr[i] == queue.peek()) {
					queue.remove(arr[i]);
				}

				i++;
				j++;

			}
		}

		int[] result = new int[maxOfSubArrays.size()];

		for (int index = 0; index < result.length; index++) {
			result[index] = maxOfSubArrays.get(index);
		}

		return maxOfSubArrays;
	}

}
