package com.algo.binarySearch;

public class KokoEatingBananas_875 {

	public int minEatingSpeed(int[] arr, int h) {
		int low = 0;
		int high = Integer.MAX_VALUE;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (okay(arr, mid, h)) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return high;
	}

	private boolean okay(int[] arr, int mid, int hours) {
		int result = 0;
		for (int a : arr) {
			result += (a + mid - 1) / mid;
		}

		return result <= hours;
	}

}
