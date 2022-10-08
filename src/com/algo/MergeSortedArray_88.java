package com.algo;

import java.util.Arrays;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };

		// System.out.println(Arrays.toString(nums1));

		merge(nums1, 3, nums2, 3);

		System.out.println(Arrays.toString(nums1));

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1; // end of the array which start putting largest

		/**
		 * Since we know that end of the first arrays has zeros then we can start
		 * putting the element from the end in order to be largest since we know the
		 * both arrays are sorte in nature and largest will be either end of 1st array
		 * to the end of 2nd array
		 */

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {

				nums1[k--] = nums1[i--];

				// OR
				/*
				 * nums1[k] = nums1[i]; i--; k--;
				 */

			} else {

				nums1[k--] = nums2[j--];

				// OR
				/*
				 * nums1[k] = nums2[j]; j--; k--;
				 */
			}
		}

		/**
		 * By now either nums1 has finiesed or num2 has finished.. if num2 has finied
		 * then don't need to anything but since all left in num1 are already in sorted
		 * manner.
		 * 
		 * But if num2 is nit finied that mean these are the largest element left then
		 * copy all num2 elements to num1
		 */
		while (j >= 0) {
			nums1[k] = nums2[j];
			j--;
			k--;
		}
	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {

		int insertPointer = (m--) + (n--) - 1;

		while (n >= 0 && m >= 0) {
			nums1[insertPointer--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		
		while (n >= 0) {
			nums1[insertPointer--] = nums2[n--];
		}
	}

}
