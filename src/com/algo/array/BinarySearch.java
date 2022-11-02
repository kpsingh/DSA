package com.algo.array;

/*
 * 
 * https://www.youtube.com/watch?v=Do95Apr9Ldc
 * 
 * https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/detailedbinarysearch
 */

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 6, 6, 6, 15, 17, 23, 34, 45, 56, 78, 89 };

		System.out.println("Normal (default left bound) : " + binary_search_temmplate3(arr, 6));
		System.out.println("Left Bound : " + left_bound_temmplate3(arr, 6));
		System.out.println("Right Bound : " + right_bound_temmplate3(arr, 6));

		// template 4
		System.out.println("Template 4 (default left bound)  : " + binary_search_temmplate4(arr, 6));
	}

	/**
	 * 
	 * Template - 3 - START
	 */

	public static int binary_search_temmplate3(int[] arr, int target) {
		// default it is left bound because of Integer division.

		int low = 0;
		int high = arr.length - 1;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] < target) {
				low = mid;
			} else {
				high = mid; // high has 2 responsibility : " > " and " = "
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

			if (arr[mid] < target) { // "<"
				low = mid;
			} else {
				high = mid; // high has 2 responsibility : " > " and " = "
			}

		}

		if (arr[low] == target) { // 1st check the left
			return low;
		}
		if (arr[high] == target) { // then right
			return high;
		}

		return -1;

	}

	public static int right_bound_temmplate3(int[] arr, int target) {

		int low = 0;
		int high = arr.length - 1;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] <= target) { // "<="
				low = mid;
			} else {
				high = mid; // // high has 1 responsibility " > "
			}

		}

		if (arr[high] == target) { // 1st check the right
			return high;
		}

		if (arr[low] == target) { // then left
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

		int low = 0; // assuming this will point to possibly correct search element if any
		int high = arr.length; // this will always points to false element (starting with invalid index)

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (isOK(arr, mid, target)) {
				low = mid; // more responsibility to low
			} else {
				high = mid;
			}
		}

		return arr[low] == target ? low : -1;

	}

	private static boolean isOK(int[] arr, int mid, int target) {
		return arr[mid] <= target;
	}

	/**
	 * 
	 * Template - 4 - END
	 */

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