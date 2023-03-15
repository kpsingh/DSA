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
		boolean result = canPartition(arr, arr.length, target);
		System.out.println(result);
	}

	/*
	 * Recursive : Brute Force
	 */
	private static boolean canPartition_BF(int[] arr, int n, int target) {

		if (target == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		if (arr[n - 1] <= target) {
			return canPartition_BF(arr, n - 1, target - arr[n - 1]) || canPartition_BF(arr, n - 1, target);
		} else {
			return canPartition_BF(arr, n - 1, target);
		}

	}
	/*
	 * Dynamic Programming
	 */

	private static boolean canPartition(int[] weight, int n, int target) {

		boolean[][] dp = new boolean[n + 1][target + 1];

		for (int i = 0; i < 1; i++) {
			dp[i][0] = true; // if target is ZERO then we can have it in all items i= 1...n
		}

		for (int item = 1; item <= n; item++) {

			for (int capacity = 1; capacity <= target; capacity++) {
				/*
				 * if the value of current item is <= left capacity
				 */
				if (weight[item - 1] <= capacity) {
					dp[item][capacity] = dp[item - 1][capacity] || dp[item - 1][capacity - weight[item - 1]];
				} else {
					// no capacity left so exlude the current item
					dp[item][capacity] = dp[item - 1][capacity];
				}
			}
		}

		return dp[n][target];

	}

}
