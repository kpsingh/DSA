package com.algo;

import java.util.Arrays;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		System.out.println(Arrays.toString(nums1));

		merge(nums1, nums1.length, nums2, nums2.length);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int[] temp = new int[m];

		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {

			if (nums1[i] < nums2[j]) {
				temp[k] = nums1[i];
				i++;
				k++;
			} else {
				temp[k] = nums2[j];
				j++;
				k++;
			}
		}

		Arrays.toString(temp);

	}
}
