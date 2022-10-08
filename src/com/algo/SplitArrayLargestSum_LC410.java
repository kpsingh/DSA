package com.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum_LC410 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int m = 2;
		int minimalLargestSum = findSum(arr);
	}

	private static int findSum(int[] arr) {
		int N = 0;

		List<Integer> maxSumList = new ArrayList<>();

		while (N < arr.length - 1) {
			int sum1 = 0;
			int sum2 = 0;

			for (int i = 0; i <= N; i++) {
				sum1 = sum1 + arr[i];
			}
			for (int i = N + 1; i < arr.length; i++) {
				sum2 = sum2 + arr[i];
			}
			if (sum1 > sum2) {
				maxSumList.add(sum1);
			} else {
				maxSumList.add(sum2);
			}
			N++;

		}

		System.out.println(maxSumList);

		return -1;
	}

}
