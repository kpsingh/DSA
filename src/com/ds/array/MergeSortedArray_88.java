package com.ds.array;

public class MergeSortedArray_88 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		merge(nums1, m, nums2, n);

		for (int a : nums1) {
			System.out.print(a + " ");
		}

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int insertPosition = (m--) + (n--) - 1;

		while (m >= 0 && n >= 0) {
			
			nums1[insertPosition--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}

		while (n >= 0) {
			nums1[insertPosition--] = nums2[n--];
		}

	}

}
