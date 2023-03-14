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

		/*
		 * Here this loop represent items - i represent total number of items available
		 * to pick.. either 1 item, 2 item or max n item
		 */
		for (int i = 1; i <= n; i++) {

			/*
			 * this loop represent the bag capacity - j value represent the present bag's
			 * capacity... from 1 kg to W kg
			 */
			for (int j = 1; j <= W; j++) {
				/*
				 * check if present item's wait wt[i-1] is <= bag's capacity (j)
				 */
				if (wt[i - 1] <= j) {
					/*
					 * choose the max : profit with taking present item and profit without choosing
					 * the present item
					 */

					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);

				} else {
					/*
					 * If present items weight is greater than the present basg't capacity then do
					 * not include this item
					 */

					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][W];

	}

}
