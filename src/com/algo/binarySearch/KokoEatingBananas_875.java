package com.algo.binarySearch;

public class KokoEatingBananas_875 {

	public int minEatingSpeed(int[] piles, int h) {
		int low = 0;
		int high = Integer.MAX_VALUE;

		while (low + 1 < high) {
			int mid = low + (high - low) / 2;

			if (ok(piles, mid, h)) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return high;
	}

	private boolean ok(int[] arr, int mid, int hours) {
		int totalHours = 0; // IMP

		if (mid == 0) { // IMP
			return false;
		}

		for (int a : arr) {
			totalHours = totalHours + (a + mid - 1) / mid;
		}

		return totalHours <= hours;
	}

}
