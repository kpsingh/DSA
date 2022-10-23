package com.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch_645 {

	public int[] findErrorNums(int[] nums) {

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

}
