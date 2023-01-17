package com.algo.twopointers;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumSubarrayOfSizeK {

	// brute force approach

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 6, 7, 8, 9, 5, 4, 20, 20 };
		int w = 3; // window size

		int maxSum = getMaxSum(arr, w);
		System.out.println(maxSum);
		System.out.println("getMaxSum_2 : " + getMaxSum_2(arr, w));

		System.out.println("getMaxSum_3 : " + getMaxSum_3(arr, w));

	}

	// approach 3
	private static int getMaxSum_3(int[] arr, int w) {

		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;

		while (j < arr.length) {

			sum += arr[j];

			if (j - i == w) {
				
				sum = sum - arr[i];
				
				max = Math.max(max, sum);
				i++;
				j++;

			} else {
				j++;
			}
		}

		return max;

	}

	// approach 2
	private static int getMaxSum_2(int[] arr, int w) {

		if (arr.length < w) {
			return -1; // not possible
		}

		int result = 0;
		int i = 0, j = 0;

		for (; j < w; j++) {
			result += arr[j];
		}

		while (j < arr.length) {
			result = Math.max(result, result + arr[j] - arr[i]);
			i++;
			j++;
		}

		return result;
	}

	// approach 1
	private static int getMaxSum(int[] arr, int w) {
		if (arr.length < w) {
			return -1; // not possible
		}

		List<List<Integer>> list = new ArrayList<>();

		int result = 0;

		for (int i = 0; i < arr.length; i++) {

			if (i + w <= arr.length) {

				List<Integer> subset = new ArrayList<>();

				for (int j = 0; j < w; j++) {
					int a = arr[i + j];
					subset.add(a);

				}
				list.add(subset);
			}
		}

		System.out.println(list);

		for (List<Integer> l : list) {

			int sum = 0;

			for (int a : l) {

				sum = sum + a;
			}

			if (sum > result) {
				result = sum;
			}
		}

		return result;
	}
}
