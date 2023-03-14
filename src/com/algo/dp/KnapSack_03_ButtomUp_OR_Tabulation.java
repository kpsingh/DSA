package com.algo.dp;

public class KnapSack_03_ButtomUp_OR_Tabulation {

	public static void main(String[] args) {

		int capacity = 50; // bag capacity
		int[] profit = { 10, 20, 30, 40 }; // profit array
		int[] weight = { 30, 10, 5, 20 }; // weight array
		int n = weight.length; // number of element left

		int result = knapSack(capacity, weight, profit, n);
		System.out.println(result);

	}

	static int knapSack(int W, int wt[], int val[], int n) {
		int[][] dp = new int[n + 1][W + 1];

		for (int i = 1; i <= n; i++) { // loop for items, starting from 1 items till all n items
			for (int j = 1; j <= W; j++) // loop for capacity..starting from 1 capacity till W
			{
				if (wt[i - 1] <= j) {
					// either we can choose the item or ignore two choces.. max of both will be
					// taken into final consideration

					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);

				} else {
					// with this capacity and wait, nothing can be selected, don't select the item
					dp[i][j] = dp[i - 1][j]; // max profit with wait "j" with out choosing the item 'i'
				}
			}
		}

		return dp[n][W];

	}

}
