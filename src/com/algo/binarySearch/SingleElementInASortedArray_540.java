package com.algo.binarySearch;

public class SingleElementInASortedArray_540 {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8};

		int result = singleNonDuplicate(arr);
		System.out.print(result);
	}

	public static int singleNonDuplicate(int[] arr) {

		// when only one element
		if (arr.length == 0)
			return arr[0];

		// when first element is the answer
		if (arr[0] != arr[1]) {
			return arr[0];
		}

		// if last element is the answer
		if (arr[arr.length - 1] != arr[arr.length - 2]) {
			return arr[arr.length - 1];
		}

		// if non of the above case : Since the arry is sorted we can apply the binary
		// search

		int low = 0;
		int high = arr.length;

		while (low + 1 < high) {
			int mid = low + (high - low) / 2;

			if (mid % 2 == 0) {
				// mid is even index
				if (arr[mid] == arr[mid + 1]) {
					low = mid;
				} else {
					high = mid;
				}

			} else {
				// mid is odd index
				if (arr[mid] == arr[mid - 1]) {
					low = mid;
				} else {
					high = mid;
				}

			}
		}

		return arr[low + 1];

	}

}
