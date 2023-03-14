package com.algo.dp;

public class SubsetSumProblem {

	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 3, 2, 2 };
		int target = 1;

		boolean result = subsetSum_BruteForce(arr, arr.length, target);

		System.out.println(result);

	}

	private static boolean subsetSum_BruteForce(int[] arr, int n, int target) {

		if (target == 0) {
			return true;
		}

		if (n == 0) {
			return false;
		}

		return subsetSum_BruteForce(arr, n - 1, target - arr[n - 1]) || subsetSum_BruteForce(arr, n - 1, target);
	}

}
