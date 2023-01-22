package com.algo.slidingwindow;

public class LargestSubarrayOfSumK {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 1, 1, 2, 3 };
		int k = 5; // target sum

		int result = findLargestSubarrayOfSumK(arr, k);
		System.out.println("Max subarray : " + result);

	}

	private static int findLargestSubarrayOfSumK(int[] arr, int k) {
		if (arr.length == 0) {
			return 0;
		}
		int count = 0;
		int sum = 0;
		int i = 0;
		int j = 0;

		while (j < arr.length) {

			sum = sum + arr[j];

			if (sum < k) {
				j++;
			} else if (sum == k) {
				count++;
				j++;
			} else if (sum > k) {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
				}

				if (count != 0 && sum == k) {
					count++;
				}
				j++;
			}
		}

		return count;
	}

}
