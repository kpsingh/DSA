package com.algo.dp;

import java.util.stream.IntStream;

public class PartitionEqualSubsetSum_416 {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 11, 5, 2 };

		int sumTotal = IntStream.of(arr).reduce(Integer::sum).getAsInt();

		if (sumTotal % 2 != 0) {
			System.out.println(false);
			return;
		}

		int target = sumTotal / 2;
		boolean result = partisionSum(arr, arr.length, target);
		System.out.println(result);
	}

	/*
	 * Recursive : Brute Force
	 */
	private static boolean partisionSum(int[] arr, int n, int target) {

		if (target == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		if (arr[n - 1] <= target) {
			return partisionSum(arr, n - 1, target - arr[n - 1]) || partisionSum(arr, n - 1, target);
		} else {
			return partisionSum(arr, n - 1, target);
		}

	}

}
