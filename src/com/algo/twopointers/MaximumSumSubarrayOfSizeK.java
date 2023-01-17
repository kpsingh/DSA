package com.algo.twopointers;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumSubarrayOfSizeK {

	// brute force approach

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 6, 7, 8, 9, 5, 4 };
		int w = 3; // window size

		int maxSum = getMaxSum(arr, w);
		System.out.println(maxSum);

	}

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
