package com.ds.stack.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/next-greater-element-i/
 */

public class NextGreaterElement_496 {

	public static void main(String[] args) {

		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };

		int[] ans = nextGreaterElement(nums1, nums2);

		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Map<Integer, Integer> nextGreatedMap = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		for (int num : nums2) {

			while (!stack.isEmpty() && num > stack.peek()) {
				nextGreatedMap.put(stack.pop(), num);
			}

			stack.push(num);
		}

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = nextGreatedMap.getOrDefault(nums1[i], -1);
		}

		return nums1;

	}
}
