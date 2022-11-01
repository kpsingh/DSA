package com.algo.array;

/*
 * https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/detailedbinarysearch
 */

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 6, 6, 6, 15, 17, 23, 34, 45, 56, 78, 89 };
		int key = 6;

		System.out.println(binary_search_temmplate3(arr, 17));
		System.out.println(left_bound_temmplate3(arr, 6));
		System.out.println(right_bound_temmplate3(arr, 6));
		// System.out.println(recursiveBinarySearch(arr, key, 0, arr.length - 1));

	}

	/**
	 * 
	 * Template - 3 - END
	 */

	public static int binary_search_temmplate3(int[] arr, int target) {

		int low = 0;
		int high = arr.length - 1;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] < target) {
				low = mid;
			} else {
				high = mid;
			}
		}

		if (arr[low] != target && arr[high] != target) {
			return -1;
		}

		return arr[low] == target ? low : high;

	}

	public static int left_bound_temmplate3(int[] arr, int target) {

		int low = 0;
		int high = arr.length - 1;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] < target) {
				low = mid;
			} else {
				high = mid;
			}
		}

		if (arr[low] == target) {
			return low;
		}
		if (arr[high] == target) {
			return high;
		}

		return -1;

	}

	public static int right_bound_temmplate3(int[] arr, int target) {

		int low = 0;
		int high = arr.length - 1;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] < target) {
				low = mid;
			} else {
				high = mid;
			}
		}

		if (arr[high] == target) {
			return high;
		}

		if (arr[low] == target) {
			return low;
		}

		return -1;

	}

	/**
	 * 
	 * Template - 3 - END
	 */

	/**
	 * 
	 * Template - 4 - Start
	 */

	public static int binary_search_temmplate4(int[] arr, int target) {

		int low = 0;
		int high = arr.length - 1;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] < target) {
				low = mid;
			} else {
				high = mid;
			}
		}

		if (arr[low] != target && arr[high] != target) {
			return -1;
		}

		return arr[low] == target ? low : high;

	}

	/**
	 * 
	 * Template - General
	 */

	public static int binary_search(int[] arr, int target) {

		int left = 0, right = arr.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;// to avoid number out of range

			if (arr[mid] < target) {

				left = mid + 1;

			} else if (arr[mid] > target) {

				right = mid - 1;

			} else if (arr[mid] == target) {

				// Return directly
				return mid;
			}
		}

		// Return directly
		return -1;
	}

	static int left_bound(int[] arr, int target) {

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

	static int right_bound(int[] nums, int target) {

		int left = 0, right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (nums[mid] < target) {

				left = mid + 1;

			} else if (nums[mid] > target) {

				right = mid - 1;

			} else if (nums[mid] == target) {

				// Don't return! Lock right border
				left = mid + 1;
			}
		}

		// Check whether right border out of bounds lastly
		if (right < 0 || nums[right] != target)
			return -1;

		return right;
	}

	public static int recursiveBinarySearch(int[] arr, int key, int start, int end) {

		if (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				return recursiveBinarySearch(arr, key, mid + 1, end);
			else
				return recursiveBinarySearch(arr, key, start, mid - 1);
		}
		return -1;
	}

}