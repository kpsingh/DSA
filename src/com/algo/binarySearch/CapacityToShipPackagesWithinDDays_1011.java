package com.algo.binarySearch;

public class CapacityToShipPackagesWithinDDays_1011 {

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr = { 1, 2, 3, 1, 1 };
		int days = 4;

		int result = shipWithinDays(arr, days);
		System.out.println("Min Capacity : " + result);
	}

	public static int shipWithinDays(int[] arr, int days) {
		int low = 0;
		int high = Integer.MAX_VALUE;

		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (okay(arr, mid, days)) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return high;
	}

	private static boolean okay(int[] arr, int capacity, int days) {
		int reqDays = 1;
		int capacityCurr = capacity;
		for (int a : arr) {

			if (a > capacity) {
				return false;
			}
			if (capacityCurr >= a) {
				capacityCurr = capacityCurr - a;
			} else {
				reqDays++;
				capacityCurr = capacity;
				capacityCurr = capacityCurr - a;
			}
		}
		return reqDays <= days;
	}

}
