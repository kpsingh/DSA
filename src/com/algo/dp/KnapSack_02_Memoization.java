package com.algo.dp;

public class KnapSack_02_Memoization {

	private static int[][] dp;

	public static void main(String[] args) {

		int capacity = 50; // bag capacity
		int[] profit = { 10, 20, 30, 40 }; // profit array
		int[] weight = { 30, 10, 5, 20 }; // weight array
		int n = weight.length; // number of element left

		dp = new int[n + 1][capacity + 1];

		knapSack(capacity, profit, weight, n);

		System.out.println(dp[n][capacity]);

	}

	private static int knapSack(int capacity, int[] profit, int[] weight, int n) {

		/*
		 * we if have have no capacity left OR we left with no items- then max profit we
		 * can have is ZERO
		 */

		if (capacity == 0 || n == 0) {
			return 0;
		}

		// check if the value for this n and capacity already exists
		if (dp[n][capacity] != 0) {
			return dp[n][capacity];
		}

		int result = 0;

		/*
		 * if weight of current element is greater than the capacity we will not include
		 * it thus returning just the ignoring part.
		 */
		if (weight[n - 1] > capacity) {
			// do not include this item
			result = knapSack(capacity, profit, weight, n - 1);
		} else {
			result = Math.max((profit[n - 1] + knapSack(capacity - weight[n - 1], profit, weight, n - 1)),
					knapSack(capacity, profit, weight, n - 1));
		}

		/*
		 * if weight of current element is less than or equal to capacity we can either
		 * include or exclude the item.
		 */

		dp[n][capacity] = result;

		return dp[n][capacity];

	}

}
