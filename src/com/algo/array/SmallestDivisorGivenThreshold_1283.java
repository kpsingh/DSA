package com.algo.array;

public class SmallestDivisorGivenThreshold_1283 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 9 };
		int threshold = 6;

		// System.out.println(Math.ceil(4 / 3));

		int devisor = smallestDivisor(arr, threshold);
		System.out.println(devisor);

	}

	public static int smallestDivisor(int[] arr, int threshold) {

		int low = 1;
		int high = (int) 10e6; // 10 ^ 6

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (ok(arr, mid, threshold)) {

				low = mid;

			} else {

				high = mid;
			}
		}
		return high;
	}

	private static boolean ok(int[] arr, int mid, int threshold) {

		int result = 0;

		for (int a : arr) {

			result += (a + mid - 1) / mid;
		}

		return result > threshold;
	}

}
