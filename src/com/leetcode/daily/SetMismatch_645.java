package com.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch_645 {

	// V1
	public int[] findErrorNums_V1(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		int[] ans = new int[2];

		for (int i : nums) {
			map.merge(i, 1, (v1, v2) -> v1 + v2);
		}

		for (int key = 1; key <= nums.length; key++) {

			int val = map.getOrDefault(key, 0);

			if (val == 2) {
				ans[0] = key;
			}
			if (val == 0) {
				ans[1] = key;
			}
		}
		return ans;
	}

	// V2

	public int[] findErrorNums_V2(int[] nums) {

		int[] arr = new int[nums.length + 1];
		int[] ans = new int[2];

		for (int i : nums) {
			arr[i]++;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 2) {
				// this is duplicate element
				ans[0] = i;
			}

			if (arr[i] == 0) {
				// this is missing element
				ans[1] = i;
			}
		}

		return ans;

	}

}
