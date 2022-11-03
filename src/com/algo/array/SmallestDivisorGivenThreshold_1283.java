package com.algo.array;

public class SmallestDivisorGivenThreshold_1283 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 9 };
		int threshold = 6;

		//System.out.println(Math.ceil(4 / 3));

		int devisor = smallestDivisor(arr, threshold);
		System.out.println(devisor);

	}

	public static int smallestDivisor(int[] arr, int threshold) {
		int low = 1;
		int divisor = 1;
		while (true) {
			int result = 0;
			for (int a : arr) {
				result += (a + low - 1) / low;
			}
			if (result <= threshold) {
				divisor = low;
				break;
			} else {
				low++;
			}
		}
		return divisor;
	}

}
