package com.algo.array;

public class BinarySearch_RightBounds {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 2, 3, 4 };

		int rightIndex = right_bound(arr, 3);

		System.out.println("Right Index of target is : " + rightIndex);

	}

	private static int right_bound(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				left = mid + 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else if (arr[mid] > target) {
				right = mid - 1;
			}

		}

		if (right < 0 || arr[right] != target) {
			return -1;
		}

		return right;

	}

}
