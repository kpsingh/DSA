package com.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets_904 {

	public static void main(String[] args) {

		// int[] arr = { 0 };
		// int[] arr = { 0 };
		int[] arr = { 0, 1, 2, 2 };
		// int[] arr = { 0 };
		System.out.println(totalFruit(arr));

	}

	// https://leetcode.com/problems/fruit-into-baskets/solutions/2960000/fruit-into-baskets/

	public static int totalFruit(int[] fruits) {
		// We use a hash map 'basket' to store the number of each type of fruit.
		Map<Integer, Integer> map = new HashMap<>();

		int left = 0, ans = 0;

		// Add fruit from the right index (right) of the window.
		for (int right = 0; right < fruits.length; ++right) {

			map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

			// If the current window has more than 2 types of fruit,
			// we remove fruit from the left index (left) of the window,
			// until the window has only 2 types of fruit.

			while (map.size() > 2) {

				map.put(fruits[left], map.get(fruits[left]) - 1);

				if (map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}

				left++;
			}

			// Update maxPicked.
			ans = Math.max(ans, right - left + 1);
		}

		// Return maxPicked as the maximum number of fruits we can collect.
		return ans;
	}

	public static int totalFruit_MY(int[] arr) {
		if (arr.length <= 2) {
			return arr.length; // if <= 2 then that is the option
		}
		int result = 2; // if more than two then this is minimum answer can be
		int i = 0;
		int j = 0;
		Map<Integer, Integer> map = new HashMap<>();

		while (j < arr.length) {
			int key = arr[j];

			if (map.size() < 2 || map.containsKey(key)) {
				map.put(key, map.getOrDefault(key, 0) + 1);
				result = Math.max(result, j - i + 1);
				j++;
			} else {
				while (map.size() >= 2) {
					int removeKey = arr[i];
					map.put(removeKey, map.get(removeKey) - 1);
					if (map.get(removeKey) == 0) {
						{
							map.remove(removeKey);
						}
					}
					i++;
				}
			}

		}
		return result;
	}

}
