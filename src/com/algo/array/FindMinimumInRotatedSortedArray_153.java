package com.algo.array;

public class FindMinimumInRotatedSortedArray_153 {

	public int findMin(int[] arr) {

		int low = 0;
		int high = arr.length;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (isOkay(arr, mid)) {

				low = mid;

			} else {

				high = mid;
			}

		}
		return arr[(low + 1) % arr.length];
	}

	private boolean isOkay(int[] arr, int mid) {

		return arr[mid] > arr[mid - 1] && arr[mid] > arr[0];
	}
}
