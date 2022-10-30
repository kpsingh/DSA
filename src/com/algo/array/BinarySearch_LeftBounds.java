package com.algo.array;

public class BinarySearch_LeftBounds {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 3, 4 };

		int leftIndex = left_bound(arr, 3);

		System.out.println("Left Index of target is : " + leftIndex);

	}

	private static int left_bound(int[] arr, int target) {

		int left = 0, right = arr.length - 1;

		// search interval is [left, right]
		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (arr[mid] < target) {

				// search interval is [mid+1, right]
				left = mid + 1;

			} else if (arr[mid] > target) {

				// search interval is [left, mid-1]
				right = mid - 1;

			} else if (arr[mid] == target) {

				// shrink right border
				right = mid - 1;
			}
		}

		// check out of bounds
		if (left >= arr.length || arr[left] != target)

			return -1;
		return left;

	}

}
