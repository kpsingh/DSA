package com.algo.dp;

public class SubsetSumProblem {

	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 3, 2, 2 };

		int target = 12;

		boolean result = subsetSum_BruteForce(arr, arr.length, target);

		System.out.println("BF : " + result);

		boolean result_dp = subsetSum(arr, arr.length, target);

		System.out.println("DP : " + result_dp);

	}

	/**
	 * Brute Force Approach
	 */

	private static boolean subsetSum_BruteForce(int[] arr, int n, int target) {

		if (target == 0) {

			return true;
		}

		if (n == 0) {
			return false;
		}

		return subsetSum_BruteForce(arr, n - 1, target - arr[n - 1]) || subsetSum_BruteForce(arr, n - 1, target);
	}

	/**
	 * Dynamic Programing - Bottom Up
	 */

	private static boolean subsetSum(int[] arr, int n, int target) {

		boolean[][] dp = new boolean[n + 1][target + 1];

		/*
		 * initialization with base case
		 * 
		 * i - number of object , j - target sum
		 */

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 1; j++) {
				dp[i][j] = true;
			}
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= target; j++) {

				// value/ weight of current object arr[i-1] is less than target (j)
				if (arr[i - 1] <= j) {

					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];

				} else {

					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][target];

	}

}
