package com.ds.stack.queue.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/next-greater-element-ii/
 */

public class NextGreaterElement_503 {

	public static void main(String[] args) {

		// int[] arr = { 1, 2, 3, 4, 3 };
		// int[] arr = { 1, 2, 1 };

		int[] arr = { 1, 1, 1, 1, 1 };

		int[] ans = nextGreaterElements(arr);

		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

	public static int[] nextGreaterElements(int[] nums) {

		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		int[] nge = new int[nums.length];

		for (int i = 0; i < nums.length * 2; i++) {

			while (!stack.isEmpty() && stack.peek() < nums[i % nums.length]) {

				nge[map.get(stack.pop())] = nums[i % nums.length];

			}

			if (i < nums.length) {
				stack.push(nums[i % nums.length]);
				map.put(nums[i % nums.length], i);
			}

		}

		while (!stack.isEmpty()) {

			nge[map.get(stack.pop())] = -1;

		}

		return nge;

	}
}
