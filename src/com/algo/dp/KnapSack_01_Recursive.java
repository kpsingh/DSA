package com.algo.dp;

/*
 * A recursive implementation of 0/1 knapsack
 */
public class KnapSack_01_Recursive {

	public static void main(String[] args) {

		int capacity = 40; // bag capacity
		int[] profit = { 10, 20, 33, 40 }; // profit array
		int[] weight = { 30, 10, 40, 20 }; // weight array
		int n = weight.length; // number of element left

		int maxProfit = knapSack(capacity, profit, weight, n);

		System.out.println(maxProfit);

	}

	private static int knapSack(int capacity, int[] profit, int[] weight, int n) {

		/*
		 * we if have have no capacity left OR we left with no items- then max profit we
		 * can have is ZERO
		 */

		if (capacity == 0 || n == 0) {
			return 0;
		}

		/*
		 * if weight of current element is greater than the capacity we will not include
		 * it thus returning just the ignoring part.
		 */
		if (weight[n - 1] > capacity) {
			// do not include this item
			return knapSack(capacity, profit, weight, n - 1);
		}

		/*
		 * if weight of current element is less than or equal to capacity we can either
		 * include or exclude the item.
		 */

		return Math.max((profit[n - 1] + knapSack(capacity - weight[n - 1], profit, weight, n - 1)),
				knapSack(capacity, profit, weight, n - 1));

	}

}
