package com.algo.dp;

public class CountSubsetsSumEqualK {

	private static int count = 0;

	public static void main(String[] args) {

		// int[] arr = { 1, 2, 3, 3 };
		int[] arr = { 2, 3, 5, 6, 8, 10 };
		int k = 10;
		countSubsetsSumEqualK_BF(arr, arr.length, k);
		System.out.println("BF:" + count);
		countSubsetsSumEqualK(arr, arr.length, k);
		System.out.println("DP:" + count);
	}

	/*
	 * Brute Force - Recursion
	 */
	private static void countSubsetsSumEqualK_BF(int[] arr, int n, int target) {

		if (target == 0) {
			count++;
			return;
		}

		if (n == 0) {
			return;
		}

		if (arr[n - 1] <= target) {

			countSubsetsSumEqualK_BF(arr, n - 1, target - arr[n - 1]);

			countSubsetsSumEqualK_BF(arr, n - 1, target);

		} else {
			countSubsetsSumEqualK_BF(arr, n - 1, target);
		}

	}

	/*
	 * DP - Bottom Up
	 */
	
	private static void countSubsetsSumEqualK(int[] arr, int n, int sum) {

		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {

			dp[i][0] = 1;// if target is zero - it can be achieved by all elements. not picking anything
		}

		for (int item = 1; item <= n; item++) {

			for (int target = 1; target <= sum; target++) {

				if (arr[item - 1] <= target) {

					dp[item][target] = dp[item - 1][target - arr[n - 1]] + dp[item - 1][target];

				} else {
					dp[item][target] = dp[item - 1][target];
				}
			}
		}

		count = dp[n][sum];

	}

}
