package com.algo.array;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedSortedArray_33 {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;

		int pivot = findPivot(arr);

		int ans = -2;
		if (pivot == -1) {
			// array is not rotated and simple binary search can be done
			ans = binarySearch(arr, target, 0, arr.length - 1);
			System.out.println(ans);
		}

		// pivot has been found and array is rotated. Now 3 cases a.

		// Case 1: pivot element itself is equals to target element

		if (arr[pivot] == target) {
			System.out.println(pivot);
		}

		// Case 2 : target is left part of the pivot
		if (target >= arr[0]) {
			ans = binarySearch(arr, target, 0, pivot - 1);
			System.out.println(ans);
		} else {

			// Case 3: target is right part of the pivot
			ans = binarySearch(arr, target, pivot + 1, arr.length - 1);
			System.out.println(ans);
		}

	}

	/*
	 * Pivot (peak) is the element which is greatest element (if array is rotated)
	 * which divide the array. That is we'll get two sorted array one is (0, pivot)
	 * and other is (pivot+1, n-1).
	 * 
	 * There exist only one element in array at index i such that arr[i] > arr[i+1],
	 * then this element is pivot element. OR arr[i] < arr[i-1]
	 * 
	 * otherwise if no such element then array is not rotated.
	 * 
	 */
	private static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			// (mid < end) : to check to avoid array overflow, i.e mid should <= arr.length
			// -1
			if ((mid < end) && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			// (mid > start) : to avoid array underflow, thst is index should not becomes
			// negative.
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}

			if (arr[mid] >= arr[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		// if no pivot is found
		return -1;
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
