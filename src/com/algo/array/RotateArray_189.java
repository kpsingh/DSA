package com.algo.array;

public class RotateArray_189 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate_V2(nums, k);

		for (int a : nums) {
			System.out.print(a + " ");
		}

	}

	public static void rotate(int[] nums, int k) {

		/**
		 * this approach will take the O(n) for time and O(n) for space complexity.
		 * 
		 * However, next step is to do it without taking the extra space that is in O(1)
		 * space complexity.
		 */

		int size = nums.length;
		k = k % size;

		int[] temp = new int[size];

		for (int i = 0; i < size; i++) {
			temp[(i + k) % size] = nums[i];
		}

		for (int i = 0; i < size; i++) {
			nums[i] = temp[i];
		}

	}

	public static void rotate_V2(int[] nums, int k) {

		/**
		 * 5,6,7,1,2,3,4]
		 * 
		 * This is in place reversal , we are not taking any extra space over here.
		 * 
		 * 1. Reverse the input array, 2. reverse the first k element 3. reverse the
		 * last n-k element 4. array after reversal is the answer.
		 */

		int size = nums.length;
		k = k % size;

		reverse(nums, 0, size - 1); // reverse the initial array.

		reverse(nums, 0, k - 1); // reverse the first k element
		reverse(nums, k , size - 1); // reverse the remaining n-k element

	}

	private static void reverse(int[] nums, int start, int end) {

		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end --;
		}
	}
}
