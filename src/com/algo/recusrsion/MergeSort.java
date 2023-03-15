package com.algo.recusrsion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { -2, 3, -5 };
		arr = sortArray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] sortArray(int[] arr, int start, int end) {

		if (start == end) {
			// single element by default is sorted
			return new int[] { arr[start] };
		}

		int mid = start + (end - start) / 2;

		int[] left = sortArray(arr, start, mid);
		int[] right = sortArray(arr, mid + 1, end);

		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {
		// if either of them null OR both of them null
		if (left.length == 0 || right.length == 0) {
			return left.length != 0 ? left : right;
		}
		// if non of them is null

		int l = 0;
		int r = 0;
		int k = 0;

		int[] res = new int[left.length + right.length];

		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				res[k++] = left[l++];
			} else {
				res[k++] = right[r++];
			}
		}

		while (l < left.length) {
			res[k++] = left[l++];
		}

		while (r < right.length) {
			res[k++] = right[r++];
		}
		return res;

	}

}
